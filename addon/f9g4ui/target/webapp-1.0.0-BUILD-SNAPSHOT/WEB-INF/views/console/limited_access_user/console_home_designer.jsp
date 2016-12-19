<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page import="com.f9g4.web.utils.ViewPaths" %>

<div class="container" id="container">
<input type="hidden" id="userId" value="${userId}" />
<div id="tabs">
	<ul>
		<li><div class="notification" id="new_messages_count"></div><a href="${pageContext.request.contextPath}<%= ViewPaths.CONSOLE_PROFILE_PROGRESS %>" title="tab_get_full_access_messages" class="li-messages li-tab">Messages</a></li>
		<li><div class="notification"></div><a href="${pageContext.request.contextPath}<%= ViewPaths.CONSOLE_PROFILE_PROGRESS %>" title="tab_get_full_access_portfolio" class="li-portfolio li-tab">Portfolio</a></li>
		<li><div class="notification"></div><a href="${pageContext.request.contextPath}<%= ViewPaths.CONSOLE_PROFILE_PROGRESS %>" title="tab_get_full_access_collections" class="li-collections li-tab">Marketplace</a></li>
		<li><div class="notification"></div><a href="${pageContext.request.contextPath}<%= ViewPaths.CONSOLE_PROFILE_PROGRESS %>" title="tab_get_full_access_account" class="li-account li-tab">Account</a></li>
        <li><div class="notification"></div><a href="${pageContext.request.contextPath}<%= ViewPaths.CONSOLE_PROFILE_PROGRESS %>" title="tab_get_full_access_activity" class="li-activity li-tab">Activity</a></li>
        <li><div class="notification"></div><a href="${pageContext.request.contextPath}/console/designer" title="tab_home" class="li-profile li-tab">Profile</a></li>
        <li class="hide"><div class="notification"></div><a href="${pageContext.request.contextPath}/console/alerts" title="tab_alerts">ALERTS</a></li>
        <li class="hide"><div class="notification"></div><a href="${pageContext.request.contextPath}/console/editdesignerinfo" title="tab_home_edit_mode" user-type="designer">Home Edit</a></li>
        <%-- <li class="hide"><div class="notification"></div><a href="${pageContext.request.contextPath}/rating" title="tab_rating" class="li-rating"></a></li> --%>
        <%-- <li class="hide"><div class="notification"></div><a href="${pageContext.request.contextPath}/create_board" title="tab_create_board">create board</a></li> --%>
        <%-- <li class="hide"><div class="notification"></div><a href="${pageContext.request.contextPath}/create_portfolio" title="tab_create_portfolio">create portfolio</a></li> --%>
        <%-- <li class="hide"><div class="notification"></div><a href="${pageContext.request.contextPath}/board" title="tab_manage_board">Board</a></li> --%>
	</ul>
</div>
</div>