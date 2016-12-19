<%@page import="com.f9g4.web.utils.ModeConstants"%>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@page import="com.f9g4.web.utils.ViewPaths"%>
<script type="text/javascript">
var appPath="${pageContext.request.contextPath}";
var ajaxPaths={
//Dashboard
	dashboardPath:appPath+"<%=ViewPaths.ADMIN_DASHBOARD%>"
	,usersViewerDetailPath:appPath+"<%= ViewPaths.ADMIN_USERS_VIEWER_DETAIL%>"+"?mode="+"<%=ModeConstants.ADMIN_USER_DETAIL_DISABLE_UTILITY%>"
//Portfolio pages
	,searchViewerPath:appPath+"<%=ViewPaths.ADMIN_SEARCH_VIEWER%>"
//List
	,specialtyListPath:appPath+"<%=ViewPaths.SPECIALTY_LIST%>"
	,langListPath:appPath+"<%=ViewPaths.LANGUAGE_LIST%>"
	,skillListPath:appPath+"<%=ViewPaths.SKILL_LIST%>"
	,expertiseListPath:appPath+"<%=ViewPaths.EXPERTISE_LIST%>"
	,educationListPath:appPath+"<%=ViewPaths.EDUCAION_LIST%>"
//Boards
	,boardDetailPath:appPath+"<%=ViewPaths.BOARD_DETAIL_JSON%>"
//Misc
	,categoryListPath:appPath+'<%=ViewPaths.GET_CATEGORY_LIST%>'
	,productListPath:appPath+'<%=ViewPaths.GET_PRODUCT_LIST%>'
	,productTypeListPath:appPath+'<%=ViewPaths.GET_PRODUCT_TYPE_LIST%>'
//Search
	,searchResultPath:appPath+"<%=ViewPaths.ADMIN_SEARCH_RESULT%>"
	,searchCriteriaPath:appPath+'<%=ViewPaths.ADMIN_SEARCH_CRITERIA%>'
	,saveSearchCriteriaPath:appPath+"<%=ViewPaths.SAVE_SEARCH_CRITERIA%>"
//Message utility
	,sendMailPath:appPath+"<%= ViewPaths.SEND_EMAIL%>"
//Image Viewer
	,imageViewerPath:appPath+"<%= ViewPaths.IMAGE_VIEWER%>"
//Image Size Retriever Path
	,imageSizeRetrieverPath:appPath+"<%= ViewPaths.IMAGE_SIZE_RETRIEVER%>"
//Server sent event path
	,ssePath:appPath+"/console/sse"
//Server sent event alternative path
	,sseAltPath:appPath+"/console/sse_alt"
//SSE polling duration
	,ssePollingDuration:"${sseDuration}"
};
</script>