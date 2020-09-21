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
Extra
<ol>
	<li>Trazas de LOG</li>
	<li>Singleton</li>
	<li>Gestion de errores TRY y CACTH sobre todo en los controladore</li>
	<li>Validacion de datos de los formulario con javax.validation</li>
	<li>Gestion de Seguridad, que los profesores y alumnos solo puedan modificar sus datos, No poder saltarse el Login</li>
	<li>Un ALUMNO puede escribir una reseña de un curso/profesor, calificando del 1 al 5 y escribiendo un comentario</li>	
</ol>

<jsp:include page="includes/tablaCursos.jsp"/>

    
<jsp:include page="includes/footer.jsp"/>