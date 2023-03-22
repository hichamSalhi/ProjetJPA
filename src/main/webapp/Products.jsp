<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
<title>Produits</title>
<link href="css/bootstrap.css" rel="stylesheet" type="text/css">
<link href="css/bootstrap-grid.min.css" rel="stylesheet" type="text/css">
<link href="css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
	<%@include file ="header.jsp" %>
	
	<section>
	<form action = "Products" method="get">
	
		<div class="card m3">
		  <div class="card-header">
		 
		  	<input class="" placeholder="Chercher">
		  	<button class="btn btn-success" type="submit">Search</button>
		  		  	
		  	<button class="btn btn-success float-end m-1" type="submit">All Categories</button>
		  			  
		  </div>
		  <div class="card-body">
			  <table class="table">
					<thead>
						<tr>
							<td>Name</td>
							<td>Price</td>
							<td>Category</td>
							<td>Action</td>
						</tr>
					</thead>
					<tbody>
						<c:forEach items= "${produits}" var="p">
							<tr>
								<td>${p.name}</td>
								<td>${p.prix}</td>
								<td>${p.categorie.nameCat}</td>
								<td>
									<a class="btn btn-danger" onclick="return confirm('Voulez-vous supprimer ce produit ?')" href="deleteProduit?idProduit=${p.idProduit}">delete</a>
									&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
									<a class="btn btn-primary"  href="UpdateProducts?idProduit=${p.idProduit}">Edit</a>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
		  </div>
		</div>
		</form>
	</section>
	<%@include file="Footer.jsp" %>
</body>
</html>