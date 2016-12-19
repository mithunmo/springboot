<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<%@ page import="com.f9g4.web.utils.ViewPaths" %> 

<!---Content------------------>
<div class="contentFrame" id="home_designer">
	<div class="content-function background-blue">
		<span class="profileHeader">${designerProfile.firstName}&nbsp;${designerProfile.lastName}</span>
		<div class="searchPanel" style="float: right; margin-right: 20px; margin-top: 15px;">
			<!-- <a href="#edit_designer_profile" id="edit_profile_designer">Edit Profile Information</a>&nbsp;&nbsp;|&nbsp;&nbsp;
			<a href="javascript:void(0)" id="manage_referrals">Manage Referrals</a> -->
		</div>
	</div>
	<div class="content background-white">
	    <div class="column second">
	    	<div class="homeImage">
	    		<i></i><img src="${designerProfile.logoImageUrl}" />
	    	</div>
	        <div class="row add-space-top">
	        	<div class="row">
		        	<div class="info_block" id="info_block_adoc">
		        		<div class="head">Resume/Additional Document</div>
		        		<div class="context">
					        <div class="entity" id="adoc_scrollbar">
								<div class="scrollbar" id="adoc_scrollbar_entity"><div class="track"><div class="thumb"><div class="end"></div></div></div></div>
								<div class="viewport">
									<div class="overview" id="industryNews" style="top: 0px;">
										<c:forEach var="item" items="${designerProfile.adoc_oname}" varStatus="counter" >
								        	<a href="/files/${designerProfile.adoc_iname[counter.count-1]}" target="_BLANK">${item}</a><br />
								        </c:forEach>
									</div>
								</div>
							</div>
		        		</div>
		        	</div>
	        	</div>
	        	<div class="row">
		           	<div class="info_block" id="info_block_about_you">
		           		<div class="head">About You</div>
		           		<div class="context">
		           			<div class="entity" id="about_you_scrollbar">
								<div class="scrollbar" id="about_you_scrollbar_entity"><div class="track"><div class="thumb"><div class="end"></div></div></div></div>
								<div class="viewport">
									<div class="overview" id="industryNews" style="top: 0px;">
										${designerProfile.aboutYou}
									</div>
								</div>
							</div>
		           		</div>
		           	</div>
	           	</div>
	        </div>
	    </div>
	    <div class="column threeForth">
	        <div class="column half add-space-top">
	        	<div class="row">
	        		<div class="info_block" id="info_block_address">
	        			<div class="head">Address</div>
	        			<div class="context">
	        			<c:if test="${!empty designerProfile.address1}">
	        				${designerProfile.address1}
	        				<br />
	        			</c:if>
	        			<c:if test="${!empty designerProfile.address2}">${designerProfile.address2}<br /></c:if>
	        			${designerProfile.city}<c:if test="${!empty designerProfile.state}"><c:if test="${!empty designerProfile.city}">,</c:if>${designerProfile.state}</c:if>
	        			<br />
	        			<c:if test="${!empty designerProfile.zip}">
	        				${designerProfile.zip}
	        				<br />
	        			</c:if>
	        			${designerProfile.countryName}
	        			</div>
	        		</div>
	        	</div>
	        	<div class="row">
	        		<div class="info_block" id="info_black_contact">
	        			<div class="head">Contact</div>
	        			<div class="context">
		        			${designerProfile.cellPhone}
		        			<br />
		        			${designerProfile.phone}<c:if test="${!empty designerProfile.phone_ext}">#${designerProfile.phone_ext}</c:if>
	        			</div>
	        		</div>
	        	</div>
	        	<div class="row">
	            	<div class="info_block" id="info_block_languages">
	            		<div class="head">Languages</div>
	            		<div class="context">
	            			<div class="entity" id="lang_scrollbar">
								<div class="scrollbar" id="lang_scrollbar_entity" style="height: 133px; "><div class="track" style="height: 133px; "><div class="thumb" style="top: 0px; height: 49.33555555555556px; "><div class="end"></div></div></div></div>
								<div class="viewport">
									<div class="overview" id="industryNews" style="top: 0px;">
										<c:choose>
											<c:when test="${empty designerProfile.languagesName}">
												<span style="color:#C30;">Please provide your languages.</span>
											</c:when>
											<c:otherwise>
												<ul>
				            						<c:forEach var="item" items="${designerProfile.languagesName}"><li>${item}</li></c:forEach>
				            					</ul>
			            					</c:otherwise>
		            					</c:choose>
									</div>
								</div>
							</div>
	            		</div>
	            	</div>
	            </div>
	            <%-- <div class="row">${designerProfile.cellPhone}</div>
	            <div class="row">${designerProfile.phone}#${designerProfile.phone_ext}</div> --%>
	        </div>
	        <div class="column half add-space-top">
	            <div class="row">
	            	<div class="info_block" id="info_block_skills">
	            		<div class="head">Skills</div>
	            		<div class="context">
	            			<div class="entity" id="skill_scrollbar">
								<div class="scrollbar" id="skill_scrollbar_entity" style="height: 108px; "><div class="track" style="height: 108px; "><div class="thumb" style="top: 0px; height: 49.33555555555556px; "><div class="end"></div></div></div></div>
								<div class="viewport">
									<div class="overview" id="industryNews" style="top: 0px;">
										<c:choose>
											<c:when test="${empty designerProfile.skillsName}">
												<span style="color:#C30;">Please provide your skills.</span>
											</c:when>
											<c:otherwise>
												<ul>
				            						<c:forEach var="item" items="${designerProfile.skillsName}"><li>${item}</li></c:forEach>
				            					</ul>
			            					</c:otherwise>
		            					</c:choose>
									</div>
								</div>
							</div>
	            		</div>
	            	</div>
	            </div>
	            <div class="row">
	        		<div class="info_block" id="info_block_brand">
	        			<div class="head">Your Brand</div>
	        			<div class="context">
	        				<c:if test="${!empty designerProfile.companyName}">
		        				${designerProfile.companyName}
		        				<br />
		        			</c:if>
		        			<a href="${designerProfile.website}" target="_BLANK">${designerProfile.website}</a>
	        			</div>
	        		</div>
	        	</div>
	            <div class="row">
	            	<div class="info_block" id="info_block_misc">
	            		<div class="head">Schools,&nbsp;Awards,<br/>Events,&nbsp;Specialities,&nbsp;etc.</div>
	            		<div id="info_block_misc_context">
	            			<div class="entity" id="misc_scrollbar">
								<div class="scrollbar" id="misc_scrollbar_entity" style="height: 108px; "><div class="track" style="height: 108px; "><div class="thumb" style="top: 0px; height: 49.33555555555556px; "><div class="end"></div></div></div></div>
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
										${designerProfile.misc}
									</div>
								</div>
							</div>
	            		</div>
	            	</div>
	            </div>
	        </div>
	        <div class="row">
	        	<div class="column" style="width:51%">
	        		<c:choose>
	        			<c:when test="${hasFullAccess}">
				        	<div class="membershipDetail">
				                <div class="row"><span class="textLeft">Member Since</span> <span class="textRight"><fmt:formatDate pattern="MMM-dd-yyyy" value="${designerProfile.memberSince}" /></span></div>
				                <!-- <div class="line"></div> -->
				                <%--<div class="row"><span class="textLeft">Membership Expires On</span><span class="textRight orangeText"><fmt:formatDate pattern="MMM-dd-yyyy" value="${designerProfile.memberExpires}" /></span></div>
				                <div class="row">
				                    <span class="textLeft">Next Payment Due Date</span><span class="textRight"><fmt:formatDate pattern="MMM-dd-yyyy" value="${designerProfile.due}" /></span>
				                    <br />
				                    <!-- <span class="textRight"><a href="#payment">(Make a Payment)</a></span> -->
				                </div>
				                <!-- <div class="line"></div> -->
				                <div class="row space textCenter"><a href="${pageContext.request.contextPath}<%= ViewPaths.UPDATE_MEMBERSHIP_PAY %>?userId=${userId}" id="update_membership">Update Membership Payment</a></div> --%>
				            </div>
			            </c:when>
			            <c:otherwise>
			            	<div class="profile-score-info" style="margin:10px auto 0px auto; float:none; text-align: center;">
			            		<div style="display:block; clear: both; float:none; text-align: center; padding-top:10px;">
			            			<c:if test="${score<100}">
							    		<span style="color: #00AEEF; font-size:4em; font-weight: bold;">${score}%</span> <span style="font-size:1.2em; margin-left:10px;"> OF PROFILE COMPLETED</span>
							    	</c:if>
						    	</div>
			            	</div>
			            </c:otherwise>
	        		</c:choose>
	            </div>
	            <div class="column" style="width:49%; text-align:center;">
	            	<a href="#edit_designer_profile" id="edit_profile_designer" style="display:block; width:100%;"><div class="button center">Edit Profile</div></a>
	            	<div style="width:100%; height:10px;"></div>
					<a id="manage_referrals" style="display:block; width:100%;"><div class="button center">Manage Referrals</div></a>
					<div style="width:100%; height:10px;"></div>
					<a id="change_password" style="text-decoration:none; display:block; width:100%;"><div class="button center">Change Password</div></a>
					<div style="width:100%; height:10px;"></div>
					<a id="view_terms" style="text-decoration:none;"><div class="button center">TERMS & CONDITIONS</div></a>
				</div>
	        </div>
	    </div>
    </div>
</div>
<!---end of content----------->