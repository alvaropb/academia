<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="../includes/head.jsp"/>
<h1>Alumno</h1>

	
<h1>Cursos inscrito</h1>
	

	<jsp:include page="../includes/tablaCursos.jsp"/>
	
<h1>Inscribirse a cursos</h1>




		<form action="${pageContext.request.contextPath}/privado/alumno" method="post">	
			<select class="custom-select" name="cursoApuntarse">
			  	<option selected>Seleccione un curso</option>
				<c:forEach items="${ofertaCursos }" var="curso">
					<option value="${curso.id }">${curso.identificador } ${curso.nombre } ${curso.profesor.nombre }${curso.profesor.apellidos }</option>
				</c:forEach>
			</select>
	
		  <button type="submit" class="btn btn-primary mt-4">Inscribirse</button>
		</form>
		


<jsp:include page="../includes/footer.jsp"/>