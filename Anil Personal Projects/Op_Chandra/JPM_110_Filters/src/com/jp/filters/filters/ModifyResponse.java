package com.jp.filters.filters;

import java.io.IOException;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;


@WebFilter(dispatcherTypes = { DispatcherType.REQUEST }, urlPatterns = { "*.do" })
public class ModifyResponse implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
    	// Before part
		System.out.println("In before part of filter-MR");
		RequestDispatcher dispatch = request.getRequestDispatcher("/WEB-INF/jsps/Head.jsp");
		dispatch.include(request, response);

    		chain.doFilter(request, response);

    	// After part
		System.out.println("In after part of filter-MR");
		RequestDispatcher dispatch1 = request.getRequestDispatcher("/WEB-INF/jsps/Footer.jsp");
		dispatch1.include(request, response);
    	}

	public void init(FilterConfig fConfig) throws ServletException {
		//Life cycle method for filter to do initialization
		System.out.println("In filters-MR init()");
	}
	
	public void destroy() {
		System.out.println("In filter-MR destroy()");
		
	}
}