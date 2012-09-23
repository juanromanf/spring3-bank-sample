<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ include file="../common/taglibs.jsp"%>
<html>
<head>
<title>Eliminar Cliente</title>
</head>
<body>

	<h1>Eliminar Cliente</h1>
	<br>
	<p>Seguro desea eliminar el cliente <i>${customer.name } (${customer.id })</i> ?
	<c:url value="/customer/delete" var="customerDelete" />
	<form:form method="post" action="${customerDelete}"
		modelAttribute="customer" cssClass="form-horizontal">
		<form:hidden path="id"/>
		<fieldset>
			<div class="form-actions">
				<input type="submit" class="btn btn-primary" value="Eliminar" />
				<a class="btn" href='<c:url value="/customer/list" />'>Cancelar</a>
			</div>
		</fieldset>
	</form:form>

</body>
</html>