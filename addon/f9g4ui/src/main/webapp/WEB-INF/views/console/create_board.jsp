<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!---Content------------------>
<script type="text/javascript">
	//retrieve the board price range from property file.
	var minimunBoardPrice = ${minimunBoardPrice};
	var maximunBoardPrice = ${maximunBoardPrice};
	var creditConversionToUsd = ${creditConversionToUsd};
</script>
<div class="contentFrame" >
    <div class="content" id="create_board">
    <form:form modelAttribute="createBoardForm" id="form_create_board" method="POST">
    	<div class="content-function">
        	<div class="oldPortfolio">
        		<span id="label_portfolio">Collection</span>
                <!-- <select name="form_old_portfolio">
                	<option value="1">1</option>
                    <option value="2">2</option>
                </select> -->
                <form:select path="portfolioId" multiple="false" edit-mode='${editMode}'>
                	<c:forEach var="item" items="${portfolioList}">
                		<c:choose>
                			<c:when test="${portfolioId == item.portfolioId}">
                				<form:option value="${item.portfolioId}" selected="selected">${item.name}</form:option>
                			</c:when>
                			<c:otherwise>
                				<form:option value="${item.portfolioId}">${item.name}</form:option>
                			</c:otherwise>
                		</c:choose>
                	</c:forEach>
                </form:select>
            </div>
    	</div>
        <div class="upload_board">
        	<div class="preview" id="create_board_review">
            	<c:if test="${!empty boardDetail}"><i></i><img id="preview_board" src="/100x100/${boardDetail.boardImages[0].thumbnailUrl}"/></c:if>
            </div>
            <div class="button" id="upload_ai" data-mode="c">Upload</div>
            <div id="label_upload_image"></div>
            <!-- <input type="hidden" name="boardImageUrl" id="form_board_image_url" value=""/> -->
            <form:hidden path="boardImageUrl" id="form_board_image_url" value="${boardDetail.boardImages[0].sourceFileURL}"/>
            <form:hidden path="boardImageType" id="form_board_image_type" value="${boardDetail.boardImages[0].fileType}"/>
            <form:hidden path="boardImageUrl_file" id="form_board_image_urL_file" value="${boardDetail.boardImages[0].fileName}"/>
            <form:hidden path="boardImageUrl_thumb" id="form_board_image_urL_thumb" value="${boardDetail.boardImages[0].thumbnailUrl}"/>
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
	           			<td class="keyword-label">SUBMISSION CODE<%-- KEY WORDS (Others) --%></td>
	           			<td><form:input path="subKeywords_4" value="${skw4}" maxlength="100"/></td>
	            	</tr>
	                <!-- <input name="form_key_words" type="text" /> -->
                </table>
           	</div>
            <!--  -->
        </div>
        <div class="detail">
        	<div class="leftArea">
            	<span id="label_board_name" class="font-header cap-bold">Board Name</span>
                <br />
                <!-- <input name="form_board_name" type="text" /> -->
                <form:input path="boardName" id="form_board_name" value="${boardDetail.name}" maxlength="300"/>
                <br />
                <span id="label_description" class="font-header cap-bold">Description</span>
                <br />
                <!-- <input name="form_description" type="text" /> -->
                <form:input path="boardDescription" id="form_board_description" value="${boardDetail.description}" maxlength="300"/>
                <br />
                <span id="label_product" class="font-header cap-bold">Product</span>
				<div style="width:100%;">
                <!-- <select name="form_product">
                	<option value="1">1</option>
                    <option value="2">2</option>
                </select> -->
                <form:select path="productTags" id="product" multiple="true">
                	<c:if test="${empty productList}">
                		<option value="-1" disabled="disabled">-Empty-</option>
                	</c:if>
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
                <div style="width:100%;">
                <span id="label_product_type" class="font-header cap-bold">Product Type / Style</span>
                <!-- <select name="form_product_type">
                	<option value="1">1</option>
                    <option value="2">2</option>
                </select> -->
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
                    <td width="5%"></td>
                    <td width="50%"><span id="label_sale_type">Board Type</span></td>
                    <td width="45%"><span id="label_pricing">FFG Credits</span>&nbsp;&nbsp;<a id="price_guideline_link">Pricing Guideline</a></td>
                    <%-- <td width="30%">
                    	Designer Price<br /><span class="smalltext">(After deducting commission)</span>
                        <!-- <input name="f4g_rate" id="f4g_rate" type="hidden" value="0.1" /> -->
                        <form:hidden path="rate" id="f4g_rate" value="0.1"/>
                        <form:hidden path="price" id="form_final_price" value=""/>
                    </td> --%>
                  </tr>
                  <c:forEach var="item" items="${saleTypeList}" varStatus="rowCounter">
                	<tr  class="grayBackground">
                  		<td>
                  			<c:choose>
                  				<c:when test="${empty boardDetail && item.lookupValueId==441}">
                  					<form:radiobutton path="saletype" id="form_saletype_${rowCounter.count}" value="${item.lookupValueId}" checked="checked" code="${item.lookupCode}" />
                  				</c:when>
                  				<c:when test="${boardDetail.saleTypeId == item.lookupValueId}">
                  					<form:radiobutton path="saletype" id="form_saletype_${rowCounter.count}" value="${item.lookupValueId}" checked="checked" code="${item.lookupCode}" />
                  				</c:when>
                  				<c:otherwise>
                  					<form:radiobutton path="saletype" id="form_saletype_${rowCounter.count}" value="${item.lookupValueId}" code="${item.lookupCode}" />
                  				</c:otherwise>
                  			</c:choose>
                  		</td>
                  		<td><label for="form_saletype_${rowCounter.count}">${item.description}</label></td>
                  		<c:choose>
                  			<c:when test="${empty boardDetail && item.lookupValueId==441}">
                  				<td id="saletype_${rowCounter.count}"><input class="sale-type-credit no-dec" name="saletype_${rowCounter.count}_cost" type="text" id="form_saletype_${rowCounter.count}_cost" class="cost" value="0" maxlength="3"/>&nbsp;=&nbsp;$&nbsp;<span class="sale-type-conversion" data-row="${rowCounter.count}">0</span></td>
                  			</c:when>
                  			<c:when test="${boardDetail.saleTypeId == item.lookupValueId}">
                  				<td id="saletype_${rowCounter.count}"><input class="sale-type-credit no-dec" name="saletype_${rowCounter.count}_cost" type="text" id="form_saletype_${rowCounter.count}_cost" class="cost" value="${boardDetail.boardPrice}" maxlength="3"/>&nbsp;=&nbsp;$&nbsp;<span class="sale-type-conversion" data-row="${rowCounter.count}">0</span></td>
                  			</c:when>
                  			<c:otherwise>
                  				<td id="saletype_${rowCounter.count}"><span class="sale-type-credit-static">0</span>&nbsp;=&nbsp;<span class="sale-type-conversion" data-row="${rowCounter.count}">$&nbsp;0</span></td>
                  			</c:otherwise>
                  		</c:choose>     		
                  		<%-- <td class="final_price" id="saletype_${rowCounter.count}_final">0000.00</td> --%>
                  	</tr>
                  </c:forEach>
                </table>
                <div class="calculate_functions">
                	<!-- <a href="javascript:void(0)" id="create_board_clear">Clear All</a> -->
                </div>    
                <%-- <div id="expDays">Select expiration range: 
                	<form:radiobutton id="form_exp_1" path="expirationDays" label="30 Days" value="30" />
                	<form:radiobutton id="form_exp_2" path="expirationDays" label="60 Days" value="60" checked="checked"/>
                	<form:radiobutton id="form_exp_3" path="expirationDays" label="90 Days" value="90" /> 
        		</div> --%>
                <%-- <div id="text_commision"> (*Money will be credited after deducting appropriate <a id="showCommission">commission</a>)</div> --%>
                <%-- <div id="current_exp_days"> Your current expiration date: <span><fmt:formatDate pattern="MMM-dd-yyyy" value="${expirationDate}"/></span></div> --%>
                <table id="boardTerms">
                	<tr class="tableHeader"><td>Board Terms</td></tr>
                	<tr class="grayBackground"><td><label id="label_formBmAgreement"><input type="checkbox" name="form_bm_agreement" id="formBmAgreement" />I agree that I have the legal rights to distribute and sell this work,
