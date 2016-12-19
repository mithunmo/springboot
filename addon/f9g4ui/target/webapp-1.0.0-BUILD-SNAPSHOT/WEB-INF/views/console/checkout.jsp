<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page import="com.f9g4.web.utils.ViewPaths" %>
 
<script type="text/javascript">
	$(document).ready(function()
	{
		$("#checkout_scrollbar").tinyscrollbar();
	});
</script>
<!---Content------------------>
<div class="contentFrame" >
	<div class="content-function">
		<div id="shopping_cart_function">
			<div class="button" id="shopping_cart_update">Update Changes</div>
			<a href="javascript:void(0);" id="back_to_search_result"><div class="button">Back to Search Results</div></a>
		</div>
	</div>
    <div class="content" id="shopping_cart">
		<div class="cart_header">
			<div class="header_filetype">File Type</div>
            <div class="header_remove">Remove</div>
            <div class="header_total">Total</div>
        </div>
        <form:form path="deleteCartItemsForm" id="form_shopping_cart">
    	<div class="cart">
    		<div class="entity" id="checkout_scrollbar">
				<div class="scrollbar" id="checkout_scrollbar_entity" style="height: 222px; "><div class="track" style="height: 222px; "><div class="thumb" style="top: 0px; height: 49.33555555555556px; "><div class="end"></div></div></div></div>
				<div class="viewport">
					<div class="overview" id="industryNews" style="top: 0px;">
						<c:if test="${existInvalidBoard==true}">
				    		<div id="invalidBoardList">
					    		<span style="color:#C30" class="invalid-boards">
								Some items are not available: 
								<c:forEach var="item" items="${invalidBoardList}">
									<a href="javascript:void(0)" class="checkoutBoardId" data="${item.boardId}" title="<c:out value="${item.boardName}" />">
										<span><c:out value="${item.boardName}" /></span>
									</a>,
								</c:forEach>
								</span>
							</div>
						</c:if>
						<c:if test="${hasInconsistentItems}">
							<div id="inconsistentBoardList">
								<span style="color:#C30;">Some of the items in your cart have changed and highlighted below. Please review and checkout.</span>
							</div>
						</c:if>
			    		<c:forEach var="item" items="${cartItems}">
			    			<div class="item <c:if test="${item.hasAltered}">inconsistent</c:if>">
				            	<div class="pic"><a href="javascript:void(0)" class="checkoutBoardId" data="${item.boardId}" title="<c:out value="${item.boardName}" />"><img src="/100x100/${item.imageUrl}" /></a></div>
				            	<div class="icon"><i></i><a href="javascript:void(0)" class="checkoutDesignerId" data="${item.designerId}" ><img src="${item.designerLogo}" /></a></div>
				                <div class="designer_name"><a href="javascript:void(0)" class="checkoutDesignerId" data="${item.designerId}">${item.designerName}</a></div>
				                <!---<div class="portfolio_name">Portfolio Name</div>--->
				                <div class="board_name">
				                	<a href="javascript:void(0)" class="checkoutBoardId" data="${item.boardId}" title="<c:out value="${item.boardName}" />">
				                		<span><c:out value="${item.boardName}" /></span>
				                	</a>
				                </div>
				                <div class="file_type">
				                	<c:forEach var="saleTypeItem" items="${saleTypeList}">
				                		<c:if test="${saleTypeItem.lookupValueId == item.fileType}">
				                			${saleTypeItem.description}
				                		</c:if>
				                	</c:forEach>
				                </div>
				                <div class="checkbox"><input name="select_item" type="checkbox" value="${item.boardId}" /></div>
				                <div class="total">$ ${item.boardprice}</div>
			            	</div>
			    		</c:forEach>
			            <%-- <div class="item">
			            	<div class="pic"><img src="resource/Images/board/10 thumb_100x100.jpg" /></div>
			                <div class="designer_name"><div class="icon"><i></i><img src="resource/designer_logo.jpg" style="width:50%; height:50%;"/></div>A.R. Austin</div>
			                -<div class="portfolio_name">Portfolio Name</div>-
			                <div class="board_name">Nature Girl</div>
			                <div class="checkbox"><input name="item_1" type="checkbox" value="" /></div>
			                <div class="total">$ 2800.00</div>
			            </div> --%>
					</div>
				</div>
			</div>	
        </div>
        </form:form>	
		
        <div class="checkout">
        	<span class="orangeText center">Please verify above details are correct. ALL SALES ARE FINAL.</span>
        	<div class="security_info">
        		Your Security is Important!
                <br />
               	<a href="http://www.paypal.com" target="new"><img src="/images/paypal.png" /></a>
                <%-- <a href="http://www.verisign.com" target="new"><img src="/images/norton.gif" /></a> --%>
        	</div>
        	<c:choose>
       		<c:when test="${hasError}">
       			<div class="subtotal error">
       				<div>
						<b style="color:#C30">Subtotal $ ${total}&nbsp;<a href="javascript:void(0);" id="checkoutError">(!)</a></b>
						<br />
						<i>(+ Applicable Taxes and Shipping)</i>
					</div>
				</div>
			</c:when>
			<c:otherwise>
				<div class="subtotal">
					<div>
						<b>Subtotal $ ${total}</b>
						<br />
						<i>(+ Applicable Taxes and Shipping)</i>
					</div>
				</div>
			</c:otherwise>
       		</c:choose>
            <div class="terms">
            	<input name="checkOutTAndC" id="form_checkOutTAndC" type="checkbox" value="" disabled="true"/> 
            	<a href="javascript:void(0)" id="shopping_cart_terms">Read and Agree to Terms and Conditions</a>
            </div>
            <%-- <div class="button" id="shopping_cart_checkout">Checkout</div> --%>
            <!-- Paypal -->
           	<div id="shopping_cart_checkout">
           		<c:if test="${count > 0}">
	           		<form id="form_shoppingcart_checkout" action="${pageContext.request.contextPath}<%= ViewPaths.CHECKOUT %>" method="post">
						<input id="checkout_submit" type="image" src="https://www.paypalobjects.com/en_US/i/btn/btn_paynowCC_LG.gif" border="0" name="submit" alt="PayPal - The safer, easier way to pay online!"><div id="paynowMask"></div></input>
						<img alt="" border="0" src="https://www.paypalobjects.com/en_US/i/scr/pixel.gif" width="1" height="1">
					</form>		
				</c:if>
 			</div>			
 			<!-- End of paypal -->
        </div>
    </div>
</div>
<!---end of content----------->