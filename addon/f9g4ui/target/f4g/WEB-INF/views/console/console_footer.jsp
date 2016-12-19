<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page import="com.f9g4.web.utils.ViewPaths" %>

<!-- Bottom Panel -->
<div class="bottomPanel" id="footer">
	<!-- <div class="referral"> -->
  <!--   </div> -->
    <div class="bottomNavigation">
        <div class="pos-shift">
        <span style="font-size:12px !important;">US PATENT PENDING</span>
        <%-- 
        <span><a href="${pageContext.request.contextPath}<%= ViewPaths.CONSOLE_ABOUT_US %>"><img src="/images/aboutus.png" alt="About Us"/></a></span>
        <span><a href="${pageContext.request.contextPath}<%= ViewPaths.CONSOLE_WORK_WITH_US %>"><img src="/images/workwithus.png" alt="Work With Us"/></a></span>
        <span><a href="${pageContext.request.contextPath}<%= ViewPaths.CONSOLE_CONTACT_US%>"><img src="/images/contactus.png" alt="Contact Us" /></a></span>
         --%>
        </div>
        <%-- <a href="${pageContext.request.contextPath}<%= ViewPaths.CONSOLE_PRIVACY_POLICY %>"><spring:message code="footer.privacy" /></a> --%>
        <span class="socialButtons">
        	<a href="${footer_urls.footer_linkedin_url}" target="_blank"><img src="/images/LinkedIn.png" /></a>
            <a href="${footer_urls.footer_facebook_url}" target="_blank"><img src="/images/Facebook.png" /></a>
            <a href="${footer_urls.footer_twitter_url}" target="_blank"><img src="/images/Twitter.png" /></a>
            <a href="${footer_urls.footer_rssfeed_url}" target="_blank"><img src="/images/RSS.png" /></a>
        </span>
    </div>
    <div class="copyright">
    	<i></i><span><!-- Copyright&nbsp;&copy;&nbsp;2012. All Rights Reserved. --><img src="/images/copyright.png" alt="Copyright&nbsp;&copy;&nbsp;2012. All Rights Reserved."/></span>
    </div>
</div>
<!-- end of bottom panel -->