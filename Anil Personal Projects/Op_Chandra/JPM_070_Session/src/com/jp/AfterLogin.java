package com.jp;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/*
 * Cookie: JSESSIONID.
 * URL rewriting.
 * Hidden Field.
 */

@WebServlet("/afterLogin")
public class AfterLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Create a session.
		// Below line Creates a session if not existing.
		HttpSession session = request.getSession();
		System.out.println("From After login" + session.getId());

		RequestDispatcher dispatch = request.getRequestDispatcher("/WEB-INF/jsps/MainMenu.jsp");
		dispatch.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
