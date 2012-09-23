<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ include file="/WEB-INF/views/common/taglibs.jsp"%>
<html>
<head>
<title>Nueva Cuenta</title>
</head>
<body>

	<h1>Nueva Cuenta</h1>
	<br>

	<c:url value="/account/save" var="accountSave" />
	<form:form method="post" action="${accountSave}"
		modelAttribute="account" cssClass="form-horizontal">
		
		<c:choose>
			<c:when test="${param.error eq 1}">
       			<div class="alert alert-error">
       				<a class="close" data-dismiss="alert" href="#">×</a>
       				Seleccione un cliente.
       			</div>
    		</c:when>			
		</c:choose>
		
		<fieldset>
			<div class="control-group">
				<form:label cssClass="control-label" path="customer">Cliente</form:label>
				<div class="controls">

					<form:select path="customer.id">
						<form:option value="NONE" label="--- Seleccione ---" />
						<form:options items="${customers}" itemValue="id" itemLabel="name" />
					</form:select>
				</div>
			</div>

			<div class="form-actions">
				<input type="submit" class="btn btn-primary" value="Crear Cuenta" /> <a
					class="btn" href='<c:url value="/account/list" />'>Cancelar</a>
			</div>
		</fieldset>
	</form:form>

</body>
</html>