<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://unpkg.com/bootstrap@5.0.0/dist/css/bootstrap.min.css" rel="stylesheet">
<title>Insert Vehicle</title>
</head>
<body>


  <h1>${msg}</h1>
<div class="container">
 <nav class="navbar navbar-dark bg-dark">
    <div class="container-fluid">
    <a class="navbar-brand" href="">Home</a>
    <a class="navbar-brand" href="">Insert driver</a>
    <a class="navbar-brand" href="">View drivers</a>
    <a class="navbar-brand" href="">search drivers</a>   
         
         
    </div>
  </nav>
  
</div><br><br>
<div class="container" >
<form  action="vehicle" method="post">
  <input placeholder="Model" name="model" class="form-control"><br>
  <select class="form-control" name="driverid" required>
   <option VALUE="">Driver Name</option>
  <c:forEach var="driver" items="${drivers}">
  <option value="${driver.getDriverid()}" >${driver.getDrivername()}</option>
  </c:forEach>
  </select><br>
  <input type="number" placeholder="Coast For Hour"  name="coastperhour" class="form-control"><br>
  
  <select class="form-control" name="vehiclebranch" required>
   
  <option VALUE="">Branch</option>
  <option value="kandy" >Kandy</option>
  <option value="nugegoda">Nugegoda</option>
  <option value="kurunegala">Kurunegala</option>
  <option value="galle">Galle</option>
  <option value="gampaha">Gampaha</option>
  <option value="jaffna">Jaffna</option>
   </select><br>
  
  
  
  <select class="form-control" name="catog" required>
   
  <option VALUE="">Category</option>
  <option value="bronze" >bronze</option>
  <option value="gold">gold</option>
  <option value="platinum">platinum</option>
   </select><br>
  <input type="hidden" name="geturl" value="add"/>
  <button type="submit" class="btn btn-primary align-text-bottom">Insert vehicle</button>

</form>

</div>




</body>
</html>