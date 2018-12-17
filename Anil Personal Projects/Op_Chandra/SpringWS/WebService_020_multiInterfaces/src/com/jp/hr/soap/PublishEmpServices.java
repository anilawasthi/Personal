package com.jp.hr.soap;

import javax.xml.ws.Endpoint;

// http://localhost:9898/viewhr?wsdl
// http://localhost:9898/updatehr?wsdl

public class PublishEmpServices {

	public static void main(String[] args) {
		try {
			EmpSoapServicesViewImpl viewServices = new EmpSoapServicesViewImpl();
			Endpoint.publish("http://localhost:9898/viewHr", viewServices);
			
			EmpSoapServicesViewImpl updateServices = new EmpSoapServicesViewImpl();
			Endpoint.publish("http://localhost:9898/updateHr", updateServices);
			
			System.out.println("Services started.");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
