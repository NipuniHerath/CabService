<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://unpkg.com/bootstrap@5.0.0/dist/css/bootstrap.min.css" rel="stylesheet">

<title>Login</title>
</head>
<body>
<h3>${msg}</h3>


<div class="container"> <div class=" text-center mt-5 ">

    </div>
    <div class="row ">
        <div class="col-lg-7 mx-auto">
            <div class="card mt-2 mx-auto p-4 bg-light">
                <div class="card-body bg-light">
                    <div class="container">
                      <div class="d-flex justify-content-center">

<form action="customer" method="post">

<div class="d-flex justify-content-center"><h1>Login</h1></div>
<input type="text" name="email" id="email" placeholder="Email" class=""><br/><br/>
<input type="password" name="password" id="password" placeholder="password"><br/><br/>

<input type="hidden" name="geturl" value="login">
<button type="submit" class="btn btn-dark">Login</button>
 </form>

</div>
                    </div>
                </div>
            </div> 
        </div> 
    </div>
</div>
</body>
</html>