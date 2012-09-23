<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ include file="/WEB-INF/views/common/taglibs.jsp"%>
<html>
<head>
<title>Registrar Transacci&oacute;n</title>
</head>
<body>

	<h1>Registrar Transacci&oacute;n</h1>
	<br>

	<c:url value="/transaction/save" var="transactionSave" />
	<form:form method="post" action="${transactionSave}"
		modelAttribute="transaction" cssClass="form-horizontal">

		<c:choose>
			<c:when test="${param.error eq 1}">
       			<div class="alert alert-error">
       				<a class="close" data-dismiss="alert" href="#">×</a>
       				Fondos insuficientes.
       			</div>
    		</c:when>
    		<c:when test="${param.error eq 2}">
       			<div class="alert alert-error">
       				<a class="close" data-dismiss="alert" href="#">×</a>
       				Seleccione una cuenta.
       			</div>
    		</c:when>		
		</c:choose>

		<fieldset>
			<div class="control-group">
				<form:label cssClass="control-label" path="account">Cuenta</form:label>
				<div class="controls">

					<form:select path="account.number">
						<form:option value="0" label="--- Seleccione ---" />
						<form:options items="${accounts}" itemValue="number"  />
					</form:select>
				</div>
			</div>

			<div class="control-group">
				<form:label cssClass="control-label" path="type">Tipo</form:label>
				<div class="controls">

					<form:select path="type">
						<form:options items="${types}" />
					</form:select>
				</div>
			</div>

			<div class="control-group">
				<form:label cssClass="control-label" path="amount">Valor</form:label>
				<div class="controls">
					<form:input path="amount" size="30" />
				</div>
			</div>

			<div class="form-actions">
				<input type="submit" class="btn btn-primary" value="Registrar" /> <a
					class="btn" href='<c:url value="/account/list" />'>Cancelar</a>
			</div>
		</fieldset>
	</form:form>

</body>
</html>