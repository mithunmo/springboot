$(document).foundation({
	orbit: {
		timer_speed: 5000, // Sets the amount of time in milliseconds before transitioning a slide
	    pause_on_hover: false, // Pauses on the current slide while hovering
	    resume_on_mouseout: false, // If pause on hover is set to true, this setting resumes playback after mousing out of slide
	    next_on_click: true, // Advance to next slide on click
	    animation_speed: 500, // Sets the amount of time in milliseconds the transition between slides will last
	   	navigation_arrows: false
	},
	accordion: {
		callback : function (accordion) {
		}
	}
});
$(document).ready(function() {
	$('.hover-tile').hover(function(e){
		$(this).children('.hover').fadeIn(350);
	},function() {
		$(this).children('.hover').fadeOut(250);
	});
	
	$(".accordion dd").on("click", "a:eq(0)", function (event) {
	    var dd_parent = $(this).parent();
	
	    if(dd_parent.hasClass('active'))
	      $(".accordion dd div.content:visible").slideToggle("normal");
	    else {
	      $(".accordion dd div.content:visible").slideToggle("normal");
	      $(this).parent().find(".content").slideToggle("normal");
	    }
	});
});