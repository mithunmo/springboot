<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page import="com.f9g4.web.utils.ViewPaths" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div class="profile">
    <div class="title" id="title">
    	<div class="titleHolder">
    		<div class="titleContent">
		        <div class="logo"><a href="${pageContext.request.contextPath}<%= ViewPaths.CONSOLE_HOME %>"><img src="/images/logo_rev.png" id="title-Logo" /></a><div class="logo-subtitle">crowdsourcing creatives</div></div>
		        <div class="hide-title-holder"><span class="hide-title" id="hideTitle"><!-- Hide --></span></div>
		        <div class="loginPanel">
		        	<%-- <span id="phone"><spring:message code="registration.header.phone" /><img src="/images/contactphone.png" alt="CONTACT US AT 1-800-550-0802"/></span> --%>
		        	<a href="${pageContext.request.contextPath}<%= ViewPaths.LOGOUT%>">Sign Out<!-- <img src="/images/signout.png" alt="Sign Out"/> --></a>
		        </div>
		        <div class="function">
		        	<div class="information">
		            HI, <span id="userFirstName">${user.firstname}</span> <span id="userLastName">${user.lastname}</span> 
		            </div>    
		            <%-- <div class="functionLeft">
		               <div><fmt:formatDate pattern="MMM-dd-yyyy" value="${date}" /></div>
		            </div> --%>
		            <%-- <div class="banner">
		                <div class="bannerLogo">
		                	<i></i><img src="${logoImageUrl}" />
		                </div>
		            </div> --%>
		        </div>
	        </div>
        </div>
    </div>
</div>