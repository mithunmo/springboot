<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page import="com.f9g4.web.utils.ViewPaths" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<title><tiles:importAttribute name="title" /><spring:message code="${title}" /></title>
		<link rel="stylesheet" type="text/css" href="/css/mobile/mobile.css" />
		<!-- <meta name="viewport" content="user-scalable=0" /> -->
		<script type="text/javascript" src="/js/jquery/jquery-1.7.2.min.js"></script>
		<script type="text/javascript" src="/js/mobile.min.js?v=1.1"></script>
		<script type="text/javascript" src="/js/ValidationHelper.min.js?v=1.1"></script>
		<script type="text/javascript">
			var contextRoot = '${pageContext.request.contextPath}';
			var submitSamplesPath = contextRoot+"/register/samples";
			var usernameCheckPath = contextRoot+"/register/usernamecheck";
			var registrationResult = contextRoot+"/register/success";
		</script>
		<%-- Google analytics --%>
		<script type="text/javascript" src="/js/gainit.min.js"></script>
	</head>

	<body>
		<div class="container">
			<tiles:insertAttribute name="header" />
			<tiles:insertAttribute name="body" />
			<tiles:insertAttribute name="footer" />
		</div>
	</body>
</html>