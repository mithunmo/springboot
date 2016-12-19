<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page import="com.f9g4.web.utils.ViewPaths" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!--  LOGIN PANEL -->
<div id="loginPanel">
	<div class="overlay"></div>
	<div class="content-holder">
		<div id="closeLoginPanel"><a href="javascript:void(0);">Close</a></div>
		<div class="content-holder-title"><img src="/images/splash/members_login.png" title="MEMBERS LOGIN" alt="MEMBERS LOGIN"/></div>
		<form method="post" action="${pageContext.request.contextPath}<%= ViewPaths.LOGIN %>" id="form_login">
		<div class="username">
			<span><spring:message code="login.username.default.msg" /></span>
			<input type="text" name="userName" id="username" placeholder="Please enter your email" value="${username}"/>
			<!-- <input type="text" name="username" id="username"></input> -->
		</div>
		<div class="password">
			<span>PASSWORD</span>
			<input type="password" name="password" id="password" value="${password}"/>
			<!-- <input type="password" name="password" id="password" placeholder="Please enter your password"></input> -->
		</div>
		<div class="remember">
			<c:choose>
				<c:when test="${rememberme == true}">
					<input type="checkbox" name="rememberme" id="remember" checked="checked" tabindex="0"></input><spring:message code="login.remember_me" />
				</c:when>
				<c:otherwise>
					<input type="checkbox" name="rememberme" id="remember" tabindex="0"></input><spring:message code="login.remember_me" />
				</c:otherwise>
			</c:choose>
	    </div>
		<div class="login"><div class="button center" id="submit">LOGIN</div></div>
		<div class="forget-password"><a href="javascript:void(0);" id="link_forget" title="Forget Password">Forgot Password?</a></div>
		</form>
	</div>
</div>