<%@ include file="../common/taglibs.jsp"%>
<html>
<head>
<title>Clientes Registrados</title>
</head>
<body>

	<h1>Clientes Registrados</h1>
	<br>

	<table class="table table-striped">
		<thead>
			<tr>
				<th>C.C</th>
				<th>Nombre</th>
				<th>Direcci&oacute;n</th>
				<th>Tel&eacute;fono</th>
				<th>&nbsp;</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="c" items="${customers}">
				<tr>
					<td>${c.id}</td>
					<td>${c.name}</td>
					<td>${c.address}</td>
					<td>${c.phone}</td>
					<td width="15%">
						<p>
							<a href='<c:url value="/customer/edit/${c.id}" />' class="btn btn-mini"><i class="icon-pencil"></i> Editar</a>
							<a href='<c:url value="/customer/delete/${c.id}" />' class="btn btn-mini btn-danger"><i class="icon-trash icon-white"></i> Eliminar</a>
						</p>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>