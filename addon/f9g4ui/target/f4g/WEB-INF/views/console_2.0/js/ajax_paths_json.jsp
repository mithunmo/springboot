<%@page import="com.f9g4.web.utils.ModeConstants"%>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@page import="com.f9g4.web.utils.ViewPaths"%>
<script type="text/javascript">
var appPath="${pageContext.request.contextPath}";
var ajaxPaths={
//Buyer projects
	createBuyerProjectPath:appPath+"<%=ViewPaths.BUYER_PROJECTS_CREATE_PROJECT%>"
	,createBuyerProjectContentPath:appPath+"<%=ViewPaths.BUYER_PROJECTS_CREATE_PROJECT_CONTENT%>"
	,viewProjectsPath:appPath+"<%=ViewPaths.USER_PROJECTS_VIEW_PROJECTS%>"
	,viewProjectsContentPath:appPath+"<%=ViewPaths.USER_PROJECTS_VIEW_PROJECTS_CONTENT%>"
	,viewProjectsDataPath:appPath+"<%=ViewPaths.USER_PROJECTS_VIEW_PROJECTS_DATA%>"
	,viewProjectsPortfolioPath:appPath+"<%=ViewPaths.USER_PROJECTS_PORTFOLIO%>"
	,viewProjectsPortfolioContentPath:appPath+"<%=ViewPaths.USER_PROJECTS_PORTFOLIO_CONTENT%>"
	,viewProjectBoardsDataPath:appPath+"<%=ViewPaths.USER_PROJECTS_BOARDS_DATA%>"
	,manageBuyerProjectsPath:appPath+"<%=ViewPaths.BUYER_PROJECTS_MANAGE_PROJECTS%>"
	,manageBuyerProjectsContentPath:appPath+"<%=ViewPaths.BUYER_PROJECTS_MANAGE_PROJECTS_CONTENT%>"
	,viewProjectBoardsPath:appPath+"<%=ViewPaths.USER_PROJECTS_BOARDS%>"
	,viewProjectBoardsContentPath:appPath+"<%=ViewPaths.USER_PROJECTS_BOARDS_CONTENT%>"
//Shopping cart
	,cartPath:appPath+"<%=ViewPaths.SHOW_CART_JSON%>"
	,addCartItemPath:appPath+'<%= ViewPaths.ADD_CART%>'
	,deleteCartItemPath:appPath+'<%= ViewPaths.DELETE_CART%>'
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