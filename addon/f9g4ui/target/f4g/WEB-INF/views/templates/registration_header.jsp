<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="com.f9g4.web.utils.ViewPaths" %>

<!---header-------------------------------------------------------------->
<%-- <div class="profile">
    <div class="title" id="title">    
        <div class="logo">
        	<a href="${pageContext.request.contextPath}/user/login"><img src="/images/Small-Logo.gif" style="margin-left:2px;width:138px;height:88px;"/></a>
        </div>
        <div class="function">
	        <div class="information">
	        Registration
	            <div class="loginPanel">
	            <span id="phone"><spring:message code="registration.header.phone" /></span> | <a href="javascript:void(0);" id="livechat"><spring:message code="registration.header.chat" /></a>
	            </div>
	        </div>
        </div>
    </div>
</div> --%>
<!---End of header------------------------------------------------------->

<div class="splash-header">
	<div class="header-functions">
		<div id="free_trial">US PATENT PENDING</div>
		<div class="right-holder">
			<div class="header-login" id="showLogin"></div>
			<a href="${pageContext.request.contextPath}<%= ViewPaths.REGISTRATION_DESIGNER %>" class="header-signup" id="mapSignUp"></a>
			<div class="header-contact" id="showContactInfo"></div>
			<%-- <a href="${pageContext.request.contextPath}<%= ViewPaths.FAQS %>" class="header-faqs"></a> --%>
			<a href="/faqs.html" class="header-faqs"></a>
			<%-- <img src="/images/splash/login_signup_contact.png" usemap="#funstions-map"></img>
			<map name="funstions-map">
  			<area shape="rect" coords="0,0,140,21" href="javascript:void(0);" title="MEMBERS LOGIN" alt="MEMBERS LOGIN" id="showLogin">
  			<area shape="rect" coords="150,0,219,21" href="#" title="SIGN UP" alt="SIGN UP">
			</map> --%>
		</div>
	</div>
	<div class="logo">
		<%-- <a href="${pageContext.request.contextPath}<%= ViewPaths.LOGIN %>"><img src="/images/logo3.png"/></a> --%>
		<a href="/"><img src="/images/logo3.png"/></a>
	</div>
	<div class="header-buttons">
		<a href="javascript:void(0);" class="invitationOnly" id="who"></a>
		<a href="javascript:void(0);" class="invitationOnly" id="what"></a>
		<%-- <a href="javascript:void(0);" class="invitationOnly" id="how"></a> --%>
		<a href="javascript:void(0);" class="invitationOnly" id="freeDemo"></a>
		<a href="http://fashionforglobe.wordpress.com/" data-outbound-link="true" id="blog"></a>
		<a href="javascript:void(0);" id="wptf"></a>
	</div>
</div>
