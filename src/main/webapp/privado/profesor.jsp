<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="../includes/head.jsp"/>
	<h1>Detalle profesor</h1>
	<h2>${mensaje}</h2>

	
	 <table style="width:100%">
		  <tr>
		    <th>Nombre</th>
		    <th>Identificador</th>
		    <th>Horas</th>
		    <th>Profesor</th>
		    <th>Operaciones</th>
		  </tr>
		  <c:forEach items="${listaCursos }" var="curso">
			  <tr>
		 		<td>${curso.nombre }</td>
			    <td>${curso.identificador}</td>
			    <td>${curso.horas }</td>
			    <td>${curso.profesor.nombre} ${curso.profesor.apellidos }</td>
			    <td><a href="privado/profesor?id=${curso.id }">Eliminar curso </a></td>
			  </tr>
		  </c:forEach>

	</table> 
	
	<form action="privado/profesor" method="post">
		
		<label for="nombreCurso">Nombre del curso</label>
		<input type="text" name="nombreCurso" id="nombreCurso">
		
		<label for="identificador">identificador</label>
		<input type="text" name="identificador" id="identificador">
		
		<label for="horas">horas</label>
		<input type="text" name="horas" id="horas">
		
		<input type="submit" value="Crear curso">
	
	</form>
	
<jsp:include page="../includes/footer.jsp"/>
	
	
	