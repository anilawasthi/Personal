package com.bypass;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//http://localhost:8080/ProjectName/*.do?page=Welcome
@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pg = request.getParameter("pg");
		RequestDispatcher dispatch = null;
		switch (pg) {
		case "Welcome": {
			Cookie[] cookies = request.getCookies();
			dispatch = request.getRequestDispatcher("/WEB-INF/jsps/Welcome.jsp");
			/* for loop for the below created cookie */
			for (Cookie cookie : cookies) {
				if (cookie.getName()
						.equals("bypassPage")) {
					dispatch = request.getRequestDispatcher("/WEB-INF/jsps/MainMenu.jsp");
					break;
				}
			}

			dispatch.forward(request, response);
			break;
		}
		case "Menu": {

			String isBoxChecked = request.getParameter("ToBypass");
			if (isBoxChecked!=null) {
				/* new name given to cookie below bypassPage */
				Cookie c = new Cookie("bypassPage", "");

						c.setMaxAge(60*60*48);
						response.addCookie(c);
			}
			dispatch = request.getRequestDispatcher("/WEB-INF/jsps/MainMenu.jsp");
			dispatch.forward(request, response);
			break;
		}
		}

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
