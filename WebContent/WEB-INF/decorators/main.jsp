<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../views/common/taglibs.jsp"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
	prefix="decorator"%>


<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>Banco :: <decorator:title /></title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">

<!-- Le styles -->
<link href='<c:url value="/static/bootstrap/css/bootstrap.css" />'
	rel="stylesheet">
<style>
body {
	padding-top: 60px;
	/* 60px to make the container go all the way to the bottom of the topbar */
}
</style>
<link
	href='<c:url value="/static/bootstrap/css/bootstrap-responsive.css" />'
	rel="stylesheet">

<!-- Le HTML5 shim, for IE6-8 support of HTML5 elements -->
<!--[if lt IE 9]>
      <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->

<script type="text/javascript"
	src='http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js'></script>

<!-- Le fav and touch icons -->
<link rel="shortcut icon"
	href='<c:url value="/static/img/favicon.ico" />'>

<decorator:head />
</head>

<body>

	<div class="navbar navbar-fixed-top">
		<div class="navbar-inner">
			<div class="container">
				<a class="btn btn-navbar" data-toggle="collapse"
					data-target=".nav-collapse"> <span class="icon-bar"></span> <span
					class="icon-bar"></span> <span class="icon-bar"></span>
				</a> <a class="brand" href="#">Banco</a>
				<div class="nav-collapse">
					<ul class="nav">
						<li><a href='<c:url value="/welcome" />'><i
								class="icon-home icon-white"></i></a></li>

						<li class="dropdown" id="menu1"><a class="dropdown-toggle"
							data-toggle="dropdown" href="#menu1"> Clientes <b
								class="caret"></b>
						</a>
							<ul class="dropdown-menu">
								<li><a href='<c:url value="/customer/add" />'>Nuevo
										cliente</a></li>
								<li><a href='<c:url value="/customer/list" />'>Ver
										clientes registrados</a></li>
							</ul></li>

						<li class="dropdown" id="menu2"><a class="dropdown-toggle"
							data-toggle="dropdown" href="#menu2"> Cuentas <b
								class="caret"></b>
						</a>
							<ul class="dropdown-menu">
								<li><a href='<c:url value="/account/add" />'>Nueva
										cuenta</a></li>
								<li><a href='<c:url value="/account/list" />'>Ver
										cuentas registradas</a></li>
								<li class="divider"></li>
								<li><a href='<c:url value="/transaction/add" />'>Registrar
										transacci&oacute;n</a></li>
								<li><a href='<c:url value="/report/customer-accounts" />'>Reporte
										de cuentas por cliente</a></li>
							</ul></li>
					</ul>
				</div>
				<!--/.nav-collapse -->
			</div>
		</div>
	</div>

	<div class="container">

		<decorator:body />

	</div>
	<!-- /container -->

	<!-- javascript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<%-- <script src='<c:url value="/static/bootstrap/js/jquery.js" />'></script> --%>
	<script
		src='<c:url value="/static/bootstrap/js/bootstrap-transition.js" />'></script>
	<script src='<c:url value="/static/bootstrap/js/bootstrap-alert.js" />'></script>
	<script src='<c:url value="/static/bootstrap/js/bootstrap-modal.js" />'></script>
	<script
		src='<c:url value="/static/bootstrap/js/bootstrap-dropdown.js" />'></script>
	<script
		src='<c:url value="/static/bootstrap/js/bootstrap-scrollspy.js" />'></script>
	<script src='<c:url value="/static/bootstrap/js/bootstrap-tab.js" />'></script>
	<script
		src='<c:url value="/static/bootstrap/js/bootstrap-tooltip.js" />'></script>
	<script
		src='<c:url value="/static/bootstrap/js/bootstrap-popover.js" />'></script>
	<script
		src='<c:url value="/static/bootstrap/js/bootstrap-button.js" />'></script>
	<script
		src='<c:url value="/static/bootstrap/js/bootstrap-collapse.js" />'></script>
	<script
		src='<c:url value="/static/bootstrap/js/bootstrap-carousel.js" />'></script>
	<script
		src='<c:url value="/static/bootstrap/js/bootstrap-typeahead.js" />'></script>

</body>