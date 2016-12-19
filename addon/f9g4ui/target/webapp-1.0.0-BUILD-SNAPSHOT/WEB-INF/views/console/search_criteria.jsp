<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page import="com.f9g4.common.util.Constants" %>
<div class="contentFrame" >
 	<!-- <form action="" method="POST" id="form_search_criteria"> -->
 	<form:form method="POST" modelAttribute="searchCriteriaForm" id="form_search_criteria">
<div class="content" id="search_options">
         	<div class="row space">
         		<div id="designerName">
             	<span class="font-header cap-bold">Designer Name</span>
             	<br />
             	<!--  <input name="designerName" type="text" />  -->
         	<form:input path="designerName"/>
           	</div>
           	<div class="column" id="ratings">
               <br />
<span class="font-header cap-bold">Ratings</span>
               <label>
                 <!-- <input type="radio" name="ratings" value="star_5" id="ratings_0" /> -->
               <form:radiobutton path="ratings" value="<%= Constants.SEARCH_OPTION_RATING_5 %>" id="ratings_0"/>
               Show Only 5 star</label>
             <label>
               <!--  <input type="radio" name="ratings" value="star_4_1" id="ratings_1" /> -->
               <form:radiobutton path="ratings" value="<%= Constants.SEARCH_OPTION_RATING_1_TO_4 %>" id="rating_1" />
               Show 4 - 1 stars</label>
             <label>
               <!-- <input type="radio" name="ratings" value="all" id="ratings_2" /> -->
               <form:radiobutton path="ratings" value="<%= Constants.SEARCH_OPTION_RATING_ALL %>" id="rating_2" checked="checked"/>
               Show All</label>
             </div>
         </div>
         <div class="row space">
         	<div class="column second">
             <span class="font-header cap-bold">Designer's Country</span>
             <br />
             <form:select path="country" id="form_country" multiple="false" cssClass="dropdown">
             	<form:option value="">- Please select one option -</form:option>
           		<c:forEach var="item" items="${countryList}">
           			<form:option value="${item.lookupValueId}">
						<c:out value="${item.description}" />
					</form:option>
					<%-- <c:choose>
						<c:when
							test="${item.lookupCode == default_country_code}">
							
							<form:option selected="true" value="${item.lookupValueId}">
								<c:out value="${item.description}" />
							</form:option>
						</c:when>
						<c:otherwise>
							<form:option value="${item.lookupValueId}">
								<c:out value="${item.description}" />
							</form:option>
						</c:otherwise>
					</c:choose> --%>
				</c:forEach>
            </form:select>
            </div>
            <div class="column second show-all">
            <span class="font-header cap-bold">Languages</span>
            <br />
            <form:select path="langs" id="form_languages" multiple="true" cssClass="dropdown">
				<c:forEach var="item" items="${languagesList}">
				<form:option value="${item.lookupValueId}">
					<c:out value="${item.description}" />
				</form:option>
				<%-- <c:choose>
					<c:when
						test="${item.lookupCode == default_language_code}">
						<form:option selected="true" value="${item.lookupValueId}">
							<c:out value="${item.description}" />
						</form:option>
					</c:when>
					<c:otherwise>
						<form:option value="${item.lookupValueId}">
							<c:out value="${item.description}" />
						</form:option>
					</c:otherwise>
				</c:choose> --%>
				</c:forEach>
			</form:select>
			<span class="font-header cap-bold">Skills</span>
            <br />
            <form:select path="skills" id="form_skills" items="${skillsList}" itemValue="lookupValueId" itemLabel="description" multiple="true" cssClass="dropdown" />
            </div>
             <div class="column second show-all">
             	<span class="font-header cap-bold">Specialty</span>
             	<br />
             	<form:select path="splId" id="form_spl" items="${specialtyList}" itemValue="lookupValueId" itemLabel="description" multiple="true" cssClass="dropdown" />
             	<span class="font-header cap-bold">Expertise</span>
             	<br />
             	<form:select path="expId" id="form_exp" items="${expertiseList}" itemValue="lookupValueId" itemLabel="description" multiple="true" cssClass="dropdown" />
             </div>
             <div class="column second">
             	<span class="font-header cap-bold">Schools,&nbsp;Awards,<br />Events,&nbsp;Specialities</span>
             	<br/>
             	<form:textarea path="misc" id="form_misc" title="Please enter the name and/or other details separated by comma"/>
             </div>
         </div>
         <div class="separate-line"></div>
         <div class="row space">
         	<div class="column second show-all" id="product_options">
         		<div class="row">
         			<span class="font-header cap-bold">Division</span>
                 	<br />
                 	<form:select path="division" id="form_division_search_criteria" cssClass="dropdown">
                 		<form:option value="-1">-Please select one option-</form:option>
                 		<c:forEach var="item" items="${divisionList}">
                 			<form:option value="${item.categoryId}">${item.name}</form:option>
                 		</c:forEach>
                 	</form:select>
                 </div>
                 <div class="row"><span class="font-header cap-bold">Category</span>
                 	<br />
                 	<form:select path="category" id="form_category" cssClass="dropdown">
                 		<form:option value="-1">-Please select Division above-</form:option>
                 	</form:select>
                 </div>
             	<div class="row"><span class="font-header cap-bold">Product</span>
              	<br />
                  <form:select path="product" id="form_product" cssClass="dropdown">
                  	<form:option value="-1">-Please select Category above-</form:option>
                  </form:select>
                 </div>
                 <div class="row"><span class="font-header cap-bold">Product Type</span>
                 	<br />
                  <form:select path="productType" id="form_product_type" cssClass="dropdown" multiple="true">
                  	<form:option value="-1" disabled="true">-Please select Product above-</form:option>
                  </form:select>
                 </div>
                 <div class="row">
                 <span class="font-header cap-bold">Key Words</span>
                 <br />
                 <!-- <input type="text "name="keywords"  class="dropdown"/> -->
                 <form:input path="keywords" />
                 </div>
             </div>
             <div class="column second" id="season_options">
             <span class="font-header cap-bold">Season</span>
             <br />
             	<%-- <form:select path="country" id="form_season" items="${seasonYear}" itemValue="seasonYearId" itemLabel="season" cssClass="dropdown" /> --%>
             	<!-- <div id="season"></div> -->
             	<c:forEach var="item" items="${seasonYear}">
             		<label><input name="season" type="checkbox" value="${item.seasonYearId}" />${item.season}</label><br />
             	</c:forEach>
             </div>
             <div class="column second" id="board_file_format_options">
             <span class="font-header cap-bold">Board File Format</span>
             <br /><br />
             <!-- <input name="jpg" type="checkbox" value="" /> JPG -->
             	<form:checkboxes  path="saleTypes" items="${saleTypeList}" itemLabel="description" itemValue="lookupValueId" delimiter="<br>" />
             </div>          
             <div class="column second" id="price_range_options">
             <span class="font-header cap-bold">Price Range</span>
             <br /><br />
             <!-- <input name="price_range" type="radio" value="all_prices" /> All Prices -->
             <label><form:radiobutton path="priceRange" value="<%= Constants.SEARCH_OPTION_PRICE_ALL %>" checked="checked" /> All Prices</label>
        		<br /><br />
             <!-- <input name="price_range" type="radio" value="price_0_199" /> 0 - $499 -->
             <label><form:radiobutton path="priceRange" value="<%= Constants.SEARCH_OPTION_PRICE_0_TO_499 %>"/> 0 - $499</label>
        		<br /><br />
             <!-- <input name="price_range" type="radio" value="price_200_499" /> $500 - $999 -->
             <label><form:radiobutton path="priceRange" value="<%= Constants.SEARCH_OPTION_PRICE_500_TO_999 %>"/> $500 - $999</label>
        		<br /><br />
             <!-- <input name="price_range" type="radio" value="price_500_999" /> $1000 - $2999 -->
             <label><form:radiobutton path="priceRange" value="<%= Constants.SEARCH_OPTION_PRICE_1000_TO_2999 %>"/> $1000 - $2999</label>
        		<br /><br />
            <!--  <input name="price_range" type="radio" value="price_1000" /> $3000+ -->
             <label><form:radiobutton path="priceRange" value="<%= Constants.SEARCH_OPTION_PRICE_3000_OR_ABOVE %>"/> $3000+</label>
             </div>
         </div>
         <div class="buttons">
          <div id="clear_search_criteria" class="button orange" style="float:right">
              Clear
          </div>
          <div id="submit_search_criteria" class="button" style="float:right">
          	Search
          </div>
         </div>
     </div>
     </form:form>
     <!-- Test loading layout -->
     <div class="loadingPanel" id="searchCriteriaLoadingPanel">
     	<div class="loadingOverlay"></div>
     	<div class="loadingSpinner"><span><img src="/images/spinner.gif" /></span></div>
     </div>
 </div>