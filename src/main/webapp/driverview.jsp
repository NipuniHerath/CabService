<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core"%> 
  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1" charset=UTF-8>
<link href="https://unpkg.com/bootstrap@5.0.0/dist/css/bootstrap.min.css" rel="stylesheet">
<title>Driver View</title>
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
       <th scope="col">Name</th>
      <th scope="col">Branch</th>
      <th scope="col">Contact</th>
      
    </tr>
  </thead>
  <tbody>
   
<c:forEach var="drivers" items="${drivers}">
    <tr>
     
      <td>${drivers.getDriverid()}</td>
      <td>${drivers.getDrivername()}</td>
      <td>${drivers.getDriverbranch()}</td>
     <td>${drivers. getContact()}</td>
       <td>
       <form action="driver" method="post">
       <input type="hidden" name="id" value="${drivers.getDriverid()}">
       <input type="hidden" name="geturl" value="edit">
       <button class="btn btn-primary">EDIT</button>
       
       </form>
       <form action="driver" method="post">
       <input type="hidden" name="id" value="${drivers.getDriverid()}">
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