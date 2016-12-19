<%@ page import="com.f9g4.web.utils.ViewPaths" %>
<div class="splash-header">
	<div class="header-functions">
		<div id="free_trial">US PATENT PENDING</div>
		<div class="right-holder">
			<div class="header-login" id="showLogin"></div>
			<a href="${pageContext.request.contextPath}<%= ViewPaths.REGISTRATION_DESIGNER %>" class="header-signup" id="mapSignUp"></a>
			<div class="header-contact" id="showContactInfo"></div>
			<%-- <a href="${pageContext.request.contextPath}<%= ViewPaths.FAQS %>" class="header-faqs"></a> --%>
			<a href="/faqs.html" class="header-faqs"></a>
			<!-- <img src="/images/splash/login_signup_contact.png" usemap="#funstions-map"></img>
			<map name="funstions-map">
  			<area shape="rect" coords="0,0,140,21" href="javascript:void(0);" title="MEMBERS LOGIN" alt="MEMBERS LOGIN" id="showLogin">
  			<area shape="rect" coords="150,0,219,21" href="javascript:void(0);" title="SIGN UP" class="invitationOnly" alt="SIGN UP" id="mapSignUp">
			</map> -->
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