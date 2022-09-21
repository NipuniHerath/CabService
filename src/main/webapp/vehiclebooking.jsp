<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core"%> 
  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1" charset=UTF-8>
<link href="https://unpkg.com/bootstrap@5.0.0/dist/css/bootstrap.min.css" rel="stylesheet">
<title>View Products</title>
</head>
<body>



<div class="container">
 <nav class="navbar navbar-dark bg-dark">
    <div class="container-fluid">
    <a class="navbar-brand" href="add-product.jsp">Home</a>
    <a class="navbar-brand" href="add-product.jsp">Insert Product</a>
    <a class="navbar-brand" href="/mobile-product/getProducts?action=all">View Products</a>
   
 
  </div>
  </nav>
  
</div><br><br>

 
<div class="container" >
<h4>${msg}</h4>
<h3>Hello <%= session.getAttribute("name") %></h3>


<table class="table">
  <thead>
  
    <tr>
      
      
       <th scope="col">Model</th>
      <th scope="col">Payment</th>
      <th scope="col">Branch</th>
      <th scope="col">Category</th>
      <th scope="col" >Booking</th>
    </tr>
  </thead>
  <tbody>
   
<c:forEach var="vehicle" items="${available}">
    <tr>
     
    
      <td>${vehicle.getVehiclemodle()}</td>
      <td>${vehicle.getCoastperhour()}</td>
       <td>${vehicle.getVehiclebranch()}</td>
       <td>${vehicle.getVehiclecatergory()}</td>
       
       
       <td>
       <form action="vehicle" method="post">
       <input type="hidden" name="vid" value="${vehicle.getId()}">
       <input type="hidden" name="driverid" value="${vehicle.getDriverid()}">
       <input type="hidden" name="coast" value="${vehicle.getCoastperhour()}">
       <input type="hidden" name="customername" value="<%= session.getAttribute("name") %>">
       <input type="hidden" name="geturl" value="getdata">
       <button class="btn btn-success">Book Now</button>
       </form></td>
    </tr>
 </c:forEach>
  </tbody>
</table>

</div>
</body>
</html>