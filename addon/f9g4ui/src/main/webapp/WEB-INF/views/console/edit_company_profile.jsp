<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<%@ page import="com.f9g4.web.utils.ViewPaths" %>

<!---Content------------------>
<div class="contentFrame" >
	<div class="content-function background-blue"></div>
    <div class="content" id="home_edit">
       <!--  <form action="" method="post" id="form_edit_profile"> -->
       <form:form modelAttribute="compProfile" method="post" id="form_edit_profile">
       
        <div class="column second">
            <div class="homeImage" id="previewImage"><i></i><img src="${compProfile.logoImageUrl}" /></div>
            <div class="button" id="update_new">Upload Image</div>
            <form:hidden path="logoImageUrl" id="form_logo_image_url" value="${compProfile.logoImageUrl}"/>
        </div>
        <!---Middle Part-------------------------------------------------------->
        <div class="column half">
            <div class="row">
                <div class="column half">
                   <div class="label" id="label_first_name"> First Name </div>
                    <br />
                    <!-- <input name="first_name" type="text" class="width_controller"/> -->
					<form:input path="firstName" id="first_name"  cssClass="width_controller" maxlength="60"/>
                </div>
                <div class="column half">
                   <div class="label" id="label_last_name"> Last Name </div>
                    <br />
                    <!-- <input name="last_name" type="text" class="width_controller"/> -->
                    <form:input path="lastName" id="last_name"  cssClass="width_controller" maxlength="60"/>
                </div>
            </div>
            <div class="row">
               <div class="label" id="label_company_name"> Company Name </div>
                <br />
                <!-- <input name="company_name" type="text" class="width_controller"/> -->
                <form:input path="companyName" id="company_name" cssClass="width_controller extra" maxlength="125"/>
            </div>
            <div class="row extra-space">
	            <div class="column half">
	              <div class="label" id="label_phone"> Primary Phone Number </div>
	                <br />
	                <!-- <input name="phone" type="text" class="width_controller"/> -->
	                <form:input path="phone" id="phone_no" cssClass="width_controller" maxlength="13"/>
	            </div>
	            <div class="column half">
	              <div class="label" id="label_ext">  Ext. </div>
	                <br />
					<!-- <input name="ext" type="text" class="width_controller"/> -->
	                <form:input path="ext" id="ext" cssClass="width_controller" maxlength="5"/>
	            </div>
	        </div>
            <div class="row">
	            <div class="column half">
	                <div class="row">
	                   <div class="label" id="label_address_1"> Street Address 1 </div>
	                    <br />
	                    <!-- <input name="address_1" type="text" class="width_controller"/> -->
	                    <form:input path="address1" id="address1" cssClass="width_controller" maxlength="125"/>
	                </div>
	                <div class="row">
	                   <div class="label" id="label_address_2"> Street Address 2 </div>
	                    <br />
	                    <!-- <input name="address_2" type="text" class="width_controller"/> -->
	                    <form:input path="address2" id="address2" cssClass="width_controller" maxlength="125"/>
	                </div>
	                <div class="row">
	                  	<div class="label" id="label_city"> City </div>
	                    <br />
	                    <!-- <input name="city" type="text" class="width_controller"/> -->
	                    <form:input path="city" id="city" cssClass="width_controller" maxlength="60"/>
	                </div>
	                <div class="row">
	                   <div class="label" id="label_zipcode"> Zip Code(Postal Code) </div>
	                    <br />
	                    <!-- <input name="zipcode" type="text" class="width_controller"/> -->
	                    <form:input path="zip" id="zip" cssClass="width_controller" maxlength="10"/>
	                </div>
	                <div class="row">
	                   <div class="label" id="label_form_country"> Country </div>
	                    <br />
	                    <!-- <input name="country" type="text" class="width_controller"/> -->
	                    <form:select path="countryId" id="form_country" items="${countriesList}" itemValue="lookupValueId" itemLabel="description" multiple="false" cssClass="width_controller">
			            <c:forEach var="item" items="${countriesList}">
							<c:choose>
								<c:when test="${compProfile.countryId == item.lookupValueId}">
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
	                  <div class="label" id="label_form_state">  State </div>
	                    <br />
	                    <!-- <input name="zipcode" type="text" class="width_controller"/> -->
	                    <c:set var="stateDisabled" value="false"/>
	              		<c:if test="${compProfile.countryId!=238}"><c:set var="stateDisabled" value="true"/></c:if>
	                    <form:select path="state" id="form_state" cssClass="width_controller" disabled="${stateDisabled}">
		                    <c:forEach var="item" items="${statesList}">
								<c:choose>
									<c:when
										test="${compProfile.state == item.lookupValueId}">
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
	            <div class="column half">
	                <div class="row">
	                  <div class="label" id="label_cell_phone">  Cell Phone Number </div>
	                    <br />
	                    <!-- <input name="cell_phone" type="text" class="width_controller"/> -->
	                    <form:input path="cellPhone" id="cellPhone" cssClass="width_controller" maxlength="13"/>
	                </div>
	                <div class="row">
	                   <div class="label" id="label_fax"> Fax Number </div>
	                    <br />
	                    <!-- <input name="fax" type="text" class="width_controller"/> -->
	                    <form:input path="fax" id="fax" cssClass="width_controller" maxlength="13"/>
	                </div>
	                <div class="row">
	                  <div class="label" id="label_website">  Company Website </div>
	                    <br />
	                    <!-- <input name="website" type="text" class="width_controller"/> -->
	                    <form:input path="website" id="website" cssClass="width_controller" maxlength="125"/>
	                </div>
	            </div>
            </div>
        </div>
        <!---End of middle part----------------------------------------------------------------->
        <!---Right Part-------------------------------------------------------------------------->
        <div class="column second">
        	<div class="label">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</div>
       		<div class="membershipDetail">
				<div class="row">
					<span class="textLeft">Member Since</span> <span class="textRight"><fmt:formatDate pattern="MMM-dd-yyyy" value="${compProfile.memberSince}" /></span>
				</div>
				<!-- <div class="line"></div> -->
				<div class="row space">
					<span class="textLeft">Membership Expires On</span><span class="textRight orangeText"><fmt:formatDate pattern="MMM-dd-yyyy" value="${compProfile.memberExpires}" /></span>
				</div>
				<div class="row">
					<span class="textLeft">Next Payment Due Date</span><span class="textRight"><fmt:formatDate pattern="MMM-dd-yyyy" value="${compProfile.due}" /></span> <br /> 
					<!-- <span class="textRight"><a href="#payment">(Make a Payment)</a></span> -->
				</div>
				<!-- <div class="line"></div> -->
				<div class="row space textCenter" style="height:20px;">
					<%-- <a href="${pageContext.request.contextPath}<%= ViewPaths.UPDATE_MEMBERSHIP_PAY %>?userId=${userId}" id="update_membership">Update Membership</a> --%>
				</div>
			</div>
            <div class="buttons" id="edit_profile_buttons">
                <div class="button rightText" id="save_company">Save</div>
                <div class="button orange rightText" id="cancel_company">Cancel</div>
            </div>
        </div>
        <!---end of right part------------------------------------------------------------------->
       </form:form>
       <div class="loadingSpinner disable"><span><img src="/images/spinner.gif" /></span></div>
    </div>
</div>
<!---end of Main Panel--------------------------------------------------------------->