package com.jp.hr.client;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import com.jp.hr.entities.Employee;
import com.jp.hr.exceptions.HrException;
import com.jp.hr.interfaces.EmpSoapServices;

public class ProcessData {
	
	public static void main(String[] args) {
		try {
			URL url = new URL("http://localhost:9898/hr?wsdl");

			// Qualified name of the service:
			// 1st arg is the service URI
			// 2nd is the service name published in the WSDL
			QName qname = new QName("http://soap.hr.jp.com/",
					"EmpSoapServicesImplService");

			// Create, in effect, a factory for the service.
			Service service = Service.create(url, qname);

			// Extract the endpoint interface, the service "port".
			EmpSoapServices soapServices = service.getPort(EmpSoapServices.class);
			
//			System.out.println(soapServices.getTestInteger(10));
//			
//			Employee emp = soapServices.getEmpDetails(101);
//			System.out.println(emp);
			
			/*ArrayList<Employee> empList = soapServices.getEmpList();
			for(Employee emp : empList) {
				System.out.println(emp);
			}*/
			
			Employee emp = new Employee(12, "aaaa", "bbbb");
			soapServices.addNewEmployee(emp);
			
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (HrException e) {
			e.printStackTrace();
		}
	}

}
