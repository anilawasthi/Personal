package com.jp.fin.test;

import com.jp.fin.exceptions.FinException;
import com.jp.fin.locator.LocateServices;
import com.jp.hr.exceptions.HrException;
import com.jp.hr.viewInterfaces.EmpSoapServicesView;

public class TestFinServices {

	public static void main(String[] args) {
		
		try {
			EmpSoapServicesView soapServices = LocateServices.getEmpServices();
			System.out.println(soapServices.getEmpDetails(10));
			System.out.println(soapServices.getEmpList());
		} catch (HrException e) {
			e.printStackTrace();
		}
		catch (FinException e) {
			e.printStackTrace();
		}


	}

}
