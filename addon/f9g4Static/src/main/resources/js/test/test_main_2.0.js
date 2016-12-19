// JavaScript Document
var basicConfig = { 
	"debugMode":false, //set to true to enable debug panel
	"writeLogToConsole":false,
	"disableRightClick":false, 
	"enableSorting":true
};
var appConfig = { 
	"ver":4.0, 
	"ratyImgPath":"/images/raty_img", 
	"shoppingCartImgPath":"/images/shoppingcart.png", 
	"shoppingCartFullImgPath":"/images/shoppingcart_full.png"
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
	"isSidebaropened":false
};

//search result related settings
var searchResult;
var searchResultProp = { "currentPage":0, "totalPages":0, "itemsPerPage":15};

//portfolio result
var portfolioResult = { "data":null, "imageList":null};
var portfolioProp = { "currentPage":0, "totalPages":0, "itemsPerPage":8, "portfolioId":-1, "preloadPortfolioId":-1, "forceToReload":false};

//boards result related settings
var boardsResult = { "portfolioId":null, "data":null};
var boardProp = { "currentPage":0, "totalPages":0, "itemsPerPage":8, "forceToReload":false};

//empty message html layout
var layoutTemplate = {
"emptyPortfolioMsg":'<div class="empty" style="width:320px;"><i></i><span><a href="javascript:void(0)" id="add_manage_portfolio" style="color:#C30">Click here</a>&nbsp;to create your first portfolio!</span></div>',
"emptyBoardMsg":'<div class="empty"><i></i><span><a href="javascript:void(0)" id="add_manage_board" style="color:#C30">Click here</a>&nbsp;to create your first board!</span></div>',
"loadingMsg":'<div class="loadingSpinner"><span><img src="/images/spinner.gif" /></span></div>',
"basicConsoleFrame":'<div class="contentFrame">'
	+'<div class="content" id="basicContent">'
	+'<div class="loadingSpinner"><span><img src="/images/spinner.gif" /></span></div>' //loadingMsg
	+'</div>'
	+'</div>',
"errorStyle":"color:#FF0000",
/*Message List*/
"optionDefaultMsg":'<option value="-1">-Please select one option-</option>',
"optionLoadingMsg":'<option value="-1">Loading...</option>',
"emptyPage":'<div class="empty"><i></i><span>Empty Page<br />Please Select Another Page</span></div>'
};

