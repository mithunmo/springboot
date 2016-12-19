<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@ page import="com.f9g4.web.utils.ViewPaths" %> 

<!---Main---------------------------------------------------------------->
<div class="membershipContainer" id="container">
	<div class="contentFrame" style="border-top-left-radius: 40px; height:600px; background-color: #FFF;">
		<div class="popup" id="membership">
			<div class="header">Membership Payment</div>
			<div id="popup_membership">
			    <div class="row space">
			    	<%-- ${showError} ; ${isUpdateMembership} ; ${isNewUser} <br/> --%>
			    	<c:choose>
				    	<c:when test="${showError == false}">
				    		<c:choose>
				    			<c:when test="${isNewUser == false && isUpdateMembership == true}">
				    				<!-- update membership -->
				    				<spring:message code="membership.update.success.msg"></spring:message>
				    			</c:when>
				    			<c:when test="${isNewUser == false && isUpdateMembership == false}">
				    				<!-- update membership -->
				    				<spring:message code="membership.update.success.msg"></spring:message>
				    			</c:when>
				    			<c:when test="${isNewUser == true}">
				    				<spring:message code="membership.success.msg"></spring:message>
				    			</c:when>
				    			<c:otherwise>
				    				<!-- paying membership first time -->
				    				<spring:message code="membership.success.msg"></spring:message>
				    			</c:otherwise>
				    		</c:choose>
				    	</c:when>
				    	<c:otherwise>
				    		<c:choose>
				    			<c:when test="${isNewUser == true}">
				    				<spring:message code="membership.success.msg"></spring:message>
				    			</c:when>
				    			<c:otherwise>
				    				<spring:message code="membership.failure.msg"></spring:message>
				    			</c:otherwise>
				    		</c:choose>
				    	</c:otherwise>
			    	</c:choose>
			    </div>
		  		<c:choose>
	    			<c:when test="${isUpdateMembership == true}">
	    				<!-- update membership -->
	    				<%-- <form action="${pageContext.request.contextPath}<%= ViewPaths.CONSOLE_HOME %>">
							<input type="submit" value="Ok">
						</form> --%>
						<div class="buttonPanel">
							<a href="${pageContext.request.contextPath}<%= ViewPaths.CONSOLE_HOME %>"><div class="button" id="membership_return">OK</div></a>
						</div>
	    			</c:when>
	    			<c:otherwise>
	    				<!-- paying membership first time -->
						<%-- <form action="${pageContext.request.contextPath}<%= ViewPaths.SPLASH_SCREEN %>">
							<input type="submit" value="Ok">
						</form> --%>
						<div class="buttonPanel">
							<a href="${pageContext.request.contextPath}<%= ViewPaths.CONSOLE_HOME %>"><div class="button" id="membership_return">OK</div></a>
						</div>
	    			</c:otherwise>
	    		</c:choose>				
			</div>
		</div>
	</div>
</div>
<!---end of main---------------------------------------------------------->