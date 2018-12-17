package com.jpm.learning.webservice;

import javax.jws.WebService;

/**
 * The @WebService property endpointInterface links the SIB (this class) to the
 * SEI (com.cg.learning.webservice). Note that the method implementations are
 * not annotated as @WebMethods.
 */
@WebService(endpointInterface = "com.jpm.learning.webservice.CalculatorServer")
public class Calculator {

	public int addition(int param1, int param2) {
		System.out.println("In addition()");
		return param1 + param2;
	}

	public int subtraction(int param1, int param2) {
		System.out.println("In subtraction()");
		return param1 - param2;
	}

	public int multiplication(int param1, int param2) {
		System.out.println("In multiplication()");
		return param1 * param2;
	}

	public int division(int param1, int param2) {
		System.out.println("In division()");
		return param1 / param2;
	}

	public int modulus(int param1, int param2) {
		System.out.println("In modulus()");
		return param1 % param2;
	}
}
