<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!---Content------------------>
<script type="text/javascript">
	var creditConversionToUsd = ${creditConversionToUsd};
</script>
<div class="contentFrame mbf" id="manage_board_frame">
	<div class="content-function">
		<div class="p-img-container">
		<c:forEach var="item" items="${portfolio.portfolioImages}">
			<c:if test="${item.activeStatus == 1}">
				<img class="p-img-thumb" src="/100x100/${item.thumbnailUrl}" />
			</c:if>	
		</c:forEach>
		</div>
		<div id="select_portfolio">
	        Collection
	        <select name="select_portfolio" id="collection_catalog">
	        	<c:forEach var="item" items="${portfolioList}">
	        		<c:choose>
	        			<c:when test="${currentPortfolio == item.portfolioId}">
	        				<option value="${item.portfolioId}" selected="selected">${item.name}</option>
	        			</c:when>
	        			<c:otherwise>
	        				<option value="${item.portfolioId}">${item.name}</option>
	        			</c:otherwise>
	        		</c:choose>
	        	</c:forEach>
	        </select>
	    </div>
	    <div id="manage_board_top_functions">
	    	<div>
	    		<a href="#edit_collection/${currentPortfolio}" id="edit_portfolio" data="${currentPortfolio}" data-mode="c"><div class="button">Edit Collection</div></a>
	    		<a href="javascript:void(0)" id="show_all_portfolios"><div class="button">All Collections</div></a>
	    		<a href="javascript:void(0)" id="add_manage_board"><div class="button">New Board</div></a>
	    	</div>
	    </div>
	</div>
	<!-- <div id="manage_board_functions">
        <a href="javascript:void(0)" id="delete_manage_board">Delete Selected Board</a>&nbsp;&nbsp; 
        <a href="javascript:void(0)" id="clear_manage_board">Clear Selected</a>
        <a href="javascript:void(0)" id="publish_manage_board">Publish Board</a>&nbsp;&nbsp;
    </div> -->
    <div class="touchbar left_touchbar" id="board_carouselPrev"><i></i><img src="/images/arrow_left.png" /></div>
    <div class="content" id="manage_board">
    	<form id="form_boards">
	    <div id="board_mask">
		    <!---Put items here, each li has maximal 8 items--->
		   	<div class="data">
		   		<!-- <div class="item">
				<a href="#board_item_1" id="board_1">
					<div class="board"></div>
				</a>
					<div class="detail">
					<div class="board_name">Board #</div>
					<div class="edit"><a href="#edit_board_1">Edit</a></div>
					<div class="price">Price $0.00</div>
					<div class="checkbox"><input name="board_1" type="checkbox" value="" id="form_board_1"/></div>
					</div>
		        </div> -->
		    </div>
		    <!--End of items-------------------------->
	    </div>
	    </form>
    </div>
    <div class="touchbar right_touchbar" id="board_carouselNext"><i></i><img src="/images/arrow_right.png" /></div>
    <div class="pagin" id="manage_board_pagin"><div class="page" id="page"></div></div>
</div>
<!---end of content----------->