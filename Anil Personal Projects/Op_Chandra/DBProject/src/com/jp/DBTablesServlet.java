package com.jp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/DBTablesServlet")
public class DBTablesServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	
	try {
		PrintWriter out = response.getWriter();
		Class.forName("oracle.jdbc.OracleDriver");
	
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/ORCL","hr","hr");
		DatabaseMetaData dmd = conn.getMetaData();
		ResultSet res = dmd.getTables(null,null, null, new String[]{"TABLE"});
		
		
		while(res.next())
		{
			String str = res.getString(3);
			out.println("<A href='DBTableOutputServlet?tablename="+str+"'>"+str+"</A><br/>");
		}
		
			
		
	}
	catch (SQLException e) {
		e.printStackTrace();
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}

	