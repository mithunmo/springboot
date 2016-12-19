<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!---Content------------------>
<div class="contentFrame" >
    <div class="content" id="profile_progress">
    	<div class="profile-progress-holder">
    		<div class="profile-progress-user-info">
    			<c:if test="${score>=100}"><span>SUCCESS!</span><br /></c:if>
    			Hi&nbsp;${user.firstname},<%-- &nbsp;${user.lastname} --%>
    		</div>
	    	<div class="profile-progress-score-holder">
	    		<c:choose>
	    			<c:when test="${score>=100}">
		    				<span class="profile-progress-score-text" style="margin-left:0px;"><spring:message code="profile.progress.completed" /></span>
	    			</c:when>
	    			<c:otherwise>
	    				<span class="profile-progress-score">${score}%</span><span class="profile-progress-score-text"> OF PROFILE COMPLETED</span>
	    			</c:otherwise>
	    		</c:choose>
	    	</div>
	    	<div id="progressbar" class="progressbar" data="${score}"><%-- <div class="progress-label"></div> --%></div>
	    	<c:choose>
		    	<c:when test="${score<100}">
		    		<div class="profile-progress-hints">
			    		<b><spring:message code="profile.progress.todo.title" /></b>
			    		<ul>
			    			<c:forEach items="${toDoList}" var="item">
			    				<li><spring:message code="${item}" /></li>
			    			</c:forEach>
			    		</ul>
			    		<%--<a href="javascript:void(0);" class="profile-progress-why"><spring:message code="profile.progress.todo.why" /></a>--%>
			    	</div>
			    	<div class="profile-progress-button-holder">
			    		<a class="button" href="#edit_designer_profile">Complete Your Profile</a>
			    	</div>
		    	</c:when>
		    	<c:otherwise>
		    		<div class="profile-progress-hints">
			    		<spring:message code="profile.progress.completed.more" />
			    	</div>
		    	</c:otherwise>
	    	</c:choose>
		</div>		
    </div>
</div>
<!---End of content----------->
<script type="text/javascript">
$(document).ready(function() {
	var progressbar = $('#'+$($('#tabs').data('tabs').anchors[$('#tabs').tabs('option','selected')]).attr('title')+' .progressbar');
	var progressLabel = $(".progress-label");
	$(".progressbar").progressbar({
	    value: 1
	});
	$(".progressbar .ui-progressbar-value").addClass("ui-corner-right");
	var new_width = $('#'+$($('#tabs').data('tabs').anchors[$('#tabs').tabs('option','selected')]).attr('title')+' .progressbar').attr('data')+'%'; //get progressbar entity in seleted tab.
 	<%-- progressLabel.text(new_width); --%>
	$(".progressbar .ui-progressbar-value").animate({width: new_width}, 'slow');
	<%-- $(".progressbar .ui-progressbar-value").html('<div class="progress-label outer" style="width:'+$('#progressbar').width()+'px">'+new_width+'</div>'); --%>
});
</script>