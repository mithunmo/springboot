<%@ page import="com.f9g4.web.utils.ViewPaths" %>
<div class="middle">
	<script type="text/javascript">
		$(document).ready(function() {
			$("#scrollbarFooter").tinyscrollbar();	//initialize the scroll bar
		});
	</script>
	<div class="divider" style="width:100%; height:25px; background-image: url('/images/static/divider.png'); position:relative;">
		<img src="/images/static/divider-arrow.png" style="position:absolute; top:0px; right:445px;" />
	</div>
	<div style="width:100%; margin:50px 0px 32px 0px; text-align:center; font-family: 'BebasNeueRegular'; font-size: 3.625em;">
	Founder's Story
	</div>
	<div style="width:70%; margin:0px auto 60px auto; float:none; text-align: center;">
		<%-- <p>
			It all began in a small city of less than 10,000 people in India.
		</p> --%>
		<p>
			As a child in India, I would accompany my grandfather each year on a visit to an old man in town. The man would measure my grandfather's feet, gather materials, and handcraft him a new pair of shoes. A bit confused by this lengthy and expensive process, <br />I asked my grandfather why doesn't he just go into a store and buy a perfectly good pair of shoes off the shelf. 
		</p>
		<p> 
			I still remember my grandfather's reply:
		</p>
		<p style="font-size:1.6em; color:#00AEEF; font-family: 'BebasNeueRegular';">
			"This man has been making shoes his whole life, as did his father before him, and his grandfather before him, and back on and on through countless generations. <br />These shoes tell that story."
		</p>
		<p>
			It was in that moment that I realized that all around the world, hidden from view, were skilled artisans devoted to their craft. I wanted them all to have the opportunity to endure and prosper in the modern world. I resolved that one day I would find a way to connect these undiscovered talents from across the globe with companies who could use their abilities. The artisans' stories would then become part of the brands and ultimately, be incorporated into customers' lives.
		</p>
		<p>
			Now, many years later, Fashion For Globe is born. Our mission is to connect cultures through creativity, and to enrich design and production through an open exchange of diverse ideas and experiences.
		</p>
		<p>
			- Girish Siddappa, founder and CEO, Fashion For Globe
		</p>
	</div>
	<div style="position:relative; width:100%; background-color: #00AEEF; height:150px; margin-top:0px;">
		<div style="position:relative; width:100%; text-align:center;">
			<h1 style="font-family: 'BebasNeueRegular'; font-size: 2.5em; color:#FFF; margin:15px 0px; font-weight: normal;">AND SO THE JOURNEY BEGAN...</h1>
		</div>
		<div style="position:relative; width:100%; text-align: center;">
			<a href="${pageContext.request.contextPath}<%= ViewPaths.WHAT_WE_DO %>" style="text-decoration: none; color:#000;"><span style="display:block; width:177px; height:50px; border:4px solid #000; margin:0px auto; background-color: #BCBEC0; line-height: 54px; font-family:'BebasNeueRegular'; font-size: 2em; cursor: pointer;">WHAT WE DO</span></a>
			<%-- <a href="${pageContext.request.contextPath}<%= ViewPaths.REGISTRATION_DESIGNER %>"><img src="/images/static/Get-started.png" /></a> --%>
		</div>
	</div>
	<div style="width:100px; height:45px;"></div>
</div>
<script type="text/javascript">
_gaq.push(['_trackPageview']);
</script>