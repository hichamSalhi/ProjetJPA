<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="css/bootstrap.css" rel="stylesheet" type="text/css">
<link href="css/bootstrap-grid.min.css" rel="stylesheet" type="text/css">
<link href="css/style.css" rel="stylesheet" type="text/css">
<title>Login</title>
</head>
<body>
	<form action="Products" class="col-4 container mt-5">
	
	<center><h1>Welcome !</h1></center>
		<br>
		<br>
		<br>
		<br>
		  <div class="mb-3">
		    <label class="form-label">User name</label>
		    <input type="text" class="form-control" aria-describedby="emailHelp">
		  </div>
		  <div class="mb-3">
		    <label for="exampleInputPassword1" class="form-label">Password</label>
		    <input type="password" class="form-control" id="exampleInputPassword1">
		  </div>
		  <div class="mb-3 float-start">
		    <a href="#">Create Account !</a>
		  </div>
		  <button type="submit" class=" col-4 float-end btn btn-primary">Submit</button>
	</form>
</body>
</html>