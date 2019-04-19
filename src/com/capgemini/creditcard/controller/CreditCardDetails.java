package com.capgemini.creditcard.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/addDetails.do")
public class CreditCardDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public CreditCardDetails() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		String path = request.getServletPath();
		if(path.equals("/addDetails.do")) {
			String cardHolderName = request.getParameter("cardHolderName");
			long cardNumber = Long.parseLong(request.getParameter("cardNumber"));
			String cardType = request.getParameter("cardType");
			double amountLimit = Double.parseDouble(request.getParameter("amountLimit"));
			RequestDispatcher dispatcher = request.getRequestDispatcher("creditCardDisplay.jsp");
			request.setAttribute("name", cardHolderName);
			request.setAttribute("number",cardNumber);
			request.setAttribute("type",cardType);
			request.setAttribute("amount",amountLimit);
			dispatcher.forward(request, response);
		}
	}

}
