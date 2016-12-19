// JavaScript Document
var basicConfig = { 
	"debugMode":false, //set to true to enable debug panel
	"writeLogToConsole":false,
	"disableRightClick":false, 
	"enableSorting":true,
	"enableSSE":true
};
var appConfig = { 
	"ver":1.0, 
	"ratyImgPath":"/images/raty_img",
	"sidebarCloseDuration":5000 //in milliseconds
};
/*Idle timer parameters*/
var idleTimerConfig = { "idleTime":1500, "pollingTime":300, "warningTime":300, "idleTimeoutDebugMode":false};
var globalVars = {
	"isWindowFocus":false,
	"hasClicked":0,
	//flag to determine the user change the data without submit
	"isChangedWithoutSubmit":false,
	"isSidebarOpened":false,
	"title":document.title,
	"sidebarTimer":null,
	"lockObject":0
};

//empty message html layout
var layoutTemplate = {
"emptyPortfolioMsg":'<div class="empty" style="width:320px;"><i></i><span><a href="javascript:void(0)" id="add_manage_portfolio" style="color:#C30">Click here</a>&nbsp;to create your first portfolio!</span></div>',
"emptyBoardMsg":'<div class="empty"><i></i><span><a href="javascript:void(0)" id="add_manage_board" style="color:#C30">Click here</a>&nbsp;to create your first board!</span></div>',
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
"optionEmpty":'<option value="-1">--Empty--</option>',
"optionEmptyWithDisabledAttr":'<option value="-1" disabled="disabled">--Empty--</option>',
"emptyPage":'<div class="empty"><i></i><span>Empty Page<br />Please Select Another Page</span></div>',
"loadingPopup":'<span style="color:blue;">Please wait....<span><br /><img src="/images/spinner_small.gif" style="margin-top:30px;"/>',
"sidebarLoading":'<div class="sidebar-loading"/>'
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
$(document).on("click",".button",function(e) {
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
	var initTag=['.text-wrapper','.item-label','.detail .board_name','.messageBoardId','.drawer_boardId','.checkoutBoardId','.messageDetailBoardId','.detail .name','.designWallBoardId','#designWallTiles .touchArea','.designerAccountBoardId','.boards_suggestion_boardId','.gridBoardId','span[title]'];
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
	$(document).on("change","#form_edit_profile input, #form_edit_profile select",function()
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
					"#tab_alerts":function() {
						$("#tab_alerts").html(layoutTemplate.basicConsoleFrame); //show loading message
						location.hash='#alerts';
						$("#tabs").tabs("load",getIdByName("tab_alerts"));
					},
					"#tab_get_full_access_messages":function() {
						location.hash="#get_full_access/messages";
						$("#tab_get_full_access_messages").html(layoutTemplate.basicConsoleFrame); //show loading message
					},
					"#tab_get_full_access_portfolio":function() {
						location.hash="#get_full_access/portfolio";
						$("#tab_get_full_access_portfolio").html(layoutTemplate.basicConsoleFrame); //show loading message
					},
					"#tab_get_full_access_collections":function() {
						location.hash="#get_full_access/collections";
						$("#tab_get_full_access_collections").html(layoutTemplate.basicConsoleFrame); //show loading message
					},
					"#tab_get_full_access_account":function() {
						location.hash="#get_full_access/account";
						$("#tab_get_full_access_account").html(layoutTemplate.basicConsoleFrame); //show loading message
					},
					"#tab_get_full_access_activity":function() {
						location.hash="#get_full_access/activity";
						$("#tab_get_full_access_activity").html(layoutTemplate.basicConsoleFrame); //show loading message
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
				"#tab_home_edit_mode":function() {
					editProfileTabHandler($(ui.tab));
					$('#profileScore').qtip('show');
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
				"#tab_home":function() {
					//init scroll bar if there exsit
					$("#skill_scrollbar").tinyscrollbar();
					$("#lang_scrollbar").tinyscrollbar();
					$("#about_you_scrollbar").tinyscrollbar();
					$("#misc_scrollbar").tinyscrollbar();
					$("#adoc_scrollbar").tinyscrollbar();
				},
				"#tab_home_edit_mode":function() {
					logging("init multiselect");
					editProfileTabHandler($(ui.tab));
					$('#profileScore').qtip('show');
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
	//if the hash is empty string, select the messages tab
	if(location.hash=="") {
		$("#tabs").tabs("select","tab_get_full_access_messages"); //select messages tab first
	}
	
	//Search criteria ===================================================================
	//End of search criteria===========================================================
	
	//Search Result click and button event==============================================
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
		//change hash
		triggerHash("#get_full_access/messages");
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
					$('#form_logo_image_url').trigger('change'); //trigger input change event.
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
	/*$(document).on('change','#form_education_other, #form_specialty_other, #form_expertise_other',function(e) {
		console.log($(this).prev());
	});*/
	//End of home========================================================================
	
	//DESIGN WALL========================================================================
	//End of design wall=================================================================
	
	//DESIGNER ACCOUNT===================================================================
	//End of designer account============================================================
	
	//Rating=============================================================================
	//End of rating======================================================================
	
	//Messages Tab=======================================================================
	//End of messages tab================================================================
	
	//Message Detail Tab=================================================================
	//End of message detail tab==========================================================
	
	//Create Board tab===================================================================
	//End of create board tab============================================================
	
	//Create a portfolio tab=============================================================	
	//End of create a portfolio tab======================================================
	
	//Activity tab=======================================================================
	//End of activity tab================================================================
	
	//Manage portfolio tab===============================================================
	//End of manage portfolio tab========================================================
	
	//manage board tab===================================================================
	//End of manage board tab============================================================
	
	//Check out tab======================================================================
	//End of check out===================================================================
	
	//popup event handler=================================================================================
	//shopping cart popup-------------------------------------
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
});

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
	if(currentHash.search("#rating")!=-1)
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
	else if(currentHash.search("#alerts")!=-1)
	{
		var tabAlerts=getIdByName("tab_alerts");
		if(tabAlerts!=-1) {
			$("#tabs").tabs("select",tabAlerts);
			$("#tabs").tabs("load",tabAlerts);
		}
		else {
			buildPopupMsg({
				"content":"Please complete your profile to get full access.",
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
	else if(currentHash.search("#edit_designer_profile")!=-1)
	{
		$("#tabs").tabs("select","tab_home_edit_mode");
	}
	else if(currentHash.search("#get_full_access")!=-1) {
		var tab=$.url().fsegment(2);
		$("#tabs").tabs("select","tab_get_full_access_"+tab);
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
	}
	else {
		closePopup();
	}
}
//End of hash change==================================================================================

//Tab function========================================================================================
function getIdByName(target)
{
	//get id by name
	//var relTable=$("#tabs").children('div');
	var relTable=$('#tabs').data('tabs').anchors;
	for(var i=0;i<relTable.length;i++)
	{
		if(relTable[i].title==target)
			return i;
	}
	return -1;
}
//End of tab function==================================================================================

//Chart================================================================================================
//End of chart=========================================================================================

//shopping cart function===============================================================================

//function for board===================================================================================
//End of board related function========================================================================

//Board Level List getter==============================================================================
//End of board level list getter=======================================================================

//Search Result related functions======================================================================
//End of search result=================================================================================

//portfolio related functions==========================================================================
//End of portfolio related function====================================================================

//Idle Timer===========================================================================================
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
			//first param: the popup you want to close, second param: the overlayId you want to hide, third param: flag to clean container
			isChangedWithoutSubmitOnPopup=false;
			closePopup("#session_expire","#session_overlay",false); //fixed the issue of the popup content is removed when close the popup.
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

//logout===============================================================//
function logout()
{
	$.idleTimeout.options.onTimeout.call(this);
}
//=====================================================================//

//raty plugin==========================================================//

//carousel view========================================================//

//==================SIDEBAR============================================//
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

//TilesView functionality=========================================================================//

//Send Message and message detail=================================================================//
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
				$("#title").animate({height:'85px'},function() {
					$('#profileScore').qtip('reposition'); //update the qtip position
				});
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
				$("#title").animate({height:'129px'},function() {
					$('#profileScore').qtip('reposition'); //update the qtip position
				});
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
	$(id).removeClass("mselect-hidden");
	$(id).multiselect({
		addText: '',
		size: 3,
		toggleAddButton: false,
		height: 100
	});
	if($(id+" ~ .mselect").length>1)
		$(id+" ~ .mselect:gt(0)").remove();
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
	$opt.prop("selected", true);
	$input.val("");
	$select.prepend($opt).multipleSelect("refresh");
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
	if($('#aboutYou').val().replace(/ /g,'')!=='') {
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
	if($('#misc').val().replace(/ /g,'')!=='') {
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