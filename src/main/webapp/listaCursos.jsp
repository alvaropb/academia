<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="includes/head.jsp"/>



<h2>TAREAS</h2>
<ol>
	<li>Maquetar pagina web, css e includes para reutilizar</li>
	<li>miercoles: Si se logea un PROFESOR que muestre sus curso, desde la misma JSP
	 podria crear un nuevo curso y eliminarlo</li>
	<li>jueves: Si se logea un ALUMNO que muestre sus curso a los que esta inscrito, 
	desde la misma JSP apuntarse a un nuevo curso</li>	
</ol>

<jsp:include page="includes/tablaCursos.jsp"/>

    
<jsp:include page="includes/footer.jsp"/>