$(document).ready(function()
{
	var winHeight=$(window).height();
	//logging("LI=>"+sessionStorage.LI+" ; LUUI=>"+sessionStorage.LUUI);
	logging("main running.."+appConfig.ver);
	logging("Browser Version:"+window.navigator.userAgent);
	//initialize the idel timeout plugin for session
	initIdleTimeoutPlugin();
	//init live query to init cloud zoom (live query help other plug-ins to bind on future element.  
	$('.cloud-zoom').livequery(function() 
	{
		$(this).CloudZoom();	
	});
	//disable mouse right click==================================================
	if(basicConfig.disableRightClick)
	{
		$(document).bind("contextmenu",function(e)
		{
			return false;
		});
	}
	
	//open the sidebar
	openSidebar();
	
	//bind the window load and focus event to check session=====================
	$(window).bind("load",function()
	{
		logging("load","#F00");
		//console.log("load");
		checkSession();
	});
	$(window).bind("focus",function()
	{
		if(!globalVars.isWindowFocus) //check now the window is focus or not
		{
			logging("focus","#F00");
			//console.log("focus");
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
	$(document).on("change","#form_edit_profile input",function()
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
	});
	resize(); //call resize event to render the title area.
*/	
	//initialize the tabs========================================================
	$("#tabs").tabs(
	{
		spinner: "Loading..",
		fx: {opacity: 'toggle',duration: "fast"},
		select:function(e,ui)
		{
			removeTabsFocusClass("tab_manage_portfolio"); //remove the css class of portfolio tab header
			removeTabsFocusClass("tab_home");
			selectTabHeader("tab_rating","hide"); //hide the tab header
			if(globalVars.isChangedWithoutSubmit)
			{
				e.preventDefault();
				//show confirmation window
				showConfirmation("You are about to leave the page with unsaved data, Continue?","Confirmation","changedWithoutSave",{
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
						location.hash='#messages_page_1';
						$("#tab_messages").html(layoutTemplate.basicConsoleFrame); //show loading message
					},
					"#tab_manage_portfolio":function() {
						//location.hash='#portfolio_page_0_1';
						//show loading message
						$('#portfolio_mask').html('<div class="data">'+layoutTemplate.loadingMsg+'</div>');
					},
					"#tab_create_portfolio":function() {
						selectTabHeader("tab_manage_portfolio");
					},
					"#tab_search_result":function() {
						syncMarket(); //synchronize the item status with shopping cart and search result.
					},
					"#tab_manage_board":function() {
						selectTabHeader("tab_manage_portfolio");
					},
					"#tab_create_board":function() {
						$("#tab_create_board").html(layoutTemplate.basicConsoleFrame); //show loading message
						selectTabHeader("tab_manage_portfolio");
					},
					"#tab_account":function() {
						location.hash="#designer_account_0_5_-1"; //default is desc by Date sold.
						$("#tab_account").html(layoutTemplate.basicConsoleFrame); //show loading message
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
					//Initialize tree view------------------------------------------------------
					//load tree view data using JSON, it will load season.js
					initSeasonsList("checkbox");
				},
				"#tab_search_result":function() {
					logging("show search result");
				},
				"#tab_design_wall":function() {
					
				},
				"#tab_messages":function() {
					//init autosize plugin
					//$("textarea").autosize();
					$("#messages_scrollbar").tinyscrollbar();
				},
				"#tab_activity_designer":function() {
					logging("activity designer tab");
					//initializa raty
					init_raty_activity();
					//initialize chart graph=====================================
					initChart(chartPath+"/30");
					//disable the Chart link
					disableChartLink("#chart_month");
				},
				"#tab_activity_company":function(){
					logging("activity designer tab");
					//initializa raty
					init_raty_activity();
					//initialize chart graph=====================================
					initChart(chartPath+"/30");
					//disable the Chart link
					disableChartLink("#chart_month");
				},
				"#tab_activity":function(){
					//initializa raty
					init_raty_activity();
					//initialize chart graph=====================================
					initChart(chartPath+"/30");
					//disable the Chart link
					disableChartLink("#chart_month");
				},
				"#tab_rating_designer":initRaty,
				"#tab_rating_company":initRaty,
				"#tab_rating":initRaty,
				"#tab_manage_portfolio":function() {
					
				},
				"#tab_manage_board":function() {
					//get boards data(ajax call)
					getBoardsByPage(boardsResult.portfolioId,boardProp.currentPage,boardProp.forceToReload);
				},
				"#tab_create_board":function()
				{
					logging("load create board tab");
					//if the edit mode, do not refresh the product and product list
					if($("#portfolioId").attr('edit-mode')==undefined || $("#portfolioId").attr('edit-mode')==false)
						$("#portfolioId").trigger("change"); //trigger the change event to get the level
					//initialize the option of "JPG+AI" to input field
				},
				"#tab_create_portfolio":function() {
					//logging("load create portfolio tab");
					initSeasonsList('radio');
					//TODO call getCatagorylist
					getCategoryList($("#form_division").val());
					//set the portfolio name of prePortfolioName
					$("#form_name_of_portfolio").val(globalVars.prePortfolioName);
					//clear the prePortfolioName
					globalVars.prePortfolioName="";
				},
				"#tab_home_edit_mode":function() {
					logging("init multiselect");
					if($(ui.tab).attr('user-type')=='designer')
					{
						var size4=
						{
							addText: '',
							size: 4,
							toggleAddButton: false,
							height: 100
						};
						$("#form_languages").multiselect(size4);
						$("#form_skills").multiselect(size4);
					}
				},
				"#tab_home":function() {
					//init scroll bar if there exsit
					$("#skill_scrollbar").tinyscrollbar();
					$("#lang_scrollbar").tinyscrollbar();
					$("#about_you_scrollbar").tinyscrollbar();
					$("#misc_scrollbar").tinyscrollbar();
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
				"#tab_activity":function() {
					logging("set raty value");
					//initialize raty plugin====================================
					init_raty_activity();
				},
				"#tab_manage_portfolio":function() {
					if(location.hash.search("#portfolio_page")==-1)
						location.hash='#portfolio_page_0_1';
					else
						getPortfolioItemsByPage(portfolioProp.currentPage,true);
					logging('<span style="color:#FF0000">content=>'+$("#portfolio_mask .data").html()+'</span>');
				},
				"#tab_manage_board":function() {
					logging("Show Manage Boards=>"+portfolioProp.portfolioId);
				},
				"#tab_create_board":function() {
					logging("SHOW CREATE BOARD");
					//$("#portfolioId").trigger("change"); //trigger the change event to get the level
				},
				"#tab_create_portfolio":function() {
				},
				"#tab_search_result":function() {
					logging("sync shopping cart and market.");
					syncMarket(); //synchronize the item status with shopping cart and search result.
					if(searchResult==undefined)
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
					}
				},
				"#tab_messages":function(){
					//init autosize plugin
					//$("textarea").autosize();
					$("#messages_scrollbar").tinyscrollbar();
				},
				"#tab_home":function() {
					//init scroll bar if there exsit
					$("#skill_scrollbar").tinyscrollbar();
					$("#lang_scrollbar").tinyscrollbar();
					$("#about_you_scrollbar").tinyscrollbar();
					$("#misc_scrollbar").tinyscrollbar();
				},
				"#tab_home_edit_mode":function() {
					logging("init multiselect");
					if($(ui.tab).attr('user-type')=='designer')
					{
						var size4=
						{
							addText: '',
							size: 4,
							toggleAddButton: false,
							height: 100
						};
						$("#form_languages").multiselect(size4);
						$("#form_skills").multiselect(size4);
					}
				},
				"#tab_shopping_cart":function() {
					$("#checkout_scrollbar").tinyscrollbar();
				},
				"#tab_rating":function() {
					removeTabsFocusClass("tab_rating","hide");
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
	}
	//Search criteria ===================================================================
	//event----------------------------------------------------------
	$(document).on("click","#submit_search_criteria",function()
	{
		var formData=$('#form_search_criteria').serialize();
		getSearchResult(formData);
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
		$("#form_product").html("<option value=-1>-Please select Category above-</option>");
		$("#form_product_type").html("<option value=-1>-Please select Product above-</option>");
		getCategoryList(e.target.value);
	});
	//category change event
	$(document).on("change","#form_category",function(e)
	{
		//logging("category change");
		getProductList(e.target.value);
	});
	//product change event
	$(document).on("change","#form_product",function(e)
	{
		//logging("product change");
		getProductTypeList(e.target.value);
	});
	//clear button
	$(document).on("click","#clear_search_criteria",function()
	{
		//reset the form
		$("#form_search_criteria")[0].reset();
		//reload the seasons list
		initSeasonsList("checkbox");
	});
	//Enter key event to call getSearchResult()
	$(document).on("keydown",'#form_search_criteria',function(e)
	{
		if(e.which==13) //enter key event
		{
			var formData=$('#form_search_criteria').serialize();
			getSearchResult(formData);
		}
	});
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
	$(document).on("click",".boardLink",function(e)
	{
		logging("boardLink clicked","#0F0");
		logging("hash=>"+location.hash,"#0F0");
		logging("data=>"+$(this).attr("data"),"#0F0");
		var targetboardId=$(this).attr("data");
		if(location.hash=="#nail_"+targetboardId) //if hash is the same, trigger the hash change event manually
		{
			logging("trigger hash change");
			$(window).hashchange();
		}
		else
			location.hash="nail_"+targetboardId;
	});
	//mouseenter event to show the focus effect
	$(document).on("mouseenter",".nail a",function(e)
	{
		//logging("mouseenter->"+e.currentTarget); //for debugging
		$(e.currentTarget.parentNode).toggleClass("hover");
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
	$(document).on("mouseleave",".nail a",function(e)
	{
		//logging("mouseout->"+e.currentTarget); //for debugging
		$(e.currentTarget.parentNode).toggleClass("hover");
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
		location.hash="#search_page_"+(searchResultProp.currentPage);
	});
	$(document).on("click","#search_carouselPrev",function(e)
	{
		logging('prev');
		
		logging("Current page=>"+searchResultProp.currentPage,"#00F");
		searchResultProp.currentPage--;
		if(searchResultProp.currentPage<0)
			searchResultProp.currentPage=searchResultProp.totalPages-1;
		//change the hash
		location.hash="#search_page_"+(searchResultProp.currentPage);
	});
	//sorting
	$(document).on("change","#sortSearchResult",function(e)
	{
		logging("sort search result=>"+this.value);
		sortSearchResult(this.value);	
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
	$(document).on("click","#sidebar_alerts",function(e)
	{
		logging("alerts");
		$("#tabs").tabs("select","tab_alerts");
	});
	$(document).on("click","#sidebar_messages",function(e)
	{
		logging("messages");
		//$("#tab_messages").html(basicConsoleFrame); //show loading message
		//change hash
		location.hash="#messages_page_1";
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
	
	
	//Home and Edit mode for both=======================================================================
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
			"previewArea":"#previewImage"
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
	//event handler when upload finish
	$(document).on("upload_finished","body",function(e)
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
	});
	//Edit mode----------------------------------------------------------
	//format the website url. If the user didn't put the http:// in front of the address, add it automatically.
	$(document).on("change","#website",function() 
	{
		 if (!/^http:\/\//.test(this.value)) 
		 {	 
	            this.value = "http://" + this.value;
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
			showConfirmation("You are about to leave the page with unsaved data, Continue?","Confirmation","changedWithoutSave",{
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
		if($("#form_saletype_1").attr("checked")=="checked")
			saleType="jpg";
		//close sidebar
		closeSidebar();
		//show upload popup
		buildUploadPopup({
			"url":uploadPicturesPath,
			"mode":"BOARD",
			"filetype":saleType,
			"previewArea":"#create_board_review",
			"event":"upload_finished_board"
		}); //url,mode,id for preview image,event name
	});
	//upload board image finish event handler 
	$(document).on("upload_finished_board","body",function(e)
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
	});
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
	$(document).on("click",'#saleTypeTable [type="radio"]',function(e)
	{
		//parse the id
		if(checkFileTypeAndSaleType())
		{
			var temp=e.currentTarget.id.split("_");
			clearSaleTypeTable();
			//get the previous price
			var previousPrice=$("#"+temp[1]+"_"+temp[2]).html();
			//set target area to apply an input field
			$("#"+temp[1]+"_"+temp[2]).html('<input name="saletype_'+temp[2]+'_cost" type="text" id="form_saletype_'+temp[2]+'_cost" class="cost" value="'+previousPrice+'"/>');
		}
		else
			e.preventDefault();
		
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
			if(checkFileTypeAndSaleType())
			{
				//show confirm window
				showConfirmation('It will <span style="color:#F00">NOT</span> publish your board to MarketPlace. Continue?',"Confirmation","save_create_board",{
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
			}
		}
		else
		{
			buildPopupMsg({
				"content":"The fields need to be enter in the following fields which are already highlighted in correspond fields:<br/>"+errors.join("<br/>"),
				"showOk":true
			});
		}
		
	});
	$(document).on("click","#publish_create_board",function(e)
	{
		var errors= createBoardInputChecking(e);
		if(errors.length==0)
		{
			if(checkFileTypeAndSaleType())
			{
				//show confirm window
				showConfirmation("Clicking Ok will publish this board to the marketplace. Continue?","Confirmation","publish_create_board",{
					"onOk":function(){
						unbindPopupMsgEvent();
						logging("Confirmation result=>"+e.trigger);
						logging("publish board");
						//change the value of publish to mp to 0
						$("#form_publish_to_mp").val("1");
						createBoard(true); //ajax call, the parameter is the boolean of publish to MP, true= publish to mp false=save
					}
				});
			}
		}
		else
		{
			buildPopupMsg({
				"content":"The fields need to be enter in the following fields which are already highlighted in correspond fields:<br/>"+errors.join("<br/>"),
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
	$(document).on("click","#back_to_portfolio",function(e)
	{
		logging("cancel create board");
		if(globalVars.isChangedWithoutSubmit)
		{
			showConfirmation("You are about to leave the page with unsaved data, Continue?","Confirmation","changedWithoutSaveOnCreateBoard",{
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
			showConfirmation("You are about to leave the page with unsaved data, Continue?","Confirmation","changedWithoutSaveOnCreateBoard",{
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
			success: function(result)
			{
				//put the list
				var listContent="";
				for(var i=0;i<result.list.length;i++)
				{
					listContent+='<option value='+result.list[i].categoryId+'>'+result.list[i].name+'</option>';
				}
				$("#product").html(listContent);
				$("#product").trigger("change");
			}
		});
	});
	$(document).on("change","#product",function(e)
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
				//console.log(result);
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
		});
	});
	$(document).on("change",'#expDays input[name="expirationDays"]',function()
	{
		////console.log("Days=>"+this.value);
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
	//End of create board tab====================================================================================
	
	//Create a portfolio tab=====================================================================================
	$(document).on("click","#save_create_portfolio",function(e)
	{
		logging("save create portfolio");
		createPortfolio();
	});
	$(document).on("click","#cancel_create_portfolio",function(e)
	{
		logging("cancel create portfolio");
		$("#tabs").tabs("select","tab_manage_portfolio");
	});
	$(document).on("click","#add_new_board",function(e)
	{
		//change the hash
		location.hash="#create_board";
	});
	$(document).on("change","#form_division",function(e)
	{
		logging("division change=>"+e.target.value);
		//get category list
		getCategoryList(e.target.value);
	});
	//End of create a portfolio tab==============================================================================
	
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
	//End of activity tab======================================================================================
	
	//Manage portfolio tab=====================================================================================
	$(document).on("click","#clear_manage_portfolio",function(e)
	{
		$("input").removeAttr("checked"); //uncheck all checkbox
	});
	$(document).on("click","#add_manage_portfolio",function(e)
	{
		logging("add portfolio");
		$("#tabs").tabs("select","tab_create_portfolio");
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
		location.hash="#board_page_"+$(this).attr("data")+"_0";
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
	$(document).on("click","#portfolio_carouselPrev",function(e)
	{
		logging("portfolio prev");
		
		//set the current page
		portfolioProp.currentPage--;
		if(portfolioProp.currentPage<0)
			portfolioProp.currentPage=portfolioProp.totalPages-1;
		//change the hash
		triggerHash("#portfolio_page_"+portfolioProp.currentPage+"_0");
	});
	$(document).on("click","#portfolio_carouselNext",function(e)
	{
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
		/*var r=confirm("The portfolio is going to be deleted. Coninue ?");*/
		showConfirmation("The portfolio is going to be deleted. Coninue ?","Confirmation","delete_portfolio",{
			"onOk":function() {
				unbindPopupMsgEvent();
				deletePortfolio(targetedId);
			},
			"onCancel":function(){
				logging("cancel");
			}
		});
		/*$(document).on("delete_portfolio","body",function(e)
		{
			////console.log(e);
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
	//End of manage portfolio tab=============================================================================
	
	//manage board tab========================================================================================
	$(document).on("click","#show_all_portfolios",function(e)
	{
		logging("Show all portfolio","#F90");
		$("#tabs").tabs("select","tab_manage_portfolio");
	});
	$(document).on("change","#portfolio_catalog",function(e)
	{
		logging("change location=>"+e.currentTarget.value);
		//change hash to trigger hash change event
		location.hash="#board_page_"+e.currentTarget.value+"_0";
	});
	$(document).on("click","#publish_manage_board",function(e)
	{
		logging("publish board");
	});
	$(document).on("click","#add_manage_board",function(e)
	{
		//get portfolio id
		logging("add new board under portfolio =>"+$("#portfolio_catalog").val());
		//change the hash
		location.hash="#create_board_"+$("#portfolio_catalog").val();
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
	$(document).on("refresh_board","body",function(e,pId)
	{
		logging("REFRESH BOARD BY EVENT");
		refreshBoards(pId);
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
		/*var r=confirm("The board is going to be deleted. Coninue ?");*/
		showConfirmation("The board is going to be deleted. Coninue ?","Confirmation","delete_board",{
			"onOk":function() {
				unbindPopupMsgEvent();
				////console.log(e);
				logging("Confirmation result=>"+e.trigger);
				deleteBoard(targetBoardId);
			}
		});
		/*$(document).on("delete_board","body",function(e)
		{
			////console.log(e);
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
		showConfirmation("The status of the board is going to be changed. Continue ?","Confirmation","togglePubstatus_board",{
			"onOk":function() {
				unbindPopupMsgEvent();
				////console.log(e);
				logging("Confirmation result=>"+e.trigger);
				ToggleStatusBoard(targetBoardId);
			}
		});
		/*$(document).on("togglePubstatus_board","body",function(e)
		{
			////console.log(e);
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
		showConfirmation("The status of the board is going to be changed. Coninue ?","Confirmation","toggleHidstatus_board",{
			"onOk":function(){
				unbindPopupMsgEvent();
				////console.log(e);
				logging("Confirmation result=>"+e.trigger);
				ToggleStatusBoard(targetBoardId);
			}
		});
		/*$(document).on("toggleHidstatus_board","body",function(e)
		{
			////console.log(e);
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
		editBoard($(this).attr("data"));
	});
	//End of manage board tab=============================================================================
	
	//Check out tab=======================================================================================
	$(document).on("click","#back_to_search_result",function(e)
	{
		logging("back to results");
		//change the hash
		location.hash="search_page_"+searchResultProp.currentPage;
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
					////console.log("DELETE MULTI");
					////console.log(cart);
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
		addToCart($(this).attr("data"));
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
		showWindow($(this).attr("data"),false);
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
	})
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
			success : function(result) 
			{
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
		$("#referral_firstname_"+tableId).html('<input type="text" name="firstName" maxlength="30" value='+$("#referral_firstname_"+tableId).html()+'></input>');
		$("#referral_lastname_"+tableId).html('<input type="text" name="lastName" maxlength="30" value='+$("#referral_lastname_"+tableId).html()+'></input>');
		$("#referral_phone_"+tableId).html('<input type="text" name="phone" maxlength="20" value='+$("#referral_phone_"+tableId).html()+'></input>');
		$("#referral_email_"+tableId).html('<input type="text" name="email" maxlength="50" value='+$("#referral_email_"+tableId).html()+'></input>');
		//create link update
		var updateLink='<a class="update_referral" id="update_referral_'+tableId+'">Update</a>';
		var sendLink='<a class="send_referral" id="send_referral_'+tableId+'">Update and Send</a>';
		//change the link in action area
		$("#referral_action_"+tableId).html(updateLink+"<br />"+sendLink);
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
		tableId=temp[2];
		$.ajax(
		{
			url:resendReferralNotiPath+"/"+tableId,
			type: "POST",
			success: function(result)
			{
				logging("Resend referral notification "+result.result,"#F0F");
			}
		});
	});
	$(document).on("click",".send_referral",function(e)
	{
		doSendReferral(e);
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
	
	//Session popup=============================================================
	$(document).on("click","#logout",function(e)
	{
		logging("LOGOUT");
		logout();
	});
	
	/*//Listener for inconsistentLI
	$("body").bind("inconsistentLI",function(e)
	{
		location.href=logoutPath;
	})*/
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
	////console.log("FPARAM=>"+$.url().fsegment(1));
	////console.log("FPARAM=>"+decodeURIComponent($.url().fsegment(2)));
	var currentHash="#"+$.url().fsegment(1);
	////console.log(currentHash);
	if(currentHash.search("#nail")!=-1) //check the hash contain '#item' or not
	{
		logging("Hash Change=>"+location.hash);
		var temp=currentHash.split("_");
		//logging(e.currentTarget.id); //for debugging
		showWindow(temp[1]); //show the popup
		closeSidebar();	//close the sidebar
	}
	else if(currentHash.search("#messages_page")!=-1)
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
		//reload the tab
		$("#tabs").tabs("url",page_messages,messagesPagePath+"/"+id); //show the views
		//set the portfolio Id
		//select tab
		logging("SELECT MESSAGES");
		$("#tab_messages").html(layoutTemplate.basicConsoleFrame); //show loading message
		$("#tabs").tabs("select",page_messages);
		$("#tabs").tabs("load",page_messages);
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
		var pageResult=getSearchResultByPage(pageId);
		logging("load search page=>"+pageId);
		logging("sort option=>"+sortOption);
		
		$("#tabs").tabs("enable","tab_search_result"); //enable search result tab		
		$("#tabs").tabs("select","tab_search_result"); //select search result tab
		$("#tabs").tabs("disable","tab_search_criteria"); //disable search tab
		
		if(pageResult!="")
		{
			if(sortOption!=undefined)
				sortSearchResult(sortOption);
			else
				sortSearchResult(1);
		
			//set currentpage
			searchResultProp.currentPage=pageId;
			//show pagin
			searchResultPagin();
			//create new div to put the data
			$('#mask').append('<div class="nextdata">'+pageResult+'</div>');
			
			//show transition effect
			transit('#mask');
			//sync market
			syncMarket();
		}
	}
	else if(currentHash.search("#portfolio_page")!=-1)
	{
		var managePortfolioIndex=getIdByName('tab_manage_portfolio');
		//get page id
		var temp=currentHash.split("_");
		var pageId=temp[2];
		var forceToLoad=temp[3];
		logging("load portfolios page=>"+pageId+" ; forceToLoad=>"+forceToLoad);
		
		if($('#tabs').tabs('option','selected') == managePortfolioIndex)
		{
			$("#tabs").tabs("select","tab_manage_portfolio");
			//set current page
			portfolioProp.currentPage=pageId;
			getPortfolioItemsByPage(pageId,forceToLoad); //get the data by page.
		}
		else
		{
			$("#tabs").tabs("select","tab_manage_portfolio");
			//set current page
			portfolioProp.currentPage=pageId;
			//getPortfolioItemsByPage(pageId,forceToLoad); //get the data by page.
		}
	}
	else if(currentHash.search("#board_item")!=-1)
	{
		//get board id
		var temp=currentHash.split("_");
		var id=temp[2];
		logging("show board item=>"+id);
		
		//close sidebar
		closeSidebar();
		buildPopup({
			"url":boardDetailPath+"/"+id
		},function () {
			$(".popup .entity").tinyscrollbar();
			$(".input textarea").autosize();
		}); //show popup
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
	else if(currentHash.search("#create_board")!=-1)
	{
		//get page id
		var temp=currentHash.split("_");
		var portfolioId=temp[2];
		
		logging("show create board tab");
		if(portfolioId==undefined)
		{
			$("#tabs").tabs("select","tab_create_board");
			//change the url
			$("#tabs").tabs("url",getIdByName("tab_create_board"),createBoardPath);
			//reload the page
			$("#tabs").tabs("load",getIdByName("tab_create_board"));
		}
		else
		{
			//change url
			$("#tabs").tabs("url",getIdByName("tab_create_board"),createBoardWithPortfolioPath+"/"+portfolioId);
			//select tab
			$("#tabs").tabs("select","tab_create_board");
		}
	}
	else if(currentHash.search("#edit_board")!=-1)
	{
		//get page id
		var temp=currentHash.split("_");
		var boardId=temp[2];
		logging("edit board=>"+boardId);
		//change the url
		$("#tabs").tabs("url",getIdByName("tab_create_board"),createBoardPath+"/"+boardId);
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
		$("#tabs").tabs("select","tab_alerts");
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
	else
	{
		logging("close=>"+currentHash);
		closePopup();
	}
}
//End of hash change==================================================================================

//Tab function========================================================================================
function getIdByName(target)
{
	//get id by name
	var relTable=$("#tabs").children('div');
	for(var i=0;i<relTable.length;i++)
	{
		if(relTable[i].id==target)
			return i;
	}
	return -1;
}
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
			logging("Chart Loading");
			$("#activity_chart").html('<div style="margin-left:47%; margin-top:14%"><span style="text-align: center;"><img src="/images/spinner_small.gif" /></span></div>');
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
	var html = '';
	var trClass="odd";
	for (var key=0, size=item.length; key<size;key++) 
	{
		if(key%2==1)
			trClass="odd";
		else
			trClass="even";
		//determine to show the dummy image or not
		if(item[key].showImage)
			html+='<tr class="'+trClass+'"><td class="td1">'+ '<a href="javascript:void(0)" class="gridBoardId" data='+ item[key].boardId +'> <img src="/100x100/' +item[key].boardImageUrl + '"/></a></td>';
		else
			html+='<tr class="'+trClass+'"><td class="td1">'+ '<a href="javascript:void(0)" class="gridBoardId" data='+ item[key].boardId +'> <img src="/images/forbidden.jpg"/></a></td>';
		html +=	'<td class="td2">'+ '	 <a href="javascript:void(0)" class="gridBoardId" data='+ item[key].boardId +'>' +  item[key].boardName +'</a></td>' +
				'<td class="td3">'+ item[key].season +'</td>' +
				'<td class="td4">'+ item[key].portfolioname +'</td>' +
				'<td class="td5">'+ item[key].noofHits +'</td>' +
				'<td class="td6">$'+ item[key].price +'</td></tr>';
	}
	$('#activity_designer_grid').html("");
	$('#activity_designer_grid').html(html);
	//update the scroll bar
	$("#grid_scrollbar").tinyscrollbar_update();
}

function fillCompanyGrid(item)
{
	var html = '';
	var trClass="odd";
	for (var key=0, size=item.length; key<size;key++) 
	{
		if(key%2==1)
			trClass="odd";
		else
			trClass="even";
		if(item[key].showImage)
			html+='<tr class="'+trClass+'"><td class="td1">'+ '<a href="javascript:void(0)" class="gridBoardId" data='+ item[key].boardId +'> <img src="/100x100/' +item[key].boardImageUrl + '"/></a></td>';
		else
			html+='<tr class="'+trClass+'"><td class="td1">'+ '<a href="javascript:void(0)" class="gridBoardId" data='+ item[key].boardId +'> <img src="/images/forbidden.jpg"/></a></td>';
		html +=	'<td class="td2">'+ '<a href="javascript:void(0)" class="gridBoardId" data='+ item[key].boardId +'>' +  item[key].boardName 	  +'</a></td>' +
	  			'<td class="td3">'+ item[key].season +'</td>' +
				'<td class="td4">'+ '<a href="javascript:void(0)" class="gridDesignerName" data='+ item[key].designerId +'>' +  item[key].designerName +'</a></td>' +
				'<td class="td5">$'+ item[key].price +'</td>' +
				'<td class="td6">'+ item[key].strDateViewed +'</td></tr>';
	}
	$('#activity_company_grid').html("");
	$('#activity_company_grid').html(html);
	//update the scroll bar
	$("#grid_scrollbar").tinyscrollbar_update();
}

function plotGraph(data,ticks,pointLabels)
{
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
			////console.log(cart);
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
			////console.log("IN CART=>");
			globalVars.cart=result;
			checkShoppingCart(result.count)
			////console.log(cart);
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
			success: function (result)
			{
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
			success: function (result)
			{
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
		success: function (result)
		{
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
	$("#"+stuffId).css(
	{
		opacity:1,
		width:150,
		height:150
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
	$("#"+stuffId).animate(
	{
		top: termination.top+8,
		left: termination.left+50,
		width:0,
		height:0
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
		opacity:1,
		width:0,
		height:0
	});
	//copy the target html to stuff
	$("#"+stuffId).html($("#board_"+target_id).html());
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
	$("#"+stuffId).animate(
	{
		top: termination.top,
		left: termination.left,
		width:148,
		height:98
	},1500,'swing',function()
	{
		$("#"+stuffId).remove();//delete the div the stuff div
		//chage cart icon that is added to cart
		$("#add_board_"+target_id).toggleClass("added_to_cart");
		$('#body').css("cursor","default");
		$('.add_to_cart').css("cursor","pointer");
	});
}

function addToCart(boardId)
{
	//ajax call to add item
	$.ajax(
	{
		url: addItemPath,
		type: "POST",
		data: "boardId="+boardId,
		success: function (result)
		{
			checkShoppingCart(result.count);
			globalVars.cart=result;
			//show add successful message
			buildPopupMsg({
				"content":"Added to cart successfully<br />(This popup will be closed automatically in 5 seconds)",
				"showOk":true,
				"title":"Add to cart",
				"showOverlay":true,
				"onShow":function(){
					var timeout=setTimeout(function (){
						closePopupMsg();
					},5000);
				}
			});
			//load popup again
			showWindow(boardId,false);
			//sync market
			syncMarket();
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
function createBoard(isPublished)
{
	if(isPublished==undefined)
		isPublished=false;
	calculate(); //calculate the final price
	//get the number of all sale type column
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
	//send the request
	$.ajax(
	{
		url: createBoardPath,
		type: "POST",
		data: $("#form_create_board").serialize()+"&price="+price,
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
					var timeout;
					//TODO user customed popup
					buildPopupMsg({
						"content":"Board created successfully<br />(This popup will be closed automatically in 5 seconds)",
						"showOk":true,
						"title":"Create board",
						"onShow":function(){
								timeout=setTimeout(function(){
								closePopupMsg();
								//change the hash
								triggerHash("#board_page_"+$("#form_create_board #portfolioId").val()+"_0_1");
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
							triggerHash("#board_page_"+$("#form_create_board #portfolioId").val()+"_0_1");
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
							triggerHash("#board_page_"+$("#form_create_board #portfolioId").val()+"_0_1");
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
					var timeout;
					buildPopupMsg({
						"content":"Update board successfully<br />(This popup will be closed automatically in 5 seconds)",
						"showOk":true,
						"title":"Update board",
						"onShow":function(){
								timeout=setTimeout(function(){
								closePopupMsg();
								if(isPublished)
								{
									//change the hash
									triggerHash("#board_page_"+$("#form_create_board #portfolioId").val()+"_0_1");
								}
								else
									clear();
							},5000);
						},
						"onClose":function() {
							if(isPublished)
							{
								//change the hash
								triggerHash("#board_page_"+$("#form_create_board #portfolioId").val()+"_0_1");
							}
							else
							{
								//change the url
								$("#tabs").tabs("url",getIdByName("tab_create_board"),createBoardPath+"/"+result.boardId);
								//go back to portfolio page
								$("#tabs").tabs("select","tab_create_board");
							}
							clearTimeout(timeout);
						},
						"onOk":function() {
							closePopupMsg();
							if(isPublished)
							{
								//change the hash
								triggerHash("#board_page_"+$("#form_create_board #portfolioId").val()+"_0_1");
							}
							else
							{
								//change the url
								$("#tabs").tabs("url",getIdByName("tab_create_board"),createBoardPath+"/"+result.boardId);
								//go back to portfolio page
								$("#tabs").tabs("select","tab_create_board");
							}
							clearTimeout(timeout);
						}
					});
					/*if(isPublished)
					{
						//set the flag
						globalVars.isChangedWithoutSubmit=false;
						$("#tabs").tabs("load",getIdByName("tab_manage_portfolio"));
						//go back to portfolio page
						$("#tabs").tabs("select","tab_manage_portfolio");
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
	logging("CLEAR FORM");
	$("#form_create_board")[0].reset(); //reset the form
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
		$("#saletype_"+i).html("0000.00");
		$("#saletype_"+i+"_final").html("0000.00");
	}
	//uncheck all saletype
//	$('[type="radio"]').removeAttr("checked");
	//clear the form data
	$("#form_final_price").val("0");
	
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
		$("#saletype_"+i).html("0000.00");
		$("#saletype_"+i+"_final").html("0000.00");
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
function getBoardsByPage(pId,pageId,forceToReload)
{
	var pageContent="";
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
				//count total pages
				boardProp.totalPages=Math.ceil(result.results.length/boardProp.itemsPerPage);
				logging("Total board pages=>"+boardProp.totalPages);
				//Load page again
				getBoardsByPage(pId,pageId,false);
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
				var nail="";
				nail+='<div class="item">';
				nail+='<div class="item-function">';
				nail+='<div class="edit"><a data="'+item.boardId+'">Edit</a></div>';
				nail+='<div class="delete_board" data="'+item.boardId+'"><img src="/images/recycle_bin.png" /></div>';
				nail+='<div class="status"> '+item.boardStatus+'</div>';
				if(item.boardStatus!="Expired")
				{
					if(item.boardStatus!="Published")
						nail+='<div class="toggleStatus togglePubstatus_board" data="'+item.boardId+'"><img src="/images/order.png" /></div>';
					else
						nail+='<div class="toggleStatus toggleHidstatus_board" data="'+item.boardId+'"><img src="/images/order.png" /></div>';
				}
				nail+='</div>';
				nail+='<a href="#board_item_'+item.boardId+'" id="board_'+item.boardId+'" class="designerBoardLink" data="'+item.boardId+'">';
				nail+='<div class="board"><i></i>';
				if(item.boardImages.length > 0)
					nail+='<img src="/400x400/'+item.boardImages[item.boardImages.length-1].fileName+'" />'; //image resource
				nail+='</div>';
				nail+='</a>';
				nail+='<div class="detail">';
				nail+='<div class="board_name">'+item.name+'</div>';
				nail+='<div class="price">Price $ '+item.totalPrice+'</div>';
				//nail+='<div class="checkbox"><input name="selectedItems" type="checkbox" value="'+item.boardId+'" id="form_board_'+item.boardId+'"/></div>';
				nail+='</div>';
				nail+='</div>';
				pageContent+=nail;
			}
		}
		//show effect
		if(pageContent.length<=0) //if the length less than 0, show empty message
			$('#board_mask').append('<div class="nextdata">'+layoutTemplate.emptyBoardMsg+'</div>');
		else
			$('#board_mask').append('<div class="nextdata">'+pageContent+'</div>'); 	//create new div to put the data
		
		boardsPagin();
		//show transition effect
		transit('#board_mask');
	}
}
function boardsPagin()  
{
	logging("Refresh boards pagin","#0F0");
	var pagin="";
	logging("cpage=>"+boardProp.currentPage);
	var pagin="";
	boardProp.currentPage=parseInt(boardProp.currentPage);
	//show head pagin
	if(boardProp.currentPage==0)
		pagin+='1&nbsp;';
	else
		pagin+='<a href="#board_page_'+portfolioProp.portfolioId+'_0">1</a>&nbsp;';
	//show middle page if the totalPages > 2,(equals to 2 means only head and tail)
	if(boardProp.totalPages>2)
	{
		//show ... before current page
		if(boardProp.currentPage>=3)
			pagin+='...&nbsp;';
		//show adajacent page
		if(boardProp.currentPage>=2)
			pagin+='<a href="#board_page_'+portfolioProp.portfolioId+'_'+(boardProp.currentPage-1)+'">'+(boardProp.currentPage)+'</a>&nbsp;';
		//current page
		if(boardProp.currentPage!=0 && boardProp.currentPage!=boardProp.totalPages-1)
			pagin+=(boardProp.currentPage+1)+'&nbsp;';
		//show adajacent page
		if(boardProp.totalPages-boardProp.currentPage>=3)
			pagin+='<a href="#board_page_'+portfolioProp.portfolioId+'_'+(boardProp.currentPage+1)+'">'+(boardProp.currentPage+2)+'</a>&nbsp;';
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
			pagin+='<a href="#board_page_'+portfolioProp.portfolioId+'_'+(boardProp.totalPages-1)+'">'+boardProp.totalPages+'</a>&nbsp;';
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
function prevBoardPage()
{
	logging("board prev");
	logging(portfolioProp);
	//load data using ajax
	
	boardProp.currentPage--;
	if(boardProp.currentPage<0)
		boardProp.currentPage=boardProp.totalPages-1;
	//change hash
	location.hash="#board_page_"+portfolioProp.preloadPortfolioId+"_"+boardProp.currentPage;
}
function nextBoardPage()
{
	logging("board next");
	logging(portfolioProp);
	//load data using ajax
	
	boardProp.currentPage++;
	if(boardProp.currentPage>=boardProp.totalPages)
		boardProp.currentPage=0;
	//change hash
	location.hash="#board_page_"+portfolioProp.preloadPortfolioId+"_"+boardProp.currentPage;
}
function refreshBoards(pId)
{
	//change hash
	if(location.hash==="#board_page_"+portfolioProp.portfolioId+"_0_1") //if the hash is already the same, trigger it forcely.
	{
		////console.log('realod');
		$(window).hashchange();
	}
	else
		location.hash="board_page_"+portfolioProp.portfolioId+"_0_1";
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
function checkFileTypeAndSaleType()
{
	//get selected radio button
	//get upload file type
	var saletype=$('#saleTypeTable input[type="radio"]:checked').attr("code");
	var filetype=$('#form_board_image_type').val();
	if(filetype=='ai')
	{
		if(saletype=="JG")
		{
			buildPopupMsg({
				"content":"The file you uploaded is ai, please select the options with AI",
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
			////console.log("file type inconsistent");
			buildPopupMsg({
				"content":"The file you uploaded is jpg, please select the option JPG",
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
function getCategoryList(parentId)
{
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
			////console.log("Error=>"+jqXHR+";"+textStatus+";"+errorThrown);
			$("#form_category").html("");
		},
		success: function(result,status)
		{
			logging("GET CATEGORY=>"+result.list.length);
			////console.log(result);
			var optionList;
			if(result.list.length<=0)
			{
				optionList="<option value=-1>--Empty--</option>";
			}
			else
			{
				//create default msg
				optionList=layoutTemplate.optionDefaultMsg;
				//create options tag
				for(var i=0;i<result.list.length;i++)
				{
					optionList+='<option value='+result.list[i].categoryId+'>'+result.list[i].name+'</option>';
					//logging("LIST "+i+" => "+optionList);
				}
			}
			$("#form_category").html(optionList);
		},
		complete: function(jqXHR, textStatus)
		{
			logging("AJAX Complete=>"+jqXHR+":"+textStatus);
			////console.log("AJAX Complete=>"+jqXHR+":"+textStatus);
		}
	});
}
function getProductList(parentId)
{
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
			////console.log("Error=>"+jqXHR+";"+textStatus+";"+errorThrown);
			$("#form_product").html("");
		},
		success: function(result,status)
		{
			logging("GET LEVEL=>"+result.list.length);
			////console.log(result);
			var optionList;
			if(result.list.length<=0)
			{
				optionList="<option value=-1>--Empty--</option>";
			}
			else
			{
				optionList=layoutTemplate.optionDefaultMsg;
				//create options tag
				for(var i=0;i<result.list.length;i++)
				{
					optionList+='<option value='+result.list[i].categoryId+'>'+result.list[i].name+'</option>';
					//logging("LIST "+i+" => "+optionList);
				}
			}
			$("#form_product").html(optionList);
		},
		complete: function(jqXHR, textStatus)
		{
			logging("AJAX Complete=>"+jqXHR+":"+textStatus);
			////console.log("AJAX Complete=>"+jqXHR+":"+textStatus);
		}
	});
}
function getProductTypeList(parentId)
{
	$.ajax(
	{
		cache: false,
		url: productTypeListPath+"/"+parentId,
		type: "GET",
		timeout: 5000,
		beforeSend: function(xhr)
		{
			$("#form_product_type").html(layoutTemplate.optionLoadingMsg);  //add the default list
		},
		error: function(jqXHR, textStatus, errorThrown)
		{
			logging("Error=>"+jqXHR+";"+textStatus+";"+errorThrown);
			////console.log("Error=>"+jqXHR+";"+textStatus+";"+errorThrown);
			$("#form_product_type").html("");
		},
		success: function(result,status)
		{
			logging("GET LEVEL=>"+result.list.length);
			////console.log(result);
			var optionList;
			if(result.list.length<=0)
			{
				optionList="<option value=-1>--Empty--</option>";
			}
			else
			{
				optionList=layoutTemplate.optionDefaultMsg;
				//create options tag
				for(var i=0;i<result.list.length;i++)
				{
					optionList+='<option value='+result.list[i].categoryId+'>'+result.list[i].name+'</option>';
					//logging("LIST "+i+" => "+optionList);
				}
			}
			$("#form_product_type").html(optionList);
		},
		complete: function(jqXHR, textStatus)
		{
			logging("AJAX Complete=>"+jqXHR+":"+textStatus);
			////console.log("AJAX Complete=>"+jqXHR+":"+textStatus);
		}
	});
}
//End of board level list getter===========================================================

//Search Result related functions=======================================//
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
function getSearchResult(searchCriteria,page)
{
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
		beforeSend: function()
		{
			$('#searchCriteriaLoadingPanel').fadeIn(0); //show loading message
		},
		success: function(result)
		{	
			$('#searchCriteriaLoadingPanel').fadeOut(0); //hide loading messag
			if(result.hasError == false)
			{
				if(result.results.length ==0)
				{
					//TODO show empty message
					buildPopupMsg({
						"content":"Your search did not return any results.<br/>Please redefine search criteria.",
						"showOk":true,
						"title":"No search result"
					});
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
					location.hash="#search_page_0/"+encodeURIComponent(searchCriteria);
					
					//$("#tabs").tabs("enable","tab_search_result"); //enable search result tab
					//if we select would send a request to server and renders the original page..
					//$("#tabs").tabs("select","tab_search_result"); //select search result tab
					//$("#tabs").tabs("disable","tab_search_criteria"); //disable search tab
				}
			}else
			{
				//go back to search criteria
				buildPopupMsg({
					"content":"Your search did not return any results.<br/>Please redefine search criteria.",
					"showOk":true,
					"title":"No search result"
				});
			}

		}
	});
}

function getSearchResultByPage(page)
{
	var pageResult="";
	//get the current page data
	if(searchResult!=undefined)
	{
		for(var i=page*searchResultProp.itemsPerPage;i<(page+1)*searchResultProp.itemsPerPage;i++)
		{
			val=searchResult[i];
			if(val!=undefined)
			{
				var nail="";
				nail+='<div class="nail" id="item'+val.boardId+'">';
				nail+='<div class="name">'+val.name+'</div>';
				nail+='<div class="check"><div id="add_board_'+val.boardId+'" class="add_to_cart"></div><input class="form_add_to_cart" name="form_add_to_cart_'+val.boardId+'" type="hidden" value="false"/></div>';
				nail+='<a href="javascript:void(0)" class="boardLink" data="'+val.boardId+'"><div class="pic" id="board_'+val.boardId+'"><img src="/100x100/'+val.thumbnailUrl+'" style="width:auto; height:100%"/></div></a>';
				nail+='<div class="nailfunctions"></div>';
				nail+='<div class="detail">&nbsp;$'+val.totalPrice+'</div>';
				nail+='</div>';
				pageResult+=nail;
			}
		}
	}
	return pageResult;
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
		pagin+='<a href="#search_page_0">1</a>&nbsp;';
	//show middle page if the totalPages > 2,(equals to 2 means only head and tail)
	if(searchResultProp.totalPages>2)
	{
		//show ... before current page
		if(searchResultProp.currentPage>=3)
			pagin+='...&nbsp;';
		//show adajacent page
		if(searchResultProp.currentPage>=2)
			pagin+='<a href="#search_page_'+(searchResultProp.currentPage-1)+'">'+(searchResultProp.currentPage)+'</a>&nbsp;';
		//current page
		if(searchResultProp.currentPage!=0 && searchResultProp.currentPage!=searchResultProp.totalPages-1)
			pagin+=(searchResultProp.currentPage+1)+'&nbsp;';
		//show adajacent page
		if(searchResultProp.totalPages-searchResultProp.currentPage>=3)
			pagin+='<a href="#search_page_'+(searchResultProp.currentPage+1)+'">'+(searchResultProp.currentPage+2)+'</a>&nbsp;';
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
			pagin+='<a href="#search_page_'+(searchResultProp.totalPages-1)+'">'+searchResultProp.totalPages+'</a>&nbsp;';
	}
	
	/*for(var i=0;i<totalPages;i++)
	{
		pagin+='<a href="#search_page_'+i+'">'+(i+1)+'</a>&nbsp;';
	}*/
	$("#searchResultPagin .pages").html('<span style="font-weight: bold;">Pages:</span>'+pagin);
}
function sortSearchResult(optionValue)
{
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
				else
					return 1;
			});
			////console.log(searchResult);
			break;
		case "2":
			logging("Sort by date DESC");
			searchResult.sort(function(a,b)
			{
				if(b.date>a.date)
					return 1;
				else
					return -1;
			});
			////console.log(searchResult);
			break;
		case "3":
			logging("Sort by Designer ASC");
			searchResult.sort(function(a,b)
			{
				if(b.designerName.toUpperCase()>a.designerName.toUpperCase())
					return -1;
				else
					return 1;
			});
			////console.log(searchResult);
			break;
		case "4":
			logging("Sort by Designer DESC");
			searchResult.sort(function(a,b)
			{
				if(b.designerName.toUpperCase()>a.designerName.toUpperCase())
					return 1;
				else
					return -1;
			});
			////console.log(searchResult);
			break;
		case "5":
			logging("Sort by Board Name ASC");
			searchResult.sort(function(a,b)
			{
				if(b.name.toUpperCase()>a.name.toUpperCase())
					return -1;
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
				else
					return -1;
			});
			break;
		default:
			logging("Sorting what?");
			break;
		}
		//show result after sorting from page 1
		//show page number
		searchResultPagin();
		//create new div to put the data
		$('#mask').append('<div class="nextdata">'+getSearchResultByPage(0)+'</div>');
		
		//show transition effect
		transit('#mask');
		//sync market
		syncMarket();
	}
}
//End of search result==================================================//

//portfolio related functions===========================================//
function createPortfolio()
{
	var errors= CheckCreatePortfolioInput();
	if(errors.length==0)
	{	
		//save the portfolio bu ajax call
		$.ajax(
		{
			url: createPortfolioPath,
			type: "POST",
			data: $('#form_create_portfolio').serialize(),
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
					buildPopupMsg({
						"content":"Added successfully<br />(This window will be closed automatically in 5 seconds)",
						"showOk":true,
						"title":"Result",
						"onShow":function () {
							var timeout = window.setTimeout(function(){
								closePopupMsg();
							}, 5000);
						}
					});
					$('#form_create_portfolio')[0].reset();
					//change the flag
					globalVars.isChangedWithoutSubmit=false;
					//load the manage portfolio tab to reload the data
					$("#tabs").tabs("load",getIdByName('tab_manage_portfolio'));
				}
			}
		});
	}
	else
	{
		buildPopupMsg({
			"content":"The fields need to be enter in the following fields which are already highlighted in correspond fields:<br/>"+errors.join("<br/>"),
			"showOk":true
		});
	}
}

function getPortfolioItems(page)
{
	if(page==undefined)
		page=0;
	$.ajax(
	{
		async: true,
		url: getPortfolioItemsPath,
		type: "GET",
		timeout: 3000,
		beforeSend: function(xhr)
		{
			logging("beforeSend: get portfolio items");
			//show loading message
			$('#portfolio_mask').html('<div class="data">'+layoutTemplate.loadingMsg+'</div>');
		},
		error: function()
		{
			logging("Get portfolio items error");
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
				portfolioResult.imageList=result.imagesList;
				//calculate the total pages
				portfolioProp.totalPages=Math.ceil(result.results.length/portfolioProp.itemsPerPage);
				logging("TOTAL Portfolio items=>"+result.results.length);
				if(result.results.length>0)
				{
					logging("Total Pages=>"+portfolioProp.totalPages);
					getPortfolioItemsByPage(page,false);
				}
				else
				{
					//show empty data
					$('#portfolio_mask').append('<div class="nextdata">'+layoutTemplate.emptyPortfolioMsg+'</div>');
					//show transition effect
					transit('#portfolio_mask');
				}
			}
		},
		complete: function()
		{
			logging("Get portfolio items complete");
		}
	});
}
function getPortfolioItemsByPage(page,forceToReload)
{
	logging("portfolio items per page=>"+portfolioProp.itemsPerPage);
	logging("SHOW portfolio item from "+(page*portfolioProp.itemsPerPage)+" to "+((page+1)*portfolioProp.itemsPerPage));
	var portfolioContent="";
	//if the result is empty call the getPortfolioItems again to get the items.
	//console.log(portfolioResult.data);
	//console.log(portfolioResult.imageList);
	if(portfolioResult.data!=null && portfolioResult.imageList!=null && (forceToReload==false || forceToReload==undefined))
	{
		if(portfolioResult.data.length > 0)
		{
			if(portfolioProp.totalPages <= page)
			{
				portfolioContent=layoutTemplate.emptyPage;
			}
			else
			{
				page=parseInt(page);
				for(var i=page*portfolioProp.itemsPerPage;i<(page+1)*portfolioProp.itemsPerPage;i++)
				{
					var item=portfolioResult.data[i];
					var itemImage=portfolioResult.imageList[i];
					var nail="";
					if(item!=undefined)
					{
						nail+='<div class="item">';
			        	nail+='<a href="javascript:void(0);" id="portfolio_'+item.portfolioId+'" data="'+item.portfolioId+'"">';
			        	nail+='<div class="portfolio">';
			        	nail+='<table>';
			        	nail+='<tr>';	        
			            if(itemImage[0]!=undefined)
			            	nail+='<td><img src=/100x100/'+itemImage[0]+'></td>';
			            else
			            	nail+='<td class="emptyCell"></td>';
			            if(itemImage[1]!=undefined)
			            	nail+='<td><img src=/100x100/'+itemImage[1]+'></td>';
			            else
			            	nail+='<td class="emptyCell"></td>';
			            nail+='</tr>';
			            nail+='<tr>';
			            if(itemImage[2]!=undefined)
			            	nail+='<td><img src=/100x100/'+itemImage[2]+'></td>';
			            else
			            	nail+='<td class="emptyCell"></td>';
			            if(itemImage[3]!=undefined)
			            	nail+='<td><img src=/100x100/'+itemImage[3]+'></td>';
			            else
			            	nail+='<td class="emptyCell"></td>';
			            nail+='<tr>';
			            nail+='</table>';
			            nail+='</div>';
			            nail+='</a>';
			            nail+='<div class="detail">';
			            nail+='<div class="name">'+item.name+'</div>';
			            nail+='<div class="checkbox delete_portfolio" data="'+item.portfolioId+'"><img src="/images/recycle_bin.png" /></div>';
			            //nail+='<div class="checkbox"><input name="selectedItems" type="checkbox" value="'+item.portfolioId+'" id="form_portfolio_'+item.portfolioId+'"/></div>';
			            nail+='</div>';
			            nail+='</div>';
					}
					portfolioContent+=nail;
				}
			}
		}
		else
		{
			portfolioContent=layoutTemplate.emptyPortfolioMsg;
		}
		//show pagin
		portfolioPagin();
		//create new div to put the data
		$('#portfolio_mask').append('<div class="nextdata">'+portfolioContent+'</div>');
		//show transition effect
		transit('#portfolio_mask');
		
	}
	else
	{
		logging("Reload the portfolio items=>"+page);
		getPortfolioItems(page);
	}
}
function portfolioPagin()
{
	logging("Refresh portfolio pagin","#0F0");
	logging("cpage=>"+portfolioProp.currentPage);
	var pagin="";
	portfolioProp.currentPage=parseInt(portfolioProp.currentPage);
	//show head pagin
	if(portfolioProp.currentPage==0)
		pagin+='1&nbsp;';
	else
		pagin+='<a href="#portfolio_page_0_0">1</a>&nbsp;';
	//show middle page if the totalPages > 2,(equals to 2 means only head and tail)
	if(portfolioProp.totalPages>2)
	{
		//show ... before current page
		if(portfolioProp.currentPage>=3)
			pagin+='...&nbsp;';
		//show adajacent page
		if(portfolioProp.currentPage>=2)
			pagin+='<a href="#portfolio_page_'+(portfolioProp.currentPage-1)+'_0">'+(portfolioProp.currentPage)+'</a>&nbsp;';
		//current page
		if(portfolioProp.currentPage!=0 && portfolioProp.currentPage!=portfolioProp.totalPages-1)
			pagin+=(portfolioProp.currentPage+1)+'&nbsp;';
		//show adajacent page
		if(portfolioProp.totalPages-portfolioProp.currentPage>=3)
			pagin+='<a href="#portfolio_page_'+(portfolioProp.currentPage+1)+'_0">'+(portfolioProp.currentPage+2)+'</a>&nbsp;';
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
			pagin+='<a href="#portfolio_page_'+(portfolioProp.totalPages-1)+'_0">'+portfolioProp.totalPages+'</a>&nbsp;';
	}
	$("#manage_portfolio_pagin").html("Pages:&nbsp;"+pagin);
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
						$("#tabs").tabs("load",getIdByName("tab_manage_portfolio"));
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
		keepAliveURL: keepSessionAlivePath,
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
			//first param: the popup you want to close, second param: the overlayId you want to hide
			closePopup("#session_expire","#session_overlay");
		},
		onAbort: function()
		{
			logging("idle timer send request abort","#F00");
			window.location=loginPath; //redirect to the login page
		},
		onRedirect: function()
		{
			logging("idle timer redirect to login","#F00");
			window.location=loginPath; //redirect to the login page
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
function transit(target) //show the transition effect on content
{
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
function openSidebar()
{
	if(!globalVars.isSidebarOpened)
	{
		$("#sidebar").animate({width:350},"normal",function()
		{
			//rotate the arrow
			//$("#sidebarToggle").find("img").attr("class","rightArrow");
			$("#sidebarToggle .arrow img").attr("src","/images/arrow_right.png");
			//load sidebar content
			$.ajax(
			{
				url: sidebarPath,
				beforeSend: function()
				{
					logging("send sidebar content req");
				},
				success: function(result)
				{
					logging("load sidebar content success");
					$("#sidebarContent").html(result);
					$("#sidebarContent").fadeIn("fast",function()
					{	
						globalVars.isSidebarOpened=true;
						//init scroll bar
						logging("init scroll bar","#F00");
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
					});
				}
			});
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

//update viewer
function showWindow(id,showEffect)
{
	if(showEffect==undefined)
		showEffect=true;
	//close sidebar
	closeSidebar();
	buildPopup({
		"url":boardDetailPath+"/"+id,
		"showPopup":showEffect
	},function () {
		$(".popup .entity").tinyscrollbar();
		$(".input textarea").autosize();
	});
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
	
	if(typeof(object)==="object")
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

//Send Message and message detail=================================================================//
function sendMessage()
{
	//if the body is empty, do not send the message
	var tempMassage=$("#form_comment_messageBody").val();
	tempMassage=tempMassage.replace(" ","");
	logging("MSG=>"+tempMassage.replace(" ",""));
	if(tempMassage != "")
	{
		logging("MESSAGE DATA=>"+$("#form_comment").serialize());
		//convert to html format and assgin to messageBody
		$('#commentBody').val(toHtmlFormat($("#form_comment_messageBody").val()));
		$.ajax(
		{	
			url: sendMessagePath,
			type: "POST",
			data: $("#form_comment").serialize(),
			success: function(result)
			{
				////console.log(result);
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
				}
			}
		});
	}
	else
		logging("empty message");
}
function sendMessageInMessageDetail()
{
	//if the body is empty, do not send the message
	var tempMassage=$("#messageContent").val();
	tempMassage=tempMassage.replace(" ","");
	logging("MSG=>"+tempMassage.replace(" ",""));
	if(tempMassage != "")
	{
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
				////console.log(result);
				if(result.hasError)
				{
					//$("#send_status").html("Error, please resend again");
					buildPopupMsg({
						"content":"Error, please resend again",
						"showOk":true,
						"title":"Error"
					});
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
	//set the offset of footer
	x=$("#tabs").offset();
	var footerOffset=x.top+$("#tabs").height();
	logging("size of tabs=>"+x.top+" : tabs=>"+$("#tabs").height());
	$("#footer").animate({"top":footerOffset},"fast");
	//detect the browser viewport height to determine the minimize the logo or not
	/*if($(window).height() <= 800)
	{
		//decrease the height of the title
		$("#title .titleContent .logo img").animate({height:'50px',width:'auto'});
		$("#title .titleContent").animate({height:'60px'});
		$("#title .titleContent").animate({width:'990px'});
		$("#title .titleHolder").animate({height:'60px'});
		$("#title").animate({height:'60px'});
	}
	if($(window).height() >800)
	{
		//decrease the height of the title
		$("#title .titleContent .logo img").animate({height:'86px',width:'auto'});
		$("#title .titleContent").animate({height:'120px'});
		$("#title .titleContent").animate({width:'990px'});
		$("#title .titleHolder").animate({height:'120px'});
		$("#title").animate({height:'129px'});
	}*/
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
	if(errors.length==0)
	{	
		logging("save designer");
		logging("FORM DATA=>"+$("#form_edit_profile").serialize());
		var action=$("#form_edit_profile").attr("action");
		$.ajax(
		{
			url: action,
			type: "POST",
			data: $("#form_edit_profile").serialize(),
			success: function(result)
			{
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
						"content":"Update Successfully<br />(This popup will be close automatically in 5 seconds)",
						"showOk":true,
						"title":"Update Profile",
						"onShow":function() {
								timeout=setTimeout(function () {
								closePopupMsg();
								location.assign(homepage+"#home");
							},5000);
						},
						"onClose":function() {
							location.assign(homepage+"#home");
							clearTimeout(timeout);
						},
						"onOk":function() {
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
			"content":"The fields need to be enter in the following fields which are already highlighted in correspond fields:<br/>"+errors.join("<br/>"),
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
		errors = CheckforNull("#address1",errors,"#label_address_1","Please enter Street Address 1");
		errors = CheckforNull("#city",errors,"#label_city","Please enter City");
		errors = CheckforNull("#form_state",errors,"#label_state","Please enter State");
		errors = CheckforNullandNumber("#zip",errors,"#label_zipcode","Please enter Zip Code")
		errors = CheckforNull("#form_country",errors,"#label_country","Please enter Country");
		errors = CheckforNullandPhoneNumber("#cellPhone",errors,"#label_cell_phone","Cell Phone Number");
		errors = CheckforNullandPhoneNumber("#phone_no",errors,"#label_phone","Work Phone Number");
		
		errors = CheckforNullinSelect("#form_languages",errors,"#label_Languages","Please select at least 1 language");
		errors = CheckforNullinSelect("#form_skills",errors,"#label_skills","Please select at least 1 skill");

		errors = CheckforNull("#website",errors,"#label_website","Please enter Website");
		errors = CheckforNull("#companyName",errors,"#label_companyname","Please enter Company Name");
	
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
			success: function(result)
			{
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
			"content":"The fields need to be enter in the following fields which are already highlighted in correspond fields:<br/>"+errors.join("<br/>"),
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
		errors = CheckforNull("#address_1",errors,"#label_address_1","Please enter Street Address 1");
		errors = CheckforNull("#city",errors,"#label_city","Please enter City");
		errors = CheckforNullandNumber("#zipcode",errors,"#label_zipcode","Please enter Zip Code")
		errors = CheckforNull("#form_state",errors,"#label_state","Please enter State");
		errors = CheckforNull("#form_country",errors,"#label_country","Please enter Country");
		
		errors = CheckforNullandPhoneNumber("#cell_phone",errors,"#label_cell_phone","Cell Phone Number");
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
			url : updateReferralPath+"/0/"+tableId, //Path params: /{requireResend}/{tableId}
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
			"content":"The fields need to be enter in the following fields which are already highlighted in correspond fields:<br/>"+errors.join("<br/>"),
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
			"content":"The fields need to be enter in the following fields which are already highlighted in correspond fields:<br/>"+errors.join("<br/>"),
			"showOk":true
		});
	}
}

function createBoardInputChecking()
{
	var errors = new Array();
	//get the number of all sale type column
	var table=$("#saleTypeTable tbody").children("tr");
	var saleTypeCount=table.length-1;
	
	//reset the highlight area
	$("#create_board .detail span").removeAttr("style");
	$("#label_upload_image").html("");
	
	errors = CheckforNull("#form_board_name",errors,"#label_board_name","Please enter Board Name");
	errors = CheckforNull("#form_board_description",errors,"#label_description","Please enter Board Description");
	errors = CheckforNull("#portfolioId",errors,"#label_portfolio","Please Select a portfolio or create a new portfolio");
	errors = CheckforNull("#product",errors,"#label_product","Please enter Product");
	errors = CheckforNull("#productType",errors,"#label_product_type","Please enter Product Type");

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
		if($("#form_saletype_"+i+"_cost").val()!=undefined && $("#form_saletype_"+i+"_cost").val()!="")
			if ($("#form_saletype_"+i+"_cost").val()>0 && $("#form_saletype_"+i+"_cost").val()<10001)
				isChecked=true;
			
	}
	if(isChecked==false)
	{
		errors = HighlightLabelandPushError(errors,"#saleTypeTable input","Please enter a valid price. It should be between 0 and 10000");
		//highlight
		
	}
	errors = CheckforNullPushtoElement("#form_board_image_url",errors,"#label_upload_image","Please upload Board Image");
	
	return errors;
}

function deleteBoard(boardId)
{
	$.ajax(
	{
		url: deleteBoardPath+"/"+boardId,
		type: "GET",
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
				$("body").trigger("refresh_board",[portfolioProp.portfolioId]);
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

function editBoard(boardId)
{
	//check the board status is not being processed
	$.ajax({
		url:isBoardLockedPath+"?boardId="+boardId,
		type:"GET",
		success: function (result) {
			if(result.hasLocked==true)
			{
				buildPopupMsg({
					"content":"This board is being purchased, you cannot be edited.",
					"showOk":true,
					"onOk":function(){
						closePopupMsg();
					}
				});
			}
			else
				triggerHash("#edit_board_"+boardId);
		}
	});
}

function deletePortfolio(portfolioId)
{
	$.ajax(
	{
		url: deletePortfolioPath+"/"+portfolioId,
		type: "GET",
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
				triggerHash("#portfolio_page_"+portfolioProp.currentPage+"_1");
			}
		}
	});
}

function checkSession()
{
	//logging("check session=>"+keepSessionAlivePath+"?loginSSId="+sessionStorage.LI);
	logging("check session");
	$.ajax(
	{
		//url:keepSessionAlivePath+"?loginSSId="+sessionStorage.LI,
		url:keepSessionAlivePath,
		success: function(result)
		{
			if(result=="OK")
			{
				logging("session still there","#F00");
			}
			else if($('#sessionTimeout',$(result)).val()=="true")
			{
				logging("session time out","#F00");
				window.location=loginPath; //redirect to the login page
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

function selectTabHeader(tabTitle,cssClass)
{
	var portfolioId=getIdByName(tabTitle);
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