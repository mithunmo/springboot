/*
 * jQuery Idle Timeout 1.2
 * Copyright (c) 2011 Eric Hynds
 *
 * http://www.erichynds.com/jquery/a-new-and-improved-jquery-idle-timeout-plugin/
 *
 * Depends:
 *  - jQuery 1.4.2+
 *  - jQuery Idle Timer (by Paul Irish, http://paulirish.com/2009/jquery-idletimer-plugin/)
 *
 * Dual licensed under the MIT and GPL licenses:
 *   http://www.opensource.org/licenses/mit-license.php
 *   http://www.gnu.org/licenses/gpl.html
 *
*/

(function($, win){
	
	var idleTimeout = {
		init: function( element, resume, options )
		{
			var self = this, elem;

			this.warning = elem = $(element);
			this.resume = $(resume);
			this.options = options;
			this.countdownOpen = false;
			this.failedRequests = options.failedRequests;
			this._startTimer();
      		this.title = document.title;
      		
      		if(this.options.debugMode)
      			console.log("Start idle timeout plugin");
			// expose obj to data cache so peeps can call internal methods
			$.data( elem[0], 'idletimeout', this );
			
			// start the idle timer
			$.idleTimer(options.idleAfter * 1000);
			
			// once the user becomes idle
			$(document).bind("idle.idleTimer", function(){
				
				// if the user is idle and a countdown isn't already running
				if( $.data(document, 'idleTimer') === 'idle' && !self.countdownOpen ){
					self._stopTimer();
					self.countdownOpen = true;
					self._idle();
				}
			});
			
			// bind continue link
			this.resume.bind("click", function(e){
				e.preventDefault();
				
				win.clearInterval(self.countdown); // stop the countdown
				self.countdownOpen = false; // stop countdown
				self._startTimer(); // start up the timer again
				self._keepAlive( false ); // ping server
				options.onResume.call( self.warning ); // call the resume callback
			});
		},
		
		_idle: function(){
			var self = this,
				options = this.options,
				warning = this.warning[0],
				counter = options.warningLength;
				
			// fire the onIdle function
			options.onIdle.call(warning);
			
			// set inital value in the countdown placeholder
			options.onCountdown.call(warning, counter);
			
			// create a timer that runs every second
			this.countdown = win.setInterval(function(){
				if(--counter === 0)
				{
					window.clearInterval(self.countdown);
					options.onTimeout.call(warning);
				} else {
					options.onCountdown.call(warning, counter);
          document.title = options.titleMessage.replace('%s', counter) + self.title;
				}
			}, 1000);
		},
		
		_startTimer: function(){
			var self = this;

			this.timer = win.setTimeout(function(){
				self._keepAlive();
			}, this.options.pollingInterval * 1000);
		},
		
		_stopTimer: function(){
			// reset the failed requests counter
			this.failedRequests = this.options.failedRequests;
			win.clearTimeout(this.timer);
		},
		
		_keepAlive: function( recurse )
		{
			var self = this,
				options = this.options;
				
			//Reset the title to what it was.
			document.title = self.title;
			
			// assume a startTimer/keepAlive loop unless told otherwise
			if( typeof recurse === "undefined" ){
				recurse = true;
			}
			
			// if too many requests failed, abort
			if( !this.failedRequests ){
				this._stopTimer();
				options.onAbort.call( this.warning[0] );
				return;
			}
			
			var currentTime = new Date();
			var hours = currentTime.getHours();
			var minutes = currentTime.getMinutes();
			var seconds= currentTime.getSeconds();
			if(options.debugMode)
			{
				console.log("--------------------------------------------------------");
				console.log("Send keep session alive=>"+hours+":"+minutes+":"+seconds);
			}
			$.ajax({
				timeout: options.AJAXTimeout,
				url: options.keepAliveURL,
				beforeSend: function()
				{
					if(options.debugMode)
						console.log("Send ajax request");
				},
				error: function()
				{
					if(options.debugMode)
						console.log("request failed");
					self.failedRequests--;
				},
				success: function(response)
				{
					if(options.debugMode)
						console.log("get response");
					if($.trim(response) !== options.serverResponseEquals)
					{
						if(options.debugMode)
							console.log("unexpected response text");
						self.failedRequests--;
						//check the content exist the flag on the login page or not.
						if($("#sessionTimeout",$(response)).val()=="true")
							options.onRedirect.call(); //fire onRedirect event
					}
				},
				complete: function()
				{
					if( recurse )
					{
						if(options.debugMode)
							console.log("keep polling");
						self._startTimer();
					}
				}
			});
		}
	};
	
	// expose
	$.idleTimeout = function(element, resume, options){
		idleTimeout.init( element, resume, $.extend($.idleTimeout.options, options) );
		return this;
	};
	
	// options
	$.idleTimeout.options = {
		// number of seconds after user is idle to show the warning
		warningLength: 30,
		
		// url to call to keep the session alive while the user is active
		keepAliveURL: "",
		
		// the response from keepAliveURL must equal this text:
		serverResponseEquals: "OK",
		
		// user is considered idle after this many seconds.  10 minutes default
		idleAfter: 600,
		
		// a polling request will be sent to the server every X seconds
		pollingInterval: 60,
		
		// number of failed polling requests until we abort this script
		failedRequests: 5,
		
		// the $.ajax timeout in MILLISECONDS!
		AJAXTimeout: 2500,
		
		// %s will be replaced by the counter value
    	titleMessage: 'Warning: %s seconds until log out | ',
    	
    	debugMode: false,
		
		/*
			Callbacks
			"this" refers to the element found by the first selector passed to $.idleTimeout.
		*/
		// callback to fire when the session times out
		onTimeout: $.noop,
		
		// fires when the user becomes idle
		onIdle: $.noop,
		
		// fires during each second of warningLength
		onCountdown: $.noop,
		
		// fires when the user resumes the session
		onResume: $.noop,
		
		// callback to fire when the script is aborted due to too many failed requests
		onAbort: $.noop,
		
		onRedirect: $.noop
	};
	
})(jQuery, window);