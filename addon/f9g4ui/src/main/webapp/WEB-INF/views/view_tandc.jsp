<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div class="popup" id="terms">
<div class="header">Terms and Conditions
	<div class="close">X</div>
</div>
<div class="content">
    <div class="terms">
        <div class="entity" id="termScrollbar">
            <div class="scrollbar" id="termScrollbar_entity"><div class="track"><div class="thumb" id="thumbPos"><div class="end"></div></div></div></div>
                <div class="viewport">
                    <div class="overview" id="termsData">
                    	<p>${terms}</p>
                    	<%-- <div class="confirmation">
                    	<form action="${pageContext.request.contextPath}/user/terms" method="post" id="terms_form" >
                    		<input name="termsId" type="hidden" value="${termsId}"/>
                    		<input name="agree" type="radio" value="agree" id="terms_agree" />Agree
                    		<input name="agree" type="radio" value="decline" id="terms_decline" />Decline
                    	</form>
                    	</div> --%>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="button close" id="terms_ok" style="margin-top:20px;">Ok</div>
</div>