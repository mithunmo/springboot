<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page import="com.f9g4.web.utils.ViewPaths" %>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<div class="admin-console-header">
	<a href="${pageContext.request.contextPath}<%= ViewPaths.ADMIN_BOARDS_APPROVAL%>${cancelParams}"><div class="button">Board Approval &amp; Examples</div></a>
	<a href="${pageContext.request.contextPath}<%= ViewPaths.ADMIN_USERS_VIEWER%>"><div class="button">User Approval</div></a>
	<a href="${pageContext.request.contextPath}<%= ViewPaths.ADMIN_REFERRALS_VIEWER%>"><div class="button">Referrals</div></a>
	<a href="${pageContext.request.contextPath}<%= ViewPaths.ADMIN_BROADCAST_ALERT%>"><div class="button">Broadcast Alerts</div></a>
	<a href="${pageContext.request.contextPath}<%= ViewPaths.ADMIN_DASHBOARD%>"><div class="button">Switch to UI 2.0</div></a>
	<a class="admin-console-header-close" href="${pageContext.request.contextPath}<%= ViewPaths.CONSOLE_HOME%>" title="back to user console">X</a>
</div>
