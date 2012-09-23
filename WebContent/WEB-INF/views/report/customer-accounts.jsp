<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ include file="/WEB-INF/views/common/taglibs.jsp"%>
<html>
<head>
<title>Reporte Cuentas - Cliente</title>

<link rel="stylesheet" type="text/css"
	href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8.14/themes/base/jquery-ui.css"></link>

<script type="text/javascript"
	src=' http://ajax.googleapis.com/ajax/libs/jqueryui/1.8.14/jquery-ui.min.js '></script>

<script>
	$(function() {
		$.datepicker.setDefaults({
			dateFormat : 'yy-mm-dd'
		});
		$("#endDate").datepicker();
		$("#startDate").datepicker();
	});
</script>
</head>
<body>

	<h1>Reporte Cuentas - Cliente</h1>
	<br>

	<c:url value="/report/customer-accounts" var="accountSave" />
	<form:form method="post" action="${accountSave}"
		modelAttribute="report" cssClass="form-horizontal">

		<c:choose>
			<c:when test="${param.error eq 1}">
				<div class="alert alert-error">
					<a class="close" data-dismiss="alert" href="#">×</a> Seleccione un
					cliente.
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

			<div class="control-group">
				<form:label cssClass="control-label" path="startDate">Fecha inicial</form:label>
				<div class="controls">
					<form:input path="startDate" />
				</div>
			</div>

			<div class="control-group">
				<form:label cssClass="control-label" path="endDate">Fecha final</form:label>
				<div class="controls">
					<form:input path="endDate" />
				</div>
			</div>

			<div class="form-actions">
				<input type="submit" class="btn btn-primary" value="Generar" /> <a
					class="btn" href='<c:url value="/account/list" />'>Cancelar</a>
			</div>
		</fieldset>
	</form:form>

</body>
</html>