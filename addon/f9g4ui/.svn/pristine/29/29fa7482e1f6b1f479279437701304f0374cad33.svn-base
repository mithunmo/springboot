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
		logging("init design wall scroll bar","#F00");
		$("#design_wall .tableHeader-holder").height($("#design_wall .tableHeader").height());
		$("#design_wall .tableHeader-holder").css("background-color","#FFF");
		//$("#design_wall .tableHeader").fadeOut();
		$("#design_wall_scrollbar").tinyscrollbar({
			wheel: 20
			,scrollChanged: function (scroll) {
				if(scroll.position().top>-530)
				{
					$("#design_wall .tableHeader-holder").height($("#design_wall .tableHeader").height());
					//$("#design_wall .tableHeader-holder").css("background-color","#FFF");
					//$("#design_wall .tableHeader").fadeOut();
				}
				else
					$("#design_wall .tableHeader").fadeIn();
			}
		});
	});
</script>
<!---Content------------------>
<div class="contentFrame" >
	<div class="content-function">
		<span class="content-function-text font-header" style="text-transform:uppercase;">Total Sales to Date: Amount $<fmt:formatNumber value="${totalAmount}" minFractionDigits="0" maxFractionDigits="2"/> Boards (${totalBoards})</span>
	</div>
    <div class="content" id="design_wall">
        <div class="wall_content">
        	<div class="tableHeader-holder">
        	<table class="tableHeader">
	    		<tr>
			        <td>Board Image</td>
			        <td></td>
			        <c:choose>
	        			<c:when test="${sort_column==1}">
	        				<td><a href="#design_wall_0_1_${sort_direction*-1}">Designer Name<img src="/images/Arrow_${sort_direction}.png"/></a></td>
	        			</c:when>
	        			<c:otherwise>
	        				<td><a href="#design_wall_0_1_1">Designer Name</a></td>
	        			</c:otherwise>
	        		</c:choose>
	        		<c:choose>
	        			<c:when test="${sort_column==2}">
	        				<td><a href="#design_wall_0_2_${sort_direction*-1}">Price<img src="/images/Arrow_${sort_direction}.png"/></a></td>
	        			</c:when>
	        			<c:otherwise>
	        				<td><a href="#design_wall_0_2_1">Price</a></td>
	        			</c:otherwise>
	        		</c:choose>
	        		<c:choose>
	        			<c:when test="${sort_column==3}">
	        				<td><a href="#design_wall_0_3_${sort_direction*-1}">Date Purchased<img src="/images/Arrow_${sort_direction}.png"/></a></td>
	        			</c:when>
	        			<c:otherwise>
	        				<td><a href="#design_wall_0_3_1">Date Purchased</a></td>
	        			</c:otherwise>
	        		</c:choose>
	        		<c:choose>
	        			<c:when test="${sort_column==4}">
	        				<td><a href="#design_wall_0_4_${sort_direction*-1}">Status<img src="/images/Arrow_${sort_direction}.png"/></a></td>
	        			</c:when>
	        			<c:otherwise>
	        				<td><a href="#design_wall_0_4_1">Status</a></td>
	        			</c:otherwise>
	        		</c:choose>
			        <td>Link</td>
				</tr>
    		</table>
    		</div>
        	<div class="entity" id="design_wall_scrollbar">
				<div class="scrollbar" id="design_wall_scrollbar_entity" style="height: 222px; "><div class="track" style="height: 222px; "><div class="thumb" style="top: 0px; height: 49.33555555555556px; "><div class="end"></div></div></div></div>
				<div class="viewport">
					<div class="overview" id="industryNews" style="top: 0px;">
						<c:choose>
							<c:when test="${!empty boardList}">
								<div class="tilesView" id="designWallTiles">
									<div class="Tiles-view">
									<div class="Tiles-view-overlay" style="display:none; width:100%; height:100%; z-index:499; background-color: #FFF; opacity:0.8; position:absolute;"></div>
									<c:forEach var="item" items="${boardList}" varStatus="counter">
										<%-- <a href="#message_detail_${item.boardId}_${item.fromUserId}_${item.toUserId}"> --%>
										<%-- <div class="messageTile" style="top:${counter.count*30+10}px; left:${(counter.count-1)*200+50}px; z-index:${-(counter.count-3)};"> --%>
										<div class="Tile">
											<div class="touchArea" data="${item.boardId}" title="<c:out value="${item.boardName}" />"></div>
											<div class="tile-content">
												<div class="background"></div>
												<a href="javascript:void(0)" class="userinfo" data="${item.userName}">${item.firstname} ${item.lastname}</a>
												<br />
												$${item.totalPrice}
												<br />
												<fmt:formatDate pattern="MMM-dd-yyyy" value="${item.sellerPayDate}" />
												<br />
												${item.statusdescription}
												<br />
												<div style="position:absolute; bottom:10px; width:100%; left:0px;">
												<c:if test="${not empty item.mainImageUrl}">
							                		<c:if test="${item.linkBroken}">
							                			<a href="download/<c:out value="${item.mainImageUrl}"/>/<c:out value="${item.fileType}"/>/<c:out value="${item.fileName}"/>/"><div class="button center download-button">Download</div></a>
							                		</c:if>
							                		<c:if test="${not item.linkBroken}">
							                			Please contact Customer Support.
							                		</c:if>
							                	</c:if>
							                	</div>
											</div>
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
					                <td><div class="board"><a href="javascript:void(0)" class="designWallBoardId" data="${item.boardId}" title="<c:out value="${item.boardName}" />"><img src="/100x100/${item.thumbnailName}" /></a><!-- need address for images --></div></td>
					                <td><div class="icon"><!-- need address for images --></div></td>
					                <td><a href="javascript:void(0)" class="userinfo" data="${item.userName}">${item.firstname} ${item.lastname}</a></td>
					                <td>$${item.totalPrice}</td>
					                <td><fmt:formatDate pattern="MMM-dd-yyyy" value="${item.sellerPayDate}" /></td>
					                <td>${item.statusdescription}</td>
					                <td>
					                	<c:if test="${not empty item.mainImageUrl}">
					                		<c:if test="${item.linkBroken}">
					                			<a href="download/<c:out value="${item.mainImageUrl}"/>/<c:out value="${item.fileType}"/>/<c:out value="${item.fileName}"/>/"><div class="button center download-button">Download</div></a>
					                		</c:if>
					                		<c:if test="${not item.linkBroken}">
					                			Please contact Customer Support.
					                		</c:if>
					                	</c:if>
					                </td>
					              </tr>
					              </c:forEach>
					            </table>
							</c:when>
							<c:otherwise>
								<div class="loadingPanel" id="designWallEmptyPanel">
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
    <div class="pagin tab-content-pagin" id="design_wall_pagination">
    	Pages:&nbsp;
    	<c:forEach var="item" items="${pageList}" varStatus="rowCounter">
		${item}
		</c:forEach>
	</div>
</div>
<!---end of content----------->