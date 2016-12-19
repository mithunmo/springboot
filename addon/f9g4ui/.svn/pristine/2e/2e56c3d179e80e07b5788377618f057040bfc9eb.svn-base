<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

    <!---Content------------------>
    <div class="contentFrame">
        <div class="content" id="rating">
        	<c:if test="${!hasError}">
            <div class="announcement">
                <span class="greeting">Hello ${user.firstname}&nbsp;${user.lastname}</span>, <spring:message code="${greetingMessageCode}"></spring:message>
                <br />
                We appreciate your time.
            </div>
            <form action="" method="POST" name="form_rating" id="form_rating">
            <div class="items">
            	<div class="group" id="group_1">
                    <div class="item">
                        <div class="icon"><a href="javascript:void(0);" class="ratingUserInfo" data="${ratingUser.userId}"><img src="${ratingUser.logoimageurl}" style="width:100px; hieght:100px;"/></a></div>
                        <div class="detail">
                            <div class="comapny"><a href="javascript:void(0);" class="ratingUserInfo" data="${ratingUser.userId}">${ratingUser.firstname}&nbsp;${ratingUser.lastname}</a></div>
                            <!-- <div class="description">Description</div> -->
                        </div>
                        <div class="rates">
                            <div class="rate">Overall Rating</div>
                            <div class="readonly" id="rate_1"></div>
                            <div class="value" id="rate_1_overall">0</div>
                            <input name="rate_1" type="hidden" value="" />
                        </div>
                    </div>
                    <div class="item">
                        <div class="board">
                       	<a href="javascript:void(0);" class="ratingBoardInfo" data="${board.boardId}"><img src="/100x100/${boardImage}" /></a>
                        </div>
                        <div class="boardDetail">
                            <div class="name"><a href="javascript:void(0);" class="ratingBoardInfo" data="${board.boardId}">${board.name}</a></div>
                            <div class="date">Date of Purchase</div>
                        </div>
                        <div class="rates">
                        	<div class="rateItem">
                                <c:forEach var="item" items="${rate1}">
                            		<c:if test="${item.lookupCode == question1Type}">
                           				<div class="rate">${item.description}</div>
                               			<div class="partial_rating" id="rate_1_1_q"></div>
                               			<div class="value" id="rate_1_1_q_value">0</div>
                           				<input name="rate_1_questionId" type="hidden" value="${item.lookupValueId}" />
                              				<input name="rate_1_1_q" type="hidden" value="" />
                           			</c:if> 		
                                </c:forEach>
                            </div>
                            <div class="rateItem">
                            	<c:forEach var="item" items="${rate2}">
                            		<c:if test="${item.lookupCode == question2Type}">
		                                <div class="rate">${item.description}</div>
		                                <div class="partial_rating" id="rate_1_1_p"></div>
		                                <div class="value" id="rate_1_1_p_value">0</div>
		                                <input name="rate_2_questionId" type="hidden" value="${item.lookupValueId}" />
		                                <input name="rate_1_1_p" type="hidden" value="" />
                                	</c:if>
                                </c:forEach>
                            </div>
                            <div class="rateItem">
                            	<c:forEach var="item" items="${rate3}">
                            		<c:if test="${item.lookupCode == question3Type}">
		                                <div class="rate">${item.description}</div>
		                                <div class="partial_rating" id="rate_1_1_r"></div>
		                                <div class="value" id="rate_1_1_r_value">0</div>
		                                <input name="rate_3_questionId" type="hidden" value="${item.lookupValueId}" />
		                                <input name="rate_1_1_r" type="hidden" value="" />
		                           	</c:if>
                                </c:forEach>
                            </div>
                            <div class="rateItem">
                            	<c:forEach var="item" items="${rate4}">
                            		<c:if test="${item.lookupCode == question4Type}">
		                                <div class="rate">${item.description}</div>
		                                <div class="partial_rating" id="rate_1_1_c"></div>
		                                <div class="value" id="rate_1_1_c_value">0</div>
		                                <input name="rate_4_questionId" type="hidden" value="${item.lookupValueId}" />
		                                <input name="rate_1_1_c" type="hidden" value="" />
                                	</c:if>
                                </c:forEach>
                            </div>
                        </div>
                        <div class="board_comment">
                        Comment
                        <textarea name="comment" cols="35" rows="3" class="nonresizable"></textarea>
                        <input name="boardId" id="ratingBoardId" type="hidden" value="${board.boardId}" />
                        <input name="ratingUserId" id="ratingUserId" type="hidden" value="${ratingUser.userId}" />
                        <input name="messageId" id="ratingMessageId" type="hidden" value="${messageId}" />
                    	</div>
                    </div>
                </div>
            </div>
            <div class="buttons">
            	<div class="button" id="submit_rating">Submit</div>
                <div class="button orange" id="cancel_rating">Cancel</div>
            </div>
            </form>
            </c:if>
            <c:if test="${hasError}">
            	<div class="empty"><i></i><span>${error.defaultMessage} <br /> <a href="javascript:void(0);" class="backHistory">Back</a></span></div>
            </c:if>
        </div>
   	</div>
    <!---end of content----------->
   <!-- <div class="item">
     <div class="board">
     Boards
     </div>
     <div class="boardDetail">
         <div class="name">Portfolio / Board Name</div>
         <div class="number">Board #</div>
         <div class="date">Date of Purchase</div>
     </div>
     <div class="rates">
         <div class="rateItem">
             <div class="rate">Quality of work</div>
             <div class="partial_rating" id="rate_1_2_q"></div>
             <div class="value" id="rate_1_2_q_value">0</div>
             <input name="rate_1_2_q" type="hidden" value="" />
         </div>
         <div class="rateItem">
             <div class="rate">Pricing</div>
             <div class="partial_rating" id="rate_1_2_p"></div>
             <div class="value" id="rate_1_2_p_value">0</div>
             <input name="rate_1_2_p" type="hidden" value="" />
         </div>
         <div class="rateItem">
             <div class="rate">Reliability</div>
             <div class="partial_rating" id="rate_1_2_r"></div>
             <div class="value" id="rate_1_2_r_value">0</div>
             <input name="rate_1_2_r" type="hidden" value="" />
         </div>
         <div class="rateItem">
             <div class="rate">Customization</div>
             <div class="partial_rating" id="rate_1_2_c"></div>
             <div class="value" id="rate_1_2_c_value">0</div>
             <input name="rate_1_2_c" type="hidden" value="" />
         </div>
     </div>
     <div class="board_comment">
     Comment
     <textarea name="comment_1_2" cols="35" rows="3" class="nonresizable"></textarea>
 	</div>
 </div> -->