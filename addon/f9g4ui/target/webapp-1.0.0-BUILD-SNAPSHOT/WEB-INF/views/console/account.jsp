<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<script>
$(document).ready(function()
	{
		if($.browser.msie && ($.browser.version == "8.0" || $.browser.version == "7.0"))
		{
			logging("layout table on IE 8","#00F");
			$('table tr:even').addClass('even'); 
		    $('table tr:odd').addClass('odd');
		    $("table tr:nth-child(1)").addClass("tr1");
		    $("table td:nth-child(1)").addClass("td1");
		    $("table td:nth-child(2)").addClass("td2");
		    $("table td:nth-child(3)").addClass("td3");
		    $("table td:nth-child(4)").addClass("td4");
		    $("table td:nth-child(5)").addClass("td5");
		    $("table td:nth-child(6)").addClass("td6");
		    $("table td:nth-child(7)").addClass("td7");
		}
		$("#account .tableHeader-holder").height($("#account .tableHeader").height());
		$("#account .tableHeader-holder").css("background-color","#FFF");
		//$("#account .tableHeader").fadeOut();
		$("#account_scrollbar").tinyscrollbar({
			scrollChanged: function(scroll) {
				if(scroll.position().top>-530)
				{
					$("#account .tableHeader-holder").height($("#account .tableHeader").height());
					//$("#account .tableHeader-holder").css("background-color","#FFF");
					//$("#account .tableHeader").fadeOut();
				}
				else
					$("#account .tableHeader").fadeIn();
			}
		});
	});
