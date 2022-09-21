package com.web.app.control;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.app.model.DriverData;
import com.web.app.model.VehicleData;
import com.web.app.service.DriverServices;
import com.web.app.service.VehicleServices;

/**
 * Servlet implementation class Drivercontrol
 */
public class Drivercontrol extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String geturl=request.getParameter("geturl");;
		if(geturl.equals("viewall")) {
			
			viewAll(request, response,"driverview");
		}
		
		else if(geturl.equals("driverview")) {
			
			viewAll(request, response,"driverview");
			
		}
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String geturl=request.getParameter("geturl");;
		if(geturl.equals("add")) {
			createDriver(request, response);
		}
	else if(geturl.equals("edit")) {
			
			viewdriverbyid(request, response,"driverview");
		}
		
	else if(geturl.equals("update")) {
		update(request, response);
	}
		
		
	}

	
	private void viewAll(HttpServletRequest request, HttpServletResponse response,String page) throws ServletException, IOException {
		String msg="";
		DriverServices ds=new DriverServices();
		
		try {
			List<DriverData> drivers=ds.viewAll();
			if(drivers.isEmpty()) {msg="No drivers Found";}request.setAttribute("drivers",drivers);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			msg=e.getMessage();
		}
		
		request.setAttribute("msg", msg);
		
		RequestDispatcher rd=request.getRequestDispatcher(page+".jsp");
		rd.forward(request, response);
	}
	
	private void viewdriverbyid(HttpServletRequest request, HttpServletResponse response,String page) throws ServletException, IOException {
		
		String msg="";
		DriverServices ds=new DriverServices();
		DriverData driver=new DriverData();
		driver.setDriverid(Integer.parseInt(request.getParameter("id")));
		try {
			List<DriverData>data=ds.viewbyID(driver);
			if(data.isEmpty()) { 
				msg="No data";
			
			}
			request.setAttribute("data", data);
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			msg=e.getMessage();
		}
		request.setAttribute("msg", msg);
		
		RequestDispatcher rd=request.getRequestDispatcher("driverupdate.jsp");
		rd.forward(request, response);
		
	}
	
	private void update(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String msg="";
		DriverData data=new DriverData();
		DriverServices ds=new DriverServices();
		data.setDrivername(request.getParameter("drivername"));
		data.setDriverbranch(request.getParameter("driverbranch"));
		data.setDriverid(Integer.parseInt(request.getParameter("vid")));
		data.setContact(request.getParameter("contactnumber"));
		try {
			boolean getresult=ds.update(data);
			if(getresult) {
				msg="Updated";
				
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			msg=e.getMessage();
		}
		request.setAttribute("msg", msg);
		response.sendRedirect("/cab-web/driver?geturl=viewall");
		
		
	}
	
	private void createDriver(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String msg="";
		DriverData data=new DriverData();
		DriverServices ds=new DriverServices();
		data.setDrivername(request.getParameter("drivername"));
		data.setDriverbranch(request.getParameter("driverbranch"));
		data.setContact(request.getParameter("contactnumber"));
		try {
			boolean getresult=ds.add(data);
			if(getresult) {
				
				
				msg="Added data";
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			msg=e.getMessage();
		}
		
		request.setAttribute("msg", msg);
		
		RequestDispatcher rd=request.getRequestDispatcher("driveradd.jsp");
		rd.forward(request, response);
	}
}
