<%@page import="entities.Categorie"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
<title>Update Products</title>
<link href="css/bootstrap.css" rel="stylesheet" type="text/css">
<link href="css/bootstrap-grid.min.css" rel="stylesheet" type="text/css">
<link href="css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
	<%@include file ="header.jsp" %>

	<section>
	
	<form action="UpdateProducts" method="post">
		<div class="card m3 width">
		  <div class="card-header">
		  	<h1>Update Product <input hidden="true" name="idProduit" value="${idProduit}"> </h1>
		  </div>
		  <div class="card-body">
			  <div class="form-group">
			  	<label class="control-label">Name</label>
			  	<input name="name" class="form-control col-3" value="${name}">
			  </div>
			  
			  <div class="form-group">
			  	<label class="control-label">Price</label>
			  	<input name="price" class="form-control col-3" value="${price}">
			  </div>
			  
			   <div class="form-group">
			   
			  	<label class="control-label">Category</label>
			  	<select name="category" class="form-control col-3">
			  		<c:forEach items = "${categories}" var="c">
			  			<option value="${c.idCategorie}"><c:out value="${c.nameCat}"></c:out></option>
			  		</c:forEach>
			  	</select>
			  </div>
			  <br>
			  <br>
			  
			  <div>	  	
			  	<button type="submit" class="btn btn-success col-3">Update</button>
			  </div>
			  
		  </div>
		</div>
	</form>
	</section>
	
	

</body>
</html>