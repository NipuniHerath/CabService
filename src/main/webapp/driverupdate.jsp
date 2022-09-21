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
<c:forEach var="data" items="${data}">
<h1>${data. getDrivername() } </h1>

</c:forEach>
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
<form  action="driver" method="post">
<c:forEach var="data" items="${data}">
  <input placeholder="Name" name="drivername" class="form-control"  value="${data. getDrivername() }"><br>
  <select class="form-control" name="driverbranch" required>
   <option VALUE="">Branch</option>
  <c:if test="${data.getDriverbranch()=='kandy'}">
   <option value="kandy" selected>Kandy</option>
  <option value="nugegoda">Nugegoda</option>
  <option value="kurunegala">Kurunegala</option>
  <option value="galle">Galle</option>
  <option value="gampaha">Gampaha</option>
  <option value="jaffna">Jaffna</option>
  </c:if>
  <c:if test="${data.getDriverbranch()=='nugegoda'}">
   <option value="kandy" >Kandy</option>
  <option value="nugegoda" selected>Nugegoda</option>
  <option value="kurunegala">Kurunegala</option>
  <option value="galle">Galle</option>
  <option value="gampaha">Gampaha</option>
  <option value="jaffna">Jaffna</option>
  </c:if>
   <c:if test="${data.getDriverbranch()=='kurunegala'}">
   <option value="kandy" >Kandy</option>
  <option value="nugegoda">Nugegoda</option>
  <option value="kurunegala" selected>Kurunegala</option>
  <option value="galle">Galle</option>
  <option value="gampaha">Gampaha</option>
  <option value="jaffna">Jaffna</option>
  </c:if>
   <c:if test="${data.getDriverbranch()=='galle'}">
   <option value="kandy" >Kandy</option>
  <option value="nugegoda">Nugegoda</option>
  <option value="kurunegala">Kurunegala</option>
  <option value="galle" selected>Galle</option>
  <option value="gampaha">Gampaha</option>
  <option value="jaffna">Jaffna</option>
  </c:if>
   <c:if test="${data.getDriverbranch()=='gampaha'}">
   <option value="kandy" >Kandy</option>
  <option value="nugegoda">Nugegoda</option>
  <option value="kurunegala">Kurunegala</option>
  <option value="galle">Galle</option>
  <option value="gampaha" selected>Gampaha</option>
  <option value="jaffna">Jaffna</option>
  </c:if>
   <c:if test="${data.getDriverbranch()=='jaffna'}">
   <option value="kandy" >Kandy</option>
  <option value="nugegoda">Nugegoda</option>
  <option value="kurunegala">Kurunegala</option>
  <option value="galle">Galle</option>
  <option value="gampaha" >Gampaha</option>
  <option value="jaffna" selected>Jaffna</option>
  </c:if>

   </select><br>
  <input class="form-control" placeholder="Contact Number" type="tel" name="contactnumber" value="${data.getContact()} " required><br>
   <input type="hidden" name="vid" value="${data.getDriverid()}"/>
  <input type="hidden" name="geturl" value="update"/>
  <button type="submit" class="btn btn-primary align-text-bottom">Update</button>
   </c:forEach>
</form>

</div>
</body>
</html>