<%@page import="com.f9g4.web.utils.ModeConstants"%>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@page import="com.f9g4.web.utils.ViewPaths"%>
<script type="text/javascript">
var appPath="${pageContext.request.contextPath}";
var ajaxPaths={
//Upload util
	uploaderPath:appPath+"<%=ViewPaths.UPLOADER%>"+";jsessionid=${pageContext.session.id}"
//Projects
	,viewProjectsPath:appPath+"<%=ViewPaths.USER_PROJECTS_VIEW_PROJECTS%>"
	,viewProjectsContentPath:appPath+"<%=ViewPaths.USER_PROJECTS_VIEW_PROJECTS_CONTENT%>"
	,viewProjectsDataPath:appPath+"<%=ViewPaths.USER_PROJECTS_VIEW_PROJECTS_DATA%>"
	
	,viewProjectsPortfolioPath:appPath+"<%=ViewPaths.USER_PROJECTS_PORTFOLIO%>"
	,viewProjectsPortfolioContentPath:appPath+"<%=ViewPaths.USER_PROJECTS_PORTFOLIO_CONTENT%>"
	,viewCBDPath:appPath+"<%=ViewPaths.USER_PROJECTS_VIEW_CREATIVE_BRIEF_DETAIL%>"	
	,viewProjectsCreativeViewPath:appPath+"<%=ViewPaths.USER_PROJECTS_CREATIVE_VIEW_BRIEF%>"
	,viewProjectsCreativeViewContentPath:appPath+"<%=ViewPaths.USER_PROJECTS_CREATIVE_VIEW_BRIEF_CONTENT%>"
	,viewProjectsCreativeViewDataPath:appPath+"<%=ViewPaths.USER_PROJECTS_CREATIVE_VIEW_BRIEF_DATA%>"		
	,viewProjectBoardsPath:appPath+"<%=ViewPaths.USER_PROJECTS_BOARDS%>"
	,viewProjectBoardsContentPath:appPath+"<%=ViewPaths.USER_PROJECTS_BOARDS_CONTENT%>"
	,viewProjectBoardsDataPath:appPath+"<%=ViewPaths.USER_PROJECTS_BOARDS_DATA%>"	
	,createProjectBoardPath:appPath+"<%=ViewPaths.USER_PROJECTS_CREATE_BOARD%>"
	,createProjectBoardContentPath:appPath+"<%=ViewPaths.USER_PROJECTS_CREATE_BOARD_CONTENT%>"
	,editProjectBoardPath:appPath+"<%=ViewPaths.USER_PROJECTS_EDIT_BOARD%>"
	,editProjectBoardContentPath:appPath+"<%=ViewPaths.USER_PROJECTS_EDIT_BOARD_CONTENT%>"
	,deleteBoardPath:appPath+"<%=ViewPaths.DELETE_BOARD%>"
	,saveProjectBoardPath:appPath+"<%=ViewPaths.USER_PROJECTS_SAVE_BOARD%>"
//Dashboard
	,dashboardPath:appPath+"<%=ViewPaths.ADMIN_DASHBOARD%>"
	,usersViewerDetailPath:appPath+"<%= ViewPaths.ADMIN_USERS_VIEWER_DETAIL%>"+"?mode="+"<%=ModeConstants.ADMIN_USER_DETAIL_DISABLE_UTILITY%>"
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
	,searchResultPath:appPath+"<%=ViewPaths.SEARCH_RESULT%>"
	,searchCriteriaPath:appPath+'<%=ViewPaths.SEARCH_CRITERIA%>'
	,saveSearchCriteriaPath:appPath+"<%=ViewPaths.SAVE_SEARCH_CRITERIA%>"
	,searchViewerPath:appPath+"<%=ViewPaths.SEARCH_VIEWER%>"
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