<%@ page import="com.f9g4.web.utils.ViewPaths" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<div class="down">
       	<div class="navi">
       		<a href="${pageContext.request.contextPath}<%= ViewPaths.CONSOLE_HOME %>" target="_blank">Home</a>
           	<a href="${pageContext.request.contextPath}<%= ViewPaths.CONSOLE_ABOUT_US %>" target="_blank"><spring:message code="footer.about_us" /></a>
           	<a href="${pageContext.request.contextPath}<%= ViewPaths.CONSOLE_WORK_WITH_US %>" target="_blank"><spring:message code="footer.work_with_us" /></a>
           	<a href="${pageContext.request.contextPath}<%= ViewPaths.CONSOLE_CONTACT_US%>" target="_blank"><spring:message code="footer.conact_us" /></a>
           	<a href="${pageContext.request.contextPath}<%= ViewPaths.CONSOLE_PRIVACY_POLICY %>" target="_blank"><spring:message code="footer.privacy" /></a>
        </div>
        <div class="copyright">
           	<spring:message code="footer.copyright" />
        </div>
</div>