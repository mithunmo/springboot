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
<div class="popup" id="userinfo">
	<div class="header">
	Designer Profile
		<div class="close">X</div>
	</div>
<!---Set id to fill in data--->
    <div class="content" id="popup_userinfo">
    	<div id="basicInfo">
    		<div class="userLogo" id="popup_designer_info_logo"><i></i><img src="${userProfile.logoImageUrl}" /></div>
    		<div class="info_block" id="popup_dsigner_info_profile">
				<div class="head"><span id="profile_userName">${userProfile.finalName}</span></div>
				<div class="context">
					<span id="profile_userCountry">${userProfile.countryName}</span>
					<br />
					${userProfile.companyName}
					<br />
					<a href="${userProfile.website}" target="_blank">${userProfile.website}</a>
				</div>
			</div>
			<div class="info_block" id="popup_designer_info_rating">
				<div class="head">Rating</div>
				<div class="context" id="popupRating">
					<div class="overall">Overall rating DG</div>
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
    	<div id="detailInfo">
    		<div class="ie7inline" style=" ">
	    		<div class="info_block" id="popup_designer_info_misc">
            		<div class="head">Schools,&nbsp;Awards,<br/>Events,&nbsp;Speciality,&nbsp;etc.</div>
            		<div id="info_block_misc_context">
            			<div class="entity" id="userinfo_misc_scrollbar">
							<div class="scrollbar" id="userinfo_misc_scrollbar_entity"><div class="track"><div class="thumb" style="top: 0px; height: 49.33555555555556px; "><div class="end"></div></div></div></div>
							<div class="viewport">
								<div class="overview" id="industryNews" style="top: 0px;">
									<c:if test="${!empty userDetail.education}">
										<b>Education:</b>
										<ul>
											<c:forEach var="item" items="${userDetail.education}">
												<li>${item.educationName}</li>
											</c:forEach>
										</ul> 
									</c:if>
									<c:if test="${!empty userDetail.specialty}">
										<b>Specailty:</b>
										<ul>
											<c:forEach var="item" items="${userDetail.specialty}">
												<li>${item.specialitiesName}</li>
											</c:forEach>
										</ul>
									</c:if>
									<c:if test="${!empty userDetail.expertise}">
										<b>Expertise:</b>
										<ul>
											<c:forEach var="item" items="${userDetail.expertise}">
												<li>${item.expertiseName}</li>
											</c:forEach>
										</ul>
									</c:if>
									<c:if test="${!empty userDetail.degAcc}">
										<b>Degrees and Accreditations:</b>
										<ul>
											<c:forEach var="item" items="${userDetail.degAcc}">
												<li>${item.degaccsName}</li>
											</c:forEach>
										</ul>
									</c:if>
									<c:if test="${!empty userDetail.yrsExp.description}">
										<b>Years of experience:</b> ${userDetail.yrsExp.description}
										<br />
									</c:if>
									<c:if test="${!empty userDetail.companiesWorked}">
										<b>Companies worked:</b> ${userDetail.companiesWorked}
										<br />
									</c:if>
									${userProfile.misc}
								</div>
							</div>
						</div>
            		</div>
			    </div>
			    <div class="info_block" id="popup_designer_info_languages">
            		<div class="head">Languages</div>
            		<div class="context">
            			<div class="entity" id="userinfo_lang_scrollbar">
							<div class="scrollbar" id="userinfo_lang_scrollbar_entity"><div class="track"><div class="thumb" style="top: 0px; height: 49.33555555555556px; "><div class="end"></div></div></div></div>
							<div class="viewport">
								<div class="overview" id="industryNews" style="top: 0px;">
									<ul>
	            						<c:forEach var="item" items="${userProfile.languagesName}"><li>${item}</li></c:forEach>
	            					</ul>
								</div>
							</div>
						</div>
            		</div>
		        </div>
		    </div>
	    	<div class="info_block" id="popup_designer_info_about_you">
	          	<div class="head">About You</div>
              	<div class="context">
	              	<div class="entity" id="userinfo_about_you_scrollbar">
						<div class="scrollbar" id="userinfo_about_you_scrollbar_entity" style="height: 281px; "><div class="track" style="height: 281px; "><div class="thumb" style="top: 0px; height: 49.33555555555556px; "><div class="end"></div></div></div></div>
						<div class="viewport">
							<div class="overview" id="industryNews" style="top: 0px;">
								${userProfile.aboutYou}
							</div>
						</div>
					</div>
           		</div>
	        </div>
		    <div class="info_block" id="popup_designer_info_skills">
		        <div class="head">Skills</div>
	        	<div class="context">
	        		<div class="entity" id="userinfo_skill_scrollbar">
						<div class="scrollbar" id="userinfo_skill_scrollbar_entity" style="height: 281px; "><div class="track" style="height: 281px; "><div class="thumb" style="top: 0px; height: 49.33555555555556px; "><div class="end"></div></div></div></div>
						<div class="viewport">
							<div class="overview" id="industryNews" style="top: 0px;">
								<ul>
		            				<c:forEach var="item" items="${userProfile.skillsName}"><li>${item}</li></c:forEach>
		           	 			</ul>
							</div>
						</div>
					</div> 
	            </div>
		   	</div>
    	</div>
    	
    	
		<%-- <div id="userInfoLogo">
			<div class="userLogo"><i></i><img src="${userProfile.logoImageUrl}" /></div>
			<div class="row">
	           	<div class="info_block" id="info_block_about_you">
	           		<div class="head">About You</div>
	               		<div class="context">
		           			${userProfile.aboutYou}
		           		</div>
	           	</div>
	       	</div>
		</div>
		<div id="userInfoDetail">
				<div class="row" style="width:300px;">
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
				<div class="row" style="width:300px;">
					<div class="info_block">
						<div class="head">Rating</div>
						<div class="context" id="popupRating">
							<div class="overall">Overall rating DG</div>
					        <div class="readonly" id="userinfo_rate_overall"></div>
					        <div class="value" id="userinfo_rate_overall_value">${overallRating}</div>
					        <div class="partial">Quality of work</div>
					        <div class="readonly" id="userinfo_rate_quality_of_work"></div>
					        <div class="value" id="userinfo_rate_quality_of_work_value">${qualityRating}</div>
					        <div class="partial">Pricing</div>
					        <div class="readonly" id="userinfo_rate_pricing"></div>
					        <div class="value" id="userinfo_rate_pricing_value">${priceRating}</div>
					        <div class="partial">Reliability</div>
					        <div class="readonly" id="userinfo_rate_reliability"></div>
					        <div class="value" id="userinfo_rate_reliability_value">${reliabilityRating}</div>
					        <div class="partial">Customization</div>
					        <div class="readonly" id="userinfo_rate_customization"></div>
					        <div class="value" id="userinfo_rate_customization_value">${customizationRating}</div>
						</div>
					</div>
				</div>
		</div>
				<div id="designerDetail" style="display:inline-block; width:300px;">
					<div class="row" style="clear:left;">
		            	<div class="info_block" id="info_block_languages">
		            		<div class="head">Languages</div>
		            		<div class="context">
			            		<ul>
			            		<c:forEach var="item" items="${userProfile.languagesName}"><li>${item}</li></c:forEach>
			            		</ul>
		            		</div>
		            	</div>
		            </div>
		            <div class="row">
		            	<div class="info_block" id="info_block_skills">
		            		<div class="head">Skills</div>
		            		<div class="context">
			            		<ul>
			            		<c:forEach var="item" items="${userProfile.skillsName}"><li>${item}</li></c:forEach>
			            		</ul>
		            		</div>
		            	</div>
		            </div>
		           	<div class="row">
		            	<div class="info_block" id="info_block_misc">
		            		<div class="head">Schools,&nbsp;Awards,<br/>Events,&nbsp;Speciality,&nbsp;etc.</div>
		            		<div id="info_block_misc_context">
		            			${userProfile.misc}
		            		</div>
		            	</div>
		            </div>
				</div> --%>
	</div>
</div>
<!---end of content----------->