<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<script>
	$(document).ready(function()
	{
		if($.browser.msie && ($.browser.version == "8.0" || $.browser.version == "7.0"))
		{
			logging("layout table on IE 8","#00F");
			$('table tr:even').addClass('even'); 
		    $('table tr:odd').addClass('odd');
		    $("table td:nth-child(1)").addClass("td1");
		    $("table td:nth-child(2)").addClass("td2");
		    $("table td:nth-child(3)").addClass("td3");
		    $("table td:nth-child(4)").addClass("td4");
		    $("table td:nth-child(5)").addClass("td5");
		    $("table td:nth-child(6)").addClass("td6");
		    $("table td:nth-child(7)").addClass("td7");
		}
	});
</script>

<!---set specific id to set  popup width-------->
<div class="popup" id="referral_manage"> 
<div class="header">
Manage Referral
    <div class="close">X</div>
</div>
<!---Set id to fill in data--->
    <div class="content" id="popup_referral_manage">
    	<div class="referral_header">
        <table border="0" cellspacing="0" cellpadding="0">
          <tr class="referral_table_header">
            <td>First Name</td>
            <td>Last Name</td>
            <td>Phone Number</td>
            <td>E-mail Address</td>
            <td>Status</td>
            <td>Date Sent</td>
            <td>Action</td>
          </tr>
        </table>
        </div>
        <div class="table">
	        <div class="entity" id="manage_referral_scrollbar">
				<div class="scrollbar" id="userinfo_misc_scrollbar_entity"><div class="track"><div class="thumb" style="top: 0px; height: 49.33555555555556px; "><div class="end"></div></div></div></div>
				<div class="viewport">
					<div class="overview" id="industryNews" style="top: 0px;">					
				        <table border="0" cellspacing="1" cellpadding="2" id="manageReferralTable">
					        <c:forEach var="item" items="${beanReferralsList}" varStatus="rowCounter">
					          <tr>
					            <td id="referral_firstname_${rowCounter.count-1}">${item.firstName}</td>
					            <td id="referral_lastname_${rowCounter.count-1}">${item.lastName}</td>
					            <td id="referral_phone_${rowCounter.count-1}">${item.phone}</td>
					            <td id="referral_email_${rowCounter.count-1}">${item.email}</td>
					            <td id="referral_status_${rowCounter.count-1}">${item.status}</td>
					            <td id="referral_datesent_${rowCounter.count-1}"><fmt:formatDate pattern="MMM dd,yyyy" value="${item.dateSent}" /></td>
					            <td id="referral_action_${rowCounter.count-1}">
					            	<%--Show the function only the referral did not register --%>
					            	<c:if test="${item.status=='Pending'}">
						            	<a href="javascript:void(0)" class="resend_noti" id="resend_referral_${rowCounter.count-1}">Resend</a>
						                <br />
						                <a href="javascript:void(0)" class="edit_referral" id="edit_referral_${rowCounter.count-1}">Edit</a>
					                </c:if>
					            </td>
					          </tr>
					        </c:forEach>
				        </table>
					</div>
				</div>
			</div>
		</div>
	 	<form:form modelAttribute="referralForm" id="form_referral" method="POST">
	 	<form:hidden path="firstName" id="form_referral_firstname" />
	 	<form:hidden path="lastName" id="form_referral_lastname" />
	 	<form:hidden path="phone" id="form_referral_phone" />
	 	<form:hidden path="email" id="form_referral_email" />
	 	</form:form>
    </div>
</div>