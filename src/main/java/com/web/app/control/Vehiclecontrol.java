package com.web.app.control;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.web.app.model.BookingData;
import com.web.app.model.DriverData;
import com.web.app.model.VehicleData;
import com.web.app.service.DriverServices;
import com.web.app.service.VehicleServices;

/**
 * Servlet implementation class Vehiclecontrol
 */
public class Vehiclecontrol extends HttpServlet {
	private static final long serialVersionUID = 1L;
  int choice;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String geturl=request.getParameter("geturl");
		if(geturl.equals("all")) {
			
			viewall(request, response);
		}
		if(geturl.equals("available")) {
			viewAvailable(request, response);
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String geturl=request.getParameter("geturl");
		if(geturl.equals("add")) {
			
			add(request, response);
		}
		
		else if(geturl.equals("edit")) {
			getvehiclebyid(request, response);
			
		}
		else if(geturl.equals("update")) {
			update(request, response);
			
		}
		
		else if(geturl.equals("delete")) {
			delete(request, response);
			
		}
		else if(geturl.equals("test")) {
			btest(request, response);
			
		}
		else if(geturl.equals("booknow")) {
			booknow(request, response);
		}
		else if(geturl.equals("getdata")) {
			getdatabook(request, response);
		}
		else if(geturl.equals("getdatabook")) {
			getPendingBokk(request, response);
		}
        
	}
	private void booknow(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		String msg="";
		
		try {
			VehicleServices vs=new VehicleServices();
			
			VehicleData vehicle=new VehicleData();
			
			BookingData book=new BookingData();
			
			book.setCustomername(request.getParameter("customername"));
			
			
			book.setDrivernumber(request.getParameter("contactp"));
			book.setFromstreet(request.getParameter("fromstreet"));
			book.setFromlocation(request.getParameter("fromlocation"));
			book.setTostreet(request.getParameter("tostreet"));
			book.setTolocation(request.getParameter("tolocation"));
			book.setHours(Double.parseDouble(request.getParameter("hours")));
			book.setCoast(Double.parseDouble(request.getParameter("hours"))*Double.parseDouble(request.getParameter("coast")));
			book.setDate(request.getParameter("date"));
			book.setStatus("pending");
			boolean res=vs.bookNow(book);
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			msg=e.getMessage();
		}
		request.setAttribute("msg", msg);
		RequestDispatcher rd=request.getRequestDispatcher("vehicleupdate.jsp");
		rd.forward(request, response);
	}
	
	
	private void getdatabook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String msg="";
		try {
			VehicleServices vs=new VehicleServices();
			DriverServices ds=new DriverServices();
			VehicleData vehicle=new VehicleData();
			DriverData driverdata=new DriverData();
			BookingData book=new BookingData();
			driverdata.setDriverid(Integer.parseInt(request.getParameter("driverid")));
			DriverData getdriverdata;
			getdriverdata = ds.getBySingleID(driverdata);
			String tp=getdriverdata.getContact();
			String name=request.getParameter("customername");
			HttpSession session=request.getSession();
			session.setAttribute("drivernumb",tp);
			session.setAttribute("vehicleid", request.getParameter("vid"));
			session.setAttribute("vehicleid",name );
			session.setAttribute("coast", request.getParameter("coast"));
			
		} catch (ClassNotFoundException | SQLException e) {
			
			msg=e.getMessage();
		}
	
		RequestDispatcher rd=request.getRequestDispatcher("bookingform.jsp");
		rd.forward(request, response);
		
