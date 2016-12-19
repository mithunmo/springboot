<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="com.f9g4.web.utils.ViewPaths" %>
<%@ taglib uri="/WEB-INF/rssutils.tld" prefix="rss" %>
<%-- <c:catch var="reeException" >
	<rss:feed url="http://www.style.com/homepage/rss" feedId="industrynews"/>
</c:catch> --%>
<div class="mainbox">
	<div id="mainbox-image-rotator" class="nivoSlider mainbox-image">
		<img src="/images/splash/splash_carousel/a.jpg" />
		<img src="/images/splash/splash_carousel/b.jpg" />
		<img src="/images/splash/splash_carousel/c.jpg" />
		<img src="/images/splash/splash_carousel/d.jpg" />
		<img src="/images/splash/splash_carousel/e.jpg" />
    </div>
	<div class="leftarea">
		<!-- <img src="/images/splash/companyinfo.png" alt="Company Info" title="Company Info" id="company_info"/> -->
		<div class="leftarea-content">
			<div class="leftarea-title">WHAT IS FASHION FOR GLOBE(FFG)?</div>
			<div class="area-content">
			We are a curated marketplace for fashion industry professionals where freelance designers can easily
			connect with big name brands across the world. Our platform is the best at discovering new talent,
			curating high quality designs and building lasting relationships between companies and designers.
			</div>
			<div class="leftarea-title space">WHO CAN JOIN?</div>
			<div class="area-content">
			We emphasize the diversity and originality of our designers. They come from all fashion categories and a 
			wide range of experience levels. Artisans, self-taught designers, students, freelance or long term industry 
			professionals are all welcome. Just getting started in the fashion industry? FFG can help you 
			find your next freelance fashion design job. 
			</div>
		</div>
		<!-- <img src="/images/splash/bigtext.png" alt="Company Info" title="Company Info" id="lower_quote"/> -->
		<div class="leftarea-content space">
			<div class="leftarea-title">CONNECTING BRANDS WITH INSPIRING TALENT FROM ACROSS THE GLOBE</div>
		</div>
		<div class="leftarea-content mainbox-quote-holder">
			<div class="rightarea-quote-title"><span>WHAT THEY'RE SAYING...</span></div>
			<div class="mainbox-quote">
				<div class="mainbox-quote-item item1">
					<div class="mainbox-quote-item-content">
						<div class="mainbox-quote-item-text">
							<img class="quote-img" src="/images/splash/quotes/upquote.png">FFG GIVES DESIGNERS THE FREEDOM TO FOCUS ON THE CREATIVE PROCESS, ENABLING US TO EXPAND OUR INSPIRATIONAL PURSUITS.<img class="quote-img" src="/images/splash/quotes/downquote.png">
						</div>
						<div class="mainbox-quote-item-name">- LAUREN B., STUDENT DESIGNER</div>
					</div>
				</div>
				<div class="mainbox-quote-item item2" style="display:none;">
					<div class="mainbox-quote-item-content">
						<div class="mainbox-quote-item-text">
							<img class="quote-img" src="/images/splash/quotes/upquote.png">FFG ALLOWS ME TO FLEX MY CREATIVITY, BROADEN MY DESIGN AESTHETIC AND GIVES ME THE OPPORTUNITY TO SHOWCASE MY WORK TO A BROAD RANGE OF CLIENTELE.<img class="quote-img" src="/images/splash/quotes/downquote.png">
						</div>
						<div class="mainbox-quote-item-name">- CHRIS M., FASHION DESIGNER</div>
					</div>
				</div>
				<div class="mainbox-quote-item item3" style="display:none;">
					<div class="mainbox-quote-item-content">
						<div class="mainbox-quote-item-text">
							<img class="quote-img" src="/images/splash/quotes/upquote.png">FASHION FOR GLOBE IS A FABULOUS PLATFORM BRINGING ME, AND EMERGING DESIGNER, ONE STEP FORWARD IN MY FASHION CAREER.<img class="quote-img" src="/images/splash/quotes/downquote.png">
						</div>
						<div class="mainbox-quote-item-name">- FIONA L., FASHION DESIGNER</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="rightarea">
		<!-- <img src="/images/splash/quotes/quotes-title.png" alt="Quotes" title="Quotes" id="quotes"/> -->
		<div class="leftarea-title banner" style="text-align: center;">
			<!-- WIN $100 BY PARTICIPATING IN "PROJECT OF THE WEEK" -->
			WIN $100 FOR "PROJECT OF THE WEEK"
			<div style="text-align: center; width:100%;">
				<a href="http://fashionforglobe.wordpress.com/projects-and-competitions/project-of-the-week-specifications/" data-outbound-link="true">Click here for details</a>&nbsp;or&nbsp;<a href="/f4g/register/designer">Register now</a>
			</div>
		</div>
		<div class="tt-wrapper">
			<a class="twitter-timeline" href="https://twitter.com/FashionForGlobe" data-widget-id="436390820363522048">Tweets by @FashionForGlobe</a>
		</div>
		<!-- <div id="mainbox-quote-rotator" class="nivoSlider mainbox-quote">
			<img src="/images/splash/quotes/quotes-1.png" style="background-color: #FFF;"/>
    	</div> -->
	</div>
</div>
<script type="text/javascript">
_gaq.push(['_trackPageview']);
</script>