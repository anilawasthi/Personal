package com.jp.products.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jp.products.daos.DaoAuthenticationImpl;
import com.jp.products.entities.Products;
import com.jp.products.entities.User;
import com.jp.products.exceptions.ProductsException;
import com.jp.products.exceptions.UserException;
import com.jp.products.services.ServiceProducts;
import com.jp.products.services.ServiceProductsImpl;

@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ServiceProducts services;
	private DaoAuthenticationImpl service1;

	@Override
    public void init() throws ServletException{
		try {
			services = new ServiceProductsImpl();
		} catch (ProductsException e) {
			throw new ServletException("Init method failed.", e);
		}
    }

	public void String() throws ServletException, UserException {
		try {
			service1 = new DaoAuthenticationImpl();
		} catch (ProductsException e) {
			e.printStackTrace();
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String command = getCommand(request.getRequestURI());
		RequestDispatcher dispatch = null;
		String jspName = null;
		String preFix = "/WEB-INF/jsps/";
		String postFix = ".jsp";
		try{
			switch(command){
			case "*":
			case "home": {
				jspName = "Home";
				break;
			}
			case "login": {
				jspName = "Login";
				break;
			}
			case "UserDetails": {
				ArrayList<User> UserDetails = service1.getUserDetails();
				System.out.println(UserDetails);
				request.setAttribute("UserDetails", UserDetails);
				jspName = "ProductList";

				// String userName = request.getParameter("username");
				// String password = request.getParameter("password");
				//
				// if (userName.equals("a") && password.equals("a")) {
				// String userFullName = "XXXX XXXX";
				// HttpSession session = request.getSession();
				// session.setAttribute("userFullName", userFullName);
				// jspName = "MainMenu";
				// } else {
				// String msg = "Wrong credentials. Please enter again";
				// request.setAttribute("message", msg);
				// jspName = "Login";
				// }
				break;
			}
			case "logout": {
				HttpSession session = request.getSession();
				request.setAttribute("userFullName", session.getAttribute("userFullName"));
				session.invalidate();
				jspName = "ThanksPage";
				break;
			}
			case "mainMenu": {
				jspName = "MainMenu";
				break;
			}
			case "productList":{
				ArrayList<Products> productList = services.getproductList();
				System.out.println(productList);
				request.setAttribute("productList", productList);
				jspName = "ProductList";
				break;
			}
			case "productDetails": {
				String idStr = request.getParameter("prodId");
				int prodId = Integer.parseInt(idStr);
				Products prd = services.getProdDetails(prodId);
				request.setAttribute("prdDetails", prd);
				System.out.println(prd);
				jspName = "ProductDetails";
				break;
			}
			case "newProduct": {
				jspName = "NewProduct";
				break;
			}
			case "submitProduct": {
				String prdIdStr = request.getParameter("prodId");
				String prdName = request.getParameter("prdName");
				String prdCat = request.getParameter("prdCat");
				String prdPrcStr = request.getParameter("prdPrc");
				int prodId = Integer.parseInt(prdIdStr);
				double prdPrc = Double.parseDouble(prdPrcStr);
				Products prod = new Products(prodId, prdName, prdCat, prdPrc);
				boolean isSuccessfull = services.addNewProduct(prod);
				String msg = isSuccessfull ? "Product Inserted" : "Insertion Failed";
				request.setAttribute("Message", msg);
				jspName = "NewProduct";
				break;
			}
			}
		} catch (ProductsException e) {
				e.printStackTrace();
			}
		dispatch = request.getRequestDispatcher(preFix + jspName + postFix);
		dispatch.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	private String getCommand(String uri) {
		int leftPosi = uri.lastIndexOf("/");
		int rtPosi = uri.lastIndexOf(".");
		/*return uri.substring(leftPosi + 1, rtPosi);*/
		if (leftPosi == -1 || rtPosi == -1) {
			return "MainMenu";
		} else 
			return uri.substring(leftPosi + 1, rtPosi);
	}

}
