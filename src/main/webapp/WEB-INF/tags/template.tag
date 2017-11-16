<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@ attribute name="title" required="true"%>
<%@ attribute name="extraStyles" fragment="true" %>
<%@ attribute name="extraScripts" fragment="true" %>

<fmt:setLocale value="pt-BR" scope="session" />

<html>
<head>
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta name="viewport" content="width=device-width,initial-scale=1">
	<title>${title}</title>
	
	<link rel="stylesheet" href="<c:url value='/assets/vendor/bootstrap/css/bootstrap.css' />">

	<!-- Puxa os outros estilos especificos da pagina -->
	<jsp:invoke fragment="extraStyles" />

	<link rel="stylesheet" href="<c:url value='/assets/css/style.css' />">
</head>

<body data-msg="${msg}">
	<c:import url="/WEB-INF/tags/menu.jsp" />
	
	<jsp:doBody />
	
	<script type="text/javascript" src="<c:url value='/assets/vendor/jquery/jquery-3.2.1.js' />"></script>
	<script type="text/javascript" src="<c:url value='/assets/vendor/bootstrap/bootstrap.js' />"></script>

	<!-- Puxa os scripts especificos da pagina -->
	<jsp:invoke fragment="extraScripts" />
</body>
</html>
