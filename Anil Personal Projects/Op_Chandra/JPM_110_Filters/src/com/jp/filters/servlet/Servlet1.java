package com.jp.filters.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns = "/servlet1.do", loadOnStartup = 1)
public class Servlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;



	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("In servlet");
		RequestDispatcher dispatch = request.getRequestDispatcher("/WEB-INF/jsps/MyJSP1.jsp");
		dispatch.include(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	@Override
	public void destroy() {
		System.out.println("In destroy of servlet1");
		super.destroy();

	}

	@Override
	public void init() throws ServletException {
		System.out.println("In init of servlet1");
		super.init();
	}

}
