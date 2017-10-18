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
import com.domain.Borrower;
import com.service.BorrowerService;

/**
 * Servlet implementation class EmployeeServlet
 */
@WebServlet("/BorrowerServlet")
public class BorrowerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BorrowerServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Borrower Servlet request");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		RequestDispatcher rd = request.getRequestDispatcher("login.html");
		HttpSession session = request.getSession(false);
		String cardNO = null;
		
		if(session == null) {			 
			rd.forward(request, response);
		}

		if (session != null) {
			cardNO = (String)session.getAttribute("cardNO");
			//out.println("userName : "+userName);
			out.println("</br>");
		}
		BorrowerService bService = new BorrowerService();
		Borrower b = bService.getBorrower(cardNO);
		System.out.println("Borrower " + b.getName() +" request on server");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}












//BorrowerService bService = new BorrowerService();
//for(Borrower b : bService.getEmpList()) {
//	out.println(b.getFname()+","+b.getLname()+","+b.getSalary());
//	out.println("</br>");