<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!---Content------------------>
<div class="contentFrame" >
    <div class="content" id="alerts">  
    	<div class="entity" id="alert_scrollbar">
			<div class="scrollbar" id="alert_scrollbar_entity"><div class="track"><div class="thumb"><div class="end"></div></div></div></div>
			<div class="viewport">
				<div class="overview" id="industryNews">  
				    <c:if test="${empty alertHistory}">At this time we don't have alerts for you. Thank you.  </c:if>
				    <c:forEach var="alert" items="${alertHistory}" varStatus="counter">
						<!-- <li> : </li> -->
						<c:if test="${counter.count % 2 == 0}">
							<div class="item odd">
								<div class="item-header"><fmt:formatDate pattern="MMM-dd-yyyy hh:mm a" value="${alert.creationDate}" /></div>
								<div class="item-subject"><c:out value="${alert.subject}"/></div>
								<div class="item-body" >${alert.messageBody}</div>
							</div>
						</c:if>
						<c:if test="${counter.count % 2 == 1}">
							<div class="item even">
								<div class="item-header"><fmt:formatDate pattern="MMM-dd-yyyy hh:mm a" value="${alert.creationDate}" /></div>
								<div class="item-subject"><c:out value="${alert.subject}"/></div>
								<div class="item-body">${alert.messageBody}</div>
							</div>
						</c:if>
					</c:forEach>
				</div>
			</div>
		</div>		
    </div>
</div>
<!---End of content----------->
