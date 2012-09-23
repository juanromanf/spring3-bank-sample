<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ include file="/WEB-INF/views/common/taglibs.jsp"%>
<html>
<head>
<title>Editar Cuenta</title>
</head>
<body>

	<h1>Editar Cuenta</h1>
	<br>

	<c:url value="/account/save" var="accountSave" />
	<form:form method="post" action="${accountSave}"
		modelAttribute="account" cssClass="form-horizontal">
		<fieldset>
			<div class="control-group">
				<form:label cssClass="control-label" path="number">No.</form:label>
				<div class="controls">
					<form:input path="number" size="30" readonly="true" />
				</div>
			</div>

			<div class="control-group">
				<form:label cssClass="control-label" path="customer.id">Cliente</form:label>
				<div class="controls">
					<form:select path="customer.id">
						<form:option value="NONE" label="--- Seleccione ---" />
						<form:options items="${customers}" itemValue="id" itemLabel="name" />
					</form:select>
				</div>
			</div>
			
			<div class="control-group">
				<form:label cssClass="control-label" path="balance">Saldo.</form:label>
				<div class="controls">
					<form:input path="balance" size="30" readonly="true" />
				</div>
			</div>

			<div class="form-actions">
				<input type="submit" class="btn btn-primary" value="Guardar" />
				<a class="btn" href='<c:url value="/account/list" />'>Cancelar</a>
			</div>
		</fieldset>
	</form:form>

</body>
</html>