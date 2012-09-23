<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ include file="../common/taglibs.jsp"%>
<html>
<head>
<title>Nuevo Cliente</title>
</head>
<body>

	<h1>Nuevo Cliente</h1>
	<br>

	<c:url value="/customer/save" var="customerSave" />
	<form:form method="post" action="${customerSave}"
		modelAttribute="customer" cssClass="form-horizontal">
		
		<c:choose>
			<c:when test="${param.error eq 1}">
       			<div class="alert alert-error">
       				<a class="close" data-dismiss="alert" href="#">×</a>
       				El campo C.C es obligatorio.
       			</div>
    		</c:when>    		
		</c:choose>
		
		<fieldset>
			<div class="control-group">
				<form:label cssClass="control-label" path="id">C.C</form:label>
				<div class="controls">
					<form:input path="id" size="30" />
				</div>
			</div>

			<div class="control-group">
				<form:label cssClass="control-label" path="name">Nombre</form:label>
				<div class="controls">
					<form:input path="name" cssStyle="width: 50%" />
				</div>
			</div>

			<div class="control-group">
				<form:label cssClass="control-label" path="address">Direcci&oacute;n</form:label>
				<div class="controls">
					<form:input path="address" cssStyle="width: 50%" />
				</div>
			</div>

			<div class="control-group">
				<form:label cssClass="control-label" path="phone">Tel&eacute;fono</form:label>
				<div class="controls">
					<form:input path="phone" cssStyle="width: 50%" />
				</div>
			</div>

			<div class="form-actions">
				<input type="submit" class="btn btn-primary" value="Guardar" />
				<a class="btn" href='<c:url value="/customer/list" />'>Cancelar</a>
			</div>
		</fieldset>
	</form:form>

</body>
</html>