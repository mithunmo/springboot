// JavaScript Document
//Initialization
var debugMode=true; //set to true to enable debug panel
var isViewerOpened=false; //flag to determine the viewer is open or not
var currentIndex; //current index
var hasResult=false; //flag to determine that there is search result or not
var isEmpty=true;
var appPath="/webapp-1.0.0-BUILD-SNAPSHOT/"; //application path
var ratyImgPath=appPath+"resources/images/raty_img/"; //images path for raty plugin
var ver=1.2;
$(document).ready(function()
{
	var winHeight=$(window).height();
	logging("main running.."+ver);
	//Show current date
	var d = new Date();
	$(".date").html(d.toDateString());
	//initialize the tabs========================================================
	$("#tabs").tabs(
	{
		cache: false,
		spinner: "Loading..",
		fx: {opacity: 'toggle',duration: "fast"},
		select:function(e,ui)
		{
			var tab=ui.tab.toString();
			//get the tab name
			var tabName=tab.substr(tab.search("#")+1,tab.length).replace("tab_","");
			logging("SELECT tabName="+tabName);
			if(tabName=='home')
				location.hash="#home";
			else if(tabName=='search_criteria')
				location.hash="#search_criteria";
			else if(tabName=='activity_company' || tabName=='activity_designer')
				location.hash="#activity";
			else if(tabName=='design_wall')
				location.hash="#design_wall_1_1_1";
			else if(tabName=='alerts')
				location.hash='#alerts';
			else if(tabName=='messages')
				location.hash='#messages_page_1';
		},
		load: function(e,ui)
		{
			logging("TAB NAME="+ui.tab);
			var tab=ui.tab.toString();
			//get the tab name
			var tabName=tab.substr(tab.search("#")+1,tab.length).replace("tab_","");
			logging("LOAD tabName="+tabName);
			if(tabName=="search_criteria") //search criteria tab
			{
				//Initialize tree view------------------------------------------------------
				//load tree view data using JSON, it will load season.js
				$.getJSON('season.js',function(result)
				{
					$('#season').tree(
					{
						data: result,
						autoOpen: false,
						dragAndDrop: false,
					});
				});
				//logging($("#season").tree('toJson'));
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
			}
			else if(tabName=="activity_designer" || tabName=="activity_company") //activity tab
			{
				logging("activity designer tab");
				//initializa raty
				init_raty_activity();
				//initialize chart graph=====================================
				initChart(appPath+"console/chart/30");
				//disable the Chart link
				disableChartLink("#chart_month");
			}
			else if(tabName=="rating_designer" || tabName=="rating_company") //for rating designer
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
			}
			else if(tabName=="create_board")
			{
				logging("load create board tab");
			}
			//resize();
		//End of load event handler======================================================
		},
		show: function(e,ui)
		{
			logging("show tab=>"+ui.index);
			//show tab name=========================================================
			var tab=ui.tab.toString();
			logging("load tab "+ui.tab+" complete");
			//get the tab name
			var tabName=tab.substr(tab.search("#")+1,tab.length).replace("tab_","");
			//logging("SHOW tabName="+tabName);
			resize();
			if(tabName=="activity_designer" || tabName=="activity_company") //set raty value in activity page
			{
				logging("set raty value");
				//initialize raty plugin====================================
				init_raty_activity();
			}
		}
	});
	function init_raty_activity()
	{
		//get all rating items into an array
		var target=$(".readonly").toArray();
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
	if(getIdByName('tab_search_result')!=-1)
	{
		$("#tabs").tabs("disable","tab_search_result"); //hide search result tab
	}
	$("#tabs").tabs("select","tab_messages"); //select messages tab first
	//logging(getIdByName("tab_messages")); //test get id by name
	
	//Search criteria ===================================================================
	//event----------------------------------------------------------
	$("#submit_search_criteria").live("click",function()
	{
		logging("submit");
		//load data using ajax
		$.ajax(
		{
			url: appPath+"search_result",
			data: $('#form_search_criteria').serialize(),
			type: "POST",
			success: function(result)
			{
				$("#tab_search_result").html(result);
				$("#tabs").tabs("enable","tab_search_result"); //enable search result tab		
				$("#tabs").tabs("select","tab_search_result"); //select search result tab
				$("#tabs").tabs("disable","tab_search_criteria"); //disable search tab
			},
		});
		//$("#Search_result").load("search_result.html");
	});
	$("#link_save_search_criteria").live("click",function(e)
	{
		loadPopup(appPath+"save_search_criteria");
	});
	$("#form_open_saved_searches").live("change",function(e)
	{
		if(this.value!="") //if the value in this form is not equal to null, load the search options
		{
			logging("select searches=>"+this.value);
		}
	});
	//clear button
	$("#clear_search_criteria").live("click",function()
	{
		document.getElementById("form_search_criteria").reset();
	});
	
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
		loadPopup(appPath+"console/add_to_cart");
	});
	//nail event---------------------------------------------------------
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
		$(this).animate(
		{
			"opacity":0.4
		},"fast");
	});
	$(".touchbar").live("mouseleave",function(e)
	{
		$(this).animate(
		{
			"opacity":0
		},"fast");
	});
	$("#search_carouselNext").live("click",function(e)
	{
		logging('next');
		//retrieve the data from server
		
		//create new div to put the data
		$('#mask').append('<div class="nextdata">TEST</div>');
		
		//
		//get div element
		transit('#mask');
		
	});
	$("#search_carouselPrev").live("click",function(e)
	{
		logging('next');
		//retrieve the data from server
		
		//create new div to put the data
		$('#mask').append('<div class="nextdata">TEST</div>');
		
		//
		//get div element
		transit('#mask');
	});
	//End of search result==============================================================
	
	//Hash Change Event to set data in search result==================================
	$(window).hashchange(function(e)
	{
		if(location.hash.search("#nail")!=-1) //check the hash contain '#item' or not
		{
			logging("Hash Change=>"+location.hash);
			//logging(e.currentTarget.id); //for debugging
			showWindow(); //show the popup
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
			$("#tabs").tabs("url",page_messages,appPath+"messages/"+id); //set address here.
			//select tab
			logging("SELECT MESSAGES");
			$("#tabs").tabs("select",page_messages);
			$("#tabs").tabs("load",page_messages);
		}
		else if(location.hash.search("#message_detail")!=-1)
		{
			logging("Trigger Hash Change: message detail");
			//get page id
			var temp=location.hash.split("_");
			var id=temp[2];
			logging("load message detail id=>"+id);
			//logging("current tab=>"+$("#tabs").tabs("option","selected"));
			//get the page id for messages
			var page_messages=getIdByName('tab_messages');
			//reload the tab
			$("#tabs").tabs("url",page_messages,appPath+"message_detail/"+id);
			//select tab
			logging("SELECT MESSAGES");
			$("#tabs").tabs("select",page_messages);
			$("#tabs").tabs("load",page_messages);
			//initialize component
			//$("textarea").autosize();
		}
		else if(location.hash.search("#search_page")!=-1)
		{
			//get page id
			var temp=location.hash.split("_");
			var id=temp[2];
			logging("load search page=>"+id);
			//load the data using ajax
			
			//create new div to put the data
			$('#mask').append('<div class="nextdata">TEST</div>');
			
			//show transition effect
			transit('#mask');
		}
		else if(location.hash.search("#portfolio_item")!=-1)
		{
			//get page id
			var temp=location.hash.split("_");
			var id=temp[2];
			var tabBoardIndex=getIdByName("tab_manage_board");
			logging("open portfolio=>"+id);
			//change tab url
			$("#tabs").tabs("url",tabBoardIndex,appPath+"board/"+id);
			//show tab
			$("#tabs").tabs("select",tabBoardIndex);
		}
		else if(location.hash.search("#portfolio_page")!=-1)
		{
			//get page id
			var temp=location.hash.split("_");
			var id=temp[2];
			logging("show portfolios page=>"+id);
			
			//TODO get data using ajax
			
			//show transition effect
			transit('#portfolio_mask');
		}
		else if(location.hash.search("#board_item")!=-1)
		{
			//get page id
			var temp=location.hash.split("_");
			var id=temp[2];
			logging("show board item=>"+id);
			
			loadPopup(appPath+"board_detail/"+id); //show popup
		}
		else if(location.hash.search("#board_page")!=-1)
		{
			//get page id
			var temp=location.hash.split("_");
			var id=temp[2];
			logging("show board page=>"+id);
			
			//show transition effect
			transit('#board_mask');
		}
		else if(location.hash.search("#edit_board")!=-1)
		{
			//get page id
			var temp=location.hash.split("_");
			var id=temp[2];
			logging("edit board=>"+id);
			$("#tabs").tabs("select","tab_create_board");
		}
		else if(location.hash.search("#rating_designer")!=-1)
		{
			//parse the id
			var temp=location.hash.split("_");
			var id=temp[2];
			//
			logging("rating=>"+id);
			$("#tabs").tabs("select","tab_rating_designer");
		}
		else if(location.hash.search("#rating_company")!=-1)
		{
			//parse the id
			var temp=location.hash.split("_");
			var id=temp[2];
			//
			logging("rating=>"+id);
			$("#tabs").tabs("select","tab_rating_company");
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
			$("#tabs").tabs("url",page_design_wall,appPath+"console/design_wall/"+page+"/"+sort_column+"/"+sort_direction);
			//select tab
			logging("SELECT DESIGN WALL");
			$("#tabs").tabs("select",page_design_wall);
			$("#tabs").tabs("load",page_design_wall);
		}
		else
		{
			logging("close");
			if(isViewerOpened==true)
			{
				closepopup();
			}
		}
	});
	$(window).hashchange(); //trigger hash change event
	
	//resize event event listener==================================================
	$(window).resize(function()
	{
		resize();
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
		$("#tabs").tabs("select","tab_messages");
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
		loadPopup(appPath+"console/referrals");
	});
	
	
	//Home for both=======================================================================
	$("#update_membership").live("click",function() //update membership event
	{
		logging("update membership");
		//show popup
		loadPopup(appPath+"membership");
	});
	$("#update_new").live("click",function(e) //update new picture event
	{
		logging("update new image");
		loadUploadPopup(appPath+"uploadPictures","jpg");
	});
	$("#manage_referrals").live("click",function(e)
	{
		logging("manage referrals");
		loadPopup(appPath+"console/manage_referrals");
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
		logging("save company");
		//serialize the form
		
	});
	$("#cancel_company").live("click",function(e)
	{
		logging("cancel company");
		$("#tabs").tabs("select",0);
	});
	
	//Home for designer----------------------------------------------------
	//event handler
	$("#edit_profile_designer").live("click",function(e)
	{
		$("#tabs").tabs("select","tab_designer_home_edit_mode");
	});
	$("#save_designer").live("click",function(e)
	{
		logging("save designer");
	});
	$("#cancel_designer").live("click",function(e)
	{
		logging("cancel designer");
		$("#tabs").tabs("select",0);
	});
	//End of home========================================================================
	
	//DESIGN WALL========================================================================
	$("#select_sort_design_wall").live("change",function(e)
	{
		logging("SORT=>"+e.currentTarget.value);
		//get the value of sorting and direction
		var sort_column=e.currentTarget.value;
		var sort_direction=1;
		location.hash="#design_wall_1_"+sort_column+"_"+sort_direction;
	});
	//End of design wall=================================================================
	
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
	
	//End of messages tab===============================================================================================
	
	//Message Detail Tab==========================================================================
	$("#message_detail a").live("click",function(event) //when user click the reply link, replace the reply link into reply function
	{
		var layout;
		logging("Reply=>"+event.target.parentNode.id);
		var target="#"+event.target.parentNode.id; //the id of target
		//get sender name========================================
		var temp=target.split("_");
		var id=temp[1]; //get its index number
		var sender=$("#sender_"+temp[1]).html(); //retrieve the sender name
		layout='<form><div class="icon">icon</div><div class="entry"><div class="poster">Designer (Reply to '+sender+')</div><div class="upArrow"><img src="resource/Arrow.gif" /></div><div class="context"><textarea name="reply_'+temp[1]+'" cols="38" rows="4" class="nonresizable"></textarea></div></div></form>';
		//change layout
		$(target).html(layout); //set the layout data to the specific area id="reply_(id)".
		$(target).toggleClass("reply"); //change css style
		//init autosize again when new text area comes in
		$('#message_detail textarea').autosize();
	});
	$("#back_to_messages").live("click",function(e)
	{
		logging("Back to messages");
	});
	$("#messages_select_all").live("click",function(e) //check all checkbox in messages tab
	{
		$(".form_message_check").attr("checked","checked");
	});
	$("#messages_select_none").live("click",function(e) //uncheck all checkbox in messages tab
	{
		$(".form_message_check").removeAttr("checked");
	});
	//End of message detail tab=======================================================================
	
	//Create Board tab================================================================================
	$("#upload_ai").live("click",function(e)
	{
		logging("upload ai");
		//show upload popup
		loadUploadPopup(appPath+"uploadPictures","ai");
	});
	$("#form_board").live("change",function(e)
	{
		
	});
	$("#new_portfolio").live("click",function(e)
	{
		logging("new portfolio");
	});
	$('[type="radio"]').live("click",function(e)
	{
		//parse the id
		var temp=e.currentTarget.id.split("_");
		clear();
		//set target
		$("#"+temp[1]+"_"+temp[2]).html('<input name="saletype_'+temp[2]+'_cost" type="text" id="form_saletype_'+temp[2]+'_cost" class="cost"/>');
	});
	$("#create_board_calculate").live("click",function(e)
	{
		calculate();
	});
	$("#create_board_clear").live("click",function(e)
	{
		clear(true);
	});
	$(".cost").live("change",function(e)
	{
		calculate();
	});
	$("#save_create_board").live("click",function(e)
	{
		logging("save create board");
		calculate();
		//fetch the price
		var price="0.0";
		for(var i=1;i<=4;i++)
		{
			if($("#form_saletype_"+i).attr("checked")=="checked")
			{
				//get the price that user input
				price=$("#form_saletype_"+i+"_cost").val();
			}
		}
		$.ajax(
		{
			url: appPath+"create_board",
			type: "POST",
			data: $("#form_create_board").serialize()+"&price="+price,
			success: function(result)
			{
				logging(result);
			}
		});
	});
	$("#publish_create_board").live("click",function(e)
	{
		logging("publish create board");
	});
	$("#cancel_create_board").live("click",function(e)
	{
		logging("cancel create board");
		$("#tabs").tabs("select","tab_manage_board");
	});
	function calculate()
	{
		//calculate the final price
		for(var i=1;i<=4;i++)
		{
			if($("#form_saletype_"+i).attr("checked")=="checked")
			{
				//get the price that user input
				var price=$("#form_saletype_"+i+"_cost").val();
				//get F4G rate
				var rate=parseFloat($("#f4g_rate").val());
				var final=price*(1.0+rate);
				$("#saletype_"+i+"_final").html(final.toFixed(2));
				//fill in the final price in the form
				$("#form_final_price").val(final);
			}
		}
	}
	function clear(uncheck)
	{
		//reset all fields
		for(var i=1;i<=4;i++)
		{
			$("#saletype_"+i).html("0000.00");
			$("#saletype_"+i+"_final").html("0000.00");
		}
		if(uncheck==true)
		{
			//uncheck all
			$('[type="radio"]').removeAttr("checked");
		}
		//clear the form data
		$("#form_final_price").val("0");
	}
	//End of create board tab====================================================================================
	
	//Create a portfolio tab=====================================================================================
	$("#save_create_portfolio").live("click",function(e)
	{
		logging("save create portfolio");
		//save the portfolio bu ajax call
		$.ajax(
		{
			url: appPath+'create_portfolio',
			type: "POST",
			data: $('#form_create_portfolio').serialize(),
			success: function(result)
			{
				logging(result);
			}
		});
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
	});
	//End of create a portfolio tab==============================================================================
	
	//Activity tab===============================================================================================
	$("#chart_today").live("click",function(e)
	{
		logging("show today");
		//reload the chart
		initChart(appPath+"console/chart/1");
		disableChartLink("#chart_today");
	});
	$("#chart_week").live("click",function(e)
	{
		logging("show week");
		//reload the chart
		initChart(appPath+"console/chart/7");
		disableChartLink("#chart_week");
	});
	$("#chart_month").live("click",function(e)
	{
		logging("show month");
		//reload the chart
		initChart(appPath+"console/chart/30");
		disableChartLink("#chart_month");
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
	});
	$("#manage_portfolio a").live("click",function(e)
	{
		logging("a=>"+e.currentTarget.id);
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
		//load data
		
		//push data
		
		//show transit function
		transit("#portfolio_mask");
	});
	$("#portfolio_carouselNext").live("click",function(e)
	{
		logging("portfolio next");
		
		//load data
		
		//push data
		
		//show transit function
		transit("#portfolio_mask");
		
		//change the hash
		//location.hash="#portfolio_page_1";
	});
	//End of manage portfolio tab=============================================================================
	
	//manage board tab========================================================================================
	$("#show_all_portfolios").live("click",function(e)
	{
		logging("Show all portfolio");
		$("#tabs").tabs("select","tab_manage_portfolio");
	});
	$("#portfolio_catalog").live("change",function(e)
	{
		logging("change location=>"+e.currentTarget.value);
	});
	$("#publish_manage_board").live("click",function(e)
	{
		logging("publish board");
	});
	$("#add_manage_board").live("click",function(e)
	{
		logging("add new board");
		$("#tabs").tabs("select","tab_create_board");
	});
	$("#delete_manage_board").live("click",function(e)
	{
		logging("delete selected board");
	});
	$("#clear_manage_board").live("click",function(e)
	{
		//logging("clear all");
		$("#form_boards")[0].reset(); //reset the form
	});	
	$("#manage_board a").live("mouseenter",function(e) //show effect when mouse move in target portfolio
	{
		$(this).children("div").eq(0).addClass("shadow"); //add shadow
	});
	$("#manage_board a").live("mouseleave",function(e) //show effect when mouse move out target portfolio
	{
		$(this).children("div").eq(0).removeClass("shadow"); //remove shadow
	});
	$("#board_carouselPrev").live("click",function(e)
	{
		logging("board prev");
		//load data using ajax
		
		//push data
		
		//
		transit('#board_mask');
	});
	$("#board_carouselNext").live("click",function(e)
	{
		logging("board next");
		//load data using ajax
		
		//push data
		
		//
		transit('#board_mask');
	});
	//End of manage board tab=============================================================================
	
	//Shopping cart=======================================================================================
	$("#back_to_search_result").live("click",function(e)
	{
		logging("back to results");
		$("#tabs").tabs("enable","tab_search_result"); //enable search result tab		
		$("#tabs").tabs("select","tab_search_result"); //select search result tab
		$("#tabs").tabs("disable","tab_search_criteria"); //disable search tab
	});
	$("#shopping_cart_update").live("click",function(e)
	{
		logging("shopping cart update");
	});
	$("#shopping_cart_terms").live("click",function(e)
	{
		loadPopup("terms.html");
	});
	$("#shopping_cart_checkout").live("click",function(e)
	{
		logging("check out");
	});
	//End of shopping cart================================================================================
	
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
		$("#tabs").tabs("select","tab_shopping_cart");
		closepopup(); //close popup
	});
	//board detail popup-------------------------------------
	$("#add_to_shopping_cart").live("click",function(e)
	{
		logging("add to cart");
	});
	//referral-------------------------------------
	$("#referral_submit").live("click",function(e)
 	{
		logging($("#form_referral").serialize());
		logging("referral submit");
		$.ajax(
		{
			url : appPath+"console/referrals",
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
		$("#referral_firstname_"+tableId).wrapInner('<input type="text" name="firstName" value='+$("#referral_firstname_"+tableId).html()+'></input>');
		$("#referral_lastname_"+tableId).wrapInner('<input type="text" name="lastName" value='+$("#referral_lastname_"+tableId).html()+'></input>');
		$("#referral_phone_"+tableId).wrapInner('<input type="text" name="phone" value='+$("#referral_phone_"+tableId).html()+'></input>');
		$("#referral_email_"+tableId).wrapInner('<input type="text" name="email" value='+$("#referral_email_"+tableId).html()+'></input>');
		//create link update
		var updateLink='<a href="#" class="update_referral" id="update_referral_'+tableId+'">Update</a>';
		var sendLink='<a href="#" class="send_referral" id="send_referral_'+tableId+'">Update and Send</a>';
		//change the link in action area
		$("#referral_action_"+tableId).html(updateLink+"<br />"+sendLink);
	});
	$(".update_referral").live("click",function(e)
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
		//logging($("#form_referral").serialize());
		//using the ajax to send the data to server
		$.ajax(
		{
			url : appPath+"console/manage_referrals/"+tableId,
			type : "POST",
			data: $("#form_referral").serialize(),
			success : function(result) 
			{
				logging("Send referral data success");
			}
		});
	});
	$(".send_referral").live("click",function(e)
	{
		logging("send referral=>"+e.currentTarget.id);
		//using the ajax to send the data to server
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
	//End of popup event handler==========================================================================
		
	//test link
	$("#testlink").live("click",function(e)
	{
		logging("test link");
		//loadPopup("board_detail.html");
		loadPopup("referral_manage.html");
	});
});

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
	$("#chart_today").attr("href",appPath+"console/chart/1");
	$("#chart_week").attr("href",appPath+"console/chart/7");
	$("#chart_month").attr("href",appPath+"console/chart/30");
	//disable link
	$(target).removeAttr("href");
}
function initChart(url)
{
	//JSON data structure
	/*
	[[['x label',(y value)],['x label',(y value)].....[]]]
	*/
	//var weekdays=['Mon','Tue','Wed','Thur','Fri','Sat','Sun'];
	logging("INIT CHART=>"+url);
	$.getJSON(url,function(result)
	{
		//logging(result);
		$.jqplot('activity_chart', result,
		{
			title: 'Viewed Boards',
			axesDefaults: 
			{
				tickRenderer: $.jqplot.CanvasAxisTickRenderer ,
				tickOptions: 
				{
					fontSize: '10pt'
				},
				showTickMarks: true
			},
			axes: 
			{
			  xaxis: 
			  {
				  renderer: $.jqplot.CategoryAxisRenderer,
				  tickOptions:
			      {
					  angle: -20
			      }
			  },
			  yaxis: 
			  {
				  min: 0,
				  pad: 2,
				  tickOptions:
				  {
					  angle: -20,
					  formatString: '%d'
				  },
				  showTicks: false,
				  showTickMarks: true
			  }
			},
			seriesDefaults: 
			{ 
		        showMarker:true,
		        pointLabels: { show:true } 
		    }
		}).replot();
		
	});
}
//End of chart==========================================================================
//shopping cart function================================================================
function checkShoppingCart()
{
	//check the session if there is any products in cart
	//if there are boards in shopping cart
	$("#cart_icon .cart_icon").attr("src","resource/shoppingcart_full.png"); //show the icon of full cart
	
	//if there is no boards in shopping cart 
	//$("#cart_icon .cart_icon").attr("src","resource/shoppingcart.png"); //show the icon of full cart
}
//animation of moving boards to cart-----------------------
function moveToCart(target)
{
	//get the id from tatget attribute
	var temp=target.split("_");
	//logging("id="+temp[2]); //the last item is the id
	var id=temp[2];
	//retrieve the value in hidden area
	var value=$("[name=form_add_to_cart_"+id+"]").val();
	if(value=="false") //if this board is not added to the cart, show the effect add to cart
	{
		effect_addToCart(id);
	}
	else
	{
		effect_backToMarket(id);
	}
	if(value=="true")
		value=false;
	else
		value=true;
	$("[name=form_add_to_cart_"+temp[2]+"]").val(value); //set the value
}
function effect_addToCart(target_id)
{
	//reset the stuff
	$("#stuff").css(
	{
		opacity:1,
		width:150,
		height:150
	});
	//get the location of the cart icon
	var termination=$("#cart_icon").offset();
	logging("cart:"+termination.top+":"+termination.left);
	//copy the target html to stuff
	$("#stuff").html($("#board_"+target_id).html());
	//logging("st="+$("#stuff").html());
	//get the start point
	var start=$("#board_"+target_id).offset();
	logging("cart:"+start.top+":"+start.left);
	//set the initial status
	$("#stuff").css(start);
	$("#stuff").css("display","block"); //show the block
	$('#body').css("cursor","progress");
	$('.add_to_cart').css("cursor","progress");
	//show the effect that moves to the shopping cart
	$("#stuff").animate(
	{
		top: termination.top+8,
		left: termination.left+50,
		width:0,
		height:0
	},1500,'swing',function()
	{
		$("#stuff").css("opacity","0"); //hide the stuff div
		//chage cart icon that is added to cart
		$("#add_board_"+target_id).toggleClass("added_to_cart");
		$('#body').css("cursor","default");
		$('.add_to_cart').css("cursor","pointer");
		checkShoppingCart();
	});
}
function effect_backToMarket(target_id)
{
	//reset the stuff
	$("#stuff").css(
	{
		opacity:1,
		width:0,
		height:0
	});
	//get the location of the cart icon
	var start=$("#cart_icon").offset();
	logging("cart:"+start.top+":"+start.left);
	//copy the target html to stuff
	$("#stuff").html($("#board_"+target_id).html());
	//logging("st="+$("#stuff").html());
	//get the start point
	var termination=$("#board_"+target_id).offset();
	logging("cart:"+termination.top+":"+termination.left);
	//set the initial pos
	$("#stuff").css(start);
	$('#body').css("cursor","progress");
	$('.add_to_cart').css("cursor","progress");
	//show the effect that moves to the shopping cart
	$("#stuff").animate(
	{
		top: termination.top,
		left: termination.left,
		width:148,
		height:98
	},1500,'swing',function()
	{
		$("#stuff").css("display","none"); //hide the stuff div
		//chage cart icon that is added to cart
		$("#add_board_"+target_id).toggleClass("added_to_cart");
		$('#body').css("cursor","default");
		$('.add_to_cart').css("cursor","pointer");
	});
}
//carousel view==================================================//
function transit(target) //show the transition  effect on content
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
		url: appPath+"console/sidebar",
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
			$("#sidebarToggle").find("img").attr("class","rightArrow");
			$("#sidebarContent").fadeIn("fast");
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
				$("#sidebarToggle").find("img").attr("class","leftArrow");
			});
		});
		isOpened=false;
	}
}

