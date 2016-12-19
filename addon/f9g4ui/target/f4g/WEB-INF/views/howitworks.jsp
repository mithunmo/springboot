<%@ page import="com.f9g4.web.utils.ViewPaths" %>
<div class="middle" id="how_to_succeed">
	<div class="divider" style="width:100%; height:25px; background-image: url('/images/static/divider.png'); position:relative;">
		<img src="/images/static/divider-arrow.png" style="position:absolute; top:0px; right:250px;" />
	</div>
	<div style="width:100%; margin-top:36px; margin-bottom:20px;">
		<div style="margin:0px auto; float:none; font-family: 'BebasNeueRegular'; font-size: 3.625em; text-align: center;">
			<span style="display:block;">Our Step-by-Step guide</span>
			<span style="display:block; clear:both; margin-top:-10px;">to sell your designs</span>
		</div>	
	</div>
	<div style="position:relative; width:100%; height:330px;">
		<div style="position:absolute; top:0px; left:35px; width:300px;">
			<h2 style="font-family: 'BebasNeueRegular'; font-size:2.3em; text-align: center; font-weight: normal; margin-bottom:0px;">Simple Sign Up</h2>
			<p style="line-height:22px; font-size:0.875em; background-image: url('/images/static/Number_1.png'); background-repeat: no-repeat; background-position: 0px 2px; padding-left:22px;">
				<!-- <img src="/images/static/Number_1.png"/> -->
				Fill out our quick &amp; easy registration form to become a member.
			</p>
			<p style="line-height:22px; font-size:0.875em; background-image: url('/images/static/Number_2.png'); background-repeat: no-repeat; background-position: 0px 2px; padding-left:22px;">
				<!-- <img src="/images/static/Number_2.png"/> -->
				<%-- Choose a membership level.
				<span style="display:block; font-style: italic;">See more on our Free and Monthly Membership levels <a href="${pageContext.request.contextPath}<%= ViewPaths.REGISTRATION_DESIGNER %>" style="text-decoration: none;">here.</a></span>--%>
				Submit examples of your work for membership approval.
			</p>
		</div>
		<div style="position:absolute; top:0px; left:370px; width:300px;">
			<h2 style="font-family: 'BebasNeueRegular'; font-size:2.3em; text-align: center; font-weight: normal; margin-bottom:0px;">Create a Design Board</h2>
			<p style="line-height:22px; font-size:0.875em; background-image: url('/images/static/Number_1.png'); background-repeat: no-repeat; background-position: 0px 2px; padding-left:22px;">
				<!-- <img src="/images/static/Number_1.png" /> -->
				Follow our simple formatting guidelines to create design boards to showcase your work.
				<%-- <span style="display:block; font-style: italic;">See more info on Design Boards <a href="${pageContext.request.contextPath}<%= ViewPaths.REGISTRATION_DESIGNER %>" style="text-decoration: none;">here.</a></span> --%>
			</p>
			<p style="line-height:22px; font-size:0.875em; background-image: url('/images/static/Number_2.png'); background-repeat: no-repeat; background-position: 0px 2px; padding-left:22px;">
				<!-- <img src="/images/static/Number_2.png"/> -->
				Create portfolios to manage your boards.
			</p>
			<p style="line-height:22px; font-size:0.875em; background-image: url('/images/static/Number_3.png'); background-repeat: no-repeat; background-position: 0px 2px; padding-left:22px;">
				<!-- <img src="/images/static/Number_3.png" style="vertical-align: middle;"/> -->
				Upload your board files.
				<%-- <span style="display:block; font-style: italic;">Note: We currently accept both .ai and .jpeg files.</span> --%>
			</p>
			<p style="line-height:22px; font-size:0.875em; background-image: url('/images/static/Number_4.png'); background-repeat: no-repeat; background-position: 0px 2px; padding-left:22px;">
				<!-- <img src="/images/static/Number_4.png"/> -->
				Set a price &amp; publish to the marketplace.
				<span style="display:block; font-style: italic;">(Unsure of how to price your work? Follow our simple pricing guidelines to
				get started or contact our team of industry professionals. We are here to help.)</span>
			</p>
		</div>
		<div style="position:absolute; top:0px; left:700px; width:330px;">
			<h2 style="font-family: 'BebasNeueRegular'; font-size:2.3em; text-align: center; font-weight: normal; margin-bottom:0px;">Sell your work</h2>
			<%-- <p style="line-height:22px; font-size:0.875em; background-image: url('/images/static/Number_1.png'); background-repeat: no-repeat; background-position: 0px 2px; padding-left:22px;">
				<img src="/images/static/Number_3.png"/>
				Attach a secure <img src="/images/static/paypal-logo.png" style="width:75px; height:auto; vertical-align: middle;"/>account.
			</p> --%>
			<p style="line-height:22px; font-size:0.875em;  background-image: url('/images/static/Number_1.png'); background-repeat: no-repeat; background-position: 0px 2px; padding-left:22px; text-align: justify;">
				<!-- <img src="/images/static/Number_1.png"/> --> Once you have published your boards to the site 
				they are categorized into our search database and accessible to retailers.
				<%-- <span style="display:block; font-style: italic;">Still have questions? <a href="${pageContext.request.contextPath}<%= ViewPaths.REGISTRATION_DESIGNER %>" style="text-decoration: none;">Click here for some of our most FAQs.</a></span> --%>
			</p>
			<p style="line-height:22px; font-size:0.875em;  background-image: url('/images/static/Number_2.png'); background-repeat: no-repeat; background-position: 0px 2px; padding-left:22px; text-align: justify;">
				Reply to buyer inquiries, keep track on the status of your payments.
			</p>
			<p style="line-height:22px; font-size:0.875em;  background-image: url('/images/static/Number_3.png'); background-repeat: no-repeat; background-position: 0px 2px; padding-left:22px; text-align: justify;">
				Use our data analysis to monitor your most popular boards and manage your ratings, all within our simple
				and easy-to-use application.
			</p>
			<div style="position:relative; width:100%; text-align: center;">
				<a href="${pageContext.request.contextPath}<%= ViewPaths.REGISTRATION_DESIGNER_GETSTARTED %>" style="text-decoration: none; color:#000;"><span class="b-shadow b-radius" style="display:block; height:48px; margin:0px auto; background-color: #00AEEF; color:#FFF; line-height: 54px; font-family:'BebasNeueRegular'; font-size: 2em; cursor: pointer; margin-left:22px;">REGISTER NOW</span></a>
				<%-- <a href="${pageContext.request.contextPath}<%= ViewPaths.REGISTRATION_DESIGNER %>"><img src="/images/static/Get-started.png" /></a> --%>
			</div>
		</div>
	</div>
	<div style="position:relative; width:100%; /* height:150px; */">
		<div style="position:relative; width:100%; text-align:center;">
			<h1 style="font-family: 'BebasNeueRegular'; font-size: 2.5em; margin:25px 0px 10px 0px; font-weight: normal;">"Selling your work has never been this easy."</h1>
		</div>
	</div>
	<div style="width:100px;"></div>
</div>
<script type="text/javascript">
_gaq.push(['_trackPageview']);
</script>