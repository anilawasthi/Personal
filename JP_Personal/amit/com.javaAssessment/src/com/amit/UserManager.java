package com.amit;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

import static com.amit.IllegalCredentialsException.MAX_UserName;
import static com.amit.IllegalCredentialsException.MIN_UserName;

public class UserManager {

    //Create “UserManager” class with list of following users:
    //add(User u), find(String name), getAll()

    String usernameM;
    String passwordM;
    String roleM;
    boolean activeM;


    static ArrayList<userDetails> userList = new ArrayList<>();

    public void add(userDetails usr){

        userList.add(usr);

    }

    public List<userDetails> findByUserId(String uName) {
        List<userDetails> temp = null;

        if (!userList.isEmpty()){
            temp = new ArrayList<>();
            for(userDetails b : userList){

                if(b.getUserId().toLowerCase().contains(uName.toLowerCase())){
                    temp.add(b);
                }
            }

        }
        else{
            System.out.println("No Record found");

        }
        return temp;

    }

    public void ListAll() {

        try {

            for (userDetails e : userList) {

                System.out.println(e);
            }
        } catch (Exception e) {

            System.out.println(e.getMessage());
        }
    }

    public String validateUserId(String vuserid) {
        String uFlag ="True";

        String rruser = vuserid;

        try {

    //Username must contain at least 6 and maximum 12 characters
            if ((rruser.length() < MIN_UserName) || (rruser.length() > MAX_UserName)) {

                uFlag = "False";
                //Incase of any of these rules are violated, raise “IllegalCredentialException”
                throw new IllegalCredentialsException();
            }

            if (rruser.isEmpty()) {

                uFlag = "False";
                //Incase of any of these rules are violated, raise “IllegalCredentialException”
                throw new IllegalCredentialsException();
            }

            if (uFlag.equalsIgnoreCase("True")){

                uFlag="False";
                for (userDetails e : userList) {

                        if (e.getUserId().equalsIgnoreCase(rruser)){

                            uFlag="True";

                        }

                }

            }


        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        return uFlag;
    }


    public String validatePass(String vpass){

        String pFlag =  "True";
        String SpIntFlag="False";
        String SpCharFlag="False";

        String rpass = vpass;
        try {
            //Password must be minimum 8 characters long
            if ((rpass.length() < 8)) {

                pFlag = "False";
                //Incase of any of these rules are violated, raise “IllegalCredentialException”
                throw new IllegalCredentialsException();
            }


            //Password must contain at least ONE digit and ONE special character
            if (pFlag.equalsIgnoreCase("true")){
                pFlag="False";

                String[] sp = {"~","!","@","#","$","%","^","&","*","(",")","-","_","<",">","?","/"};

                for (int i=0; i<sp.length;i++){

                    if (rpass.contains(sp[i])){
                        SpCharFlag="True";
                       // System.out.println("special validate");
                        break;
                    }
                }

                //Password must contain at least ONE digit and ONE special character
                String [] nos = {"1","2","3","4","5","6","7","8","9","0"};

                for (int j=0; j<nos.length;j++){

                    if (rpass.contains(nos[j])){
                        SpIntFlag="True";
                        //System.out.println("nos validate");
                        break;
                    }
                }

            }

            if ((SpIntFlag.equalsIgnoreCase("True")) && (SpCharFlag.equalsIgnoreCase("True"))){
                pFlag="True";
            }else
            {
                pFlag="False";
                //Incase of any of these rules are violated, raise “IllegalCredentialException”
                throw new IllegalCredentialsException();
            }

            if (pFlag.equalsIgnoreCase("true")){
                pFlag="False";

                for (userDetails e : userList) {
                    if (e.getPassword().equalsIgnoreCase(rpass)){
                        pFlag="True";

                    }
                }

            }
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return pFlag;
    }


}