//update viewer
/*function updateViewer(id)
{
	//close the previous dialog
	$.ajax(
	{
		url:"viewer.html",
		beforeSend: function()
		{
			logging("loading "+this.url);
		},
		success:function(result)
		{
			logging("loading complete");
			data=target.split("-");
			currentIndex=data[1];
			logging("currentIndex=>"+currentIndex);
			$("#dialog").html(result);
			//show div
			$(".popupContent").css("display","block");
		}
	});
}*/
//==========resize event handler================================//
function resize()
{
	//set the offset of footer
	x=$("#tabs").offset();
	var footerOffset=x.top+$("#tabs").height();
	logging("tabs="+x.top+" : tabs="+$("#tabs").height());
	$("#footer").animate({"top":footerOffset},"fast");
}

//show viewer======================================================
function showWindow()
{
	//loading data using ajax
	/*
	$.ajax(
	{
		url:"viewer.html?id=123", //id in database
		beforeSend: function()
		{
			logging("loading "+this.url);
		},
		success:function(result)
		{
			logging("loading complete");
			$("#dialog").html(result);
			//show div
			$(".popupContent").css("display","block");
			//set the prev and next link
			//get the index
			var index=new Number(location.hash.replace("#nail",""));
			var prevIndex=index-1;
			var nextIndex=index+1;
			if(prevIndex-1<1)
			prevIndex=1;
			$("#prevItem").attr("href","#nail"+prevIndex);
			$("#nextItem").attr("href","#nail"+nextIndex);
			//set the data
		}
	});
	
	//open the dialog
	$("#dialog").dialog(
	{
		show:"scale",
		hide:"scale",
		modal:true,
		maxWidth:1024,
		maxHeight:800,
		minWidth:900,
		minHeight:600
	});*/
	loadPopup("board_detail.html");
	isViewerOpened=true;
}

