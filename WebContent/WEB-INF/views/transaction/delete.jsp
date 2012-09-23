<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ include file="/WEB-INF/views/common/taglibs.jsp"%>
<html>
<head>
<title>Eliminar Cuenta</title>
</head>
<body>

	<h1>Eliminar Cuenta</h1>
	<br>
	<p>Seguro desea eliminar la cuenta No.<i>${account.number }</i> ?</p>
	<c:url value="/account/delete" var="accountDelete" />
	<form:form method="post" action="${accountDelete}"
		modelAttribute="account" cssClass="form-horizontal">
		
		<form:hidden path="number"/>
		
		<fieldset>
			<div class="form-actions">
				<input type="submit" class="btn btn-primary" value="Eliminar" />
				<a class="btn" href='<c:url value="/account/list" />'>Cancelar</a>
			</div>
		</fieldset>
	</form:form>

</body>
</html>