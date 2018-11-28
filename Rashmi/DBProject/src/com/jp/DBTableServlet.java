package com.jp;

import java.beans.Statement;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/DBTableServlet")
public class DBTableServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String tableName = request.getParameter("table");
		
		try
		{  
			
			ArrayList<String> list = new ArrayList<String>();

			Class.forName("oracle.jdbc.driver.OracleDriver");  
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","hr","hr");  
			
			DatabaseMetaData meta =  con.getMetaData();
			ResultSet rs = meta.getColumns(null,  "HR", tableName, null);
			
			while (rs.next())
			{
				list.add(rs.getString("COLUMN_NAME"));
			}
			
			/*
			out.println("<table border='2'>");
			out.println("<thead><th>TABLE NAME</th><th>COLUMN NAME</th></thead>");
			
			for (int i=0; i<list.size(); i++)
			{
				out.println("<tr>");				
				out.println("<td>"+tableName+"</td>" + "<td>"+ list.get(i)+"</td>");
				out.println("</tr>");
			}
			out.println("</table><br /><br /><br />");
			*/
			
			java.sql.Statement stmt  = con.createStatement();
			ResultSet rs1 = stmt.executeQuery("select * from " + tableName);
			
						
			out.println("<table border='2'>");
			out.println("<thead>");
			
			for (int i=0; i<list.size(); i++)
			{
				out.println("<th>");				
				out.println(list.get(i));
				out.println("</th>");
			}
			out.println("</thead>");
			
			while (rs1.next())
			{
				out.println("<tr>");				
				for (int i=0; i<list.size(); i++)
				{
					out.println("<td>"+rs1.getString(list.get(i))+"</td>");
				}
				out.println("</tr>");
			}
			out.println("</table><br /><br /><br />");
			
			out.flush();
			con.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}  
		finally
        { 
			
        } 
		
	}
	
	/*protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}*/

}
