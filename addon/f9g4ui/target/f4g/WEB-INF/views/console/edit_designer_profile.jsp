<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<%@ page import="com.f9g4.web.utils.ViewPaths" %>

<!---Content------------------>
<%-- <c:if test="${!hasFullAccess}"> --%>
	<div class="profile-score-bubble" id="profileScore" profile-score="${score}" >${score}%</div>
	<div id="qtipDataCarrier" style="display:none">
		<a href="javascript:void(0);" class="qtip-close-button">Close</a>
		<a href="javascript:void(0);" class="profile-progress-why"><spring:message code="profile.progress.todo.why" /></a>
		<c:forEach var="item" items="${fullToDoList}">
			<c:choose>
				<c:when test="${toDoHM[item] == true}">
					<div class="<spring:message code="${item}.id" />" style="margin:5px 0px;"><spring:message code="${item}" /></div>
				</c:when>
				<c:otherwise>
					<div class="<spring:message code="${item}.id" />" style="margin-bottom:5px; display:none;"><spring:message code="${item}" /></div>
				</c:otherwise>
			</c:choose>
		</c:forEach>
		<div class="profCompleted" style="display:none;">Congratulations! Click Save Now</div>
	</div>
<%-- </c:if> --%>
<div class="contentFrame" >
	<div class="content-function min background-blue">
	</div>
    <div class="content" id="home_designer_edit">
        <form:form modelAttribute="designerProfile" method="post" id="form_edit_profile">
        <div class="column second">
            <div class="homeImage" id="previewImage"><i></i><img src="${designerProfile.logoImageUrl}" /></div>
            <div class="button" id="update_new">Upload Image</div>
            <form:hidden path="logoImageUrl" id="form_logo_image_url" value="${designerProfile.logoImageUrl}"/>
            <%-- <c:if test="${hasFullAccess}">
	            <div class="membershipDetail">
	                <div class="row"><span class="textLeft">Member Since</span> <span class="textRight"><fmt:formatDate pattern="MMM-dd-yyyy" value="${designerProfile.memberSince}" /></span></div>
	                <!-- <div class="line"></div> -->
	                <div class="row"><span class="textLeft">Membership Expires On</span><span class="textRight orangeText"><fmt:formatDate pattern="MMM-dd-yyyy" value="${designerProfile.memberExpires}" /></span></div>
	                <div class="row">
	                    <span class="textLeft">Next Payment Due Date</span><span class="textRight"><fmt:formatDate pattern="MMM-dd-yyyy" value="${designerProfile.due}" /></span>
	                    <br />
	                    <!-- <span class="textRight"><a href="#payment">(Make a Payment)</a></span> -->
	                </div>
	                <!-- <div class="line"></div> -->
	                <div class="row space textCenter"><a href="${pageContext.request.contextPath}<%= ViewPaths.UPDATE_MEMBERSHIP_PAY %>?userId=${userId}" id="update_membership">Update Membership</a></div>
	            </div>
            </c:if> --%>
        </div>
        <div class="column second">
        	<div class="row">
        	<div class="label" id="label_first_name"> First Name </div>
        		<br />
        		<!-- <input name="first_name" type="text" class="width_controller"/> -->
        		<form:input path="firstName" value="${designerProfile.firstName}" cssClass="width_controller" maxlength="60"/>
       
            </div>
            <div class="row">
            	<div class="label" id="label_last_name"> Last Name </div>
                <br />
                <!-- <input name="last_name" type="text" class="width_controller"/> -->
                <form:input path="lastName" value="${designerProfile.lastName}" cssClass="width_controller" maxlength="60"/>	
            </div>
            <div class="row">
            	<div class="label" id="label_form_country"> Country </div>
                <br />
                <!-- <input name="country" type="text" class="width_controller"/> -->
                <form:select path="countryId" id="form_country" multiple="false" cssClass="width_controller">
                	<form:option selected="true" value="0">Please select</form:option>
		            <c:forEach var="item" items="${countriesList}">
						<c:choose>
							<c:when test="${designerProfile.countryId == item.lookupValueId}">
								<form:option selected="true" value="${item.lookupValueId}">
									<c:out value="${item.description}" />
								</form:option>
							</c:when>
							<c:otherwise>
								<form:option value="${item.lookupValueId}">
									<c:out value="${item.description}" />
								</form:option>
							</c:otherwise>
						</c:choose>
					</c:forEach>
                </form:select>
           	</div>
            <div class="row">
            	<div class="label" id="label_address_1"> Street Address 1 </div>
                <br />
                <!-- <input name="address_1" type="text" class="width_controller"/> -->
                <form:input path="address1" value="${designerProfile.address1}" cssClass="width_controller" maxlength="125"/>
            </div>
            <div class="row">
             	<div class="label" id="label_address_2"> Street Address 2 </div>
                <br />
                <!-- <input name="address_2" type="text" class="width_controller"/> -->
                <form:input path="address2" value="${designerProfile.address2}" cssClass="width_controller" maxlength="125"/>
           	</div>
            <div class="row">
            	<div class="column half">
              		<div class="label" id="label_city"> City </div>
                	<br />
                	<!-- <input name="city" type="text" class="width_controller"/> -->
                	<form:input path="city" value="${designerProfile.city}" cssClass="width_controller" maxlength="60"/>
              	</div>
              	<c:set var="showState" value="inactive"/>
              	<c:if test="${designerProfile.countryId == 238}">
              		<c:set var="showState" value=""/>
              	</c:if>
                <div class="column half ${showState}">
                    <div class="label" id="label_form_state">  State </div>
                    <br />
                   	<!-- <select name="state"class="dropdown" id="form_state">
                    		<option value="1" selected="selected">1</option>
                        	<option value="2">2</option>
                    </select> -->
                    <form:select path="state" id="form_state" cssClass="width_controller il">
                    	<form:option selected="true" value="0">Please select</form:option>
	                    <c:forEach var="item" items="${statesList}">
							<c:choose>
								<c:when
									test="${designerProfile.state == item.description}">
									<form:option selected="true" value="${item.lookupValueId}">
										<c:out value="${item.description}" />
									</form:option>
								</c:when>
								<c:otherwise>
									<form:option value="${item.lookupValueId}">
										<c:out value="${item.description}" />
									</form:option>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</form:select>
                </div>
            </div>
            <div class="row">
           		 <div class="label" id="label_zipcode"> Zip Code </div>
                <br />
                <!-- <input name="zipcode" type="text" class="width_controller"/> -->
                <form:input path="zip" value="${designerProfile.zip}" cssClass="width_controller" maxlength="10"/>	
            </div>
            <div class="row">
               	<div class="label" id="label_cell_phone">  Mobile Phone Number </div>
                <br />
                <!-- <input name="cell_phone" type="text" class="width_controller"/> -->
                <form:input path="cellPhone" value="${designerProfile.cellPhone}" cssClass="width_controller"  maxlength="13"/>
            </div>
            <div class="row">
            	<div class="column threeFifth">
            	<div class="label" id="label_phone"> Work Phone </div>
	                <br />
	                <!-- <input name="work_phone" type="text" class="width_controller"/> -->
	                <form:input id="phone_no" path="phone" value="${designerProfile.phone}" cssClass="width_controller" maxlength="13"/>
                </div>
                <div class="column twoFifth">
                	<div class="label" id="label_ext">Ext</div>
                	<br />
                	<!-- <input name="ext" type="text" class="width_controller"/> -->
                	<form:input path="phone_ext" value="${designerProfile.phone_ext}" cssClass="width_controller" maxlength="5"/>
                </div>
            </div>
            <div class="row">
            	<div class="label" id="label_companyname"> Company Name </div>
                 <br />
                 <!-- <input name="company_name" id="form_company_name" type="text" class="width_controller"/> -->
                 <form:input path="companyName" value="${designerProfile.companyName}" cssClass="width_controller" maxlength="125"/>
            </div>
        </div>
        <div class="column second show-all">
        <div class="row">
        	<div class="row">
        		<div class="label" id="label_website"> Website </div>
                <br />
                <!-- <input name="website" id="form_website" type="text" class="width_controller"/> -->
                <form:input path="website" value="${designerProfile.website}" cssClass="width_controller" maxlength="125"/>
            </div>
        	<div class="label" id="label_Languages"> Languages </div>
                <br />
                <form:select path="languagesId" id="form_languages" items="${languagesList}" itemValue="lookupValueId" itemLabel="description" multiple="true" cssClass="width_controller" >
                </form:select>  
            </div>
            <div class="row">
                <div class="label" id="label_about_tou">About You</div> <span style="font-size:10px; color:#C30;">(1000 characters long)</span>
                <br />
                <form:textarea path="aboutYou" cols="27" rows="10" cssClass="nonresizable width_controller" maxlength="1000"/>
            </div>
            <div class="row" style="padding-bottom:0px;">
            <div class="label" id="label_skills"> Skills </div>
               	<br />
                <form:select path="skillsId" id="form_skills" items="${skillsList}" itemValue="lookupValueId" itemLabel="description" multiple="true" cssClass="width_controller"></form:select>
            </div>
            <div class="row">
            	<div class="label" id="label_misc">Awards,Events,<br /> and Special Projects.</div>
                <br />
                <!-- <textarea name="misc" id="form_misc" cols="27" rows="4" class="nonresizable"></textarea> -->
                <form:textarea path="misc" cols="27" rows="4" cssClass="nonresizable width_controller" maxlength="1000"/>
            </div>
        </div>
        <div class="column second show-all">
            <%-- New columns --%>
            <div class="row">
            	<div class="label" id="label_education"> Education </div>
                <br />
                <form:select path="educationId" id="form_education" items="${educationsList}" itemValue="lookupValueId" itemLabel="description" class="width_controller ms-add-other" multiple="true">
                	<%-- <c:choose>
                		<c:when test="${designerProfile.educationId == -2}">
                			<option value="-2" selected="selected">Others</option>
                		</c:when>
                		<c:otherwise>
                			<option value="-2">Others</option>
                		</c:otherwise>
                	</c:choose> --%>
                	<%-- <c:forEach var="item" items="${educationsList}">
                		<c:choose>
                			<c:when test="${designerProfile.educationId == item.lookupValueId}">
                				<option value="${item.lookupValueId}" selected="selected">${item.description}</option>
                			</c:when>
                			<c:otherwise>
                				<option value="${item.lookupValueId}">${item.description}</option>
                			</c:otherwise>
                		</c:choose>
                	</c:forEach> --%>
                </form:select>
                <div><b>Other:</b>&nbsp;<input type="text" name="_otherEducation" id="form_education_other" value="${designerProfile.otherEducation}" class="inline-controller ms-add-other-value"/>&nbsp;<a class="ms-add-other-button" href="javascript:void(0);">Add</a></div>
            </div>
            <div class="row">
            	<div class="label" id="label_areaOfSpecialty"> Area of Specialty </div>
                <br />
                <form:select path="specialtyId" id="form_specialty" items="${specialtiesList}" itemValue="lookupValueId" itemLabel="description" cssClass="width_controller ms-add-other" multiple="true">
                	<%-- <c:choose>
                		<c:when test="${designerProfile.specialtyId == -2}">
                			<option value="-2" selected="selected">Others</option>
                		</c:when>
                		<c:otherwise>
                			<option value="-2">Others</option>
                		</c:otherwise>
                	</c:choose> --%>
                	<%-- <c:forEach var="item" items="${specialtiesList}">
                		<c:choose>
                			<c:when test="${designerProfile.specialtyId == item.lookupValueId}">
                				<option value="${item.lookupValueId}" selected="selected">${item.description}</option>
                			</c:when>
                			<c:otherwise>
                				<option value="${item.lookupValueId}">${item.description}</option>
                			</c:otherwise>
                		</c:choose>
                	</c:forEach> --%>
                </form:select>
                <div><b>Other:</b>&nbsp;<input type="text" name="_otherSpecialty" id="form_specialty_other" value="${designerProfile.otherSpecialty}" class="inline-controller ms-add-other-value"/>&nbsp;<a class="ms-add-other-button" href="javascript:void(0);">Add</a></div>
            </div>
            <div class="row">
            	<div class="label" id="label_expertise"> Area Of Expertise </div>
                <br />
                <form:select path="expertiseId" id="form_expertise" items="${expertisesList}" itemValue="lookupValueId" itemLabel="description" cssClass="width_controller ms-add-other" multiple="true">
                	<%-- <c:choose>
                		<c:when test="${designerProfile.expertiseId == -2}">
                			<option value="-2" selected="selected">Others</option>
                		</c:when>
                		<c:otherwise>
                			<option value="-2">Others</option>
                		</c:otherwise>
                	</c:choose> --%>
                	<%-- <c:forEach var="item" items="${expertisesList}">
                		<c:choose>
	                		<c:when test="${designerProfile.expertiseId == item.lookupValueId}">
	                			<option value="${item.lookupValueId}" selected="selected">${item.description}</option>
	                		</c:when>
	                		<c:otherwise>
	                			<option value="${item.lookupValueId}">${item.description}</option>
	                		</c:otherwise>
                		</c:choose>
                	</c:forEach> --%>
                </form:select>
                <div><b>Other:</b>&nbsp;<input type="text" name="_otherExpertise" id="form_expertise_other" value="${designerProfile.otherExpertise}" class="inline-controller ms-add-other-value"/>&nbsp;<a class="ms-add-other-button" href="javascript:void(0);">Add</a></div>
                <%-- <form:hidden path="otherExpertise" class="ms-add-other-value" /> --%>
            </div>
            <div class="row">
            	<div class="label" id="label_degAcc"> Degrees and Accreditations </div>
                <br />
                <form:select path="degAccId" id="form_degacc" items="${degAccList}" itemValue="lookupValueId" itemLabel="description" cssClass="width_controller" multiple="true">
                 	<%-- <c:forEach var="item" items="${degAccList}">
                 		<c:choose>
	                 		<c:when test="${designerProfile.degAccId == item.lookupValueId}">
	                			<option value="${item.lookupValueId}" selected="selected">${item.description}</option>
	                		</c:when>
	                		<c:otherwise>
	                			<option value="${item.lookupValueId}">${item.description}</option>
	                		</c:otherwise>
                		</c:choose>
                	</c:forEach> --%>
                </form:select>
            </div>
            <div class="row">
            	<div class="label" id="label_yrsExp"> Years of Experience </div>
                <br />
                <form:select path="yrsExpId" cssClass="width_controller">
	                <option value="-1">Please select</option>
                 	<c:forEach var="item" items="${yrsExpList}">
                 		<c:choose>
	                 		<c:when test="${designerProfile.yrsExpId == item.lookupValueId}">
	                			<option value="${item.lookupValueId}" selected="selected">${item.description}</option>
	                		</c:when>
	                		<c:otherwise>
	                			<option value="${item.lookupValueId}">${item.description}</option>
	                		</c:otherwise>
                		</c:choose>
                	</c:forEach>
                </form:select>
            </div>
            <div class="row">
            	<div class="label" id="label_companiesWorked"> Name the companies you have worked-for in the past </div>
            	<br />
                <form:input path="companiesWorked" value="${designerProfile.companiesWorked}" cssClass="width_controller" maxlength="125"/>
            </div>
            
            <%--additional document upload --%>
            <div class="adoc-section">
				<div class="label">Resume/Additional document</div>
				<div id="file_result">
					<c:forEach var="item" items="${designerProfile.adoc_oname}" varStatus="counter">
						<div class="added-file">${item}<span class="added-file-delete" data="1"></span></div>
					</c:forEach>
				</div>
				<c:choose>
					<c:when test="${!empty designerProfile.adoc_oname}">
						<c:forEach var="item" items="${designerProfile.adoc_oname}" varStatus="counter">
							<input type="hidden" name="adoc_id" id="adoc_id" value="${designerProfile.adoc_id[counter.count-1]}" />
							<input type="hidden" name="adoc_oname" id="adoc_oname" value="${item}" />
							<input type="hidden" name="adoc_type" id="adoc_type" value="${designerProfile.adoc_type[counter.count-1]}" />
							<input type="hidden" name="adoc_iname" id="adoc_iname" value="${designerProfile.adoc_iname[counter.count-1]}" />
						</c:forEach>
					</c:when>
					<c:otherwise>
						<input type="hidden" name="adoc_id" id="adoc_id" />
						<input type="hidden" name="adoc_oname" id="adoc_oname" />
						<input type="hidden" name="adoc_type" id="adoc_type" />
						<input type="hidden" name="adoc_iname" id="adoc_iname" />
					</c:otherwise>
				</c:choose>
				<div class="button" id="upload_doc">Upload File</div>
			</div>
        </div>
        <div class="buttons">
        	<div class="button rightText" id="save_designer">Save</div>
            <div class="button orange rightText" id="cancel_designer">Cancel</div>
      	</div>
        </form:form>
        <div class="loadingSpinner disable"><span><img src="/images/spinner.gif" /></span></div>
    </div>
</div>
<!---end of Main Panel--------------------------------------------------------------->