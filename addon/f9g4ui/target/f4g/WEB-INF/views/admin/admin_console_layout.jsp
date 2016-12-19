<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page import="com.f9g4.web.utils.ViewPaths" %>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<c:if test="${!canRender}">
	<div class="admin-console">
		<tiles:insertAttribute name="admin.console.header"></tiles:insertAttribute>
	</div>
</c:if>
<c:if test="${canRender}">
	<div class="admin-console">
		<tiles:insertAttribute name="admin.console.header"></tiles:insertAttribute>
		<tiles:insertAttribute name="admin.console.body"></tiles:insertAttribute>
	</div>
	<script type="text/javascript">
		var sumbitBoardApprovalPath="${pageContext.request.contextPath}<%= ViewPaths.ADMIN_ADD_BOARDS_APPROVAL%>";
		var viewBoardApprovalPath="${pageContext.request.contextPath}<%= ViewPaths.ADMIN_BOARDS_APPROVAL%>";
		var submitUserApprovalPath="${pageContext.request.contextPath}<%= ViewPaths.ADMIN_USERS_VIEWER%>";
		var usersViewerDetailPath="${pageContext.request.contextPath}<%= ViewPaths.ADMIN_USERS_VIEWER_DETAIL%>";
		var sendMailPath="${pageContext.request.contextPath}<%= ViewPaths.SEND_EMAIL%>";
		var resetTempPasswordPath="${pageContext.request.contextPath}<%= ViewPaths.ADMIN_RESET_PASSWORD%>";
		var getTemplateContentPath="${pageContext.request.contextPath}<%= ViewPaths.ADMIN_BROADCAST_TEMPLATE_CONTENT%>";
		var submitBroadcastMsgPath="${pageContext.request.contextPath}<%= ViewPaths.ADMIN_BROADCAST_ALERT%>";
		var editBoardPath="${pageContext.request.contextPath}<%= ViewPaths.ADMIN_EDIT_BOARD%>";
		var resubmitSamplesPath="${pageContext.request.contextPath}<%= ViewPaths.ADMIN_RESUBMIT_SAMPLES%>";
		var approverCommentsPath="${pageContext.request.contextPath}<%= ViewPaths.ADMIN_APPROVER_COMMENTS%>";
		var adminRatingPath="${pageContext.request.contextPath}<%= ViewPaths.ADMIN_UPDATE_RATING%>";
		$(document).on("click",".viewBigImage",function(e) {
			showEnlargeImage($(this).attr("image-data"));
		});
	</script>
	<script type="text/javascript" src="/js/admin_mode.min.js?v=1.6"></script>
</c:if>