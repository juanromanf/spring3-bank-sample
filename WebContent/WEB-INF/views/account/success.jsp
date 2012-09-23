<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ include file="/WEB-INF/views/common/taglibs.jsp"%>
<html>
<head>
<title>Cuenta</title>
</head>
<body>

	<h1>Cuenta</h1>
	<br>
	<p>
		La cuenta fue
		<c:choose>
			<c:when test="${created}">creada</c:when>
			<c:otherwise>actualizada</c:otherwise> 
		</c:choose>
		exitosamente.
	</p>
	
	<div class="form-actions">
		<a class="btn btn-primary" href='<c:url value="/account/edit/${account}" />'>Ver Cuenta</a>
		<a class="btn" href='<c:url value="/account/list" />'>Volver</a>
	</div>

</body>
</html>