</script>
<!---Content------------------>
<div class="contentFrame" >
	<div class="content-function">
		<span id="account_summary">Total Sales to Date&nbsp;&nbsp; Amount: $&nbsp;<fmt:formatNumber value="${totalAmount}" minFractionDigits="0" maxFractionDigits="2"/>*&nbsp;&nbsp; Total Boards:&nbsp; ${totalBoards}* &nbsp;&nbsp;</span>
		<div id="account_total">
	  		<span style="font-size:15px;">(*Some boards may still be processing)</span>
  		</div>
	</div>
    <div class="content" id="account">
    	<div class="wall_content">
    		<div class="tableHeader-holder">
    		<table class="tableHeader">
    			<tr>
	        		<td>Board Image</td>
	        		<c:choose>
	        			<c:when test="${sort_column==1}">
	        				<td><a href="#designer_account_0_1_${sort_direction*-1}">Portfolio Name<img src="/images/Arrow_${sort_direction}.png"/></a></td>
	        			</c:when>
	        			<c:otherwise>
	        				<td><a href="#designer_account_0_1_1">Portfolio Name</a></td>
	        			</c:otherwise>
	        		</c:choose>
	        		<c:choose>
	        			<c:when test="${sort_column==2}">
	        				<td><a href="#designer_account_0_2_${sort_direction*-1}">Board Name<img src="/images/Arrow_${sort_direction}.png"/></a></td>
	        			</c:when>
	        			<c:otherwise>
	        				<td><a href="#designer_account_0_2_1">Board Name</a></td>
	        			</c:otherwise>
	        		</c:choose>
	        		<c:choose>
	        			<c:when test="${sort_column==3}">
	        				<td><a href="#designer_account_0_3_${sort_direction*-1}">Purchaser<img src="/images/Arrow_${sort_direction}.png"/></a></td>
	        			</c:when>
	        			<c:otherwise>
	        				<td><a href="#designer_account_0_3_1">Purchaser</a></td>
	        			</c:otherwise>
	        		</c:choose>
	        		<c:choose>
	        			<c:when test="${sort_column==4}">
	        				<td><a href="#designer_account_0_4_${sort_direction*-1}">Price<img src="/images/Arrow_${sort_direction}.png"/></a></td>
	        			</c:when>
	        			<c:otherwise>
	        				<td><a href="#designer_account_0_4_1">Price</a></td>
	        			</c:otherwise>
	        		</c:choose>
	        		<c:choose>
	        			<c:when test="${sort_column==5}">
	        				<td><a href="#designer_account_0_5_${sort_direction*-1}">Date Sold<img src="/images/Arrow_${sort_direction}.png"/></a></td>
	        			</c:when>
	        			<c:otherwise>
	        				<td><a href="#designer_account_0_5_1">Date Sold</a></td>
	        			</c:otherwise>
	        		</c:choose>
	        		<c:choose>
	        			<c:when test="${sort_column==6}">
	        				<td><a href="#designer_account_0_6_${sort_direction*-1}">Status<img src="/images/Arrow_${sort_direction}.png"/></a></td>
	        			</c:when>
	        			<c:otherwise>
	        				<td><a href="#designer_account_0_6_1">Status</a></td>
	        			</c:otherwise>
	        		</c:choose>
				</tr>
    		</table>
    		</div>
    		<div class="entity" id="account_scrollbar">
				<div class="scrollbar" id="account_scrollbar_entity"><div class="track"><div class="thumb"><div class="end"></div></div></div></div>
				<div class="viewport">
					<div class="overview" id="industryNews" style="top: 0px;">
						<c:choose>
							<c:when test="${!empty boardList}">
								<div class="tilesView" id="accountTiles">
									<div class="Tiles-view">
									<div class="Tiles-view-overlay" style="display:none; width:100%; height:100%; z-index:499; background-color: #FFF; opacity:0.8; position:absolute;"></div>
									<c:forEach var="item" items="${boardList}" varStatus="counter">
										<%-- <a href="#message_detail_${item.boardId}_${item.fromUserId}_${item.toUserId}"> --%>
										<%-- <div class="messageTile" style="top:${counter.count*30+10}px; left:${(counter.count-1)*200+50}px; z-index:${-(counter.count-3)};"> --%>
										<div class="Tile">
											<div class="tile-content">
												<div class="background"></div>
												${item.portfolioName}
												<br />
												<a href="javascript:void(0);" class="designerAccountBoardId" data="${item.boardId}" title="<c:out value="${item.boardName}" />"><span>${item.boardName}</span></a>
												<a href="javascript:void(0);" class="designerAccountUserId" data="${item.purchaserId}">${item.purchaserName}</a>
												<br />
												$&nbsp;${item.boardPrice}
												<br />
												<fmt:formatDate pattern="MMM-dd-yyyy" value="${item.dateSold}" />
												<br />
												${item.paymentStatus}
											</div>
											<div class="touchArea" data="${item.boardId}"></div>
											<img src="/400x400/${item.tileImageUrl}">
										</div>
										<!-- </a> -->
									</c:forEach>
									</div>
									<div class="Tiles-function">
										<a href="javascript:void(0);" class="Tiles-pre"></a>
										<a href="javascript:void(0);" class="Tiles-next"></a>
									</div>
								</div>
								<table>
						    		<c:forEach var="item" items="${boardList}">
						    			<tr>
						        			<td><a href="javascript:void(0);" class="designerAccountBoardId" data="${item.boardId}" title="<c:out value="${item.boardName}" />"><div class="board"><img src="/100x100/${item.boardImage}" /></div></a></td>
						            		<td>${item.portfolioName}</td>
						                	<td><a href="javascript:void(0);" class="designerAccountBoardId" data="${item.boardId}" title="<c:out value="${item.boardName}" />">${item.boardName}</a></td>
						                	<td><a href="javascript:void(0);" class="designerAccountUserId" data="${item.purchaserId}">${item.purchaserName}</a></td>
						                	<td>${item.boardPrice}</td>
						                	<td><fmt:formatDate pattern="MMM-dd-yyyy" value="${item.dateSold}" /></td>
						                	<td>${item.paymentStatus}</td>
						           		</tr>
						    		</c:forEach>
						       	</table>
							</c:when>
							<c:otherwise>
								<div class="loadingPanel" id="accountEmptyPanel">
           							<div class="loadingOverlay"></div>
           							<div class="loadingSpinner"><span>Empty</span></div>
           						</div>
							</c:otherwise>
				       	</c:choose>
					</div>
				</div>
			</div>
       	</div>
    </div>
    <div class="pagin" id="account_pagination">
    	Pages:&nbsp;
    	<c:forEach var="item" items="${pageList}" varStatus="rowCounter">
		${item}
		</c:forEach>
	</div>
</div>
<!---end of content----------->