<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ include file="/WEB-INF/views/common/taglibs.jsp"%>
<html>
<head>
<title>Detalle Transacci&oacute;n</title>
</head>
<body>

	<h1>Detalle Transacci&oacute;n</h1>
	<br>

	<form:form method="post" action="#"
		modelAttribute="transaction" cssClass="form-horizontal">
		<fieldset>
			<div class="control-group">
				<form:label cssClass="control-label" path="id">Transacci&oacute;n No.</form:label>
				<div class="controls">
					<form:input path="id" size="30" readonly="true" />
				</div>
			</div>

			<div class="control-group">
				<form:label cssClass="control-label" path="type">Tipo</form:label>
				<div class="controls">
					<form:input path="type" size="30" readonly="true" />
				</div>
			</div>
			
			<div class="control-group">
				<form:label cssClass="control-label" path="date">Fecha</form:label>
				<div class="controls">
					<form:input path="date" size="30" readonly="true" />
				</div>
			</div>
			
			<div class="control-group">
				<form:label cssClass="control-label" path="amount">Valor</form:label>
				<div class="controls">
					<form:input path="amount" size="30" readonly="true" />
				</div>
			</div>

			<div class="form-actions">
				<a class="btn" href='<c:url value="/account/list" />'>Volver</a>
			</div>
		</fieldset>
	</form:form>

</body>
</html>