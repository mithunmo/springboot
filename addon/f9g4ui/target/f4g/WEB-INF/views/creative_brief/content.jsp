<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div class="wrap">
	<div class="space"></div>
	<div class="brief"> 
		CREATIVE BRIEF
	</div>
	<div class="title-content">
		<div class="panel">
		   <div class="column-left">TITLE</div>
		   <div class="column-center">CLIENT</div>
		   <div class="column-right">PROJECT #ID</div>
		</div>
		<div class="panel-content">
		   <div class="column-left">${targetContest.originalData.contestPortfolioDomain.name}</div>
		   <div class="column-center">${targetContest.originalData.contestPortfolioDomain.user.firstname} ${targetContest.originalData.contestPortfolioDomain.user.lastname}</div>
		   <div class="column-right">${targetContest.projectId}</div>
		</div>
	</div>
	<!-- Use a container to wrap float element -->
	<div class="main-wrapper">
		<div class="main"> <!-- float Element -->
			<div class="mainbox">
			    <div class="panel">  
			    	INTRODUCTION
			    </div>
			    <div class="mainbox-content">
			    	<p>${targetContest.originalData.introduction}</p>
			    </div>
			</div>
			<div class="mainbox">
			    <div class="panel">  
			    	DESCRIPTION
			    </div>
			    <div class="mainbox-content">
				    <p>${targetContest.originalData.contestPortfolioDomain.description}</p>
			    </div>
			</div>
			<div class="mainbox">
			    <div class="panel">  
			    	DELIVERABLE
			    </div>
			    <div class="mainbox-content">
			    	<p>${targetContest.originalData.deliverable}</p>
			    </div>
			</div>
			<div class="mainbox">
			    <div class="panel">  
			    	OTHER INFORMATION
			    </div>
			    <div class="mainbox-content">
			    	<p>${targetContest.originalData.otherInformation}</p>
			    </div>
			</div>	
		</div>
		<div class="sidebar">	
			<div class="mainbox-rightpanel">
			    <div class="panel">  
			    	POSTED			    	
			    </div>
			    <p>
			<c:choose>
				<c:when test="${targetContest.contestStatus=='Pending'}">
				Pending
				</c:when>
				<c:otherwise>
							<fmt:formatDate value="${targetContest.startDate}" pattern="yyyy-MM-dd" />
				</c:otherwise>
			</c:choose>
			    </p>
			</div>
	    	<!-- <div class="space"></div> -->
			<div class="sidebar-box">
		    	<div class="sidebar-heading">PROJECT TYPE</div>
		    	<div class="space"> </div>
		    	<span class="proj-label t tr" ng-class="{tg: item.contestTypeMap['4'], tr: item.contestTypeMap['1'] || item.contestTypeMap['3'] , tb: item.contestTypeMap['2'] || item.contestTypeMap['0']}">${targetContest.contestType}</span>
		    	<!-- <button type="button" name="" value="" class="sidebarbutton">${targetContest.contestType}</button> -->
			</div>
			<div class="sidebar-box">
		    	<div class="sidebar-heading"> COMPENSATION </div>
		    	<div class="space"> </div>
		    	<div>Winners: ${targetContest.originalData.numberOfWinners}</div>
			</div>
			<div class="sidebar-box">
		    	<div class="sidebar-heading"> SEASON</div>
		    	<div class="space"> </div>
		    	<span class="proj-label s s-fall" ng-class="{'s-spring': item.seasonYearMap['isSpring'], 's-summer': item.seasonYearMap['isSummer'], 's-fall': item.seasonYearMap['isFall'], 's-winter': item.seasonYearMap['isWinter'], 's-other': item.seasonYearMap['isOther']}">${targetContest.season}</span>
		    	<!-- <button type="button" name="" value="" class="sidebar-button">Fall'15</button> -->
			</div>
			<div class="sidebar-box">
		    	<div class="sidebar-heading"> DOCUMENTS </div>
		    	<div class="space"></div>
		    	<c:if test="${targetContest.originalData.contestPortfolioDomain.portfolioImages[0] != null}">
		    		<img src="/100x100/${targetContest.originalData.contestPortfolioDomain.portfolioImages[0].thumbnailUrl}" />
		    	</c:if>
		    	<c:if test="${targetContest.originalData.contestPortfolioDomain.portfolioImages[1] != null}">
		    		<img src="/100x100/${targetContest.originalData.contestPortfolioDomain.portfolioImages[1].thumbnailUrl}" />
		    	</c:if>
			</div>
			<div class="sidebar-box">
		    	<div class="sidebar-heading"> REQUIREMENTS </div>
		    	<div class="space"> </div>
		    	<div>Requirements ${targetContest.projectBoardDimension}</div>
		    	<div>High Quality ${targetContest.projectBoardFormat}</div>
			</div>
		</div>
	</div>
</div>