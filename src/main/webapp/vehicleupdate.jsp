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


  <h4>${msg}</h4>
  
  
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

<c:forEach var="vehicledat" items="${data}">

  <input placeholder="Model" name="model" class="form-control" value="${vehicledat.getVehiclemodle()}"> <br>
  
   <input class="form-control" type="number" name="driverid" placeholder="Driver ID" value="${vehicledat.getDriverid()}"><br>
  <input type="number" placeholder="Coast For Hour"  name="coastperhour" class="form-control" value="${vehicledat.getCoastperhour()}"><br>
  
  <select class="form-control" name="vehiclebranch" required>
   <option VALUE="">Branch</option>
  <c:if test="${vehicledat.getVehiclebranch()=='kandy'}">
   <option value="kandy" selected>Kandy</option>
  <option value="nugegoda">Nugegoda</option>
  <option value="kurunegala">Kurunegala</option>
  <option value="galle">Galle</option>
  <option value="gampaha">Gampaha</option>
  <option value="jaffna">Jaffna</option>
  </c:if>
  <c:if test="${vehicledat.getVehiclebranch()=='nugegoda'}">
   <option value="kandy" >Kandy</option>
  <option value="nugegoda" selected>Nugegoda</option>
  <option value="kurunegala">Kurunegala</option>
  <option value="galle">Galle</option>
  <option value="gampaha">Gampaha</option>
  <option value="jaffna">Jaffna</option>
  </c:if>
   <c:if test="${vehicledat.getVehiclebranch()=='kurunegala'}">
   <option value="kandy" >Kandy</option>
  <option value="nugegoda">Nugegoda</option>
  <option value="kurunegala" selected>Kurunegala</option>
  <option value="galle">Galle</option>
  <option value="gampaha">Gampaha</option>
  <option value="jaffna">Jaffna</option>
  </c:if>
   <c:if test="${vehicledat.getVehiclebranch()=='galle'}">
   <option value="kandy" >Kandy</option>
  <option value="nugegoda">Nugegoda</option>
  <option value="kurunegala">Kurunegala</option>
  <option value="galle" selected>Galle</option>
  <option value="gampaha">Gampaha</option>
  <option value="jaffna">Jaffna</option>
  </c:if>
   <c:if test="${vehicledat.getVehiclebranch()=='gampaha'}">
   <option value="kandy" >Kandy</option>
  <option value="nugegoda">Nugegoda</option>
  <option value="kurunegala">Kurunegala</option>
  <option value="galle">Galle</option>
  <option value="gampaha" selected>Gampaha</option>
  <option value="jaffna">Jaffna</option>
  </c:if>
   <c:if test="${vehicledat.getVehiclebranch()=='jaffna'}">
   <option value="kandy" >Kandy</option>
  <option value="nugegoda">Nugegoda</option>
  <option value="kurunegala">Kurunegala</option>
  <option value="galle">Galle</option>
  <option value="gampaha" >Gampaha</option>
  <option value="jaffna" selected>Jaffna</option>
  </c:if>

   </select><br>
  
  
  
  <select class="form-control" name="catog" required>
   
  <option VALUE="">Category</option>
  <c:if test="${vehicledat.getVehiclecatergory()=='bronze'}">
  <option value="bronze" selected>bronze</option>
  <option value="gold">gold</option>
  <option value="platinum">platinum</option>
  </c:if>
    <c:if test="${vehicledat.getVehiclecatergory()=='gold'}">
  <option value="bronze">bronze</option>
  <option value="gold" selected>gold</option>
  <option value="platinum">platinum</option>
  </c:if>
    <c:if test="${vehicledat.getVehiclecatergory()=='platinum'}">
  <option value="bronze" >bronze</option>
  <option value="gold">gold</option>
  <option value="platinum" selected>platinum</option>
  </c:if>
   </select><br>
  <input type="hidden" name="geturl" value="update"/>
 
  <input type="hidden" name="vid" value="${vehicledat.getId()}"/>
  <button type="submit" class="btn btn-primary align-text-bottom">Update vehicle</button>
</c:forEach>
</form>

</div>




</body>
</html>