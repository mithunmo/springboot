<%@ page import="com.f9g4.web.utils.ViewPaths"%>
<div class="content content-wrapper" ng-controller="userProjects">
	<div class="content-holder">
		<div class="title">Projects</div>
		<div class="tabs">
			<div class="header">
				<%-- <a ng-class="{selected: tab.viewProjects}" class="item" href="${pageContext.request.contextPath}<%= ViewPaths.USER_PROJECTS_VIEW_PROJECTS%>">View Projects</a> --%>
				<%-- <a ng-class="{selected: tab.manageProjects}" class="item" href="${pageContext.request.contextPath}<%= ViewPaths.BUYER_PROJECTS_MANAGE_PROJECTS%>">Manage Projects</a> --%>
				<a ng-class="{selected: tab.viewProjectsSubmissions}" class="item" href="${pageContext.request.contextPath}<%= ViewPaths.USER_PROJECTS_VIEW_PROJECTS%>">View Submissions</a>
				<%-- <a class="item" href="${pageContext.request.contextPath}<%= ViewPaths.ADMIN_SEARCH_VIEWER%>#examples">Messages</a> --%>
			</div>
			<div class="function"></div>
			<div class="body" ng-view>
			</div>			
		</div>
	</div>
</div>
