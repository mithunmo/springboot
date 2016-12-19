<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<script type="text/javascript">
	$(document).ready(function()
	{
		logging("init scroll bar","#F00");
		//$("#messages .messages-header").fadeOut();
	});
</script>
<!---Content------------------>
<div class="contentFrame" >
    <div class="content" id="messages">
    	<%-- <div class="functions">
        	<a href="#">Archive</a>&nbsp;
        	<a href="#">Delete</a>&nbsp;
        	<a href="#">Mark Read</a>&nbsp;
        	<a href="#">Mark Unread</a>
            <div class="pagin">
            	<!-- <a href="#messages_page_1">1</a>&nbsp;
                <a href="#messages_page_2">2</a>&nbsp; -->
            </div>
        </div> --%>
       <!--  <div class="select">
        	Select&nbsp;
            <a href="#" id="messages_select_all">All</a>&nbsp;
            <a href="#" id="messages_select_none">None</a>
            <div class="sorting">
            	<a href="#" id="messages_all">All Messages <img src="/images/Arrow.gif" id="messages_all_arrow"/></a>&nbsp;
                <a href="#" id="messages_newest">Newest <img src="/images/Arrow.gif" id="messages_newest_arrow"/></a>
            </div>
        </div>
         -->
        <div class="font-header cap-bold messages-header"><span class="header-board">BOARD</span><span class="header-sender">SENDER</span><span class="header-message">MESSAGE</span><span class="header-date-sent">DATE SENT</span></div>
        <div class="messages">
        <div class="entity" id="messages_scrollbar">
			<div class="scrollbar" id="messages_scrollbar_entity"><div class="track"><div class="thumb noSelect" unselectable="on"><div class="end"></div></div></div></div>
				<div class="viewport">
					<div class="overview" id="industryNews">
						<form id="form_messages">
							<c:choose>
								<c:when test="${messageListCount==0}">
									<div class="loadingPanel" id="messagesEmptyPanel">
            							<div class="loadingOverlay"></div>
            							<div class="loadingSpinner"><span><spring:message code="console.tab.messages.empty"></spring:message></span></div>
            						</div>
								</c:when>
								<c:otherwise>
									<div class="tilesView" id="messageTiles">
										<div class="Tiles-view">
										<div class="Tiles-view-overlay" style="display:none; width:100%; height:100%; z-index:499; background-color: #FFF; opacity:0.8; position:absolute;"></div>
										<c:forEach var="item" items="${messageList}" varStatus="counter">
											<%-- <a href="#message_detail_${item.boardId}_${item.fromUserId}_${item.toUserId}"> --%>
											<%-- <div class="messageTile" style="top:${counter.count*30+10}px; left:${(counter.count-1)*200+50}px; z-index:${-(counter.count-3)};"> --%>
											<div class="Tile" data="${item.boardId}_${item.fromUserId}_${item.toUserId}">
												<c:if test="${item.showImage && item.typeCode eq 'board.processing.designer'}">
													<div class="tile-badge font-header cap-bold">Reviewing</div>
												</c:if>
												<div class="tile-content">
													<div class="background"></div>
													<div class="senderLogo"><a href="javascript:void(0)" class="messages_fromUserId" data="${item.fromUserId}"><img src="${item.fromUserLogo}"/></a></div>
													<div class="senderInfo">
														<span style="text-transform: uppercase;">
															<a href="javascript:void(0)" class="messageBoardId" data="${item.boardId}" title="<c:out value="${item.boardName}" />">
																<c:choose>
											        				<c:when test="${fn:length(item.boardName)>71}">
											        					<c:out value="${fn:substring(item.boardName, 0, 70)}"/>&nbsp;...
											        				</c:when>
											        				<c:otherwise>
											        					<c:out value="${item.boardName}"/>
											        				</c:otherwise>
											        			</c:choose>
															</a>
														</span>
														<br />
															<span>
																<a href="javascript:void(0)" class="messages_fromUserId" data="${item.fromUserId}">
																${item.fromFinalName}<c:if test="${item.fromUserIsCompany}">&nbsp;(${item.fromUserCompanyName})</c:if>
																</a>
															</span>
														<br />
														<span><fmt:formatDate pattern="MMM-dd-yyyy hh:mm a" value="${item.date}"/></span>
													</div>
													<div class="messages"><a href="#message_detail_${item.boardId}_${item.fromUserId}_${item.toUserId}">${item.messageBody}</a></div>
												</div>
												<div class="touchArea" href="javascript:void(0);" data="${item.boardId}_${item.fromUserId}_${item.toUserId}"></div>
												<c:choose>
													<c:when test="${item.showImage}">
														<img src="/400x400/${item.boardTileUrl}">
													</c:when>
													<c:otherwise>
														<c:choose>
															<c:when test="${item.typeCode eq 'board.unpublished'}">
																<img src="/images/forbidden_with_detail.jpg">
															</c:when>
															<c:when test="${item.typeCode eq 'board.sold.unrelatedusers'}">
																<img src="/images/forbidden_with_detail.jpg">
															</c:when>
															<c:when test="${item.typeCode eq 'board.processing'}">
																<img src="/images/processing_with_detail.jpg">
															</c:when>
														</c:choose>
													</c:otherwise> 
												</c:choose>
											</div>
											<!-- </a> -->
										</c:forEach>
									</div>
									<div class="Tiles-function">
										<a href="javascript:void(0);" class="Tiles-pre"></a>
										<a href="javascript:void(0);" class="Tiles-next"></a>
									</div>
								</div>
						        	<c:forEach var="item" items="${messageList}" varStatus="counter">
						        		<%-- <c:if test="${counter.count>3}"> --%>
						        		<div class="message <c:if test="${counter.count%2==1}">odd</c:if> <c:if test="${counter.count%2==0}">even</c:if>">
							                <div class="pic">
							                <table>
							                	<tr><td><a href="javascript:void(0)" class="messageBoardId" data="${item.boardId}" title="<c:out value="${item.boardName}" />"><span class="boardNameLabel font-header">${item.boardName}</span></a></td></tr>
							                	<c:choose>
							                		<c:when test="${item.showImage}">
							                			<tr><td><a href="javascript:void(0)" class="messageBoardId" data="${item.boardId}" title="<c:out value="${item.boardName}" />"><img src="/100x100/${item.boardUrl}"/></a></td></tr>
							                		</c:when>
							               			<c:otherwise>
							               				<c:choose>
															<c:when test="${item.typeCode eq 'board.unpublished'}">
																<tr><td><a href="javascript:void(0)" class="messageBoardId" data="${item.boardId}" title="<c:out value="${item.boardName}" />"><img src="/images/forbidden.jpg"/></a></td></tr>
															</c:when>
															<c:when test="${item.typeCode eq 'board.sold.unrelatedusers'}">
																<tr><td><a href="javascript:void(0)" class="messageBoardId" data="${item.boardId}" title="<c:out value="${item.boardName}" />"><img src="/images/forbidden.jpg"/></a></td></tr>
															</c:when>
															<c:when test="${item.typeCode eq 'board.processing'}">
																<tr><td><a href="javascript:void(0)" class="messageBoardId" data="${item.boardId}" title="<c:out value="${item.boardName}" />"><img src="/images/processing.jpg"/></a></td></tr>
															</c:when>
														</c:choose>
							               			</c:otherwise>
							               		</c:choose>
							                </table>
							                </div>
							                <div class="sender">
							                	<table>
							                		<tr><td><a href="javascript:void(0)" class="messages_fromUserId" data="${item.fromUserId}"><div class="userNameLabel font-header wordClip">${item.fromFinalName}<c:if test="${item.fromUserIsCompany}">&nbsp;(${item.fromUserCompanyName})</c:if></div></a></td></tr>
							                		<tr><td><a href="javascript:void(0)" class="messages_fromUserId" data="${item.fromUserId}"><img src="${item.fromUserLogo}"/></a></td></tr>
							                	</table>
							                </div>
							                <div class="detail">
							                	<!-- <i></i> -->
							                	<table>
							                	<tr><td>
								                    <div class="board"><a href="javascript:void(0)" class="messageBoardId" data="${item.boardId}" title="<c:out value="${item.boardName}" />"><span class="boardNameLabel font-header">${item.boardName}</span></a></div>
								                </td></tr>
								                <tr><td>
							                    <div class="context font-regular"><a href="#message_detail_${item.boardId}_${item.fromUserId}_${item.toUserId}">${item.messageBody}</a></div>
							                    </td></tr>
							                    <%-- <tr><td>
							                    <div class="message_function">
							                    	<a href="#message_detail_${item.boardId}">Reply</a>&nbsp;|&nbsp;<a href="#">Archive</a>&nbsp;|&nbsp;<a href="#">Delete</a>
							                    </div>
							                    </td></tr> --%>
							                    </table>
							                </div>
							                <div class="time font-header"><i></i><span><fmt:formatDate pattern="MMM-dd-yyyy hh:mm a" value="${item.date}"/></span></div>
						            	</div>
						            	<%-- </c:if> --%>
						        	</c:forEach>
					        	</c:otherwise>
				        	</c:choose>
				        </form>
					</div>
				</div>
			</div>
        </div>
    </div>
</div>
<!---end of content----------->