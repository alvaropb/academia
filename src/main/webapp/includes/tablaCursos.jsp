<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    	<table class="table table-striped">
		<thead>
  		    <tr>
			    <th scope="col">id curso</th>
			    <th scope="col">nombre curso</th>
			    <th scope="col">Identificador</th>
			    <th scope="col">horas</th>
			    <th scope="col">id profesor</th>
			    <th scope="col">profesor</th>
			    
			</tr>
		 </thead>
		 <tbody>
			  <c:forEach items="${listaCursos }" var="curso">
				  <tr>
				  	
				    <td>${curso.id }</td>
				    <td>${curso.nombre }</td>
				    <td>${curso.identificador}</td>
				    <td>${curso.horas }</td>
				    <td>${curso.profesor.id }</td>
				    <td>${curso.profesor.nombre} ${curso.profesor.apellidos }</td>
				  </tr>
			  </c:forEach>
	  	</tbody>
	  
	</table>