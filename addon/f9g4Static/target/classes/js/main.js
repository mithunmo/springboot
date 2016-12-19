// JavaScript Document
//Initialization
var debugMode=false; //set to true to enable debug panel
var disableRightClick=false;
var isWindowFocus=false;
var enableSorting=true;
var isViewerOpened=false; //flag to determine the viewer is open or not
var currentIndex; //current index
var hasResult=false; //flag to determine that there is search result or not
var hasClicked=0;
var isEmpty=true;
var ratyImgPath="/images/raty_img";
var prePortfolioName=""; //the name of portfolio
var totalPurchasedItems=0;
var shoppingCartImgPath="/images/shoppingcart.png";
var shoppingCartFullImgPath="/images/shoppingcart_full.png";
/*Idle timer parameters*/
var idleTime=1500;
var pollingTime=300; //5 mins 
var warningTime=300;
var idleTimeoutDebugMode=false;
/*Message List*/
var optionDefaultMsg='<option value="-1">-Please select one option-</option>';
var optionLoadingMsg='<option value="-1">Loading...</option>';
var ver=1.5;

//shopping cart
var cart;

//search result related settings
var searchResult;
var currentPage=0;
var totalPages=0;
var itemsPerPage=15;

//portfolio result 
var portfolioResult;
var portfolioImageList;
var currentPage_portfolio=0;
var totalPages_portfolio=0;
var itemsPerPage_portfolio=8;
var preloadPortfolioId=-1; //the id to determine when you show the manage boards tab. If the value=-1,means no preload.

//boards result related settings
var boardsResult;
var portfolioId;
var boardId;
var currentPage_board=0;
var totalPages_board=0;
var itemsPerPage_board=8;

//empty message html layout
var emptyPortfolioMsg='<div class="empty" style="width:320px;"><span><a href="javascript:void(0)" id="add_manage_portfolio" style="color:#C30">Click here</a>&nbsp;to create your first portfolio!</span></div>';
var emptyBoardMsg='<div class="empty"><span><a href="javascript:void(0)" id="add_manage_board" style="color:#C30">Click here</a>&nbsp;to create your first board!</span></div>';
var emptySearchResultMsg='<div class="empty" id="emptySearch"><span>Your search did not return any results.<br/>Please go back and redefine search criteria.</span>'
						+'<div class="button" id="empty_search_ok">Ok</div>'
						+'</div>';
var loadingMsg='<div class="loadingSpinner"><span><img src="/images/spinner.gif" /></span></div>';
var basicConsoleFrame='<div class="left">'
	+'<div class="searchTitle"></div>'
	+'</div>'
	+'<div class="right">'
	+'<div class="rightCurve"></div>'
	+'</div>'
	+'<div class="contentFrame" >'
	+'<div class="content" id="messages">'
	+ loadingMsg
	+'</div>'
	+'</div>';
var errorStyle="color:#FF0000";

