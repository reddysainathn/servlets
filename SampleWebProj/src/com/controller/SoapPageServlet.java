package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.vo.ShopCart;

/**
 * Servlet implementation class SoapPageServlet
 */
@WebServlet("/soapPage")
public class SoapPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SoapPageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String item4 = request.getParameter("item4");
		String item5 = request.getParameter("item5");
		String item6 = request.getParameter("item6");
		
		HttpSession session = request.getSession();
		
		ShopCart cart = (ShopCart) session.getAttribute("cart");
		session.setAttribute("count", cart.getItemList().size());
		if (item4 != null) {
			cart.getItemList().add(item4);
		}
		if (item5 != null) {
			cart.getItemList().add(item5);
		}
		if (item6 != null) {

			cart.getItemList().add(item6);
		}
		
		
/*
		if (item4 != null) {

			Cookie cookie4 = new Cookie("item4", item4);
			response.addCookie(cookie4);

		}
		if (item5 != null) {

			Cookie cookie5 = new Cookie("item5", item5);
			response.addCookie(cookie5);

		}
		if (item6 != null) {

			Cookie cookie6 = new Cookie("item6", item6);
			response.addCookie(cookie6);

		}*/

		RequestDispatcher requestDispacher = request.getRequestDispatcher("clothes.jsp");
		requestDispacher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
