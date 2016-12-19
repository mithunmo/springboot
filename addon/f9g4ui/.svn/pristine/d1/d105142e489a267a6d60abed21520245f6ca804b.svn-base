<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<script>
	$(document).ready(function()
	{
		var ratyImgPath="/images/raty_img";
		//initialize the rating plugin
		logging("init raty","#F00");
		//get all rating items into an array
		var initTarget=$("#popupRating .readonly").toArray();
		logging("array length"+initTarget.length);
		//get value from value div
		for(var i=0;i<initTarget.length;i++)
		{
			logging("SET RATY"+$("#"+initTarget[i].id+"_value").html());
			//set value to display star
			$("#"+initTarget[i].id).raty(
			{
				path: ratyImgPath,
				space: true,
				width: "100px",
				readOnly: true,
				score: $("#"+initTarget[i].id+"_value").html()
			});
		}
	});
</script>
<!---set specific id to set  popup width-------->
<div class="popup" id="userinfo_company">
	<div class="header">
	Company Profile
		<div class="close">X</div>
	</div>
<!---Set id to fill in data--->
    <div class="content" id="popup_userinfo">
		<div id="userInfoLogo">
			<div class="userLogo"><i></i><img src="${userProfile.logoImageUrl}" /></div>
		</div>
		<div id="userInfoDetail">
				<div class="row" style="width:350px;">
					<div class="info_block">
						<div class="head"><span id="profile_userName">${userProfile.firstName}&nbsp;&nbsp;${userProfile.lastName}</span></div>
						<div class="context">
							<span id="profile_userCountry">${userProfile.countryName}</span>
							<br />
							${userProfile.companyName}
							<br />
							<a href="${userProfile.website}" target="_blank">${userProfile.website}</a>
						</div>
					</div>
				</div>
				<div class="row" style="width:350px;">
					<div class="info_block">
						<div class="head">Rating</div>
						<div class="context" id="popupRating">
							<div class="overall">Overall rating CT</div>
				          	<div class="readonly" id="userinfo_rate_overall"></div>
				            <div class="value" id="userinfo_rate_overall_value">${overallRating}</div>
				            <c:forEach var="item" items="${rate1}">
				           		<c:if test="${item.lookupCode == question1Type}">
						            <div class="partial">${item.description}</div>
						            <div class="readonly" id="userinfo_rate_quality_of_work"></div>
						            <div class="value" id="userinfo_rate_quality_of_work_value">${rating1}</div>
					            </c:if>
				            </c:forEach>
				            <c:forEach var="item" items="${rate2}">
				            	<c:if test="${item.lookupCode == question2Type}">
				            		<div class="partial">${item.description}</div>
				            		<div class="readonly" id="userinfo_rate_pricing"></div>
				            		<div class="value" id="userinfo_rate_pricing_value">${rating2}</div>
				            	</c:if>
				           	</c:forEach>
				            <c:forEach var="item" items="${rate3}">
				            	<c:if test="${item.lookupCode == question3Type}">
				            		<div class="partial">${item.description}</div>
				            		<div class="readonly" id="userinfo_rate_reliability"></div>
				            		<div class="value" id="userinfo_rate_reliability_value">${rating3}</div>
				            	</c:if>
				            </c:forEach>
				            <c:forEach var="item" items="${rate4}">
				            	<c:if test="${item.lookupCode == question4Type}">
				            		<div class="partial">${item.description}</div>
				            		<div class="readonly" id="userinfo_rate_customization"></div>
				            		<div class="value" id="userinfo_rate_customization_value">${rating4}</div>
				            	</c:if>
				            </c:forEach>
						</div>
					</div>
				</div>
		</div>
	</div>
</div>
<!---end of content----------->