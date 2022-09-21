<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core"%>
     
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://unpkg.com/bootstrap@5.0.0/dist/css/bootstrap.min.css" rel="stylesheet">
<title>Insert Products</title>
</head>
<body>
<div class="container">
 <nav class="navbar navbar-dark bg-dark">
    <div class="container-fluid">
    <a class="navbar-brand" href="add-product.jsp">Home</a>
    <a class="navbar-brand" href="driveradd.jsp.jsp">Insert Driver</a>
    <a class="navbar-brand" href="/mobile-product/getProducts?action=all">View Driver</a>
       
         
         
    </div>
  </nav>
  
</div><br><br>
<div class="container" >
<h3>${msg}</h3>
<form  action="customer" method="post">
  <input placeholder="Name" name="customername" class="form-control"><br>
  
    <input placeholder="Street" name="customerstreet" class="form-control"><br>
    
   <select class="form-control" name="customerbranch" required>
   
  <option VALUE="">Branch</option>
  <option value="kandy" >Kandy</option>
  <option value="nugegoda">Nugegoda</option>
  <option value="kurunegala">Kurunegala</option>
  <option value="galle">Galle</option>
  <option value="gampaha">Gampaha</option>
  <option value="jaffna">Jaffna</option>
   </select><br>
<input class="form-control" placeholder="Contact Number" type="tel" name="contactnumber" required><br>
     <input placeholder="Email" name="email" class="form-control"><br>
   <input type="password" "Password" name="password" class="form-control" placeholder="Password"><br>
  <input type="hidden" name="geturl" value="add"/>
  
  <button type="submit" class="btn btn-primary align-text-bottom">Create Account</button>
   
</form>

</div>
</body>
</html>