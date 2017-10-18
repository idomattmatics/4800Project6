package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Login Servlet request");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String cardNO = request.getParameter("cardNO");
		String password = request.getParameter("password");
		
		System.out.println("cardNO and password set");
		
		RequestDispatcher rd = request.getRequestDispatcher("login.html");
		RequestDispatcher rd_success = request.getRequestDispatcher("BorrowerServlet");
		System.out.println("Borrower Servlet session");
		HttpSession session = request.getSession();

		//System.out.println("username :"+userName);
		
		if (cardNO.equals("kachar")) {
			if(password.equals("005929907")) {
				session.setAttribute("cardNO", cardNO);
				out.println("login success");
				rd_success.forward(request, response);
			}
			else {
				session.invalidate();
				out.println("password incorrect");
				//response.sendRedirect("login.html");
				rd.include(request, response);
			}
		}
		else
			out.println("username invalid");
	}
}
