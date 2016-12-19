<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page import="com.f9g4.web.utils.ViewPaths" %>
<script type="text/javascript">
var appPath="${pageContext.request.contextPath}";
//referral
var referralPath=appPath+"<%= ViewPaths.REFERRALS%>";
var submitReferralPath=appPath+"<%= ViewPaths.REFERRALS%>";
var updateReferralPath=appPath+"<%= ViewPaths.MANAGE_REFERRALS%>";
var manageReferralsPath=appPath+"<%= ViewPaths.MANAGE_REFERRALS%>";
var resendReferralNotiPath=appPath+"<%= ViewPaths.RESEND_REFERRAL_NOTIFICATION %>";
//
var uploadPicturesPath=appPath+"<%= ViewPaths.UPLOAD_JPG%>";
var sidebarPath=appPath+"<%= ViewPaths.SIDEBAR%>";
var uploaderPath=appPath+'<%= ViewPaths.UPLOAD_JPG%>';
//login
var loginPath=appPath+'<%= ViewPaths.LOGIN%>';
//logout
var logoutPath=appPath+'<%= ViewPaths.LOGOUT%>';
var keepSessionAlivePath=appPath+'<%= ViewPaths.KEEP_SESSION_ALIVE%>';
//home page
var homepage = appPath+'<%= ViewPaths.CONSOLE_HOME%>'; 
//user info
var userInfoPath = appPath+'<%= ViewPaths.USER_INFO%>';
//Image Viewer
var imageViewerPath=appPath+"<%= ViewPaths.IMAGE_VIEWER%>";
//Image Size Retriever Path
var imageSizeRetrieverPath=appPath+"<%= ViewPaths.IMAGE_SIZE_RETRIEVER%>";
//Feedback path
var feedbackPath=appPath+"<%= ViewPaths.FEEDBACK_FORM%>";
//Change password popup path
var changePasswordPath=appPath+"<%= ViewPaths.CHANGE_PASSWORD%>";
//view terms path
var viewTermsPath=appPath+"<%= ViewPaths.VIEW_TERMS%>";
var whyCompleteProfilePath=appPath+"<%= ViewPaths.WHY_COMPLETE_PROFILE%>";
//server sent event path
var ssePath=appPath+"/console/sse";
//server sent event alternative path
var sseAltPath=appPath+"/console/sse_alt";
//SSE polling duration
var ssePollingDuration="${sseDuration}";
</script>