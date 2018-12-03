package com.jp.shopping.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jp.shopping.entities.Item;
import com.jp.shopping.entities.Order;
import com.jp.shopping.excptions.ShoppingExceptions;
import com.jp.shopping.services.ServiceItem;
import com.jp.shopping.services.ServiceItemImpl;


@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ServiceItem services;

	@Override
	public void init() throws ServletException {
		try {
			services = new ServiceItemImpl();
		} catch (ShoppingExceptions e) {
			throw new ServletException("Init method failed.", e);
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String command = getCommand(request.getRequestURI());
		RequestDispatcher dispatch = null;
		String jspName = null;
		String preFix = "/WEB-INF/jsps/";
		String postFix = ".jsp";

		try {
			switch (command) {
			case "*":
			case "home": {
				jspName = "Home";
				break;
			}
			case "login": {
				jspName = "Login";
				break;
			}
			case "authenticate": {
				String userName = request.getParameter("username");
				String password = request.getParameter("password");

				if (userName.equals("a") && password.equals("a")) {
					String userFullName = "aaaaa aaaa aaaa";
					HttpSession session = request.getSession();
					session.setAttribute("userFullName", userFullName);
					jspName = "MainMenu";

				} else {
					String msg = "Wrong credentials. Pls enter again";
					request.setAttribute("message", msg);
					jspName = "Login";
				}

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
			case "itemList": {
				ArrayList<Item> itemList = services.getItemList();
				request.setAttribute("itemList", itemList);
				jspName = "ItemList";
				break;
			}
			case "itemDetails": {
				String idStr = request.getParameter("itemId");
				int itemId = Integer.parseInt(idStr);
				Item itm = services.getItemDetails(itemId);
				request.setAttribute("itemDetails", itm);
				jspName = "itemDetails";
				break;
			}

			case "addToCart": {
				String custId = request.getParameter("customerId");
				int cId = Integer.parseInt(custId);
				String ordId = request.getParameter("orderId");
				int oId = Integer.parseInt(ordId);
				String itmId = request.getParameter("itemId");
				int iId = Integer.parseInt(itmId);
				Order ord = new Order(cId, oId, iId);
				boolean isSuccessfull = services.addToCart(ord);
				String msg = isSuccessfull ? "Item Added to Cart." : "Insertion Failed";
				request.setAttribute("message", msg);
				jspName = "addToCart";
				break;
			}
			}
		} catch (ShoppingExceptions e) {
			throw new ServletException(e);
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

		if (leftPosi == -1 || rtPosi == -1) {
			return "home";
		} else {
			return uri.substring(leftPosi + 1, rtPosi);
		}
	}

}
