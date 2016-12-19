<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="entity" id="sidebar_scrollbar">
	<div class="scrollbar" id="sidebar_scrollbar_entity" style="height: 222px; "><div class="track" style="height: 222px; "><div class="thumb" style="top: 0px; height: 49.33555555555556px; "><div class="end"></div></div></div></div>
	<div class="viewport">
		<div class="overview" id="industryNews" style="top: 0px;">
			<div class="block">
				<img src="/images/dashboard-yourmessages.png"/>		   	
		    </div>
		    <div class="blockContent" id="Messages">
		        <div class="label">Alerts</div><div class="noti"><a href="javascript:void(0)" id="sidebar_alerts">${drawerInfo.yourMessages.alerts}</a></div>
		        <br />
		        <div class="label">Messages</div><div class="noti"><a href="javascript:void(0)" id="sidebar_messages">${drawerInfo.yourMessages.messages}</a></div>
		        <br />       
		    </div>
		    <div class="block">
		    	<img src="/images/dashboard-stats.png"/>
		    </div>
		    <div class="blockContent" id="Stats">
		       <!--  Boards Purchased
		        <br />
		        <div class="statsList">${drawerInfo.stats.boardsPurchasedCount} Boards $<div class="amount">${drawerInfo.stats.boardsPurchasedTotal}</div></div>
		        <br /> -->
		        Board Views
		        <br />
		        <div class="statsList"><div class="label">Today</div><div class="noti">${drawerInfo.stats.boardsViewedToday}</div></div>
		        <div class="statsList"><div class="label">Week</div><div class="noti">${drawerInfo.stats.boardsViewedWeek}</div></div>
		        <div class="statsList"><div class="label">Month</div><div class="noti">${drawerInfo.stats.boardsViewedMonth}</div></div>
		    </div>
		    <div class="block">
		    	<img src="/images/dashboard-averageratings.png" />
		    </div>
		    <div class="blockContent">
			    Overall Rating 	<div class="readonly" id="sidebar_avg_rating" data-score="${average_rating}"></div>${average_rating}*
		    </div>
		    <div class="block">
		    	<img src="/images/dashboard-recentactivity.png" />
		    </div>
		    <div class="blockContent">
		        Boards
		        <br />
		        <c:forEach items="${drawerInfo.recentActivity}" var="current">
		        	<div class="actList"><a href="javascript:void(0)" class="drawer_boardId" data="${current.boardId}"><c:out value="${current.name}"/></a> <div class="amount">$<c:out value="${current.boardPrice}" /></div></div>
		      	</c:forEach>    
			</div>
		</div>
	</div>
</div>
