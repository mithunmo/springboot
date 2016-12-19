var _gaq = _gaq || [];
_gaq.push(['_setAccount', 'UA-47462303-1']); //gaq id
(function() {
	var ga = document.createElement('script'); ga.type = 'text/javascript'; ga.async = false;
	ga.src = ('https:' == document.location.protocol ? 'https://ssl' : 'http://www') + '.google-analytics.com/ga.js';
	var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(ga, s);
})();

//track outbound links
var trackOutboundLink = function(url,callback) {
	var redirectTimer;
	_gaq.push(['_set','hitCallback',function() {
		clearTimeout(redirectTimer);
		callback();
	}]);
	_gaq.push(['_trackEvent', 'hyperlink', 'outbound', url]); //push record to google analytics
	redirectTimer=setTimeout(function() {
		callback();
	},1000);
}

$(document).on('click','a[data-outbound-link="true"]',function(e) {
	if (!e.target.hasAttribute("target")) {
	    e.preventDefault();     
	    e.target.setAttribute("target", "_blank");
	    trackOutboundLink($(this).attr('href'),function() {
	    	e.target.click();
	    });
	    return;
	}
});