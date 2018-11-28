package com.jp.config.servlets;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * 	Declaring context parameters through Annotations.
 * 		They are to be declared at Filter or Listener.
 * 
 * 	Declaring config parameters:
 * 		Can be declared in SML as well as initParam in @WebServlet.
 */




@WebServlet(urlPatterns={"/process2","/process1"}, 
initParams={@WebInitParam(name="pageHead", value="Employee List"), @WebInitParam(name="footHead", value="Contact Details")})  //Commented this line since we wanted to see configuration through XML.
public class Process1 extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Within Servlet");
		
		ServletContext ctx = super.getServletContext();
		System.out.println(ctx.getInitParameter("CompanyName"));
		
		ServletConfig cfg = super.getServletConfig();
		System.out.println(cfg.getInitParameter("pageHead"));
		System.out.println(cfg.getInitParameter("footHead"));
	}

}
