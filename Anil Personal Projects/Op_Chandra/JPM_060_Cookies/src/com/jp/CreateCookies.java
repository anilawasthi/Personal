/*
 * package com.jp;
 * 
 * import java.io.IOException; import java.net.URLEncoder;
 * 
 * import javax.servlet.ServletException; import
 * javax.servlet.annotation.WebServlet; import javax.servlet.http.Cookie; import
 * javax.servlet.http.HttpServlet; import javax.servlet.http.HttpServletRequest;
 * import javax.servlet.http.HttpServletResponse;
 * 
 * 
 * @WebServlet("/createCookies") public class CreateCookies extends HttpServlet
 * { private static final long serialVersionUID = 1L;
 * 
 * 
 * protected void doGet(HttpServletRequest request, HttpServletResponse
 * response) throws ServletException, IOException { Cookie cookie1 = new
 * Cookie("c1", Itsapersistentcookie")); Cookie cookie2 = new Cookie("c2",
 * "Itsapersistentcookie");
 * 
 * cookie2.setMaxAge(120); // In seconds
 * 
 * response.addCookie(cookie1); response.addCookie(cookie2);
 * 
 * response.sendRedirect("showCookies"); }
 * 
 * }
 */