		//session.setAttribute("name", );
		
	}
	
	private void getPendingBokk(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String msg="";
		VehicleServices vs=new VehicleServices();
		BookingData orders=new BookingData();
		orders.setDrivernumber(request.getParameter("contact"));
		try {
			List<BookingData>book=vs.viewBookingDriver(orders);
			if(book.isEmpty()) {
				msg="No data";
			}
			request.setAttribute("data", book);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			msg=e.getMessage();
		}
		
		RequestDispatcher rd=request.getRequestDispatcher("orders.jsp");
		rd.forward(request, response);
		
	}
	private void viewall(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String msg="";
		VehicleServices vs=new VehicleServices();
		try {
			List<VehicleData>vehicledata=vs.getAll();
			if(vehicledata.isEmpty()) {
				
				msg="No Data Found";
			}
			request.setAttribute("vehicledata", vehicledata);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			msg=e.getMessage();
		}
		request.setAttribute("msg", msg);
		
		RequestDispatcher rd=request.getRequestDispatcher("vehicleall.jsp");
		rd.forward(request, response);
	}
	
	private void getvehiclebyid(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String msg="";
		VehicleServices vs=new VehicleServices();
		VehicleData vehicle=new VehicleData();
		vehicle.setId(Integer.parseInt(request.getParameter("id")));
		try {
			List<VehicleData>data=vs.getByID(vehicle);
			if(data.isEmpty()) { 
				msg="No data";
			
			}
			request.setAttribute("data", data);
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			msg=e.getMessage();
		}
		request.setAttribute("msg", msg);
		
		RequestDispatcher rd=request.getRequestDispatcher("vehicleupdate.jsp");
		rd.forward(request, response);
	}
	
	
	private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String msg="";
		VehicleServices vs=new VehicleServices();
		VehicleData data=new VehicleData();
		data.setVehiclemodle(request.getParameter("model"));
	    data.setCoastperhour(Double.parseDouble(request.getParameter("coastperhour")));
		data.setVehiclebranch(request.getParameter("vehiclebranch"));
		data.setVehiclecatergory(request.getParameter("catog"));
		data.setDriverid(Integer.parseInt(request.getParameter("driverid")));
		data.setAvailability("yes");
		
		boolean getresult;
		try {
			getresult = vs.addvehicle(data);
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
	
	private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String msg="";
		VehicleServices vs=new VehicleServices();
		VehicleData data=new VehicleData();
		data.setAvailability("yes");
		data.setVehiclemodle(request.getParameter("model"));
		data.setVehiclecatergory(request.getParameter("catog"));
		data.setCoastperhour(Double.parseDouble(request.getParameter("coastperhour")));
		data.setId(Integer.parseInt(request.getParameter("vid")));
		data.setVehiclebranch(request.getParameter("vehiclebranch"));
		data.setDriverid(Integer.parseInt(request.getParameter("driverid")));
		try {
			boolean resultdata=vs.updatevehicle(data);
			if(resultdata) {
				msg="Update Success";
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			
			 msg=e.getMessage();
		}
		request.setAttribute("msg", msg);
		response.sendRedirect("/cab-web/vehicle?geturl=all");
		
	}
	private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String msg="";
		VehicleServices vs=new VehicleServices();
		VehicleData data=new VehicleData();
		
		data.setId(Integer.parseInt(request.getParameter("id")));
		try {
			boolean resultdata=vs.delete(data);
			if(resultdata==true) {
				msg="Delete Success";
			}
			
			
		} catch (ClassNotFoundException | SQLException e) {
			
			 msg=e.getMessage();
		}
		request.setAttribute("msg", msg);
		response.sendRedirect("/cab-web/vehicle?geturl=all");
		
	}
	
 private void viewAvailable(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String msg="";
	VehicleServices vs=new VehicleServices();
	try {
		List<VehicleData> data=vs.bookingvehicle();
		if(data.isEmpty()) {
			msg="No data found";
		}
		request.setAttribute("available",data );
	} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		 msg=e.getMessage();
	}
	
	request.setAttribute("msg", msg);
	
	RequestDispatcher rd=request.getRequestDispatcher("vehiclebooking.jsp");
	rd.forward(request, response);
	 
	 
 }
	
 private void btest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 	String msg="";
		VehicleServices vs=new VehicleServices();
		DriverServices ds=new DriverServices();
		VehicleData vehicle=new VehicleData();
		DriverData dr=new DriverData();
		dr.setDriverid(Integer.parseInt(request.getParameter("driverid")));
		vehicle.setId(Integer.parseInt(request.getParameter("id")));
		try {
			List<VehicleData>data=vs.getByID(vehicle);
			List<DriverData>sr=ds.viewbyID(dr);
			
			if(data.isEmpty()) { 
				msg="No data";
			
			}
			request.setAttribute("data", data);
			request.setAttribute("driverdata", sr);
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			msg=e.getMessage();
		}
		request.setAttribute("msg", msg);
		
		RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
		rd.forward(request, response);
	
		
 }
 
}
