<%@ page import="com.f9g4.web.utils.ViewPaths"%>
<div class="content content-wrapper" ng-controller="userProjects">
	<div class="content-holder">
		<div class="title">My Work</div>
		<div class="tabs">
			<div class="header">
				<a ng-class="{selected: tab.viewProjects}" class="item" href="${pageContext.request.contextPath}<%= ViewPaths.USER_PROJECTS_VIEW_PROJECTS%>">View Projects</a>
				<a ng-class="{selected: tab.viewProjectsSubmissions}" class="item" href="${pageContext.request.contextPath}<%= ViewPaths.USER_PROJECTS_PORTFOLIO%>">Project Submissions</a>
				<a ng-class="{selected: tab.manageProjects}" target="_self" class="item" href="${pageContext.request.contextPath}<%= ViewPaths.TAB_COLLECTION%>">Marketplace</a>
				<a target="_self" class="item" href="${pageContext.request.contextPath}<%= ViewPaths.TAB_PORTFOLIO%>">Portfolio</a>
			</div>
			<div class="function"></div>
			<div class="body" ng-view>
			</div>			
		</div>
	</div>
</div>
