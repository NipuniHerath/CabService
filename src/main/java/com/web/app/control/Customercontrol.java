package com.web.app.control;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.web.app.model.CustomerData;

import com.web.app.service.CustomerServices;


public class Customercontrol extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String geturl=request.getParameter("geturl");
		if(geturl.equals("add")) {
			
			createaccount(request, response);
		}
		else if(geturl.equals("login")) {
			
			customerLogin(request, response);
			
		}
		
	}

	
	private void createaccount(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String msg="";
		CustomerData customer=new CustomerData();
		CustomerServices cs=new CustomerServices();
		customer.setCustomername(request.getParameter("customername"));
		customer.setCustomerstreet(request.getParameter("customerstreet"));
		customer.setCustomercity(request.getParameter("customerbranch"));
		customer.setCustomercontact(request.getParameter("contactnumber"));
		customer.setEmail(request.getParameter("email"));
		customer.setPassword(request.getParameter("password"));
		try {
			boolean getresult=cs.createaccount(customer);
			if(getresult) {
				msg="account created";
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			msg=e.getMessage();
		}
		request.setAttribute("msg", msg);
		
		RequestDispatcher rd=request.getRequestDispatcher("customeraccount.jsp");
		rd.forward(request, response);
	}
	
	public void customerLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String msg="";
		CustomerData customer=new CustomerData();
		CustomerServices cs=new CustomerServices();
		customer.setEmail(request.getParameter("email"));
		customer.setPassword(request.getParameter("password"));
		try {
			CustomerData custom=cs.login(customer);
			
			if(custom.getCustomername()==null) {
				
				msg="invalid login";
				RequestDispatcher rd=request.getRequestDispatcher("login.jsp");
				rd.forward(request, response);
			}
			
			else if(custom.getCustomername()!=null) {
				
				HttpSession session=request.getSession();
				
				session.setAttribute("name", custom.getCustomername());
				
				
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			msg=e.getMessage();
		}
		 request.setAttribute("msg", msg);
		
		  response.sendRedirect("/cab-web/vehicle?geturl=available");
		
		
	}
	
	
}
