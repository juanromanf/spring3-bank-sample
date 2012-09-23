<%@ include file="/WEB-INF/views/common/taglibs.jsp"%>
<html>
<head>
<title>Cuentas Registradas</title>
</head>
<body>

	<h1>Cuentas Registradas</h1>
	<br>

	<table class="table table-striped">
		<thead>
			<tr>
				<th>Cuenta No.</th>
				<th>Cliente</th>
				<th>Saldo</th>
				<th>&nbsp;</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="c" items="${accounts}">
				<tr>
					<td>${c.number}</td>
					<td>${c.customer.name}</td>
					<td>${c.balance}</td>
					<td width="15%">
						<p>
							<a href='<c:url value="/account/edit/${c.number}" />' class="btn btn-mini"><i class="icon-pencil"></i> Editar</a>
							<a href='<c:url value="/account/delete/${c.number}" />' class="btn btn-mini btn-danger"><i class="icon-trash icon-white"></i> Eliminar</a>
						</p>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>