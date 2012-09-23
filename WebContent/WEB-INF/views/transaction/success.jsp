<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ include file="/WEB-INF/views/common/taglibs.jsp"%>
<html>
<head>
<title>Transacci&oacute;n</title>
</head>
<body>

	<h1>Transacci&oacute;n</h1>
	<br>
	<p>
		La transacci&oacute;n fue registrada exitosamente.
	</p>
	
	<div class="form-actions">
		<a class="btn btn-primary" href='<c:url value="/transaction/show/${transaction}" />'>Ver Detalles</a>
		<a class="btn" href='<c:url value="/account/list" />'>Volver</a>
	</div>

</body>
</html>