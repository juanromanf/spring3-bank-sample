<%@ include file="/WEB-INF/views/common/taglibs.jsp"%>
<html>
<head>
<title>Transacciones Cuenta No. ${account.number }</title>
</head>
<body>

	<h1>Transacciones Cuenta No. ${account.number }</h1>
	<br>

	<table class="table table-striped">
		<thead>
			<tr>
				<th>Fecha</th>
				<th>Tipo</th>
				<th>Valor</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="t" items="${transactions}">
				<tr>
					<td> <fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${t.date}" /> </td>
					<td>${t.type}</td>
					<td>${t.amount}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<br>
	<a class="btn" href='<c:url value="/account/list" />'>Volver</a>
</body>
</html>