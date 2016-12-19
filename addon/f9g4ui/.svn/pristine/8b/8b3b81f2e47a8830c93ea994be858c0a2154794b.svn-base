<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!---set specific id to set  popup width-------->
<div class="popup" id=""> 

<div class="header">
Comments History
    <div class="close">X</div>
</div>
<!---Set id to fill in data--->
<div class="content" id="popup_commission">
	<c:choose>
		<c:when test="${canRender}">
			<div>
				Content:<br />
				${comments}
			</div>
		</c:when>
		<c:otherwise>
			Access violation :Unauthorized user.
		</c:otherwise>
	</c:choose>
	<div style="text-align:center;">
		<a class="button close">Ok</a>
	</div>
</div>
</div>