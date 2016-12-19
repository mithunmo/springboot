<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!---Content------------------>
<c:if test="${editMode}">
	<c:set var="hasDisabled" value="disabled=\"disabled\"" />
</c:if>
<div class="contentFrame" >
    <div class="content" id="create_portfolio">
    <form:form action="" modelAttribute="createPortfolioForm" id="form_create_portfolio" method="POST">
    	<div class="info">The information you select will apply to your new portfolio and any pages stored within it.</div>
        <div class="portfolio">
        	<div class="name">
        		<div class="label" id="label_portfolio_name">Portfolio Name</div>
                <br />
                <!-- <input name="name_of_portfolio" id="form_name_of_portfolio" type="text" /> -->
                <form:input path="portfolioName" id="form_name_of_portfolio" disabled="${editMode}" maxlength="300" />
            </div>
            <div class="description">
            	<div class="label" id="label_portfolio_description">Portfolio Description</div>
                <br />
                <!-- <input name="description_of_portfolio" id="form_description_of_portfolio" type="text" /> -->
                <form:input path="portfolioDescription" id="form_description_of_portfolio" disabled="${editMode}" maxlength="300"/>
            </div>
        </div>
        <div class="detail">
        	<div class="leftArea">
        		<div class="label" id="label_division">Division</div>
                <br />
              
                <form:select path="division" id="form_division" items="${divisionList}" multiple="false" itemValue="categoryId" itemLabel="name" disabled="${editMode}" edit-mode="${editMode}" />
                <br />
                <br />
                <div class="label" id="label_category">Category</div>
                <br />
            
                <form:select path="category" id="form_category" items="${categoryList}"  multiple="false" itemValue="categoryId" itemLabel="name" disabled="${editMode}" />
                <%-- <select>
                	<c:forEach items="${categoryList}" var="item">
                		<option value="${item.categoryId}">${item.name}</option>
                	</c:forEach>
                </select> --%>
            </div>
            <div class="rightArea">
                <div class="label" id="label_season">Season</div>
                <br />
             
                <div id="seasonPanel">
                	<!-- <div id="season"></div> -->
                	<c:forEach var="item" items="${seasonYear}">
                		<c:choose>
                			<c:when test="${item.seasonYearId == seasonId}">
                				<label><input name="season" type="radio" value="${item.seasonYearId}" ${hasDisabled} checked="checked" />${item.season}</label><br />
                			</c:when>
             				<c:otherwise>
             					<label><input name="season" type="radio" value="${item.seasonYearId}" ${hasDisabled} />${item.season}</label><br />
             				</c:otherwise>
             			</c:choose>
             		</c:forEach>
                </div>
            </div>
        </div>
        <div class="images-section">
        	<div class="images-section-item label">
        		Upload portfolio pages
        	</div>
        	<c:forEach begin="1" end="2" varStatus="counter">
        		<div class="sample-item">
        			<div class="sample-item-title">IMAGE ${counter.index} of 2*</div>
					<div class="sample-item-preview" role="${counter.index}">
						<c:if test="${portfolio.portfolioImages[(counter.index-1)].portfolioImageId !=0 && !empty portfolio.portfolioImages[(counter.index-1)].portfolioImageId && portfolio.portfolioImages[(counter.index-1)].activeStatus == 1}">
							<i></i><img src="/100x100/${portfolio.portfolioImages[(counter.index-1)].thumbnailUrl}">
						</c:if>
					</div>
					<div class="sample-item-upload" role="${counter.index}">
						<input id="uploadifyPortfolio${counter.index}" role="${counter.index}" type="file">
					</div>
					<div class="sample-item-delete" role="${counter.index}">
						<label><input type="checkbox" class="delete-portfolio-image" role="${counter.index}" />Delete Image</label>
						<%-- <div class="button orange delete-portfolio-image" role="${counter.index}">Delete</div> --%>
					</div>
					<input type="hidden" class="portfolio_image_id" role="${counter.index}" name="portfolio_image_id" value="${portfolio.portfolioImages[(counter.index-1)].portfolioImageId}"/>
					<input type="hidden" class="filestatus" role="${counter.index}" name="filestatus" value="${isUpdate}" />
					<c:choose>
						<c:when test="${empty portfolio.portfolioImages[(counter.index-1)].activeStatus}">
							<input type="hidden" class="active_status" role="${counter.index}" name="active_status" value="1" />
						</c:when>
						<c:otherwise>
							<input type="hidden" class="active_status" role="${counter.index}" name="active_status" value="${portfolio.portfolioImages[(counter.index-1)].activeStatus}" />
						</c:otherwise>
					</c:choose>
					<input type="hidden" class="filename" role="${counter.index}" name="filename" value="${portfolio.portfolioImages[(counter.index-1)].sourceFileURL}" />
					<input type="hidden" class="filename_ext" role="${counter.index}" name="filename_ext" value="${portfolio.portfolioImages[(counter.index-1)].fileType}" />
					<input type="hidden" class="filename_100" role="${counter.index}" name="filename_100" value="${portfolio.portfolioImages[(counter.index-1)].thumbnailUrl}" />
					<input type="hidden" class="filename_400" role="${counter.index}" name="filename_400" value="${portfolio.portfolioImages[(counter.index-1)].fileName}" />
					<input type="hidden" class="filename_original" role="${counter.index}" name="filename_original" value="${portfolio.portfolioImages[(counter.index-1)].mainImageUrl}" />
	       		</div>
        	</c:forEach>
        	<div class="images-section-item hint" style="width:50%;">
        		*Please upload up to 2 inspirational photos or mood boards. These images will be attached to each design board within this portfolio.
        	</div>
        </div>
        
        <div class="buttons">
        	<input type="hidden" id="portfolioId" name="portfolioId" value="${portfolio.portfolioId}" />
        	<c:choose>
        		<c:when test="${editMode}">
        			<div class="button orange" id="back_to_boards" data-mode="p" data-portfolio="${portfolio.portfolioId}">Cancel</div>
        		</c:when>
        		<c:otherwise>
        			<div class="button orange" id="cancel_create_portfolio" data-mode="p">Cancel</div>
        		</c:otherwise>
        	</c:choose>
            <div class="button" id="save_create_portfolio" data-mode="p" button-disabled="false" edit-mode="${editMode}">Save</div>
        </div>
    </form:form>
    </div>
</div>
<!---end of content----------->
<script type="text/javascript" src="/js/pimg_upload.min.js?v=1.1"></script>