<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core"%> 
  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1" charset=UTF-8>
<link href="https://unpkg.com/bootstrap@5.0.0/dist/css/bootstrap.min.css" rel="stylesheet">
<title>View Booking </title>
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
       <th scope="col">Customer</th>
      <th scope="col">Customer Street</th>
      <th scope="col">Location</th>
      <th scope="col">Destination Street</th>
      <th scope="col">Destination Location</th>
       <th scope="col">Hours</th>
       <th scope="col">Coast</th>
       <th scope="col">Order Date</th>
        <th scope="col" colspan="2" >Action</th>
    </tr>
  </thead>
  <tbody>
   
<c:forEach var="book" items="${booking}">
    <tr>
     
      <td></td>
      <td></td>
      <td></td>
       <td></td>
       <td></td>
       <td></td>
       <td></td>
       <td></td>
       <td></td>
       <td></td>
       
    </tr>
 </c:forEach>
  </tbody>
</table>

</div>
</body>
</html>