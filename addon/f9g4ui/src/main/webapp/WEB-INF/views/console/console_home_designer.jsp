<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.f9g4.web.utils.ViewPaths" %>
<div class="container" id="container">
<input type="hidden" id="userId" value="${userId}" />
<div id="tabs">
	<ul>
		<li><div class="notification" id="new_messages_count"></div><a href="${pageContext.request.contextPath}/messages/1" title="tab_messages" class="li-tab">Messages</a></li>
		<c:if test="${!newPortfolioIdError}">
			<li><div class="notification"></div><a href="${pageContext.request.contextPath}/portfolio" title="tab_manage_portfolio" class="li-tab li-portfolio" data-portfolio-id="${newPortfolioId}" >Portfolio</a></li>
		</c:if>
		<li><div class="notification"></div><a href="${pageContext.request.contextPath}/collections" title="tab_manage_collections" class="li-tab li-collections">Marketplace</a></li>
		<li><div class="notification"></div><span onClick="location.assign('${pageContext.request.contextPath}<%= ViewPaths.USER_PROJECTS_VIEW_PROJECTS%>')" class="li-tab-cust">Projects</span></li>
		<li><div class="notification"></div><a href="${pageContext.request.contextPath}/console/designer_account/0/1/1" title="tab_account" class="li-tab">Account</a></li>
        <li><div class="notification"></div><a href="${pageContext.request.contextPath}/console/activity_designer" title="tab_activity" class="li-tab">Activity</a></li>
        <li><div class="notification"></div><a href="${pageContext.request.contextPath}/console/designer" title="tab_home" class="li-tab">Profile</a></li>
        <li class="hide"><div class="notification"></div><a href="${pageContext.request.contextPath}/console/alerts" title="tab_alerts">Alerts</a></li>
        <li class="hide"><div class="notification"></div><a href="${pageContext.request.contextPath}/console/editdesignerinfo" title="tab_home_edit_mode" user-type="designer">Home Edit</a></li>
        <li class="hide"><div class="notification"></div><a href="${pageContext.request.contextPath}/rating" title="tab_rating" class="li-tab"></a></li>
        <li class="hide"><div class="notification"></div><a href="${pageContext.request.contextPath}/create_board" title="tab_create_board">create board</a></li>
        <li class="hide"><div class="notification"></div><a href="${pageContext.request.contextPath}/create_portfolio" title="tab_create_collection">create collection</a></li>
        <li class="hide"><div class="notification"></div><a href="${pageContext.request.contextPath}/create_portfolio" title="tab_create_portfolio">create portfolio</a></li>
        <li class="hide"><div class="notification"></div><a href="${pageContext.request.contextPath}/board" title="tab_manage_board">Board</a></li>
	</ul>
</div>
</div>