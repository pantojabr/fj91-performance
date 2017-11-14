<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@ attribute name="title" required="true"%>

<fmt:setLocale value="pt-BR" scope="session" />

<html>
<head>
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta name="viewport" content="width=device-width,initial-scale=1">
	<title>${title}</title>
	
	<link rel="stylesheet" href="<c:url value='/assets/vendor/bootstrap/css/bootstrap.css' />">
	<link rel="stylesheet" href="<c:url value='/assets/vendor/bootstrap/css/bootstrap-theme.css' />">
	<link rel="stylesheet" href="<c:url value='/assets/vendor/select2/select2.css' />">
	<link rel="stylesheet" href="<c:url value='/assets/vendor/owl.carousel/assets/owl.carousel.css' />">
	<link rel="stylesheet" href="<c:url value='/assets/vendor/owl.carousel/assets/owl.theme.default.css' />">
	<link rel="stylesheet" href="<c:url value='/assets/css/style.css' />">
</head>

<body data-msg="${msg}">
	<c:import url="/WEB-INF/tags/menu.jsp" />
	
	<jsp:doBody />
	
	<script type="text/javascript" src="<c:url value='/assets/vendor/jquery/jquery-3.2.1.js' />"></script>
	<script type="text/javascript" src="<c:url value='/assets/vendor/bootstrap/bootstrap.js' />"></script>
	<script type="text/javascript" src="<c:url value='/assets/vendor/jquery.validate/jquery.validate.js' />"></script>
	<script type="text/javascript" src="<c:url value='/assets/vendor/sweetAlert/sweetAlert.js' />"></script>
	<script type="text/javascript" src="<c:url value='/assets/vendor/tinymce/tinymce.min.js' />"></script>
	<script type="text/javascript" src="<c:url value='/assets/vendor/select2/select2.js' />"></script>
	<script type="text/javascript" src="<c:url value='/assets/vendor/owl.carousel/owl.carousel.js' />"></script>
	<script type="text/javascript" src="<c:url value='/assets/js/scripts.js' />"></script>
</body>
</html>
