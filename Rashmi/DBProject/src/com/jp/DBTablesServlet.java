package com.jp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/DBTablesServlet")
public class DBTablesServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		try
		{  
			String table[] = { "TABLE" };
			ArrayList<String> list = new ArrayList<String>();

			Class.forName("oracle.jdbc.driver.OracleDriver");  
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","hr","hr");  
			
			DatabaseMetaData meta =  con.getMetaData();
			ResultSet rs = meta.getTables(null, "HR", null, table);
			
			while (rs.next())
			{
				list.add(rs.getString(3));
			}
			con.close();
			
			for (int i=0; i<list.size(); i++)
			{
				out.println("<a href='DBTableServlet?table="+list.get(i)+"'>"+list.get(i)+"</a>"+"<br />");
			}
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
