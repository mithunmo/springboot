<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div class="popup" id="referral"> 
	<div class="header">Refer a Designer<div class="close">X</div></div>
	
	<div class="content" id="popup_referral">
		<form:form modelAttribute="referralForm" id="form_referral" method="POST">
		<div class="row orangeText">
	    Please fill in as much information as possible. Thank you for your referral.
	    </div>
	    <div class="row" id="addReferralResult"></div> 
	    <table>
	  	<tr>
	    	<td>
	    		FIRST NAME
	   			<!-- <input name="first_name" id="form_first_name" type="text" /> -->
	   			<form:input path="firstName" id="form_first_name" tabindex="1" maxlength="125"/>
	    	</td>
	    	<td rowspan="2">
	        	WHY DO YOU RECOMMEND THIS PERSON?
	        	<!-- <textarea name="why" id="form_why" cols="" rows="4"></textarea> -->
	        	<form:textarea path="reason" id="form_why" cols="" rows="4" tabindex="5" maxlength="1000"/>
	        </td>
	  	</tr>
	  	<tr>
	    	<td>
	        	LAST NAME
	    		<!-- <input name="last_name" id="form_last_name" type="text" /> -->
	    		<form:input path="lastName" id="form_last_name" tabindex="2" maxlength="125"/>
	       	</td>
	  	</tr>
	  	<tr>
	    	<td>
	    		PHONE NUMBER
	    		<!-- <input name="phone" id="form_phone" type="text" /> -->
	    		<form:input path="phone" id="form_phone" tabindex="3" maxlength="10"/>
	        </td>
	    	<td rowspan="2">
	    		HOW DO YOU KNOW THIS PERSON?
	        	<!-- <textarea name="how" id="form_how" cols="" rows="4"></textarea> -->
	        	<form:textarea path="background" id="form_how" cols="" rows="4" tabindex="6" maxlength="500"/>
	        </td>
	  	</tr>
	  	<tr>
	  		<td>
	    		EMAIL ADDRESS
	    		<!-- <input name="email" id="form_email" type="text" /> -->
	    		<form:input path="email" id="form_email" tabindex="4" maxlength="125"/>
	    	</td>
	  	</tr>
		</table>
	    <div id="referral_buttons">
	    	<i></i>
	       	<div class="button" id="referral_submit">Submit</div>
	        <div class="button orangeButton close" id="referral_cancel">Cancel</div>    
	   	</div>
		</form:form>
		
	</div>
</div>