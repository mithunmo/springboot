<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div class="popup" id="terms">
<div class="header">New Terms and Conditions</div>
<div class="content">
    <div class="terms">
        <div class="entity" id="termScrollbar">
            <div class="scrollbar" id="termScrollbar_entity"><div class="track"><div class="thumb" id="thumbPos"><div class="end"></div></div></div></div>
                <div class="viewport">
                    <div class="overview" id="termsData">
                    	<p> ${terms.messageTermsandCond}</p>
                    	<div class="confirmation">
                    	<form:form modelAttribute="terms" method="POST" id="terms_lg" >
                    		<%-- <form:radiobutton path="accept" value="true" id="terms_agree_login" label="Agree" />
                    		<form:radiobutton path="accept" value="false" id="terms_decline_login" label="Decline" /> --%>
                    		<input type="radio" name="accept" value="true" id="terms_agree_login" />Agree
                    		<input type="radio" name="accept" value="false" id="terms_decline_login" />Decline
                    	</form:form>
                    	</div>
                    </div>
                </div>
                <div style="font-size:16px;color:#C30;text-align:center;font-weight:bold;margin:7px 0px;">Please scroll to the bottom to select agree or decline</div>
            </div>
        </div>
    </div>
    <div class="button disabled terms-ok" button-disabled="true" id="terms_ok_login">Ok</div>
</div>