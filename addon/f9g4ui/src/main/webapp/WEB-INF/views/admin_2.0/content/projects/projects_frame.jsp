<%@ page import="com.f9g4.web.utils.ViewPaths"%>
<div class="content content-wrapper" ng-controller="adminProjects">
	<div class="content-holder">
		<div class="title">Projects</div>
		<div class="tabs">
			<div class="header">
				<a class="item" ng-class="{selected: tab.createProject}" href="${pageContext.request.contextPath}<%= ViewPaths.ADMIN_PROJECTS_CREATE_PROJECT%>">Create Project</a>
				<a class="item" ng-class="{selected: tab.manageProjects}" href="${pageContext.request.contextPath}<%= ViewPaths.ADMIN_PROJECTS_MANAGE_PROJECTS%>">Manage Projects</a>
				<a class="item" ng-class="{selected: tab.approveSubmissions}" href="${pageContext.request.contextPath}<%= ViewPaths.ADMIN_PROJECTS_APPROVE_SUBMISSIONS%>">Approve Submissions</a>
				<a class="item" ng-class="{selected: tab.messages}" href="javascript:void(0);">Messages</a>
			</div>
			<div class="function">
			</div>
			<div class="body" ng-view>
			</div>			
		</div>
	</div>
</div>
