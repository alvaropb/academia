<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="includes/head.jsp"/>

<h1>LOGIN FORMULARIO</h1>

	<form action="login" method="post">
		
		 	 <div class="form-group">
				  <label for="usuario">Usuario</label>
				    <input name="usuario" type="text" class="form-control" value="${nombre }"  id="usuario" aria-describedby="Nombre usuario">
				    
			  </div>
			  
			  <div class="form-group">
				    <label for="password">Password</label>
				    <input name="password" type="password" class="form-control" id="password">
			  </div>

			  <button type="submit" class="btn btn-primary">Submit</button>
		
	</form>


<jsp:include page="includes/footer.jsp"/>