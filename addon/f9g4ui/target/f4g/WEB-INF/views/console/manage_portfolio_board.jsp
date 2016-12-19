<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!---Content------------------>
<div class="contentFrame" id="manage_board_frame">
	<div class="content-function">
		<div id="select_portfolio">
	        <%--Select Portfolio
	        <select name="select_portfolio" id="portfolio_catalog">
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
	        </select> --%>
	        <input type="hidden" name="select_portfolio" id="portfolio_catalog" value="${portfolioList[0].portfolioId}" /><%-- ${portfolioList[0].name} --%>
	    </div>
	    <div id="manage_board_top_functions">
	    	<div><!-- 
	    		<%-- <a href="#edit_portfolio/${currentPortfolio}" id="edit_portfolio" data="${currentPortfolio}"><div class="button">Edit Portfolio</div></a> --%>
	    		<%-- <a href="javascript:void(0)" id="show_all_portfolios"><div class="button">All Portfolios</div></a> --%>
	    	--><a href="javascript:void(0)" class="button" id="add_manage_page" button-disabled='true' data-title="8 pages allowed in portfolio.">New Page</a>
	    	</div>
	    </div>
	</div>
	<!-- <div id="manage_board_functions">
        <a href="javascript:void(0)" id="delete_manage_board">Delete Selected Board</a>&nbsp;&nbsp; 
        <a href="javascript:void(0)" id="clear_manage_board">Clear Selected</a>
        <a href="javascript:void(0)" id="publish_manage_board">Publish Board</a>&nbsp;&nbsp;
    </div> -->
    <%-- <div class="touchbar left_touchbar" id="pboard_carouselPrev"><i></i><img src="/images/arrow_left.png" /></div> --%>
    <div class="content pb" id="manage_board">
    	<form id="form_boards">
	    <div class="mask pb" id="board_mask">
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
    <%-- <div class="touchbar right_touchbar" id="pboard_carouselNext"><i></i><img src="/images/arrow_right.png" /></div> --%>
    <div class="pagin" id="manage_board_pagin"><div class="page" id="page"></div></div>
</div>
<!---end of content----------->