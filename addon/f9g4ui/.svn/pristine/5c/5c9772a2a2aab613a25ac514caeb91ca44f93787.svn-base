<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script>
	$(document).ready(function()
	{
		if($.browser.msie && ($.browser.version == "8.0" || $.browser.version == "7.0"))
		{
			logging("layout table on IE 8","#00F");
			$('table tr:even').addClass('even'); 
		    $('table tr:odd').addClass('odd');
		    $("table td:nth-child(1)").addClass("td1");
		    $("table td:nth-child(2)").addClass("td2");
		    $("table td:nth-child(3)").addClass("td3");
		    $("table td:nth-child(4)").addClass("td4");
		    $("table td:nth-child(5)").addClass("td5");
		    $("table td:nth-child(6)").addClass("td6");
		    $("table td:nth-child(7)").addClass("td7");
		}
		//initialize scroll bar plugin
		logging("init tinyscrollbar","#F00");
		$("#grid_scrollbar").tinyscrollbar();
	});
</script>
<!---Content------------------>
<div class="contentFrame" >
    <div class="content" id="activity">
        <div class="ratingDetails" id="ratingDetails">
        	<!---Just fill in the value in class="value" field, the star will fetch that value to display the corresponding stars--->
       <div class="ratingTitle">Rating Details</div>
            <div class="overall">Overall rating</div>
            <div class="readonly" id="act_rate_overall"></div>
            <div class="value" id="act_rate_overall_value">${overallRating}</div>
            <c:forEach var="item" items="${rate1}">
           		<c:if test="${item.lookupCode == question1Type}">
		            <div class="partial">${item.description}</div>
		            <div class="readonly" id="act_rate_quality_of_work"></div>
		            <div class="value" id="act_rate_quality_of_work_value">${rating1}</div>
	            </c:if>
            </c:forEach>
            <c:forEach var="item" items="${rate2}">
            	<c:if test="${item.lookupCode == question2Type}">
            		<div class="partial">${item.description}</div>
            		<div class="readonly" id="act_rate_pricing"></div>
            		<div class="value" id="act_rate_pricing_value">${rating2}</div>
            	</c:if>
           	</c:forEach>
            <c:forEach var="item" items="${rate3}">
            	<c:if test="${item.lookupCode == question3Type}">
            		<div class="partial">${item.description}</div>
            		<div class="readonly" id="act_rate_reliability"></div>
            		<div class="value" id="act_rate_reliability_value">${rating3}</div>
            	</c:if>
            </c:forEach>
            <c:forEach var="item" items="${rate4}">
            	<c:if test="${item.lookupCode == question4Type}">
            		<div class="partial">${item.description}</div>
            		<div class="readonly" id="act_rate_customization"></div>
            		<div class="value" id="act_rate_customization_value">${rating4}</div>
            	</c:if>
            </c:forEach>
        </div>
        <div class="chart">
        	<div class="displayRange">Chart Range</div>
        	<div class="options">Boards Viewed: <a href="#" id="chart_today">Today</a>&nbsp;<a href="#" id="chart_week">Week</a>&nbsp;<a href="#" id="chart_month">Month</a></div>
        	<div id="activity_chart" style="width:95%; height:90%;"></div>
        </div>
        <!-- <div class="separateLine"></div> -->
        <div class="tableHeader-holder">
        <table class="act_designer_table">
        	<tr class="tableHeader">
                <td>Board</td>
                <td>Board Name</td>
                <td>Season</td>
                <td>Portfolio Name</td>
                <td>Views</td>
                <td>Price</td>
            </tr>
        </table>
        </div>
       <div class="tableArea">
       		<div class="entity" id="grid_scrollbar">
				<div class="scrollbar" id="grid_scrollbar_entity"><div class="track"><div class="thumb" style="top: 0px; height: 49.33555555555556px; "><div class="end"></div></div></div></div>
				<div class="viewport">
					<div class="overview" id="industryNews" style="top: 0px;">
						<table class="act_designer_table" id="activity_designer_grid"></table>
					</div>
				</div>
			</div>
        </div>
    </div>
</div>
<!---end of content----------->
 <!--<c:forEach var="item" items="${activityGrid}">
              <tr>
                <td><a href="javascript:void(0)" class="gridBoardId" data="${item.boardId}"><img src="/100x100/${item.boardImageUrl}" /></a></td>
                <td><a href="javascript:void(0)" class="gridBoardId" data="${item.boardId}">${item.boardName}</a></td>
                <td>${item.season}</td>
                <td>${item.portfolioname}</td>
                <td>${item.noofhits}</td>
                <td>$${item.price}</td>
              </tr>
              </c:forEach>-->