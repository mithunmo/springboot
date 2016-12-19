<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page import="com.f9g4.web.utils.ViewPaths" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="container" id="container">
	<div id="cart_icon">
		<c:choose>
			<c:when test="${cartItems <= 0}">
				<a href="javascript:void(0)" id="add_to_cart"><img src="/images/shoppingcart.png" width="40" height="40" class="cart_icon"/><label id="lblitemCount">${cartItems}</label></a>
			</c:when>
			<c:otherwise>
				<a href="javascript:void(0)" id="add_to_cart"><img src="/images/shoppingcart_full.png" width="40" height="40" class="cart_icon"/><label id="lblitemCount">${cartItems}</label></a>
			</c:otherwise>
		</c:choose>
    </div>
<input type="hidden" id="userId" value="${userId}" />
<div id="tabs">
	<ul>
		<li><div class="notification" id="new_messages_count"></div><a href="${pageContext.request.contextPath}/messages/1" title="tab_messages" class="li-tab">Messages</a></li>
		<!-- <li><div class="notification"></div><a href="#tab_search_criteria" title="tab_search_criteria">Search</a></li> -->
		<li><div class="notification"></div><a href="${pageContext.request.contextPath}<%= ViewPaths.SEARCH_CRITERIA%>" title="tab_search_criteria" class="li-tab">Search</a></li>
        <li><div class="notification"></div><a href="#tab_search_result" title="tab_search_result" class="li-tab">Search Result</a></li>
        <%-- <li><div class="notification"></div><a href="${pageContext.request.contextPath}<%= ViewPaths.SEARCH_RESULT%>" title="tab_search_result">Search Result</a></li> --%>
		<li><div class="notification"></div><a id="userId" href="${pageContext.request.contextPath}/console/design_wall/0/1/1" title="tab_design_wall" class="li-tab">Design Wall</a></li>
        <li><div class="notification"></div><a href="${pageContext.request.contextPath}/console/activity_company" title="tab_activity" class="li-tab">Activity</a></li>
        <li><div class="notification"></div><a href="${pageContext.request.contextPath}/console/compinfo" title="tab_home" class="li-tab">Profile</a></li> 
        <li class="hide"><div class="notification"></div><a href="${pageContext.request.contextPath}/console/alerts" title="tab_alerts">Alerts</a></li>
        <li class="hide"><div class="notification"></div><a href="${pageContext.request.contextPath}/console/editcompinfo" title="tab_home_edit_mode" user-type="company">Home Edit</a></li>
       	<li class="hide"><div class="notification"></div><a href="${pageContext.request.contextPath}/rating" title="tab_rating" class="li-rating"></a></li>
        <li class="hide"><div class="notification"></div><a href="${pageContext.request.contextPath}/checkout" title="tab_shopping_cart">Shopping Cart</a></li>
        <c:if test="${hasAdminMode}">
        	<li><div class="notification"></div><span id="adminMode" class="li-tab-cust" onClick="location.assign('${pageContext.request.contextPath}<%= ViewPaths.ADMIN_DASHBOARD%>')">Admin</span></li>
        </c:if>
	</ul>
	<!-- <div id="tab_search_criteria"></div -->
	<div id="tab_search_result">
		<tiles:insertDefinition name="console_search_result" />
	</div>
</div>
</div>