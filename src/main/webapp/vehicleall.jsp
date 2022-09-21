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

<table class="table">
  <thead>
  
    <tr>
      
      <th scope="col">ID</th>
       <th scope="col">Model</th>
      <th scope="col">Payment</th>
      <th scope="col">Driver</th>
      <th scope="col">Branch</th>
      <th scope="col">Category</th>
       <th scope="col">Availability</th>
        <th scope="col" colspan="2" >Action</th>
    </tr>
  </thead>
  <tbody>
   
<c:forEach var="vehicle" items="${vehicledata}">
    <tr>
     
      <td>${vehicle.getId()}</td>
      <td>${vehicle.getVehiclemodle()}</td>
      <td>${vehicle.getCoastperhour()}</td>
       <td>${vehicle.getDriverid()}</td>
       <td>${vehicle.getVehiclebranch()}</td>
       <td>${vehicle.getVehiclecatergory()}</td>
       <td>${vehicle.getAvailability()}</td>
       <td>
       <form action="vehicle" method="post">
       <input type="hidden" name="id" value="${vehicle.getId()}">
       <input type="hidden" name="geturl" value="edit">
       <button class="btn btn-primary">EDIT</button>
       
       </form></td>
       <td>
       <form action="vehicle" method="post">
       <input type="hidden" name="id" value="${vehicle.getId()}">
       <input type="hidden" name="geturl" value="delete">
       <button class="btn btn-danger">DELTE</button>
       </form></td>
    </tr>
 </c:forEach>
  </tbody>
</table>

</div>
</body>
</html>