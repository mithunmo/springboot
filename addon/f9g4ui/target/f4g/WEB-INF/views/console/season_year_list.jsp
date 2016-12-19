<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

[
	<c:forEach var="item" items="${year}" varStatus="rowCounter">
	{
		"name" : "${item}",
		"id" : ${item},
		"children":
		[
			<c:choose>
				<c:when test="${mode == 'checkbox'}">
					<c:forEach var="seasonItem" items="${season}">
						<c:if test="${seasonItem.year == item}">
								{"name":"<input name=\"season\" type=\"checkbox\" value=\"${seasonItem.seasonYearId}\" />${seasonItem.season}"},
						</c:if>
					</c:forEach>
				</c:when>
				<c:otherwise>
					<c:forEach var="seasonItem" items="${season}">
						<c:if test="${seasonItem.year == item}">
								{"name":"<input name=\"season\" type=\"radio\" value=\"${seasonItem.seasonYearId}\" />${seasonItem.season}"},
						</c:if>
					</c:forEach>
				</c:otherwise>
			</c:choose>
		]
	},
	</c:forEach>
]