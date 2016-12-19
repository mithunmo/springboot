<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page import="com.f9g4.web.utils.ViewPaths" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="x-ua-compatible" content="IE=Edge"/>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta name="viewport" content="width=1050, maximum-scale=1.5, user-scalable=1" />
		<title><tiles:importAttribute name="title" /><spring:message code="${title}" /><%-- <tiles:insertAttribute name="title" ignore="true" /> --%></title>
		<link rel="stylesheet" type="text/css" href="/css/ver2.0/popup_2.0.css" />
		<link rel="stylesheet" type="text/css" href="/css/ver2.0/splashscreen_2.0.css" />
		<link rel="stylesheet" type="text/css" href="/css/nivo-slider/nivo-slider.css" />
		<link rel="stylesheet" type="text/css" href="/css/uploadify/uploadify.css" media="all" />
		<link rel="stylesheet" type="text/css" href="/css/tooltip/jquery.qtip.css" />
		<!--[if IE 8]>
			<link rel="stylesheet" type="text/css" href="/css/ver2.0/ie8_popup_2.0.css" />
			<style type="text/css">
				body { filter: progid:DXImageTransform.Microsoft.gradient(GradientType=0,startColorstr='#e6e7e8', endColorstr='#ffffff'); /* For IE7-8-9  */}
			</style>
		<![endif]-->
		<!--[if IE 7]>
			<link rel="stylesheet" type="text/css" href="/css/ver2.0/ie7_popup_2.0.css" />
			<link rel="stylesheet" type="text/css" href="/css/ver2.0/ie7_splashscreen_2.0.css" />
			<style type="text/css">
				body { filter: progid:DXImageTransform.Microsoft.gradient(GradientType=0,startColorstr='#e6e7e8', endColorstr='#ffffff'); /* For IE7-8-9  */}
				.body { overflow:hidden;}
			</style>
		<![endif]-->
		<script id="twitter-wjs" type="text/javascript" src="http://platform.twitter.com/widgets.js"></script>
		<script type="text/javascript" src="/js/jquery/jquery-1.7.2.min.js"></script>
		<script type="text/javascript" src="/js/jquery/scrollbar/jquery.tinyscrollbar.min.js"></script>
		<!-- File Uploading -->
		<script type="text/javascript" src="/js/jquery/uploadify/jquery.uploadify-3.1.min.js"></script>
		<script type="text/javascript" src="/js/ValidationHelper.min.js?v=1.1"></script>
		<script type="text/javascript" src="/js/popup.min.js?v=2.2"></script>
		<script type="text/javascript" src="/js/splashscreen.min.js?v=1.23"></script>
		<script type="text/javascript" src="/js/jquery/placeholder/jquery.placeholder.min.js"></script>
		<!-- For image rotator -->
		<script type="text/javascript" src="/js/jquery/nivo-slider/jquery.nivo.slider.pack.js"></script>
		<!--  tooltip -->
		<script type="text/javascript" src="/js/jquery/tooltip/jquery.qtip.min.js"></script>
		<script type="text/javascript" src="/js/jquery/browserdetect/detectmobilebrowser.min.js?v=1.0"></script>
		<script type="text/javascript">
			var contextRootPath = "${pageContext.request.contextPath}"; 
			var splashUrl = "${pageContext.request.contextPath}"+"<%= ViewPaths.LOGIN%>";
			var forgotPwdUrl = "${pageContext.request.contextPath}/user/forgotpwd";
			var consoleHomeUrl = "${pageContext.request.contextPath}/console/home";
			var securityQuestionsUrl = "${pageContext.request.contextPath}/user/questions";
			var termsUrl = "${pageContext.request.contextPath}/user/terms";
			var updateMembershipPath="${pageContext.request.contextPath}"+"<%= ViewPaths.MEMBERSHIP_PAY  %>";
			var invitationFormPath = "${pageContext.request.contextPath}"+"<%= ViewPaths.INVITATION_FORM  %>";
			var setupSeqPasswordPath = "${pageContext.request.contextPath}"+"<%= ViewPaths.SETUP_SEQ_PASSWORD  %>";
			var membershipUrl  = "${pageContext.request.contextPath}" + "<%= ViewPaths.MEMBERSHIP_PAY %>";
			var submitSamplesPath = "${pageContext.request.contextPath}"+"<%= ViewPaths.SAMPLES_SUBMISSION %>";
		</script>
		<%-- Google analytics init code--%>
		<script type="text/javascript" src="/js/gainit.min.js"></script>
	</head>
<body>
	<div class="body">
		<input type="hidden" id="sessionTimeout" value="true" />
		<tiles:insertAttribute name="header" />
		<%-- <div class="up" id="information"><a href="#">Request Demo</a>&nbsp;|&nbsp;<spring:message code="registration.header.phone" /></div> --%>
		<noscript>
			<div id="nojavascriptsupport" style="width:100%; background-color:#EEE; height:30px; vertical-align: middle;">
				<span>You have to enable the Javascript to log in our website, thank you.</span>
			</div>
		</noscript>
		<tiles:insertAttribute name="body" />
		<tiles:insertAttribute name="footer"/>
		<div style="clear:both; width:100%; height:1px;"></div>
	</div>
<div class="debug" id="debug"></div>
<!-- POPUP -->
<div class="popupContainer" id="popupContainer"></div>
<div class="overlay" id="overlay"></div>
<tiles:insertAttribute name="login_panel" />
</body>
</html>