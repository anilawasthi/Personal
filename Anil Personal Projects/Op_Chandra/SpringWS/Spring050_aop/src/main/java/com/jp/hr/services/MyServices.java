package com.jp.hr.services;

public class MyServices {

	// Below methods are Join Points abcMethod1, abcMethod2, abcMethod3
	public void abcMethod1(){
		System.out.println("\tIn abcMethod1()");
	}
	
	public void abcMethod2(int x){
		System.out.println("\tIn abcMethod2(int x)");
	}
	
	public void abcMethod3(int x, int y) {
		System.out.println("In abcMethod3(int x, int y)");
	}
	
}
