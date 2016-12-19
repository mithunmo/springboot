<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<script type="text/javascript">
	$(document).ready(function()
	{
		//initialize jHtmlArea plugin
		/* logging("Init jHTMLArea plugin in message detail","#F00");
		var settings={
				toolbar: [
				          "bold", "italic", "underline",
				          "|",
				          "h1", "h2", "h3", "h4", "h5", "h6",
				          "|",
				          "link", "unlink"
				      ]
				  };
		var noButton={ toolbar: []};
		//$('#messageContent').htmlarea(noButton); */
		logging("init scroll bar","#F00");
		$("#message_content_scrollbar").tinyscrollbar();
		wrapMessageDetail();
	});
</script>
<!---Content------------------>
<div class="contentFrame" >
	<div class="content-function">
		<div class="searchPanel" style="float:right;margin-top:8px;"><a id="back_to_messages"><div class="button">Back to Messages</div></a></div>
	</div>
    <div class="content" id="message_detail">
        <div class="msg_profile">
            <div class="icon">
            	<c:if test="${showBoardImage && typeCode eq 'board.processing.designer'}">
            		<div class="icon-badge">Reviewing</div>
            	</c:if>
            	<a href="javascript:void(0)" class="messageDetailBoardId" data="${boardDetail.boardId}" title="<c:out value="${boardDetail.name}" />">
            		<c:choose>
            			<c:when test="${showBoardImage}">
            				<img src="/400x400/${boardImageUrl}" />
            			</c:when>
            			<c:otherwise>
            				<c:choose>
								<c:when test="${typeCode eq 'board.unpublished'}">
									<img src="/images/forbidden.jpg">
								</c:when>
								<c:when test="${typeCode eq 'board.sold.unrelatedusers'}">
									<img src="/images/forbidden.jpg">
								</c:when>
								<c:when test="${typeCode eq 'board.processing'}">
									<img src="/images/processing.jpg">
								</c:when>
							</c:choose>
            			</c:otherwise>
            		</c:choose>
            	</a>
            </div>
            <div class="detail">
               	<a href="javascript:void(0)" class="messageDetailBoardId" data="${boardDetail.boardId}" title="<c:out value="${boardDetail.name}" />">
               		<span>
               		<c:choose>
        				<c:when test="${fn:length(boardDetail.name)>71}">
        					<c:out value="${fn:substring(boardDetail.name, 0, 70)}"/>&nbsp;...
        				</c:when>
        				<c:otherwise>
        					<c:out value="${boardDetail.name}"/>
        				</c:otherwise>
        			</c:choose>
        			</span>
               	</a>
               	<a href="javascript:void(0)" class="messageDetailDesignerId" data="${boardDetail.originalUserId}"><span>${boardDesigner}</span></a>
            </div>
        </div>
        <div id="replyBox">
        	<div class="comm-protocol-holder">
        		<label><input type="checkbox" id="commProtocol" />
        		<c:choose>
        			<c:when test="${user.userType=='DG'}">
        				<spring:message code="communication.protocol.designer"/>
        			</c:when>
        			<c:otherwise>
        				<spring:message code="communication.protocol.company"/>
        			</c:otherwise>
        		</c:choose>
        		</label>
        	</div>
	       	To: ${replyToUserName}<c:if test="${replyToUserIsCompany == true}">(${replyToUserCompanyName})</c:if>&nbsp;&nbsp;<span style="color:#C30;">(<span id="leftWords">1000</span> characters left)</span><div id="sendMessage"><a id="send_reply">Send</a></div>
	        <textarea maxlength="1000" id="messageContent" name="messageContent" placeholder="Reply here"></textarea>
	        <form:form modelAttribute="messageForm" id="replyForm">
	        	<input type="hidden" name="messageBody" id="messageBody" />
	        	<input type="hidden" name="boardId" id="boardId" value="${boardDetail.boardId}" />
		        <input type="hidden" name="boardName" id="boardName" value="<c:out value="${boardDetail.name}"/>" />
		        <input type="hidden" name="toUserId" value="${replyToUserId}" />
        	</form:form>
       	</div>
        <div class="message_content">
        	<a href="javascript:void(0);" id="expandAll">Expand All</a>
        	<div class="entity" id="message_content_scrollbar">
				<div class="scrollbar" id="message_content_scrollbar_entity"><div class="track"><div class="thumb" style="top: 0px; height: 49.33555555555556px; "><div class="end"></div></div></div></div>
				<div class="viewport">
					<div class="overview" id="industryNews" style="top: 0px;">
						<c:forEach var="item" items="${messageHistory}" varStatus="rowCounter">
			        		<c:choose>
			        		<c:when test="${rowCounter.count<=3}">
			       				<c:choose>
				        			<c:when test="${item.toUserId == user.userId}">
							            <div class="post">
							            	<div class="date"><fmt:formatDate pattern="MMM-dd-yyyy hh:mm a" value="${item.creationDate}"/></div>
							                <div class="icon">
							                <a href="javascript:void(0)" class="messageDetailDesignerId" data="${replyToUserId}"><img src="${replyToUserLogo}" style="width:100%; height:100%;"/></a>
							                </div>
							                <div class="entry">
							                    <div class="sender" id="sender_1"><a href="javascript:void(0)" class="messageDetailDesignerId" data="${replyToUserId}">${replyToUserName}<c:if test="${replyToUserIsCompany == true}">(${replyToUserCompanyName})</c:if></a></div>
							                    <div class="viewarea">
							                    	<div class="context">
							                   			${item.messageBody}
							                   		</div>
							                    </div>
							                </div>
							            </div>
						            </c:when>
						            <c:otherwise>
							            <div class="reply">
							            	<div class="date"><fmt:formatDate pattern="MMM-dd-yyyy hh:mm a" value="${item.creationDate}"/></div>
							            	<div class="icon">
							                <img src="${user.logoimageurl}" style="width:auto; height:100%;"/>
							                </div>
							                <div class="entry">
							                	<div class="author">${user.firstname}&nbsp;${user.lastname}</div>
							                	<div class="viewarea">
							                    	<div class="context">
							                    	${item.messageBody}
							                    	</div>
							                    </div>
							                </div>
							            </div>
						            </c:otherwise>
			           			</c:choose>
				           	</c:when>
				           	<c:otherwise>
				           		<%-- When the count larger than 3, add hidden class for each item --%>
				           		<c:if test="${rowCounter.count==4}">
				           			<div id="buttonShowMore">Show&nbsp;More</div>
				           		</c:if>
				           		<c:choose>
				        			<c:when test="${item.toUserId == user.userId}">
							            <div class="post hidden">
							            	<div class="date"><fmt:formatDate pattern="MMM-dd-yyyy hh:mm a" value="${item.creationDate}"/></div>
							                <div class="icon">
							                <a href="javascript:void(0)" class="messageDetailDesignerId" data="${replyToUserId}"><img src="${replyToUserLogo}" style="width:100%; height:100%;"/></a>
							                </div>
							                <div class="entry">
							                    <div class="sender" id="sender_1"><a href="javascript:void(0)" class="messageDetailDesignerId" data="${replyToUserId}">${replyToUserName}<c:if test="${replyToUserIsCompany == true}">(${replyToUserCompanyName})</c:if></a></div>
							                    <div class="viewarea">
							                    	<div class="context">
							                   		${item.messageBody}
							                  		</div>
							                    </div>
							                </div>
							            </div>
						            </c:when>
						            <c:otherwise>
							            <div class="reply hidden">
							            	<div class="date"><fmt:formatDate pattern="MMM-dd-yyyy hh:mm a" value="${item.creationDate}"/></div>
							            	<div class="icon">
							                <img src="${user.logoimageurl}" style="width:auto; height:100%;"/>
							                </div>
							                <div class="entry">
							                	<div class="author">${user.firstname}&nbsp;${user.lastname}</div>
							                	<div class="viewarea">
							                    	<div class="context">
							                    	${item.messageBody}
							                    	</div>
							                    </div>
							                </div>
							            </div>
						            </c:otherwise>
				           		</c:choose>
				           	</c:otherwise>
				           	</c:choose>
			            </c:forEach>
					</div>
				</div>
			</div>
        	      
            
            <!-- <div class="post">
                <div class="icon">
                <img src="resource/designer_logo.jpg" style="width:100%; height:100%;"/>
                </div>
                <div class="date">July, 11, 2012&nbsp;&nbsp;09:30 a.m.</div>
                <div class="entry">
                    <div class="sender" id="sender_2">A.R. Austin</div>
                    <div class="context">
                   	Hi, made the necessary changes, please take a look and let me know your thoughts, Thank You.
                    </div>
                </div>
            </div>
            <div class="replyLink" id="reply_2">
                <a href="#">Reply</a>
            </div>
            
            <div class="replyLink" id="reply_4">
                <a href="#">Reply</a>
            </div> -->
            <!---End of content----------------------------------------->
        </div>
    </div>
</div>
<!---end of content----------->