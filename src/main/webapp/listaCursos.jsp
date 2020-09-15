<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="head.jsp"/>

<h1><a href="login.jsp">->login</a></h1>
<table>
  <tr>
    <th>id curso</th>
    <th>nombre curso</th>
    <th>Identificador</th>
    <th>horas</th>
    <th>id profesor</th>
    <th>profesor</th>
    <th></th>
  </tr>
  <c:forEach items="${cursos }" var="curso">
	  <tr>
	    <td>${curso.id }</td>
	    <td>${curso.nombre }</td>
	    <td>${curso.identificador}</td>
	    <td>${curso.horas }</td>
	    <td>${curso.profesor.id }</td>
	    <td>${curso.profesor.nombre} ${curso.profesor.apellidos }</td>
	  </tr>
  </c:forEach>
  
</table>

    
<jsp:include page="footer.jsp"/>