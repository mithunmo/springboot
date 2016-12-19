<%@ page import="com.f9g4.web.utils.ViewPaths"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="cbuttons rt npad">
	<c:choose>
		<c:when test="${allowNewSubmission}">
			<a class="cbutton pad large" ng-class="{'disabled':false}" ng-href="${pageContext.request.contextPath}<%=ViewPaths.USER_PROJECTS_CREATE_BOARD%>/{{portfolioId}}/{{contestId}}" tooltip-placement="bottom" tooltip="">New Submission</a>
		</c:when>
		<c:otherwise>
			<a class="cbutton pad large disabled" href="javascript:void(0);" tooltip-placement="bottom" tooltip="Cannot create new submission when project is ${contestStatus}">New Submission</a>
		</c:otherwise>
	</c:choose>
</div>