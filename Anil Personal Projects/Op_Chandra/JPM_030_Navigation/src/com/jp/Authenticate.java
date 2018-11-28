package com.jp;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/authenticate")
public class Authenticate extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("In servlet");
		String userName = request.getParameter("username"); // These are being used from Login.jsp page
		String password = request.getParameter("password"); // These are being used from Login.jsp page
		
		RequestDispatcher dispatch = null;
			
			
			if(userName.equals("a") && password.equals("b")){
				dispatch = request.getRequestDispatcher("/WEB-INF/jsps/MainMenu.jsp");
			}
			else{
				String message = "Wrong username/password. Pls enter again";
				request.setAttribute("msg", message); //This message is being referred in Login.jsp page.
				dispatch = request.getRequestDispatcher("/WEB-INF/jsps/Login.jsp");
			}
				dispatch.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}