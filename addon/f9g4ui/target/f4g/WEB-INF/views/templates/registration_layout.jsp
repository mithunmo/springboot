<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.f9g4.web.utils.ViewPaths" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="x-ua-compatible" content="IE=Edge"/> 
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta name="viewport" content="width=1050, maximum-scale=1.5, user-scalable=1" />
		<title><tiles:importAttribute name="title" /><spring:message code="${title}" /></title>
		<link rel="stylesheet" type="text/css" href="/css/ver2.0/registration_2.0.css" />
		<link rel="stylesheet" type="text/css" href="/css/ver2.0/popup_2.0.css" />
		<link rel="stylesheet" type="text/css" href="/css/uploadify/uploadify.css" media="all" />
		<link rel="stylesheet" type="text/css" href="/css/custom-theme/jquery-ui-1.8.20.custom_2.0.css" />
		<link rel="stylesheet" type="text/css" href="/css/multiselect/multiple-select.css" />
		<link rel="stylesheet" type="text/css" href="/css/tooltip/jquery.qtip.css" />
		<!--[if IE 8]>
		   	<link rel="stylesheet" type="text/css" href="/css/uploadify/ie8_uploadify.css" media="all" />
		   	<style type="text/css">
				body { filter: progid:DXImageTransform.Microsoft.gradient(GradientType=0,startColorstr='#e6e7e8', endColorstr='#ffffff'); /* For IE7-8-9  */}
			</style>
		<![endif]-->
		<!--[if IE 7]>
			<link rel="stylesheet" type="text/css" href="/css/ver2.0/ie7_popup_2.0.css" />
			<link rel="stylesheet" type="text/css" href="/css/ver2.0/ie7_registration_2.0.css" />
			<style type="text/css">
				body { filter: progid:DXImageTransform.Microsoft.gradient(GradientType=0,startColorstr='#e6e7e8', endColorstr='#ffffff'); /* For IE7-8-9  */}
			</style>
		<![endif]-->
		<script type="text/javascript" src="/js/jquery/jquery-1.7.2.min.js"></script>
		<script type="text/javascript" src="/js/jquery/scrollbar/jquery.tinyscrollbar.min.js"></script>
		<script type="text/javascript" src="/js/jquery/uploadify/jquery.uploadify-3.1.min.js"></script>
		<script type="text/javascript" src="/js/jquery/multiselect/jquery.multiple.select.min.js"></script>
		<!--  tooltip -->
		<script type="text/javascript" src="/js/jquery/tooltip/jquery.qtip.min.js"></script>
		<script type="text/javascript" src="/js/popup.min.js?v=2.2"></script>
		<script type="text/javascript" src="/js/reg.min.js?v=1.22"></script>
		<script type="text/javascript" src="/js/ValidationHelper.min.js?v=1.1"></script>
		<script type="text/javascript" src="/js/jquery/browserdetect/detectmobilebrowser.min.js?v=1.0"></script>
		<script type="text/javascript">
			var forgotPwdUrl = "${pageContext.request.contextPath}/user/forgotpwd";
			var consoleHomeUrl = "${pageContext.request.contextPath}/console/home";
			var securityQuestionsUrl = "${pageContext.request.contextPath}/user/questions";
			var termsUrl = "${pageContext.request.contextPath}/user/terms";
			var updateMembershipPath="${pageContext.request.contextPath}"+"<%= ViewPaths.MEMBERSHIP_PAY  %>";
			var invitationFormPath = "${pageContext.request.contextPath}"+"<%= ViewPaths.INVITATION_FORM  %>";
			var setupSeqPasswordPath = "${pageContext.request.contextPath}"+"<%= ViewPaths.SETUP_SEQ_PASSWORD  %>";
			var submitSamplesPath = "${pageContext.request.contextPath}"+"<%= ViewPaths.SAMPLES_SUBMISSION %>";
			var usernameCheckPath = "${pageContext.request.contextPath}"+"<%= ViewPaths.REGISTRATION_USERNAME_CHECK %>";
		</script>
		<%-- Google analytics init code--%>
		<script type="text/javascript" src="/js/gainit.min.js"></script>
	</head>
	<body>
		<div id="body">
			<c:choose>
				<c:when test="${isUpdateMembership == true}">
					<tiles:insertDefinition name="console_header"></tiles:insertDefinition>
				</c:when>
				<c:otherwise>
					<tiles:insertAttribute name="reg_header" />
				</c:otherwise>
			</c:choose>
			<%-- <tiles:insertAttribute name="reg_header" /> --%>
			<tiles:insertAttribute name="reg_body" />
			<c:choose>
				<c:when test="${isUpdateMembership == true}">
					<tiles:insertDefinition name="console_footer"></tiles:insertDefinition>
				</c:when>
				<c:otherwise>
					<tiles:insertAttribute name="reg_footer"/>
				</c:otherwise>
			</c:choose>
			<%-- <tiles:insertAttribute name="reg_footer"/> --%>
		</div>
		<!-- Popup up -->
		<div class="popupContainer" id="popupContainer"></div>
		<div class="overlay" id="overlay"></div>
		<!-- end of popup -->
		<!-- Error Popup -->
		<c:if test="${hasError}">
			<div class="overlay" id="reg_error_overlay"></div>
			<div class="popupContainer" id="reg_error">
				<div class="popup">
					<div class="header"><span id="title">Error</span></div>
					<div class="content" id="error_content">
						<div id="errorContent">
							<%-- ${errorDescription} --%>
							<spring:message code="${errorCode}" />
						</div>
						<div class="buttonPanel" style="width:85%">
							<c:choose>
								<c:when test="${isUpdateMembership == true}">
									<a href="${pageContext.request.contextPath}<%= ViewPaths.CONSOLE_HOME%>#home"><div class="button error_ok" id="error_button_ok" tabindex="0" data="null">Ok</div></a>
								</c:when>
								<c:otherwise>
									<a href="/"><div class="button error_ok" id="error_button_ok" tabindex="0" data="null">Ok</div></a>
								</c:otherwise>
							</c:choose>
						</div>
					</div>
				</div>
			</div>
		</c:if>
		<div class="debug" id="debug"></div>
		<tiles:insertAttribute name="login_panel" />
	</body>
</html>