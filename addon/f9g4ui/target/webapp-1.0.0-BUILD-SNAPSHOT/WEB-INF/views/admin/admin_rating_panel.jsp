<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!---set specific id to set  popup width-------->
<div class="popup" id="admin_rating"> 

<div class="header">
ADMIN RATING
    <div class="close">X</div>
</div>
<!---Set id to fill in data--->
<div class="content" id="popup_admin_rating">
	<div style="padding-left:140px;">
		<div class="ffg-rating" id="ffgRating" data-id="${adminRatingUser.userId}"></div>
		<div class="ffg-rating-value" id="ffgRatingValue" data-id="${adminRatingUser.userId}">
			<c:choose>
				<c:when test="${adminRatingValue == -1}">
					Unrated
				</c:when>
				<c:otherwise>
					${adminRatingValue}
				</c:otherwise>
			</c:choose>
		</div>
		<input name="ffgRating" id="form_ffgRating" type="hidden" data-id="${adminRatingUser.userId}" value="${adminRatingValue}" />
		<img class="ffg-rating-spinner" src="/images/spinner_min.gif" />
	</div>
	<div class="buttonPanel">
		<div class="button close" id="admin_rating_ok">Ok</div>
	</div>
</div>
</div>