that it is not displayed on any other websites and that it is my original work.</label></td></tr>
				</table>
				<a class="important" href="/images/file_types_manual.pdf" target="_BLANK">How to upload supported file types?</a>
            </div>
            <div class="buttons">
            	<table style="width:100%;">
            		<tr>
            			<td class="td">
            				<div class="button" id="save_create_board">Save</div>
            			</td>
            			<td class="td">
            				<div class="button" id="publish_create_board">Save &amp; Publish</div>
            			</td>
            			<td class="td">
            				<a href="javascript:void(0)" id="create_board_clear"><div class="button orange">Clear All</div></a>
            			</td>
            			<td class="td">
            				<c:choose>
            					<c:when test="${hasWithPortfolio}">
            						<div class="button orange" id="back_to_boards" data-portfolio="${portfolioId}">Cancel</div>
            					</c:when>
            					<c:otherwise>
            						<div class="button orange" id="back_to_collections">Cancel</div>
            					</c:otherwise>
            				</c:choose>
            			</td>
            		</tr>
            		<tr>
            			<td>
            				<span class="only"><spring:message code="board.manage.save.hint"></spring:message></span>
            			</td>
            			<td>
            				<span class="all"><spring:message code="board.manage.publish.hint"></spring:message></span>
            			</td>
            			<td></td>
            			<td></td>
            		</tr>
            	</table>
            	<form:hidden path="publishToMp" id="form_publish_to_mp" value="0"/>
            	<form:hidden path="boardId" id="form_board_id" value="${boardDetail.boardId}"/> 	
            </div>
            <div class="manual">      
            </div>
            <!----------------------------------------------------------->
        </div>
    </form:form>
    </div>
</div>
<!---end of content----------->