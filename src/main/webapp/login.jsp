<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h1>LOGIN FORMULARIO</h1>

<form action="login" method="post">
	
	<label for="usuario">Usuario</label>
	<input type="text" name="usuario" value="${nombre }">

	<label for="password">password</label>
	<input type="password" name="password">
	
	<input type="submit" value="enviar">

</form>
	<label>${error}</label>
