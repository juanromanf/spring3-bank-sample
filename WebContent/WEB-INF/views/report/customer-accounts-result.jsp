<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ include file="/WEB-INF/views/common/taglibs.jsp"%>
<html>
<head>
<title>Reporte Cuentas - Cliente</title>
</head>
<body>

	<h1>Reporte Cuentas</h1>
	<br>
	<h2>${ customer.name }</h2>
	<br>

	<c:choose>
		<c:when test="${ fn:length(result) gt 0 }">
			<table class="table table-striped">
			<thead>
				<tr>
					<th>Cuenta No.</th>
					<th>Debitos</th>
					<th>Creditos</th>
					<th>Saldo</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="r" items="${result}">
					<tr>
						<td>${r[1]}</td>
						<td>${r[3]}</td>
						<td>${r[4]}</td>
						<td>${r[2]}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		</c:when>
		<c:otherwise>
			No se encontraron registros... 
			<br>&nbsp;<br>
		</c:otherwise>
	</c:choose>

	<a class="btn" href='<c:url value="/report/customer-accounts" />'>Volver</a>

</body>
</html>