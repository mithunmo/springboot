// JavaScript Document
var basicConfig = { 
	"debugMode":false, //set to true to enable debug panel
	"writeLogToConsole":false,
	"disableRightClick":false, 
	"enableSorting":true,
	"enableSSE":true
};
var appConfig = { 
	"ver":3.0, 
	"ratyImgPath":"/images/raty_img", 
	"shoppingCartImgPath":"/images/shoppingcart.png", 
	"shoppingCartFullImgPath":"/images/shoppingcart_full.png",
	"sidebarCloseDuration":5000 //in milliseconds
	//"enableLIChecking":false
};
/*Idle timer parameters*/
var idleTimerConfig = { "idleTime":1500, "pollingTime":300, "warningTime":300, "idleTimeoutDebugMode":false};
var globalVars = {
	"isWindowFocus":false,
	"hasClicked":0,
	"prePortfolioName":"",
	//shopping cart
	"cart":null,
	//flag to determine the user change the data without submit
	"isChangedWithoutSubmit":false,
	"isSidebarOpened":false,
	"title":document.title,
	"sidebarTimer":null,
	"lockObject":{
		'portfolio':0,
		'collections':0
	},
	'tabNamesTable':undefined
};

//search result related settings
var searchResult;
var searchResultProp = { "currentPage":0, "totalPages":0, "itemsPerPage":8, "searchCriteria":null, "sortOption":1, "isNewRequest":false, "previousSelectedIndex":0}; //8 items per page for now

//collections result
var collectionsResult = { "data":null, "imageList":null, "visible":null};
var collectionsProp = { "currentPage":0, "totalPages":0, "itemsPerPage":8, "portfolioId":-1, "preloadPortfolioId":-1, "forceToReload":false};
//portfolio result
var portfolioResult = { "data":null, "imageList":null, "visible":null};
var portfolioProp = { "currentPage":0, "totalPages":0, "itemsPerPage":8, "portfolioId":-1, "preloadPortfolioId":-1, "forceToReload":false};

//boards result related settings
var boardsResult = { "portfolioId":null, "data":null, "visible":null};
var boardProp = { "currentPage":0, "totalPages":0, "itemsPerPage":8, "forceToReload":false};

//empty message html layout
var layoutTemplate = {
"emptyPortfolioMsg":'<div class="empty" style="width:320px;"><i></i><span><a href="javascript:void(0)" id="add_manage_portfolio" data-mode="c" style="color:#C30">Click here</a>&nbsp;to create your first portfolio!</span></div>',
"emptyBoardMsg":'<div class="empty"><i></i><span><a href="javascript:void(0)" id="add_manage_board" style="color:#C30">Click here</a>&nbsp;to add your first board!</span></div>',
"emptyPortfolioBoardMsg":'<div class="empty"><i></i><span><a href="javascript:void(0)" id="add_manage_page" style="color:#C30">Click here</a>&nbsp;to create your first page!</span></div>',
"reqPortfolioBoardMsg":'<div class="empty w opa"><i></i><a href="javascript:void(0);" class="close">CLOSE</a><span>You must have 3 published portfolio images to complete this segment of your profile and become visible to buyers.</span></div>',
"invisibleDesignerMsg":'<div class="empty w opa"><i></i><a href="javascript:void(0);" class="close">CLOSE</a><span>Please complete <a class="act" href="#portfolio_page_0_1">your portfolio</a> to become visible to buyers. Thank you.</span></div>',
"loadingMsg":'<div class="loadingSpinner"><span><img src="/images/spinner.gif" /></span></div>',
"loadingPortfolioMsg":'<div class="loadingSpinner"><span><img src="/images/spinner.gif" /><br />Loading Portfolio Items...</span></div>',
"basicConsoleFrame":'<div class="contentFrame">'
	+'<div class="content" id="basicContent">'
	+'<div class="loadingSpinner"><span><img src="/images/spinner.gif" /></span></div>' //loadingMsg
	+'</div>'
	+'</div>',
"basicConsoleFrameWithHeader":'<div class="contentFrame" id="basicFrame">'
	+'<div class="content-function"></div>'
	+'<div class="content with-header">'
	+'<div class="loadingSpinner"><span><img src="/images/spinner.gif" /></span></div>' //loadingMsg
	+'</div>'
	+'</div>',
"errorStyle":"color:#FF0000",
/*Message List*/
"optionDefaultMsg":'<option value="-1">-Please select one option-</option>',
"optionDefaultMsgWithDontCare":'<option value="-1">-Please select one option-</option><option value="-1">-Ignore-</option>',
"optionDefaultMsgWithDisabledAttr":'<option value="-1" disabled="disabled">-Please select one option-</option>',
"optionLoadingMsg":'<option value="-1" disabled="disabled">Loading...</option>',
"optionDefaultCategory":'<option value="-1">-Please select Division above-</option>',
"optionDefaultProduct":'<option value="-1">-Please select Category above-</option>',
"optionDefaultProductWithDontCare":'<option value="-1">-Please select Category above-</option><option value="-1">-Ignore-</option>',
"optionDefaultProductType":'<option value="-1" disabled="disabled">-Please select Product above-</option>',
"optionDefaultProductTypeWithDontCare":'<option value="-1" disabled="disabled">-Please select Product above-</option><option value="-1">-Ignore-</option>',
"optionEmpty":'<option value="-1" disabled="disabled">--Empty--</option>',
"optionEmptyWithDisabledAttr":'<option value="-1" disabled="disabled">--Empty--</option>',
"emptyPage":'<div class="empty"><i></i><span>Empty Page<br />Please Select Another Page</span></div>',
"loadingPopup":'<span style="color:blue;">Please wait....<span><br /><img src="/images/spinner_small.gif" style="margin-top:30px;"/>',
"sidebarLoading":'<div class="sidebar-loading"/>',
"downloadHint":'<div class="download-hint">Your download will begin shortly.</div>'
};

//messages
var messagesProp={
'confirmation_continue':' Would you like to continue?',
'save_create_pboard_confirmation':'Clicking OK will save this page to your portfolio, but will NOT be reviewed by a FFG Administrator.',
'publish_create_pboard_confirmation':'Clicking OK will save this page to your Portfolio, and will be reviewed by a FFG Administrator.',
'save_create_board_confirmation':'This board will <span style="color:#F00">NOT</span> be published to the Marketplace.<br/>Would you like to continue?<br/>If you would like your board to be visible in the Marketplace, you must select "Save & Publish."',
'publish_create_board_confirmation':'Clicking Ok will publish this board to the Marketplace.',
'number_only':'Credits can only be entered as whole numbers. Be sure not to include any decimals or other characters in this field.'
};

//server-sent event
var sseUtility = {
	"source": null,
	"eventAlertsTS": "",
	"eventMessagesTS": "",
	"pollingMode": false
};

//tooltip config
var tooltipConfig={
	position: {
		target: 'mouse',
		my:'Top Center',
		at:'Bottom Center',
		adjust: {
			screen:true,
			mouse:true,
			x:5,
			y:20
		}
	},
	style: {
		classes: 'qtip-blue qtip-shadow',
		tip: false 
	} 
};

