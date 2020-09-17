<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    HttpSession s = request.getSession(true);
    request.setCharacterEncoding("UTF-8");
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>MF0226_3: Ipartek </title>
	    <meta name="description" content="Ipartek formación"> 
        <meta name="viewport" content="width=device-width, user-scalable=no">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    </head>
    <body>
		<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
		<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
		<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
		
		
		
		<nav class="navbar navbar-expand-lg navbar-light bg-light">
			<c:if test="${usuario eq null }">
		 		 <a class="navbar-brand" href="login.jsp">Login</a>
		  	</c:if>
		  	<c:if test="${usuario ne null }">
			  	<div class="alert alert-primary" role="alert">
			  		${usuario.nombre} ${usuario.apellidos }
				</div>
			</c:if>
			<c:if test="${usuario ne null }">
		
		
			  <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
			    <div class="navbar-nav">
			      <a class="nav-item nav-link active" href="#">Home <span class="sr-only">(current)</span></a>
			      <a class="nav-item nav-link" href="#">Features</a>
			      <a class="nav-item nav-link" href="#">Pricing</a>
			      <a class="nav-item nav-link disabled" href="#" tabindex="-1" aria-disabled="true">Disabled</a>
			    </div>
			  </div>
		  </c:if>
		</nav>
		<!-- main  -->
		<main class="container">
			<c:if test="${null ne mensaje }">
				
				<div class="alert ${mensaje.tipo }" role="alert">
				  ${mensaje.mensaje }
				</div>
			</c:if>
			
	
	