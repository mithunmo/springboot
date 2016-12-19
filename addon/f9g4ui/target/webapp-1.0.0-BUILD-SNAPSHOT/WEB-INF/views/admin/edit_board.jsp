<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page import="com.f9g4.web.utils.ViewPaths" %>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

    <div class="content" id="create_board">
		<form:form modelAttribute="createBoardForm" id="form_create_board" method="POST">
	    	<div class="content-function">
	        	<div class="oldPortfolio">
	        		<span id="label_portfolio">Portfolio:&nbsp;&nbsp;</span>
	                <c:forEach var="item" items="${portfolioList}">
	                	<c:if test="${portfolioId == item.portfolioId}">
	                		<c:set var="seasonYearId" value="${item.seasonYearId}"/>
	                		<a class="text-wrapper" title="<c:out value="${item.name}"/>" data="${portfolioId}" id="showBoardsByPortfolio"><c:out value="${item.name}"/></a>
	                	</c:if>
	                </c:forEach>
	                <span class="text-wrapper" style="width:150px;">${boardDetail.category.categoryLevel1Value}</span>
	                <span>&nbsp;&nbsp; &gt; &nbsp;&nbsp;</span>
	                <span class="text-wrapper" style="width:150px;">${boardDetail.category.categoryLevel2Value}</span>
	                &nbsp;&nbsp;&nbsp;
	                <c:forEach var="item" items="${seasonYear}">
	                	<c:if test="${item.seasonYearId == seasonYearId}">
	                		<span class="text-wrapper" style="width:150px; color:#FFF;">(${item.season})</span>
	                	</c:if>
	                </c:forEach>
	            </div>
	            <div id="board-gallery" class="board-gallery">
	            	<div class="board-gallery-controller">
	            		<a href="javascript:void(0);" class="control-prev">&lt;&nbsp;Prev</a> 
	            		<a href="javascript:void(0);" class="control-next">Next&nbsp;&gt;</a>
	            	</div>
	            	<div class="board-gallery-wrapper">
	            		<ul>
		            	<c:forEach var="item" items="${boardsByPortfolio}" varStatus="counter">
		            		<li>
		            		<c:choose>
		            			<c:when test="${item.boardId == boardDetail.boardId}">
		            				<img class="drawer_boardId highlight" data="${item.boardId}" src="/100x100/${item.boardImages[0].thumbnailUrl}" title="<c:out value="${item.name}" />"/>
		            			</c:when>
		            			<c:otherwise>
		            				<img class="drawer_boardId" data="${item.boardId}" src="/100x100/${item.boardImages[0].thumbnailUrl}" title="<c:out value="${item.name}" />"/>
		            			</c:otherwise>
		            		</c:choose>
		            		</li>
		            	</c:forEach>
		            	</ul>
	            	</div>
	            </div>
	    	</div>
	        <div class="upload_board">
	        	<div class="preview" id="create_board_review">
	            	<c:if test="${!empty boardDetail}"><i></i><img id="preview_board" src="/100x100/${boardDetail.boardImages[0].thumbnailUrl}"/></c:if>
	            </div>
	            <div style="margin-left:10px; width:170px;">
	        		<div id="label_board_name" class="font-header cap-bold">Board Name</div>
	        		<div class="text-wrapper" title="<c:out value="${boardDetail.name}"/>"><c:out value="${boardDetail.name}"/></div>
	        		<div id="label_description" class="font-header cap-bold">Description</div>
	        		<div class="text-wrapper" title="<c:out value="${boardDetail.description}"/>"><c:out value="${boardDetail.description}"/></div>
	        	</div>
	            <%-- <div class="button" id="upload_ai">Upload</div> --%>
	            <div id="label_upload_image"></div>
	            <!-- <input type="hidden" name="boardImageUrl" id="form_board_image_url" value=""/> -->
	            <%-- <form:hidden path="boardImageUrl" id="form_board_image_url" value="${boardDetail.boardImages[0].sourceFileURL}"/>
	            <form:hidden path="boardImageType" id="form_board_image_type" value="${boardDetail.boardImages[0].fileType}"/>
	            <form:hidden path="boardImageUrl_file" id="form_board_image_urL_file" value="${boardDetail.boardImages[0].fileName}"/>
	            <form:hidden path="boardImageUrl_thumb" id="form_board_image_urL_thumb" value="${boardDetail.boardImages[0].thumbnailUrl}"/> --%>
	            <form:hidden path="boardImageUrl_main" id="form_board_image_urL_main" value="${boardDetail.boardImages[0].mainImageUrl}"/>
	            <!-- keywords fields -->
	           	<div class="keywords-session">
	           		<table>
	           			<tr class="session-header"><td colspan="2"><span class="font-header cap-bold">Key Words</span></td></tr>
		            	<tr>
		           			<td class="keyword-label">KEY WORDS (Inspiration/Trends)</td>
		           			<td><form:input path="subKeywords_1" value="${skw1}" maxlength="100"/></td>
		            	</tr>
		            	<tr>
		           			<td class="keyword-label">KEY WORDS (Design details)</td>
		           			<td><form:input path="subKeywords_2" value="${skw2}" maxlength="100"/></td>
		            	</tr>
		            	<tr>
		           			<td class="keyword-label">KEY WORDS (Fabric)</td>
		           			<td><form:input path="subKeywords_3" value="${skw3}" maxlength="100"/></td>
		            	</tr>
		            	<tr>
		           			<td class="keyword-label">KEY WORDS (Others)</td>
		           			<td><form:input path="subKeywords_4" value="${skw4}" maxlength="100"/></td>
		            	</tr>
		                <!-- <input name="form_key_words" type="text" /> -->
	                </table>
	           	</div>
	            <!--  -->
	            <div style="width:100%; clear:both; height:1px;"></div>
	        </div>
	        <div class="detail">
	        	<div class="leftArea">
	            	<%-- <div id="label_board_name" class="font-header cap-bold">Board Name</div>
	                <!-- <input name="form_board_name" type="text" /> -->
	                <form:input path="boardName" id="form_board_name" value="${boardDetail.name}" maxlength="300"/>
	                <div class="text-wrapper" title="<c:out value="${boardDetail.name}"/>"><c:out value="${boardDetail.name}"/></div>
	                <div id="label_description" class="font-header cap-bold">Description</div>
	                <!-- <input name="form_description" type="text" /> -->
	                <form:input path="boardDescription" id="form_board_description" value="${boardDetail.description}" maxlength="300"/>
	                <div class="text-wrapper" title="<c:out value="${boardDetail.description}"/>"><c:out value="${boardDetail.description}"/></div> --%>
	                <div style="width:100%; height:25px;"></div>
	                <div id="label_product" class="font-header cap-bold">Product</div>
	                <div style="width:100%;">
	                <form:select path="productTags" id="product" multiple="true">
	                	<c:forEach var="item" items="${productList}">
	                		<c:choose>
	 	               			<c:when test="${not empty boardCategoryLevel3HM[item.name]}">
	 	               				<form:option value="${item.name}" selected="selected">${item.name}</form:option>
	                			</c:when>
	                			<c:otherwise>
	                				<form:option value="${item.name}">${item.name}</form:option>
	                			</c:otherwise>
	                		</c:choose>
	                	</c:forEach>
	                </form:select>
	                </div>
					<div id="label_product_type" class="font-header cap-bold">Product Type / Style</div>
					<div style="width:100%;">
	                <form:select path="productTypeTags" id="productType" multiple="true">
	                	<c:if test="${empty productTypeList}">
                			<option value="-1" disabled="disabled">-Please select Product above-</option>
                		</c:if>
	                	<c:forEach var="item" items="${productTypeList}">
	                		<c:choose>
	                			<c:when test="${not empty productTypeHM[item.name]}">
	 	               			<%-- <c:when test="${item.categoryId == boardDetail.categoryLevel4Id}"> --%>
	 	               				<form:option value="${item.name}" selected="selected">${item.name}</form:option>
	                			</c:when>
	                			<c:otherwise>
	                				<form:option value="${item.name}">${item.name}</form:option>
	                			</c:otherwise>
	                		</c:choose>
	                	</c:forEach>
                	</form:select>
                	</div>
	            </div>
	            <div class="rightArea">
	            	<!-- <span class="saleType" id="label_sale_type">Sale Type</span> <span class="pricing" id="label_pricing">Pricing</span> -->
	                <table id="saleTypeTable">
	                  <tr class="tableHeader">
	                    <!-- <td width="5%"></td> -->
	                    <td width="50%"><span id="label_sale_type">File Types + Available Options</span></td>
	                    <td width="45%"><span id="label_pricing">Price</span><!-- &nbsp;&nbsp;<a id="price_guideline_link">Pricing Guideline</a> --></td>
	                    <%-- <td width="30%">
	                    	Designer Price<br /><span class="smalltext">(After deducting commission)</span>
	                        <!-- <input name="f4g_rate" id="f4g_rate" type="hidden" value="0.1" /> -->
	                        <form:hidden path="rate" id="f4g_rate" value="0.1"/>
	                        <form:hidden path="price" id="form_final_price" value=""/>
	                    </td> --%>
	                  </tr>
	                  <c:forEach var="item" items="${saleTypeList}" varStatus="rowCounter">
	                  	<c:if test="${boardDetail.saleTypeId == item.lookupValueId}">
	                	<tr  class="grayBackground">
	                  		<%-- <td>
                  				<form:radiobutton path="saletype" id="form_saletype_${rowCounter.count}" value="${item.lookupValueId}" checked="checked" code="${item.lookupCode}" />
	                  		</td> --%>
	                  		<td>${item.description}</td>
	                  		<td id="saletype_${rowCounter.count}"><input name="price" type="text" id="form_board_price" class="cost" value="${boardDetail.boardPrice}"/></td>
	                  		<%-- <td class="final_price" id="saletype_${rowCounter.count}_final">0000.00</td> --%>
	                  	</tr>
	                  	</c:if>
	                  </c:forEach>
	                </table>
	                <div class="calculate_functions">
	                	<%-- <a href="javascript:void(0)" id="create_board_clear">Clear All</a> --%>
	                </div>    
	                <%-- <div id="expDays">Select expiration range: 
	                	<form:radiobutton id="form_exp_1" path="expirationDays" label="30 Days" value="30" />
	                	<form:radiobutton id="form_exp_2" path="expirationDays" label="60 Days" value="60" checked="checked"/>
	                	<form:radiobutton id="form_exp_3" path="expirationDays" label="90 Days" value="90" /> 
	        		</div> --%>
	                <!-- <div id="text_commision"> (*Money will be credited after deducting appropriate <a id="showCommission">commission</a>)</div> -->
	                <div id="text_commision">User current commission rate: ${commissionRate}%</div>
	                <input type="hidden" id="commissionRate" value="${commissionRate}">
	                <div id="current_exp_days"> Expiration date: <span><fmt:formatDate pattern="MMM-dd-yyyy" value="${expirationDate}"/></span></div>
	            </div>
	            <div class="buttons">
	            	<table style="width:100%;">
	            		<tr>
	            			<td class="td">
	            				<div class="button center" id="admin_save_edit_board">Save</div>
	            			</td>
	            			<!-- <td class="td">
	            				<div class="button" id="publish_create_board">Save &amp; Publish</div>
	            			</td> -->
	            			<td class="td">
	            				<!-- <a href="javascript:void(0)" id="create_board_clear"><div class="button orange">Clear All</div></a> -->
	            				<a href="${pageContext.request.contextPath}<%=ViewPaths.ADMIN_BOARDS_APPROVAL%>${cancelParams}"><div class="button orange" id="cancel">Cancel</div></a>
	            			</td>
	            			<td class="td">
	            				<%-- <a href="${pageContext.request.contextPath}<%=ViewPaths.ADMIN_BOARDS_APPROVAL %>"><div class="button orange" id="cancel">Cancel</div></a> --%>
	            			</td>
	            		</tr>
	            	</table>
	            	<form:hidden path="boardId" id="form_board_id" value="${boardDetail.boardId}"/>
	            	<input type="hidden" id="portfolioId" value="${portfolioId}"/>
	            </div>
	            <div class="manual">      
	            </div>
	            <!-- -->
	        </div>
	    </form:form>
    </div>
<script type="text/javascript">
	//retrieve the board price range from property file.
	var minimunBoardPrice = ${minimunBoardPrice};
	var maximunBoardPrice = ${maximunBoardPrice};
	//bind currentValue of product type to its element
	//refershMultiselect("#product");
	//refershMultiselect("#productType");
	categoryMSInit();
</script>