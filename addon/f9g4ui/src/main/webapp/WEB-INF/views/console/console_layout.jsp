<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page import="com.f9g4.web.utils.ViewPaths"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="x-ua-compatible" content="IE=Edge"/> 
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta name="viewport" content="width=1000, maximum-scale=1.5, user-scalable=1" />
		<title><tiles:importAttribute name="title" /><spring:message code="${title}" /></title>
		<!--[if IE 9]>
	  		<style type="text/css">
	    		.gradient { filter: none; }
	  		</style>
		<![endif]-->
		<link rel="stylesheet" type="text/css" href="/css/ver2.0/console_2.0.css?v=2.00" />
		<%-- <link rel="stylesheet" type="text/css" href="/css/carousel/carousel.css" /> --%>
		<%-- <link rel="stylesheet" type="text/css" href="/css/treeview/jqtree.css" /> --%>
		<link rel="stylesheet" type="text/css" href="/css/custom-theme/jquery-ui-1.8.20.custom_2.0.css" />
		<link rel="stylesheet" type="text/css" href="/css/uploadify/uploadify.css" media="all" />
		<link rel="stylesheet" type="text/css" href="/css/zoom/cloud-zoom.css" />
		<link rel="stylesheet" type="text/css" href="/css/ver2.0/popup_2.0.css" />
		<link rel="stylesheet" type="text/css" href="/css/ver2.0/sidebar_2.0.css" />
		<link rel="stylesheet" type="text/css" href="/css/multiselect/multiple-select.css" />
		<link rel="stylesheet" type="text/css" href="/css/tooltip/jquery.qtip.css" />
		<%-- <link rel="stylesheet" type="text/css" href="/css/jHtmlArea/jHtmlArea.css" /> --%>
		<!--[if IE 8]>
		   <link rel="stylesheet" type="text/css" href="/css/ver2.0/ie8_console_2.0.css" />
		   <link rel="stylesheet" type="text/css" href="/css/ver2.0/ie8_popup_2.0.css" />
		   <link rel="stylesheet" type="text/css" href="/css/uploadify/ie8_uploadify.css" media="all" />
		<![endif]-->
		<!--[if IE 7]>
		   <link rel="stylesheet" type="text/css" href="/css/ver2.0/ie7_console_2.0.css" /> 
		   <link rel="stylesheet" type="text/css" href="/css/ver2.0/ie7_popup_2.0.css" />
		   <link rel="stylesheet" type="text/css" href="/css/ver2.0/ie7_sidebar_2.0.css" />
		   <link rel="stylesheet" type="text/css" href="/css/uploadify/ie8_uploadify.css" media="all" />
		   <link rel="stylesheet" type="text/css" href="/css/custom-theme/ie7_jquery-ui-1.8.20.custom.css" />
		<![endif]-->
		<%-- <link rel="stylesheet" type="text/css" href="/css/ver2.0/ie8_sidebar_2.0.css" /> --%>
		<tiles:insertAttribute name="ajaxPaths" />
		<tiles:insertAttribute name="jsLibraries" />
		<tiles:insertAttribute name="jsCore" />
		<tiles:insertDefinition name="console_js_stp" />
	</head>
	<body>
		<div id="body">
			<tiles:insertAttribute name="console_header" />
			<tiles:insertAttribute name="console_body" />
			<div class="button-holder">
				<div class="button" id="feedbackButton">Feedback</div>
				<div class="button" id="referralButton">Refer a Designer</div>
			</div>
			<tiles:insertAttribute name="console_footer"/>
		</div>
		<!-- sidebar -->
		<div class="sidebar" id="sidebar">
			<div class="left" id="sidebarToggle">
    			<div class="arrow"><i></i><img src="/images/arrow_left.png" /></div>
    			<div class="dashboard-text"><i></i><img src="/images/dashboard.png" /><!-- <span>DASHBOARD</span> --></div>
			</div>
			<div class="content" id="sidebarContent"></div>
		</div>
		<!-- dialog -->
		<!-- <div id="dialog" title="Viewer"></div> -->
		<!-- Popup up -->
		<div class="popupContainer" id="popupContainer"></div>
		<div class="overlay" id="overlay">
			<div class="loading-spinner"><img src="/images/spinner_small.gif"/></div>
		</div>
		<!-- end of popup -->
		
		<!-- Session Expire -->
		<div class="overlay" id="session_overlay"></div>
		<div class="popupContainer" id="session_expire">
			<div class="popup" id="width_session_expire">
				<div class="header">
				Your session is about to expire!
				</div>
				<div class="content" id="popup_session_expire">
					<div>
						<p>You will be logged off in <span id="dialog-countdown"></span> seconds.</p>
						<p>Do you want to continue your session?</p>
						<div class="button" id="continueSession">Yes</div><div class="button orangeButton" id="logout">No</div>
					</div>
				</div>
			</div>
		</div>
		<!--  -->
		
		<!-- Error -->
		<div class="overlay" id="error_overlay"></div>
		<div class="popupContainer" id="error"></div>
		<!-- notification popup -->
		<div class="notifPopup" id="notifPopup">
			<div class="notifPopup-close" id="notifPopupClose">X</div>
			<div class="notifPopup-content" id="notifContent"></div>
		</div>
		<!-- context menu -->
		<div class="context-menu shadow" id="contextMenu"><spring:message code="console.contextmenu" /></div>
		<!-- Debug window -->
		<div class="debug" id="debug"></div>		
	</body>
</html>