//flag to determine the user change the data without submit
var isChangedWithoutSubmit=false;
$(document).ready(function()
{
	var winHeight=$(window).height();
	logging("main running.."+ver);
	//initialize the idel timeout plugin for session
	initIdleTimeoutPlugin();
	//init live query to init cloud zoom (live query help other plug-ins to bind on future element.  
	$('.cloud-zoom').livequery(function() 
	{
		$(this).CloudZoom();	
	});
	//disable mouse right click==================================================
	if(disableRightClick)
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
		if(!isWindowFocus) //check now the window is focus or not
		{
			logging("focus","#F00");
			//console.log("focus");
			checkSession();
		}
		isWindowFocus=true;
	});
	$(window).bind("blur",function()
	{
		isWindowFocus=false;
	});
	$(window).bind("beforeunload",function(e)
	{
		//unfocus current input
		$("input").blur();
		$("textarea").blur();
		//console.log($("#tabs").tabs('option', 'selected'));
		var selectedTabTitle = $($("#tabs li")[$("#tabs").tabs('option', 'selected')]).text();
		//console.log(selectedTabTitle);
		if(isChangedWithoutSubmit || isChangedWithoutSubmitOnPopup)
			return "Do you want to leave the page without saving";
	});
	//bind input fields related to tabs to check user modify the data
	$("#form_create_board input").live("change",function()
	{
		isChangedWithoutSubmit=true;
	});
	$("#form_edit_profile input").live("change",function()
	{
		isChangedWithoutSubmit=true;
	});
	$("#form_create_portfolio input").live("change",function()
	{
		isChangedWithoutSubmit=true;
	});
	$("#messageContent").live("change",function()
	{
		isChangedWithoutSubmit=true;
	});
	$("#replyForm input").live("change",function()
	{
		isChangedWithoutSubmit=true;
	});
	//bind input fields related to popup to check user modify the data
	$(".popup input[type=text]").live("change",function()
	{
		isChangedWithoutSubmitOnPopup=true;
	});
	$(".popup textarea").live("change",function()
	{
		isChangedWithoutSubmitOnPopup=true;
	});
	//===========================================================================
	
	//initialize the tabs========================================================
	$("#tabs").tabs(
	{
		spinner: "Loading..",
		fx: {opacity: 'toggle',duration: "fast"},
		select:function(e,ui)
		{
			if(isChangedWithoutSubmit)
			{
				e.preventDefault();
				//show confirmation window
				showConfirmation("You leave the page with unsaved data, Continue?","Confirmation","changedWithoutSave");
				$("body").bind("changedWithoutSave",function(changeEvent)
				{	
					if(changeEvent.trigger=="ok")
					{
						//set the flag false;
						isChangedWithoutSubmit=false;
						//trigger the event
						$("#tabs").tabs("select",ui.index);
					}
					$("body").off("changedWithoutSave");
				});
			}
			else
			{
			checkSession();
			var tab=ui.tab.toString();
			hasClicked++;
			if(hasClicked>=1)
				closeSidebar();
			//get the tab name
			var tabName=tab.substr(tab.search("#")+1,tab.length).replace("tab_","");
			logging("SELECT tabName="+tabName);
			if(tabName=='home')
			{
				location.hash="#home";
				$("#tabs").tabs("load",getIdByName("tab_home"));
			}
			else if (tabName=='home_edit_mode')
			{
				$("#tab_home_edit_mode").html(basicConsoleFrame); //show loading message
			}
			else if (tabName=='designer_home_edit_mode')
			{
				$("#tab_designer_home_edit_mode").html(basicConsoleFrame); //show loading message
			}
			else if(tabName=='search_criteria')
			{
				location.hash="#search_criteria";
				//load search criteria page if the tab content is empty
				if($("#tab_search_criteria").html()=="")
				{
					logging("LOAD SEARCH CRITERIA"+getIdByName("tab_search_criteria"),"#F00");
					$("#tabs").tabs("url",getIdByName("tab_search_criteria"),searchCriteriaPath);
				}
				else
				{
					//enable the cache for search criteria after the first time loading
					logging("enable cache","#F00");
				    var currentTabAnchor = $("#tabs").data('tabs').anchors[1];
				    $(currentTabAnchor).data('cache.tabs', true);
				}
			}
			else if(tabName=='activity_company' || tabName=='activity_designer')
			{
				$("#tab_"+tabName).html(basicConsoleFrame); //show loading message
				location.hash="#activity";
			}
			else if(tabName=='design_wall')
			{
				location.hash="#design_wall_0_1_1";
				$("#tab_design_wall").html(basicConsoleFrame); //show loading message	
			}
			else if(tabName=='alerts')
			{
				$("#tab_alerts").html(basicConsoleFrame); //show loading message
				location.hash='#alerts';
				$("#tabs").tabs("load",getIdByName("tab_alerts"));
			}
			else if(tabName=='messages')
			{
				logging("show message loading..","#F00");
				//location.hash='#messages_page_1';
				$("#tab_messages").html(basicConsoleFrame); //show loading message
			}
			/*else if(tabName=='manage_portfolio')
				location.hash='#portfolio_page_0';*/
			else if(tabName=='search_result')
			{
				syncMarket(); //synchronize the item status with shopping cart and search result.
			}
			else if(tabName=='manage_portfolio')
			{
				//show loading message
				$('#portfolio_mask').html('<div class="data">'+loadingMsg+'</div>');
			}
			else if(tabName=='create_board')
			{
				$("#tab_create_board").html(basicConsoleFrame); //show loading message
			}
			else if(tabName=='account')
			{
				location.hash="#designer_account_0_1_1";
				$("#tab_account").html(basicConsoleFrame); //show loading message	
			}
			}
		},
		load: function(e,ui)
		{
			//logging("TAB NAME="+ui.tab);
			var tab=ui.tab.toString();
			//get the tab name
			var tabName=tab.substr(tab.search("#")+1,tab.length).replace("tab_","");
			logging("LOAD tabName="+tabName);
			if(tabName=="search_criteria") //search criteria tab
			{
				//Initialize tree view------------------------------------------------------
				//load tree view data using JSON, it will load season.js
				initSeasonsList("checkbox");
			}
			else if(tabName=="search_result") //show search result
			{
				logging("show search result");
			}
			else if(tabName=="design_wall") //design wall
			{
				
			}
			else if(tabName=="messages")
			{
				//init autosize plugin
				//$("textarea").autosize();
				$("#messages_scrollbar").tinyscrollbar();
			}
			else if(tabName=="activity_designer" || tabName=="activity_company") //activity tab
			{
				logging("activity designer tab");
				//initializa raty
				init_raty_activity();
				//initialize chart graph=====================================
				initChart(chartPath+"/30");
				//disable the Chart link
				disableChartLink("#chart_month");
			}
			else if(tabName=="rating_designer" || tabName=="rating_company" || tabName=="rating") //for rating designer
			{
				logging("init raty");
				//get all rating items into an array
				var target=$(".readonly").toArray();
				//initialize rating plugin==============================
				//for company page
				$(".rating").raty(
				{
					path: ratyImgPath,
					cancel: true,
					space: true,
					width: "150px",
					click: function(score,e)
					{
						var target=$(this).attr('id');
						$("#"+target+"_value").html(score);
						$("[name="+target+"]").val(score); //set the value to the hidden area
					},
				});
				//for designer page----------------------------------------
				//overall rating
				$(".readonly").raty(
				{
					path: ratyImgPath,
					cancel: true,
					space: true,
					width: "155px",
					readOnly: true,
				});
				//partial rating
				$(".partial_rating").raty(
				{
					path: ratyImgPath,
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
							path: ratyImgPath,
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
			else if(tabName=="manage_portfolio") //portfolio
			{
				logging("portfolio");
				getPortfolioItems();
			}
			else if(tabName=="manage_board")
			{
				if(preloadPortfolioId!=-1)
				{
					//get boards data(ajax call)
					getBoardsByPortfolioId(preloadPortfolioId);
					//preloadPortfolioId=-1;
				}
			}
			else if(tabName=="create_board")
			{
				logging("load create board tab");
				//initialize the option of "JPG+AI" to input field
				//$("#saletype_2").html('<input name="saletype_2_cost" type="text" id="form_saletype_2_cost" class="cost"/>');
			}
			else if(tabName=="create_portfolio")
			{
				//logging("load create portfolio tab");
				//Initialize tree view------------------------------------------------------
				//load tree view data using JSON, it will load season.js
				logging("season Path=>"+seasonYearListPath);
				$("#season").html("Loading Data, Please wait...");
				$.ajax(
				{
					url: seasonYearListPath+"/radio",
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
							dragAndDrop: false,
						});
					}
				});
				//TODO call getCatagorylist
				getCategoryList($("#form_division").val());
				//set the portfolio name of prePortfolioName
				$("#form_name_of_portfolio").val(prePortfolioName);
				//clear the prePortfolioName
				prePortfolioName="";
			}
			//resize();
		//End of load event handler======================================================
		},
		show: function(e,ui)
		{
			//logging("show tab=>"+ui.index);
			//show tab name=========================================================
			var tab=ui.tab.toString();
			logging("load tab "+ui.tab+" complete");
			//get the tab name
			var tabName=tab.substr(tab.search("#")+1,tab.length).replace("tab_","");
			logging("SHOW tabName="+tabName);
			resize();
			if(tabName=="activity_designer" || tabName=="activity_company") //set raty value in activity page
			{
				logging("set raty value");
				//initialize raty plugin====================================
				init_raty_activity();
			}
			else if(tabName=="manage_portfolio") //portfolio
			{
				//logging("Complete Get Portfolio Items...");
				logging('<span style="color:#FF0000">content=>'+$("#portfolio_mask .data").html()+'</span>');
				/*if(!$("#portfolio_mask .data").html() || $("#portfolio_mask .data").html().length==0)
				{	
					logging('<span style="color:#FF0000">empty data</span>');
				}*/
				//getPortfolioItems();
			}
			else if(tabName=="manage_board")
			{
				logging("Show Manage Boards=>"+portfolioId);
			}
			else if(tabName=="create_board")
			{
				logging("SHOW CREATE BOARD");
				$("#portfolioId").trigger("change"); //trigger the change event to get the level
			}
			else if(tabName=='search_result')
			{
				logging("sync shopping cart and market.");
				syncMarket(); //synchronize the item status with shopping cart and search result.
			}
			else if(tabName=="messages")
			{
				//init autosize plugin
				//$("textarea").autosize();
				$("#messages_scrollbar").tinyscrollbar();
			}
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
	$("#submit_search_criteria").live("click",function()
	{
		getSearchResult();
	});
	$("#link_save_search_criteria").live("click",function(e)
	{
		//close sidebar
		closeSidebar();
		loadPopup(saveSearchCriteriaPath);
	});
	$("#form_open_saved_searches").live("change",function(e)
	{
		if(this.value!="") //if the value in this form is not equal to null, load the search options
		{
			logging("select searches=>"+this.value);
		}
	});
	//division change event
	$("#form_division_search_criteria").live("change",function(e)
	{
		//reset the drop down menu
		$("#form_product").html("<option value=-1>-Please select Category above-</option>");
		$("#form_product_type").html("<option value=-1>-Please select Product above-</option>");
		getCategoryList(e.target.value);
	});
	//category change event
	$("#form_category").live("change",function(e)
	{
		//logging("category change");
		getProductList(e.target.value);
	});
	//product change event
	$("#form_product").live("change",function(e)
	{
		//logging("product change");
		getProductTypeList(e.target.value);
	});
	//clear button
	$("#clear_search_criteria").live("click",function()
	{
		//reset the form
		$("#form_search_criteria")[0].reset();
		//reload the seasons list
		initSeasonsList("checkbox");
	});
	//End of search criteria
	
	//Search Result click and button event==============================================
	$("#back_search_criteria").live("click",function()
	{
		//remove search result tabs
		logging("back");
		$("#tabs").tabs("enable","tab_search_criteria"); //enable search criteria tab		
		$("#tabs").tabs("select","tab_search_criteria"); //select search result tab
		$("#tabs").tabs("disable","tab_search_result"); //disable search tab
	});
	$(".add_to_cart").live("click",function(e)
	{
		moveToCart(e.currentTarget.id); //show the animation from board to shopping cart
	});
	$("#add_to_cart").live("click",function(e)
	{
		//close sidebar
		closeSidebar();
		loadPopup(addToCartPath);
	});
	$("#empty_search_ok").live("click",function(e)
	{
		//select search criteria tab
		logging("back");
		$("#tabs").tabs("enable","tab_search_criteria"); //enable search criteria tab		
		$("#tabs").tabs("select","tab_search_criteria"); //select search result tab
		$("#tabs").tabs("disable","tab_search_result"); //disable search tab
	});
	//nail event---------------------------------------------------------
	$(".boardLink").live("click",function(e)
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
	$(".nail a").live("mouseenter",function(e)
	{
		//logging("mouseenter->"+e.currentTarget); //for debugging
		$(e.currentTarget.parentNode).animate(
		{
			"background-color":"#DDD"
		},"fast"); //set the target item css
	});
	//mouseenter event to hide the focus effect
	$(".nail a").live("mouseleave",function(e)
	{
		//logging("mouseout->"+e.currentTarget); //for debugging
		$(e.currentTarget.parentNode).animate(
		{
			"background-color":"white"
		},"fast"); //set the target item css
	});
	//prev button event handler
	$(".touchbar").live("mouseenter",function(e)
	{
		//logging("touch "+e.currentTarget.id);
		$(this).addClass("appear");
		$(this).removeClass("disappear");
		$(this).animate(
		{
			"opacity":0.4
		},"fast");
	});
	$(".touchbar").live("mouseleave",function(e)
	{
		//logging("touch "+e.currentTarget.id);
		$(this).addClass("disappear");
		$(this).removeClass("appear");
		$(this).animate(
		{
			"opacity":0
		},"fast");
	});
	$("#search_carouselNext").live("click",function(e)
	{
		logging('next');
		
		logging("Current page=>"+currentPage,"#00F");
		currentPage++;
		if(currentPage>=totalPages)
			currentPage=0;
		//change the hash
		location.hash="#search_page_"+(currentPage);
	});
	$("#search_carouselPrev").live("click",function(e)
	{
		logging('prev');
		
		logging("Current page=>"+currentPage,"#00F");
		currentPage--;
		if(currentPage<0)
			currentPage=totalPages-1;
		//change the hash
		location.hash="#search_page_"+(currentPage);
	});
	//sorting
	$("#sortSearchResult").live("change",function(e)
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
		//update the sidebar scroll bar size.
		$("#sidebar_scrollbar").tinyscrollbar_update();
	});
	//sidebar=======================================================================
	//click function
 	$("#sidebarToggle").click(function()
	{
		if(isOpened==false)
		{
			openSidebar();
		}
		else
		{
			closeSidebar();
		}
		//logging("sideBar click=>"+isOpened);
	});
	//mouseenter event to show effect
	$("#sidebarToggle").mouseenter(function(e)
	{
		$("#sidebarToggle").animate(
		{
			"background-color":"#DDD"
		});
	});
	//mouseleave event to hide effect
	$("#sidebarToggle").mouseleave(function(e)
	{
		$("#sidebarToggle").animate(
		{
			"background-color":"#bdcbd4"
		});
	});
	$("#sidebar_alerts").live("click",function(e)
	{
		logging("alerts");
		$("#tabs").tabs("select","tab_alerts");
	});
	$("#sidebar_messages").live("click",function(e)
	{
		logging("messages");
		//$("#tab_messages").html(basicConsoleFrame); //show loading message
		//change hash
		location.hash="#messages_page_1";
	});
	$(".drawer_boardId").live("click",function(e)
	{
		logging("board id=>"+$(this).attr("data"));
		//show boardDetail popup
		showWindow($(this).attr("data"));
	});
	//Viewer event===================================================================
	//Pic viewer control
	$("#prevItem").live("click",function()
	{
		logging($("#prevItem").attr("href"));
		location.hash=$("#prevItem").attr("href"); //reset the hash
	});
	
	$("#nextItem").live("click",function()
	{
		logging($("#nextItem").attr("href"));
		location.hash=$("#nextItem").attr("href"); //reset the hash
	});
	
	//=====REFERRAL BUTTON EVENT===============================================
	$("#referralButton").click(function()
	{
		logging("referral button click");
		//close sidebar
		closeSidebar();
		loadPopup(referralPath);
	});
	
	
	//Home and Edit mode for both=======================================================================
	$("#update_membership").live("click",function() //update membership event
	{
		logging("update membership");
		logging("loading popup "+ updateMembershipPath);
		//show popup
		//loadPopup(updateMembershipPath);
	});
	$("#update_new").live("click",function(e) //update new picture event
	{
		logging("update new image");
		//close sidebar
		//closeSidebar();
		loadUploadPopup(uploadPicturesPath,"LOGO","ai","previewImage");
	});
	$("#manage_referrals").live("click",function(e)
	{
		logging("manage referrals");
		//close sidebar
		closeSidebar();
		loadPopup(manageReferralsPath);
	});
	//event handler when upload finish
	$("body").live("upload_finished",function(e)
	{
		logging("USER LOGO UPLOAD FINISHED=>"+e.filename_400);
		//set the flag
		isChangedWithoutSubmit=true;
		//save the filename in hidden area
		$("#form_logo_image_url").val("/400x400/"+e.filename_400);
		$("#previewImage").html('<i></i><img src="/400x400/'+e.filename_400+'" />');
	});
	//Edit mode----------------------------------------------------------
	//format the website url. If the user didn't put the http:// in front of the address, add it automatically.
	$("#website").live("change",function() 
	{
		 if (!/^http:\/\//.test(this.value)) 
		 {	 
	            this.value = "http://" + this.value;
		 }
	});
	//Home for company----------------------------------------------------
	//Event Handler
	$("#edit_profile_company").live("click",function(e)
	{
		logging("show edit mode");
		$("#tabs").tabs("select","tab_home_edit_mode");
	});
	$("#save_company").live("click",function(e)
	{
		doSaveCompany();
	});
	$("#cancel_company").live("click",function(e)
	{
		logging("cancel company");
		$("#tabs").tabs("select","tab_home");
	});
	
	//Home for designer----------------------------------------------------
	//event handler
	$("#edit_profile_designer").live("click",function(e)
	{
		$("#tabs").tabs("select","tab_designer_home_edit_mode");
	});
	$("#save_designer").live("click",function(e)
	{
		doSaveDesigner();
	});
	$("#cancel_designer").live("click",function(e)
	{
		logging("cancel designer");
		$("#tabs").tabs("select","tab_home");
	});
	//End of home========================================================================
	
	//DESIGN WALL========================================================================
	$("#select_sort_design_wall").live("change",function(e)
	{
		logging("SORT=>"+e.currentTarget.value);
		//get the value of sorting and direction
		var sort_column=e.currentTarget.value;
		var sort_direction=1;
		location.hash="#design_wall_0_"+sort_column+"_"+sort_direction;
	});
	$(".userinfo").live("click",function(e)
	{
		logging("click user id=>"+encodeURIComponent($(this).attr("data")));
		//close sidebar
		closeSidebar();
		//show user info popup
		loadPopup(userInfoPath+"?profileUserName="+encodeURIComponent($(this).attr("data"))+"&profileUserId=");
	});
	$(".designWallBoardId").live("click",function(e)
	{
		logging("click board id=>"+$(this).attr("data"),"#FF0");
		//show boardDetail popup
		showWindow($(this).attr("data"));
	});
	//End of design wall=================================================================
	
	//DESIGNER ACCOUNT========================================================================
	$("#select_sort_account").live("change",function(e)
	{
		logging("SORT=>"+$(this).val());
		//get the value of sorting and direction
		var sort_column=$(this).val();
		var sort_direction=1;
		location.hash="#designer_account_0_"+sort_column+"_"+sort_direction;
	});
	$(".designerAccountBoardId").live("click",function(e)
	{
		logging("click board id=>"+$(this).attr("data"),"#FF0");
		//show boardDetail popup
		showWindow($(this).attr("data"));
	});
	$(".designerAccountUserId").live("click",function(e)
	{
		logging("click user id=>"+encodeURIComponent($(this).attr("data")));
		//close sidebar
		closeSidebar();
		//show user info popup
		loadPopup(userInfoPath+"?profileUserName="+"&profileUserId="+encodeURIComponent($(this).attr("data")));
	});
	//End of designer account=================================================================
	
	//Rating=============================================================================
	//rating for company----------------------------------------------
	$("#submit_rating_company").live("click",function(e)
	{
		logging("submit rating company");
	});
	$("#cancel_rating_company").live("click",function(e)
	{
		logging("cancel rating company");
		$("#tabs").tabs("select","tab_alerts"); //back to alerts tab
	});
	
	//rating for designer---------------------------------------------
	$("#submit_rating_designer").live("click",function(e)
	{
		logging("submit rating designer");
	});
	$("#cancel_rating_designer").live("click",function(e)
	{
		logging("cancel rating designer");
		$("#tabs").tabs("select","tab_alerts"); //back to alerts tab
	});	
	//End of rating===================================================================================================
	
	//Messages Tab=====================================================================================================
	var sorting_messages_all="ASC";
	var sorting_messages_newest="ASC";
	$("#messages_all").live("click",function(e)
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
	$("#messages_newest").live("click",function(e)
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
	$(".messageBoardId").live("click",function(e)
	{
		logging("board id=>"+$(this).attr("data"));
		showWindow($(this).attr("data"));
	});
	//form user name click event handler, when user click the from user name and logo, it will show the popup.
	$(".messages_fromUserId").live("click",function(e)
	{
		logging("from user id=>"+$(this).attr("data")+" ; path=>"+userInfoPath+"?profileUserName=&profileUserId="+$(this).attr("data"));
		//close sidebar
		closeSidebar();
		//show user info popup
		loadPopup(userInfoPath+"?profileUserName=&profileUserId="+$(this).attr("data"));
	});
	//End of messages tab===============================================================================================
	
	//Message Detail Tab==========================================================================
	$("#send_reply").live("click",function(event) //when user click the reply link, replace the reply link into reply function
	{
		sendMessageInMessageDetail();
	});
	$("#back_to_messages").live("click",function(e)
	{
		if(isChangedWithoutSubmit)
		{
			showConfirmation("You leave the page with unsaved data, Continue?","Confirmation","changedWithoutSave");
			$("body").bind("changedWithoutSave",function(changeEvent)
			{	
				if(changeEvent.trigger=="ok")
				{
					//set the flag false;
					isChangedWithoutSubmit=false;
					//change the hash
					//change hash
					location.hash="#messages_page_1";
					//show loading message
					$("#tab_messages").html(basicConsoleFrame);
				}
				$("body").off("changedWithoutSave");
			});
		}
		else
		{
			//change hash
			location.hash="#messages_page_1";
			//show loading message
			$("#tab_messages").html(basicConsoleFrame);
		}
	});
	$("#messages_select_all").live("click",function(e) //check all checkbox in messages tab
	{
		$(".form_message_check").attr("checked","checked");
	});
	$("#messages_select_none").live("click",function(e) //uncheck all checkbox in messages tab
	{
		$(".form_message_check").removeAttr("checked");
	});
	$(".messageDetailBoardId").live("click",function(e)
	{
		logging("board id=>"+$(this).attr("data"));
		showWindow($(this).attr("data"));
	});
	$(".messageDetailDesignerId").live("click",function(e)
	{
		logging("user id=>"+$(this).attr("data"));
		//close sidebar
		closeSidebar();
		//show user info popup
		loadPopup(userInfoPath+"?profileUserName=&profileUserId="+$(this).attr("data"));
	});
	$("#buttonShowMore").live("click",function(e)
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
	$("#messageContent").live("keyup",function(e)
	{
		var currentLength=$("#messageContent").val().length;
		$("#leftWords").html(1000-currentLength);
	});
	$(".readMore").live("click",function(e)
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
	$('.hideContext').live("click",function(e)
	{
		//show animation to fold the viewarea
		//$(this).prev().css("height",56);
		$(this).prev().animate({height:56},function()
		{
			//update the scroll bar
			$("#message_content_scrollbar").tinyscrollbar_update('relative');
		});
		//Change the hide to read more
		$(this).removeClass("hideContext");
		//add the class and change the html of the hyperlink.
		$(this).addClass("readMore").children('a').html("Read more...");
	});
	$('#expandAll').live("click",function(e)
	{
		console.log($("#buttonShowMore").length);
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
	$('#collapseAll').live("click",function(e)
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
	$("#upload_ai").live("click",function(e)
	{
		logging("upload ai");
		//check sale type
		var saleType="ai";
		if($("#form_saletype_1").attr("checked")=="checked")
			saleType="jpg";
		//close sidebar
		closeSidebar();
		//show upload popup
		loadUploadPopup(uploadPicturesPath,"BOARD",saleType,"create_board_review","upload_finished_board"); //url,mode,id for preview image,event name
	});
	//upload board image finish event handler 
	$("body").live("upload_finished_board",function(e)
	{
		logging("upload_finished_board=>"+e.filename);
		//set the flag
		isChangedWithoutSubmit=true;
		$("#form_board_image_url").val(e.filename);
		$("#form_board_image_type").val(e.filename_ext);
		$("#form_board_image_urL_file").val(e.filename_400);
		$("#form_board_image_urL_thumb").val(e.filename_100);
		$("#form_board_image_urL_main").val(e.filename_original);
	});
	$("#new_portfolio").live("click",function(e)
	{
		logging("new portfolio");
		//get the name from form
		logging("CREATE PORTFOLIO=>"+$("#form_new_portfolio").val());
		$("#tabs").tabs("select","tab_create_portfolio");
		//set the prePortfolioName to put into #form_name_of_portfolio
		prePortfolioName=$("#form_new_portfolio").val();
	});
	$('#saleTypeTable [type="radio"]').live("click",function(e)
	{
		//parse the id
		var temp=e.currentTarget.id.split("_");
		clearSaleTypeTable();
		//get the previous price
		var previousPrice=$("#"+temp[1]+"_"+temp[2]).html();
		//set target area to apply an input field
		$("#"+temp[1]+"_"+temp[2]).html('<input name="saletype_'+temp[2]+'_cost" type="text" id="form_saletype_'+temp[2]+'_cost" class="cost" value="'+previousPrice+'"/>');
		
		checkFileTypeAndSaleType();
	});
	$("#create_board_calculate").live("click",function(e)
	{
		calculate();
	});
	$("#create_board_clear").live("click",function(e)
	{
		clear();
	});
	$(".cost").live("change",function(e)
	{
		calculate();
	});
	$("#save_create_board").live("click",function(e)
	{
		//submit the form
		var errors= createBoardInputChecking(e);
		if(errors.length==0)
		{
			if(checkFileTypeAndSaleType())
			{
				//show confirm window
				showConfirmation('It will <span style="color:#F00">NOT</span> publish your board to MarketPlace. Continue?',"Confirmation","save_create_board");
				$("body").live("save_create_board",function(e)
				{
					/*console.log(e);*/
					logging("Confirmation result=>"+e.trigger);
					if(e.trigger=="ok")
					{
						logging("save create board");
						//change the value of publish to mp to 0
						$("#form_publish_to_mp").val("0");
						createBoard(false); //ajax call, the parameter is the boolean of publish to MP, true= publish to mp false=save
					}
					//remove the event listener
					$("body").die("save_create_board");
				});	
			}
/*			var r=confirm("It will NOT publish your board to MarketPlace. Continue?");
			if (r==true)
			{
				logging("save create board");
				//change the value of publish to mp to 0
				$("#form_publish_to_mp").val("0");
				createBoard(false); //ajax call, the parameter is the boolean of publish to MP, true= publish to mp false=save
			}*/
		}
		else
		{
			showErrorMsg("The fields need to be enter in the following fields which are already highlighted in correspond fields:<br/>"+errors.join("<br/>"),true);
		}
		
	});
	$("#publish_create_board").live("click",function(e)
	{
		var errors= createBoardInputChecking(e);
		if(errors.length==0)
		{
			if(checkFileTypeAndSaleType())
			{
				//show confirm window
				showConfirmation("It will publish your board to MarketPlace. Continue?","Confirmation","publish_create_board");
				$("body").live("publish_create_board",function(e)
				{
					/*console.log(e);*/
					logging("Confirmation result=>"+e.trigger);
					if(e.trigger=="ok")
					{
						logging("publish board");
						//change the value of publish to mp to 0
						$("#form_publish_to_mp").val("1");
						createBoard(true); //ajax call, the parameter is the boolean of publish to MP, true= publish to mp false=save
					}
					//remove the event listener
					$("body").die("publish_create_board");
				});
			}
			/*var r=confirm("It will publish your board to MarketPlace. Continue?");
			if(r==true)
			{
				logging("publish create board");
				//change the value of publish to mp to 1
				$("#form_publish_to_mp").val("1");
				createBoard(true); //ajax call, the parameter is the boolean of publish to MP, true= publish to mp false=save
			}*/
		}
		else
		{
			showErrorMsg("The fields need to be enter in the following fields which are already highlighted in correspond fields:<br/>"+errors.join("<br/>"),true);
		}	
	});
	$("#cancel_create_board").live("click",function(e)
	{
		logging("cancel create board");
		//$("#tabs").tabs("select","tab_manage_board");
		//change the hash
		location.hash="#portfolio_item_"+preloadPortfolioId;
	});
	$("#portfolioId").live("click",function(e)
	{
		$("#portfolioId").unbind("change"); //unbind the previous event
		$("#portfolioId").bind("change",function(e)
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
					//console.log(result);
					//put the list
					var listContent="";
					for(var i=0;i<result.list.length;i++)
					{
						listContent+='<option value='+result.list[i].categoryId+'>'+result.list[i].name+'</option>';
					}
					$("#product").html(listContent);
				}
			});
		});
	});
	$("#product").live("click",function(e)
	{
		$("#product").unbind("change"); //unbind the previous event
		$("#product").bind("change",function(e)
		{
			logging("Product change=>"+e.target.value);
			//clear the list
			$("#productType").html("");
			$.ajax(
			{
				url: productTypeListPath+"/"+e.target.value,
				type: "GET",
				success: function(result)
				{
					//console.log(result);
					//put the list
					var listContent="";
					for(var i=0;i<result.list.length;i++)
					{
						listContent+='<option value='+result.list[i].categoryId+'>'+result.list[i].name+'</option>';
					}
					$("#productType").html(listContent);
				}
			});
		});
	});
	$("#showCommission").live("click",function(e)
	{
		logging("show commission");
		showCommission();
	});
	$("#price_guideline_link").live("click",function(e)
	{
		logging("show price guide line");
		//close sidebar
		closeSidebar();
		//load popup
		loadPopup(showPriceGuidelinePath);
	});
	//End of create board tab====================================================================================
	
	//Create a portfolio tab=====================================================================================
	$("#save_create_portfolio").live("click",function(e)
	{
		logging("save create portfolio");
		createPortfolio();
	});
	$("#cancel_create_portfolio").live("click",function(e)
	{
		logging("cancel create portfolio");
		$("#tabs").tabs("select","tab_manage_portfolio");
	});
	$("#add_new_board").live("click",function(e)
	{
		logging("show create board tab");
		$("#tabs").tabs("select","tab_create_board");
		//change the url
		$("#tabs").tabs("url",getIdByName("tab_create_board"),createBoardPath);
		//reload the page
		$("#tabs").tabs("load",getIdByName("tab_create_board"));
	});
	$("#form_division").live("change",function(e)
	{
		logging("division change=>"+e.target.value);
		//get category list
		getCategoryList(e.target.value);
	});
	//End of create a portfolio tab==============================================================================
	
	//Activity tab===============================================================================================
	$("#chart_today").live("click",function(e)
	{
		logging("show today");
		//reload the chart
		initChart(chartPath+"/1");
		disableChartLink("#chart_today");
	});
	$("#chart_week").live("click",function(e)
	{
		logging("show week");
		//reload the chart
		initChart(chartPath+"/7");
		disableChartLink("#chart_week");
	});
	$("#chart_month").live("click",function(e)
	{
		logging("show month");
		//reload the chart
		initChart(chartPath+"/30");
		disableChartLink("#chart_month");
	});
	$(".gridBoardId").live("click",function(e)
	{
		logging("board id=>"+$(this).attr("data"));
		//show popup
		showWindow($(this).attr("data"));
	});
	$(".gridDesignerName").live("click",function(e)
	{
		logging("click user id=>"+encodeURIComponent($(this).attr("data")));
		//close sidebar
		closeSidebar();
		//show user info popup
		loadPopup(userInfoPath+"?profileUserName=&profileUserId="+encodeURIComponent($(this).attr("data")));
	});
	//End of activity tab======================================================================================
	
	//Manage portfolio tab=====================================================================================
	$("#clear_manage_portfolio").live("click",function(e)
	{
		$("input").removeAttr("checked"); //uncheck all checkbox
	});
	$("#add_manage_portfolio").live("click",function(e)
	{
		logging("add portfolio");
		$("#tabs").tabs("select","tab_create_portfolio");
	});
	$("#delete_manage_portfolio").live("click",function(e)
	{
		logging("delete portfolio");
		deletePortfolio();
	});
	$("#manage_portfolio a").live("click",function(e)
	{
		//logging("a=>"+e.currentTarget.id);
		//change hash
		location.hash="#portfolio_item_"+$(this).attr("data");
		//$(this).children("div").animate({"border-width":"2px"},"fast");
	});
	$("#manage_portfolio a").live("mouseenter",function(e)
	{
		$(this).children("div").eq(0).addClass("shadow");
	});
	$("#manage_portfolio a").live("mouseleave",function(e)
	{
		$(this).children("div").eq(0).removeClass("shadow");
	});
	$("#portfolio_carouselPrev").live("click",function(e)
	{
		logging("portfolio prev");
		
		//set the current page
		currentPage_portfolio--;
		if(currentPage_portfolio<0)
			currentPage_portfolio=totalPages_portfolio-1;
		//change the hash
		location.hash="#portfolio_page_"+currentPage_portfolio;
	});
	$("#portfolio_carouselNext").live("click",function(e)
	{
		logging("portfolio next");
		
		//set the current page
		currentPage_portfolio++;
		if(currentPage_portfolio>=totalPages_portfolio)
			currentPage_portfolio=0;
		//change the hash
		location.hash="#portfolio_page_"+currentPage_portfolio;
	});
	$(".delete_portfolio").live("click",function(e)
	{
		logging("delete portfolio=>"+parseInt($(this).attr("data")));
		var targetedId=parseInt($(this).attr("data"));
		/*var r=confirm("The portfolio is going to be deleted. Coninue ?");*/
		showConfirmation("The portfolio is going to be deleted. Coninue ?","Confirmation","delete_portfolio");
		$("body").live("delete_portfolio",function(e)
		{
			//console.log(e);
			logging("Confirmation result=>"+e.trigger);
			if(e.trigger=="ok")
			{
				deletePortfolio(targetedId);
			}
			//remove the event listener
			$("body").die("delete_portfolio");
		});	
		/*if (r==true)
			deletePortfolio(delete_portfolioId);*/
	});
	//End of manage portfolio tab=============================================================================
	
	//manage board tab========================================================================================
	$("#show_all_portfolios a").live("click",function(e)
	{
		logging("Show all portfolio","#F90");
		$("#tabs").tabs("select","tab_manage_portfolio");
	});
	$("#portfolio_catalog").live("change",function(e)
	{
		logging("change location=>"+e.currentTarget.value);
		//change hash to trigger hash change event
		location.hash="#portfolio_item_"+e.currentTarget.value;
	});
	$("#publish_manage_board").live("click",function(e)
	{
		logging("publish board");
	});
	$("#add_manage_board").live("click",function(e)
	{
		//get portfolio id
		logging("add new board under portfolio =>"+$("#portfolio_catalog").val());
		//change url
		$("#tabs").tabs("url",getIdByName("tab_create_board"),createBoardWithPortfolioPath+"/"+$("#portfolio_catalog").val());
		//select tab
		$("#tabs").tabs("select","tab_create_board");
	});
	$("#delete_manage_board").live("click",function(e)
	{
		logging("delete selected board");
		deleteBoard();
	});
	$("#clear_manage_board").live("click",function(e)
	{
		//logging("clear all");
		$("#form_boards")[0].reset(); //reset the form
	});	
	$("#manage_board a").live("mouseenter",function(e) //show effect when mouse move in target portfolio
	{
		//$(this).children("div").eq(0).addClass("shadow"); //add shadow
		$(this).parent().addClass("shadow"); //add shadow
	});
	$("#manage_board a").live("mouseleave",function(e) //show effect when mouse move out target portfolio
	{
		//$(this).children("div").eq(0).removeClass("shadow"); //remove shadow
		$(this).parent().removeClass("shadow"); //add shadow
	});
	$("#board_carouselPrev").live("click",function(e)
	{
		prevBoardPage();	
	});
	$("#board_carouselNext").live("click",function(e)
	{
		nextBoardPage();
	});
	$("body").live("refresh_board",function(e,pId)
	{
		logging("REFRESH BOARD BY EVENT");
		refreshBoards(pId);
	});
	$(".designerBoardLink").live("click",function(e)
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
	$(".delete_board").live("click",function(e)
	{
		logging("delete board=>"+parseInt($(this).attr("data")));
		var targetBoardId=$(this).attr("data");
		/*var r=confirm("The board is going to be deleted. Coninue ?");*/
		showConfirmation("The board is going to be deleted. Coninue ?","Confirmation","delete_board");
		$("body").live("delete_board",function(e)
		{
			//console.log(e);
			logging("Confirmation result=>"+e.trigger);
			if(e.trigger=="ok")
			{
				deleteBoard(targetBoardId);
			}
			//remove the event listener
			$("body").die("delete_board");
		});
		/*if (r==true)
			deleteBoard(boardId);*/	
	});
	$(".togglePubstatus_board").live("click",function(e)
	{
		logging("toggle board status to public=>"+$(this).attr("data"));
		var targetBoardId=$(this).attr("data");
		/*var r=confirm("The status of the board is going to be changed. Coninue ?");*/
		showConfirmation("The status of the board is going to be changed. Coninue ?","Confirmation","togglePubstatus_board");
		$("body").live("togglePubstatus_board",function(e)
		{
			//console.log(e);
			logging("Confirmation result=>"+e.trigger);
			if(e.trigger=="ok")
			{
				ToggleStatusBoard(targetBoardId);
			}
			//remove the event listener
			$("body").die("togglePubstatus_board");
		});		
		/*if (r==true)
			ToggleStatusBoard(boardId);*/
	});
	$(".toggleHidstatus_board").live("click",function(e)
	{
		logging("toggle board status to hidden=>"+$(this).attr("data"));
		var targetBoardId=$(this).attr("data");
		/*var r=confirm("The status of the board is going to be changed. Coninue ?");*/
		showConfirmation("The status of the board is going to be changed. Coninue ?","Confirmation","toggleHidstatus_board");
		$("body").live("toggleHidstatus_board",function(e)
		{
			//console.log(e);
			logging("Confirmation result=>"+e.trigger);
			if(e.trigger=="ok")
			{
				ToggleStatusBoard(targetBoardId);
			}
			//remove the event listener
			$("body").die("toggleHidstatus_board");
		});		
		/*if (r==true)
			ToggleStatusBoard(boardId);*/
	});
	//End of manage board tab=============================================================================
	
	//Check out tab=======================================================================================
	$("#back_to_search_result").live("click",function(e)
	{
		//Render the page
		var sortList='<option value="1">Date ASC</option>'+
		 '<option value="2" selected="selected">Date DESC</option>'+
		 '<option value="3">Designer ASC</option>'+
		 '<option value="4">Designer DESC</option>'+
		 '<option value="5">Board Name ASC</option>'+
		 '<option value="6">Board Name DESC</option>';
		//Render the page
		var left = '<div class="left" id="leftPanel"><div class="searchTitle">Search Result</div><div id="searchResultPagin"><div class="pages" id="searchPages"></div></div>' + 
		'<div class="sort" id="sort">Sort By<br><select name="" class="list" id="sortSearchResult">'+sortList+'</select></div>' +
		'<div class="searchPanel" id="searchPanel"><br> <a href="#" id="back_search_criteria">Back To Search Criteria</a></div></div>';

		var rigth = '<div class="right"><div class="rightCurve"></div></div>';

		var contentFrame = '<div class="contentFrame" id="contentFrame"><div class="touchbar left_touchbar" id="search_carouselPrev"><i></i>' +
		'<img src="/images/arrow_left.png"></div><div class="content" id="content"> <div id="mask"><div id="data" class="data">' +
		'</div></div></div><div class="touchbar right_touchbar" id="search_carouselNext"><i></i><img src="/images/arrow_right.png"></div></div>';
		$("#tab_search_result").html(left + rigth + contentFrame);
		
		logging("back to results");
		$("#tabs").tabs("enable","tab_search_result"); //enable search result tab		
		$("#tabs").tabs("select","tab_search_result"); //select search result tab
		$("#tabs").tabs("disable","tab_search_criteria"); //disable search tab
	});
	$("#shopping_cart_update").live("click",function(e)
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
					cart=result; //reset the shopping cart
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
	$("#shopping_cart_terms").live("click",function(e)
	{
		//close sidebar
		closeSidebar();
		//loadPopup("terms.html");
		displayLatestTermAndConditions(CustomerSaleTermsPath);
	});
	$("#terms_ok").live("click",function(e)
	{
		logging("terms_ok");
		$("#form_checkOutTAndC").attr("checked","checked");
		if($("#terms_agree").attr("checked")=="checked") //if user check agree, then go to verification panel
		{
			// capture terms id
			var termId = $('input[name="termsId"]').val();
			closepopup();
			//check the chechbox in registration page
			$("#form_checkOutTAndC").attr("checked","checked");
			//$('#form_accepted_termsId').val(termId);
		}
		else if($("#terms_decline").attr("checked")=="checked") //if user decline the term, then close the panel
		{
			closepopup();
			//uncheck the chechbox in registration page
			$("#form_checkOutTAndC").removeAttr("checked");
		}
	});
	$("#shopping_cart_checkout").live("click",function(e)
	{
		logging("check out");
	});
	$("#form_shoppingcart_checkout").live("submit",function(e) {
		logging("form_shoppingcart_checkout");
		if($("#form_checkOutTAndC").attr("checked")!="checked"){
			showErrorMsg("Please Accept the Sales Terms and conditions before proceeding to checkout. Thanks",true);
			return false;
		}
		else
		{
			//this is for disabling the pay button once paypal pay is selected
			$("#shopping_cart_checkout").prop("disabled",true);
			$("#form_shoppingcart_checkout").prop("disabled",true);
			logging("checkout");
			//show the mask on the paynow button
			$('#paynowMask').css("z-index","10");
		}
	});
	$(".checkoutBoardId").live("click",function(e)
	{
		logging("board id=>"+$(this).attr("data"));
		showWindow($(this).attr("data"));
	});
	$(".checkoutDesignerId").live("click",function(e)
	{
		logging("designer id=>"+$(this).attr("data"));
		//close sidebar
		closeSidebar();
		//show user info popup
		loadPopup(userInfoPath+"?profileUserName=&profileUserId="+$(this).attr("data"));
	});
	//End of check out================================================================================
	
	//popup event handler=================================================================================
	//shopping cart popup-------------------------------------
	$("#back_to_search_results").live("click",function(e)
	{
		logging('back to search results');
		//$("#tabs").tabs("select","tab_search_result"); //show search result tab
		closepopup(); //close popup
	});
	$("#to_checkout").live("click",function(e)
	{
		logging('to checkout');
		//location.hash = "#shopping_cart";
		//$(window).hashchange();
		//$("#tabs").tabs("select","tab_shopping_cart");
		//$("#tabs").tabs("load",getIdByName("tab_shopping_cart"));
		closepopup(); //close popup
		if(location.hash=="#shopping_cart")
		{
			//trigger the hash event forcelly
			$(window).hashchange();
		}
		else
			location.hash = "#shopping_cart";
	});
	$(".shoppingCartBoardId").live("click",function(e)
	{
		logging("board id=>"+$(this).attr("data"));
		showWindow($(this).attr("data"));
	});
	$(".shoppingCartDesignerId").live("click",function(e)
	{
		logging("designer id=>"+$(this).attr("data"));
		//close sidebar
		closeSidebar();
		loadPopup(userInfoPath+"?profileUserName=&profileUserId="+$(this).attr("data"));
	});
	//board detail popup-------------------------------------
	$("#add_to_shopping_cart").live("click",function(e)
	{
		logging("add to cart","#00F");
		addToCart($(this).attr("data"));
	});
	$("#remove_from_shopping_cart").live("click",function(e)
	{
		logging("remove from cart","#00F");
		removeFromCart($(this).attr("data"));
	});
	$("#form_send_comment").live("click",function(e)
	{
		logging("send message");
		sendMessage();
	})
	$(".boards_suggestion_boardId").live("click",function(e)
	{
		logging("show board=>"+$(this).attr("data"));
		showWindow($(this).attr("data"),false);
	});
	$(".enlargeImage").live("click",function(e)
	{
		logging("Enlarge image=>"+$(this).attr("image-width")+";"+$(this).attr("image-height")+";"+$(this).attr("image-data"),"#F00");
		//get path
		var imagePath=$(this).attr("image-data");
		//get width
		var imageWidth=parseInt($(this).attr("image-width"));
		imageWidth+=20;
		//get height
		var imageHeight=parseInt($(this).attr("image-height"));
		imageHeight+=20;
		
		//get screen size, and determine the size of image viewer.
		var screenWidth=screen.width;
		var screenHeight=screen.height;
		if(imageWidth>=screenWidth*0.9)
			imageWidth=screenWidth*0.9;
		if(imageHeight>=screenHeight*0.85)
			imageHeight=screenHeight*0.85;
		
		//open the new window with scrollbar and without toolbar.
		window.open(imageViewerPath+"?img="+imagePath,"_blank",'width='+imageWidth+',height='+imageHeight+',scrollbars=yes,toolbar=no');
	});
	//referral-------------------------------------
	$("#referral_submit").live("click",function(e)
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
				//set the flag
				isChangedWithoutSubmitOnPopup=false;
				logging("Send referral data success");
				if(result[0]=="SUCCESS")
				{
					$("#addReferralResult").css("color","blue");
					$("#addReferralResult").html(result[1]);
					$("#form_referral")[0].reset();
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
	$(".edit_referral").live("click",function(e)
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
		var updateLink='<a href="javascript:void(0)" class="update_referral" id="update_referral_'+tableId+'">Update</a>';
		var sendLink='<a href="javascript:void(0" class="send_referral" id="send_referral_'+tableId+'">Update and Send</a>';
		//change the link in action area
		$("#referral_action_"+tableId).html(updateLink+"<br />"+sendLink);
	});
	//update referral
	$(".update_referral").live("click",function(e)
	{
		doUpdateReferral(e);
	});
	//update and resend
	$(".resend_noti").live("click",function(e)
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
	$(".send_referral").live("click",function(e)
	{
		doSendReferral(e);
	});
	//catch the event when close the popup======================================
	$("#popupContainer").live("terms_agree",function()
	{
		logging("terms agree");
		//loadPopup("membership.html"); //set GET var to check the checkbox
	});
	$("#popupContainer").live("terms_decline",function()
	{
		logging("terms decline");
		//loadPopup("membership.html"); //set GET var to check the checkbox
	});
	//End of popup event handler================================================
	$("#remove_from_cart_bybid").live("click",function(e){
		logging("remove_from_cart_bybid"+$(this).attr("data"));
		delete_from_cart_by_board_id($(this).attr("data"));
		//+ $(this).attr("data")
	});
	
	//Session popup=============================================================
	$("#logout").live("click",function(e)
	{
		logging("LOGOUT");
		logout();
	});
});

//Hash Change event===================================================================================
function hashChange()
{
	if(location.hash.search("#nail")!=-1) //check the hash contain '#item' or not
	{
		logging("Hash Change=>"+location.hash);
		var temp=location.hash.split("_");
		//logging(e.currentTarget.id); //for debugging
		showWindow(temp[1]); //show the popup
		closeSidebar();	//close the sidebar
	}
	else if(location.hash.search("#messages_page")!=-1)
	{
		logging("Trigger Hash Change: messages page");
		//get page id
		var temp=location.hash.split("_");
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
		$("#tab_messages").html(basicConsoleFrame); //show loading message
		$("#tabs").tabs("select",page_messages);
		$("#tabs").tabs("load",page_messages);
	}
	else if(location.hash.search("#message_detail")!=-1)
	{
		logging("Trigger Hash Change: message detail");
		//get page id
		var temp=location.hash.split("_");
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
		$("#tab_messages").html(basicConsoleFrame); //show loading message
		$("#tabs").tabs("select",page_messages);
		$("#tabs").tabs("load",page_messages);
		//initialize component
		//$("textarea").autosize();
	}
	else if(location.hash.search("#search_page")!=-1)
	{
		//get page id
		var temp=location.hash.split("_");
		var pageId=temp[2];
		var sortOption=temp[3];
		logging("load search page=>"+pageId);
		logging("sort option=>"+sortOption);
		
		if(sortOption!=undefined)
			sortSearchResult(sortOption);
		else
			sortSearchResult(1);
		var pageResult=getSearchResultByPage(pageId);
		
		//set currentpage
		currentPage=pageId;
		//show pagin
		searchResultPagin();
		//create new div to put the data
		$('#mask').append('<div class="nextdata">'+pageResult+'</div>');
		
		//show transition effect
		transit('#mask');
		//sync market
		syncMarket();
	}
	else if(location.hash.search("#portfolio_item")!=-1)
	{
		logging("PORTFOLIO");
		//get page id
		var temp=location.hash.split("_");
		var id=temp[2]; //portfolio id
		var tabBoardIndex=getIdByName("tab_manage_board");
		logging("open portfolio=>"+id);
		
		//set the id
		portfolioId=id;
		//set the preloadPortfolioId to load boards data after the tab showed up.
		preloadPortfolioId=id;
		//change tab url
		$("#tabs").tabs("url",tabBoardIndex,boardPath+"/"+id);
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
	else if(location.hash.search("#portfolio_page")!=-1)
	{
		//get page id
		var temp=location.hash.split("_");
		var pageId=temp[2];
		logging("load portfolios page=>"+pageId);
		
		$("#tabs").tabs("select","tab_manage_portfolio");
		//set current page
		currentPage_portfolio=pageId;
		//show pagin
		portfolioPagin();
		var pageResult=getPortfolioItemsByPage(pageId); //get the data by page.
		//create new div to put the data
		$('#portfolio_mask').append('<div class="nextdata">'+pageResult+'</div>');
		//show transition effect
		transit('#portfolio_mask');
	}
	else if(location.hash.search("#board_item")!=-1)
	{
		//get board id
		var temp=location.hash.split("_");
		var id=temp[2];
		logging("show board item=>"+id);
		
		//close sidebar
		closeSidebar();
		loadPopup(boardDetailPath+"/"+id); //show popup
	}
	else if(location.hash.search("#board_page")!=-1)
	{
		//get page id
		var temp=location.hash.split("_");
		var pId=temp[2];
		var pageId=temp[3];
		logging("show board page=>"+pageId);
		
		//set current page
		currentPage_board=pageId;
		//show pagin
		boardsPagin();
		var pageResult=getBoardsByPage(pageId);
			
		if(pageResult.length<=0) //if the length less than 0, show empty message
			$('#board_mask').append('<div class="nextdata">'+emptyBoardMsg+'</div>');
		else
			$('#board_mask').append('<div class="nextdata">'+pageResult+'</div>'); 	//create new div to put the data
		
		//show transition effect
		transit('#board_mask');
	}
	else if(location.hash.search("#edit_board")!=-1)
	{
		//get page id
		var temp=location.hash.split("_");
		var boardId=temp[2];
		logging("edit board=>"+boardId);
		//change the url
		$("#tabs").tabs("url",getIdByName("tab_create_board"),createBoardPath+"/"+boardId);
		$("#tabs").tabs("select","tab_create_board");
	}
	else if(location.hash.search("#rating_designer")!=-1)
	{
		//parse the id
		var temp=location.hash.split("_");
		var id=temp[2];
		//
		logging("rating=>"+id);
		$("#tabs").tabs("url",getIdByName("tab_rating"),ratingPath+"/"+id);
		$("#tabs").tabs("select","tab_rating");
	}
	else if(location.hash.search("#rating_company")!=-1)
	{
		//parse the id
		var temp=location.hash.split("_");
		var id=temp[2];
		//
		logging("rating=>"+id);
		$("#tabs").tabs("select","tab_rating");
	}
	else if(location.hash.search("#design_wall")!=-1)
	{
		//parse the parameter
		logging("PARSING HASH="+location.hash);
		var temp=location.hash.split("_");
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
	else if(location.hash.search("#designer_account")!=-1)
	{
		//parse the parameter
		logging("PARSING HASH="+location.hash);
		var temp=location.hash.split("_");
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
	else if(location.hash.search("#search_criteria")!=-1)
	{
		//show search criteria tab
		$("#tabs").tabs("select","tab_search_criteria");
	}
	else if(location.hash.search("#alerts")!=-1)
	{
		$("#tabs").tabs("select","tab_alerts");
	}
	else if(location.hash.search("#shopping_cart")!=-1)
	{
		$("#tabs").tabs("select","tab_shopping_cart");
		$("#tabs").tabs("load",getIdByName("tab_shopping_cart"));
	}
	else if(location.hash.search("#home")!=-1)
	{
		$("#tabs").tabs("select","tab_home");
		//$("#tabs").tabs("load",getIdByName('tab_home'));
	}
	else if(location.hash.search("#edit_company_profile")!=-1)
	{
		$("#tabs").tabs("select","tab_home_edit_mode");
	}
	else if(location.hash.search("#edit_designer_profile")!=-1)
	{
		$("#tabs").tabs("select","tab_designer_home_edit_mode");
	}
	else
	{
		logging("close=>"+location.hash);
		if(isViewerOpened==true)
		{
			closepopup();
		}
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
	for (var key=0, size=item.length; key<size;key++) 
	{
		//determine to show the dummy image or not
		if(item[key].showImage)
			html+='<tr><td class="td1">'+ '<a href="javascript:void(0)" class="gridBoardId" data='+ item[key].boardId +'> <img src="/100x100/' +item[key].boardImageUrl + '"/></a></td>';
		else
			html+='<tr><td class="td1">'+ '<a href="javascript:void(0)" class="gridBoardId" data='+ item[key].boardId +'> <img src="/images/forbidden.jpg"/></a></td>';
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
	for (var key=0, size=item.length; key<size;key++) 
	{
	  if(item[key].showImage)
			html+='<tr><td class="td1">'+ '<a href="javascript:void(0)" class="gridBoardId" data='+ item[key].boardId +'> <img src="/100x100/' +item[key].boardImageUrl + '"/></a></td>';
	  else
			html+='<tr><td class="td1">'+ '<a href="javascript:void(0)" class="gridBoardId" data='+ item[key].boardId +'> <img src="/images/forbidden.jpg"/></a></td>';
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
			},
			//showTickMarks: true
			
		},
		axes: 
		{
		  xaxis: 
		  {
			  renderer: $.jqplot.CategoryAxisRenderer,
			  ticks : ticks,
			  label:"Time Scale"
		  },
		  yaxis: 
		  {
			  min: 0,
			  pad: 1.5,
			  tickOptions:
			  {
				  formatString: '%d'
			  },
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
	if(cart!=undefined)
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
			if(cart!=undefined || cart!=null)
			{
				if($.inArray(parseInt(id),cart.boardIdList)!=-1) //means the board is already in shopping cart, set the value to true
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
		url: getItemPath,
		type: "POST",
		error: function()
		{
			logging("get cart error");
		},
		success: function(result)
		{
			//console.log("IN CART=>");
			cart=result;
			checkShoppingCart(result.count)
			//console.log(cart);
		}
	});
}
function checkShoppingCart(count)
{
	//check the session if there is any products in cart
	//if there are boards in shopping cart
	logging("COUNT=>"+count);
	if(count>0)
		$("#cart_icon .cart_icon").attr("src",shoppingCartFullImgPath); //show the icon of full cart
	else
		$("#cart_icon .cart_icon").attr("src",shoppingCartImgPath); //show the icon of full cart
	
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
				cart=result;
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
				cart=result;
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
					cart=result;
					
					$("#item_id_"+board_id).html("");
					$("#total_price").html("$"+result.total);
					//sync market
					syncMarket();
					$("#tabs").tabs("load",getIdByName("tab_shopping_cart"));
					if(result.count>0)
						$("#popup_checkout_button").html("<a href=\"javascript:void(0)\" id=\"to_checkout\"><div class=\"button orangeButton\" id=\"button_checkout\">Checkout</div></a>");
					else
						$("#popup_checkout_button").html("");
				}
			});
}

function effect_addToCart(target_id)
{
	//get the location of the cart icon
	var termination=$("#cart_icon").offset();
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
	var start=$("#cart_icon").offset();
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
			cart=result;
			//show add successful message
			showErrorMsg("Added to cart successfully",true,"Add to cart",true);
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
			cart=result;
			//show remove successful message
			showErrorMsg("Remove from cart successfully",true,"Remove from cart",true);
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
	loadPopup(showCommissionPath+'/'+price);
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
			//console.log("BOARD RESULT");
			//console.log(result);
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
				showErrorMsg("Please enter data in the mandatory fields displayed in the list:<br/>"+errorInfo.join("<br/>"),true);
				//alert("error=>"+result.errorCode+":"+result.errorDescription);
			}
			else
			{
				if(result.type=="create")
				{
					//TODO user customed popup
					showErrorMsg("Create board successfully",true,"Create board");
					//alert("Create board successfully");
					if(isPublished)
					{
						//set the flag
						isChangedWithoutSubmit=false;
						$("#tabs").tabs("load",getIdByName("tab_manage_portfolio"));
						//go back to portfolio page
						$("#tabs").tabs("select","tab_manage_portfolio");
					}
					else
						clear();
				}
				else
				{
					//TODO user customed popup
					showErrorMsg("Update board successfully",true,"Update board");
					//alert("Update board successfully");
					if(isPublished)
					{
						//set the flag
						isChangedWithoutSubmit=false;
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
					}
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
			var final=price*(1.0-rate);
			$("#saletype_"+i+"_final").html(final.toFixed(2));
			//fill in the final price in the form
			$("#form_final_price").val(final);
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
			$('#board_mask').html('<div class="data">'+loadingMsg+'</div>');
		},
		success: function(result)
		{
			logging("Get boards data","#F00");
			//console.log("Boards=>");
			//console.log(result.results);
			boardsResult=result.results;
			//count total pages
			totalPages_board=Math.ceil(result.results.length/itemsPerPage_board);
			logging("Total board pages=>"+totalPages_board);
			//reset the current page
			currentPage_board=0;
			location.hash="#board_page_"+id+"_0";
			/*//get the first page of boards data, and show on the page
			$('#board_mask').append('<div class="nextdata">'+getBoardsByPage(0)+'</div>');
			//show transition effect
			transit('#board_mask');*/
		}
	});
}
//get the boards data by page and create the html.
function getBoardsByPage(pageId)
{
	var pageContent="";
	if(boardsResult==null || boardsResult.length<=0)
	{
		logging("board result is 0");
	}
	else
	{
		for(var i=pageId*itemsPerPage_board;i<(pageId+1)*itemsPerPage_board;i++)
		{
			var item=boardsResult[i];
			if(item!=undefined)
			{
				var nail="";
				nail+='<div class="item">';
				nail+='<a href="#board_item_'+item.boardId+'" id="board_'+item.boardId+'" class="designerBoardLink" data="'+item.boardId+'">';
				nail+='<div class="board"><i></i>';
				if(item.boardImages.length > 0)
					nail+='<img src="/400x400/'+item.boardImages[item.boardImages.length-1].fileName+'" />'; //image resource
				nail+='</div>';
				nail+='</a>';
				nail+='<div class="detail">';
				nail+='<div class="board_name">'+item.name+'</div>';
				nail+='<div class="edit"><a href="#edit_board_'+item.boardId+'">Edit</a></div>';
				nail+='<div class="price">Price $ '+item.totalPrice+'</div>';
				nail+='<div class="delete_board" data="'+item.boardId+'"><img src="/images/recycle_bin.png" /></div>';
				nail+='<div class="status"> '+item.boardStatus+'</div>';
				if(item.boardStatus!="Expired")
				{
					if(item.boardStatus!="Published")
						nail+='<div class="toggleStatus togglePubstatus_board" data="'+item.boardId+'"><img src="/images/order.png" /></div>';
					else
						nail+='<div class="toggleStatus toggleHidstatus_board" data="'+item.boardId+'"><img src="/images/order.png" /></div>';
				}
				//nail+='<div class="checkbox"><input name="selectedItems" type="checkbox" value="'+item.boardId+'" id="form_board_'+item.boardId+'"/></div>';
				nail+='</div>';
				nail+='</div>';
				pageContent+=nail;
			}
		}
	}
	return pageContent;
}
function boardsPagin()
{
	logging("Refresh boards pagin","#0F0");
	var pagin="";
	logging("cpage=>"+currentPage_board);
	var pagin="";
	currentPage_board=parseInt(currentPage_board);
	//show head pagin
	if(currentPage_board==0)
		pagin+='1&nbsp;';
	else
		pagin+='<a href="#board_page_'+portfolioId+'_0">1</a>&nbsp;';
	//show middle page if the totalPages > 2,(equals to 2 means only head and tail)
	if(totalPages_board>2)
	{
		//show ... before current page
		if(currentPage_board>=3)
			pagin+='...&nbsp;';
		//show adajacent page
		if(currentPage_board>=2)
			pagin+='<a href="#board_page_'+portfolioId+'_'+(currentPage_board-1)+'">'+(currentPage_board)+'</a>&nbsp;';
		//current page
		if(currentPage_board!=0 && currentPage_board!=totalPages_board-1)
			pagin+=(currentPage_board+1)+'&nbsp;';
		//show adajacent page
		if(totalPages_board-currentPage_board>=3)
			pagin+='<a href="#board_page_'+portfolioId+'_'+(currentPage_board+1)+'">'+(currentPage_board+2)+'</a>&nbsp;';
		//show ... after current page
		if(totalPages_board-currentPage_board>=4)
			pagin+='...&nbsp;';
	}
	//show tail pagin
	if(totalPages_board>=2)
	{
		if(currentPage_board==totalPages_board-1)
			pagin+=totalPages_board+'&nbsp;';
		else
			pagin+='<a href="#board_page_'+portfolioId+'_'+(totalPages_board-1)+'">'+totalPages_board+'</a>&nbsp;';
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
	//load data using ajax
	
	currentPage_board--;
	if(currentPage_board<0)
		currentPage_board=totalPages_board-1;
	//change hash
	location.hash="#board_page_"+portfolioId+"_"+currentPage_board;
}
function nextBoardPage()
{
	logging("board next");
	//load data using ajax
	
	currentPage_board++;
	if(currentPage_board>=totalPages_board)
		currentPage_board=0;
	//change hash
	location.hash="#board_page_"+portfolioId+"_"+currentPage_board;
}
function refreshBoards(pId)
{
	$.ajax(
	{
		url: getBoardsByPortfolioIdPath+"/"+pId,
		type: "POST",
		success: function(result)
		{
			logging("Get boards data");
			//console.log("Boards=>");
			//console.log(result.results);
			boardsResult=result.results;
			//count total pages
			totalPages_board=Math.ceil(result.results.length/itemsPerPage_board);
			logging("Total board pages=>"+totalPages_board);
			//reset the current page
			currentPage_board=0;

			//get the first page of boards data, and show on the page
			$('#board_mask').append('<div class="nextdata">'+getBoardsByPage(0)+'</div>');
			//show transition effect
			transit('#board_mask');
		}
	});
}
function checkFileTypeAndSaleType()
{
	//get selected radio button
	//console.log($('#saleTypeTable input[type="radio"]:checked').val());
	//console.log($('#saleTypeTable input[type="radio"]:checked').attr("code"));
	//get upload file type
	//console.log($('#form_board_image_type').val());
	var saletype=$('#saleTypeTable input[type="radio"]:checked').attr("code");
	var filetype=$('#form_board_image_type').val();
	if(filetype=='ai')
	{
		if(saletype=="JG")
		{
			//console.log("inconsistent");
			showErrorMsg("The file you uploaded is ai, please select the options with AI",true,"File Type Inconsistent",true,"filetype",false);
			return false;
		}
	}
	else if(filetype=='jpg')
	{
		if(saletype!="JG")
		{
			//console.log("file type inconsistent");
			showErrorMsg("The file you uploaded is jpg, please select the option JPG",true,"File Type Inconsistent",true,"filetype",false);
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
			$("#form_category").html(optionLoadingMsg);  //add the default list
		},
		error: function(jqXHR, textStatus, errorThrown)
		{
			logging("Error=>"+jqXHR+";"+textStatus+";"+errorThrown);
			//console.log("Error=>"+jqXHR+";"+textStatus+";"+errorThrown);
			$("#form_category").html("");
		},
		success: function(result,status)
		{
			logging("GET CATEGORY=>"+result.list.length);
			//console.log(result);
			var optionList;
			if(result.list.length<=0)
			{
				optionList="<option value=-1>--Empty--</option>";
			}
			else
			{
				//create default msg
				optionList=optionDefaultMsg;
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
			//console.log("AJAX Complete=>"+jqXHR+":"+textStatus);
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
			$("#form_product").html(optionLoadingMsg);  //add the default list
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
				optionList="<option value=-1>--Empty--</option>";
			}
			else
			{
				optionList=optionDefaultMsg;
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
			//console.log("AJAX Complete=>"+jqXHR+":"+textStatus);
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
			$("#form_product_type").html(optionLoadingMsg);  //add the default list
		},
		error: function(jqXHR, textStatus, errorThrown)
		{
			logging("Error=>"+jqXHR+";"+textStatus+";"+errorThrown);
			//console.log("Error=>"+jqXHR+";"+textStatus+";"+errorThrown);
			$("#form_product_type").html("");
		},
		success: function(result,status)
		{
			logging("GET LEVEL=>"+result.list.length);
			//console.log(result);
			var optionList;
			if(result.list.length<=0)
			{
				optionList="<option value=-1>--Empty--</option>";
			}
			else
			{
				optionList=optionDefaultMsg;
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
			//console.log("AJAX Complete=>"+jqXHR+":"+textStatus);
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
				dragAndDrop: false,
			});
		}
	});
	//$("#form_division_search_criteria").trigger("change");
}
function getSearchResult()
{
	logging("submit");
	//load data using ajax
	var formData=$('#form_search_criteria').serialize();
	//If the value of category, product, and product type=-1,replace it with empty string;
	formData=formData.replace("&division=-1","");
	formData=formData.replace("&category=-1","");
	formData=formData.replace("&product=-1","");
	formData=formData.replace("&productType=-1","");
	logging("search form=>"+formData);
	//get shopping cart list
	//var cart=getCart();
	
	var sortList='<option value="1">Date ASC</option>'+
        		 '<option value="2" selected="selected">Date DESC</option>'+
        		 '<option value="3">Designer ASC</option>'+
        		 '<option value="4">Designer DESC</option>'+
        		 '<option value="5">Board Name ASC</option>'+
        		 '<option value="6">Board Name DESC</option>';
	//Render the page
	var left = '<div class="left" id="leftPanel"><div class="searchTitle">Search Result</div><div id="searchResultPagin"><div class="pages" id="searchPages"></div></div>' + 
	   '<div class="sort" id="sort">Sort By<br><select name="" class="list" id="sortSearchResult">'+sortList+'</select></div>' +
	   '<div class="searchPanel" id="searchPanel"><br> <a href="javascript:void(0);" id="back_search_criteria">Back To Search Criteria</a></div></div>';

	var rigth = '<div class="right"><div class="rightCurve"></div></div>';

	var contentFrame = '<div class="contentFrame" id="contentFrame"><div class="touchbar left_touchbar" id="search_carouselPrev"><i></i>' +
	'<img src="/images/arrow_left.png"></div><div class="content" id="content"> <div id="mask"><div id="data" class="data">' +
	'</div></div></div><div class="touchbar right_touchbar" id="search_carouselNext"><i></i><img src="/images/arrow_right.png"></div></div>';
	$("#tab_search_result").html(left + rigth + contentFrame);
	
	//
	$.ajax(
	{
		url: searchResultPath,
		data: formData,
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
					showErrorMsg("Your search did not return any results.<br/>Please redefine search criteria.",true,"No search result");
					//create new div to put the data
					//$('#mask').append('<div class="nextdata">'+emptySearchResultMsg+'</div>');
					
					//show transition effect
					//transit('#mask');
				}
				else
				{
					//display results				
					//logging("result size=>"+result.results.length);
					//console.log("SEARCH=>");
					//console.log(result);
					//sava search result in an array
					searchResult=result.results;
					//calculate the total page
					totalPages=Math.ceil(result.results.length/itemsPerPage);
					logging("TOTAL SEARCH ITEMS=>"+result.results.length);
					logging("Current Page=>"+currentPage+" ; Total Pages=>"+totalPages);
					logging("Show item from "+(0*itemsPerPage)+" to "+(((currentPage+1)*itemsPerPage)-1));
					//change hash
					location.hash="#search_page_0";
					
					/*$.each(result.results, function(i, val)
					{
						var nail="";
						nail+='<div class="nail" id="item'+val.boardId+'">';
	                	nail+='<div class="name">'+val.name+'</div>';
	                	nail+='<div class="check"><div id="add_board_'+val.boardId+'" class="add_to_cart"></div><input class="form_add_to_cart" name="form_add_to_cart_'+val.boardId+'" type="hidden" value="false"/></div>';
	                    nail+='<a href="#nail_'+val.boardId+'"><div class="pic" id="board_'+val.boardId+'"><img src="http://localhost/100x100/'+val.thumbnailUrl+'" style="width:auto; height:100%"/></div></a>';
	                    nail+='<div class="nailfunctions">email</div>';
	                    nail+='<div class="detail">'+val.totalPrice+'</div>';
	                    nail+='</div>';
						var l1 = '<div class="nail"><div class="name">' + val.name + '</div>';
				        var l2 = '<div class="check"><div class="add_to_cart"></div><input name="form_add_to_cart_'+val.boardId+'" type="hidden" value="false"/></div><a href="#nail_'+val.boardId+'"><div class="pic" id="board_'+val.boardId+'"><img src="' +val.thumbnailUrl +'" style="width:auto; height:100%"></div></a>';
				        //	var l3 = '<div class="nailfunctions">' + email + '</div>';
				        var l4 = '<div class="detail">' + val.boardPrice +'</div></div>';
						$("#data").append(nail);
					});*/
					$("#tabs").tabs("enable","tab_search_result"); //enable search result tab
					//if we select would send a request to server and renders the original page..
					$("#tabs").tabs("select","tab_search_result"); //select search result tab
					$("#tabs").tabs("disable","tab_search_criteria"); //disable search tab
				}
			}else
			{
				//go back to search criteria
				showErrorMsg("Your search did not return any results.<br/>Please redefine search criteria.",true,"No search result");
			}

		},
	});
}

function getSearchResultByPage(page)
{
	var pageResult="";
	//get the current page data
	if(searchResult!=undefined)
	{
		for(var i=page*itemsPerPage;i<(page+1)*itemsPerPage;i++)
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
	logging("cpage=>"+currentPage);
	var pagin="";
	currentPage=parseInt(currentPage);
	//show head pagin
	if(currentPage==0)
		pagin+='1&nbsp;';
	else
		pagin+='<a href="#search_page_0">1</a>&nbsp;';
	//show middle page if the totalPages > 2,(equals to 2 means only head and tail)
	if(totalPages>2)
	{
		//show ... before current page
		if(currentPage>=3)
			pagin+='...&nbsp;';
		//show adajacent page
		if(currentPage>=2)
			pagin+='<a href="#search_page_'+(currentPage-1)+'">'+(currentPage)+'</a>&nbsp;';
		//current page
		if(currentPage!=0 && currentPage!=totalPages-1)
			pagin+=(currentPage+1)+'&nbsp;';
		//show adajacent page
		if(totalPages-currentPage>=3)
			pagin+='<a href="#search_page_'+(currentPage+1)+'">'+(currentPage+2)+'</a>&nbsp;';
		//show ... after current page
		if(totalPages-currentPage>=4)
			pagin+='...&nbsp;';
	}
	//show tail pagin
	if(totalPages>=2)
	{
		if(currentPage==totalPages-1)
			pagin+=totalPages+'&nbsp;';
		else
			pagin+='<a href="#search_page_'+(totalPages-1)+'">'+totalPages+'</a>&nbsp;';
	}
	
	/*for(var i=0;i<totalPages;i++)
	{
		pagin+='<a href="#search_page_'+i+'">'+(i+1)+'</a>&nbsp;';
	}*/
	$("#searchResultPagin .pages").html('<span style="font-weight: bold;">Pages:</span>'+pagin);
}
function sortSearchResult(optionValue)
{
	if(enableSorting)
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
			//console.log(searchResult);
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
			//console.log(searchResult);
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
			//console.log(searchResult);
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
			//console.log(searchResult);
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
					showErrorMsg("Please enter data in the mandatory fields displayed in the list:<br/>"+errorInfo.join("<br/>"),true);
				}
				else
				{
					showErrorMsg("Added successfully",true,"Result");
					//alert("Added successfully");
					$('#form_create_portfolio')[0].reset();
					//change the flag
					isChangedWithoutSubmit=false;
					//load the manage portfolio tab to reload the data
					$("#tabs").tabs("load",getIdByName('tab_manage_portfolio'));
				}
			}
		});
	}
	else
	{
		showErrorMsg("The fields need to be enter in the following fields which are already highlighted in correspond fields:<br/>"+errors.join("<br/>"),true);
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
			$('#portfolio_mask').html('<div class="data">'+loadingMsg+'</div>');
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
				portfolioResult=result.results;
				portfolioImageList=result.imagesList;
				//calculate the total pages
				totalPages_portfolio=Math.ceil(result.results.length/itemsPerPage_portfolio);
				logging("TOTAL Portfolio items=>"+result.results.length);
				if(result.results.length>0)
				{
					logging("Total Pages=>"+totalPages_portfolio);
					//logging("Current hash=>"+location.hash);
					//create pagination
					if(location.hash=="#portfolio_page_"+page) //check current hash, if the hash is the same, trigger the hash event.
					{
						logging("same hash");
						$(window).hashchange();
					}
					else
					{
						//change the hash
						location.hash="#portfolio_page_"+page;
					}
				}
				else
				{
					//show empty data
					$('#portfolio_mask').append('<div class="nextdata">'+emptyPortfolioMsg+'</div>');
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
function getPortfolioItemsByPage(page)
{
	logging("portfolio items per page=>"+itemsPerPage_portfolio);
	logging("SHOW portfolio item from "+(page*itemsPerPage_portfolio)+" to "+((page+1)*itemsPerPage_portfolio));
	//logging('<span style="color:#FF0000">Portfolio items=>'+portfolioResult+'</span>');
	var portfolioContent="";
	//if the result is empty call the getPortfolioItems again to get the items.
	if(portfolioResult!=undefined)
	{
		for(var i=page*itemsPerPage_portfolio;i<(page+1)*itemsPerPage_portfolio;i++)
		{
			var item=portfolioResult[i];
			var itemImage=portfolioImageList[i];
			var nail="";
			if(item!=undefined)
			{
				nail+='<div class="item">';
	        	/*nail+='<a href="#portfolio_item_'+item.portfolioId+'" id="portfolio_'+item.portfolioId+' data="'+item.portfolioId+'"">';*/
	        	nail+='<a href="javascript:void(0);" id="portfolio_'+item.portfolioId+'" data="'+item.portfolioId+'"">';
	        	/*nail+='<div class="portfolio">';
	            nail+='<div class="topLeft" id="test1">';
	            if(itemImage[0]!=undefined)
	            	nail+='<img src=/100x100/'+itemImage[0]+'>';
	            nail+='</div>';
	            nail+='<div class="topRight">';
	            if(itemImage[1]!=undefined)
	            	nail+='<img src=/100x100/'+itemImage[1]+'>';
	            nail+='</div>';
	            nail+='<div class="bottomLeft">';
	            if(itemImage[2]!=undefined)
	            	nail+='<img src=/100x100/'+itemImage[2]+'>';
	            nail+='</div>';
	            nail+='<div class="bottomRight">';
	            if(itemImage[3]!=undefined)
	            	nail+='<img src=/100x100/'+itemImage[3]+'>';
	            nail+='</div>';
	            nail+='</div>';*/
	        	nail+='<div class="portfolio">';
	        	nail+='<table>';
	        	nail+='<tr>';
	            nail+='<td>';
	            if(itemImage[0]!=undefined)
	            	nail+='<img src=/100x100/'+itemImage[0]+'>';
	            nail+='</td>';
	            nail+='<td>';
	            if(itemImage[1]!=undefined)
	            	nail+='<img src=/100x100/'+itemImage[1]+'>';
	            nail+='</td>';
	            nail+='</tr>';
	            nail+='<tr>';
	            nail+='<td>';
	            if(itemImage[2]!=undefined)
	            	nail+='<img src=/100x100/'+itemImage[2]+'>';
	            nail+='</td>';
	            nail+='<td>';
	            if(itemImage[3]!=undefined)
	            	nail+='<img src=/100x100/'+itemImage[3]+'>';
	            nail+='</td>';
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
	else
	{
		logging("Reload the portfolio items=>"+page);
		getPortfolioItems(page);
	}
	return portfolioContent;
}
function portfolioPagin()
{
	logging("Refresh portfolio pagin","#0F0");
	logging("cpage=>"+currentPage_portfolio);
	var pagin="";
	currentPage_portfolio=parseInt(currentPage_portfolio);
	//show head pagin
	if(currentPage_portfolio==0)
		pagin+='1&nbsp;';
	else
		pagin+='<a href="#portfolio_page_0">1</a>&nbsp;';
	//show middle page if the totalPages > 2,(equals to 2 means only head and tail)
	if(totalPages_portfolio>2)
	{
		//show ... before current page
		if(currentPage_portfolio>=3)
			pagin+='...&nbsp;';
		//show adajacent page
		if(currentPage_portfolio>=2)
			pagin+='<a href="#portfolio_page_'+(currentPage_portfolio-1)+'">'+(currentPage_portfolio)+'</a>&nbsp;';
		//current page
		if(currentPage_portfolio!=0 && currentPage_portfolio!=totalPages_portfolio-1)
			pagin+=(currentPage_portfolio+1)+'&nbsp;';
		//show adajacent page
		if(totalPages_portfolio-currentPage_portfolio>=3)
			pagin+='<a href="#portfolio_page_'+(currentPage_portfolio+1)+'">'+(currentPage_portfolio+2)+'</a>&nbsp;';
		//show ... after current page
		if(totalPages_portfolio-currentPage_portfolio>=4)
			pagin+='...&nbsp;';
	}
	//show tail pagin
	if(totalPages_portfolio>=2)
	{
		if(currentPage_portfolio==totalPages_portfolio-1)
			pagin+=totalPages_portfolio+'&nbsp;';
		else
			pagin+='<a href="#portfolio_page_'+(totalPages_portfolio-1)+'">'+totalPages_portfolio+'</a>&nbsp;';
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
		idleAfter: idleTime, // user is considered idle after 5 minutes of no movement
		pollingInterval: pollingTime, // a request to keepalive.php (below) will be sent to the server every minute
		keepAliveURL: keepSessionAlivePath,
		serverResponseEquals: 'OK', // the response from keepSessionAlivePath must equal the text "OK"
		warningLength: warningTime,
		failedRequests: 5,
		AJAXTimeout: 2500,
		debugMode:idleTimeoutDebugMode,
		onTimeout: function()
		{
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
			showpopup("#session_expire");
			//$(this).dialog("open");
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
			closepopup("#session_expire","#session_overlay");
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
			path: ratyImgPath,
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
	data.eq(0).animate(
	{
		left:-900
	},"normal","swing");
	data.eq(1).animate(
	{
		left:0
	},"normal","swing");
	data.eq(0).remove();
}

//==================SIDEBAR======================================//
function openSidebar()
{
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
		}
	});
	if(!isOpened)
	{
		$("#sidebar").animate({width:350},"slow",function()
		{
			//rotate the arrow
			//$("#sidebarToggle").find("img").attr("class","rightArrow");
			$("#sidebarToggle img").attr("src","/images/arrow_right.png");
			$("#sidebarContent").fadeIn("fast",function()
			{
				//init scroll bar
				logging("init scroll bar","#F00");
				$("#sidebar_scrollbar").tinyscrollbar();
			});
		});
		isOpened=true;
	}
}
function closeSidebar()
{
	//logging("sideBar click=>"+isOpened);
	if(isOpened)
	{
		$("#sidebarContent").fadeOut("fast",function()
		{
			$("#sidebar").animate({width:50},"slow",function()
			{
				//rotate the arrow
				//$("#sidebarToggle").find("img").attr("class","leftArrow");
				$("#sidebarToggle img").attr("src","/images/arrow_left.png");
			});
		});
		isOpened=false;
	}
}

//update viewer
function showWindow(id,showEffect)
{
	if(showEffect==undefined)
		showEffect=true;
	//close sidebar
	closeSidebar();
	loadPopup(boardDetailPath+"/"+id,showEffect);
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
				//console.log(result);
				if(result.hasError)
				{
					//$("#send_status").html("Error, please resend again");
					showErrorMsg("Error, please resend again",true,"Error");
				}
				else
				{
					$("#send_status").html("Sent successfully");
					//TODO reload the message detail url
					//get the page id for messages
					var tab_messages=getIdByName('tab_messages');
					//change the flag
					isChangedWithoutSubmit=false;
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
		if($($(viewareaArray[i]).children('.context')).height()>56)
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
		//
		beforeSend: function()
		{
			logging("loading "+address);
			$("#overlay").fadeIn("fast"); //show the overlay when loading
		},
		error: function(xhr,status,error)
		{
			logging(this.url+" is "+error); //if there is arrow, close the overlay
			$("#overlay").fadeOut("fast"); //show the overlay when loading
		},
		success: function(result)
		{
			logging("loading "+this.url+"complete");	
			if(!(result && result.hasError))
			{
				//No error, show terms and conditioins popup..
				$("#popupContainer").html(result); //set the result to the popupContainer
				//show the popup on the screen
				showpopup();
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
}

//debug function, continue to record the data
function logging(data,color)
{
	if(color==undefined)
		color="#000";
	if(debugMode)
	{
		$("#debug").css("display","block");
		if(data==undefined || data=="")
			$("#debug").append("Undefined or blank <br />");	
		$("#debug").append('<span style="color:'+color+'">'+data+'</span><br />');
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
					//TODO show success popup
					isChangedWithoutSubmit=false;
					location.assign(homepage+"#home");	
					//update username on the header
					$("#userFirstName").html(result.userFirstName);
					$("#userLastName").html(result.userLastName);
					//change the logo on the page header.
					$(".bannerLogo").html('<i></i><img src="'+result.userLogo+'" />');
					showErrorMsg("Update Successfully",true,"Update Profile");
					//alert("Update Successfully");
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
					showErrorMsg("Please enter data in the mandatory fields displayed in the list:<br/>"+errorInfo.join("<br/>"),true);
				}
			}
		});
	}
	else
	{
		//client side input validation fail
		showErrorMsg("The fields need to be enter in the following fields which are already highlighted in correspond fields:<br/>"+errors.join("<br/>"),true);
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
					//TODO show success popup
					//showErrorMsg('<div style="color:#0000CC">Update Successfully</div>',true,"Update Result");
					//change the flag
					isChangedWithoutSubmit=false;
					location.assign(homepage+"#home");
					//update username on the header
					$("#userFirstName").html(result.userFirstName);
					$("#userLastName").html(result.userLastName);
					//change the logo on the page header.
					$(".bannerLogo").html('<i></i><img src="'+result.userLogo+'" />');
					showErrorMsg("Update Successfully",true,"Update Profile");
					//alert("Update Successfully");
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
					showErrorMsg("Please enter data in the mandatory fields displayed in the list:<br/>"+errorInfo.join("<br/>"),true);
				}
			}
		});
	}
	else
	{
		//client side input validation fail
		showErrorMsg("The fields need to be enter in the following fields which are already highlighted in correspond fields:<br/>"+errors.join("<br/>"),true);
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
					showErrorMsg("Update Failure.<br /> Please click update again.",true,"Update Referral Error");
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
		showErrorMsg("The fields need to be enter in the following fields which are already highlighted in correspond fields:<br/>"+errors.join("<br/>"),true);
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
					showErrorMsg("Update Failure.<br /> Please click update again.",true,"Update Referral Error");
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
		showErrorMsg("The fields need to be enter in the following fields which are already highlighted in correspond fields:<br/>"+errors.join("<br/>"),true);
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
		errors = HighlightLabelandPushError(errors,"#label_pricing","Please enter a valid price. It should be between 0 and 10000");
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
				logging("ERROR OCCURED");
			}	
			else
			{
				logging("REFRESH BOARDS");
				$("body").trigger("refresh_board",[portfolioId]);
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
				logging("ERROR OCCURED");
			}	
			else
			{
				logging("REFRESH BOARDS");
				$("body").trigger("refresh_board",[portfolioId]);
			}
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

function checkSession()
{
	logging("check session");
	$.ajax(
	{
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
		}
	});
}
