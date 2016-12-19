<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page import="com.f9g4.web.utils.ViewPaths" %>
<script type="text/javascript">
var appPath="${pageContext.request.contextPath}";
//search
var searchResultPath=appPath+"<%= ViewPaths.SEARCH_RESULT %>";
var searchCriteriaPath=appPath+'<%= ViewPaths.SEARCH_CRITERIA%>';
var saveSearchCriteriaPath=appPath+"<%= ViewPaths.SAVE_SEARCH_CRITERIA %>";
var searchViewerPath=appPath+'<%=ViewPaths.SEARCH_VIEWER%>#marketplaceSubmissions';
//Messages	
var messagesPagePath=appPath+"<%= ViewPaths.MESSAGES%>";
var messageDetailPath=appPath+"<%= ViewPaths.MESSAGE_DETAIL%>";
var sendMessagePath=appPath+"<%= ViewPaths.SEND_MESSAGE%>";
//design wall
var designWallPath=appPath+"<%= ViewPaths.DESIGN_WALL%>";
var referralPath=appPath+"<%= ViewPaths.REFERRALS%>";
//var updateMembershipPath=appPath+"<%= ViewPaths.MEMBERSHIP%>";
var updateMembershipPath=appPath+"<%= ViewPaths.UPDATE_MEMBERSHIP_PAY %>";
var uploadPicturesPath=appPath+"<%= ViewPaths.UPLOAD_JPG%>";
//referral
var submitReferralPath=appPath+"<%= ViewPaths.REFERRALS%>";
var updateReferralPath=appPath+"<%= ViewPaths.MANAGE_REFERRALS%>";
var manageReferralsPath=appPath+"<%= ViewPaths.MANAGE_REFERRALS%>";
var resendReferralNotiPath=appPath+"<%= ViewPaths.RESEND_REFERRAL_NOTIFICATION %>";
//
var chartPath=appPath+"<%= ViewPaths.CHART%>";
var sidebarPath=appPath+"<%= ViewPaths.SIDEBAR%>";
var uploaderPath=appPath+'<%= ViewPaths.UPLOAD_JPG%>';
var seasonYearListPath=appPath+'<%= ViewPaths.SEASON_YEAR_LIST%>';
//var levelListPath=appPath+'<%= ViewPaths.GET_LEVEL_LIST%>';
var categoryListPath=appPath+'<%= ViewPaths.GET_CATEGORY_LIST%>';
var productListPath=appPath+'<%= ViewPaths.GET_PRODUCT_LIST%>';
var productListByPortfolioPath=appPath+'<%= ViewPaths.GET_PRODUCT_LIST_BY_PORTFOLIO%>';
var productTypeListPath=appPath+'<%= ViewPaths.GET_PRODUCT_TYPE_LIST%>';
//shopping cart
var getCartItemPath=appPath+"<%= ViewPaths.SHOW_CART %>";
var addToCartPath=appPath+"<%= ViewPaths.SHOW_CART %>";
var getItemPath=appPath+'<%= ViewPaths.SHOW_CART%>';
var addItemPath=appPath+'<%= ViewPaths.ADD_CART%>';
var deleteItemPath=appPath+'<%= ViewPaths.DELETE_CART%>';
var deleteMultiItemsPath=appPath+'<%= ViewPaths.DELETE_CART_MULTIPLE%>';
//collections
var getPortfolioItemsPath=appPath+'<%= ViewPaths.GET_COLLECTION_ITEMS%>';
var deletePortfolioPath=appPath+'<%= ViewPaths.DELETE_COLLECTION%>';
var managePortfolioPath=appPath+'<%= ViewPaths.CREATE_COLLECTION%>';
var editPortfolioPath=appPath+'<%= ViewPaths.EDIT_COLLECTION%>';
var createPortfolioPath=appPath+'<%= ViewPaths.CREATE_COLLECTION%>';
//portfolio
var manageNewPortfolioPath=appPath+'<%= ViewPaths.CREATE_NEW_PORTFOLIO%>';
var getNewPortfolioItemsPath=appPath+'<%= ViewPaths.GET_NEW_PORTFOLIO_ITEMS%>';
var editNewPortfolioPath=appPath+'<%= ViewPaths.EDIT_NEW_PORTFOLIO%>';
var createNewPortfolioPath=appPath+'<%= ViewPaths.CREATE_NEW_PORTFOLIO%>';
var pBoardPath=appPath+"<%= ViewPaths.NEW_PORTFOLIO_BOARD%>";
//portfolio boards
var createPBoardPath=appPath+'<%= ViewPaths.CREATE_PORTFOLIO_BOARD%>';
var createPBoardWithPortfolioPath=appPath+'<%= ViewPaths.CREATE_PORTFOLIO_BOARD_WITH_PORTFOLIO%>';
//collection boards
var boardPath=appPath+"<%= ViewPaths.BOARD%>";
var boardDetailPath=appPath+"<%= ViewPaths.BOARD_DETAIL%>";
var createBoardPath=appPath+'<%= ViewPaths.CREATE_BOARD%>';
var createBoardWithPortfolioPath=appPath+'<%= ViewPaths.CREATE_BOARD_WITH_PORTFOLIO%>';
var showCommissionPath=appPath+'<%= ViewPaths.SHOW_COMMISSION%>';
var getBoardsByPortfolioIdPath=appPath+'<%= ViewPaths.BOARDS_BY_PORTFOLIO_ID%>';
var deleteBoardPath=appPath+'<%= ViewPaths.DELETE_BOARD%>';
var toggleStatusBoardPath = appPath+'<%= ViewPaths.TOGGLE_STATUS_BOARD%>';
var showPriceGuidelinePath = appPath+'<%= ViewPaths.PRICE_GUIDELINE%>';
var computeBoardExpDatePath= appPath + '<%= ViewPaths.COMPUTE_BOARD_EXP_DATE%>';
var isBoardLockedPath = appPath + '<%= ViewPaths.IS_BOARD_LOCKED %>';
//login
var loginPath=appPath+'<%= ViewPaths.LOGIN%>';
//logout
var logoutPath=appPath+'<%= ViewPaths.LOGOUT%>';
var keepSessionAlivePath=appPath+'<%= ViewPaths.KEEP_SESSION_ALIVE%>';
//registration paths
var DesignerResgistrationTermsPath=appPath+'<%= ViewPaths.DESIGNER_REGISTRATION_TERMS%>';
var CustomerResgistrationTermsPath=appPath+'<%= ViewPaths.CUSTOMER_REGISTRATION_TERMS%>';
var CustomerSaleTermsPath=appPath+'<%= ViewPaths.CUSTOMER_SALE_TERMS%>';
//rating
var ratingPath=appPath+'<%= ViewPaths.RATING %>';
//terms and conditions
var ResgistrationTermsPath=appPath+'<%= ViewPaths.DESIGNER_REGISTRATION_TERMS%>';
//home page
var homepage = appPath+'<%= ViewPaths.CONSOLE_HOME%>'; 
var checkoutPath = appPath + '<%= ViewPaths.CHECKOUT %>';
//user info
var userInfoPath = appPath+'<%= ViewPaths.USER_INFO%>';
//designer account
var designerAccountPath=appPath+"<%= ViewPaths.ACCOUNT%>";
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
//server sent event path
var ssePath=appPath+"/console/sse";
//server sent event alternative path
var sseAltPath=appPath+"/console/sse_alt";
//SSE polling duration
var ssePollingDuration="${sseDuration}";
</script>