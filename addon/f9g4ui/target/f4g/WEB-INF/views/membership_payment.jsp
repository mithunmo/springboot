<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@ page import="com.f9g4.web.utils.ViewPaths" %> 

<!---Main---------------------------------------------------------------->
<div class="membershipContainer" id="container">
	<div class="contentFrame">
	<div class="popup" id="membership">
		<div class="header">Membership Payment</div>
		<div id="popup_membership">
		    <div class="row space">Current Membership Payment Status 
		    	<span class="orangeText textRight">
		    	<c:choose>
		    		<c:when test="${ isPaymentDue == true}">
		    			<c:out value="DUE"></c:out>
		    		</c:when>
		    		<c:otherwise>
		    			<c:out value="PAID"></c:out>
		    		</c:otherwise>
		    	</c:choose>
		    	</span>
		    </div>
		    <div class="row space">Membership Details</div>
		    <c:if test="${!isCtUserType}">
			    <div class="row">
			    	Amount Due <span class="orangeText textRight"><fmt:formatNumber type="CURRENCY"  maxFractionDigits="2" minFractionDigits="2" currencySymbol="$" value="${membershipPrice}" /></span>
			    </div>
		    </c:if>		    
		    <div class="row">
		    	Expiration Date <span class="orangeText textRight"><fmt:formatDate pattern="MMM-dd-yyyy" value="${expDate}" /></span>
		    </div>
		    <div style="width:100%; text-align: center; margin-top:10px; margin-bottom: 10px;">
		    <c:if test="${!isCtUserType}">
			    <c:choose>
			    	<c:when test="${hasError}">
			    			<span style="color:#C30;"><spring:message code="${errorCode}"></spring:message></span>
			    	</c:when>
					<c:when test="${isUpdateMembership == true}">
							<!-- The user has registered and clicked on save and we will show the Designer membership payment status window.  -->			
							Please click on Pay Now button to pay for your membership.
					</c:when>
					<c:otherwise>
							<!-- The user has registered and clicked on save and we will show the Designer membership payment status window.  -->			
							Please click on Pay Now button to pay for your membership. Your membership start date will ONLY begin after we process your application.
							<br />
							<!--  User has paid for the membership dues successfully on Pay Pal. -->
							<!-- Thank you for your payment. We will start processing your application and be in touch with you. Your membership will be started ONLY after we process you application. In case if your membership gets denied, we will refund the full amount to your Credit Card within 14 days after the denial date. Thank You.  -->
							<br />
							<!-- User has canceled the Pay Pal screen. -->
							<!-- You have not paid for your membership. Please click on Pay Now to continue or you can come back and pay later. Please note that, we will not process your application until the payment is received. Thank You. -->			
					</c:otherwise>
				</c:choose>
			</c:if>
			<c:if test="${isCtUserType}">
				<spring:message code="membership.pay.company"></spring:message>
			</c:if>
			</div>
		    <div class="row">
		    	<c:choose>
		    		<c:when test="${isCtUserType}">
		    			<div class="buttonPanel" style="width:100%;">
		    				<a href="${pageContext.request.contextPath}<%= ViewPaths.LOGIN %>"><div class="button" id="membership_return">Ok</div></a>
		    			</div>
		    		</c:when>
		    		<c:otherwise>
				    	<c:choose>
				    		<c:when test="${hasError}">
				    			<div class="buttonPanel" style="width:100%;">
				    				<c:choose>
										<c:when test="${isUpdateMembership == true}">
											<a href="${pageContext.request.contextPath}<%= ViewPaths.CONSOLE_HOME %>#home"><div class="button" id="membership_error_ok">Ok</div></a>
										</c:when>
										<c:otherwise>
											<a href="/"><div class="button" id="membership_error_ok">Ok</div></a>
										</c:otherwise>
									</c:choose>
									<%-- <a href="${pageContext.request.contextPath}<%= ViewPaths.LOGIN %>"><div class="button" id="membership_error_ok">Ok</div></a> --%>
								</div>
							</c:when>
							<c:otherwise>
								<div style="display: inline-block; padding-top: 8px; float: right; height:50px;">
							    	<form action="${pageContext.request.contextPath}<%= ViewPaths.MEMBERSHIP_PAY %>?userId=${userId}" method="post" id="form_membership_payment">
							    		<div id="paynowMask"></div>
										<input id="membership_payment" type="image" src="https://www.paypalobjects.com/en_US/i/btn/btn_paynowCC_LG.gif" border="0" name="submit" alt="PayPal - The safer, easier way to pay online!">
										<img alt="" border="0" src="https://www.paypalobjects.com/en_US/i/scr/pixel.gif" width="1" height="1">
									</form>
								</div>
								<div style="display: inline-block; float: right;">
						    		<c:choose>
										<c:when test="${isUpdateMembership == true}">
											<a href="${pageContext.request.contextPath}<%= ViewPaths.CONSOLE_HOME %>#home"><div class="button orangeButton" id="membership_return">Cancel</div></a>
										</c:when>
										<c:otherwise>
											<a href="/"><div class="button orangeButton" id="membership_return">Cancel</div></a>
										</c:otherwise>
									</c:choose>
								</div>
							</c:otherwise>
						</c:choose>
					</c:otherwise>
				</c:choose>
		    </div>
		    <!-- <div class="row space" id="paypal_description">
			    	(Paypal - after successful payment bring user back to the screen and
			        display a message saying payment is being processed and we will send
			        a status email)
		    </div> -->
		</div>
	</div>
	</div>
</div>
<!---end of main---------------------------------------------------------->