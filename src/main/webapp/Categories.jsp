<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
<title>Categories</title>
<link href="css/bootstrap.css" rel="stylesheet" type="text/css">
<link href="css/bootstrap-grid.min.css" rel="stylesheet" type="text/css">
<link href="css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
	<%@include file ="header.jsp" %>
	
	<section>
	<form action ="categories" method="get">
	
		<div class="card m3">
		  <div class="card-header">
		  	<input class="" placeholder="Chercher">
		  	<button class="btn btn-success" type="submit">Search</button>	  	
		  	<button class="btn btn-success float-end m-1" type="submit">All categories</button>		  
		  </div>
		  <div class="card-body">
			  <table class="table">
					<thead>
						<tr>
							<td>Nom</td>
							<td>Action</td>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${categories}" var="c">
							<tr>
								<td>${c.nameCat}</td>
								<td>
									<a class="btn btn-danger" onclick="return confirm('Voulez-vous supprimer cette categorie ?')" href="deleteCategorie?idProduit=${c.idCategorie}">delete</a>
									<a class="btn btn-primary"  href="UpdateCategory?idCategory=${c.idCategorie}">Edit</a>
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