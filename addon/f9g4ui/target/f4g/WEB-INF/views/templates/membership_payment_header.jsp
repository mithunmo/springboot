<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!---header-------------------------------------------------------------->
<div class="profile">
    <div class="title" id="title">    
        <div class="logo">
        <img src="/images/Small-Logo.gif" style="margin-left:2px;width:138px;height:88px;"/>
        </div>
        <div class="function">
	        <div class="information">
	        Membership Payment
	            <div class="loginPanel">
	            <span id="phone"><spring:message code="registration.header.phone" /></span> | <a href="javascript:void(0);" id="livechat"><spring:message code="registration.header.chat" /></a>
	            </div>
	        </div>
        </div>
    </div>
</div>
<!---End of header------------------------------------------------------->
