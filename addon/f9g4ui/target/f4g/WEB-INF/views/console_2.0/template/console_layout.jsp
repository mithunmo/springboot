<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page import="com.f9g4.web.utils.ViewPaths"%>
<!DOCTYPE html>
<html ng-app="consoleApp">
	<head>
		<meta http-equiv="x-ua-compatible" content="IE=Edge"/>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta name="viewport" content="width=1050, maximum-scale=1.5, user-scalable=1" />
		<title><tiles:importAttribute name="title" /><spring:message code="${title}" /></title>
		<tiles:insertAttribute name="js_ajax_path"></tiles:insertAttribute>
		<link rel="stylesheet" type="text/css" href="/css/ver3/normalize.css" />
		<link rel="stylesheet" type="text/css" href="/css/ver3/console.css" />
		<link rel="stylesheet" type="text/css" href="/css/ver3/animation.css" />
		<link rel="stylesheet" type="text/css" href="/css/ver3/rzslider.css" />
		<link rel="stylesheet" type="text/css" href="/css/ver3/angular-multi-select.css" />
		<link rel="stylesheet" type="text/css" href="/css/ver3/bootstrap/bootstrap.min.css" />
		<link rel="stylesheet" type="text/css" href="/css/ver3/bootstrap/bootstrap-theme.min.css" />
		<link rel="stylesheet" type="text/css" href="/css/ver3/ng-modal.css" />
		<link rel="stylesheet" type="text/css" href="/css/ver3/dialogs.css" />
		<link rel="stylesheet" type="text/css" href="/css/uploadify/uploadify.css" media="all" />
		<script type="text/javascript" src="/js/angular.min.js"></script>
		<script type="text/javascript" src="/js/angular-animate.min.js"></script>
		<script type="text/javascript" src="/js/angular-route.min.js"></script>
		<script type="text/javascript" src="/js/angular-sanitize.min.js"></script>
		<tiles:insertAttribute name="core_js_libs"></tiles:insertAttribute>
		<script type="text/javascript" src="/js/plugin/rzslider.js"></script>
		<script type="text/javascript" src="/js/plugin/angular-multi-select.js"></script>
		<script type="text/javascript" src="/js/plugin/ui-bootstrap-tpls-0.11.2.min.js"></script>
		<script type="text/javascript" src="/js/plugin/ng-modal.min.js"></script>
		<script type="text/javascript" src="/js/plugin/dialogs-default-translations.min.js"></script>
		<script type="text/javascript" src="/js/plugin/dialogs.min.js"></script>
		<%-- J-Query Core --%>
		<script type="text/javascript" src="/js/jquery/jquery-1.7.2.min.js" ></script>
		<%-- File Uploading --%>
		<script type="text/javascript" src="/js/jquery/uploadify/jquery.uploadify-3.1.min.js"></script>
	</head>
	
	<body ng-controller="appController">
		<!-- Header -->
		<tiles:insertAttribute name="header"></tiles:insertAttribute>
		<!-- Content -->
		<tiles:insertAttribute name="body"></tiles:insertAttribute>
		<!-- Footer -->
		<tiles:insertAttribute name="footer"></tiles:insertAttribute>
	</body>
</html>