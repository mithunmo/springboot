<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!--  <script type="text/javascript">
initZoom();
</script> -->
<!---set specific id to set  popup width-------->
<div class="popup" id="added_to_cart"> 

<div class="header">
Boards added to your cart
    <div class="close">X</div>
</div>
	<!---Set id to fill in data--->
	<div class="content" id="popup_added_to_cart">
		<c:if test="${count <= 0}"><span style="color:#C30">Your shopping cart is empty. Please add the item and checkout. Thank you.</span></c:if>
        <div class="cart">
        	<div class="entity" id="cart_scrollbar">
				<div class="scrollbar" id="cart_scrollbar_entity"><div class="track"><div class="thumb" style="top: 0px; height: 49.33555555555556px; "><div class="end"></div></div></div></div>
				<div class="viewport">
					<div class="overview" id="industryNews" style="top: 0px;">
						<c:if test="${existInvalidBoard == true}">
							<span style="color:#C30" class="invalid-boards">
								Some items are not available: 
								<c:forEach var="item" items="${invalidBoardList}">
									<a href="javascript:void(0)" class="shoppingCartBoardId" data="${item.boardId}" title="<c:out value="${item.boardName}" />">
										<span><c:out value="${item.boardName}" /></span>
									</a>&nbsp;
								</c:forEach>
							</span>
						</c:if>
						<c:if test="${hasInconsistentItems}">
							<span style="color:#C30;">Some items have been changed after you added to the shopping cart.</span>
						</c:if>
						<c:forEach var="item" items="${cartItems}" varStatus="counter">
							<div class="item <c:if test="${item.hasAltered}">inconsistent</c:if> <c:if test="${counter.count%2==1}">odd</c:if> <c:if test="${counter.count%2==0}">even</c:if>" id="item_id_${item.boardId}">
				            	<div class="pic"><i></i><a href="javascript:void(0)" class="shoppingCartBoardId" data="${item.boardId}" title="<c:out value="${item.boardName}" />"><img src="/100x100/${item.imageUrl}" /></a></div>
				                <div class="description">
				                	<div class="board_info">
				                		<a href="javascript:void(0)" class="shoppingCartBoardId" data="${item.boardId}" title="<c:out value="${item.boardName}" />">
				                			<span><c:out value="${item.boardName}" /></span>
				                		</a>
				                	</div>
				                    <div class="designer_info">Designer: <a href="javascript:void(0)" class="shoppingCartDesignerId" data="${item.designerId}">${item.designerName}</a></div>
				                    <div class="remove_from_cart" id="remove_from_cart_bybid" data="${item.boardId}"><img src="/images/recycle_bin.png" /></div>
				                </div>
				                <div class="price">
				                	$ ${item.boardprice}
				                </div>
				                <div class="processingMask"></div>
			            	</div>
			        	</c:forEach>
					</div>
				</div>
			</div>
            <%-- <div class="item">
            	<div class="pic">Pic</div>
                <div class="description">
                	<div class="board_info">Board Name</div>
                    <div class="designer_info">Designer Name</div>
                </div>
                <div class="price">
                	$0000.00
                </div>
            </div> --%>
        </div>
        <div class="subtotal">
        	SubTotal<div class="price" id="total_price">$ ${total}</div>
            <br />
            <span class="info">(+ Applicable Taxes and Shipping)</span>
        </div>
        <div class="functions" id="popup_checkout_button">
            <c:if test="${count > 0}"><a href="javascript:void(0)" id="to_checkout"><div class="button orangeButton" id="button_checkout">Checkout</div></a></c:if>
        </div>
	</div>    
</div>
<script type="text/javascript">
//Update the count number
$('#lblitemCount').html('${count}');
</script>