var htmlTemplate = {
"emptyPortfolioMsg":'<div class="empty" style="width:320px;"><span><a href="javascript:void(0)" id="add_manage_portfolio" style="color:#C30">Click here</a>&nbsp;to create your first portfolio!</span></div>',
"emptyBoardMsg":'<div class="empty"><span><a href="javascript:void(0)" id="add_manage_board" style="color:#C30">Click here</a>&nbsp;to create your first board!</span></div>',
"loadingMsg":'<div class="loadingSpinner"><span><img src="/images/spinner.gif" /></span></div>',
"basicConsoleFrame":'<div class="left">'
	+'<div class="searchTitle"></div>'
	+'</div>'
	+'<div class="right">'
	+'<div class="rightCurve"></div>'
	+'</div>'
	+'<div class="contentFrame" >'
	+'<div class="content" id="messages">'
	+'<div class="loadingSpinner"><span><img src="/images/spinner.gif" /></span></div>' //loadingMsg
	+'</div>'
	+'</div>',
"errorStyle":"color:#FF0000",
/*Message List*/
"optionDefaultMsg":'<option value="-1">-Please select one option-</option>',
"optionLoadingMsg":'<option value="-1">Loading...</option>'
};
var rePhoneInteger = /^[(]{0,1}[0-9]{3}[)]{0,1}[-\s.]{0,1}[0-9]{3}[-\s.]{0,1}[0-9]{4}$/;

var reInteger = /^\d+$/;

var errorStyle= htmlTemplate.errorStyle;

function isInteger (s)
{ 
    return reInteger.test(s)
}

function isIntegerwithLength (s,len)
{ 
    return reInteger.test(s);
}

function isPhoneInteger (s)
{ 
    return rePhoneInteger.test(s);
}

function HighlightLabelandPushError(errors,label,errorMsg)
{
	errors.push(errorMsg);
	$(label).attr("style",errorStyle);
	return errors;
}

function CheckforNullandSpace(control,errors,label,errorMsg)
{
	if($(control).val()=="" || $(control).val().search(" ")!=-1){
		errors.push(errorMsg);
		$(label).attr("style",errorStyle);
	}
		
	return errors;
}

function CheckforNull(control,errors,label,errorMsg)
{
	if($(control).val()==""||$(control).val()==null){
		errors.push(errorMsg);
		$(label).attr("style",errorStyle);
	}
		
	return errors;
}

function CheckforNullPushtoElement(control,errors,label,errorMsg)
{
	if($(control).val()==""||$(control).val()==null){
		errors.push(errorMsg);
		$(label).html(errorMsg);
	}
		
	return errors;
}

function CheckforNullinSelect(control,errors,label,errorMsg)
{
	if($(control).val()==null){
		errors.push(errorMsg);
		$(label).attr("style",errorStyle);
	}
		
	return errors;
}

function CheckforNullandPhoneNumber(control,errors,label,errorMsg)
{
	//please enter 
	if($(control).val()=="")
	{
		errors.push("Please enter " + errorMsg);
		$(label).attr("style",errorStyle);
	}
	
	if($(control).val()!=""&&!isPhoneInteger ($(control).val())){
		errors.push("Please enter a valid 10 digit " + errorMsg +".");
		$(label).attr("style",errorStyle);
	}
	return errors;
}

function CheckforNullandNumber(control,errors,label,errorMsg)
{
	if($(control).val()==""||!isInteger($(control).val())){
		errors.push(errorMsg);
		$(label).attr("style",errorStyle);
	}
		
	return errors;
}

function CheckforNumberRange(control,errors,label,errorMsg,min,max)
{
	if($(control).val()<min||$(control).val()>max){
		errors.push(errorMsg);
		$(label).attr("style",errorStyle);
	}
		
	return errors;
}

function CheckforNegative(control,errors,label,errorMsg)
{
	if($(control).val()<0){
		errors.push(errorMsg);
		$(label).attr("style",errorStyle);
	}
	return errors;
}

function CheckforContainSpace(control,errors,label,errorMsg)
{
	if($(control).val().search(/\s/g)!=-1){
		errors.push(errorMsg);
		$(label).attr("style",errorStyle);
	}
	return errors;
}

function trim (myString)     
{     
    return myString.replace(/^s+/g,'').replace(/s+$/g,'')     
}