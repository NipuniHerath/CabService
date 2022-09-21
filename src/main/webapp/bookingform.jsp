<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core"%>
     
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://unpkg.com/bootstrap@5.0.0/dist/css/bootstrap.min.css" rel="stylesheet">
<title>Booking Form</title>
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
<form  action="vehicle" method="post">
  <input placeholder="Customername" name="customername" class="form-control" value="<%= session.getAttribute("name") %>"required><br>
  
   <input placeholder="Current Street" name="fromstreet" class="form-control" required><br>
   <select class="form-control" name="fromlocation" required>
   
  <option VALUE="">Customer City</option>
  <option value="kandy" >Kandy</option>
  <option value="nugegoda">Nugegoda</option>
  <option value="kurunegala">Kurunegala</option>
  <option value="galle">Galle</option>
  <option value="gampaha">Gampaha</option>
  <option value="jaffna">Jaffna</option>
   </select><br>
    <input placeholder="Booking Street" name="tostreet" class="form-control"required><br>
   <select class="form-control" name="tolocation" required>
   
  <option VALUE="">City</option>
  <option value="kandy" >Kandy</option>
  <option value="nugegoda">Nugegoda</option>
  <option value="kurunegala">Kurunegala</option>
  <option value="galle">Galle</option>
  <option value="gampaha">Gampaha</option>
  <option value="jaffna">Jaffna</option>
   </select><br>
    <input type="number" "Booking Hours" name="hours" class="form-control" required><br>
  <input type="date" id="date" name="date" class="form-control"><br><br>
  <input type="hidden" name="geturl" value="booknow"/>
  <input type="hidden" name="contactp" value="<%= session.getAttribute("drivernumb") %>">
   <input type="hidden" name="vehicleid" value="<%= session.getAttribute("vehicleid") %>">
   <input type="hidden" name="coast" value="<%= session.getAttribute("coast") %>">
  <button type="submit" class="btn btn-primary align-text-bottom">Book Now</button>
   </form>
</div>
<script>
date.min = new Date().toISOString().split("T")[0];


</script>
</body>
</html>