//bind the disabled button event
$(document).on("click",".button, a",function(e) {
	if($(this).attr('disabled')=="disabled" || $(this).attr('disabled')=="true" || $(this).attr('button-disabled')=="true") {
		logging("disable button event hooked!");
		e.stopImmediatePropagation(); //stop event bubble up to the document level.
	}
});
$(document).ready(function()
{
	//SSE handler
	initSSE();

	var winHeight=$(window).height();
	//logging("LI=>"+sessionStorage.LI+" ; LUUI=>"+sessionStorage.LUUI);
	logging("main running.."+appConfig.ver);
	logging("Browser Version:"+window.navigator.userAgent);
	//initialize the idel timeout plugin for session
	initIdleTimeoutPlugin();
	//init live query to init cloud zoom (live query help other plug-ins to bind on future element.  
	$('.cloud-zoom').livequery(function() {
		$(this).CloudZoom();
	});
	//init tooltip
	var initTag=['.text-wrapper','.item-label','.detail .board_name','.item-function .board_name','.messageBoardId','.shoppingCartBoardId','.drawer_boardId','.checkoutBoardId','.messageDetailBoardId','.detail .name','.designWallBoardId','#designWallTiles .touchArea','.designerAccountBoardId','.boards_suggestion_boardId','.gridBoardId','span[title]','.show-qtip'];
	$(initTag.join(',')).livequery(function() {
		$(this).qtip(tooltipConfig);
	});
	//Force to close the tooltip if the tooltip did not disappear automatically.
	$(document).on('click','.qtip',function() {
		$(this).css('display','none');
	});
	//disable mouse right click and show custom context menu=======================================
	if(basicConfig.disableRightClick)
	{
		$(document).bind("contextmenu",function(e)
		{
			if(e.target.id!='contextMenu') {
				$('#contextMenu').css({
					'top': e.clientY,
					'left':e.clientX
				});
				$('#contextMenu').show();
			}
			return false;
		});
	}
	
	//context menu close handler
	$(window).bind('click',function(e) {
		//if the #context menu is shown up and not in the context menu, make it disappear
		if(e.target.id!='contextMenu')
			$('#contextMenu').hide();
	});
	
	//open the sidebar, and close automatically after duration
	/*openSidebar(function() {
		//Automatically close sidebar.
		globalVars.sidebarTimer = setTimeout(function() {
			closeSidebar();
		},appConfig.sidebarCloseDuration);
	});*/
	
	//bind the window load and focus event to check session=====================
	$(window).bind("load",function()
	{
		logging("load","#F00");
		//logging("load");
		checkSession();
	});
	$(window).bind("focus",function()
	{
		if(!globalVars.isWindowFocus) //check now the window is focus or not
		{
			logging("focus","#F00");
			//logging("focus");
			checkSession();
		}
		globalVars.isWindowFocus=true;
	});
	$(window).bind("blur",function()
	{
		globalVars.isWindowFocus=false;
	});
	$(window).bind("beforeunload",function(e)
	{
		logging("trigger beforeunload","#F00");
		//unfocus current input
		$("input").blur();
		$("textarea").blur();
		//logging($("#tabs").tabs('option', 'selected'));
		var selectedTabTitle = $($("#tabs li")[$("#tabs").tabs('option', 'selected')]).text();
		//logging(selectedTabTitle);
		if(globalVars.isChangedWithoutSubmit || isChangedWithoutSubmitOnPopup)
		{
			logging(globalVars.isChangedWithoutSubmit+" ; "+isChangedWithoutSubmitOnPopup);
			return "Do you want to leave the page without saving";
		}
	});
	//bind input fields related to tabs to check user modify the data
	$(document).on("change","#form_create_board input",function()
	{
		globalVars.isChangedWithoutSubmit=true;
	});
	$(document).on("change","#form_edit_profile input, #form_edit_profile select",function()
	{
		globalVars.isChangedWithoutSubmit=true;
	});
	$(document).on("change","#form_create_portfolio input",function()
	{
		globalVars.isChangedWithoutSubmit=true;
	});
	$(document).on("change","#messageContent",function()
	{
		globalVars.isChangedWithoutSubmit=true;
	});
	$(document).on("change","#replyForm input",function()
	{
		globalVars.isChangedWithoutSubmit=true;
	});
	//bind input fields related to popup to check user modify the data
	$(document).on("change",".popup input[type=text]",function()
	{
		isChangedWithoutSubmitOnPopup=true;
	});
	$(document).on("change",".popup textarea",function()
	{
		isChangedWithoutSubmitOnPopup=true;
	});
	//Prevent the click event on cloud zoom
	$(document).on("click",".cloud-zoom",function(e) {
		e.preventDefault();
	});
	//===========================================================================
	//Minimize title event
	/*$(document).on("click","#hideTitle",function() {
		//decrease the height of the title
		$("#title .titleContent .logo img").animate({height:'50px',width:'auto'});
		$("#title .titleContent").animate({height:'60px'});
		$("#title .titleContent").animate({width:'990px'});
		$("#title .titleHolder").animate({height:'60px'});
		$("#title").animate({height:'60px'});
		//change the logo size
		$("#title .logo img").fadeIn();
	});*/
	//attach the data of title size on div #title
	$('#title').data("mode","max");
	resize(); //call resize event to render the title area.

	//initialize the tabs========================================================
	$("#tabs").tabs(
	{
		spinner: "Loading..",
		fx: {opacity: 'toggle',duration: "fast"},
		select:function(e,ui)
		{
			$('#profileScore').qtip('hide'); //hide the qtip
			removeTabsFocusClass("tab_manage_portfolio"); //remove the css class of portfolio tab header
			removeTabsFocusClass("tab_manage_collections"); //remove the css class of collection tab header
			removeTabsFocusClass("tab_home");
			selectTabHeader("tab_rating","hide"); //hide the tab header
			if(globalVars.isChangedWithoutSubmit)
			{
				e.preventDefault();
				//show confirmation window
				showConfirmation("You are about to leave the page with unsaved data, Would you like to continue?","Confirmation","changedWithoutSave",{
					"onOk":function() {
						closePopupMsg();
						//set the flag false;
						globalVars.isChangedWithoutSubmit=false;
						//trigger the event
						$("#tabs").tabs("select",ui.index);
					}
				});
				/*$("body").bind("changedWithoutSave",function(changeEvent)
				{	
					if(changeEvent.trigger=="ok")
					{
						//set the flag false;
						globalVars.isChangedWithoutSubmit=false;
						//trigger the event
						$("#tabs").tabs("select",ui.index);
					}
					$("body").off("changedWithoutSave");
				});*/
			}
			else
			{
				checkSession();
				var tab=ui.tab.hash;
				var tabSelectHandler = {
					"#tab_home":function() {
						$(tab).html(layoutTemplate.basicConsoleFrame); //show loading message
						location.hash="#home";
						//$("#tabs").tabs("load",getIdByName("tab_home"));
					},
					"#tab_home_edit_mode":function() {
						$(tab).html(layoutTemplate.basicConsoleFrame); //show loading message
						selectTabHeader("tab_home");
						$("#tab_home_edit_mode").html(layoutTemplate.basicConsoleFrame); //show loading message
					},
					"#tab_search_criteria":function() {
						location.hash="#search_criteria";
						//load search criteria page if the tab content is empty
						if($("#tab_search_criteria").html()=="")
						{
							$(tab).html(layoutTemplate.basicConsoleFrame); //show loading message
							logging("LOAD SEARCH CRITERIA"+getIdByName("tab_search_criteria"),"#F00");
							//$("#tabs").tabs("url",getIdByName("tab_search_criteria"),searchCriteriaPath);
						}
						else
						{
							//enable the cache for search criteria after the first time loading
							logging("enable cache","#F00");
						    var currentTabAnchor = $("#tabs").data('tabs').anchors[1];
						    $(currentTabAnchor).data('cache.tabs', true);
						}
					},
					"#tab_activity":function() {
						$(tab).html(layoutTemplate.basicConsoleFrame); //show loading message
						location.hash="#activity";
					},
					"#tab_design_wall": function() {
						location.hash="#design_wall_0_3_-1"; //default is desc by Date purchased
						$("#tab_design_wall").html(layoutTemplate.basicConsoleFrame); //show loading message
					},
					"#tab_alerts":function() {
						$("#tab_alerts").html(layoutTemplate.basicConsoleFrame); //show loading message
						location.hash='#alerts';
						$("#tabs").tabs("load",getIdByName("tab_alerts"));
					},
					"#tab_messages":function() {
						logging("show message loading..","#F00");
						$("#tab_messages").html(layoutTemplate.basicConsoleFrame); //show loading message
						location.hash='#messages_page_1';
					},
					"#tab_manage_portfolio":function() {
						$("#tab_manage_portfolio").html(layoutTemplate.basicConsoleFrameWithHeader); //show loading message
						navigate($('.li-portfolio'),true);
					},
					"#tab_manage_collections":function() {
						//location.hash='#portfolio_page_0_1';
						//show loading message
						$("#tab_manage_collections").html(layoutTemplate.basicConsoleFrameWithHeader); //show loading message
						//$('#portfolio_mask').html('<div class="data">'+layoutTemplate.loadingMsg+'</div>');
					},
					"#tab_create_portfolio":function() {
						selectTabHeader("tab_manage_portfolio");
						$("#tab_create_portfolio").html(layoutTemplate.basicConsoleFrame); //show loading message
					},
					"#tab_create_collection":function() {
						selectTabHeader("tab_manage_collections");
						$("#tab_create_collection").html(layoutTemplate.basicConsoleFrame); //show loading message
					},
					"#tab_search_result":function() {
						syncMarket(); //synchronize the item status with shopping cart and search result.
					},
					"#tab_manage_board":function() {
						$("#tab_manage_board").html(layoutTemplate.basicConsoleFrame); //show loading message
						if($(ui.tab).attr('data-mode').toLowerCase()=='c')
							selectTabHeader("tab_manage_collections");
						else
							selectTabHeader("tab_manage_portfolio");
					},
					"#tab_create_board":function() {
						$("#tab_create_board").html(layoutTemplate.basicConsoleFrame); //show loading message
						if($(ui.tab).attr('data-mode').toLowerCase()=='c')
							selectTabHeader("tab_manage_collections");
						else
							selectTabHeader("tab_manage_portfolio");
					},
					"#tab_account":function() {
						location.hash="#designer_account_0_5_-1"; //default is desc by Date sold.
						$("#tab_account").html(layoutTemplate.basicConsoleFrame); //show loading message
					},
					"#tab_shopping_cart":function() {
						$("#tab_shopping_cart").html(layoutTemplate.basicConsoleFrame); //show loading message
					},
					"#tab_rating":function() {
						$("#tab_rating").html(layoutTemplate.basicConsoleFrame); //show loading message
					}
				}
				logging("SELECT tabName="+tab);
				globalVars.hasClicked++;
				if(globalVars.hasClicked>=1)
					closeSidebar();
				if(typeof(tabSelectHandler[tab])==="function")
					tabSelectHandler[tab]();
				else
					logging("Undefined tab name");
			}
		},
		load: function(e,ui)
		{
			var tab=ui.tab.hash;
			var tabLoadHandler = {
				"#tab_search_criteria":function() {
					searchCriteriaTabHandler();
				},
				"#tab_search_result":function() {
					logging("show search result");
				},
				"#tab_design_wall":function() {
					initTiles({
						"id":"#designWallTiles",
						"xSpace":150,
						"ySpace":20
					},function(){
						$("#design_wall_scrollbar").tinyscrollbar_update('relative');
					},0);
				},
				"#tab_account":function() {
					initTiles({
						"id":"#accountTiles",
						"xSpace":150,
						"ySpace":20
					},function(){
						$("#account_scrollbar").tinyscrollbar_update('relative');
					},0);
				},
				"#tab_messages":function() {
					//init autosize plugin
					//$("textarea").autosize();
					//show messageTile
					if($("#messages_scrollbar")!=undefined) {
						$("#messages_scrollbar").tinyscrollbar({
							scrollChanged: function (scroll) {
								if(scroll.position().top>-510)
									$("#messages .messages-header").fadeOut();
								else
									$("#messages .messages-header").fadeIn();
							}
						});
						initTiles({},function(){
							$("#messages_scrollbar").tinyscrollbar_update('relative');
						},0);
					}
				},
				"#tab_activity_designer":function() {
					logging("activity designer tab");
					//initializa raty
					init_raty_activity();
					//initialize chart graph=====================================
					initChart(chartPath+"/7");
					//disable the Chart link
					disableChartLink("#chart_week");
				},
				"#tab_activity_company":function(){
					logging("activity designer tab");
					//initializa raty
					init_raty_activity();
					//initialize chart graph=====================================
					initChart(chartPath+"/7");
					//disable the Chart link
					disableChartLink("#chart_week");
				},
				"#tab_activity":function(){
					//initializa raty
					init_raty_activity();
					//initialize chart graph=====================================
					initChart(chartPath+"/7");
					//disable the Chart link
					disableChartLink("#chart_week");
				},
				"#tab_rating_designer":initRaty,
				"#tab_rating_company":initRaty,
				"#tab_rating":initRaty,
				"#tab_manage_portfolio":function() {
					if(globalVars.lockObject.portfolio+1>=2) {
						if($(ui.tab).attr('data-portfolio-id')==undefined) {
							if(location.hash.search("#portfolio_page")==-1) {
								location.hash='#portfolio_page_0_1';
							}
							else {
								getPortfolioItemsByPage(portfolioProp.currentPage,true,function() {
									globalVars.lockObject.portfolio=0;
								},{
									//Setup options for new portfolio 
									'container':'#tab_manage_portfolio',
									'mask':'#portfolio_mask',
									'url':getNewPortfolioItemsPath,
									'pageProp':portfolioProp,
									'data':portfolioResult,
									'paginHandler':undefined,
									'paginContainer':'#manage_portfolio_pagin',
									'paginPrefix':'#portfolio_page',
									'renderMode':'p'
								});
							}
						}
						else {
							globalVars.lockObject.portfolio=0; //release the token
							triggerHash('#pboard_page_'+$(ui.tab).attr('data-portfolio-id')+'_0_1');
						}
					}
					else {
						globalVars.lockObject.portfolio++;
					}
				},
				"#tab_manage_collections":function() {
					if(globalVars.lockObject.collections+1>=2) {
						logging("acquire 2 locks in load");
						if(location.hash.search("#collections_page")==-1)
							location.hash='#collections_page_0_1';
						else {
							getPortfolioItemsByPage(portfolioProp.currentPage,true,function() {
								logging("release mutex lock in load");
								globalVars.lockObject.collections=0;
							},{
								'paginPrefix':'#collections_page'
							});
						}
					}
					else {
						logging("collections give lock in load");
						globalVars.lockObject.collections++;
					}
				},
				"#tab_manage_board":function() {
					//get boards data(ajax call)
					getBoardsByPage(boardsResult.portfolioId,boardProp.currentPage,boardProp.forceToReload,$(ui.tab).attr('data-mode'));
				},
				"#tab_create_board":function()
				{
					logging("load create board tab");
					//if the edit mode, do not refresh the product and product list
					if($("#portfolioId").attr('edit-mode')==undefined || $("#portfolioId").attr('edit-mode')==false)
						$("#portfolioId").trigger("change"); //trigger the change event to get the level
					else
						$('.sale-type-credit').trigger('keyup');
					categoryMSInit();
				},
				"#tab_create_collection":function() {
					//logging("load create portfolio tab");
					//initSeasonsList('radio');
					//TODO call getCatagorylist
					if($("#form_division").attr('edit-mode')!='true') {
						getCategoryList($("#form_division").val(),{
							"haveDontCareTag":false
						});
					}
					//set the portfolio name of prePortfolioName
					//$("#form_name_of_portfolio").val(globalVars.prePortfolioName);
					//clear the prePortfolioName
					//globalVars.prePortfolioName="";
				},
				"#tab_create_portfolio":function() {
					//logging("load create portfolio tab");
					//initSeasonsList('radio');
					//TODO call getCatagorylist
					if($("#form_division").attr('edit-mode')!='true') {
						getCategoryList($("#form_division").val(),{
							"haveDontCareTag":false
						});
					}
					//set the portfolio name of prePortfolioName
					//$("#form_name_of_portfolio").val(globalVars.prePortfolioName);
					//clear the prePortfolioName
					//globalVars.prePortfolioName="";
				},
				"#tab_home_edit_mode":function() {
					editProfileTabHandler($(ui.tab));
				},
				"#tab_home":function() {
					//init scroll bar if there exsit
					$("#skill_scrollbar").tinyscrollbar();
					$("#lang_scrollbar").tinyscrollbar();
					$("#about_you_scrollbar").tinyscrollbar();
					$("#misc_scrollbar").tinyscrollbar();
					$("#adoc_scrollbar").tinyscrollbar();
				},
				"#tab_alerts":function() {
					$("#alert_scrollbar").tinyscrollbar();
				}
			}
			if(typeof(tabLoadHandler[tab])==="function")
				tabLoadHandler[tab]();
			else
				logging("Undefined tab name");
		//End of load event handler======================================================
		},
		show: function(e,ui)
		{
			//show tab name=========================================================
			var tab=ui.tab.hash;
			var tabShowHandler= {
				"#tab_search_criteria":function() {
					searchCriteriaTabHandler();
				},
				"#tab_activity":function() {
					logging("set raty value");
					//initialize raty plugin====================================
					init_raty_activity();
				},
				"#tab_manage_portfolio":function() {
					if(globalVars.lockObject.portfolio+1>=2) {
						if($(ui.tab).attr('data-portfolio-id')==undefined) {
							if(location.hash.search("#portfolio_page")==-1) {
								location.hash='#portfolio_page_0_1';
							}
							else {
								getPortfolioItemsByPage(portfolioProp.currentPage,true,function() {
									globalVars.lockObject.portfolio=0;
								},{
									//Setup options for new portfolio 
									'container':'#tab_manage_portfolio',
									'mask':'#portfolio_mask',
									'url':getNewPortfolioItemsPath,
									'pageProp':portfolioProp,
									'data':portfolioResult,
									'paginHandler':undefined,
									'paginContainer':'#manage_portfolio_pagin',
									'paginPrefix':'#portfolio_page',
									'renderMode':'p'
								});
							}
						}
						else {
							globalVars.lockObject.portfolio=0;
							triggerHash('#pboard_page_'+$(ui.tab).attr('data-portfolio-id')+'_0_1');
						}
					}
					else {
						globalVars.lockObject.portfolio++;
					}
					logging('<span style="color:#FF0000">content=>'+$("#portfolio_mask .data").html()+'</span>');
				},
				"#tab_manage_collections":function() {
					if(globalVars.lockObject.collections+1>=2) {
						logging("acquire 2 locks in show");
						if(location.hash.search("#collections_page")==-1)
							location.hash='#collections_page_0_1';
						else {
							getPortfolioItemsByPage(portfolioProp.currentPage,true,function() {
								logging("release mutex lock in show");
								globalVars.lockObject.collections=0;
							},{
								'paginPrefix':'#collections_page'
							});
						}
					}
					else {
						logging("collections give lock in show");
						globalVars.lockObject.collections++;
					}
				},
				"#tab_manage_board":function() {
					logging("Show Manage Boards=>"+portfolioProp.portfolioId);
				},
				"#tab_create_board":function() {
					logging("SHOW CREATE BOARD");
					//$("#portfolioId").trigger("change"); //trigger the change event to get the level
					//initialize the option of "JPG+AI" to input field
					categoryMSInit();
				},
				"#tab_create_portfolio":function() {
				},
				"#tab_search_result":function() {
					logging("sync shopping cart and market.");
					syncMarket(); //synchronize the item status with shopping cart and search result.
					/*if(searchResult==undefined || searchResult.length<=0)
					{
						var timeout;
						buildPopupMsg({
							"title":"Hint",
							"content":'<span style="color:#C30">Please redefine your search criteria. Thank you.<br/>(Will close in 5 seconds.)</span>',
							"onOk":function() {
								closePopupMsg();
								triggerHash("#search_criteria");
								clearTimeout(timeout);
							},
							"onClose":function() {
								closePopupMsg();
								triggerHash("#search_criteria");
								clearTimeout(timeout);
							},
							"onShow":function(){
									timeout=setTimeout(function (){
									closePopupMsg();
									triggerHash("#search_criteria");
								},5000);
							}
						});
					}*/
				},
				"#tab_messages":function() {
					//init autosize plugin
					//$("textarea").autosize();
					//show messageTile
					if($("#messages_scrollbar")!=undefined) {
						$("#messages_scrollbar").tinyscrollbar({
							scrollChanged: function (scroll) {
								if(scroll.position().top>-510)
									$("#messages .messages-header").fadeOut();
								else
									$("#messages .messages-header").fadeIn();
							}
						});
						initTiles({},function(){
							$("#messages_scrollbar").tinyscrollbar_update('relative');
						},0);
					}
				},
				"#tab_home":function() {
					//init scroll bar if there exsit
					$("#skill_scrollbar").tinyscrollbar();
					$("#lang_scrollbar").tinyscrollbar();
					$("#about_you_scrollbar").tinyscrollbar();
					$("#misc_scrollbar").tinyscrollbar();
					$("#adoc_scrollbar").tinyscrollbar();
				},
				"#tab_home_edit_mode":function() {
					editProfileTabHandler($(ui.tab));
				},
				"#tab_shopping_cart":function() {
					$("#checkout_scrollbar").tinyscrollbar();
				},
				"#tab_rating":function() {
					removeTabsFocusClass("tab_rating","hide");
				},
				"#tab_alerts":function() {
					$("#alert_scrollbar").tinyscrollbar();
				}
			}
			if(typeof(tabShowHandler[tab])==='function')
			{
				logging("Execute "+tabShowHandler[tab]+" handler");
				tabShowHandler[tab]();
			}
			else
				logging("Undefined tab name handler");
		}
	});
	//
	if(getIdByName('tab_search_result')!=-1)
	{
		$("#tabs").tabs("disable","tab_search_result"); //hide search result tab
	}
	//if the hash is empty string, select the messages tab
	if(location.hash=="")
	{
		getCart();
		$("#tabs").tabs("select","tab_messages"); //select messages tab first
		//triggerHash('#messages_page_1');
	}
	//Search criteria ===================================================================
	//event----------------------------------------------------------
	$(document).on("click keydown","#submit_search_criteria",function()
	{
		var formData=$('#form_search_criteria').serialize();
		formData = formData + '&timestamp='+$.now(); //add timestamp
		getSearchResult(formData,0,{
			"onLoad":function() {
				$('#searchCriteriaLoadingPanel').fadeIn(0); //show loading message
			},
			"onSuccess":function() {
				searchResultProp.searchCriteria=encodeURIComponent(formData); //save in the cache.
				searchResultProp.isNewRequest=true; //Force the search result page to reload.
				location.hash="#search_page_0_2/"+encodeURIComponent(formData);
			},
			"onEmptyResult":function() {
				buildPopupMsg({
					"content":"Your search did not return any results.<br/>Please redefine search criteria.",
					"showOk":true,
					"title":"No search result"
				});
			},
			"onError":function(result) {
				buildPopupMsg({
					"content":result.errorDescription,
					"showOk":true,
					"title":"Error"
				});
			}
		});
	});
	$(document).on("click","#link_save_search_criteria",function(e)
	{
		//close sidebar
		closeSidebar();
		buildPopup({
			"url":saveSearchCriteriaPath
		});
	});
	$(document).on("change","#form_open_saved_searches",function(e)
	{
		if(this.value!="") //if the value in this form is not equal to null, load the search options
		{
			logging("select searches=>"+this.value);
		}
	});
	//division change event
	$(document).on("change","#form_division_search_criteria",function(e)
	{
		//reset the drop down menu
		$("#form_product").html(layoutTemplate.optionDefaultProduct);
		$("#form_product_type").html(layoutTemplate.optionDefaultProductType);
		getCategoryList(e.target.value,{
			"haveDontCareTag":false
		});
	});
	//category change event
	$(document).on("change","#form_category",function(e)
	{
		//logging("category change");
		getProductList(e.target.value,{
			"haveDontCareTag":false
		});
	});
	//product change event
	$(document).on("change","#form_product",function(e)
	{
		//logging("product change");
		var level1Id = $('#form_division_search_criteria').val();
		var level2Id = $('#form_category').val();
		var parentName = e.target.value;
		getProductTypeList(level1Id,level2Id,parentName,{
			"haveDontCareTag":false,
			"data":'level1='+level1Id+'&level2='+level2Id+'&productTags='+encodeURIComponent(parentName),
			"rememberOldValue":false
		});
	});
	//clear button
	$(document).on("click","#clear_search_criteria",function()
	{
		//reset the form
		$("#form_search_criteria")[0].reset();
		$("#form_skills").val("");
		$("#form_spl").val("");
		$("#form_exp").val("");
		$("#form_languages").val(""); //select default language as english
		$("#form_skills,#form_languages,#form_spl,#form_exp").multipleSelect('refresh'); //refresh multiple select component
		//reload the seasons list
		//initSeasonsList("checkbox");
		//trigger division drop down to refresh the component.
		$('#form_division_search_criteria').trigger('change');
		
	});
	//Enter key event to call getSearchResult()
	/*$(document).on("keydown",'#form_search_criteria',function(e)
	{
		if(e.which==13) //enter key event
		{
			var formData=$('#form_search_criteria').serialize();
			getSearchResult(formData);
		}
	});*/
	//End of search criteria===========================================================
	
	//Search Result click and button event==============================================
	$(document).on("click","#back_search_criteria",function()
	{
		//remove search result tabs
		logging("back");
		$("#tabs").tabs("enable","tab_search_criteria"); //enable search criteria tab		
		$("#tabs").tabs("select","tab_search_criteria"); //select search result tab
		$("#tabs").tabs("disable","tab_search_result"); //disable search tab
	});
	$(document).on("click",".add_to_cart",function(e)
	{
		moveToCart(e.currentTarget.id); //show the animation from board to shopping cart
	});
	$(document).on("click","#add_to_cart",function(e)
	{
		//close sidebar
		closeSidebar();
		buildPopup({
			"url":addToCartPath
		},function () {
			$(".popup .entity").tinyscrollbar();
		});
	});
	$(document).on("click","#empty_search_ok",function(e)
	{
		//select search criteria tab
		logging("back");
		$("#tabs").tabs("enable","tab_search_criteria"); //enable search criteria tab		
		$("#tabs").tabs("select","tab_search_criteria"); //select search result tab
		$("#tabs").tabs("disable","tab_search_result"); //disable search tab
	});
	//nail event---------------------------------------------------------
	$(document).on("click",".nailBoardLink",function(e)
	{
		logging("boardLink clicked","#0F0");
		logging("hash=>"+location.hash,"#0F0");
		logging("data=>"+$(this).attr("data"),"#0F0");
		var targetboardId=$(this).attr("data");
		//triggerPopupHash('#nail_'+targetboardId);
		triggerHash('#search_page_'+searchResultProp.currentPage+'_'+searchResultProp.sortOption+'/'+searchResultProp.searchCriteria+'/#nail_'+targetboardId);
	});
	//mouseenter event to show the focus effect
	$(document).on("mouseenter","#content .item",function(e)
	{
		$(this).addClass("shadow");
		//$(e.currentTarget.parentNode).toggleClass("hover");
		/*$(e.currentTarget.parentNode).css(
		{
			"background-color":"#DDD"
		});*
		//set the target item css
		/*$(e.currentTarget.parentNode).animate(
		{
			"background-color":"#DDD"
		},"fast"); //set the target item css
*/	});
	//mouseenter event to hide the focus effect
	$(document).on("mouseleave","#content .item",function(e)
	{
		$(this).removeClass("shadow");
		//$(e.currentTarget.parentNode).toggleClass("hover");
		/*$(e.currentTarget.parentNode).css(
		{
			"background-color":"white"
		}); //set the target item css
*/		/*$(e.currentTarget.parentNode).animate(
		{
			"background-color":"white"
		},"fast"); //set the target item css
*/	});
	//prev button event handler
	$(document).on("mouseenter",".touchbar",function(e)
	{
		//logging("touch "+e.currentTarget.id);
		$(this).addClass("appear");
		$(this).removeClass("disappear");
		$(this).animate(
		{
			"opacity":0.4
		},0);
	});
	$(document).on("mouseleave",".touchbar",function(e)
	{
		//logging("touch "+e.currentTarget.id);
		$(this).addClass("disappear");
		$(this).removeClass("appear");
		$(this).animate(
		{
			"opacity":0
		},0);
	});
	$(document).on("click","#search_carouselNext",function(e)
	{
		logging('next');
		
		logging("Current page=>"+searchResultProp.currentPage,"#00F");
		searchResultProp.currentPage++;
		if(searchResultProp.currentPage>=searchResultProp.totalPages)
			searchResultProp.currentPage=0;
		//change the hash
		location.hash="#search_page_"+(searchResultProp.currentPage)+"_"+$('#sortSearchResult').val()+"/"+searchResultProp.searchCriteria;
	});
	$(document).on("click","#search_carouselPrev",function(e)
	{
		logging('prev');
		
		logging("Current page=>"+searchResultProp.currentPage,"#00F");
		searchResultProp.currentPage--;
		if(searchResultProp.currentPage<0)
			searchResultProp.currentPage=searchResultProp.totalPages-1;
		//change the hash
		location.hash="#search_page_"+(searchResultProp.currentPage)+"_"+$('#sortSearchResult').val()+"/"+searchResultProp.searchCriteria;
	});
	//sorting
	$(document).on("change","#sortSearchResult",function(e)
	{
		logging("sort search result=>"+this.value);
		location.hash="#search_page_"+(searchResultProp.currentPage)+"_"+this.value+"/"+searchResultProp.searchCriteria;
		//sortSearchResult(this.value,true);
	});
	//End of search result==============================================================
	
	//Hash Change Event to set data in search result==================================
	$(window).hashchange(function(e)
	{
		hashChange();
	});
	$(window).hashchange(); //trigger hash change event
	
	//resize event event listener==================================================
	$(window).resize(function()
	{
		resize();
		//update the sidebar scroll bar size if the sidebar is expanded.
		if(globalVars.isSidebarOpened)
			$("#sidebar_scrollbar").tinyscrollbar_update();
	});
	//sidebar=======================================================================
	//click function
 	$(document).on("click","#sidebarToggle",function()
	{
		if(globalVars.isSidebarOpened==false)
		{
			openSidebar();
		}
		else
		{
			closeSidebar();
		}
		//logging("sideBar click=>"+globalVars.isSidebarOpened);
	});
	//mouseenter event to show effect
	$(document).on("mouseenter","#sidebarToggle",function(e)
	{
		$("#sidebarToggle").toggleClass("selected");
		/*$("#sidebarToggle").css(
		{
			"backgroundColor":"#DDD"
		});*/
		/*$("#sidebarToggle").animate(
		{
			"background-color":"#DDD"
		},100);*/
	});
	//mouseleave event to hide effect
	$(document).on("mouseleave","#sidebarToggle",function(e)
	{
		$("#sidebarToggle").toggleClass("selected");
		/*$("#sidebarToggle").css(
		{
			"backgroundColor":"#bdcbd4"
		});*/
		/*$("#sidebarToggle").animate(
		{
			"background-color":"#bdcbd4"
		},100);*/
	});
	$(document).on("mouseenter","#sidebar",function(e)
	{
		//clear timeout
		if(globalVars.isSidebarOpened) {
			clearTimeout(globalVars.sidebarTimer);
		}
	});
	$(document).on("mouseleave","#sidebar",function(e)
	{
		if(globalVars.isSidebarOpened) {
			//Automatically close sidebar.
			globalVars.sidebarTimer = setTimeout(function() {
				closeSidebar();
			},appConfig.sidebarCloseDuration);
		}
	});
	$(document).on("click","#sidebar_alerts",function(e)
	{
		logging("alerts");
		triggerHash("#alerts");
		//$("#tabs").tabs("select","tab_alerts");
	});
	$(document).on("click","#sidebar_messages",function(e)
	{
		logging("messages");
		//$("#tab_messages").html(basicConsoleFrame); //show loading message
		//change hash
		triggerHash("#messages_page_1");
		//location.hash="#messages_page_1";
	});
	$(document).on("click",".drawer_boardId",function(e)
	{
		logging("board id=>"+$(this).attr("data"));
		//show boardDetail popup
		showWindow($(this).attr("data"));
	});
	//Viewer event===================================================================
	//Pic viewer control
	$(document).on("click","#prevItem",function()
	{
		logging($("#prevItem").attr("href"));
		location.hash=$("#prevItem").attr("href"); //reset the hash
	});
	
	$(document).on("click","#nextItem",function()
	{
		logging($("#nextItem").attr("href"));
		location.hash=$("#nextItem").attr("href"); //reset the hash
	});
	
	//=====REFERRAL BUTTON EVENT===============================================
	$(document).on("click","#referralButton",function()
	{
		logging("referral button click");
		//close sidebar
		closeSidebar();
		buildPopup({
			"url":referralPath
		});
	});
	
	
	//Home and Edit mode for both users=======================================================================
	$(document).on("click","#update_membership",function() //update membership event
	{
		logging("update membership");
	});
	$(document).on("click","#update_new",function(e) { //update new picture event	
		logging("update new image");
		//close sidebar
		closeSidebar();
		buildUploadPopup({
			"url": uploadPicturesPath,
			"mode":"LOGO",
			"filetype":"ai",
			"previewArea":"#previewImage",
			"onUploadSuccess":function(result) {
				//event handler when upload finish
				logging("USER LOGO UPLOAD FINISHED=>"+e.filename_400);
				if(result.filestatus!=-1) {
					//set the flag
					globalVars.isChangedWithoutSubmit=true;
					//save the filename in hidden area
					$("#form_logo_image_url").val("/400x400/"+result.filename_400);
					$("#previewImage").html('<i></i><img src="/400x400/'+result.filename_400+'" />');
				}
			}
		});
	});
	$(document).on("click","#manage_referrals",function(e)
	{
		logging("manage referrals");
		//close sidebar
		closeSidebar();
		buildPopup({
			"url":manageReferralsPath
		},function() {
			$(".popup .entity").tinyscrollbar();
		});
	});
	$(document).on("click","#change_password",function(e)
	{
		//display the change password pop-up
		buildPopup({
			'url':changePasswordPath
		});
	});
	$(document).on("click","#submitChangePassword",function(e)
	{
		submitChangePasswordForm();
	});
	
	//disallow user to enter space in password field
	$(document).on("keydown",'input[type=password]',function(e) {
		if(e.which==32)
			return false;
	});
	
	$(document).on("keyup","#newPwd",function(e)
	{
		$("#result").html(checkStrength($("#newPwd").val()));
	});
	$(document).on("click","#view_terms",function() {
		//show popup for terms
		buildPopup({
			"url":viewTermsPath
		}, function() { 
			$("#termScrollbar").tinyscrollbar();
			$(".anchor").each(function(index) {
				$(".rightArea .block:nth-child("+(index+1)+")").animate({top:$(this).position().top});
			});
		});
	});
	//event handler when upload finish
	/*$(document).on("upload_finished","body",function(e)
	{
		logging("USER LOGO UPLOAD FINISHED=>"+e.filename_400);
		if(e.filestatus!=-1)
		{
			//set the flag
			globalVars.isChangedWithoutSubmit=true;
			//save the filename in hidden area
			$("#form_logo_image_url").val("/400x400/"+e.filename_400);
			$("#previewImage").html('<i></i><img src="/400x400/'+e.filename_400+'" />');
		}
	});*/
	//Edit mode----------------------------------------------------------
	//format the website url. If the user didn't put the http:// in front of the address, add it automatically.
	$(document).on("change","#website",function() 
	{
		 if (!/^http:\/\//.test(this.value)) 
		 {	 
	            this.value = "http://" + this.value;
		 }
		 if (!/^https:\/\//.test(this.value)) 
		 {	 
	            this.value = "https://" + this.value;
		 }
	});
	$(document).on('change','#form_country',function() {
		if($(this).val()!=238) {
			//disable state
			$('#form_state').attr('disabled','disabled');
			$('#form_state').parent().addClass('inactive');
		}
		else {
			//enable state
			$('#form_state').removeAttr('disabled');
			$('#form_state').parent().removeClass('inactive');
		}
	});
	//Home for company----------------------------------------------------
	//Event Handler
	$(document).on("click","#edit_profile_company",function(e)
	{
		logging("show edit mode");
		$("#tabs").tabs("select","tab_home_edit_mode");
	});
	$(document).on("click","#save_company",function(e)
	{
		doSaveCompany();
	});
	$(document).on("click","#cancel_company",function(e)
	{
		logging("cancel company");
		$("#tabs").tabs("select","tab_home");
	});
	
	//Home for designer----------------------------------------------------
	//event handler
	$(document).on("click","#edit_profile_designer",function(e)
	{
		$("#tabs").tabs("select","tab_designer_home_edit_mode");
	});
	$(document).on("click","#save_designer",function(e)
	{
		doSaveDesigner();
	});
	$(document).on("click","#cancel_designer",function(e)
	{
		logging("cancel designer");
		$("#tabs").tabs("select","tab_home");
	});
	//upload additional document
	$(document).on('click','#upload_doc',function(e) {
		buildUploadPopup({
			"url":uploadPicturesPath,
			"mode":"files",
			"filetype":"files",
			"previewArea":"",
			"onUploadSuccess":function(result) {
				//add a record to the result section
				$('#file_result').html('<div class="added-file">'+result.original_filename+'<span class="added-file-delete" data="1"></span></div>');
				$('#adoc_oname').val(result.original_filename);
				$('#adoc_type').val(result.filename_ext);
				$('#adoc_iname').val(result.filename);
			}
		});
	});
	$(document).on('click','.added-file-delete',function(e) {
		$('#file_result').html("").removeClass('added-file');
		$('#adoc_oname').val("");
		$('#adoc_type').val("");
		$('#adoc_iname').val("");
	});
	
	//prefile progress instant checking
	$(document).on('keyup change','#form_edit_profile input, #form_edit_profile select, #form_edit_profile textarea, #form_logo_image_url',function(e) {
		profileScore();
	});
	$('#profileScore').livequery(function() {
		$(this).qtip({
			position: {
				my:'right center',
				at:'center left',
				adjust: {
					screen:true,
					mouse:false
				}
			},
			content: {
				text: $('#qtipDataCarrier').html()
			},
			style: {
				classes: 'qtip-light qtip-shadow'
			},
			show: {
				event: 'click focus'
			},
			hide: {
				event: ''
			}
		});
	});
	$(document).on('click','.profile-progress-why',function(e) {
		buildPopup({
			"url":whyCompleteProfilePath,
			"onClose":function() {
				$('#profileScore').qtip('show');
			}
		});
	});
	
	//add others value to multiple select
	$(document).on('click','.ms-add-other-button',function(e) {
		addOtherToMS($(this));
	});
	//education and specialty change event handler
	$(document).on('change','#form_education, #form_specialty, #form_expertise',function(e) {
		updateInput($(this));
	});
	function updateInput(target) {
		if(target.val()=='-2') {
			//enable other filed
			target.next().removeClass('hide');
			target.next().removeAttr('disabled').focus();
		}
		else {
			//disable other filed
			target.next().addClass('hide');
			target.next().attr('disabled','disabled');
		}
	}
	//End of home========================================================================
	
	//DESIGN WALL========================================================================
	$(document).on("change","#select_sort_design_wall",function(e)
	{
		logging("SORT=>"+e.currentTarget.value);
		//get the value of sorting and direction
		var sort_column=e.currentTarget.value;
		var sort_direction=1;
		location.hash="#design_wall_0_"+sort_column+"_"+sort_direction;
	});
	$(document).on("click",".userinfo",function(e)
	{
		logging("click user id=>"+encodeURIComponent($(this).attr("data")));
		//close sidebar
		closeSidebar();
		//show user info popup
		buildPopup({
			"url":userInfoPath+"?profileUserName="+encodeURIComponent($(this).attr("data"))+"&profileUserId="
		},function() {
			$(".popup .entity").tinyscrollbar();
		});
	});
	$(document).on("click",".designWallBoardId",function(e)
	{
		logging("click board id=>"+$(this).attr("data"),"#FF0");
		//show boardDetail popup
		showWindow($(this).attr("data"));
	});
	$(document).on("click","#designWallTiles .Tile .touchArea",function(e) {
		showWindow($(this).attr("data"));
	});
	$(document).on("mouseenter","#designWallTiles .Tile",function(e) {
		$(this).addClass("hover");
	});
	$(document).on("mouseleave","#designWallTiles .Tile",function(e) {
		$(this).removeClass("hover");
	});
	$(document).on("click","#designWallTiles .Tiles-next",function(e) {
		nextTile({
			"id":"#designWallTiles"
		});
	});
	$(document).on("click","#designWallTiles .Tiles-pre",function(e) {
		prevTile({
			"id":"#designWallTiles"
		});
	});
	$(document).on('click','.download-button',function(e) {
		if($('.downloadHint').length<=0)
			$('body').append(layoutTemplate.downloadHint);
		else
			$('.downloadHint').fadeIn(0);
		var timeout = setTimeout(function() {
			$('.download-hint').fadeOut(1000);
		},3000);
	});
	//End of design wall=================================================================
	
	//DESIGNER ACCOUNT========================================================================
	$(document).on("change","#select_sort_account",function(e)
	{
		logging("SORT=>"+$(this).val());
		//get the value of sorting and direction
		var sort_column=$(this).val();
		var sort_direction=1;
		location.hash="#designer_account_0_"+sort_column+"_"+sort_direction;
	});
	$(document).on("click",".designerAccountBoardId",function(e)
	{
		logging("click board id=>"+$(this).attr("data"),"#FF0");
		//show boardDetail popup
		showWindow($(this).attr("data"));
	});
	$(document).on("click",".designerAccountUserId",function(e)
	{
		logging("click user id=>"+encodeURIComponent($(this).attr("data")));
		//close sidebar
		closeSidebar();
		//show user info popup
		buildPopup({
			"url":userInfoPath+"?profileUserName="+"&profileUserId="+encodeURIComponent($(this).attr("data"))
		},function () {
			$(".popup .entity").tinyscrollbar();
		});
	});
	$(document).on("click","#accountTiles .Tile .touchArea",function(e) {
		showWindow($(this).attr("data"));
	});
	$(document).on("mouseenter","#accountTiles .Tile",function(e) {
		$(this).addClass("hover");
	});
	$(document).on("mouseleave","#accountTiles .Tile",function(e) {
		$(this).removeClass("hover");
	});
	$(document).on("click","#accountTiles .Tiles-next",function(e) {
		nextTile({
			"id":"#accountTiles"
		});
	});
	$(document).on("click","#accountTiles .Tiles-pre",function(e) {
		prevTile({
			"id":"#accountTiles"
		});
	});
	//End of designer account=================================================================
	
	//Rating=============================================================================
	$(document).on("click","#submit_rating",function(e)
	{
		logging("submit rating designer");
		var formData=$("#form_rating").serialize();
		$.ajax({
			url: ratingPath,
			type:"POST",
			data: formData,
			beforeSend: function() {
				logging("Show Loading message");
				//show loading popup
				buildPopupMsg({
					"content": '<span style="color:blue;">Please wait...<span><br /><img src="/images/spinner_small.gif" style="margin-top:30px;"/>',
					"title": "Please Wait",
					"showOk": false,
					"closeByOverlay": false,
					"effect":false
				});
			},
			success: function(result) {
				if(result.hasError)
				{
					buildPopupMsg({
						"content":result.error,
						"showOk":true
					});
				}
				else
				{
					buildPopupMsg({
						"content":"Thank you for your rating.",
						"title":"Rate successfully",
						"showOk":true,
						"onOk": function(){
							closePopupMsg();
							triggerHash("#messages_page_1");
						},
						"onClose":function(){
							triggerHash("#messages_page_1");
						}
					});
				}
			},
			error: function() {
				buildPopupMsg({
					"content":"Submit error, please try again.",
					"showOk":true
				});
			}
		});
	});
	
	$(document).on("click","#cancel_rating",function(e)
	{
		logging("cancel rating designer");
		$("#tabs").tabs("select","tab_alerts"); //back to alerts tab
	});
	
	$(document).on("click",".backHistory",function(e){
		history.back();
	});
	
	$(document).on("click",".ratingUserInfo",function(e){
		//show user info popup
		buildPopup({
			"url":userInfoPath+"?profileUserName="+"&profileUserId="+encodeURIComponent($(this).attr("data"))
		},function () {
			$(".popup .entity").tinyscrollbar();
		});
	});
	
	$(document).on("click",".ratingBoardInfo",function(e){
		showWindow($(this).attr("data"));
	})
	//End of rating===================================================================================================
	
	//Messages Tab=====================================================================================================
	var sorting_messages_all="ASC";
	var sorting_messages_newest="ASC";
	$(document).on("click","#messages_all",function(e)
	{
		if(sorting_messages_all=="ASC")
		{
			$("#messages_all_arrow").addClass("upArrow");
			sorting_messages_all="DSC";
			logging("all messages DSC");
		}
		else
		{
			$("#messages_all_arrow").removeClass("upArrow");
			sorting_messages_all="ASC";
			logging("all messages ASC");
		}
	});
	$(document).on("click","#messages_newest",function(e)
	{
		if(sorting_messages_newest=="ASC")
		{
			$("#messages_newest_arrow").addClass("upArrow");
			sorting_messages_newest="DSC";
			logging("newest messages DSC");
		}
		else
		{
			$("#messages_newest_arrow").removeClass("upArrow");
			sorting_messages_newest="ASC";
			logging("newest messages ASC");
		}
	});
	//board item click event hadler, when user click the board name and images, it will show the popup.
	$(document).on("click",".messageBoardId",function(e)
	{
		logging("board id=>"+$(this).attr("data"));
		showWindow($(this).attr("data"));
	});
	//form user name click event handler, when user click the from user name and logo, it will show the popup.
	$(document).on("click",".messages_fromUserId",function(e)
	{
		logging("from user id=>"+$(this).attr("data")+" ; path=>"+userInfoPath+"?profileUserName=&profileUserId="+$(this).attr("data"));
		//close sidebar
		closeSidebar();
		//show user info popup
		buildPopup({
			"url":userInfoPath+"?profileUserName=&profileUserId="+$(this).attr("data")
		},function () {
			$(".popup .entity").tinyscrollbar();
		});
	});
	$(document).on("click","#messageTiles .Tile .touchArea",function(e) {
		triggerHash("#message_detail_"+$(this).attr("data"));
	});
	$(document).on("mouseenter","#messageTiles .Tile",function(e) {
		$(this).addClass("hover");
	});
	$(document).on("mouseleave","#messageTiles .Tile",function(e) {
		$(this).removeClass("hover");
	});
	$(document).on("click","#messageTiles .Tiles-next",function(e) {
		nextTile({});
	});
	$(document).on("click","#messageTiles .Tiles-pre",function(e) {
		prevTile({});
	});
	//End of messages tab===============================================================================================
	
	//Message Detail Tab==========================================================================
	$(document).on("click","#send_reply",function(event) //when user click the reply link, replace the reply link into reply function
	{
		sendMessageInMessageDetail();
	});
	$(document).on("click","#back_to_messages",function(e)
	{
		if(globalVars.isChangedWithoutSubmit)
		{
			showConfirmation("You are about to leave the page with unsaved data, Would you like to continue?","Confirmation","changedWithoutSave",{
				"onOk":function() {
					closePopupMsg();
					//set the flag false;
					globalVars.isChangedWithoutSubmit=false;
					//change the hash
					//change hash
					location.hash="#messages_page_1";
					//show loading message
					$("#tab_messages").html(layoutTemplate.basicConsoleFrame);
				}
			});
			/*$("body").bind("changedWithoutSave",function(changeEvent)
			{	
				if(changeEvent.trigger=="ok")
				{
					//set the flag false;
					globalVars.isChangedWithoutSubmit=false;
					//change the hash
					//change hash
					location.hash="#messages_page_1";
					//show loading message
					$("#tab_messages").html(layoutTemplate.basicConsoleFrame);
				}
				$("body").off("changedWithoutSave");
			});*/
		}
		else
		{
			//change hash
			location.hash="#messages_page_1";
			//show loading message
			$("#tab_messages").html(layoutTemplate.basicConsoleFrame);
		}
	});
	$(document).on("click","#messages_select_all",function(e) //check all checkbox in messages tab
	{
		$(".form_message_check").attr("checked","checked");
	});
	$(document).on("click","#messages_select_none",function(e) //uncheck all checkbox in messages tab
	{
		$(".form_message_check").removeAttr("checked");
	});
	$(document).on("click",".messageDetailBoardId",function(e)
	{
		logging("board id=>"+$(this).attr("data"));
		showWindow($(this).attr("data"));
	});
	$(document).on("click",".messageDetailDesignerId",function(e)
	{
		logging("user id=>"+$(this).attr("data"));
		//close sidebar
		closeSidebar();
		//show user info popup
		buildPopup({
			"url":userInfoPath+"?profileUserName=&profileUserId="+$(this).attr("data")
		},function () {
			$(".popup .entity").tinyscrollbar();
		});
	});
	$(document).on("click","#buttonShowMore",function(e)
	{
		logging("Show more messages","#FF0");
		//remove the hidden class for each item
		//make the show more button disappeared
		$("#buttonShowMore").fadeOut(function()
		{
			$("#message_detail .message_content .hidden").removeClass("hidden");
			//wrap message detail
			wrapMessageDetail(3);
			//update the scroll bar
			$("#message_content_scrollbar").tinyscrollbar_update('relative');
			//remove the showMoreButton element
			$("#buttonShowMore").remove();
		});
	});
	$(document).on("keyup","#messageContent",function(e)
	{
		var currentLength=$("#messageContent").val().length;
		$("#leftWords").html(1000-currentLength);
	});
	$(document).on("click",".readMore",function(e)
	{
		//show animation to expand the viewarea.
		//$(this).prev().css("height",$(this).prev().children('.context').height()+5);
		$(this).prev().animate({height:$(this).prev().children('.context').height()+5},function()
		{
			//update the scroll bar
			$("#message_content_scrollbar").tinyscrollbar_update('relative');
		});
		//Change the read more... to hide
		$(this).removeClass("readMore");
		//add the class and change the html of the hyperlink.
		$(this).addClass("hideContext").children('a').html("Hide");
	});
	$(document).on("click",'.hideContext',function(e)
	{
		//show animation to fold the viewarea
		//$(this).prev().css("height",56);
		$(this).prev().animate({height:72},function()
		{
			//update the scroll bar
			$("#message_content_scrollbar").tinyscrollbar_update('relative');
		});
		//Change the hide to read more
		$(this).removeClass("hideContext");
		//add the class and change the html of the hyperlink.
		$(this).addClass("readMore").children('a').html("Read more...");
	});
	$(document).on("click",'#expandAll',function(e)
	{
		if($("#buttonShowMore").length>0)
		{
			$("#buttonShowMore").fadeOut(10,function()
			{
				$("#message_detail .message_content .hidden").removeClass("hidden");
				//wrap message detail
				wrapMessageDetail(3);
				//update the scroll bar
				$("#message_content_scrollbar").tinyscrollbar_update('relative');
				var viewareaArray=$(".readMore").toArray();
				for(var i=0;i<viewareaArray.length;i++)
					$(viewareaArray[i]).trigger("click");
				//remove the showMoreButton element
				$("#buttonShowMore").remove();
			});
		}
		else
		{
			var viewareaArray=$(".readMore").toArray();
			for(var i=0;i<viewareaArray.length;i++)
				$(viewareaArray[i]).trigger("click");
		}
		//change the link to collapse all and change the id to collapseAll
		$('#expandAll').attr("id","collapseAll");
		$('#collapseAll').html("Collapse All");
	});
	$(document).on("click",'#collapseAll',function(e)
	{
		var viewareaArray=$(".hideContext").toArray();
		for(var i=0;i<viewareaArray.length;i++)
			$(viewareaArray[i]).trigger("click");
		//change the link to expand all and change the id to exapndAll
		$('#collapseAll').attr("id","expandAll");
		$('#expandAll').html("Expand All");
	});
	//End of message detail tab=======================================================================
	
	//Create Board tab================================================================================
	$(document).on("click","#upload_ai",function(e)
	{
		logging("upload ai");
		//check sale type
		var saleType="ai";
		var dataMode=$(this).attr('data-mode').toLowerCase(),
			previewArea='#create_board_review';
		if(dataMode=='p')
			previewArea='';
		//if($("#form_saletype_1").attr("checked")=="checked")
		//	saleType="jpg";
		//close sidebar
		closeSidebar();
		//show upload popup
		buildUploadPopup({
			"url":uploadPicturesPath,
			"mode":"BOARD",
			"filetype":saleType,
			"previewArea":previewArea,
			"event":"upload_finished_board",
			"onClose":function() {
				//if(dataMode!='p') //if the designer create the portfolio page, do not check file type and sale type
				//	checkFileTypeAndSaleType(true);
			},
			"onUploadSuccess":function(result) {
				logging("upload_finished_board=>"+result.filename);
				if(result.filestatus!=-1) {
					//set the flag
					globalVars.isChangedWithoutSubmit=true;
					$("#form_board_image_url").val(result.filename);
					$("#form_board_image_type").val(result.filename_ext);
					$("#form_board_image_urL_file").val(result.filename_400);
					$("#form_board_image_urL_thumb").val(result.filename_100);
					$("#form_board_image_urL_main").val(result.filename_original);
					//show the 400*400 image in preview area when dataMode is p
					if(dataMode=='p')
						$('#create_board_review').html('<i></i><img src="/400x400/'+result.filename_400+'" />');
				}
			}
		}); //url,mode,id for preview image,event name
	});
	//upload board image finish event handler 
	/*$(document).on("upload_finished_board","body",function(e)
	{
		logging("upload_finished_board=>"+e.filename);
		if(e.filestatus!=-1)
		{
			//set the flag
			globalVars.isChangedWithoutSubmit=true;
			$("#form_board_image_url").val(e.filename);
			$("#form_board_image_type").val(e.filename_ext);
			$("#form_board_image_urL_file").val(e.filename_400);
			$("#form_board_image_urL_thumb").val(e.filename_100);
			$("#form_board_image_urL_main").val(e.filename_original);
		}
	});*/
	$(document).on("click","#create_board_review",function(e)
	{
		logging("Get enlarge image");
		//fetch filename of bigimage
		if($('#form_board_image_urL_main').val()!="")
			showEnlargeImage($('#form_board_image_urL_main').val());
	});
	$(document).on("click","#new_portfolio",function(e)
	{
		logging("new portfolio");
		//get the name from form
		logging("CREATE PORTFOLIO=>"+$("#form_new_portfolio").val());
		$("#tabs").tabs("select","tab_create_portfolio");
		//set the prePortfolioName to put into #form_name_of_portfolio
		globalVars.prePortfolioName=$("#form_new_portfolio").val();
	});
	$(document).on("click",'#saleTypeTable input[type="radio"]',function(e)
	{
		//parse the id
		//if(checkFileTypeAndSaleType())
		//{
			var temp=e.currentTarget.id.split("_");
			clearSaleTypeTable();
			//get the previous price
			var previousPrice=$("#"+temp[1]+"_"+temp[2]+" .sale-type-credit-static").html();
			//set target area to apply an input field
			$("#"+temp[1]+"_"+temp[2]).html('<input name="saletype_'+temp[2]+'_cost" type="text" id="form_saletype_'+temp[2]+'_cost" class="cost sale-type-credit no-dec" value="'+previousPrice+'" maxlength="3"/>&nbsp;=&nbsp;$&nbsp;<span class="sale-type-conversion" data-row="'+temp[2]+'">0</span>');
		//}
		//else
		//	e.preventDefault();
		
	});
	$(document).on("click","#create_board_calculate",function(e)
	{
		calculate();
	});
	$(document).on("click","#create_board_clear",function(e)
	{
		clear();
	});
	$(document).on("change",".cost",function(e)
	{
		calculate();
	});
	$(document).on("click","#save_create_board",function(e)
	{
		//submit the form
		var errors= createBoardInputChecking(e);
		if(errors.length==0)
		{
			//if(checkFileTypeAndSaleType())
			//{
				//show confirm window
				showConfirmation(messagesProp.save_create_board_confirmation,"Confirmation","save_create_board",{
					"onOk":function() {
						unbindPopupMsgEvent();
						/*//console.log(e);*/
						logging("Confirmation result=>"+e.trigger);
						logging("save create board");
						//change the value of publish to mp to 0
						$("#form_publish_to_mp").val("0");
						createBoard(false); //ajax call, the parameter is the boolean of publish to MP, true= publish to mp false=save
					}
				});
			//}
		}
		else
		{
			buildPopupMsg({
				"content":"Below information is mandatory, we have highlighted the missing data:<br/>"+errors.join("<br/>"),
				"showOk":true
			});
		}
		
	});
	$(document).on("click","#publish_create_board",function(e)
	{
		var errors= createBoardInputChecking(e);
		if(errors.length==0)
		{
			//if(checkFileTypeAndSaleType())
			//{
				//show confirm window
				showConfirmation(messagesProp.publish_create_board_confirmation+messagesProp.confirmation_continue,"Confirmation","publish_create_board",{
					"onOk":function(){
						unbindPopupMsgEvent();
						logging("Confirmation result=>"+e.trigger);
						logging("publish board");
						//change the value of publish to mp to 0
						$("#form_publish_to_mp").val("1");
						createBoard(true); //ajax call, the parameter is the boolean of publish to MP, true= publish to mp false=save
					}
				});
			//}
		}
		else
		{
			buildPopupMsg({
				"content":"Below information is mandatory, we have highlighted the missing data:<br/>"+errors.join("<br/>"),
				"showOk":true
			});
		}	
	});
	$(document).on("click","#save_create_pboard",function(e) {
		//submit the form
		var errors= createPBoardInputChecking(e);
		if(errors.length==0) {
			//show confirm window
			showConfirmation(messagesProp.save_create_pboard_confirmation+'<br/>'+messagesProp.confirmation_continue,"Confirmation","save_create_board",{
				"onOk":function() {
					unbindPopupMsgEvent();
					/*//console.log(e);*/
					logging("Confirmation result=>"+e.trigger);
					logging("save create board");
					//change the value of publish to mp to 0
					$("#form_publish_to_mp").val("0");
					createBoard(false,createPBoardPath,'p'); //ajax call, the parameter is the boolean of publish to MP, true= publish to mp false=save
				}
			});
		}
		else {
			buildPopupMsg({
				"content":"Below information is mandatory, we have highlighted the missing data:<br/>"+errors.join("<br/>"),
				"showOk":true
			});
		}
	});
	$(document).on("click","#publish_create_pboard",function(e) {
		var errors= createPBoardInputChecking(e);
		if(errors.length==0) {
			//show confirm window
			showConfirmation(messagesProp.publish_create_pboard_confirmation+'<br/>'+messagesProp.confirmation_continue,"Confirmation","publish_create_board",{
				"onOk":function(){
					unbindPopupMsgEvent();
					logging("Confirmation result=>"+e.trigger);
					logging("publish board");
					//change the value of publish to mp to 0
					$("#form_publish_to_mp").val("2");
					createBoard(true,createPBoardPath,'p'); //create portfolio board (New portfolio page)
				}
			});
		}
		else {
			buildPopupMsg({
				"content":"Below information is mandatory, we have highlighted the missing data:<br/>"+errors.join("<br/>"),
				"showOk":true
			});
		}	
	});
	/*$(document).on("click","#cancel_create_board",function(e)
	{
		logging("cancel create board");
		//$("#tabs").tabs("select","tab_manage_board");
		//change the hash
		//location.hash="#portfolio_item_"+portfolioProp.preloadPortfolioId;
		//trigger the previous hash
		//$(window).hashchange();
		if(globalVars.isChangedWithoutSubmit)
		{
			showConfirmation("You are about to leave the page with unsaved data, Continue?","Confirmation","changedWithoutSaveOnCreateBoard",{
				"onOk":function() {
					closePopupMsg();
					//set the flag false;
					globalVars.isChangedWithoutSubmit=false;
					//determine back to which page
					window.history.back();
				}
			});
		}
		else
		{
			//determine back to which page
			window.history.back();
		}
	});*/
	$(document).on("click","#back_to_collections",function(e)
	{
		logging("cancel create board");
		if(globalVars.isChangedWithoutSubmit)
		{
			showConfirmation("You are about to leave the page with unsaved data, Would you like to continue?","Confirmation","changedWithoutSaveOnCreateBoard",{
				"onOk":function() {
					closePopupMsg();
					//set the flag false;
					globalVars.isChangedWithoutSubmit=false;
					triggerHash('#collections_page_'+portfolioProp.currentPage+'_1');
				}
			});
		}
		else
			triggerHash('#collections_page_'+portfolioProp.currentPage+'_1');
	});
	$(document).on("click","#back_to_portfolio",function(e) {
		logging("cancel create board");
		if(globalVars.isChangedWithoutSubmit) {
			showConfirmation("You are about to leave the page with unsaved data, Would you like to continue?","Confirmation","changedWithoutSaveOnCreateBoard",{
				"onOk":function() {
					closePopupMsg();
					//set the flag false;
					globalVars.isChangedWithoutSubmit=false;
					triggerHash('#portfolio_page_'+portfolioProp.currentPage+'_1');
				}
			});
		}
		else
			triggerHash('#portfolio_page_'+portfolioProp.currentPage+'_1');
	});
	$(document).on("click","#back_to_boards",function(e)
	{
		logging("cancel create board");
		var dataPortfolio=$(this).attr('data-portfolio');
		if(globalVars.isChangedWithoutSubmit)
		{
			showConfirmation("You are about to leave the page with unsaved data, Would you like to continue?","Confirmation","changedWithoutSaveOnCreateBoard",{
				"onOk":function() {
					closePopupMsg();
					//set the flag false;
					globalVars.isChangedWithoutSubmit=false;
					triggerHash('#board_page_'+dataPortfolio+'_'+boardProp.currentPage+"_1");
				}
			});
		}
		else
			triggerHash('#board_page_'+dataPortfolio+'_'+boardProp.currentPage+"_1");
	});
	$(document).on("click","#back_to_pboards",function(e) {
		logging("cancel create board");
		var dataPortfolio=$(this).attr('data-portfolio');
		if(globalVars.isChangedWithoutSubmit) {
			showConfirmation("You are about to leave the page with unsaved data, Would you like to continue?","Confirmation","changedWithoutSaveOnCreateBoard",{
				"onOk":function() {
					closePopupMsg();
					//set the flag false;
					globalVars.isChangedWithoutSubmit=false;
					triggerHash('#pboard_page_'+dataPortfolio+'_'+boardProp.currentPage+"_1");
				}
			});
		}
		else
			triggerHash('#pboard_page_'+dataPortfolio+'_'+boardProp.currentPage+"_1");
	});
	
	$(document).on("change","#portfolioId",function(e)
	{
		logging("portfolio id change=>"+e.target.value);
		
		//clear the list
		$("#product").html("");
		$("#productType").html("");
		logging("AJAX url=>"+productListByPortfolioPath+"/"+e.target.value);
		//get the list of product
		$.ajax(
		{	
			url: productListByPortfolioPath+"/"+e.target.value,
			type: "GET",
			beforeSend: function() {
				$('#product + .mselect').html("Loading..."); //add loading text in the component.
			},
			success: function(result)
			{
				//put the list
				var listContent="";
				if(result.list.length<=0)
					listContent+=layoutTemplate.optionEmpty;
				for(var i=0;i<result.list.length;i++)
				{
					listContent+='<option value="'+result.list[i].name+'">'+result.list[i].name+'</option>';
				}
				$("#product").html(listContent);
				$("#productType").html(layoutTemplate.optionEmpty);
				refershMultiselect("#product");
				refershMultiselect("#productType");
				//$("#product ~ .mselect").trigger("change");
			}
		});
	});
	
	/*$(document).on("click","#product",function(e)
	{
		logging("Product click");
		logging("Product change=>"+e.target.value);
		//clear the list
		$("#productType").html("");
		$.ajax(
		{
			url: productTypeListPath+"/"+e.target.value,
			type: "GET",
			beforeSend: function(){
				$("#productType").html('<option value="-1">Loading..</option>');
			},
			success: function(result)
			{
				//put the list
				var listContent="";
				if(result.list.length<=0)
				{
					listContent+='<option value="-1">N/A</option>';
				}
				else
				{
					for(var i=0;i<result.list.length;i++)
					{
						listContent+='<option value='+result.list[i].categoryId+'>'+result.list[i].name+'</option>';
					}
				}
				$("#productType").html(listContent);
			}
		});
		//$("#product").unbind("change"); //unbind the previous event
		$("#product").one("change",function(e)
		{
			logging("Product change=>"+e.target.value);
			//clear the list
			$("#productType").html("");
			$.ajax(
			{
				url: productTypeListPath+"/"+e.target.value,
				type: "GET",
				beforeSend: function(){
					$("#productType").html('<option value="-1">Loading..</option>');
				},
				success: function(result)
				{
					//put the list
					var listContent="";
					if(result.list.length<=0)
					{
						listContent+='<option value="-1">N/A</option>';
					}
					else
					{
						for(var i=0;i<result.list.length;i++)
						{
							listContent+='<option value='+result.list[i].categoryId+'>'+result.list[i].name+'</option>';
						}
					}
					$("#productType").html(listContent);
				}
			});
		});
	});*/
	$(document).on("click","#showCommission",function(e)
	{
		logging("show commission");
		showCommission();
	});
	$(document).on("click","#price_guideline_link",function(e)
	{
		logging("show price guide line");
		//close sidebar
		closeSidebar();
		//load popup
		buildPopup({
			"url":showPriceGuidelinePath
		},function() {
			$("#termScrollbar").tinyscrollbar();
		});
	});
	$(document).on("change",'#expDays input[name="expirationDays"]',function()
	{
		//console.log("Days=>"+this.value);
		$.ajax({
			url: computeBoardExpDatePath+"?days="+this.value,
			type: "GET",
			beforeSend: function(){
				$('#current_exp_days span').html("Computing..");
			},
			success: function(result)
			{
				$('#current_exp_days span').html(result.expirationDate);
			}
		});
	});
	//calculate FFG credit to USD price
	$(document).on('keyup','.sale-type-credit',function() {
		convertCreditToUsd($(this));
	});
	//End of create board tab====================================================================================
	
	//Create a collection tab=====================================================================================
	$(document).on("click","#save_create_portfolio",function(e)
	{
		logging("save create portfolio");
		createPortfolio($(this).attr("edit-mode"),$(this).attr('data-mode').toLowerCase());
	});
	$(document).on("click","#cancel_create_portfolio",function(e)
	{
		logging("cancel create portfolio");
		$("#tabs").tabs("select","tab_manage_collections");
	});
	$(document).on("click","#add_new_board",function(e)
	{
		//change the hash
		if($(this).attr('data-mode')=='p')
			location.hash="#create_board";
		else if($(this).attr('data-mode')=='c')
			location.hash="#create_board";
		else
			logging('data mode does not specified');
	});
	$(document).on("change","#form_division",function(e)
	{
		logging("division change=>"+e.target.value);
		//get category list
		getCategoryList(e.target.value,{
			"haveDontCareTag":false
		});
	});
	$(document).on('click','.delete-portfolio-image',function(e) {
		var role = $(this).attr('role');
		var activeStatus = $('.active_status[role='+role+']').val();
		if(activeStatus == 1) {
			//change the active status to 0
			$('.active_status[role='+role+']').val(0);
			//update the checkbox
			$(this).prop('checked',true);
		}
		else {
			//change the active status to 1
			$('.active_status[role='+role+']').val(1);
			//update the checkbox
			$(this).prop('checked',false);
		}	
	});
	//End of create a collection tab==============================================================================
	
	//Activity tab===============================================================================================
	$(document).on("click","#chart_today",function(e)
	{
		logging("show today");
		//reload the chart
		initChart(chartPath+"/1");
		disableChartLink("#chart_today");
	});
	$(document).on("click","#chart_week",function(e)
	{
		logging("show week");
		//reload the chart
		initChart(chartPath+"/7");
		disableChartLink("#chart_week");
	});
	$(document).on("click","#chart_month",function(e)
	{
		logging("show month");
		//reload the chart
		initChart(chartPath+"/30");
		disableChartLink("#chart_month");
	});
	$(document).on("click",".gridBoardId",function(e)
	{
		logging("board id=>"+$(this).attr("data"));
		//show popup
		showWindow($(this).attr("data"));
	});
	$(document).on("click",".gridDesignerName",function(e)
	{
		logging("click user id=>"+encodeURIComponent($(this).attr("data")));
		//close sidebar
		closeSidebar();
		//show user info popup
		buildPopup({
			"url":userInfoPath+"?profileUserName=&profileUserId="+encodeURIComponent($(this).attr("data"))
		},function () {
			$(".popup .entity").tinyscrollbar();
		});
	});
	//chart graph click handler
	$(document).on('jqplotDataClick','#activity_chart',function(ev, seriesIndex, pointIndex, data) {
		logging(ev+';'+seriesIndex+';'+pointIndex);
		logging(data);
	});
	//End of activity tab======================================================================================
	
	//Manage collections tab=====================================================================================
	$(document).on("click","#clear_manage_portfolio",function(e)
	{
		$("input").removeAttr("checked"); //uncheck all checkbox
	});
	$(document).on("click","#add_manage_portfolio",function(e)
	{
		logging("add portfolio");
		//check mode is portfolio or collections
		if($(this).attr('data-mode')=='p'){
			$("#tabs").tabs("url",getIdByName("tab_create_portfolio"),manageNewPortfolioPath); //load create portfolio tab 
			$("#tabs").tabs("select","tab_create_portfolio");
		}
		else if($(this).attr('data-mode')=='c') {
			$("#tabs").tabs("url",getIdByName("tab_create_collection"),managePortfolioPath); //load create collection tab
			$("#tabs").tabs("select","tab_create_collection");
		}
		else
			logging('data-mode does not specified');
		
	});
	$(document).on("click","#delete_manage_portfolio",function(e)
	{
		logging("delete portfolio");
		deletePortfolio();
	});
	$(document).on("click","#manage_portfolio .item a",function(e)
	{
		//logging("a=>"+e.currentTarget.id);
		//change hash
		if($(this).attr('data-mode').toLowerCase()=='c')
			location.hash="#board_page_"+$(this).attr("data")+"_0_1"; //page=0, forceToReload=1
		else if($(this).attr('data-mode').toLowerCase()=='p')
			location.hash="#pboard_page_"+$(this).attr("data")+"_0_1"; //page=0, forceToReload=1
		else
			logging('unspecified data mode');
		//$(this).children("div").animate({"border-width":"2px"},"fast");
	});
	$(document).on("mouseenter","#manage_portfolio a",function(e)
	{
		$(this).children("div").eq(0).addClass("shadow");
	});
	$(document).on("mouseleave","#manage_portfolio a",function(e)
	{
		$(this).children("div").eq(0).removeClass("shadow");
	});
	$(document).on("mouseenter",'#manage_portfolio',function(e)
	{
		//show arrow
		//$('#manage_portfolio_frame .touchbar').
		$('#manage_portfolio_frame .touchbar').addClass("appear");
		$('#manage_portfolio_frame .touchbar').removeClass("disappear");
		$('#manage_portfolio_frame .touchbar').animate(
		{
			"opacity":0.4
		},"fast");
	});
	$(document).on("mouseleave",'#manage_portfolio',function(e)
	{
		//$('#manage_portfolio_frame .touchbar').
		$('#manage_portfolio_frame .touchbar').addClass("disappear");
		$('#manage_portfolio_frame .touchbar').removeClass("appear");
		$('#manage_portfolio_frame .touchbar').animate(
		{
			"opacity":0
		},"fast");
	});
	$(document).on("click","#collections_carouselPrev",function(e)
	{
		logging("portfolio prev");
		//set the current page
		portfolioProp.currentPage--;
		if(portfolioProp.currentPage<0)
			portfolioProp.currentPage=portfolioProp.totalPages-1;
		//change the hash
		triggerHash("#collections_page_"+portfolioProp.currentPage+"_0");
	});
	//Carousel controller
	$(document).on("click","#collections_carouselNext",function(e)
	{
		logging("portfolio next");
		//set the current page
		portfolioProp.currentPage++;
		if(portfolioProp.currentPage>=portfolioProp.totalPages)
			portfolioProp.currentPage=0;
		//change the hash
		triggerHash("#collections_page_"+portfolioProp.currentPage+"_0");
	});
	$(document).on("click","#portfolio_carouselPrev",function(e) {
		logging("portfolio prev");
		//set the current page
		portfolioProp.currentPage--;
		if(portfolioProp.currentPage<0)
			portfolioProp.currentPage=portfolioProp.totalPages-1;
		//change the hash
		triggerHash("#portfolio_page_"+portfolioProp.currentPage+"_0");
	});
	$(document).on("click","#portfolio_carouselNext",function(e) {
		logging("portfolio next");
		//set the current page
		portfolioProp.currentPage++;
		if(portfolioProp.currentPage>=portfolioProp.totalPages)
			portfolioProp.currentPage=0;
		//change the hash
		triggerHash("#portfolio_page_"+portfolioProp.currentPage+"_0");
	});
	$(document).on("click",".delete_portfolio",function(e)
	{
		logging("delete portfolio=>"+parseInt($(this).attr("data")));
		var targetedId=parseInt($(this).attr("data"));
		var renderMode= $(this).attr('data-mode').toLowerCase();
		/*var r=confirm("The portfolio is going to be deleted. Coninue ?");*/
		if(renderMode=='c') {
			showConfirmation("The collection is going to be deleted. Would you like to Coninue?","Confirmation","delete_portfolio",{
				"onOk":function() {
					unbindPopupMsgEvent();
					deletePortfolio(targetedId,'collections_page');
				},
				"onCancel":function(){
					logging("cancel");
				}
			});
		}
		else if(renderMode=='p') {
			showConfirmation("The portfolio is going to be deleted. Would you like to Coninue?","Confirmation","delete_portfolio",{
				"onOk":function() {
					unbindPopupMsgEvent();
					deletePortfolio(targetedId,'portfolio_page');
				},
				"onCancel":function(){
					logging("cancel");
				}
			});
		}
		/*$(document).on("delete_portfolio","body",function(e)
		{
			//console.log(e);
			logging("Confirmation result=>"+e.trigger);
			if(e.trigger=="ok")
			{
				deletePortfolio(targetedId);
			}
			//remove the event listener
			$("body").die("delete_portfolio");
		});	*/
		/*if (r==true)
			deletePortfolio(delete_portfolioId);*/
	});
	//End of manage collections tab=============================================================================
	
	//manage board tab========================================================================================
	$(document).on("click","#show_all_portfolios",function(e)
	{
		logging("Show all portfolio","#F90");
		$("#tabs").tabs("select","tab_manage_collections");
	});
	$(document).on("change","#collection_catalog",function(e)
	{
		logging("change location=>"+e.currentTarget.value);
		//change hash to trigger hash change event
		location.hash="#board_page_"+e.currentTarget.value+"_0";
	});
	$(document).on("change","#portfolio_catalog",function(e) {
		logging("change location=>"+e.currentTarget.value);
		//change hash to trigger hash change event
		location.hash="#pboard_page_"+e.currentTarget.value+"_0";
	});
	$(document).on("click","#publish_manage_board",function(e)
	{
		logging("publish board");
	});
	$(document).on("click","#add_manage_board",function(e)
	{
		//get portfolio id
		logging("add new board under portfolio =>"+$("#collection_catalog").val());
		//change the hash
		location.hash="#create_board_"+$("#collection_catalog").val();
	});
	$(document).on("click","#add_manage_page",function(e) {
		//get portfolio id
		logging("add new board under portfolio =>"+$("#portfolio_catalog").val());
		//change the hash
		location.hash="#create_pboard_"+$("#portfolio_catalog").val();
	});
	$(document).on("click","#delete_manage_board",function(e)
	{
		logging("delete selected board");
		deleteBoard();
	});
	$(document).on("click","#clear_manage_board",function(e)
	{
		//logging("clear all");
		$("#form_boards")[0].reset(); //reset the form
	});	
	$(document).on("mouseenter","#manage_board .item",function(e) //show effect when mouse move in target portfolio
	{
		//$(this).children("div").eq(0).addClass("shadow"); //add shadow
		$(this).addClass("shadow"); //add shadow
	});
	$(document).on("mouseleave","#manage_board .item",function(e) //show effect when mouse move out target portfolio
	{
		//$(this).children("div").eq(0).removeClass("shadow"); //remove shadow
		$(this).removeClass("shadow"); //add shadow
	});
	$(document).on("click","#board_carouselPrev",function(e)
	{
		prevBoardPage();	
	});
	$(document).on("click","#board_carouselNext",function(e)
	{
		nextBoardPage();
	});
	$(document).on("click","#pboard_carouselPrev",function(e) {
		prevBoardPage('pboard_page');	
	});
	$(document).on("click","#pboard_carouselNext",function(e) {
		nextBoardPage('pboard_page');
	});
	$(document).on("refresh_board","body",function(e,pId,dataMode)
	{
		logging("REFRESH BOARD BY EVENT");
		refreshBoards(pId,dataMode);
	});
	$(document).on("click",".designerBoardLink",function(e)
	{
		logging("boardLink clicked","#0FF");
		logging("hash=>"+location.hash,"#0FF");
		logging("data=>"+$(this).attr("data"),"#0FF");
		var targetboardId=$(this).attr("data");
		if(location.hash=="#board_item_"+targetboardId) //if hash is the same, trigger the hash change event manually
		{
			logging("trigger hash change");
			$(window).hashchange();
		}
		else
			location.hash="board_item_"+targetboardId;
	});
	$(document).on("click",".delete_board",function(e)
	{
		logging("delete board=>"+parseInt($(this).attr("data")));
		var targetBoardId=$(this).attr("data");
		var dataMode=$(this).attr('data-mode'),
			popupContent='The board is going to be deleted. Would you like to continue?';
		if(dataMode.toLowerCase()=='p')
			popupContent='The page is going to be deleted. Would you like to coninue?';
		/*var r=confirm("The board is going to be deleted. Coninue ?");*/
		showConfirmation(popupContent,"Confirmation","delete_board",{
			"onOk":function() {
				unbindPopupMsgEvent();
				//console.log(e);
				logging("Confirmation result=>"+e.trigger);
				deleteBoard(targetBoardId,dataMode);
			}
		});
		/*$(document).on("delete_board","body",function(e)
		{
			//console.log(e);
			logging("Confirmation result=>"+e.trigger);
			if(e.trigger=="ok")
			{
				deleteBoard(targetBoardId);
			}
			//remove the event listener
			$("body").die("delete_board");
		});*/
		/*if (r==true)
			deleteBoard(boardId);*/	
	});
	$(document).on("click",".togglePubstatus_board",function(e)
	{
		logging("toggle board status to public=>"+$(this).attr("data"));
		var targetBoardId=$(this).attr("data");
		/*var r=confirm("The status of the board is going to be changed. Coninue ?");*/
		showConfirmation('Your board is going to be <span style="color:#C30;">Published</span>. Continue ?',"Confirmation","togglePubstatus_board",{
			"onOk":function() {
				unbindPopupMsgEvent();
				//console.log(e);
				logging("Confirmation result=>"+e.trigger);
				ToggleStatusBoard(targetBoardId);
			}
		});
		/*$(document).on("togglePubstatus_board","body",function(e)
		{
			//console.log(e);
			logging("Confirmation result=>"+e.trigger);
			if(e.trigger=="ok")
			{
				ToggleStatusBoard(targetBoardId);
			}
			//remove the event listener
			$("body").die("togglePubstatus_board");
		});*/
		/*if (r==true)
			ToggleStatusBoard(boardId);*/
	});
	$(document).on("click",".toggleHidstatus_board",function(e)
	{
		logging("toggle board status to hidden=>"+$(this).attr("data"));
		var targetBoardId=$(this).attr("data");
		/*var r=confirm("The status of the board is going to be changed. Coninue ?");*/
		showConfirmation('Your board is going to be <span style="color:#C30;">Unpublished</span>. Continue ?',"Confirmation","toggleHidstatus_board",{
			"onOk":function(){
				unbindPopupMsgEvent();
				//console.log(e);
				logging("Confirmation result=>"+e.trigger);
				ToggleStatusBoard(targetBoardId);
			}
		});
		/*$(document).on("toggleHidstatus_board","body",function(e)
		{
			//console.log(e);
			logging("Confirmation result=>"+e.trigger);
			if(e.trigger=="ok")
			{
				ToggleStatusBoard(targetBoardId);
			}
			//remove the event listener
			$("body").die("toggleHidstatus_board");
		});*/		
		/*if (r==true)
			ToggleStatusBoard(boardId);*/
	});
	$(document).on("click",".edit a",function(){
		//check the board status
		editBoard($(this).attr("data"),$(this).attr('data-mode'));
	});
	//End of manage board tab=============================================================================
	
	//Check out tab=======================================================================================
	$(document).on("click","#back_to_search_result",function(e)
	{
		logging("back to results");
		//change the hash
		//location.hash="search_page_"+searchResultProp.currentPage+"_"+searchResultProp.sortOption;
		location.href=searchViewerPath;
		//$("#tabs").tabs("enable","tab_search_result"); //enable search result tab		
		//$("#tabs").tabs("select","tab_search_result"); //select search result tab
		//$("#tabs").tabs("disable","tab_search_criteria"); //disable search tab
	});
	$(document).on("click","#shopping_cart_update",function(e)
	{
		//if($("#form_checkOutTAndC").attr("checked")=="checked") //
		{
			logging("shopping cart update");
			//serialize the form
			$("#form_shopping_cart").serialize();
			logging("FORM DATA=>"+$("#form_shopping_cart").serialize());
			$.ajax(
			{
				url: deleteMultiItemsPath,
				type: 'POST',
				data: $("#form_shopping_cart").serialize(),
				success: function(result)
				{
					logging("DELETE SUCCESS");
					//reload the tab
					globalVars.cart=result; //reset the shopping cart
					checkShoppingCart(result.count); //check the sopping cart is empty or not and then reset the picture.
					//console.log("DELETE MULTI");
					//console.log(cart);
					$("#tabs").tabs("load",getIdByName("tab_shopping_cart"));
				}
			});
		}
		{
			//showErrorMsg("Please Read Terms and Conditions. Thank you.");
			//please Accept the terms and conditions to proceed!
		}
		
	});
	$(document).on("click","#shopping_cart_terms",function(e)
	{
		//close sidebar
		closeSidebar();
		displayLatestTermAndConditions(CustomerSaleTermsPath);
	});
	$(document).on("click","#terms_ok",function(e)
	{
		logging("terms_ok");
		$("#form_checkOutTAndC").attr("checked","checked");
		if($("#terms_agree").attr("checked")=="checked") //if user check agree, then go to verification panel
		{
			// capture terms id
			var termId = $('input[name="termsId"]').val();
			closePopup();
			//check the chechbox in registration page
			$("#form_checkOutTAndC").attr("checked","checked");
			//$('#form_accepted_termsId').val(termId);
		}
		else if($("#terms_decline").attr("checked")=="checked") //if user decline the term, then close the panel
		{
			closePopup();
			//uncheck the chechbox in registration page
			$("#form_checkOutTAndC").removeAttr("checked");
		}
	});
	$(document).on("click","#shopping_cart_checkout",function(e)
	{
		logging("check out");
	});
	$(document).on("submit","#form_shoppingcart_checkout",function(e) {
		logging("form_shoppingcart_checkout");
		if($("#form_checkOutTAndC").attr("checked")!="checked"){
			buildPopupMsg({
				"content":"Please Accept the Sales Terms and conditions before proceeding to checkout. Thanks",
				"showOk":true
			});
			return false;
		}
		else
		{
			//this is for disabling the pay button once paypal pay is selected
			$("#shopping_cart_checkout").prop("disabled",true);
			$("#form_shoppingcart_checkout").prop("disabled",true);
			logging("checkout","#F00");
			//show the mask on the paynow button
			$('#paynowMask').css("z-index","10");
		}
	});
	$(document).on("click",".checkoutBoardId",function(e)
	{
		logging("board id=>"+$(this).attr("data"));
		showWindow($(this).attr("data"));
	});
	$(document).on("click",".checkoutDesignerId",function(e)
	{
		logging("designer id=>"+$(this).attr("data"));
		//close sidebar
		closeSidebar();
		//show user info popup
		buildPopup({
			"url":userInfoPath+"?profileUserName=&profileUserId="+$(this).attr("data")
		}, function () {
			$(".popup .entity").tinyscrollbar();
		});
	});
	$(document).on("click","#checkoutError",function(e){
		buildPopupMsg({
			"content":"Your transaction amount has to be less than $10,000.00, please remove some items or please contact us for further help. Thank You.",
			"showOk":true,
			"onOk":function(){
				closePopupMsg();
			}
		});
	});
	//click event on check out checkbox
	$(document).on("click","#shopping_cart .checkbox input[type=checkbox]",function(e){
		//highlight update change button
		var delay=400;
		$("#shopping_cart_update").stop(true, true);
		//make the button blink
		$("#shopping_cart_update").addClass("gray",delay).removeClass("gray",delay).addClass("gray",delay).removeClass("gray",delay).addClass("gray",delay).removeClass("gray",delay);
	});
	//End of check out================================================================================
	
	//popup event handler=================================================================================
	//shopping cart popup-------------------------------------
	$(document).on("click","#back_to_search_results",function(e)
	{
		logging('back to search results');
		//$("#tabs").tabs("select","tab_search_result"); //show search result tab
		closePopup(); //close popup
	});
	$(document).on("click","#to_checkout",function(e)
	{
		logging('to checkout');
		closePopup(); //close popup
		triggerHash("#shopping_cart");
	});
	$(document).on("click",".shoppingCartBoardId",function(e)
	{
		//hide the tooltip
		$('.qtip.qtip-active').css("display","none");
		logging("board id=>"+$(this).attr("data"));
		showWindow($(this).attr("data"));
	});
	$(document).on("click",".shoppingCartDesignerId",function(e)
	{
		logging("designer id=>"+$(this).attr("data"));
		//close sidebar
		closeSidebar();
		buildPopup({
			"url":userInfoPath+"?profileUserName=&profileUserId="+$(this).attr("data")
		},function () {
			$(".popup .entity").tinyscrollbar();
		});
	});
	//board detail popup-------------------------------------
	$(document).on("click","#add_to_shopping_cart",function(e)
	{
		logging("add to cart","#00F");
		var boardId=$(this).attr("data");
		addToCart(boardId,function() {
			$('#add_to_shopping_cart').remove();
		});
	});
	$(document).on("click","#remove_from_shopping_cart",function(e)
	{
		logging("remove from cart","#00F");
		removeFromCart($(this).attr("data"));
	});
	$(document).on("click","#form_send_comment",function(e)
	{
		logging("send message");
		sendMessage();
	})
	$(document).on("click",".boards_suggestion_boardId",function(e)
	{
		logging("show board=>"+$(this).attr("data"));
		triggerHash("#board_item_"+$(this).attr("data"));
		//showWindow($(this).attr("data"),false);
	});
	$(document).on("click",".enlargeImage",function(e)
	{
		showEnlargeImage($(this));
	});
	$(document).on("keydown","#form_comment_messageBody",function(e){
		if(e.which==13 || e.which==8) {
			//update scroll bar
			$("#board_detail_scrollbar").tinyscrollbar_update('relative');
		}
	});
	$(document).on('click','.board-gallery-item',function(e) {	
		//use the image-data1 to show on the main image area.
		//remove the previous image area
		$('#board_detail .leftArea .pic .main-image-wrapper').html();
		//change the enlage link attributes.
		//if the attributes of image-width and image-height are existed. Attach to the link also. Or remove the attribute
		if($(this).attr('image-width')!=undefined)
			$('.enlargeImage').attr('image-width',$(this).attr('image-width'));
		else
			$('.enlargeImage').removeAttr('image-width');
		if($(this).attr('image-height')!=undefined)
			$('.enlargeImage').attr('image-height',$(this).attr('image-height'));
		else
			$('.enlargeImage').removeAttr('image-height');
		//hint and Enlarge link seaction
		//if the image ration is <=1.0. Change the hint to "Actual Size"
		if($(this).attr('image-actual-size') == 'true') {
			//change to new image
			var layout = '<img src="/400x400/'+$(this).attr('image-data1')+'" />';
			$('#board_detail .leftArea .pic .main-image-wrapper').html(layout); //update layout
			$('.enlargeImage').css('display',"none"); //if the ratio of width and height are <=1.0, do not display enlarge option
			$('#board_detail .leftArea-hint').html('(Actual size)');
		}
		else {
			//change to new image
			var layout = '<a href="/bigimage/'+$(this).attr('image-data')+'" class ="cloud-zoom" id="zoom1" rel="zoomWidth:450, softFocus: false"><img src="/400x400/'+$(this).attr('image-data1')+'" /></a>';
			$('#board_detail .leftArea .pic .main-image-wrapper').html(layout); //update layout
			$('#board_detail .leftArea-hint').html('(Rollover image to zoom detail)');
			//if the enlargeImage div is not existed, append a new one.
			if($('#board_detail .enlargeImage').length<1)
				$('#board_detail .leftArea .pic').append('<span class="enlargeOption"><a class="enlargeImage" image-data="">[+] Enlarge</a></span>');
			$('.enlargeImage').css('display',"block");
			$('.enlargeImage').attr('image-data',$(this).attr('image-data')); //update image-data attribute
		}
	});
	
	//referral-------------------------------------
	$(document).on("click","#referral_submit",function(e)
 	{
		logging($("#form_referral").serialize());
		logging("referral submit");
		$.ajax(
		{
			url : submitReferralPath,
			type : "POST",
			dataType:"json",
			data : $("#form_referral").serialize(),
			beforeSend:function(e) {
				$("#addReferralResult").css("color","blue").html("Processing...");
				//disable the send button
				$('#referral_submit').attr("disabled","disabled");
			},
			error: function() {
				$("#addReferralResult").css("color","red").html("Process error, please submit again. Thank you.");
				//clear the error text after 5 seconds.
				var clearTextTimer = setTimeout(function() {
					$("#addReferralResult").html("");
				},5000);
				//enable the send button
				$('#referral_submit').removeAttr("disabled");
			},
			success : function(result) 
			{
				//enable the send button
				$('#referral_submit').removeAttr("disabled");
				logging("Send referral data success");
				if(result[0]=="SUCCESS")
				{
					$("#addReferralResult").css("color","blue");
					$("#addReferralResult").html(result[1]);
					$("#form_referral")[0].reset();
					//set the flag
					isChangedWithoutSubmitOnPopup=false;
				}
				else
				{
					$("#addReferralResult").css("color","red");
					$("#addReferralResult").html(result[1]);
				}
			}
		});
	});
	//manage referrals popup---------------------------------
	$(document).on("click",".edit_referral",function(e)
	{
		logging("edit referral=>"+e.currentTarget.id);
		//parsing the table id
		temp=e.currentTarget.id.split("_");
		tableId=temp[2];
		//setting text field
		$("#referral_firstname_"+tableId).html('<input type="text" name="firstName" maxlength="30" value="'+$("#referral_firstname_"+tableId).html()+'"></input>');
		$("#referral_lastname_"+tableId).html('<input type="text" name="lastName" maxlength="30" value="'+$("#referral_lastname_"+tableId).html()+'"></input>');
		$("#referral_phone_"+tableId).html('<input type="text" name="phone" maxlength="20" value="'+$("#referral_phone_"+tableId).html()+'"></input>');
		$("#referral_email_"+tableId).html('<input type="text" name="email" maxlength="50" value="'+$("#referral_email_"+tableId).html()+'"></input>');
		//create link update
		/*var updateLink='<a class="update_referral" id="update_referral_'+tableId+'">Update</a>';*/
		var sendLink='<a class="send_referral" id="send_referral_'+tableId+'">Update and Send</a>';
		//change the link in action area
		//$("#referral_action_"+tableId).html(updateLink+"<br />"+sendLink);
		$("#referral_action_"+tableId).html(sendLink+"<br />&nbsp;");
	});
	//update referral
	$(document).on("click",".update_referral",function(e)
	{
		doUpdateReferral(e);
	});
	//update and resend
	$(document).on("click",".resend_noti",function(e)
	{
		logging("resend referral email=>"+e.currentTarget.id,"#00F");
		//parsing the table id
		temp=e.currentTarget.id.split("_");
		tableId=parseInt(temp[2]);
		$.ajax(
		{
			url:resendReferralNotiPath+"/"+tableId,
			type: "POST",
			beforeSend:function(){
				//create link update
				var resendLink='<a href="javascript:void(0)" class="resend_noti" id="resend_referral_'+tableId+'">Resend</a><img src="/images/spinner_small.gif" style="width:12px; height:12px;"/>';
				var editLink='<a href="javascript:void(0)" class="edit_referral" id="edit_referral_'+tableId+'">Edit</a>';
				//change the link in action area
				$("#referral_action_"+tableId).html(resendLink+"<br />"+editLink);
			},
			success: function(result)
			{
				var resendLink='<a href="javascript:void(0)" class="resend_noti" id="resend_referral_'+tableId+'">Resend</a>';
				var editLink='<a href="javascript:void(0)" class="edit_referral" id="edit_referral_'+tableId+'">Edit</a>';
				//change the link in action area
				$("#referral_action_"+tableId).html(resendLink+"<br />"+editLink);
				if(result.hasError==false)
				{
					//set the input field back to normal text.
					$("#referral_firstname_"+tableId).html(result.result.firstName);
					$("#referral_lastname_"+tableId).html(result.result.lastName);
					$("#referral_phone_"+tableId).html(result.result.phone);
					$("#referral_email_"+tableId).html(result.result.email);
					$("#referral_status_"+tableId).html(result.result.status);
					$("#referral_datesent_"+tableId).html(result.result.dateSentString);
					//$("#manageReferralTable tr:nth-child("+(tableId+1)+")").addClass("blink",200).removeClass("blink",1000);
					//clear animation queue
					$("#manageReferralTable tr:nth-child("+(tableId+1)+") td").stop(true,true);
					//show animation
					$("#manageReferralTable tr:nth-child("+(tableId+1)+") td").each(function(index) {
						//compute the delayTimes
						var delayTimes=50;
						$(this).delay(delayTimes*index).addClass("blink",200).removeClass("blink",600);
					});
				}
				else
				{
					buildPopupMsg({
						"content":"Resend Failure.<br /> Please click resend again. Thank you.",
						"showOk":true,
						"title":"Resend Error"
					});
				}
			}
		});
	});
	$(document).on("click",".send_referral",function(e)
	{
		doUpdateReferral(e);
	});
	//catch the event when close the popup======================================
	$(document).on("terms_agree","#popupContainer",function()
	{
		logging("terms agree");
	});
	$(document).on("terms_decline","#popupContainer",function()
	{
		logging("terms decline");
	});
	//End of popup event handler================================================
	$(document).on("click","#remove_from_cart_bybid",function(e){
		logging("remove_from_cart_bybid"+$(this).attr("data"));
		delete_from_cart_by_board_id($(this).attr("data"));
	});
	
	//Feedback popup=============================================================
	$(document).on("click","#feedbackButton",function(e)
	{
		buildPopupMsg({
			"title":"Your feedback is valuable!",
			"content":'<div style="color:#C30;">Dear users, your feedback is valuable to our product and helps us improve the features.<br /> Please send your thoughts and concerns to <a href="mailto://'+staticTextPack.feedbackEmailAddr+'">'+staticTextPack.feedbackEmailAddr+'</a><br />Thank you.</div>',
			"showOk":true,
			"onOk":function(){
				closePopupMsg();
			}
		});
	});
	
	//LOGOUT=============================================================
	$(document).on("click","#logout",function(e)
	{
		logging("LOGOUT");
		logout();
	});
	
	//Notif Popup Handler
	$(document).on("click","#notifPopupClose",function(e) {
		$("#notifPopup").fadeOut();
		//reset title
		document.title=globalVars.title;
	});
	
	/*//Listener for inconsistentLI
	$("body").bind("inconsistentLI",function(e)
	{
		location.href=logoutPath;
	})*/
	
	//contact info popup
	$(document).on('click','#phone',function() {
		buildPopupMsg({
			"content": '<img src="/images/splash/contact_info.png"/>',
			"title": "CONTACT INFO",
			"showOk": true,
			"closeByOverlay": true,
			"effect":true
		});
	});
	
	//close event of empty panel
	$(document).on('click','.empty.w .close',function(e) {
		$(this).parent().css('display','none');
		navigate($('.li-portfolio'),true);
	});
	
	$(document).on('click','.nav',function() {
		triggerHash('#portfolio_page_0_1');
	})
});

function initRaty()
{
	logging("init raty");
	//get all rating items into an array
	var target=$(".readonly").toArray();
	//initialize rating plugin==============================
	//for company page
	$(".rating").raty(
	{
		path: appConfig.ratyImgPath,
		cancel: true,
		space: true,
		width: "150px",
		click: function(score,e)
		{
			var target=$(this).attr('id');
			$("#"+target+"_value").html(score);
			$("[name="+target+"]").val(score); //set the value to the hidden area
		}
	});
	//for designer page----------------------------------------
	//overall rating
	$(".readonly").raty(
	{
		path: appConfig.ratyImgPath,
		cancel: true,
		space: true,
		width: "155px",
		readOnly: true
	});
	//partial rating
	$(".partial_rating").raty(
	{
		path: appConfig.ratyImgPath,
		cancel: true,
		space: true,
		width: "150px",
		click: function(score,e)
		{
			var target=$(this).attr('id');
			logging("raty item=>"+target);
			$("#"+target+"_value").html(score);
			//set the value to the hidden form
			$("[name="+target+"]").val(score);
			//update overall rating-------------------
			//get total items in this group
			var temp=target.split("_"); //fetch attributes from id "rate_(groupid)_(partial_id)_(q,p,r,c)"
			var itemSize=$("#group_"+temp[1]+" .item").size() - 1; //board number fir company is total minus the item for company
			var total=0;
			var average=0;
			//get each item value and calculate the total
			for(var i=1;i<=itemSize;i++)
			{
				if($("#"+temp[0]+"_"+temp[1]+"_"+i+"_q_value").html()=="")
					total+=0;
				else	
					total+=parseInt($("#"+temp[0]+"_"+temp[1]+"_"+i+"_q_value").html());
				if($("#"+temp[0]+"_"+temp[1]+"_"+i+"_p_value").html()=="")
					total+=0;
				else
					total+=parseInt($("#"+temp[0]+"_"+temp[1]+"_"+i+"_p_value").html());
				if($("#"+temp[0]+"_"+temp[1]+"_"+i+"_r_value").html()=="")
					total+=0;
				else
					total+=parseInt($("#"+temp[0]+"_"+temp[1]+"_"+i+"_r_value").html());
				if($("#"+temp[0]+"_"+temp[1]+"_"+i+"_c_value").html()=="")
					total+=0;
				else
					total+=parseInt($("#"+temp[0]+"_"+temp[1]+"_"+i+"_c_value").html());
			}
			average=total/(itemSize*4); //compute the average
			average=average.toFixed(1);
			//logging("average="+average);
			//update the average to overall rating and it's value-------------------
			$("#rate_"+temp[1]+"_overall").html(average); //round the average
			$("#rate_"+temp[1]).raty( //display the average on overall rating
			{
				path: appConfig.ratyImgPath,
				space: true,
				width: "155px",
				readOnly: true,
				half: true,
				score: average
			});
			//set the value to the form overall hidden area
			$("[name=rate_"+temp[1]+"]").val(average);
		}
	});
}
//Hash Change event===================================================================================
function hashChange()
{
	/*var route=location.hash.replace("#","");
	var hashEventHandler = {
		"nail": function() {
			
		},
		"messages_page": function()) { },
		"activity": function() { }
	};
	hashEventHandler[route]();*/
	//console.log("FPARAM=>"+$.url().fsegment(1));
	//console.log("FPARAM=>"+decodeURIComponent($.url().fsegment(2)));
	var currentHash="#"+$.url().fsegment(1);
	//console.log(currentHash);
	if(currentHash.search("#messages_page")!=-1)
	{
		logging("Trigger Hash Change: messages page");
		//get page id
		var temp=currentHash.split("_");
		var id=temp[2];
		//
		logging("reload message page=>"+id);
		//logging("current tab=>"+$("#tabs").tabs("option","selected"));
		//get the page id for messages
		var page_messages=getIdByName('tab_messages');
		if(page_messages!=-1) {
			//reload the tab
			$("#tabs").tabs("url",page_messages,messagesPagePath+"/"+id); //show the views
			//set the portfolio Id
			//select tab
			logging("SELECT MESSAGES");
			$("#tab_messages").html(layoutTemplate.basicConsoleFrame); //show loading message
			$("#tabs").tabs("select",page_messages);
			$("#tabs").tabs("load",page_messages);
		}
		else {
			showConfirmation("You will leave admin console and redirect to messages tab in user console. Would you like to continue?","Confirmation","leaveAdminConsole",{
				"onOk":function() {
					//back to user console
					location.href=homepage+"#messages_page_1";
				}
			});
		}
	}
	else if(currentHash.search("#message_detail")!=-1)
	{
		logging("Trigger Hash Change: message detail");
		//get page id
		var temp=currentHash.split("_");
		var id=temp[2];
		var fromUserId=temp[3];
		var toUserId=temp[4];
		logging("load message detail id=>"+id);
		//logging("current tab=>"+$("#tabs").tabs("option","selected"));
		//get the page id for messages
		var page_messages=getIdByName('tab_messages');
		//reload the tab
		$("#tabs").tabs("url",page_messages,messageDetailPath+"/"+id+"/"+fromUserId+"/"+toUserId);
		//select tab
		logging("SELECT MESSAGES");
		$("#tab_messages").html(layoutTemplate.basicConsoleFrame); //show loading message
		$("#tabs").tabs("select",page_messages);
		$("#tabs").tabs("load",page_messages);
		//initialize component
		//$("textarea").autosize();
	}
	else if(currentHash.search("#search_page")!=-1)
	{
		//get page id
		var temp=currentHash.split("_");
		var pageId=temp[2];
		var sortOption=temp[3];
		var pageResult;
		var inconsistentCriteria=false;
		$('#sortSearchResult').val(sortOption);
		if($.url().fsegment(2)!=undefined) {
			if(searchResultProp.searchCriteria!=$.url().fsegment(2))
				inconsistentCriteria=true;
			searchResultProp.searchCriteria=$.url().fsegment(2);
		}
		if(sortOption!=undefined)
			searchResultProp.sortOption=sortOption;
		logging("load search page=>"+pageId);
		logging("sort option=>"+sortOption);
		
		$("#tabs").tabs("enable","tab_search_result"); //enable search result tab		
		$("#tabs").tabs("select","tab_search_result"); //select search result tab
		$("#tabs").tabs("disable","tab_search_criteria"); //disable search tab
		
		if(searchResult==undefined || inconsistentCriteria) {
			var formData=decodeURIComponent(searchResultProp.searchCriteria);
			var timeout;
			var triggerFunction=function() {
				closePopupMsg();
				triggerHash("#search_criteria");
				clearTimeout(timeout);
			};
			var showTrigger=function() {
				timeout=setTimeout(function (){
					closePopupMsg();
					triggerHash("#search_criteria");
				},5000);
			};
			getSearchResult(formData,0,{
				"async": true,
				"onLoad":function() {
					$('#mask').html('<div class="data" data-page="0" data-sort-option="1">'+layoutTemplate.loadingMsg+'</div>');
					//$('#searchCriteriaLoadingPanel').fadeIn(0); //show loading message
				},
				"onSuccess":function() {
					if(sortOption!=undefined)
						sortSearchResult(sortOption,false);
					else
						sortSearchResult(1,false);
					pageResult=getSearchResultByPage(pageId);
											
					//set currentpage
					searchResultProp.currentPage=pageId;
					//show pagin
					searchResultPagin();
					//create new div to put the data
					$('#mask').append('<div class="nextdata" data-page="'+pageId+'" data-sort-option="'+sortOption+'">'+pageResult+'</div>');
					//Attach serach criteria on related div
					//$('#mask .nextdata[data-page="'+pageId+'"]').data('searchCriteria',searchResultProp.searchCriteria);
					
					//show transition effect
					transit('#mask');
					//sync market
					syncMarket();
				},
				"onEmptyResult":function() {
					buildPopupMsg({
						"content":"Your search did not return any results.<br/>Please redefine search criteria.",
						"showOk":true,
						"title":"No search result",
						"onOk":triggerFunction,
						"onClose":triggerFunction,
						"onShow":showTrigger
					});
				},
				"onError":function() {
					buildPopupMsg({
						"content":result.errorDescription,
						"showOk":true,
						"title":"Error",
						"onOk":triggerFunction,
						"onClose":triggerFunction,
						"onShow":showTrigger
					});
				}
			});
		}
		else {
			if(pageResult!="")
			{
				if(sortOption!=undefined)
					sortSearchResult(sortOption,false);
				else
					sortSearchResult(1,false);
			
				pageResult=getSearchResultByPage(pageId);
				//set currentpage
				searchResultProp.currentPage=pageId;
				//show pagin
				searchResultPagin();
				
				//create new div to put the data if the page has not showing up yet.
				if($('#mask .nextdata[data-page='+pageId+'][data-sort-option='+sortOption+']').length<=0 || searchResultProp.isNewRequest) {
					searchResultProp.isNewRequest=false;
					$('#mask').append('<div class="nextdata" data-page="'+pageId+'" data-sort-option="'+sortOption+'">'+pageResult+'</div>');
					
					//show transition effect
					transit('#mask');
				}
				//sync market
				syncMarket();
			}
		}
	}
	else if(currentHash.search("#portfolio_page")!=-1) {
		var managePortfolioIndex=getIdByName('tab_manage_portfolio');
		//get page id
		var temp=currentHash.split("_");
		var pageId=temp[2];
		var forceToLoad=temp[3];
		logging("load portfolios page=>"+pageId+" ; forceToLoad=>"+forceToLoad);
		
		if($('#tabs').tabs('option','selected') == managePortfolioIndex) {
			$("#tabs").tabs("select","tab_manage_portfolio");
			//set current page
			portfolioProp.currentPage=pageId;
			getPortfolioItemsByPage(pageId,forceToLoad,function() {
				logging("release mutex lock in hashchange");
				globalVars.lockObject.portfolio=0;
			},{
				//setup options for new portfolio
				'container':'#tab_manage_portfolio',
				'mask':'#portfolio_mask',
				'url':getNewPortfolioItemsPath,
				'pageProp':portfolioProp,
				'data':portfolioResult,
				'paginHandler':undefined,
				'paginContainer':'#manage_portfolio_pagin',
				'paginPrefix':'#portfolio_page',
				'renderMode':'p'
			}); //get the data by page.
		}
		else {
			$("#tabs").tabs("select","tab_manage_portfolio");
			//set current page
			portfolioProp.currentPage=pageId;
			//getPortfolioItemsByPage(pageId,forceToLoad); //get the data by page.
		}
	}
	else if(currentHash.search("#collections_page")!=-1)
	{
		var managePortfolioIndex=getIdByName('tab_manage_collections');
		//get page id
		var temp=currentHash.split("_");
		var pageId=temp[2];
		var forceToLoad=temp[3];
		logging("load portfolios page=>"+pageId+" ; forceToLoad=>"+forceToLoad);
		
		if($('#tabs').tabs('option','selected') == managePortfolioIndex)
		{
			$("#tabs").tabs("select","tab_manage_collections");
			//set current page
			portfolioProp.currentPage=pageId;
			getPortfolioItemsByPage(pageId,forceToLoad,function() {
				logging("release mutex lock in hashchange");
				globalVars.lockObject.collections=0;
			},{
				//TODO Setup options for collections
				'paginPrefix':'#collections_page',
				'renderMode':'c'
			}); //get the data by page.
		}
		else
		{
			$("#tabs").tabs("select","tab_manage_collections");
			//set current page
			portfolioProp.currentPage=pageId;
			//getPortfolioItemsByPage(pageId,forceToLoad); //get the data by page.
		}
	}
	else if(currentHash.search("#board_page")!=-1)
	{
		//go to the board tab first
		var tabBoardIndex=getIdByName("tab_manage_board");
		var temp=currentHash.split("_");
		var pId=temp[2];
		var pageId=temp[3];
		var forceToReload=temp[4];
		//check the previous portfolioId and pId is the same or not. If it's different, set the forceToReload property to true, or to false
		if(pId===boardsResult.portfolioId && !forceToReload)
		{
			boardProp.forceToReload=false;
		}
		else
		{
			boardProp.forceToReload=true;
		}
		//set the value to the boards
		boardsResult.portfolioId=pId;
		portfolioProp.portfolioId=pId;
		portfolioProp.preloadPortfolioId=pId;
		boardProp.currentPage=pageId;
		//change tab url
		$("#tabs").tabs("url",tabBoardIndex,boardPath+"/"+pId);
		$('#tabs ul li a[title="tab_manage_board"]').attr('data-mode','c'); //add attrbute on the tab li>a tags
		//if it's already select the boards tab, then load the tab instead of select
		if($('#tabs').tabs('option','selected') == tabBoardIndex)
		{
			//load tab
			$("#tabs").tabs("load",tabBoardIndex);
		}
		else
		{
			//show tab
			$("#tabs").tabs("select",tabBoardIndex);
		}
	}
	else if(currentHash.search("#pboard_page")!=-1) {
		//go to the board tab first
		var tabBoardIndex=getIdByName("tab_manage_board");
		var temp=currentHash.split("_");
		var pId=temp[2];
		var pageId=temp[3];
		var forceToReload=temp[4];
		//check the previous portfolioId and pId is the same or not. If it's different, set the forceToReload property to true, or to false
		if(pId===boardsResult.portfolioId && !forceToReload)
			boardProp.forceToReload=false;
		else
			boardProp.forceToReload=true;
		//set the value to the boards
		boardsResult.portfolioId=pId;
		portfolioProp.portfolioId=pId;
		portfolioProp.preloadPortfolioId=pId;
		boardProp.currentPage=pageId;
		//change tab url
		$("#tabs").tabs("url",tabBoardIndex,pBoardPath+"/"+pId); //reset the url for the tab to the new portfolio
		$('#tabs ul li a[title="tab_manage_board"]').attr('data-mode','p'); //add attrbute on the tab li tags
		//if it's already select the boards tab, then load the tab instead of select
		if($('#tabs').tabs('option','selected') == tabBoardIndex) {
			//load tab
			$("#tabs").tabs("load",tabBoardIndex);
		}
		else {
			//show tab
			$("#tabs").tabs("select",tabBoardIndex);
		}
	}
	else if(currentHash.search("#create_board")!=-1) {
		boardHashChangeHandler(currentHash,createBoardPath,createBoardWithPortfolioPath,'c');
	}
	else if(currentHash.search("#create_pboard")!=-1) {
		boardHashChangeHandler(currentHash,createPBoardPath,createPBoardWithPortfolioPath,'p');
	}
	else if(currentHash.search("#edit_board")!=-1)
	{
		//get page id
		var temp=currentHash.split("_");
		var boardId=temp[2];
		logging("edit board=>"+boardId);
		$('#tabs ul li a[title="tab_create_board"]').attr('data-mode','c'); //add attrbute on the tab li tags
		//change the url
		$("#tabs").tabs("url",getIdByName("tab_create_board"),createBoardPath+"/"+boardId);
		$("#tabs").tabs("select","tab_create_board");
	}
	else if(currentHash.search("#edit_pboard")!=-1) {
		//get page id
		var temp=currentHash.split("_");
		var boardId=temp[2];
		logging("edit board=>"+boardId);
		$('#tabs ul li a[title="tab_create_board"]').attr('data-mode','p'); //add attrbute on the tab li tags
		//change the url
		$("#tabs").tabs("url",getIdByName("tab_create_board"),createPBoardPath+"/"+boardId);
		$("#tabs").tabs("select","tab_create_board");
	}
	else if(currentHash.search("#rating")!=-1)
	{
		//parse the id
		var temp=currentHash.split("_");
		var boardId=$.url().fsegment(2);
		var messageId=$.url().fsegment(3);
		//
		logging("rating=>"+id);
		//set the url
		$("#tabs").tabs("url",getIdByName("tab_rating"),ratingPath+"/"+boardId+"/"+messageId);
		$("#tabs").tabs("select","tab_rating");
	}
	else if(currentHash.search("#design_wall")!=-1)
	{
		//parse the parameter
		logging("PARSING HASH="+currentHash);
		var temp=currentHash.split("_");
		var page=temp[2];
		var sort_column=temp[3];
		var sort_direction=temp[4];
		var page_design_wall=getIdByName("tab_design_wall");
		logging("PAGE_DESIGN WALL"+page_design_wall);
		logging("URL="+appPath+"console/design_wall/"+page+"/"+sort_column+"/"+sort_direction);
		$("#tabs").tabs("url",page_design_wall,designWallPath+"/"+page+"/"+sort_column+"/"+sort_direction);
		//select tab
		logging("SELECT DESIGN WALL");
		$("#tabs").tabs("select",page_design_wall);
		$("#tabs").tabs("load",page_design_wall);
	}
	else if(currentHash.search("#designer_account")!=-1)
	{
		//parse the parameter
		logging("PARSING HASH="+currentHash);
		var temp=currentHash.split("_");
		var page=temp[2];
		var sort_column=temp[3];
		var sort_direction=temp[4];
		var tab_designer_acount=getIdByName("tab_account");
		logging("URL="+designerAccountPath+"/"+page+"/"+sort_column+"/"+sort_direction);
		$("#tabs").tabs("url",tab_designer_acount,designerAccountPath+"/"+page+"/"+sort_column+"/"+sort_direction);
		//select tab
		logging("SELECT DESIGNER ACCOUNT");
		$("#tabs").tabs("select",tab_designer_acount);
		$("#tabs").tabs("load",tab_designer_acount);
	}
	else if(currentHash.search("#search_criteria")!=-1)
	{
		//show search criteria tab
		$("#tabs").tabs("enable","tab_search_criteria"); //enable search result tab		
		$("#tabs").tabs("select","tab_search_criteria"); //select search result tab
		$("#tabs").tabs("disable","tab_search_result"); //disable search tab
	}
	else if(currentHash.search("#alerts")!=-1)
	{
		var tabAlerts=getIdByName("tab_alerts");
		if(tabAlerts!=-1) {
			$("#tabs").tabs("select",tabAlerts);
			$("#tabs").tabs("load",tabAlerts);
		}
		else {
			showConfirmation("You will leave admin console and redirect to alerts tab in user console. Would you like to continue?","Confirmation","leaveAdminConsole",{
				"onOk":function() {
					//back to user console
					location.href=homepage+"#alerts";
				}
			});
		}
	}
	else if(currentHash.search("#shopping_cart")!=-1)
	{
		var checkoutTabIndex=getIdByName("tab_shopping_cart");
		if($("#tabs").tabs('option', 'selected')==checkoutTabIndex)
			$("#tabs").tabs("load",checkoutTabIndex);
		else
			$("#tabs").tabs("select","tab_shopping_cart");
		//check second fragment value, if the value == 88888 and then show Over 10000 error popup.
		if($.url().fsegment(2)=='88888')
		{
			buildPopupMsg({
				"content":"Your transaction amount has to be less than $10,000.00, please remove some items or please contact us for further help. Thank You.",
				"showOk":true,
				"onOk":function(){
					closePopupMsg();
				}
			});
		}
	}
	else if(currentHash.search("#home")!=-1)
	{
		$("#tabs").tabs("select","tab_home");
		//$("#tabs").tabs("load",getIdByName('tab_home'));
	}
	else if(currentHash.search("#edit_company_profile")!=-1)
	{
		$("#tabs").tabs("select","tab_home_edit_mode");
	}
	else if(currentHash.search("#edit_designer_profile")!=-1)
	{
		$("#tabs").tabs("select","tab_home_edit_mode");
	}
	else if(currentHash.search("#activity")!=-1)
	{
		$("#tabs").tabs("select","tab_activity");
	}
	else if(currentHash.search("#edit_portfolio")!=-1)
	{
		var portfolioId=$.url().fsegment(2); //get portfolio id
		$("#tabs").tabs("url",getIdByName("tab_create_portfolio"),manageNewPortfolioPath+"/"+portfolioId); //change the url
		$("#tabs").tabs("select","tab_create_portfolio");
	}
	else if(currentHash.search("#edit_collection")!=-1) {
		var portfolioId=$.url().fsegment(2); //get portfolio id
		$("#tabs").tabs("url",getIdByName("tab_create_collection"),managePortfolioPath+"/"+portfolioId); //change the url
		$("#tabs").tabs("select","tab_create_collection");
	}
	else 
	{
		logging("close=>"+currentHash);
	}
	
	//Hash for popup
	var popupHash="#"+$.url().attr('fragment');
	if(popupHash.search("#nail")!=-1) //check the hash contain '#item' or not
	{
		var match=popupHash.match("#nail[_\\d+]*");
		if(searchResult==undefined) {
			//Fetch searhc result from session
			$.ajax({
				url:searchResultPath,
				type:'POST',
				async:false,
				beforeSend: function() {
					logging('loading');
				},
				error: function (e) {
					logging('syncing search result failed');
				},
				success: function(result) {
					searchResult=result.searchResults;
					searchResultProp.totalPages=Math.ceil(searchResult.length/searchResultProp.itemsPerPage); //calculate the total page
				}
			});
		}
		//get board id
		var temp=match[0].split("_");
		var id=temp[1];
		var showEffect=true;
		logging("show board item=>"+id);
		
		if($('#board_detail').length>0) {
			showEffect=false;
		}
		//close sidebar
		closeSidebar();
		showWindow(id,showEffect,getItemIndexFromObjectContainer(searchResult,id));
	}
	else if(popupHash.search("#board_item")!=-1) {
		//get board id
		var temp=currentHash.split("_");
		var id=temp[2];
		var showEffect=true;
		logging("show board item=>"+id);
		
		if($('#board_detail').length>0) {
			showEffect=false;
		}
		//close sidebar
		closeSidebar();
		showWindow(id,showEffect,getItemIndexFromObjectContainer(searchResult,id));
		/*buildPopup({
			"url":boardDetailPath+"/"+id,
			"showPopup":showEffect,
			"onLoad":function() {
				$('#board_detail .loadingSpinner').fadeIn(500); //show loading panel
			},
			"onClose": function() {
				//unbind the board gallery plugin.
				$(document).off("click",'#board-gallery .control-prev');
				$(document).off("click",'#board-gallery .control-next');
			}
		},function () {
			$(".popup .entity").tinyscrollbar();
			$(".input textarea").autosize(undefined,function() {
				$(".popup .entity").tinyscrollbar_update();
			});
			if(!showEffect)
				$('#board_detail .loadingSpinner').show().fadeOut(300); //hide loading panel
			$('.qtip.qtip-active').css("display","none"); //hide the tooltip if it's active.
			//unbind previous board gallery plugin.
			$(document).off("click",'#board-gallery .control-prev');
			$(document).off("click",'#board-gallery .control-next');
			//bind related board plugin
			$(document).on('click','#board-gallery .control-prev',function () {
				galleryController('prev');	
			})

			$(document).on('click','#board-gallery .control-next',function () {
				galleryController('next');	
			})
		});*/ //show popup
	}
	else {
		closePopup();
	}
}
//End of hash change==================================================================================

//Tab function========================================================================================
function getIdByName(target, focusTabHeaderMode)
{
	if(focusTabHeaderMode) {
		var liItems=$("#tabs").children('ul').children('li');
		var tabNamesTable=new Array();
		if(globalVars.tabNamesTable==undefined) {
			for(var i=0;i<liItems.length;i++)
			{
				tabNamesTable.push($(liItems[i]).children('.li-tab').attr('title'));
			}
			globalVars.tabNamesTable=tabNamesTable;
		}
		else {
			tabNamesTable=globalVars.tabNamesTable;
		}
		for(var i=0;i<tabNamesTable.length;i++)
		{
			if(tabNamesTable[i]==target) {
				return i;
			}
		}
		return -1;
	}
	else {
		//get id by name
		var relTable=$("#tabs").children('div');
		for(var i=0;i<relTable.length;i++)
		{
			if(relTable[i].id==target)
			{
				return i;
			}
		}
		return -1;
	}
}

/*function getIdByName(target)
{
	//get id by name
	var liItems=$("#tabs").children('ul').children('li');
	var tabNamesTable=new Array();
	for(var i=0;i<liItems.length;i++)
	{
		tabNamesTable.push($(liItems[i]).children('.li-tab').attr('title'));
	}
	for(var i=0;i<tabNamesTable.length;i++)
	{
		if(tabNamesTable[i]==target) {
			return i;
		}
	}
	return -1;
}*/
//End of tab function==================================================================================
//Chart================================================================================================
function disableChartLink(target)
{
	//enable all link
	$("#chart_today").attr("href",chartPath+"/1");
	$("#chart_week").attr("href",chartPath+"/7");
	$("#chart_month").attr("href",chartPath+"/30");
	//add underline
	$("#chart_today").attr("style","text-decoration:underline;");
	$("#chart_week").attr("style","text-decoration:underlin;");
	$("#chart_month").attr("style","text-decoration:underlin;");
	//disable link
	$(target).removeAttr("href");
	$(target).attr("style","text-decoration:none;");
}
function initChart(url)
{
	//JSON data structure
	/*
	[[['x label',(y value)],['x label',(y value)].....[]]]
	*/
	//var weekdays=['Mon','Tue','Wed','Thur','Fri','Sat','Sun'];
	logging("INIT CHART=>"+url);
	$.ajax(
	{
		url:url,
		type : "GET",
		dataType:"json",
		beforeSend:function()
		{
			$('#activity_company_grid').stop(true,true);
			$('#activity_designer_grid').stop(true,true);
			$('#activity_company_grid').fadeOut();
			$('#activity_designer_grid').fadeOut();
			logging("Chart Loading");
			$("#activity_chart").html('<div style="margin-left:47%; margin-top:14%"><span style="text-align: center;"><img src="/images/spinner_med_wbg.gif" /></span></div>');
		},
		success: function(result)
		{
			logging("chart success");
			//logging(result);
			if(result.hasError){
				
			}else{
				var data = jQuery.parseJSON(result.data);
				var ticks = jQuery.parseJSON(result.ticks);
				var pointLabels = jQuery.parseJSON(result.pointLabels);
				//var data3 = [[1,4,6,2,6,8,3,5]];
				//var ticks1 = [["label start"],[""], ["label mid1"],[""],["label mid2"],[""],["label last"],[""]];
				//data3 and ticks1 gotta be replaced by data from the controller!
				plotGraph(data,ticks,pointLabels);
				if(result.userType=="company")
					fillCompanyGrid(result.activityGrid);
				else
					fillDesignerGrid(result.activityGrid);
				$('#lblBoardCount').html(result.boardCount);
			}
		}
	});
}

function fillDesignerGrid(item)
{
	var html = [];
	var trClass="odd";
	for (var key=0, size=item.length; key<size;key++) 
	{
		var escapedBoardName=htmlEntities(item[key].boardName);
		var escapedPortfolio=htmlEntities(item[key].portfolioname);
		if(key%2==1)
			trClass="odd";
		else
			trClass="even";
		//determine to show the dummy image or not
		if(item[key].showImage)
			html.push('<tr class="'+trClass+'"><td class="td1">'+ '<a href="javascript:void(0)" class="gridBoardId" data="'+ item[key].boardId +'" title="'+escapedBoardName+'"> <img src="/100x100/' +item[key].boardImageUrl + '"/></a></td>');
		else
			html.push('<tr class="'+trClass+'"><td class="td1">'+ '<a href="javascript:void(0)" class="gridBoardId" data="'+ item[key].boardId +'" title="'+escapedBoardName+'"> <img src="/images/forbidden.jpg"/></a></td>');
		html.push('<td class="td2">'+ '	 <a href="javascript:void(0)" class="gridBoardId" data="'+ item[key].boardId +'" title="'+escapedBoardName+'"><span>' +  escapedBoardName +'</span></a></td>' +
				'<td class="td3">'+ item[key].season +'</td>' +
				'<td class="td4"><span title="'+escapedPortfolio+'">'+ escapedPortfolio +'</span></td>' +
				'<td class="td5">'+ item[key].noofHits +'</td>' +
				'<td class="td6">$'+ item[key].price +'</td></tr>');
	}
	/*if(item.length>100)
		html.push('<tr><td colspan="6">Show More...</td></tr>');*/
	$('#activity_designer_grid').html("");
	$('#activity_designer_grid').html(html.join(''));
	if(item.length<=0)
		$('#activity_designer_grid').html('<tr><td class="empty-grid">Empty</td></tr>');
	$('#activity_designer_grid').fadeIn();
	//update the scroll bar
	$("#grid_scrollbar").tinyscrollbar_update();
}

function fillCompanyGrid(item)
{
	var html = [];
	var trClass="odd";
	for (var key=0, size=item.length; key<size;key++) 
	{
		var escapedBoardName = htmlEntities(item[key].boardName);
		if(key%2==1)
			trClass="odd";
		else
			trClass="even";
		if(item[key].showImage)
		{
			html.push('<tr class="');
			html.push(trClass);
			html.push('"><td class="td1">');
			html.push('<a href="javascript:void(0)" class="gridBoardId" data=');
			html.push(item[key].boardId);
			html.push(' title="'+escapedBoardName+'"> <img src="/100x100/');
			html.push(item[key].boardImageUrl);
			html.push('"/></a></td>');
			//html.push('<tr class="'+trClass+'"><td class="td1">'+ '<a href="javascript:void(0)" class="gridBoardId" data='+ item[key].boardId +'> <img src="/100x100/' +item[key].boardImageUrl + '"/></a></td>');
		}
		else
		{
			html.push('<tr class="');
			html.push(trClass);
			html.push('"><td class="td1">');
			html.push('<a href="javascript:void(0)" class="gridBoardId" data=');
			html.push(item[key].boardId);
			if(item[key].typeCode==undefined)
				html.push(' title="'+escapedBoardName+'"> <img src="/images/forbidden.jpg"/></a></td>');
			else {
				if(item[key].typeCode=="board.unpublished")
					html.push(' title="'+escapedBoardName+'"> <img src="/images/processing.jpg"/></a></td>');
				else
					html.push(' title="'+escapedBoardName+'"> <img src="/images/forbidden.jpg"/></a></td>');
			}
			//html.push('<tr class="'+trClass+'"><td class="td1">'+ '<a href="javascript:void(0)" class="gridBoardId" data='+ item[key].boardId +'> <img src="/images/forbidden.jpg"/></a></td>');
		}
		html.push('<td class="td2">');
		html.push('<a href="javascript:void(0)" class="gridBoardId" data=');
		html.push(item[key].boardId);
		html.push(' title="'+escapedBoardName+'">');
		html.push('<span>'+escapedBoardName+'</span>');
		html.push('</a></td>');
		html.push('<td class="td3">');
		html.push(item[key].season);
		html.push('</td>');
		html.push('<td class="td4">');
		html.push('<a href="javascript:void(0)" class="gridDesignerName" data=');
		html.push(item[key].designerId);
		html.push('>');
		html.push(item[key].designerName);
		html.push('</a></td>');
		html.push('<td class="td5"><img class="credit-unit" src="/images/creditunit.png" alt="FFG Credit" />&nbsp;');
		html.push(convertPriceToCredit(item[key].price));
		html.push('</td>');
		html.push('<td class="td6">');
		html.push(item[key].strDateViewed);
		html.push('</td></tr>');
		/*html.push('<td class="td2">'+ '<a href="javascript:void(0)" class="gridBoardId" data='+ item[key].boardId +'>' +  item[key].boardName 	  +'</a></td>' +
	  			'<td class="td3">'+ item[key].season +'</td>' +
				'<td class="td4">'+ '<a href="javascript:void(0)" class="gridDesignerName" data='+ item[key].designerId +'>' +  item[key].designerName +'</a></td>' +
				'<td class="td5">$'+ item[key].price +'</td>' +
				'<td class="td6">'+ item[key].strDateViewed +'</td></tr>');*/
	}
	/*if(item.length>100)
		html.push('<tr><td colspan="6"><div class="button center">Show More...</div></td></tr>');*/
	$('#activity_company_grid').html("");
	$('#activity_company_grid').html(html.join(''));
	if(item.length<=0)
		$('#activity_company_grid').html('<tr><td style="height:250px; width:100%; text-align:center; font-size:2em">Empty</td></tr>');
	$('#activity_company_grid').fadeIn(1000);
	//update the scroll bar
	$("#grid_scrollbar").tinyscrollbar_update();
}

function plotGraph(data,ticks,pointLabels)
{
	//put the first date into the data object
	$('#activity_chart').data("firstDate",ticks[0]);
	var temp=ticks[0][0].split("/");
	//console.log(temp);
	$.jqplot('activity_chart', data,
	{
		title: 'Viewed Boards',
		//ticks : ticks1,
		axesDefaults: 
		{
			tickRenderer: $.jqplot.CanvasAxisTickRenderer ,
			tickOptions: 
			{
				fontSize: '10pt'
			}
			//showTickMarks: true
		},
		axes: 
		{
		  xaxis: 
		  {
			  renderer: $.jqplot.CategoryAxisRenderer,
			  ticks : ticks
		  },
		  yaxis: 
		  {
			  min: 0,
			  pad: 1.5,
			  tickOptions:
			  {
				  formatString: '%d'
			  }
			 // showTicks: false,
			 // showTickMarks: true
		  }
		},
		seriesDefaults: 
		{ 
	        showMarker:true,
	        markerOptions: { style: 'filledSquare', size:4,color:'blue' },
	        pointLabels: { show:true, labels:pointLabels } 
	    },
	    highlighter: {
            show: true,
            sizeAdjust: 9.5
        }
	}).replot();
}

//End of chart==========================================================================
//shopping cart function================================================================
function syncMarket()
{
	//getCart() //refreshing the shopping cart record
	logging("ITEM TOTAL=>"+$(".form_add_to_cart").size(),"#F00");
	if(globalVars.cart!=undefined)
	{
		for(var i=0;i<$(".form_add_to_cart").size();i++)
		{
			//logging("GET VALUE at "+i+" => "+$(".form_add_to_cart")[i].value);
			//get boardId
			var temp=$(".form_add_to_cart").get(i).name;
			temp=temp.split("_");
			var id=temp[4];
			//logging("board id=>"+id);
			//console.log(cart);
			//logging("cart object=>"+cart);
			if(globalVars.cart!=undefined || globalVars.cart!=null)
			{
				if($.inArray(parseInt(id),globalVars.cart.boardIdList)!=-1) //means the board is already in shopping cart, set the value to true
				{
					$(".form_add_to_cart").get(i).value=true;
					//add the style
					$("#add_board_"+id).addClass("added_to_cart");
				}
				else
				{
					//logging("remove class at "+id);
					$(".form_add_to_cart").get(i).value=false;
					//remove the style
					$("#add_board_"+id).removeClass("added_to_cart");
				}
			}
		}
	}
	else
	{
		logging("cart empty","#F00");
	}
}
function getCart() //get the cart items from session
{
	$.ajax(
	{
		url: getCartItemPath,
		type: "POST",
		error: function()
		{
			logging("get cart error");
		},
		success: function(result)
		{
			//logging("IN CART=>");
			globalVars.cart=result;
			checkShoppingCart(result.count);
			//logging(cart);
		}
	});
}
function checkShoppingCart(count)
{
	//check the session if there is any products in cart
	//if there are boards in shopping cart
	logging("COUNT=>"+count);
	if(count>0)
		$("#cart_icon .cart_icon").attr("src",appConfig.shoppingCartFullImgPath); //show the icon of full cart
	else
		$("#cart_icon .cart_icon").attr("src",appConfig.shoppingCartImgPath); //show the icon of full cart
	
	$('#lblitemCount').html(count);
	//if there is no boards in shopping cart 
	//$("#cart_icon .cart_icon").attr("src","resource/shoppingcart.png"); //show the icon of full cart
}
//animation of moving boards to cart-----------------------
function moveToCart(target,showEffect)
{
	if(showEffect==undefined)
		showEffect=true;
	//get the id from tatget attribute
	var temp=target.split("_");
	//logging("id="+temp[2]); //the last item is the id
	var id=temp[2];
	var price=100;
	var percentage=0.1;
	//retrieve the value in hidden area
	var value=$("[name=form_add_to_cart_"+id+"]").val();
	
	if(value=="false") //if this board is not added to the cart, show the effect add to cart
	{
		//ajax call to add item
		$.ajax(
		{
			url: addItemPath,
			type: "POST",
			data: "boardId="+id+"&boardprice="+price+"&percentage"+percentage,
			beforeSend: function () {
				$('#board_'+id+'+.processingMask').show(); //show loading mask
			},
			error: function() {
				$('#board_'+id+'+.processingMask').hide(); //hide loading mask
			},
			success: function (result)
			{
				$('#board_'+id+'+.processingMask').hide(); //hide loading mask
				if(showEffect)
					effect_addToCart(id);
				
				if(value=="true")
					value=false;
				else
					value=true;
				$("[name=form_add_to_cart_"+id+"]").val(value); //set the value
				checkShoppingCart(result.count);
				globalVars.cart=result;
			}
		});
	}
	else
	{
		//ajax call to reduce item
		$.ajax(
		{
			url: deleteItemPath,
			type: "POST",
			data: "boardId="+id+"&boardprice="+price+"&percentage"+percentage,
			beforeSend: function() {
				$('#board_'+id+'+.processingMask').show(); //show loading mask
			},
			error: function() {
				$('#board_'+id+'+.processingMask').hide(); //hide loading mask
			},
			success: function (result)
			{
				$('#board_'+id+'+.processingMask').hide(); //hide loading mask
				effect_backToMarket(id);
				
				if(value=="true")
					value=false;
				else
					value=true;
				$("[name=form_add_to_cart_"+id+"]").val(value); //set the value
				checkShoppingCart(result.count);
				globalVars.cart=result;
			}
		});
	}
}
function delete_from_cart_by_board_id(board_id)
{
	var price=100;
	var percentage=0.1;
	//retrieve the value in hidden area
	//var value=$("[name=form_add_to_cart_"+board_id+"]").val();
	$.ajax(
	{
		url: deleteItemPath,
		type: "POST",
		data: "boardId="+board_id+"&boardprice="+price+"&percentage"+percentage,
		beforeSend: function () {
			$('#item_id_'+board_id+' .processingMask').show(); //show loading spinner on item itself
		},
		error: function() {
			$('#item_id_'+board_id+' .processingMask').hide(); //show loading spinner on item itself
		},
		success: function (result)
		{
			$('#item_id_'+board_id+' .processingMask').hide(); //show loading spinner on item itself
			closePopupMsg();
			logging("delete_from_cart_by_board_id success");
			checkShoppingCart(result.count);
			globalVars.cart=result;
			
			//remove the item from container
			$("#item_id_"+board_id).remove();
			/*$("#item_id_"+board_id).html("");*/
			$("#total_price").html("$"+result.total);
			//sync market
			syncMarket();
			$("#tabs").tabs("load",getIdByName("tab_shopping_cart"));
			if(result.count>0)
				$("#popup_checkout_button").html("<a href=\"javascript:void(0)\" id=\"to_checkout\"><div class=\"button orangeButton\" id=\"button_checkout\">Checkout</div></a>");
			else
				$("#popup_checkout_button").html("");
			//update the scroll bar
			$("#cart_scrollbar").tinyscrollbar_update("relative");
		}
	});
}

function effect_addToCart(target_id)
{
	//get the location of the cart icon
	var termination=$("#add_to_cart").offset();
	logging("cart:"+termination.top+":"+termination.left);
	//create a stuffid
	var stuffId='stuff_'+target_id+'_0';
	//create a div to append 
	$("body").append('<div class="stuff" id="'+stuffId+'"></div>');
	//reset the stuff
	$("#"+stuffId).css({
		opacity:1,
		width:200,
		height:200
	});
	//copy the target html to stuff
	$("#"+stuffId).html($("#board_"+target_id).html());
	//logging("st="+$("#stuff").html());
	//get the start point
	var start=$("#board_"+target_id).offset();
	logging("cart:"+start.top+":"+start.left);
	//set the initial status
	$("#"+stuffId).css(start);
	$("#"+stuffId).css("display","block"); //show the block
	$('#body').css("cursor","progress");
	$('.add_to_cart').css("cursor","progress");
	//show the effect that moves to the shopping cart
	$("#"+stuffId+" img").animate({
		width: "toggle",
		height: "toggle"
	},1800,'swing');
	$("#"+stuffId).animate({
		top: termination.top+8,
		left: termination.left-90
	},1500,'swing',function()
	{
		$("#"+stuffId).remove();//delete the div the stuff div
		//chage cart icon that is added to cart
		$("#add_board_"+target_id).toggleClass("added_to_cart");
		$('#body').css("cursor","default");
		$('.add_to_cart').css("cursor","pointer");
	});
}
function effect_backToMarket(target_id)
{
	//get the location of the cart icon
	var start=$("#add_to_cart").offset();
	//adjust the start point
	start.top=start.top+8;
	start.left=start.left+50;
	logging("cart:"+start.top+":"+start.left);
	//create a stuffid
	var stuffId='stuff_'+target_id+'_1';
	//create a div to append 
	$("body").append('<div class="stuff" id="'+stuffId+'"></div>');
	//reset the stuff
	$("#"+stuffId).css(
	{
		opacity:1
	});
	//copy the target html to stuff
	$("#"+stuffId).html($("#board_"+target_id).html());
	$("#"+stuffId+" img").css({
		width:0,
		height:0
	});
	$("#"+stuffId).css("display","block"); //show the block
	//logging("st="+$("#stuff").html());
	//get the start point
	var termination=$("#board_"+target_id).offset();
	logging("cart:"+termination.top+":"+termination.left);
	//set the initial pos
	$("#"+stuffId).css(start);
	$('#body').css("cursor","progress");
	$('.add_to_cart').css("cursor","progress");
	//show the effect that moves to the shopping cart
	$("#"+stuffId+" img").animate({
		width:200,
		height:200
	},1500,'swing');
	$("#"+stuffId).animate({
		top: termination.top,
		left: termination.left
	},1500,'swing',function()
	{
		$("#"+stuffId).remove();//delete the div the stuff div
		//chage cart icon that is added to cart
		$("#add_board_"+target_id).toggleClass("added_to_cart");
		$('#body').css("cursor","default");
		$('.add_to_cart').css("cursor","pointer");
	});
}

function addToCart(boardId,callback)
{
	//ajax call to add item
	$.ajax(
	{
		url: addItemPath,
		type: "POST",
		data: "boardId="+boardId,
		beforeSend:function () {
			buildPopupMsg({
				"content": layoutTemplate.loadingPopup,
				"title": "Loading",
				"showOk": false,
				"closeByOverlay": false,
				"effect":false
			});
		},
		error: function() {
			buildPopupMsg({
				"content": 'Please try again. Thank you.',
				"title": "Error",
				"showOk": true,
				"closeByOverlay": false,
				"effect":false
			});
		},
		success: function (result)
		{
			checkShoppingCart(result.count);
			globalVars.cart=result;
			var timeout;
			//show add successful message
			buildPopupMsg({
				"content":"Added to cart successfully<br />(This popup will be closed automatically in 5 seconds)",
				"showOk":true,
				"title":"Add to cart",
				"showOverlay":true,
				"onShow":function(){
					timeout=setTimeout(function (){
						closePopupMsg();
					},5000);
				}
			});
			//load popup again
			if(typeof(callback)==='function')
				callback();
			//sync market
			syncMarket();
			$("#tabs").tabs("load",getIdByName("tab_shopping_cart")); //sync checkout tab
		}
	});	
}
function removeFromCart(boardId)
{
	$.ajax(
	{
		url: deleteItemPath,
		type: "POST",
		data: "boardId="+boardId,
		success: function (result)
		{
			checkShoppingCart(result.count);
			globalVars.cart=result;
			//show remove successful message
			buildPopupMsg({
				"content":"Remove from cart successfully",
				"showOk":true,
				"title":"Remove from cart",
				"showOverlay":true
			});
			//load popup again
			showWindow(boardId,false);
			//sync market
			syncMarket();
			$("#tabs").tabs("load",getIdByName("tab_shopping_cart")); //sync checkout tab
		}
	});
}
//function for board=======================================================
function showCommission()
{
	var table=$("#saleTypeTable tbody").children("tr");
	var saleTypeCount=table.length-1;
	//logging("SALE TYPE SIZE=>"+table.length);
	//fetch the price
	var price="-1.0";
	for(var i=1;i<=saleTypeCount;i++)
	{
		if($("#form_saletype_"+i).attr("checked")=="checked")
		{
			//get the price that user input
			price=$("#form_saletype_"+i+"_cost").val();
			if(!price)
				price="-1.0";
			
		}
	}
	
	//close sidebar
	closeSidebar();
	buildPopup({
		"url":showCommissionPath+'/'+price
	});
}
//update the board if the form of boardId is not null, create the board if the form of boardId is null
function createBoard(isPublished,url,dataMode)
{
	if(isPublished==undefined)
		isPublished=false;
	if(url==undefined)
		url=createBoardPath;
	if(dataMode==undefined)
		dataMode='c';
	calculate(); //calculate the final price
	//get the number of all sale type column
	var table=$("#saleTypeTable tbody").children("tr");
	var saleTypeCount=table.length-1;
	//logging("SALE TYPE SIZE=>"+table.length);
	//fetch the price
	var price="-1.0";
	var pagePrefix='board_page';
	if(dataMode.toLowerCase()=='p')
		pagePrefix='pboard_page';
	for(var i=1;i<=saleTypeCount;i++)
	{
		if($("#form_saletype_"+i).attr("checked")=="checked")
		{
			//get the price that user input
			price=$("#form_saletype_"+i+"_cost").val();
			if(!price)
				price="-1.0";
		}
	}
	//send the request
	$.ajax(
	{
		url: url,
		type: "POST",
		data: $("#form_create_board").serialize()+"&price="+price,
		beforeSend:function() {
			buildPopupMsg({
				"content": '<span style="color:blue;">Please wait...<span><br /><img src="/images/spinner_small.gif" style="margin-top:30px;"/>',
				"title": "Please Wait",
				"showOk": false,
				"closeByOverlay": false,
				"effect":false
			});
		},
		error:function() {
			logging("--createBoard() => Creating board error when calling ajax");
			closePopupMsg();
		},
		success: function(result)
		{
			logging("BOARD RESULT");
			logging(result);
			if(result.hasError)
			{
				var errorInfo = new Array();
				$(".label").removeAttr("style");
				//console.log(result);
				for(var i=0; i<result.errors.length ; i++)
				{
					errorInfo.push(result.errors[i].defaultMessage);
					//helight area
					logging("Error field=>"+result.errors[i].field);
				}
				$("#overlay").fadeOut("fast"); //show the overlay when loading
				//create error content
				var errorContent;
				if(result.errors.length <=0 )
					errorContent=result.errorDescription;
				else
					errorContent=errorInfo.join("<br/>");
				buildPopupMsg({
					"content":errorContent,
					"showOk":true
				});
			}
			else
			{
				//set the flag
				globalVars.isChangedWithoutSubmit=false;
				if(result.type=="create")
				{
					var timeout,
						popupTitle='Create board',
						popupContent='Board created successfully<br />(This popup will be closed automatically in 5 seconds)';
					if(dataMode.toLowerCase()=='p') {
						popupTitle='Create page';
						popupContent='Page created successfully<br />(This popup will be closed automatically in 5 seconds)';
					}
					//TODO user customed popup
					buildPopupMsg({
						"content":popupContent,
						"showOk":true,
						"title":popupTitle,
						"onShow":function(){
								timeout=setTimeout(function(){
								closePopupMsg();
								//change the hash
								triggerHash("#"+pagePrefix+"_"+$("#form_create_board #portfolioId").val()+"_0_1");
								/*if(isPublished)
								{
									//change the hash
									triggerHash("#board_page_"+$("#form_create_board #portfolioId").val()+"_0_1");
								}
								else
									clear();*/
							},5000);
						},
						"onClose":function(){
							//change the hash
							triggerHash("#"+pagePrefix+"_"+$("#form_create_board #portfolioId").val()+"_0_1");
							clearTimeout(timeout);
							/*if(isPublished)
							{
								//change the hash
								triggerHash("#board_page_"+$("#form_create_board #portfolioId").val()+"_0_1");
							}
							else
								clear();*/
						},
						"onOk":function(){
							closePopupMsg();
							//change the hash
							triggerHash("#"+pagePrefix+"_"+$("#form_create_board #portfolioId").val()+"_0_1");
							clearTimeout(timeout); //clearTimeout to avoid trigger hash again.
							/*if(isPublished)
							{
								//change the hash
								triggerHash("#board_page_"+$("#form_create_board #portfolioId").val()+"_0_1");
							}
							else
								clear();*/
						}
					});
					/*if(isPublished)
					{
						//set the flag
						globalVars.isChangedWithoutSubmit=false;
						//change the hash
						location.hash="#board_page_"+$("#form_create_board #portfolioId").val()+"_0";
					}
					else
						clear();*/
				}
				else
				{
					//TODO user customed popup
					var timeout,
						popupTitle='Update board',
						popupContent='Update board successfully<br />(This popup will be closed automatically in 5 seconds)';
					if(dataMode.toLowerCase()=='p') {
						popupTitle='Update page';
						popupContent='Update page successfully<br />(This popup will be closed automatically in 5 seconds)';
					}
					buildPopupMsg({
						"content":popupContent,
						"showOk":true,
						"title":popupTitle,
						"onShow":function(){
								timeout=setTimeout(function(){
								closePopupMsg();
								triggerHash("#"+pagePrefix+"_"+$("#form_create_board #portfolioId").val()+"_0_1");
							},5000);
						},
						"onClose":function() {
							triggerHash("#"+pagePrefix+"_"+$("#form_create_board #portfolioId").val()+"_0_1");
							clearTimeout(timeout);
						},
						"onOk":function() {
							closePopupMsg();
							triggerHash("#"+pagePrefix+"_"+$("#form_create_board #portfolioId").val()+"_0_1");
							clearTimeout(timeout);
						}
					});
					/*if(isPublished)
					{
						//set the flag
						globalVars.isChangedWithoutSubmit=false;
						$("#tabs").tabs("load",getIdByName("tab_manage_collections"));
						//go back to portfolio page
						$("#tabs").tabs("select","tab_manage_collections");
					}
					else
					{
						//change the url
						$("#tabs").tabs("url",getIdByName("tab_create_board"),createBoardPath+"/"+result.boardId);
						//go back to portfolio page
						$("#tabs").tabs("select","tab_create_board");
					}*/
				}
			}
		}
	});
}
function calculate()
{
	//calculate the final price
	//get the number of all sale type column
	var table=$("#saleTypeTable tbody").children("tr");
	var saleTypeCount=table.length-1;
	//logging("SALE TYPE SIZE=>"+table.length);
	for(var i=1;i<=table.length-1;i++)
	{
		if($("#form_saletype_"+i).attr("checked")=="checked")
		{
			//get the price that user input
			var price=$("#form_saletype_"+i+"_cost").val();
			//get F4G rate
			var rate=parseFloat($("#f4g_rate").val());
			var finalPrice=price*(1.0-rate);
			$("#saletype_"+i+"_final").html(finalPrice.toFixed(2));
			//fill in the final price in the form
			$("#form_final_price").val(finalPrice);
		}
	}
}
function clear()
{
	var oldPortfolioId=$('#portfolioId').val();
	logging("CLEAR FORM");
	//retrieve old portfolio id
	//remove the selected attributes on product and product type
	$('#product').val("");
	$('#product option').removeAttr('selected');
	$('#productType').val("");
	$('#productType option').removeAttr('selected');
	//reset the images
	$("#create_board_review").html("");
	//reset the image value
	$("#form_board_image_url").val("");
	//get the number of all sale type column
	var table=$("#saleTypeTable tbody").children("tr");
	var saleTypeCount=table.length-1;
	//reset all fields
	for(var i=1;i<=4;i++)
	{
		if($("#form_saletype_"+i+"_cost").length>0)
			$("#form_saletype_"+i+"_cost").val("0");
		else
			$("#form_saletype_"+i).html("0");
		$("#saletype_"+i+"_final").html("0");
	}
	//uncheck all saletype
//	$('[type="radio"]').removeAttr("checked");
	//clear the form data
	$("#form_final_price").val("0");
	$("#form_create_board")[0].reset(); //reset the form
	$('#portfolioId').val(oldPortfolioId);
	$('#portfolioId').trigger('change');
	$('#product').trigger("change"); //Trigger the change event for product drop down to refersh product type items.
	//refresh multiselect component
	$('#product').multipleSelect("refresh");
	$('#productType').multipleSelect("refresh");
	//reset the default value	
}
function clearSaleTypeTable()
{
	//get the number of all sale type column
	var table=$("#saleTypeTable tbody").children("tr");
	var saleTypeCount=table.length-1;
	//reset all fields
	for(var i=1;i<=saleTypeCount;i++)
	{
		//remove the input fiels
		$("#saletype_"+i).html('<span class="sale-type-credit-static">0</span>&nbsp;=&nbsp;<span class="sale-type-conversion" data-row="'+i+'">$ 0</span>');
		$("#saletype_"+i+"_final").html("0");
	}
	//clear the form data
	$("#form_final_price").val("0");
}
function getBoardsByPortfolioId(id)
{
	logging("Get Boards By=>"+id);
	$.ajax(
	{
		url: getBoardsByPortfolioIdPath+"/"+id,
		type: "POST",
		beforeSend: function()
		{
			//show loading message
			$('#board_mask').html('<div class="data">'+layoutTemplate.loadingMsg+'</div>');
		},
		success: function(result)
		{
			logging("Get boards data","#F00");
			boardsResult.data=result.results;
			//count total pages
			boardProp.totalPages=Math.ceil(result.results.length/boardProp.itemsPerPage);
			logging("Total board pages=>"+boardProp.totalPages);
			//reset the current page
			boardProp.currentPage=0;
			location.hash="#board_page_"+id+"_0";
		}
	});
}
//get the boards data by page and create the html.
//dataMode={'c'=>collections,'p'=>portfolio}
function getBoardsByPage(pId,pageId,forceToReload,dataMode)
{
	var pageContent=[];
	if(dataMode==undefined)
		dataMode='c';
	if(boardsResult.data==null || forceToReload===true || forceToReload===undefined)
	{
		//TODO load board result
		$.ajax(
		{
			url: getBoardsByPortfolioIdPath+"/"+pId,
			type: "POST",
			beforeSend: function()
			{
				//show loading message
				$('#board_mask').html('<div class="data">'+layoutTemplate.loadingMsg+'</div>');
			},
			success: function(result)
			{
				logging("Get boards data successfully=>"+pId+" ; "+pageId,"#F00");
				boardsResult.data=result.results;
				boardsResult.visible=result.isVisibleDesigner;
				//count total pages
				boardProp.totalPages=Math.ceil(result.results.length/boardProp.itemsPerPage);
				logging("Total board pages=>"+boardProp.totalPages);
				//Load page again
				getBoardsByPage(pId,pageId,false,dataMode);
			}
		});
	}
	else
	{
		pageId=parseInt(pageId);
		for(var i=pageId*boardProp.itemsPerPage;i<(pageId+1)*boardProp.itemsPerPage;i++)
		{
			var item=boardsResult.data[i];
			if(item!=undefined)
			{
				var pName=htmlEntities(item.name);
				var choppedName=item.name;
				//Chop the string
				if(choppedName.length>26)
					choppedName=choppedName.substring(0,25)+" ...";
				choppedName=htmlEntities(choppedName);
				var nail=[];
				nail.push('<div class="item '+dataMode+'">');
				nail.push('<div class="item-function">');
				if(dataMode.toLowerCase()=='c') {
					nail.push('<div class="edit"><a data="'+item.boardId+'" data-mode="'+dataMode+'">Edit</a></div>');
					nail.push('<div class="delete_board" data="'+item.boardId+'" data-mode="'+dataMode+'"><img src="/images/recycle_bin.png" /></div>');
					nail.push('<div class="status"> '+item.boardStatus+'</div>');
					if(item.boardStatus!="Expired") {
						if(item.boardStatus=="Unpublished")
							nail.push('<div class="toggleStatus togglePubstatus_board" data="'+item.boardId+'"><img src="/images/order.png" /></div>');
						else
							nail.push('<div class="toggleStatus toggleHidstatus_board" data="'+item.boardId+'"><img src="/images/order.png" /></div>');
					}
				}
				else {
					nail.push('<div class="board_name" title="'+pName+'">'+choppedName+'</div>');
					nail.push('<div class="delete_board" data="'+item.boardId+'" data-mode="'+dataMode+'"><img src="/images/recycle_bin.png" /></div>');
					nail.push('<div class="edit"><a data="'+item.boardId+'" data-mode="'+dataMode+'">Update</a></div>');
				}
				nail.push('</div>');
				if(dataMode.toLowerCase()=='c') {
					nail.push('<a href="#board_item_'+item.boardId+'" id="board_'+item.boardId+'" class="designerBoardLink" data="'+item.boardId+'" data-mode="'+dataMode+'">');
					nail.push('<div class="board"><i></i>');
					if(item.boardImages.length > 0)
						nail.push('<img src="/400x400/'+item.boardImages[item.boardImages.length-1].fileName+'" />'); //image resource
					nail.push('</div>');
					nail.push('</a>');
				}
				else {
					nail.push('<a href="javascript:void(0);" class="enlargeImage" id="board_'+item.boardId+'" image-data="'+item.boardImages[item.boardImages.length-1].mainImageUrl+'" data="'+item.boardId+'" data-mode="'+dataMode+'">');
					nail.push('<div class="board"><i></i>');
					switch(item.publishToMP) {
					case 0:
						if(item.lastupdateby==2)
							nail.push('<div class="imgFlag lt rj">Resubmit</div>');
						else
							nail.push('<div class="imgFlag lt pr">Private</div>');
						break;
					case 1:
						nail.push('<div class="imgFlag rt pb">Published</div>');
						break;
					case 2:
						nail.push('<div class="imgFlag lt rv">Reviewing</div><div class="imgFlag rt rj">Not Published Yet</div>');
						break;
					}
					if(item.boardImages.length > 0)
						nail.push('<img src="/400x400/'+item.boardImages[item.boardImages.length-1].fileName+'" />'); //image resource
					nail.push('</div>');
					nail.push('</a>');
				}
				nail.push('<div class="detail">');
				if(dataMode.toLowerCase()=='c') {
					if(creditConversionToUsd==undefined) //reset to default price if variable is undefined
						creditConversionToUsd=25;
					nail.push('<div class="board_name" title="'+pName+'">'+choppedName+'</div>');
					nail.push('<div class="price">'+item.boardPrice+' FFG credits<span>$&nbsp;'+(item.boardPrice*creditConversionToUsd)+'</span></div>');
				}
				//nail.push('<div class="board_name" title="'+pName+'">'+choppedName+'</div>');
				//nail+='<div class="checkbox"><input name="selectedItems" type="checkbox" value="'+item.boardId+'" id="form_board_'+item.boardId+'"/></div>';
				nail.push('</div>');
				nail.push('</div>');
				pageContent.push(nail.join(''));
			}
		}
		//show effect
		if(pageContent.length<=0) { //if the length less than 0, show empty message
			if(dataMode.toLowerCase()=='c')
				$('#board_mask').append('<div class="nextdata">'+layoutTemplate.emptyBoardMsg+'</div>');
			else
				$('#board_mask').append('<div class="nextdata"></div>');
		}
		else {	
			$('#board_mask').append('<div class="nextdata">'+pageContent.join('')+'</div>'); //create new div to put the data
		}
		//show the popup if the designer is invisible
		if(dataMode.toLowerCase()=='p') {
			$('#add_manage_page').removeAttr('button-disabled').removeClass('show-qtip').removeAttr('title');
			if(!boardsResult.visible) 
				$('#board_mask .nextdata').append(layoutTemplate.reqPortfolioBoardMsg);
			if (boardsResult.data.length >= 8) {
				var title=$('#add_manage_page').attr('data-title');
				$('#add_manage_page').attr('button-disabled','true').attr('title',title).addClass('show-qtip');
			}
			boardsPagin('pboard_page'); //setup board page prefix
		}
		else {
			if(!boardsResult.visible) {
				navigate($('.li-portfolio'));
				$('#board_mask .nextdata').append(layoutTemplate.invisibleDesignerMsg);
			}
			boardsPagin();
		}
		//show transition effect
		transit('#board_mask');
	}
}
function boardsPagin(pagePrefix)  
{
	if(pagePrefix==undefined)
		pagePrefix='board_page';
	logging("Refresh boards pagin","#0F0");
	var pagin="";
	logging("cpage=>"+boardProp.currentPage);
	var pagin="";
	boardProp.currentPage=parseInt(boardProp.currentPage);
	//show head pagin
	if(boardProp.currentPage==0)
		pagin+='1&nbsp;';
	else
		pagin+='<a href="#'+pagePrefix+'_'+portfolioProp.portfolioId+'_0">1</a>&nbsp;';
	//show middle page if the totalPages > 2,(equals to 2 means only head and tail)
	if(boardProp.totalPages>2)
	{
		//show ... before current page
		if(boardProp.currentPage>=3)
			pagin+='...&nbsp;';
		//show adajacent page
		if(boardProp.currentPage>=2)
			pagin+='<a href="#'+pagePrefix+'_'+portfolioProp.portfolioId+'_'+(boardProp.currentPage-1)+'">'+(boardProp.currentPage)+'</a>&nbsp;';
		//current page
		if(boardProp.currentPage!=0 && boardProp.currentPage!=boardProp.totalPages-1)
			pagin+=(boardProp.currentPage+1)+'&nbsp;';
		//show adajacent page
		if(boardProp.totalPages-boardProp.currentPage>=3)
			pagin+='<a href="#'+pagePrefix+'_'+portfolioProp.portfolioId+'_'+(boardProp.currentPage+1)+'">'+(boardProp.currentPage+2)+'</a>&nbsp;';
		//show ... after current page
		if(boardProp.totalPages-boardProp.currentPage>=4)
			pagin+='...&nbsp;';
	}
	//show tail pagin
	if(boardProp.totalPages>=2)
	{
		if(boardProp.currentPage==boardProp.totalPages-1)
			pagin+=boardProp.totalPages+'&nbsp;';
		else
			pagin+='<a href="#'+pagePrefix+'_'+portfolioProp.portfolioId+'_'+(boardProp.totalPages-1)+'">'+boardProp.totalPages+'</a>&nbsp;';
	}
	
	$("#manage_board_pagin").html("Pages:&nbsp;"+pagin);
}
/*function deleteBoard()
{
	//check the form data is empty or not
	//if($("#form_boards").serialize()!='')
	//{
		//logging("Delete board form=>"+$("#form_boards").serialize());
		//show confirm window
		var r=confirm("It will delete your boards. Continue?");
		if (r==true)
		{
			$.ajax(
			{
				url: deleteBoardPath,
				type: "POST",
				data: $("#form_boards").serialize(),
				success: function(result)
				{
					logging("delete board result");
					if(result.hasError)
					{
						logging("ERROR OCCURED");
					}	
					else
					{
						logging("REFRESH BOARDS");
						//trigger the refresh event
						$("body").trigger("refresh_board",[portfolioId]);
						//location.hash="#board_page_"+portfolioId+"_"+currentPage_board;
						//getBoardsByPortfolioId(portfolioId);
					}
				}
			});
		}
	//}
	//else
	//{
		//showErrorMsg("Please Select board(s) to delete",true);
	//}
}*/
function prevBoardPage(pagePrefix)
{
	if(pagePrefix==undefined)
		pagePrefix='board_page';
	logging("board prev");
	logging(portfolioProp);
	//load data using ajax
	
	boardProp.currentPage--;
	if(boardProp.currentPage<0)
		boardProp.currentPage=boardProp.totalPages-1;
	//change hash
	location.hash='#'+pagePrefix+'_'+portfolioProp.preloadPortfolioId+"_"+boardProp.currentPage;
}
function nextBoardPage(pagePrefix)
{
	if(pagePrefix==undefined)
		pagePrefix='board_page';
	logging("board next");
	logging(portfolioProp);
	//load data using ajax
	
	boardProp.currentPage++;
	if(boardProp.currentPage>=boardProp.totalPages)
		boardProp.currentPage=0;
	//change hash
	location.hash='#'+pagePrefix+'_'+portfolioProp.preloadPortfolioId+"_"+boardProp.currentPage;
}
function refreshBoards(pId,dataMode)
{
	if(dataMode==undefined)
		dataMode='c';
	//change hash
	if(dataMode.toLowerCase()=='c')
		triggerHash("#board_page_"+portfolioProp.portfolioId+"_"+boardProp.currentPage+"_1");
	else
		triggerHash("#pboard_page_"+portfolioProp.portfolioId+"_"+boardProp.currentPage+"_1");
	/*if(location.hash==="#board_page_"+portfolioProp.portfolioId+"_"+boardProp.currentPage+"_1") //if the hash is already the same, trigger it forcely.
	{
		$(window).hashchange();
	}
	else
		location.hash="board_page_"+portfolioProp.portfolioId+"_"+boardProp.currentPage+"_1";*/
	/*$.ajax(
	{
		url: getBoardsByPortfolioIdPath+"/"+pId,
		type: "POST",
		success: function(result)
		{
			logging("Get boards data");
			boardsResult.portfolioId=pId;
			boardsResult.data=result.results;
			//count total pages
			boardProp.totalPages=Math.ceil(result.results.length/boardProp.itemsPerPage);
			logging("Total board pages=>"+boardProp.totalPages);
			//reset the current page
			boardProp.currentPage=0;

			//get the first page of boards data, and show on the page
			$('#board_mask').append('<div class="nextdata">'+getBoardsByPage(0)+'</div>');
			//show transition effect
			transit('#board_mask');
		}
	});*/
}
function checkFileTypeAndSaleType(forceToSelect)
{
	if(forceToSelect==undefined)
		forceToSelect=false;
	//get selected radio button
	//get upload file type
	var saletype=$('#saleTypeTable input[type="radio"]:checked').attr("code");
	var filetype=$('#form_board_image_type').val();
	if(filetype=='ai')
	{
		if(saletype=="JG")
		{
			buildPopupMsg({
				"content":"The file you uploaded is AI(PDF), please select the appropriate option for FILE TYPES + AVAILABLE OPTIONS. Thank you.",
				"showOk":true,
				"title":"File Type Inconsistent",
				"showOverlay":true
			});
			return false;
		}
	}
	else if(filetype=='jpg')
	{
		if(saletype!="JG")
		{
			//console.log("file type inconsistent");
			buildPopupMsg({
				"content":"The file you uploaded is JPG, please select the appropriate option for FILE TYPES + AVAILABLE OPTIONS. Thank you.",
				"showOk":true,
				"title":"File Type Inconsistent",
				"showOverlay":true
			});
			return false;
		}
	}
	return true;
}
//End of board related function========================================================================

//Board Level List getter=================================================
function getCategoryList(parentId,options)
{
	var defaultOptions = {
		"target": "#form_category",
		"triggerChangeTarget": true,
		"haveDontCareTag":false
	};
	options=$.extend({},defaultOptions,options);
	
	if(parentId==-1) {
		$("#form_category").html(layoutTemplate.optionDefaultCategory);
		$(options.target).trigger("change");
	}
	else {
		//get category list
		$.ajax(
		{
			cache: false,
			url: categoryListPath+"/"+parentId,
			type: "GET",
			timeout: 5000,
			beforeSend: function(xhr)
			{
				$("#form_category").html(layoutTemplate.optionLoadingMsg);  //add the default list
			},
			error: function(jqXHR, textStatus, errorThrown)
			{
				logging("Error=>"+jqXHR+";"+textStatus+";"+errorThrown);
				//console.log("Error=>"+jqXHR+";"+textStatus+";"+errorThrown);
				$("#form_category").html(layoutTemplate.optionEmpty);
			},
			success: function(result,status)
			{
				logging("GET CATEGORY=>"+result.list.length);
				//console.log(result);
				var optionList;
				if(result.list.length<=0)
				{
					optionList=layoutTemplate.optionEmpty;
				}
				else
				{
					//create default msg
					if(options.haveDontCareTag) {
						optionList=layoutTemplate.optionDefaultMsgWithDontCare;
					}
					else {
						optionList=layoutTemplate.optionDefaultMsg;
					}
					//create options tag
					for(var i=0;i<result.list.length;i++)
					{
						optionList+='<option value='+result.list[i].categoryId+'>'+result.list[i].name+'</option>';
						//logging("LIST "+i+" => "+optionList);
					}
				}
				$("#form_category").html(optionList);
				//trigger change event
				if(options.triggerChangeTarget) {
					$(options.target).trigger("change");
				}
			},
			complete: function(jqXHR, textStatus)
			{
				logging("AJAX Complete=>"+jqXHR+":"+textStatus);
				//console.log("AJAX Complete=>"+jqXHR+":"+textStatus);
			}
		});
	}
}
function getProductList(parentId,options)
{
	var defaultOptions = {
		"target": "#form_product",
		"triggerChangeTarget": true,
		"haveDontCareTag":false
	};
	options=$.extend({},defaultOptions,options);
	
	if(parentId==-1) {
		$("#form_product").html(layoutTemplate.optionDefaultProduct);
		$(options.target).trigger("change");
	}
	else {
		$.ajax(
		{
			cache: false,
			url: productListPath+"/"+parentId,
			type: "GET",
			timeout: 5000,
			beforeSend: function(xhr)
			{
				$("#form_product").html(layoutTemplate.optionLoadingMsg);  //add the default list
			},
			error: function(jqXHR, textStatus, errorThrown)
			{
				logging("Error=>"+jqXHR+";"+textStatus+";"+errorThrown);
				//console.log("Error=>"+jqXHR+";"+textStatus+";"+errorThrown);
				$("#form_product").html("");
			},
			success: function(result,status)
			{
				logging("GET LEVEL=>"+result.list.length);
				//console.log(result);
				var optionList;
				if(result.list.length<=0)
				{
					optionList=layoutTemplate.optionEmpty;
				}
				else
				{
					//create default msg
					if(options.haveDontCareTag) {
						optionList=layoutTemplate.optionDefaultProductWithDontCare;
					}
					else {
						optionList=layoutTemplate.optionDefaultMsg;
					}
					//create options tag
					for(var i=0;i<result.list.length;i++)
					{
						optionList+='<option value="'+result.list[i].name+'">'+result.list[i].name+'</option>';
						//logging("LIST "+i+" => "+optionList);
					}
				}
				$("#form_product").html(optionList);
				//trigger next level event
				if(options.triggerChangeTarget) {
					$(options.target).trigger("change");
				}
			},
			complete: function(jqXHR, textStatus)
			{
				logging("AJAX Complete=>"+jqXHR+":"+textStatus);
				//console.log("AJAX Complete=>"+jqXHR+":"+textStatus);
			}
		});
	}
}
function getProductTypeList(level1Id,level2Id,parentName,options)
{
	var defaultOptions = {
		"target": "#form_product",
		"container":"#form_product_type",
		"triggerChangeTarget": true,
		"haveDontCareTag":false,
		"onLoad":$.noop,
		"onError":$.noop,
		"onSuccess":$.noop,
		"data":'level1='+level1Id+'&level2='+level2Id+'&productTags='+encodeURIComponent(parentName),
		"rememberOldValue":false
	};
	options=$.extend({},defaultOptions,options);
	var oldValue;
	if(options.rememberOldValue)
		oldValue = $(options.container).val(); //remember old value
	if(parentName==-1) {
		$(options.container).html(layoutTemplate.optionDefaultProductType);
		refershMultiselect(options.container); //Refresh multi-select plugin
	}
	else {
		$.ajax(
		{
			cache: false,
			url: productTypeListPath,
			type: "GET",
			data: options.data,
			timeout: 5000,
			beforeSend: function(xhr)
			{
				options.onLoad();
				$(options.container).html(layoutTemplate.optionLoadingMsg);  //add the default list
				$(options.container+' + .mselect').html("Loading..."); //add loading text in the component.
			},
			error: function(jqXHR, textStatus, errorThrown)
			{
				logging("Error=>"+jqXHR+";"+textStatus+";"+errorThrown);
				options.onError();
				//console.log("Error=>"+jqXHR+";"+textStatus+";"+errorThrown);
				$(options.container).html("");
			},
			success: function(result,status)
			{
				logging("GET LEVEL=>"+result.list.length);
				//console.log(result);
				var optionList;
				if(result.list.length<=0)
				{
					optionList=layoutTemplate.optionEmptyWithDisabledAttr;
				}
				else
				{
					//create default msg
					if(options.haveDontCareTag) {
						optionList=layoutTemplate.optionDefaultProductTypeWithDontCare;
					}
					else {
						optionList=layoutTemplate.optionDefaultMsgWithDisabledAttr;
					}
					//create options tag
					for(var i=0;i<result.list.length;i++)
					{
						optionList+='<option value="'+result.list[i].name+'">'+result.list[i].name+'</option>';
						//logging("LIST "+i+" => "+optionList);
					}
			}
				$(options.container).html(optionList);
				if(options.rememberOldValue)
					$(options.container).val(oldValue); //put the old value back from the element binding data
				//Refresh multi-select plugin
				refershMultiselect(options.container);
				options.onSuccess();
			},
			complete: function(jqXHR, textStatus)
			{
				logging("AJAX Complete=>"+jqXHR+":"+textStatus);
				//console.log("AJAX Complete=>"+jqXHR+":"+textStatus);
			}
		});
	}
}
//End of board level list getter===========================================================

//Search Result related functions=======================================//
//TODO Depricated function. 
function initSeasonsList(mode)
{
	logging("season Path=>"+seasonYearListPath);
	$("#season").html("Loading Data, Please wait...");
	$.ajax(
	{
		url: seasonYearListPath+"/"+mode,
		type: "GET",
		success: function(result)
		{
			//To deleted the undefined node in JSON object(For IE 8)
			var jsonOb=processJSONObject(result); //convert the string to json object.
			//initialize the tree plug-in
			$('#season').tree(
			{
				data: jsonOb,
				autoOpen: false,
				dragAndDrop: false
			});
			//select current year
			var currentYear=new Date();
			currentYear=currentYear.getFullYear();
			var node = $('#season').tree('getNodeById', currentYear);
			$('#season').tree('openNode', node);
		}
	});
	//$("#form_division_search_criteria").trigger("change");
}
function getSearchResult(searchCriteria,page,options)
{
	var defaultOptions = {
		"async":true,
		"onLoad":$.noop,
		"onSuccess":$.noop,
		"onEmptyResult":$.noop,
		"onError":$.noop
	};
	options=$.extend({},defaultOptions,options);
	logging("submit");
	//load data using ajax
	//If the value of category, product, and product type=-1,replace it with empty string;
	searchCriteria=searchCriteria.replace("&division=-1","");
	searchCriteria=searchCriteria.replace("&category=-1","");
	searchCriteria=searchCriteria.replace("&product=-1","");
	searchCriteria=searchCriteria.replace("&productType=-1","");
	logging("search form=>"+searchCriteria);
	//get shopping cart list
	//var cart=getCart();
	
	//
	$.ajax(
	{
		url: searchResultPath,
		data: searchCriteria,
		type: "GET",
		async: options.async,
		beforeSend: function()
		{
			options.onLoad();
			//$('#searchCriteriaLoadingPanel').fadeIn(0); //show loading message
		},
		success: function(result)
		{	
			$('#searchCriteriaLoadingPanel').fadeOut(0); //hide loading messag
			if(result.hasError == false)
			{
				if(result.results.length ==0)
				{
					//Trigger empty result event
					options.onEmptyResult();
					/*buildPopupMsg({
						"content":"Your search did not return any results.<br/>Please redefine search criteria.",
						"showOk":true,
						"title":"No search result"
					});*/
				}
				else
				{
					//display results				
					//sava search result in an array
					searchResult=result.results;
					//calculate the total page
					searchResultProp.totalPages=Math.ceil(result.results.length/searchResultProp.itemsPerPage);
					logging("TOTAL SEARCH ITEMS=>"+result.results.length);
					logging("Current Page=>"+searchResultProp.currentPage+" ; Total Pages=>"+searchResultProp.totalPages);
					logging("Show item from "+(0*searchResultProp.itemsPerPage)+" to "+(((searchResultProp.currentPage+1)*searchResultProp.itemsPerPage)-1));
					//change hash
					options.onSuccess();
					//location.hash="#search_page_0/"+encodeURIComponent(searchCriteria);
					
					//$("#tabs").tabs("enable","tab_search_result"); //enable search result tab
					//if we select would send a request to server and renders the original page..
					//$("#tabs").tabs("select","tab_search_result"); //select search result tab
					//$("#tabs").tabs("disable","tab_search_criteria"); //disable search tab
				}
			}else
			{
				//Trigger error event
				options.onError(result);
				/*buildPopupMsg({
					"content":result.errorDescription,
					"showOk":true,
					"title":"Error"
				});*/
			}

		}
	});
}

function getSearchResultByPage(page)
{
	var pageResult=[];
	//get the current page data
	if(searchResult!=undefined)
	{
		for(var i=page*searchResultProp.itemsPerPage;i<(page+1)*searchResultProp.itemsPerPage;i++)
		{
			var val=searchResult[i];
			if(val!=undefined)
			{
				/*var nail="";*/
				/*pageResult.push('<div class="nail" id="item'+val.boardId+'">');
				pageResult.push('<div class="name">'+val.name+'</div>');
				pageResult.push('<div class="check"><div id="add_board_'+val.boardId+'" class="add_to_cart"></div><input class="form_add_to_cart" name="form_add_to_cart_'+val.boardId+'" type="hidden" value="false"/></div>');
				pageResult.push('<a href="javascript:void(0)" class="boardLink" data="'+val.boardId+'"><div class="pic" id="board_'+val.boardId+'"><img src="/100x100/'+val.thumbnailUrl+'" style="width:auto; height:100%"/></div></a>');
				pageResult.push('<div class="nailfunctions"></div>');
				pageResult.push('<div class="detail">&nbsp;$'+val.totalPrice+'</div>');
				pageResult.push('</div>');*/
				
				//
				var pName=htmlEntities(val.name);
				var choppedName=val.name;
				if(choppedName.length>40) //Chop the string
					choppedName=choppedName.substring(0,39)+" ...";
				choppedName=htmlEntities(choppedName);
				pageResult.push('<div class="item">');
				pageResult.push('<div class="item-function">');
				pageResult.push('<div class="edit"><div id="add_board_'+val.boardId+'" class="add_to_cart"></div><input class="form_add_to_cart" name="form_add_to_cart_'+val.boardId+'" type="hidden" value="false"/></div>');
				pageResult.push('<div class="item-label" title="'+pName+'"><div class="board-name">'+choppedName+'</div>');
				pageResult.push('<div class="board-price">Price&nbsp;<img class="credit-unit" src="/images/creditunit.png" alt="FFG Credit" />&nbsp;'+convertPriceToCredit(val.salePrice)+'</div>');
				pageResult.push('</div></div>');
				//pageResult.push('<a href="#board_item_'+val.boardId+'" id="board_'+val.boardId+'" class="designerBoardLink" data="'+val.boardId+'">');
				pageResult.push('<a id="board_'+val.boardId+'" class="nailBoardLink" data="'+val.boardId+'">');
				pageResult.push('<div class="board"><i></i>');
				pageResult.push('<img src="/400x400/'+val.tileImageUrl+'" />'); //image resource
				pageResult.push('</div>');
				pageResult.push('</a><div class="processingMask"/>');
				pageResult.push('<div class="detail">');
				pageResult.push('<div class="board_name">'+choppedName+'</div>');
				pageResult.push('<div class="price">Price&nbsp;<img class="credit-unit" src="/images/creditunit.png" alt="FFG Credit"/>&nbsp;'+convertPriceToCredit(val.salePrice)+'</div>');
				pageResult.push('</div>');
				pageResult.push('</div>');
				/*pageResult+=nail;*/
			}
		}
	}
	return pageResult.join('');
}
function searchResultPagin()
{
	logging("Refresh search result pagin","#0F0");
	logging("cpage=>"+searchResultProp.currentPage);
	var pagin="";
	searchResultProp.currentPage=parseInt(searchResultProp.currentPage);
	//show head pagin
	if(searchResultProp.currentPage==0)
		pagin+='1&nbsp;';
	else
		pagin+='<a href="#search_page_0_${sortOption}/${searchCriteria}">1</a>&nbsp;';
	//show middle page if the totalPages > 2,(equals to 2 means only head and tail)
	if(searchResultProp.totalPages>2)
	{
		//show ... before current page
		if(searchResultProp.currentPage>=3)
			pagin+='...&nbsp;';
		//show adajacent page
		if(searchResultProp.currentPage>=2)
			pagin+='<a href="#search_page_'+(searchResultProp.currentPage-1)+'_${sortOption}/${searchCriteria}">'+(searchResultProp.currentPage)+'</a>&nbsp;';
		//current page
		if(searchResultProp.currentPage!=0 && searchResultProp.currentPage!=searchResultProp.totalPages-1)
			pagin+=(searchResultProp.currentPage+1)+'&nbsp;';
		//show adajacent page
		if(searchResultProp.totalPages-searchResultProp.currentPage>=3)
			pagin+='<a href="#search_page_'+(searchResultProp.currentPage+1)+'_${sortOption}/${searchCriteria}">'+(searchResultProp.currentPage+2)+'</a>&nbsp;';
		//show ... after current page
		if(searchResultProp.totalPages-searchResultProp.currentPage>=4)
			pagin+='...&nbsp;';
	}
	//show tail pagin
	if(searchResultProp.totalPages>=2)
	{
		if(searchResultProp.currentPage==searchResultProp.totalPages-1)
			pagin+=searchResultProp.totalPages+'&nbsp;';
		else
			pagin+='<a href="#search_page_'+(searchResultProp.totalPages-1)+'_${sortOption}/${searchCriteria}">'+searchResultProp.totalPages+'</a>&nbsp;';
	}
	//fill search criteria to href attr
	pagin=pagin.replace(/\$\{searchCriteria\}/g,searchResultProp.searchCriteria);
	//fill sort option to href attr
	pagin=pagin.replace(/\$\{sortOption\}/g,$('#sortSearchResult').val());
	/*for(var i=0;i<totalPages;i++)
	{
		pagin+='<a href="#search_page_'+i+'">'+(i+1)+'</a>&nbsp;';
	}*/
	$("#searchResultPagin .pages").html('<span style="font-weight: bold;">Pages:&nbsp;</span>'+pagin);
}
function sortSearchResult(optionValue,doTransit)
{
	var compareById = function (a,b) {
		if(b.boardId>a.boardId)
			return 1;
		else
			return -1;
	}
		
	if(basicConfig.enableSorting)
	{
		switch(optionValue)
		{
		case "1":
			logging("Sort by date ASC");
			searchResult.sort(function(a,b)
			{
				if(b.date>a.date)
					return -1;
				else if(b.date==a.date) {
					return compareById(a,b);
				}
				else
					return 1;
			});
			break;
		case "2":
			logging("Sort by date DESC");
			searchResult.sort(function(a,b)
			{
				if(b.date>a.date)
					return 1;
				else if(b.date==a.date) {
					return compareById(a,b);
				}
				else
					return -1;
			});
			break;
		case "3":
			logging("Sort by Designer ASC");
			searchResult.sort(function(a,b)
			{
				if(b.designerName.toUpperCase()>a.designerName.toUpperCase())
					return -1;
				else if(b.designerName.toUpperCase()==a.designerName.toUpperCase()) {
					return compareById(a,b);
				}
				else
					return 1;
			});
			break;
		case "4":
			logging("Sort by Designer DESC");
			searchResult.sort(function(a,b)
			{
				if(b.designerName.toUpperCase()>a.designerName.toUpperCase())
					return 1;
				else if(b.designerName.toUpperCase()==a.designerName.toUpperCase()) {
					return compareById(a,b);
				}
				else
					return -1;
			});
			break;
		case "5":
			logging("Sort by Board Name ASC");
			searchResult.sort(function(a,b)
			{
				if(b.name.toUpperCase()>a.name.toUpperCase())
					return -1;
				else if(b.name.toUpperCase()==a.name.toUpperCase()) {
					return compareById(a,b);
				}
				else
					return 1;
			});
			break;
		case "6":
			logging("Sort by Board Name DESC");
			searchResult.sort(function(a,b)
			{
				if(b.name.toUpperCase()>a.name.toUpperCase())
					return 1;
				else if(b.name.toUpperCase()==a.name.toUpperCase()) {
					return compareById(a,b);
				}
				else
					return -1;
			});
			break;
		/*case "99":
			searchResult.sort(function(a,b)
			{
				if(b.boardId>a.boardId)
					return -1;
				else
					return 1;
			});
			break;*/
		default:
			logging("Sorting what?");
			break;
		}
		//show page number
		searchResultPagin();
		if(doTransit || doTransit==undefined) {
			//create new div to put the data
			$('#mask').append('<div class="nextdata" data-page="0" data-sort-option="'+optionValue+'">'+getSearchResultByPage(0)+'</div>');
			
			//show transition effect
			transit('#mask');
		}
		//sync market
		syncMarket();
	}
}
//End of search result==================================================//

//portfolio related functions===========================================//
function createPortfolio(editMode,dataMode)
{
	if(dataMode==undefined)
		dataMode='c';
	var errors= CheckCreatePortfolioInput();
	var url = createPortfolioPath;
	var formData=$('#form_create_portfolio').serialize();
	if(editMode == 'true') {
		if(dataMode.toLowerCase()=='c')
			url=editPortfolioPath;
		else if(dataMode.toLowerCase()=='p')
			url=editNewPortfolioPath;
		else
			logging('unspecified data mode');
		editMode=true;
	}
	else {
		if(dataMode.toLowerCase()=='c')
			url = createPortfolioPath;
		else if(dataMode.toLowerCase()=='p')
			url = createNewPortfolioPath;
		else
			logging('unspecified data mode');
		editMode=false;
	}
	if(dataMode.toLowerCase()=='c')
		formData=$('#form_create_collection').serialize();
	if(errors.length==0)
	{	
		//save the portfolio bu ajax call
		$.ajax(
		{
			url: url,
			type: "POST",
			data: formData,
			beforeSend: function(){
				buildPopupMsg({
					"content": layoutTemplate.loadingPopup,
					"title": "Loading",
					"showOk": false,
					"closeByOverlay": false,
					"effect":false
				});
			},
			success: function(result)
			{
				logging("ERROR=>"+result.hasError);
				if(result.hasError)
				{
					var errorInfo = new Array();
					$(".label").removeAttr("style");
					for(var i=0; i<result.errors.length ; i++)
					{
						errorInfo.push(result.errors[i].defaultMessage);
						//helight area
						logging("Error field=>"+result.errors[i].field);
					}
					$("#overlay").fadeOut("fast"); //show the overlay when loading
					buildPopupMsg({
						"content":"Please enter data in the mandatory fields displayed in the list:<br/>"+errorInfo.join("<br/>"),
						"showOk":true
					});
				}
				else
				{	
					var timeout;
					var contentMessage="Added successfully<br />(This window will be closed automatically in 5 seconds)";
					if(editMode)
						contentMessage="Updated successfully";
					buildPopupMsg({
						"content":contentMessage,
						"showOk":true,
						"title":"Result",
						"onShow":function () {
							if(!editMode) {
								timeout = window.setTimeout(function(){
									closePopupMsg();
									//go to manage board tab
									triggerHash('#board_page_'+result.portfolioId+'_0_1');
								}, 5000);
							}
						},
						"onOk":function () {
							closePopupMsg();
							if(!editMode) {
								clearTimeout(timeout);
								//go to manage board tab
								triggerHash('#board_page_'+result.portfolioId+'_0_1');
							}
						},
						"onClose":function () {
							closePopupMsg();
							if(!editMode) {
								clearTimeout(timeout);
								//go to manage board tab
								triggerHash('#board_page_'+result.portfolioId+'_0_1');
							}
						}
					});
					if(!editMode) {
						if(dataMode.toLowerCase()=='c')
							$('#form_create_collection')[0].reset();
						else
							$('#form_create_portfolio')[0].reset();
						//clear portfolio images and urls
						for(var roleId=1;roleId<=$('.sample-item-upload').length;roleId++) {
							$('.sample-item-preview[role="'+roleId+'"]').html("");
							$(".portfolio_image_id[role='"+roleId+"']").val("");
					        $(".filestatus[role='"+roleId+"']").val(-1);
					        $(".filename[role='"+roleId+"']").val("");
					        $(".filename_ext[role='"+roleId+"']").val("");
					        $(".filename_100[role='"+roleId+"']").val("");
					        $(".filename_400[role='"+roleId+"']").val("");
					        $(".filename_original[role='"+roleId+"']").val("");
						}
					}
					else {
						//remove the image if the active_status is zero
						for(var i=1;i<=$('.active_status').length;i++) {
							if($('.active_status[role='+i+']').val()==0) {
								$('.sample-item-preview[role='+i+']').html("");
							}	
						}
					}
					
					//change the flag
					globalVars.isChangedWithoutSubmit=false;
					//load the manage portfolio tab to reload the data
					//$("#tabs").tabs("load",getIdByName('tab_manage_collections'));
				}
			}
		});
	}
	else
	{
		buildPopupMsg({
			"content":"Below information is mandatory, we have highlighted the missing data:<br/>"+errors.join("<br/>"),
			"showOk":true
		});
	}
}

function getPortfolioItems(page,callback,options)
{
	if(page==undefined)
		page=0;
	var defaultOptions={
		'container':'#tab_manage_collections',
		'mask':'#portfolio_mask',
		'url':getPortfolioItemsPath,
		'pageProp':portfolioProp,
		'data':portfolioResult,
		'paginHandler':undefined,
		'paginContainer':'#manage_portfolio_pagin',
		'paginPrefix':'#portfolio_page',
		'renderMode':'c'
	},target;
	options=$.extend({},defaultOptions,options); //apply options
	target=options.container+' '+options.mask;
	$.ajax(
	{
		async: true,
		url: options.url,
		type: "GET",
		timeout: 10000, //Set 10 secs for timeout
		beforeSend: function(xhr)
		{
			logging("beforeSend: get portfolio items");
			//show loading message
			if($(target).length<1) {
				logging("can not insert loading panel");
				//insert mask into the basic frame
				$('#basicFrame .content.with-header').html('<div id="portfolio_mask"></div>');
				$(target).html('<div class="data">'+layoutTemplate.loadingPortfolioMsg+'</div>');
			}
			else {
				logging("beforeSend: insert loading panel");
				$(target).html('<div class="data">'+layoutTemplate.loadingPortfolioMsg+'</div>');
			}
		},
		error: function(jqXHR,textStatus,errorThrown)
		{
			logging("Get portfolio items error"+errorThrown);
			if(typeof(callback)==='function')
				callback();
		},
		success: function(result)
		{
			if(result.hasError)
			{
				logging("GET portfolio error");
			}
			else
			{
				logging("GET portfolio successfully");
				portfolioResult.data=result.results;
				portfolioResult.visible=result.isVisibleDesigner;
				//portfolioResult.imageList=result.imagesList;
				//calculate the total pages
				portfolioProp.totalPages=Math.ceil(result.results.length/portfolioProp.itemsPerPage);
				logging("TOTAL Portfolio items=>"+result.results.length);
				if(result.results.length>0)
				{
					logging("Total Pages=>"+portfolioProp.totalPages);
					getPortfolioItemsByPage(page,false,callback,options);
				}
				else
				{
					//disable the New Board button
					$(options.container+' #add_new_board').css("display","none");
					//show empty data
					$(target).append('<div class="nextdata">'+layoutTemplate.emptyPortfolioMsg+'</div>');
					//show transition effect
					transit(target);
					if(typeof(callback)==='function')
						callback();
				}
			}
		},
		complete: function()
		{
			logging("Get portfolio items complete");
		}
	});
}
function getPortfolioItemsByPage(page,forceToReload,callback,options)
{
	var portfolioContent=[];
	var defaultOptions={
		'container':'#tab_manage_collections',
		'mask':'#portfolio_mask',
		'url':getPortfolioItemsPath,
		'pageProp':portfolioProp,
		'data':portfolioResult,
		'paginHandler':undefined,
		'paginContainer':'#manage_portfolio_pagin',
		'paginPrefix':'#portfolio_page',
		'renderMode':'c'
	},target;
	options=$.extend({},defaultOptions,options); //apply options
	target=options.container+' '+options.mask;
	logging("portfolio items per page=>"+portfolioProp.itemsPerPage);
	logging("SHOW portfolio item from "+(page*portfolioProp.itemsPerPage)+" to "+((page+1)*portfolioProp.itemsPerPage));
	//if the result is empty call the getPortfolioItems again to get the items.
	//console.log(portfolioResult.data);
	//console.log(portfolioResult.imageList);
	if(portfolioResult.data!=null && (forceToReload==false || forceToReload==undefined))
	{
		if(portfolioResult.data.length > 0)
		{
			if(portfolioProp.totalPages <= page)
			{
				portfolioContent.push(layoutTemplate.emptyPage);
			}
			else
			{
				//enable the New Board button
				$(options.container+' #add_new_board').css("display","inline");
				page=parseInt(page);
				for(var i=page*portfolioProp.itemsPerPage;i<(page+1)*portfolioProp.itemsPerPage;i++)
				{
					var nail=[];
					var item=portfolioResult.data[i];
					if(item!=undefined)
					{
						var pName=htmlEntities(item.name);
						var choppedName=item.name;
						var imagesToDisplay = new Array();
						if(choppedName.length>41)
							choppedName=choppedName.substring(0,40)+" ...";
						choppedName=htmlEntities(choppedName);
						var itemImage=item.boards;
						//prepare imagesToDisplay array
						//add portfolio images first
						for(var pImageIndex=0;pImageIndex<item.portfolioImages.length;pImageIndex++) {
							if(item.portfolioImages[pImageIndex].activeStatus==1)
								imagesToDisplay.push(item.portfolioImages[pImageIndex].thumbnailUrl);
						}
						//add board image
						var bImagesCount=imagesToDisplay.length;
						for(var bImageIndex=0;bImageIndex<4-bImagesCount;bImageIndex++)
						{
							if(itemImage[bImageIndex]!=undefined && itemImage[bImageIndex].boardImages.length > 0) {
								if(options.renderMode.toLowerCase()=='c')
									imagesToDisplay.push(itemImage[bImageIndex].boardImages[0].thumbnailUrl);
								else
									imagesToDisplay.push(itemImage[bImageIndex].boardImages[0].fileName);
							}
							else
								imagesToDisplay.push("");
						}
						nail.push('<div class="item '+options.renderMode+'">');
						nail.push('<a href="javascript:void(0);" id="portfolio_'+item.portfolioId+'" data="'+item.portfolioId+'" data-mode="'+options.renderMode+'">');
						nail.push('<div class="portfolio">');
						if(options.renderMode.toLowerCase()=='c') {
							nail.push('<table>');
							nail.push('<tr>');
				            if(imagesToDisplay[0]!="")
				            	nail.push('<td><img src=/100x100/'+imagesToDisplay[0]+'></td>');
				            else
				            	nail.push('<td class="emptyCell"></td>');
				            if(imagesToDisplay[1]!="")
				            	nail.push('<td><img src=/100x100/'+imagesToDisplay[1]+'></td>');
				            else
				            	nail.push('<td class="emptyCell"></td>');
				            nail.push('</tr>');
				            nail.push('<tr>');
				            if(imagesToDisplay[2]!="")
				            	nail.push('<td><img src=/100x100/'+imagesToDisplay[2]+'></td>');
				            else
				            	nail.push('<td class="emptyCell"></td>');
				            if(imagesToDisplay[3]!="")
				            	nail.push('<td><img src=/100x100/'+imagesToDisplay[3]+'></td>');
				            else
				            	nail.push('<td class="emptyCell"></td>');
				            nail.push('<tr>');
				            nail.push('</table>');
						}
						else {
							if(imagesToDisplay[0]!="")
								nail.push('<img src="/400x400/'+imagesToDisplay[0]+'"/>');
						}
			            nail.push('</div>');
			            nail.push('</a>');
			            nail.push('<div class="detail">');
			            nail.push('<div class="name" title="'+pName+'">'+choppedName+'</div>');
			            nail.push('<div class="checkbox delete_portfolio" data-mode="'+options.renderMode+'" data="'+item.portfolioId+'"><img src="/images/recycle_bin.png" /></div>');
			            nail.push('</div>');
			            nail.push('</div>');
					}
					var nailToString=nail.join('');
					portfolioContent.push(nailToString);
				}
			}
		}
		else
		{
			portfolioContent.push(layoutTemplate.emptyPortfolioMsg);
		}
		//show pagin
		if(options.paginHandler==undefined)
			portfolioPagin(options.container+' '+options.paginContainer,options.paginPrefix); //run default pagin handler
		else
			options.paginHandler(options.container+' '+options.paginContainer,options.paginPrefix);
		//create new div to put the data
		$(target).append('<div class="nextdata">'+portfolioContent.join('')+'</div>');
		//append hint if the designer is invisible
		if(!portfolioResult.visible) {
			navigate($('.li-portfolio'));
			$(target+' .nextdata').append(layoutTemplate.invisibleDesignerMsg);
		}
		//show transition effect
		transit(target);
		if(typeof(callback)==='function')
			callback();
	}
	else
	{
		logging("Reload the portfolio items=>"+page);
		getPortfolioItems(page,callback,options);
	}
}
function portfolioPagin(container,pagePrefix)
{
	if(container==undefined)
		container='#manage_portfolio_pagin';
	if(pagePrefix==undefined)
		pagePrefix='#portfolio_page';
	logging("Refresh portfolio pagin","#0F0");
	logging("cpage=>"+portfolioProp.currentPage);
	var pagin="";
	portfolioProp.currentPage=parseInt(portfolioProp.currentPage);
	//show head pagin
	if(portfolioProp.currentPage==0)
		pagin+='1&nbsp;';
	else
		pagin+='<a href="'+pagePrefix+'_0_0">1</a>&nbsp;';
	//show middle page if the totalPages > 2,(equals to 2 means only head and tail)
	if(portfolioProp.totalPages>2)
	{
		//show ... before current page
		if(portfolioProp.currentPage>=3)
			pagin+='...&nbsp;';
		//show adajacent page
		if(portfolioProp.currentPage>=2)
			pagin+='<a href="'+pagePrefix+'_'+(portfolioProp.currentPage-1)+'_0">'+(portfolioProp.currentPage)+'</a>&nbsp;';
		//current page
		if(portfolioProp.currentPage!=0 && portfolioProp.currentPage!=portfolioProp.totalPages-1)
			pagin+=(portfolioProp.currentPage+1)+'&nbsp;';
		//show adajacent page
		if(portfolioProp.totalPages-portfolioProp.currentPage>=3)
			pagin+='<a href="'+pagePrefix+'_'+(portfolioProp.currentPage+1)+'_0">'+(portfolioProp.currentPage+2)+'</a>&nbsp;';
		//show ... after current page
		if(portfolioProp.totalPages-portfolioProp.currentPage>=4)
			pagin+='...&nbsp;';
	}
	//show tail pagin
	if(portfolioProp.totalPages>=2)
	{
		if(portfolioProp.currentPage==portfolioProp.totalPages-1)
			pagin+=portfolioProp.totalPages+'&nbsp;';
		else
			pagin+='<a href="#'+pagePrefix+'_'+(portfolioProp.totalPages-1)+'_0">'+portfolioProp.totalPages+'</a>&nbsp;';
	}
	$(container).html("Pages:&nbsp;"+pagin);
}
/*function deletePortfolio()
{
	if($("#form_portfolios").serialize()!="")
	{
		logging("FORM PORTFOLIO=>"+$("#form_portfolios").serialize());
		//show confirm window
		var r=confirm("It will delete your portfolio and boards belongs to it. Continue?");
		if (r==true)
		{
			$.ajax(
			{
				url: deletePortfolioPath,
				data: $("#form_portfolios").serialize(),
				type: "POST",
				success: function(result)
				{
					if(result.hasError)
					{
						logging("ERROR OCCURED");
					}
					else
					{
						logging("Delete Portfolio Result=>"+result);
						$("#tabs").tabs("load",getIdByName("tab_manage_collections"));
					}
				}
			});
		}
	}
	else
	{
		showErrorMsg("Please Select Portfolio(s) to delete",true);
	}
}*/
//End of portfolio related function====================================//

//Idle Timer===========================================================//
function initIdleTimeoutPlugin()
{
	logging("Init idle timeout plugin");
	//hide the init popup
	// start the plugin
	$.idleTimeout('#session_expire', '#continueSession', 
	{
		idleAfter: idleTimerConfig.idleTime, // user is considered idle after 5 minutes of no movement
		pollingInterval: idleTimerConfig.pollingTime, // a request to keepalive.php (below) will be sent to the server every minute
		//keepAliveURL: keepSessionAlivePath+"?loginSSId="+sessionStorage.LI,
		keepAliveURL: keepSessionAlivePath+'?v='+new Date().getTime(),
		serverResponseEquals: 'OK', // the response from keepSessionAlivePath must equal the text "OK"
		warningLength: idleTimerConfig.warningTime,
		failedRequests: 5,
		AJAXTimeout: 2500,
		debugMode:idleTimerConfig.idleTimeoutDebugMode,
		onTimeout: function()
		{
			//set the flag of unsaved notification to false
			globalVars.isChangedWithoutSubmit=false;
			isChangedWithoutSubmitOnPopup=false;
			// redirect the user when they timeout.
			window.location = logoutPath;
		},
		onIdle: function()
		{
			// show the dialog when the user idles
			if ( $.browser.msie && $.browser.version == "8.0") 
			{
				$('#session_overlay').css('filter', 'alpha(opacity=70)');
			}
			$("#session_overlay").fadeIn("fast"); 
			showPopup({
				"container":"#session_expire"
			});
		},
		onCountdown: function(counter)
		{
			// update the counter span inside the dialog during each second of the countdown
			$("#dialog-countdown").html(counter);
		},
		onResume: function()
		{
			// the dialog is closed by a button in the dialog
			// no need to do anything else
			logging("On Resume");
			//first param: the popup you want to close, second param: the overlayId you want to hide, third param: flag to clean container
			isChangedWithoutSubmitOnPopup=false;
			closePopup("#session_expire","#session_overlay",false); //fixed the issue of the popup content is removed when close the popup.
		},
		onAbort: function()
		{
			logging("idle timer send request abort","#F00");
			window.location='/'; //redirect to the login page
		},
		onRedirect: function()
		{
			logging("idle timer redirect to login","#F00");
			window.location='/'; //redirect to the login page
		}
	});
}
function logout()
{
	$.idleTimeout.options.onTimeout.call(this);
}
//=====================================================================//

//raty plugin==========================================================//
function init_raty_activity()
{
	//get all rating items into an array
	var target=$("#ratingDetails .readonly").toArray();
	//get value from value div
	for(var i=0;i<target.length;i++)
	{
		logging("SET RATY"+$("#"+target[i].id+"_value").html());
		//set value to display star
		$("#"+target[i].id).raty(
		{
			path: appConfig.ratyImgPath,
			space: true,
			width: "100px",
			readOnly: true,
			score: $("#"+target[i].id+"_value").html()
		});
	}
}
//=====================================================================//

//carousel view========================================================//
function transit(target,options) //show the transition effect on content
{
	var defaultOptions = {
		"page":0	
	};
	options=$.extend({},defaultOptions,options);
	var data=$(target).children('div');
	globalVars.inTransit=!globalVars.inTransit;
	data.eq(0).animate(
	{
		left:-900
	},"normal","swing");
	data.eq(1).animate(
	{
	left:0
	},"normal","swing",function()
	{
		globalVars.inTransit=!globalVars.inTransit;
	});
	data.eq(0).remove();
}

//==================SIDEBAR======================================//
function openSidebar(callback)
{
	if(!globalVars.isSidebarOpened)
	{
		$("#sidebar").animate({width:350},"normal",function()
		{
			//rotate the arrow
			//$("#sidebarToggle").find("img").attr("class","rightArrow");
			$("#sidebarToggle .arrow img").attr("src","/images/arrow_right.png");
			loadSidebarContent(callback);
		});
	}
}
function closeSidebar()
{
	//logging("sideBar click=>"+globalVars.isSidebarOpened);
	if(globalVars.isSidebarOpened)
	{
		$("#sidebarContent").fadeOut("fast",function()
		{
			$("#sidebar").animate({width:50},"normal",function()
			{
				//rotate the arrow
				//$("#sidebarToggle").find("img").attr("class","leftArrow");
				$("#sidebarToggle .arrow img").attr("src","/images/arrow_left.png");
			});
		});
		globalVars.isSidebarOpened=false;
	}
}

function loadSidebarContent(callback)
{
	//load sidebar content
	$.ajax(
	{
		url: sidebarPath,
		beforeSend: function()
		{
			globalVars.isSidebarOpened=true;
			logging("send sidebar content req");
			$("#sidebarContent").html(layoutTemplate.sidebarLoading);
		},
		success: function(result)
		{
			logging("load sidebar content success");
			$("#sidebarContent").html(result);
			//init scroll bar
			$("#sidebar_scrollbar").tinyscrollbar();
			//init raty
			$("#sidebar_avg_rating").raty(
			{
				path: appConfig.ratyImgPath,
				cancel: true,
				space: true,
				width: "50px",
				readOnly: true,
				score: function () {
					return $(this).attr("data-score")
				}
			});
			$("#sidebarContent").fadeIn("fast",function()
			{
				//update scroll bar
				$("#sidebar_scrollbar").tinyscrollbar_update();
				logging("init scroll bar","#F00");
			});
			//update scroll bar
			$("#sidebar_scrollbar").tinyscrollbar_update();
			if(typeof(callback)==='function')
				callback();
		}
	});
}

//update viewer
function showWindow(id,showEffect,selectedItem)
{
	if(showEffect==undefined)
		showEffect=true;
	//close sidebar
	closeSidebar();
	buildPopup({
		"url":boardDetailPath+"/"+id,
		"showPopup":showEffect,
		"onLoad":function() {
			$('#board_detail .loadingSpinner').fadeIn(500); //show loading panel
		},
		"onClose": function() {
			//unbind the board gallery plugin.
			$(document).off("click",'#board-gallery .control-prev');
			$(document).off("click",'#board-gallery .control-next');
		}
	},function () {
		$("#board_detail_scrollbar").tinyscrollbar();
		$(".input textarea").autosize(undefined,function() {
			$("#board_detail_scrollbar").tinyscrollbar_update();
		});
		if(!showEffect)
			$('#board_detail .loadingSpinner').show().fadeOut(300); //hide loading panel
		$('.qtip.qtip-active').css("display","none"); //hide the tooltip if it's active.
		//insert arrow to forward/back search items
		if(selectedItem!=undefined && searchResult!=undefined)
		{
			var hasSelectedItem=true;
			if(selectedItem==-1) {
				//Use previous selected index if existed
				selectedItem = searchResultProp.previousSelectedIndex;
				hasSelectedItem = false;
			}
			else {
				searchResultProp.previousSelectedIndex = selectedItem;
			}
				
			//retrieve the containerIndex
			var nextItem=(selectedItem+1)%searchResult.length;
			var prevItem=((selectedItem-1)+searchResult.length)%searchResult.length;
			$("#popup_board_detail .leftArea .prev-board").attr('data',searchResult[prevItem].boardId);
			$("#popup_board_detail .leftArea .next-board").attr('data',searchResult[nextItem].boardId);
			//add nail image
			var itemCount=searchResult.length;
			if(itemCount>5)
				itemCount=5;
			var offset=Math.floor(itemCount/2);
			$('.navi-gallery-img.highlight').removeClass('highlight');
			for(var i=0;i<itemCount;i++) {
				var itemIndex= (selectedItem+(i-offset)+searchResult.length)%searchResult.length;
				if(itemIndex==selectedItem && hasSelectedItem)
					$('.navi-gallery').append('<span class="navi-gallery-img highlight"><a class="nailBoardLink" data="'+searchResult[itemIndex].boardId+'" title="'+htmlEntities(searchResult[itemIndex].name)+'"><img src="/100x100/'+searchResult[itemIndex].thumbnailUrl+'"/></a></span>');
				else
					$('.navi-gallery').append('<span class="navi-gallery-img"><a class="nailBoardLink" data="'+searchResult[itemIndex].boardId+'" title="'+htmlEntities(searchResult[itemIndex].name)+'"><img src="/100x100/'+searchResult[itemIndex].thumbnailUrl+'"/></a></span>');
			}
			if(showEffect) {
				$('#navigator').show('blind',{},500,function () {
					//Update the right area size to the same height of the popup
					$('#board_detail_scrollbar').height($('#popup_board_detail').height());
					$('#board_detail_scrollbar').tinyscrollbar_update();
				});
			}
			else {
				$('#navigator').show().css('display','block');
				//Update the right area size to the same height of the popup
				$('#board_detail_scrollbar').height($('#popup_board_detail').height());
				$('#board_detail_scrollbar').tinyscrollbar_update();
			}
			//init qtip plugin
			$('.navi-gallery-img a').qtip(tooltipConfig);
		}
		
		//unbind previous board gallery plugin.
		$(document).off("click",'#board-gallery .control-prev');
		$(document).off("click",'#board-gallery .control-next');
		//bind related board plugin
		$(document).on('click','#board-gallery .control-prev',function () {
			galleryController('prev');	
		})

		$(document).on('click','#board-gallery .control-next',function () {
			galleryController('next');	
		})
	});
}

function galleryInit() {
	var attributes={
		'wrapperWidth': $('#board-gallery .board-gallery-wrapper').width(),
		'viewerWidth': $('#board-gallery .board-gallery-wrapper ul').width(),
		'itemWidth': $('#board-gallery .board-gallery-wrapper ul li').width()
	};
	attributes.transitionWidth = attributes.itemWidth*Math.floor(attributes.wrapperWidth/attributes.itemWidth)
	return attributes;
}

function galleryController(mode,callback) {
	var galleryAttr;
	if($('#board-gallery').data('galleryAttr')==undefined) {
		$('#board-gallery').data('galleryAttr',galleryInit());
		galleryAttr=$('#board-gallery').data('galleryAttr');
		$('#board-gallery').data('inTransit',false);
	}
	else {
		//bind attributes on div data
		galleryAttr=$('#board-gallery').data('galleryAttr');
	}
	var viewerPos=$('#board-gallery .board-gallery-wrapper ul').position();
	if(mode=='prev') {
		if(viewerPos.left<0) {
			if($('#board-gallery').data('inTransit')==false) {
				$('#board-gallery .board-gallery-wrapper ul').animate({
					left:'+='+galleryAttr.transitionWidth
				},function() {
					$('#board-gallery').data('inTransit',false);
				});
				$('#board-gallery').data('inTransit',true);
			}
		}
	}
	else {
		if(viewerPos.left-galleryAttr.transitionWidth>(0-galleryAttr.viewerWidth)) {
			if($('#board-gallery').data('inTransit')==false) {
				$('#board-gallery .board-gallery-wrapper ul').animate({
					left:'-='+galleryAttr.transitionWidth
				},function() {
					$('#board-gallery').data('inTransit',false);
				});
				$('#board-gallery').data('inTransit',true);
			}
		}
	}
}

//show enlarge image browser
function showEnlargeImage(object)
{
	logging("Types of object=>"+typeof(object));
	var imagePath;
	var imageWidth;
	var imageHeight;
	//get screen size, and determine the size of image viewer.
	var screenWidth=screen.width;
	var screenHeight=screen.height;
	
	if(typeof(object)==="object" && (object.attr("image-width")!=undefined || object.attr("image-height")!=undefined))
	{
		logging("Enlarge image=>"+object.attr("image-width")+";"+object.attr("image-height")+";"+object.attr("image-data"),"#F00");
		//get path
		imagePath=object.attr("image-data");
		//get width
		imageWidth=parseInt(object.attr("image-width"));
		imageWidth+=20;
		//get height
		imageHeight=parseInt(object.attr("image-height"));
		imageHeight+=20;
		
		if(imageWidth>=screenWidth*0.9)
			imageWidth=screenWidth*0.9;
		if(imageHeight>=screenHeight*0.85)
			imageHeight=screenHeight*0.85;
		//open the new window with scrollbar and without toolbar.
		window.open(imageViewerPath+"?img="+imagePath,"_blank",'width='+imageWidth+',height='+imageHeight+',scrollbars=yes,toolbar=no,location=0');
	}
	else
	{
		//if the type is still object, means the image width and height attributes are missing. So we retrieve the image path from image-data to get the image size.
		if(typeof(object)==="object")
			imagePath=object.attr('image-data');
		else
			imagePath=object;
		//ajax method
		$.ajax(
		{
			url:imageSizeRetrieverPath+"?img="+imagePath,
			beforeSend: function()
			{
				//logging("loading "+this.url);
			},
			error: function(xhr,status,error)
			{
				//logging(this.url+" is "+error); //if there is arrow, close the overlay
			},
			success: function(result)
			{
				imageWidth=parseInt(result.imageWidth);
				imageHeight=parseInt(result.imageHeight);
				imageWidth+=20;
				imageHeight+=20;
				
				if(imageWidth>=screenWidth*0.9)
					imageWidth=screenWidth*0.9;
				if(imageHeight>=screenHeight*0.85)
					imageHeight=screenHeight*0.85;
				
				//open the new window with scrollbar and without toolbar.
				window.open(imageViewerPath+"?img="+imagePath,"_blank",'width='+imageWidth+',height='+imageHeight+',scrollbars=yes,toolbar=no,location=0');
			},
			complete: function(xhr,status)
			{
				logging("popup complete"+xhr+";"+status);
			}
		});
	}
}

//TilesView functionality
function initTiles(options,callback,startIndex)
{
	//address,mode,filetype,target,event)
	var defaultOptions = {
		"id": "#messageTiles",
		"xSpace":200,
		"ySpace":30,
		"showInitEffect": true,
		"initEffectSpeed":1000
	};
	options=$.extend({},defaultOptions,options);
	$(options.id).height(0);
	//$("#messageTiles .messageTile").css("display","none");
	//attach data in the target div
	$(options.id).data("startIndex",startIndex);
	$(options.id).data("x-space",options.xSpace);
	$(options.id).data("y-space",options.ySpace);
	//set the position
	$(options.id+" .Tile").each(function(index){
		$(this).css({
			"top":(index)*options.ySpace,
			"left":index*options.xSpace,
			"z-index":-(index-$(options.id+" .Tile").length)
		});
	});
	if(options.showInitEffect)
	{
	$(options.id).animate({height:530},options.initEffectSpeed,"easeInOutQuad",function() {
		//call callback function
		if(typeof(callback)==='function')
		{
			callback();
		}
		/*$("#messageTiles .messageTile").each(function(index){
			if(index<=3)
			{
			$(this).delay(500*index).fadeIn(500,function() {
				$(this).fadeIn(300,function() {
					$(this).addClass("show");
					$(this).children('.tile-content').fadeIn();
				});
				if(index==$("#messageTiles .messageTile").length-1)
				{
					var timeout=setTimeout(function() {
						$("#messageTiles .messageTile .tile-content").fadeOut(1000,function() {
							$(this).attr("style","");
							$("#messageTiles .messageTile").removeClass("show");
						});
					},2000);
				}
			});
			}
		});*/
	});
	}
	else
	{
		if(typeof(callback)==='function')
		{
			callback();
		}
	}
}
function nextTile(options)
{
	//address,mode,filetype,target,event)
	var defaultOptions = {
		"id": "#messageTiles"
	};
	options=$.extend({},defaultOptions,options);
	//fetch xSpace and ySpace from the div
	var xSpace=$(options.id).data("xSpace");
	var ySpace=$(options.id).data("ySpace");
	var startIndex=$(options.id).data('startIndex');
	if(startIndex<$(options.id+" .Tile").length-1)
	{
		var nextIndex=$(options.id).data('startIndex')+1;
		$(options.id).data('startIndex',nextIndex);
		//animation
		/*$(options.id+" .Tile").animate({
			left:'-='+xSpace+'px',
			top:'-='+ySpace+'px'
			,'z-index':'+=1'
		});*/
		$(options.id+" .Tile").each(function(index) {
			//compute the delayTimes
			var delayTimes;
			if(index<startIndex)
				delayTimes=$(options.id+" .Tile").length-(startIndex-index);
			else
				delayTimes=index-startIndex;
			$(this).delay(delayTimes*50).animate({
				left:'-='+xSpace+'px',
				top:'-='+ySpace+'px'
				/*,'z-index':'+=1'*/
			});
		});
		$($(options.id+" .Tile")[startIndex]).fadeOut(100);
	}
}

function prevTile(options)
{
	//address,mode,filetype,target,event)
	var defaultOptions = {
		"id": "#messageTiles"
	};
	options=$.extend({},defaultOptions,options);
	//fetch xSpace and ySpace from the div
	var xSpace=$(options.id).data("xSpace");
	var ySpace=$(options.id).data("ySpace");
	var startIndex=$(options.id).data('startIndex');
	if(startIndex>0)
	{
		var previousIndex=$(options.id).data('startIndex')-1;
		$(options.id).data('startIndex',previousIndex);
		//animation
		$($(options.id+" .Tile")[previousIndex]).fadeIn(100);
		$(options.id+" .Tile").animate({
			left:'+='+xSpace+'px',
			top:'+='+ySpace+'px'
			/*,'z-index':'-=1'*/
		});
		/*$(options.id+" .Tile").each(function(index) {
			if(index<startIndex)
				delayTimes=$(options.id+" .Tile").length-(startIndex-index);
			else
				delayTimes=index-startIndex;
			$(this).delay(delayTimes*50).animate({
			left:'+='+xSpace+'px',
			top:'+='+ySpace+'px'
			,'z-index':'-=1'
			});
		});*/
		//reset the pos of the startIndex-1 item
	}
}
//Send Message and message detail=================================================================//
function sendMessage(forceToSend)
{
	//if the body is empty, do not send the message
	var tempMassage=$("#form_comment_messageBody").val();
	tempMassage=tempMassage.replace(" ","");
	logging("MSG=>"+tempMassage.replace(" ",""));
	if(tempMassage != "")
	{
		//check the communication protocal checkbox status
		if($('#popupCommProtocol').attr('checked')=='checked' || forceToSend==true) {
			logging("MESSAGE DATA=>"+$("#form_comment").serialize());
			//convert to html format and assgin to messageBody
			$('#commentBody').val(toHtmlFormat($("#form_comment_messageBody").val()));
			$.ajax(
			{	
				url: sendMessagePath,
				type: "POST",
				data: $("#form_comment").serialize(),
				beforeSend: function() {
					$("#send_status").html("Sending...");
				},
				success: function(result)
				{
					//console.log(result);
					if(result.hasError)
					{
						$("#send_status").html("Error, please resend again");
					}
					else
					{
						//change the unsave notification flag to false.
						isChangedWithoutSubmitOnPopup=false;
						$("#send_status").html("Sent successfully");
						$("#form_comment_messageBody").val("");
						//uncheck the communication protocol checkbox
						$('#popupCommProtocol').removeAttr('checked');
					}
				}
			});
		}
		else {
			//$("#send_status").html("Please review and accept communication protocol");
			//Show confirmation popup
			showConfirmation($('#board_detail .comm-protocol-holder label').text(),"Confirmation","changedWithoutSave",{
				"onOk":function() {
					closePopupMsg();
					sendMessage(true);
				}
			});
		}
			
	}
	else
		logging("empty message");
}
function sendMessageInMessageDetail(forceToSend)
{
	//if the body is empty, do not send the message
	var tempMassage=$("#messageContent").val();
	tempMassage=tempMassage.replace(" ","");
	logging("MSG=>"+tempMassage.replace(" ",""));
	if(tempMassage != "")
	{
		//check the communication checkbox status
		if($('#commProtocol').attr('checked')=='checked' || forceToSend==true) {
			logging("REPLY MESSAGE DATA=>"+$("#replyForm").serialize());
			//Assgign to messageBody
			$('#messageBody').val(toHtmlFormat($("#messageContent").val()));
			var messageData=$("#replyForm").serialize();
			logging("Data=>"+messageData);
			$.ajax(
			{	
				url: sendMessagePath,
				type: "POST",
				data: messageData,
				beforeSend: function()
				{
					$("#sendMessage").html('<span style="color:#0000CC">Sending...</span>');
					//$("#sendMessage a").html("Sending");
				},
				success: function(result)
				{
					//console.log(result);
					if(result.hasError)
					{
						//$("#send_status").html("Error, please resend again");
						buildPopupMsg({
							"content":"Error, please resend again",
							"showOk":true,
							"title":"Error"
						});
						$("#sendMessage").html('<a id="send_reply">Send</a>');
					}
					else
					{
						$("#send_status").html("Sent successfully");
						//TODO reload the message detail url
						//get the page id for messages
						var tab_messages=getIdByName('tab_messages');
						//change the flag
						globalVars.isChangedWithoutSubmit=false;
						//reload the tab
						$("#tabs").tabs("load",tab_messages);				
					}
				}
			});
		}
		else {
			//Show confirmation popup
			showConfirmation($('#message_detail .comm-protocol-holder label').text(),"Confirmation","changedWithoutSave",{
				"onOk":function() {
					closePopupMsg();
					sendMessageInMessageDetail(true);
				}
			});
		}
	}
}
//convert the plain text format to html format
function toHtmlFormat(source)
{
	var dest="";
	dest=source.replace(/\n/g, "<br/>");
	dest=dest.replace(/\s/g, '&nbsp;');
	return dest;
}
//detect the height of the message context, and put the hyperlink if needed.
function wrapMessageDetail(start)
{
	if(start==undefined)
		start=0;
	var viewareaArray=$(".viewarea").toArray();
	//wrap content if the hight is over 52px.
	for(var i=start;i<viewareaArray.length;i++)
	{
		//if the content is more than the height of 3 lines, insert read more hyperlink.
		if($($(viewareaArray[i]).children('.context')).height()>72)
		{
			//insert read more hyper-link after the viewarea div.
			$(viewareaArray[i]).after('<div class="readMore"><a href="javascript:void(0)">Read more...</a></div>');
		}
	}
	//update the scroll bar
	$("#message_content_scrollbar").tinyscrollbar_update('relative');
}
//================================================================================================

//terms and condition=============================================================================
function displayLatestTermAndConditions(address)
{
	//ajax method
	$.ajax(
	{
		url:address,
		type: "GET",
		beforeSend: function()
		{
			logging("loading "+address);
			if ( $.browser.msie && ($.browser.version == "8.0" || $.browser.version == "7.0")) 
			{
				$("#overlay").css('filter', 'alpha(opacity=70)');
			}
			$("#overlay").fadeIn("fast"); //show the overlay when loading
		},
		error: function(xhr,status,error)
		{
			//logging(this.url+" is "+error); //if there is error, close the overlay
			$("#overlay").fadeOut("fast"); //show the overlay when loading
		},
		success: function(result)
		{
			if(!(result && result.hasError))
			{
				//No error, show terms and conditioins popup..
				$("#popupContainer").html(result); //set the result to the popupContainer
				//show the popup on the screen
				showPopup({},function() {
					//adhere the nutshell on the position.
					$(".anchor").each(function(index) {
						if($(this).attr("data")!=undefined)
						$("#block_"+$(this).attr("data")).animate({top:$(this).position().top});
					});
				});
			}
		},
		complete: function(xhr,status)
		{
			$("#termScrollbar").tinyscrollbar();
			//initiate the scroll bar in terms panel !!!important
		}
	});	
}
//====================================================================================================
function processJSONObject(source)
{
	var dest=eval(source); //convert the string to json object.
	if(dest[dest.length-1]==undefined) //if the last one is undefined, remove it.
		dest.pop();
	for(var i=0;i<dest.length;i++)
	{
		if(dest[i].children[dest[i].children.length-1]==undefined) //if the last one of the children is undefined, remove it.
			dest[i].children.pop();
	}
	return dest;
}
//==========resize event handler================================//
function resize()
{
	if($("#tabs").length>0)
	{
		//set the offset of footer
		x=$("#tabs").offset();
		var footerOffset=x.top+$("#tabs").height();
		logging("size of tabs=>"+x.top+" : tabs=>"+$("#tabs").height());
		$("#footer").animate({"top":footerOffset},"fast");
		//detect the browser viewport height to determine the minimize the logo or not
		/*if($(window).height() <= 800)
		{
			if($('#title').data("mode")!='min')
			{
				$('#title').data("mode",'min');
				//decrease the height of the title
				$("#title .titleContent .logo img").animate({height:'70px',width:'auto'});
				$("#title .titleContent").animate({height:'85px'});
				$("#title .titleContent").animate({width:'990px'});
				$("#title .titleHolder").animate({height:'85px'});
				$("#title").animate({height:'85px'});
			}
		}
		if($(window).height() >800)
		{
			if($('#title').data("mode")!='max')
			{
				$('#title').data("mode",'max');
				//increase the height of the title
				$("#title .titleContent .logo img").animate({height:'86px',width:'auto'});
				$("#title .titleContent").animate({height:'120px'});
				$("#title .titleContent").animate({width:'990px'});
				$("#title .titleHolder").animate({height:'120px'});
				$("#title").animate({height:'129px'});
			}
		}*/
	}
}

//debug function, continue to record the data
function logging(data,color)
{
	if(color==undefined)
		color="#000";
	if(basicConfig.debugMode)
	{
		$("#debug").css("display","block");
		if(data==undefined || data=="")
			$("#debug").append("Undefined or blank <br />");
		$("#debug").append('<span style="color:'+color+'">'+data+'</span><br />');
		if(basicConfig.writeLogToConsole)
			console.log(data);
		$("#debug").scrollTop($("#debug")[0].scrollHeight);
	}
}

function doSaveDesigner()
{
	var errors= CheckDesignerInput();
	var formData,
		educations=$('#form_education option[data-is-others="true"]:selected'),
		specialty=$('#form_specialty option[data-is-others="true"]:selected'),
		expertises=$('#form_expertise option[data-is-others="true"]:selected'),
		serialData=new Array();
	//add others values
	for(var i=0;i<educations.length;i++) {
		//reset the option value to integer
		$(educations[i]).val(0);
		serialData.push('otherEducation='+encodeURI($(educations[i]).attr('data-text')));
	}
	for(var i=0;i<specialty.length;i++) {
		$(specialty[i]).val(0);
		serialData.push('otherSpecialty='+encodeURI($(specialty[i]).attr('data-text')));
	}
	for(var i=0;i<expertises.length;i++) {
		$(expertises[i]).val(0);
		serialData.push('otherExpertise='+encodeURI($(expertises[i]).attr('data-text')));
	}
	formData=$("#form_edit_profile").serialize()+'&'+serialData.join('&');
	if(errors.length==0)
	{	
		logging("save designer");
		logging("FORM DATA=>"+$("#form_edit_profile").serialize());
		var action=$("#form_edit_profile").attr("action");
		$.ajax(
		{
			url: action,
			type: "POST",
			data: formData,
			beforeSend:function() {
				//show loading spinner
				$('#home_designer_edit .loadingSpinner').removeClass("disable");
				//bind disable attr on save/cancel button
				$('#save_designer').attr("disabled","disabled");
				$('#cancel_designer').attr("disabled","disabled");
			},
			success: function(result)
			{
				//hide loading spinner
				$('#home_designer_edit .loadingSpinner').addClass("disable");
				//unbind disable attr on save/cancel button
				$('#save_designer').removeAttr("disabled");
				$('#cancel_designer').removeAttr("disabled");
				logging(result.hasError+result.errorCode+result.errorDescription);
				if(result.hasError==false)
				{
					var timeout;
					//TODO show success popup
					globalVars.isChangedWithoutSubmit=false;	
					//update username on the header
					$("#userFirstName").html(result.userFirstName);
					$("#userLastName").html(result.userLastName);
					//change the logo on the page header.
					$(".bannerLogo").html('<i></i><img src="'+result.userLogo+'" />');
					buildPopupMsg({
						"content":"Updated Successfully<br />(This popup will be close automatically in 5 seconds)",
						"showOk":true,
						"title":"Update Profile",
						"onShow":function() {
								timeout=setTimeout(function () {
								closePopupMsg();
								triggerHash('#home');
								//location.assign(homepage+"#home");
								//Force to reload the whole page if the user console access changed (limited access <--> full access)
								if(result.ucAccessChanged == true) 
									location.reload();
							},5000);
						},
						"onClose":function() {
							triggerHash('#home');
							//location.assign(homepage+"#home");
							if(result.ucAccessChanged == true)
								location.reload();
							clearTimeout(timeout);
							$('#profileScore').qtip('hide'); //hide the qtip
						},
						"onOk":function() {
							closePopupMsg();
							triggerHash('#home');
							//location.assign(homepage+"#home");
							if(result.ucAccessChanged == true)
								location.reload();
							clearTimeout(timeout);
							$('#profileScore').qtip('hide'); //hide the qtip
						}
					});
				}
				else
				{
					var errorInfo = new Array();
					//remove previous hightlight fields
					$(".label").removeAttr("style");
					for(var i=0; i<result.errors.length ; i++)
					{
						errorInfo.push(result.errors[i].defaultMessage);
						//helight area
						logging("Error field=>"+result.errors[i].field);
					}
					$("#overlay").fadeOut("fast"); //show the overlay when loading
					buildPopupMsg({
						"content":"Please enter data in the mandatory fields displayed in the list:<br/>"+errorInfo.join("<br/>"),
						"showOk":true
					});
				}
			}
		});
	}
	else
	{
		//client side input validation fail
		buildPopupMsg({
			"content":"Below information is mandatory, we have highlighted the missing data:<br/>"+errors.join("<br/>"),
			"showOk":true
		});
	}
}

function CheckDesignerInput()
{
	//var isCorrect=false;
	var errors = new Array();
	
		errors = CheckforNull("#firstName",errors,"#label_first_name","Please enter First Name");
		errors = CheckforNull("#lastName" ,errors,"#label_last_name" ,"Please enter Last Name");
		//
		//errors = CheckforNull("#address1",errors,"#label_address_1","Please enter Street Address 1");
		//errors = CheckforNull("#city",errors,"#label_city","Please enter City");
		//errors = CheckforNull("#form_state",errors,"#label_state","Please enter State");
		//errors = CheckforNullandNumber("#zip",errors,"#label_zipcode","Please enter Zip Code")
		//errors = CheckforNull("#form_country",errors,"#label_country","Please enter Country");
		//errors = CheckforNullandPhoneNumber("#cellPhone",errors,"#label_cell_phone","Cell Phone Number");
		//errors = CheckforNullandPhoneNumber("#phone_no",errors,"#label_phone","Work Phone Number");
		
		//errors = CheckforNullinSelect("#form_languages",errors,"#label_Languages","Please select at least 1 language");
		//errors = CheckforNullinSelect("#form_skills",errors,"#label_skills","Please select at least 1 skill");

		//errors = CheckforNull("#website",errors,"#label_website","Please enter Website");
		//errors = CheckforNull("#companyName",errors,"#label_companyname","Please enter Company Name");
	
	return errors;
}

function doSaveCompany()
{
	var errors= CheckCompanyInput();
	if(errors.length==0)
	{	
		logging("save company");
		//serialize the form
		logging("FORM DATA=>"+$("#form_edit_profile").serialize());
		var action=$("#form_edit_profile").attr("action");
		$.ajax(
		{
			url: action,
			type: "POST",
			data: $("#form_edit_profile").serialize(),
			beforeSend:function() {
				//show loading spinner
				$('#home_edit .loadingSpinner').removeClass("disable");
				//bind disable attr on save/cancel button
				$('#save_company').attr("disabled","disabled");
				$('#cancel_company').attr("disabled","disabled");
			},
			success: function(result)
			{
				//hide loading spinner
				$('#home_edit .loadingSpinner').addClass("disable");
				//unbind disable attr on save/cancel button
				$('#save_company').removeAttr("disabled");
				$('#cancel_company').removeAttr("disabled");
				logging(result);
				logging(result.hasError+result.errorCode+result.errorDescription);
				if(result.hasError==false)
				{
					var timeout;
					//TODO show success popup
					//change the flag
					globalVars.isChangedWithoutSubmit=false;
					//update username on the header
					$("#userFirstName").html(result.userFirstName);
					$("#userLastName").html(result.userLastName);
					//change the logo on the page header.
					$(".bannerLogo").html('<i></i><img src="'+result.userLogo+'" />');
					buildPopupMsg({
						"content":"Update Successfully<br />(This popup will be closed automatically in 5 seconds)",
						"showOk":true,
						"title":"Update Profile",
						"onShow": function () {
								timeout=setTimeout(function () {
								closePopupMsg();
								location.assign(homepage+"#home");
							},5000);
						
						},
						"onClose":function(){
							location.assign(homepage+"#home");
							clearTimeout(timeout);
						},
						"onOk":function(){
							closePopupMsg();
							location.assign(homepage+"#home");
							clearTimeout(timeout);
						}
					});
				}
				else
				{
					var errorInfo = new Array();
					//remove previous hightlight fields
					$(".label").removeAttr("style");
					for(var i=0; i<result.errors.length ; i++)
					{
						errorInfo.push(result.errors[i].defaultMessage);
						//helight area
						logging("Error field=>"+result.errors[i].field);
					}
					//hightlight error fields
					//highlightErrorFields(result);
					//$("#errorContainer").html(errorInfo.join("<br/>"));
					$("#overlay").fadeOut("fast"); //show the overlay when loading
					buildPopupMsg({
						"content":"Please enter data in the mandatory fields displayed in the list:<br/>"+errorInfo.join("<br/>"),
						"showOk":true
					});
				}
			}
		});
	}
	else
	{
		//client side input validation fail
		buildPopupMsg({
			"content":"Below information is mandatory, we have highlighted the missing data:<br/>"+errors.join("<br/>"),
			"showOk":true
		});
	}
}


function CheckCompanyInput()
{
	//var isCorrect=false;
	var errors = new Array();
	
		errors = CheckforNull("#first_name",errors,"#label_first_name","Please enter First Name");
		errors = CheckforNull("#last_name" ,errors,"#label_last_name" ,"Please enter Last Name");
		errors = CheckforNull("#company_name",errors,"#label_company_name","Please enter Company Name");
		errors = CheckforNull("#address1",errors,"#label_address_1","Please enter Street Address 1");
		errors = CheckforNull("#city",errors,"#label_city","Please enter City");
		errors = CheckforNull("#zip",errors,"#label_zipcode","Please enter Zip Code")
		errors = CheckforNull("#form_state",errors,"#label_state","Please enter State");
		errors = CheckforNull("#form_country",errors,"#label_country","Please enter Country");
		
		errors = CheckforNullandPhoneNumber("#cellPhone",errors,"#label_cell_phone","Cell Phone Number");
		errors = CheckforNullandPhoneNumber("#phone_no",errors,"#label_phone","Work Phone Number");
		//errors = CheckforNullandPhoneNumber("#fax",errors,"#label_fax","Fax Number");
		errors = CheckforNull("#website",errors,"#label_website","Please enter Website");
		//errors = CheckforNullinSelect("#form_languages",errors,"#label_Languages","Please select at least 1 language");
		//errors = CheckforNullinSelect("#form_skills",errors,"#label_skills","Please select at least 1 skill");
		
		
	
	return errors;
}

function CheckCreatePortfolioInput()
{
	var errors = new Array();
	errors = CheckforNull("#form_name_of_portfolio",errors,"#label_portfolio_name","Please enter Portfolio Name");
	errors = CheckforNull("#form_description_of_portfolio" ,errors,"#label_portfolio_description" ,"Please enter Portfolio Description");
	
	errors = CheckforNegative("#form_division" ,errors,"#label_division" ,"Please enter Division");
	errors = CheckforNegative("#form_category" ,errors,"#label_category" ,"Please enter Category");
	
	//errors = CheckforNull("#season" ,errors,"#label_last_name" ,"Please enter Last Name");
	return errors;
}

function doUpdateReferral(e)
{
	var errors= CheckUpdateReferralInput(e);
	if(errors.length==0)
	{	
		logging("update referral=>"+e.currentTarget.id);
		//parsing the table id
		temp=e.currentTarget.id.split("_");
		tableId=parseInt(temp[2]);
		//fillin the data in the form
		$("#form_referral_id").val(tableId);
		$("#form_referral_firstname").val($("#referral_firstname_"+tableId+" input").val());
		$("#form_referral_lastname").val($("#referral_lastname_"+tableId+" input").val());
		$("#form_referral_phone").val($("#referral_phone_"+tableId+" input").val());
		$("#form_referral_email").val($("#referral_email_"+tableId+" input").val());
		//serialize the form
		logging($("#form_referral").serialize());
		//using the ajax to send the data to server
		$.ajax(
		{
			url : updateReferralPath+"/0/"+tableId, //Path params: /{requireResend}/{tableId}
			type : "POST",
			data: $("#form_referral").serialize(),
			beforeSend:function(){
				//create link update
				/*var updateLink='<a class="update_referral" id="update_referral_'+tableId+'">Update</a>';*/
				var sendLink='<a class="send_referral" id="send_referral_'+tableId+'">Update and Send</a>';
				//change the link in action area
				//$("#referral_action_"+tableId).html(updateLink+"<br />"+sendLink);
				$("#referral_action_"+tableId).html(sendLink+'<br />&nbsp;<img src="/images/spinner_small.gif" style="width:12px; height:12px;"/>');
			},
			success : function(result) 
			{
				logging("Send referral data success");
				logging("update referral result=>"+result,"#F00");
				if(result.hasError || result==null)
				{
					logging("Update Referral Error","#F00");
					buildPopupMsg({
						"content":"Update Failure.<br /> Please click update again.",
						"showOk":true,
						"title":"Update Referral Error"
					});
				}
				else
				{
					//reset the unsave flag
					isChangedWithoutSubmitOnPopup=false;
					logging("Result"+result.result.firstName,"#0F0");
					logging("Result"+result.result.lastName,"#0F0");
					logging("Result"+result.result.phone,"#0F0");
					logging("Result"+result.result.email,"#0F0");
					//set the input field back to normal text.
					$("#referral_firstname_"+tableId).html(result.result.firstName);
					$("#referral_lastname_"+tableId).html(result.result.lastName);
					$("#referral_phone_"+tableId).html(result.result.phone);
					$("#referral_email_"+tableId).html(result.result.email);
					$("#referral_status_"+tableId).html(result.result.status);
					$("#referral_datesent_"+tableId).html(result.result.dateSentString);
					//show effect
					$("#manageReferralTable tr:nth-child("+(tableId+1)+") td").each(function(index) {
						//compute the delayTimes
						var delayTimes=50;
						$(this).delay(delayTimes*index).addClass("blink",200).removeClass("blink",600);
					});
					//reset the action panel
					//create link update
					var resendLink='<a href="javascript:void(0)" class="resend_noti" id="resend_referral_'+tableId+'">Resend</a>';
					var editLink='<a href="javascript:void(0)" class="edit_referral" id="edit_referral_'+tableId+'">Edit</a>';
					//change the link in action area
					$("#referral_action_"+tableId).html(resendLink+"<br />"+editLink);
				}
			}
		});
	}
	else
	{
		buildPopupMsg({
			"content":"Below information is mandatory, we have highlighted the missing data:<br/>"+errors.join("<br/>"),
			"showOk":true
		});
	}
}

function CheckUpdateReferralInput(e)
{
	var errors = new Array();
	temp=e.currentTarget.id.split("_");
	tableId=temp[2];
	
	if($("#referral_firstname_"+tableId+" input").val()=="")
		errors.push("Please Enter First Name");
	if($("#referral_lastname_"+tableId+" input").val()=="")
		errors.push("Please Enter Last Name");
	if($("#referral_email_"+tableId+" input").val()=="")
		errors.push("Please Enter Email");
	
	return errors;
}

function doSendReferral(e)
{
	var errors= CheckUpdateReferralInput(e);
	if(errors.length==0)
	{	
		logging("send referral=>"+e.currentTarget.id);
		//using the ajax to send the data to server
		logging("update referral=>"+e.currentTarget.id);
		//parsing the table id
		temp=e.currentTarget.id.split("_");
		tableId=temp[2];
		//fillin the data in the form
		$("#form_referral_id").val(tableId);
		$("#form_referral_firstname").val($("#referral_firstname_"+tableId+" input").val());
		$("#form_referral_lastname").val($("#referral_lastname_"+tableId+" input").val());
		$("#form_referral_phone").val($("#referral_phone_"+tableId+" input").val());
		$("#form_referral_email").val($("#referral_email_"+tableId+" input").val());
		//serialize the form
		logging($("#form_referral").serialize());
		//using the ajax to send the data to server
		$.ajax(
		{
			url : updateReferralPath+"/1/"+tableId, //Path params: /{requireResend}/{tableId}
			type : "POST",
			data: $("#form_referral").serialize(),
			success : function(result) 
			{
				logging("Send referral data success");
				logging("update referral result=>"+result,"#F00");
				if(result.hasError || result==null)
				{
					logging("Update Referral Error","#F00");
					buildPopupMsg({
						"content":"Update Failure.<br /> Please click update again.",
						"showOk":true,
						"title":"Update Referral Error"
					});
				}
				else
				{
					//reset the unsave flag
					isChangedWithoutSubmitOnPopup=false;
					logging("Result"+result.result.firstName,"#0F0");
					logging("Result"+result.result.lastName,"#0F0");
					logging("Result"+result.result.phone,"#0F0");
					logging("Result"+result.result.email,"#0F0");
					//set the input field back to normal text.
					$("#referral_firstname_"+tableId).html(result.result.firstName);
					$("#referral_lastname_"+tableId).html(result.result.lastName);
					$("#referral_phone_"+tableId).html(result.result.phone);
					$("#referral_email_"+tableId).html(result.result.email);
					//reset the action panel
					//create link update
					var resendLink='<a href="javascript:void(0)" class="resend_noti" id="resend_referral_'+tableId+'">Resend</a>';
					var editLink='<a href="javascript:void(0)" class="edit_referral" id="edit_referral_'+tableId+'">Edit</a>';
					//change the link in action area
					$("#referral_action_"+tableId).html(resendLink+"<br />"+editLink);
				}
			}
		});
	}
	else
	{
		buildPopupMsg({
			"content":"Below information is mandatory, we have highlighted the missing data:<br/>"+errors.join("<br/>"),
			"showOk":true
		});
	}
}

function createBoardInputChecking()
{
	//if the price range is undefined, set to the default value.
	if(minimunBoardPrice==undefined)
		minimunBoardPrice=50;
	if(maximunBoardPrice==undefined)
		maximunBoardPrice=10000;
	var errors = new Array();
	//get the number of all sale type column
	var table=$("#saleTypeTable tbody").children("tr");
	var saleTypeCount=table.length-1;
	
	//reset the highlight area
	$("#create_board .detail span,#create_board .detail label").removeAttr("style");
	$("#label_upload_image").html("");
	
	errors = CheckforNull("#form_board_name",errors,"#label_board_name","Please enter Board Name");
	errors = CheckforNull("#form_board_description",errors,"#label_description","Please enter Board Description");
	errors = CheckforNull("#portfolioId",errors,"#label_portfolio","Please Select a portfolio or create a new portfolio");
	errors = CheckforNull("#product",errors,"#label_product","Please enter Product");
	errors = CheckforNull("#productType",errors,"#label_product_type","Please enter Product Type");
	//check board creation agreement
	if($('#formBmAgreement').attr("checked")!="checked") {
		HighlightLabelandPushError(errors,"#formBmAgreement","Please review and accept board terms");
		$('#label_formBmAgreement').css('border','2px solid #C30');
	}

	var isChecked=false;
	for(var i=1;i<=saleTypeCount;i++)
	{
		if($("#form_saletype_"+i).attr("checked")=="checked")
			isChecked=true;
	}
	if(isChecked==false)
	{
		errors = HighlightLabelandPushError(errors,"#label_sale_type","Please Select one sale type");
	}
	isChecked=false;
	for(var i=1;i<=saleTypeCount;i++)
	{
		if($("#form_saletype_"+i+"_cost").val()!=undefined && $("#form_saletype_"+i+"_cost").val()!="") {
			if($("#form_saletype_"+i+"_cost").val()%1!=0)
				errors = HighlightLabelandPushError(errors,"#saleTypeTable input","Invalid input, FFG credit doesn't allow decimal.");
			if ($("#form_saletype_"+i+"_cost").val()>=minimunBoardPrice && $("#form_saletype_"+i+"_cost").val()<=maximunBoardPrice)
				isChecked=true;
		}
	}
	if(isChecked==false)
	{
		errors = HighlightLabelandPushError(errors,"#saleTypeTable input","Please enter a valid price. It should be between "+minimunBoardPrice+" and "+maximunBoardPrice+".");
		//highlight
		
	}
	errors = CheckforNullPushtoElement("#form_board_image_url",errors,"#label_upload_image","Please upload Board Image");
	
	return errors;
}

function createPBoardInputChecking() {
	var errors = new Array();
	//reset the highlight area
	$("#create_board .detail span,#create_board .detail label").removeAttr("style");
	$("#label_upload_image").html("");
	
	//errors = CheckforNull("#form_board_name",errors,"#label_board_name","Please enter Board Name");
	//errors = CheckforNull("#form_board_description",errors,"#label_description","Please enter Board Description");
	errors = CheckforNullPushtoElement("#form_board_image_url",errors,"#label_upload_image","Please upload Image");
	
	return errors;
}

function deleteBoard(boardId,dataMode)
{
	if(dataMode==undefined)
		dataMode='c';
	$.ajax(
	{
		url: deleteBoardPath+"/"+boardId,
		type: "GET",
		beforeSend: function() {
			buildPopupMsg({
				"content": '<span style="color:blue;">Please wait...<span><br /><img src="/images/spinner_small.gif" style="margin-top:30px;"/>',
				"title": "Please Wait",
				"showOk": false,
				"closeByOverlay": false,
				"effect":false
			});
		},
		success: function(result)
		{
			logging("delete board result");
			if(result.hasError)
			{
				buildPopupMsg({
					"content":result.errorDescription,
					"showOk":true,
					"onOk":function(){
						closePopupMsg();
					}
				});
				logging("ERROR OCCURED");
			}	
			else
			{
				logging("REFRESH BOARDS");
				closePopupMsg();
				$("body").trigger("refresh_board",[portfolioProp.portfolioId,dataMode]);
			}
		}
	});
}

function ToggleStatusBoard(boardId)
{
	$.ajax(
	{
		url: toggleStatusBoardPath+"/"+boardId,
		type: "GET",
		success: function(result)
		{
			logging("Toggle Status board result");
			if(result.hasError)
			{
				buildPopupMsg({
					"content":result.errorDescription,
					"showOk":true,
					"onOk":function(){
						closePopupMsg();
					}
				});
				logging("ERROR OCCURED");
			}	
			else
			{
				logging("REFRESH BOARDS");
				closePopupMsg();
				$("body").trigger("refresh_board",[portfolioProp.portfolioId]);
			}
		}
	});
}

function editBoard(boardId,dataMode)
{
	if(dataMode==undefined)
		dataMode='c';
	//check the board status is not being processed
	$.ajax({
		url:isBoardLockedPath+"?boardId="+boardId,
		type:"GET",
		success: function (result) {
			if(result.hasLocked==true)
			{
				buildPopupMsg({
					"content":"This board is being purchased, it cannot be edited.",
					"showOk":true,
					"onOk":function(){
						closePopupMsg();
					}
				});
			}
			else {
				if(dataMode.toLowerCase()=='c')
					triggerHash("#edit_board_"+boardId);
				else
					triggerHash("#edit_pboard_"+boardId);
			}
		}
	});
}

function deletePortfolio(portfolioId,pagePrefix)
{
	if(pagePrefix==undefined)
		pagePrefix='portfolio_page';
	$.ajax(
	{
		url: deletePortfolioPath+"/"+portfolioId,
		type: "GET",
		beforeSend:function(e) {
			//show loading msg popup.
			buildPopupMsg({
				"content": '<span style="color:blue;">Please wait...<span><br /><img src="/images/spinner_small.gif" style="margin-top:30px;"/>',
				"title": "Please Wait",
				"showOk": false,
				"closeByOverlay": false,
				"effect":false
			});
		},
		error:function() {
			logging("Ajax error when deletes the portfolio");
		},
		success: function(result)
		{
			if(result.hasError)
			{
				buildPopupMsg({
					"content":result.errorDescription,
					"showOk":true,
					"onOk":function(){
						closePopupMsg();
					}
				});
				logging("ERROR OCCURED");
			}
			else
			{
				closePopupMsg();
				logging("Delete Portfolio Result=>"+result);
				//trigger hash
				triggerHash('#'+pagePrefix+'_'+portfolioProp.currentPage+"_1");
			}
		}
	});
}

function checkSession()
{
	//logging("check session=>"+keepSessionAlivePath+"?loginSSId="+sessionStorage.LI);
	logging("check session");
	var d = new Date().getTime();
	$.ajax(
	{
		//url:keepSessionAlivePath+"?loginSSId="+sessionStorage.LI,
		url:keepSessionAlivePath+'?v='+d,
		headers: {
			'Cache-Control': 'no-cache'
	    },
		success: function(result)
		{
			if(result=="OK")
			{
				logging("session still there","#F00");
			}
			else if($('#sessionTimeout',$('<div>'+result+'</div>')).val()=="true")
			{
				logging("session time out","#F00");
				window.location='/'; //redirect to the login page
			}
			/*else if(result=="FALSE")
			{
				if(enableLIChecking)
				{
					logging("Inconsistent userId","#F00");
					showErrorMsg("OOPS! Something confused us",true,"Error",true,"inconsistentLI",false);
				}
			}*/
		}
	});
}


function triggerHash(hash)
{
	if(location.hash==hash)
		$(window).hashchange();
	else
		location.hash=hash;
}

function triggerPopupHash(hash)
{
	//remove the digit
	var prefix=hash.replace(/_\d+/g,"");
	var segment=$.url().attr('fragment');
	//normalize the segArray
	/*for(x in segArray) {
		segArray[x]=segArray[x].replace(/_\d+/g,"");
	}*/
	if(segment.search(prefix)!=-1) {
		//replace the current hash
		var currentHash=$.url().attr('fragment');
		var patt = new RegExp(""+prefix+"[_\\d+]*"); 
		currentHash = currentHash.replace(patt,hash);
		triggerHash("#"+currentHash);
	}
	else {
		triggerHash($.url().attr('fragment')+"/"+hash); //concat the popup hash
	}
}

function selectTabHeader(tabTitle,cssClass)
{
	var portfolioId=getIdByName(tabTitle,true);
	if(cssClass==undefined)
		cssClass="ui-tabs-focus";
	if(portfolioId!=-1)
		$("#tabs li:nth-child("+(portfolioId+1)+")").addClass(cssClass);
}

function removeTabsFocusClass(tabTitle,cssClass)
{
	var portfolioId=getIdByName(tabTitle);
	if(cssClass==undefined)
		cssClass="ui-tabs-focus";
	if(portfolioId!=-1)
		$("#tabs li:nth-child("+(portfolioId+1)+")").removeClass(cssClass);
}

function getItemIndexFromObjectContainer(container,Pattern)
{
	var selectedItem=-1;
	if(container!=undefined)
	{
		for(var i=0;i<container.length;i++)
		{
			if(searchResult[i].boardId==Pattern)
				selectedItem=i;
		}
	}
	return selectedItem;
}

function submitChangePasswordForm()
{
	//user input checking
	var errors = new Array();
	//reset css
	$('#label_currentPassowrd').removeAttr('style');
	$('#label_newPwd').removeAttr('style');
	$('#label_confirmPwd').removeAttr('style');
	errors = CheckforNull("#currentPassword",errors,"#label_currentPassowrd","Please enter Current Password");
	errors = CheckforContainSpace("#currentPassword",errors,"#label_currentPassowrd","Please check that there are no spaces in Current Password");
	errors = CheckforNull("#newPwd",errors,"#label_newPwd","Please enter New Password");
	errors = CheckforContainSpace("#newPwd",errors,"#label_newPwd","Please check that there are no spaces in New Password");
    errors = CheckforNull("#confirmPwd" ,errors,"#label_confirmPwd" ,"Please enter Confirm Password");
    errors = CheckforContainSpace("#confirmPwd" ,errors,"#label_confirmPwd" ,"Please check that there are no spaces in Confirm Password");
    
	if(errors.length>0)
	{
		var errorInfo = new Array();
		for(var i=0; i<errors.length ; i++){
			errorInfo.push(errors[i]);
		}
		buildPopupMsg({
			"title":"Information <span style=\"#C30\">!</span>",
			"content":"Please enter data in the mandatory fields as highlighted in the screen and also displayed in the list:<br/>"+errorInfo.join("<br/>"),
			"showOk":true
		});
	}	
	else
	{
		$.ajax({
			url:$("#changePasswordForm").attr("action"),
			type:"POST",
			data:$("#changePasswordForm").serialize(),
			beforeSend: function() {
				//show loading popup
				buildPopupMsg({
					"content": '<span style="color:blue;">Please wait...<span><br /><img src="/images/spinner_small.gif" style="margin-top:30px;"/>',
					"title": "Please Wait",
					"showOk": false,
					"closeByOverlay": false,
					"effect":false
				});
			},
			success: function (result) {
				if(result.hasError){
					var errorInfo = new Array();
					for(var i=0; i<result.errors.length ; i++)
					{
						errorInfo.push(result.errors[i].defaultMessage);
						//helight area
						logging("Error field=>"+result.errors[i].field);
					}
					//hightlight error fields
					//highlightErrorFields(result);
					buildPopupMsg({
						"content":errorInfo.join("<br/>"),
						"showOk":true
					});
				}
				else {
					buildPopupMsg({
						"content": '<span style="color:blue;">Your password has beeen successfully updated.<span>',
						"title": "Update successfully",
						"showOk": true,
						"closeByOverlay": true,
						"effect":true,
						"onOk":function () {
							closePopup("#popupContainer","#overlay");
							closePopupMsg();
						},
						"onClose":function () {
							closePopup("#popupContainer","#overlay");
							closePopupMsg();
						}
					});
				}
			},
			error: function() {
				buildPopupMsg({
					"content":"Our service is not available, please submit again. Thanks.",
					"showOk":true
				});
			}
		});
	}
}

function checkStrength(password,label)
{
	if(label==undefined)
		label='#result';
	if(password==undefined)
		password=document.getElementById("#form_password").val;
	//initial strength
    var strength = 0;
    var requirements=new Array();
    requirements[0]=false; //length
    requirements[1]=false; //Contain capital
    requirements[2]=false; //Contain number
    requirements[3]=false; //Contain special character
    
	
    //if the password length is less than 6, return message.
    if (password.length < 8) 
    { 
		$(label).removeClass();
		$(label).addClass('short');
		requirements[0]=false;
		return 'Password should be at least 8 characters long';
	}
    
    //length is ok, lets continue.
	
	//if length is 8 characters or more, increase strength value
	if (password.length > 7)
	{
		requirements[0]=true;
		strength += 1;
	}
	
	//if password contains both lower and uppercase characters, increase strength value
	if (password.match(/([A-Z])/))
	//if (password.match(/([a-z].*[A-Z])|([A-Z].*[a-z])/))
	{
		requirements[1]=true;
		strength += 1;
	}
	
	//if it has numbers and characters, increase strength value
	if (password.match(/([a-zA-Z])/) && password.match(/([0-9])/))
	{
		requirements[2]=true;
		strength += 1;
	}
	
	//if it has one special character, increase strength value
    if (password.match(/([!,%,&,@,#,$,^,*,?,_,~,-])/)) 
    {
    	requirements[3]=true;
    	strength += 1;
    }
	
	//if it has two special characters, increase strength value
    if (password.match(/(.*[!,%,&,@,#,$,^,*,?,_,~,-].*[!,%,&,@,#,$,^,*,?,_,~,-])/)) 
    {
    	requirements[3]=true;
    	strength += 1;
    }
	
	//now we have calculated strength value, we can return messages
	
	//if value is less than 2
	if (strength < 4 ) 
	{
		var result="";
		$(label).removeClass();
		$(label).addClass('weak');
		if(!requirements[1])
			result+=" 1 capital.";
		else if(!requirements[2])
			result+=" 1 number";
		else if(!requirements[3])
			result+=" 1 special character";
		if(result!="")
			return "Weak. Should contain "+result;
		else
			return "Weak.";		
	} 
	else if (strength == 4 ) 
	{
		$(label).removeClass();
		$(label).addClass('good');
		return 'Good';		
	} 
	else 
	{
		$(label).removeClass();
		$(label).addClass('strong');
		return 'Strong';
	}
}

function updateNotifPopup(data)
{
	if(data.hasUnreadAlert || data.hasUnreadMessage) {
		//Check TS and show notification if TS is not the same
		if(sseUtility.eventAlertsTS!=data.latestAlertsTS || sseUtility.eventMessagesTS!=data.latestMessagesTS) {
			logging("Got new event");
			sseUtility.eventAlertsTS=data.latestAlertsTS;
			sseUtility.eventMessagesTS=data.latestMessagesTS;
			var notifText='';
			if(data.hasUnreadAlert==true)
				notifText+='<div class="notifPopup-item"><a onclick="triggerHash(\'#alerts\');">You have '+data.unreadAlertsCount+' unread alerts</a></div>';
			if(data.hasUnreadMessage==true)
				notifText+='<div class="notifPopup-item"><a onclick="triggerHash(\'#messages_page_1\')">You have '+data.unreadMessagesCount+' unread messages</a></div>';
			$('#notifContent').html(notifText); //Set text
			$('#notifPopup').fadeIn(500).fadeOut(500).fadeIn(500); //show notifPopup
			
			//Update new messages count on tab button
			if(data.unreadMessagesCount+data.unreadAlertsCount > 99) {
				if(data.unreadMessagesCount > 99)
					$('#new_messages_count').html('(99+)');
				else
					$('#new_messages_count').html('('+data.unreadMessagesCount+')');
				document.title='(99+) '+globalVars.title; //change document title
			}
			else {
				$('#new_messages_count').html('('+data.unreadMessagesCount+')');
				document.title='('+(data.unreadMessagesCount+data.unreadAlertsCount)+') '+globalVars.title; //change document title
			}
			
			
			//If sidebar is opened, reload the sidebar content.
			if(data.hasUnreadAlert) {
				if(globalVars.isSidebarOpened) {
					loadSidebarContent(function() {
						$('#sidebar_alerts').fadeOut(500).fadeIn(500).fadeOut(500).fadeIn(500).fadeOut(500).fadeIn(500);
					});
				}
			}

			//Retrieve selected tabs.
			//If the user already stays in the alerts tab, reload again to see the updated data.
			if($("#tabs").tabs("option","selected")===getIdByName("tab_alerts")) {
				$("#tabs").tabs("load",getIdByName("tab_alerts"));
			}
			
			//TODO check url hash is more accurate
			/*if($("#tabs").tabs("option","selected")===getIdByName("tab_messages"))
			{
				$("#tabs").tabs("load",getIdByName("tab_messages"));
			}*/
		}
	}
	else
	{
		//Update message count on tab button
		$('#new_messages_count').html('');
		$('#notifPopup').fadeOut(500);
		document.title=globalVars.title; //reset title
	}
}

function refershMultiselect(id)
{
	/*if(($(id+" + .mselect").length>0))
		$(id+" + .mselect").remove();*/
	$(id).multipleSelect('refresh');
	/*$(id).removeClass("mselect-hidden");
	$(id).multiselect({
		addText: '',
		size: 3,
		toggleAddButton: false,
		height: 100
	});
	if($(id+" ~ .mselect").length>1)
		$(id+" ~ .mselect:gt(0)").remove();*/
}

function initSSE()
{
	if(basicConfig.enableSSE) {
		if (typeof (EventSource) !== "undefined" && sseUtility.pollingMode!=true) {
			sseUtility.source = new EventSource(ssePath);
			logging("Listen SSE on path: "+ssePath);
			sseUtility.source.onmessage = function(event) {
				logging(event);
				var data=eval(event.data); //cast string to JSON object
				updateNotifPopup(data);
			};
			sseUtility.source.onerror = function(event) {
				logging("Error occurred!");
				logging(event.type);
			};
			sseUtility.source.onopen = function(event) {
				logging("SSE connection opened");
				logging(event.type);
			};
		} 
		else {
			logging("Sorry, your browser does not support server-sent events. Using ajax polling instead");
			if(ssePollingDuration == undefined || ssePollingDuration==null) {
				logging("Cannot retrieve the pollingDuration, using default value: 120000 milliseconds.");
				ssePollingDuration=120000;
			}
			//Get the first update without interval.
			$.ajax( {
				url:sseAltPath,
				type:"GET",
				success: function (data)
			    {
					logging(data);
					updateNotifPopup(data);
			    }
			});
			var i = setInterval(function ()
			{
				$.ajax( {
					url:sseAltPath,
					type:"GET",
					success: function (data)
				    {
						logging(data);
						updateNotifPopup(data);
				    },
				    error: function ()
				    {
				    	// on error, stop execution
				        i.clearInterval();
				    }
				});
			}, ssePollingDuration);
		}
	}
}

//Convert HTML entitles back
function unescapeHTML(source)
{
	//Unescape HTML reserved characters
	var target = source.replace(/&quot;/g,'"').replace(/&lt;/g,'<').replace(/&gt;/g,'>').replace(/&amp;/g,'&').replace(/&apos;/g,'\'');
	return target;
}

function htmlEntities(str) {
    return String(str).replace(/&/g, '&amp;').replace(/</g, '&lt;').replace(/>/g, '&gt;').replace(/"/g, '&quot;');
}

function boardHashChangeHandler(currentHash,createBoardPath,createBoardWithPortfolioPath,dataMode) {
	//get page id
	var temp=currentHash.split("_");
	var portfolioId=temp[2];
	
	logging("show create board tab");
	$('#tabs ul li a[title="tab_create_board"]').attr('data-mode',dataMode); //add attrbute on the tab li tags
	if(portfolioId==undefined) {
		$("#tabs").tabs("select","tab_create_board");
		//change the url
		$("#tabs").tabs("url",getIdByName("tab_create_board"),createBoardPath);
		//reload the page
		$("#tabs").tabs("load",getIdByName("tab_create_board"));
	}
	else {
		//change url
		$("#tabs").tabs("url",getIdByName("tab_create_board"),createBoardWithPortfolioPath+"/"+portfolioId);
		//select tab
		$("#tabs").tabs("select","tab_create_board");
	}
}

function navigate(obj,terminate) {
	if(terminate==true) {
		clearInterval(globalVars.blinkTimer);
		$('.nav').data('hasShown',false);
		$('.nav').fadeOut();
	}
	else {
		if($('.nav').length<=0)
			$(body).append('<div class="nav"></div>');
		$('.nav').css('top',obj.offset().top+obj.height()).css('left',obj.offset().left+(obj.width()/2)-($('.nav').width()/2));
		if($('.nav').data('hasShown')==undefined || $('.nav').data('hasShown')!=true) {
			//show effect
			globalVars.blinkTimer=setInterval(blinkEffect,1000); //register timer variable to globalVars
			//bind data on nav
			$('.nav').data('hasShown',true);
		}
	}
}

function blinkEffect() {
	$('.nav').fadeOut(500).fadeIn(500);
}

function convertCreditToUsd(object) {
	var targetVal = object.val(),
		patt = /(\.|\D)/g;
	if(patt.test(targetVal)) {
		object.val(targetVal.replace(patt,''));
		buildPopupMsg({
			"content":messagesProp.number_only,
			"showOk":true,
			"title":"Hint",
			"onClose":function(){
				object.focus();
				closePopupMsg();
			},
			"onOk": function(){
				object.focus();
				closePopupMsg();
			}
		});
	}
	if(creditConversionToUsd==undefined) //reset to default price if variable is undefined
		creditConversionToUsd=25;
	//calculate the value
	if(!isNaN(object.val())) {
		var result=parseInt(object.val())*creditConversionToUsd;
		if(!isNaN(result))
			object.next().html(result);
		else
			object.next().html('0');
	}
	else {
		object.next().html('0');
	}
}

function editProfileTabHandler(obj) {
	logging("init multiselect");
	if(obj.attr('user-type')=='designer') {
		var size4= {
			filter: true,
		    maxHeight: 200,
		    width: 215,
		    placeholder: "Please select",
		    selectAll: false
		};
		$("#form_education").multipleSelect(size4);
		$("#form_specialty").multipleSelect(size4);
		$("#form_expertise").multipleSelect(size4);
		$("#form_degacc").multipleSelect(size4);
		//add event callbacks
		size4.onClick=function() {
			profileScore();
		};
		size4.onCheckAll=function() {
			profileScore();
		};
		size4.onUncheckAll=function() {
			profileScore();
		};
		$("#form_languages").multipleSelect(size4);
		size4.maxHeight=150;
		$("#form_skills").multipleSelect(size4);
		//updateInput($('#form_education'));
		//updateInput($('#form_specialty'));
		//updateInput($('#form_expertise'));
		$('#firstName').focus();
	}
}

function addOtherToMS(obj){
	var $select = obj.parent().siblings('.ms-add-other'),
		$input = obj.siblings('.ms-add-other-value'),
		value = $.trim($input.val()),
		$opt = $("<option />", {
			value: '0{'+value+'}',
			text: value,
			'data-text':value,
			'data-is-others':true
		});
	if (!value) {
	    $input.focus();
	    return;
	}
	var matched=new Array();
	//check other value existence in the current list
	$select.children('option').each(function(i,val) {
		if(value.toUpperCase() == $(val).html().trim().toUpperCase()) {
			matched.push($(val).val()); //add option value to matched array.
		}
	});
	//if the other value exist in the current list, select the option in the current list.
	if(matched.length>0) {
		matched=matched.concat($select.multipleSelect('getSelects')); //merge selected array and matched array
		$select.multipleSelect('setSelects', matched);
	}
	else {
		$opt.prop("selected", true);
		$select.prepend($opt).multipleSelect("refresh");
	}
	$input.val("");
}

function updateMS(portfolioObj,productObj,productTypeObj) {
	var portfolioIdParam;
	if(portfolioObj.serialize()=="")
		portfolioIdParam="portfolioId="+portfolioObj.val();
	else
		portfolioIdParam=portfolioObj.serialize();
	if(productObj.val()!=null) {
		getProductTypeList("","",'',{
			"haveDontCareTag":false,
			"data":portfolioIdParam+'&'+productObj.serialize(),
			"container":"#productType",
			"rememberOldValue":true
		});
	}
	else {
		//console.log();
		productTypeObj.html(layoutTemplate.optionDefaultProductType);
		refershMultiselect('#'+productTypeObj.attr('id')); //Refresh multi-select plugin
	}
}

function categoryMSInit() {
	//initialize the option of "JPG+AI" to input field
	$("#product").multipleSelect({
		filter: true,
	    maxHeight: 150,
	    width: 244,
	    placeholder: "Please select",
	    onCheckAll:function() {
	    	updateMS($("#portfolioId"),$("#product"),$("#productType"));
	    },
	    onUncheckAll:function() {
	    	updateMS($("#portfolioId"),$("#product"),$("#productType"));
	    },
	    onClick:function(view) {
	    	updateMS($("#portfolioId"),$("#product"),$("#productType"));
	    }
	});
	//init multi-select component
	$("#productType").multipleSelect({
		filter: true,
	    maxHeight: 150,
	    width: 244,
	    placeholder: "Please select"
	});
}

function profileScore() {
	//initialization
	if($('#profileScore').data('targetScore')==undefined)
		$('#profileScore').data('currentScore',$('#profileScore').attr('profile-score'));
	var score=40;
	var targetScore=$('#profileScore').data('targetScore');
	//check address completeness. If the country is US, do check the state value or ignore it.
	if($('#address1').val().replace(/ /g,'')!=='' && $('#city').val().replace(/ /g,'')!=='' && ($('#form_state').val()!=0 || $('#form_country').val()!=238) && $('#zip').val().replace(/ /g,'')!=='' && $('#form_country').val()!=0) {
		score+=10;
		$('.profReqAddress').css('display','none');
	}
	else
		$('.profReqAddress').css('display','block');
		
	//check mobile pone
	if($('#cellPhone').val().replace(/ /g,'')!=='' && $('#cellPhone').val().length>=10) {
		score+=10;
		$('.profReqContact').css('display','none');
	}
	else
		$('.profReqContact').css('display','block');
	//check languages
	if($('#form_languages').val()!=null) {
		score+=10;
		$('.profReqLanguage').css('display','none');
	}
	else
		$('.profReqLanguage').css('display','block');
	//check about you
	if($('#aboutYou').val()!=undefined && $('#aboutYou').val().replace(/ /g,'')!=='') {
		score+=10;
		$('.profReqAbout').css('display','none');
	}
	else
		$('.profReqAbout').css('display','block');
	//check skills
	if($('#form_skills').val()!=null) {
		score+=10;
		$('.profReqSkill').css('display','none');
	}
	else
		$('.profReqSkill').css('display','block');
	//check schools awards
	if($('#misc').val()!=undefined && $('#misc').val().replace(/ /g,'')!=='') {
		score+=10;
		$('.profReqSchools').css('display','none');
	}
	else
		$('.profReqSchools').css('display','block');
	//check logo
	if($('#form_logo_image_url').val()!='/images/avatar_default.jpg') {
		$('.profPhoto').css('display','none');
	}
	else {
		$('.profPhoto').css('display','block');
	}
	
	if(score==100)
		$('.profCompleted').css('display','block');
	else
		$('.profCompleted').css('display','none');
	
	if(targetScore!=score) {
		$('#profileScore').qtip('show');
	}
	
	$('#profileScore').data('targetScore',score);
	var scoreAni=setInterval(function() { 
		var currentScore=$('#profileScore').data('currentScore');
		var targetScore=$('#profileScore').data('targetScore');
		if(currentScore>targetScore) {
			currentScore--;
		}
		else if(currentScore<targetScore) {
			currentScore++;
		}
		else {
			currentScore=targetScore;
			clearInterval(scoreAni); //clear timer
			$('#profileScore').qtip('reposition');
		}
		$('#profileScore').data('currentScore',currentScore);
		$('#profileScore').html(currentScore+'%');
	},10);
}

function searchCriteriaTabHandler() {
	//Initialize tree view------------------------------------------------------
	//load tree view data using JSON, it will load season.js
	//initSeasonsList("checkbox");
	var opts= {
		filter: true,
		maxHeight: 150,
		width: 215,
		placeholder: "Please select"
	};
	$('#form_languages').multipleSelect(opts);
	$('#form_skills').multipleSelect(opts);
	$("#form_spl").multipleSelect(opts);
	$("#form_exp").multipleSelect(opts);
	opts.width=260;
	opts.position='top';
	$('#form_product_type').multipleSelect(opts);
}

function convertPriceToCredit(price) {
	var creditConversionToUsd=25;
	var result=Math.ceil(parseInt(price)/creditConversionToUsd);
	return result;
}