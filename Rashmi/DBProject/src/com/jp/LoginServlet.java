package com.jp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.sql.rowset.*;
import java.sql.*;
import java.*;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
		
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName = request.getParameter("txtName");
		String password = request.getParameter("txtPassword");
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		int count = 0; 
		
		try{  
			Class.forName("oracle.jdbc.driver.OracleDriver");  
			  
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","hr","hr");  
			  
			PreparedStatement stmt=con.prepareStatement("select count(*) from employees where upper(first_name) = ? and upper(last_name) = ?");  
			stmt.setString(1,userName.toUpperCase());//1 specifies the first parameter in the query  
			stmt.setString(2,password.toUpperCase());  
			  
			ResultSet rs = stmt.executeQuery();
			rs.next();
			count = rs.getInt(1);
			con.close();
			  
			}
		catch(Exception e){ System.out.println(e);}  
		finally
        { 
			
        } 
			
		if (count > 0)
		{
			response.sendRedirect("DBTablesServlet");
		}
		else
			out.write("<h1>InValid user</h1>");
					
		out.flush();
		
	}

}
