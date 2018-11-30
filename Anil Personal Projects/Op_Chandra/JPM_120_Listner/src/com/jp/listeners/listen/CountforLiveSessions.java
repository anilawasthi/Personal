package com.jp.listeners.listen;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;


@WebListener
public class CountforLiveSessions implements HttpSessionListener {

    public CountforLiveSessions() {
		System.out.println("Listner created.");
    }


    public void sessionCreated(HttpSessionEvent arg0)  { 
		System.out.println("Session created.");
		// HttpSession session = arg0.getSession();
		// session.setAttribute("cart", arg1);
    }


    public void sessionDestroyed(HttpSessionEvent arg0)  { 
		System.out.println("Listner destroyed.");
    }
	
}
