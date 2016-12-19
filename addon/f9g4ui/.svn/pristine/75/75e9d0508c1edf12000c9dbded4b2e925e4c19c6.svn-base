<%@ page import="com.f9g4.web.utils.ViewPaths"%>
<!-- Header -->
<div class="header header-wrapper">
	<div class="header-holder">
		<div class="header-holder-logo"><a href="${pageContext.request.contextPath}<%= ViewPaths.CONSOLE_HOME %>" target="_self"><img src="/images/logo.png" alt="Fashion For Globe"></a></div><!--
		--><div class="header-holder-uprofile">
			<img class="user-logo" src="${user.logoimageurl}" />
			<span class="user-name dropdown" on-toggle="toggled(open)">
				<a href="" class="uname-label dropdown-toggle">
		        	${user.firstname}&nbsp;${user.lastname}<span class="caret"></span>
		      	</a>
				<ul class="dropdown-menu">
					<li>
						<a href="javascript:void(0);">Switch Account</a>
					</li>
					<li class="divider"></li>
					<li>
						<a href="${pageContext.request.contextPath}<%= ViewPaths.ADMIN_BOARDS_APPROVAL%>" target="_self">To Admin Console 1.0</a>
					</li>
					<li>
						<a href="${pageContext.request.contextPath}<%= ViewPaths.CONSOLE_HOME %>" target="_self">To User Console</a>
					</li>
					<li class="divider"></li>
			        <li>
			          	<a href="${pageContext.request.contextPath}<%= ViewPaths.LOGOUT%>" target="_self">Sign Out</a>
			        </li>
			    </ul>
			</span>
		</div><!-- 
		--><div class="header-holder-functions">
			<div class="items">
				<div class="item ${dashboard}"><a href="${pageContext.request.contextPath}<%= ViewPaths.ADMIN_DASHBOARD%>" target="_self">Dashboard</a></div>
				<!-- <div class="item"><a href="javascript:void(0);" target="_self">Members</a></div> -->
				<div class="item"><a href="${pageContext.request.contextPath}<%= ViewPaths.ADMIN_MEMBERS%>" target="_self">Members</a></div>
				<div class="item"><a href="javascript:void(0);" target="_self">Projects</a></div>
				<div class="item ${search_criteria}"><a href="${pageContext.request.contextPath}<%= ViewPaths.ADMIN_SEARCH_CRITERIA%>" target="_self">Search</a></div>
				<div class="item"><a href="${pageContext.request.contextPath}<%= ViewPaths.ADMIN_BOARDS_APPROVAL%>" target="_self">To UI 1.0</a></div>
			</div>
		</div>
	</div>
</div>