//put test data in search panel
/*function test()
{
	var data="";
	data+="<ul><li>";
	for(i=1;i<=15;i++)
		data+='<div class="nail" id="item'+i+'"><div class="name">pic'+i+'</div><div class="check"><input name="" type="checkbox" value="" /></div><a href="#nail'+i+'"><div class="pic"></div></a><div class="nailfunctions">email</div><div class="detail">123.58</div></div>';
	data+="</li>";
	data+="<li>";
	for(i=16;i<=30;i++)
		data+='<div class="nail" id="item'+i+'"><div class="name">pic'+i+'</div><div class="check"><input name="" type="checkbox" value="" /></div><a href="#nail'+i+'"><div class="pic"></div></a><div class="nailfunctions">email</div><div class="detail">123.58</div></div>';
	data+="</li>";
	data+="<li>";
	for(i=31;i<=45;i++)
		data+='<div class="nail" id="item'+i+'"><div class="name">pic'+i+'</div><div class="check"><input name="" type="checkbox" value="" /></div><a href="#nail'+i+'"><div class="pic"></div></a><div class="nailfunctions">email</div><div class="detail">123.58</div></div>';
	data+="</li>";
	data+="</ul>";
	$("#search_result_content").html(data);
}*/

//debug function, continue to record the data
function logging(data)
{
	if(debugMode)
		$("#debug").css("display","block");
	if(data==undefined || data=="")
		$("#debug").append("Undefined or blank <br />");	
	$("#debug").append(data+"<br />");
	$("#debug").scrollTop($("#debug")[0].scrollHeight);
}