/*
 * jQuery Carousel Plugin v1.0
 * http://richardscarrott.co.uk/posts/view/jquery-carousel-plugin
 *
 * Copyright (c) 2010 Richard Scarrott
 *
 * Dual licensed under the MIT and GPL licenses:
 * http://www.opensource.org/licenses/mit-license.php
 * http://www.gnu.org/licenses/gpl.html
 *
 * Requires jQuery v1.4+
 *
 */

// prototypal inheritance
if (typeof Object.create !== 'function') 
{
	Object.create = function (o) 
	{
		function F() {}
		F.prototype = o;
		return new F();
	};
}

(function($) {
	// ie alias
	var headache = $.browser.msie && $.browser.version.substr(0,1)<9;

	// carousel
	var Carousel = {
		settings: 
		{
			itemsPerPage: 1,
			itemsPerTransition: 1,
			noOfRows: 1,
			pagination: true,
			nextPrevLinks: true,
			speed: 'normal',
			easing: 'swing',
			pageId: 'page',
			prevId: 'carouselPrev',
			nextId: 'carouselNext',
		},
		init: function(el, options) 
		{
			//alert("carousel init");
			if (!el.length) {return false;}
			this.options = $.extend({}, this.settings, options);
			this.itemIndex = 0;	
			this.container = el;
			this.runner = this.container.find('ul');
			this.items = this.runner.children('li');
			this.noOfItems = this.items.length;
			this.setRunnerWidth();
			if (this.noOfItems <= this.options.itemsPerPage) {return false;} // bail if there are too few items to paginate
			this.insertMask();
			this.noOfPages = Math.ceil((this.noOfItems - this.options.itemsPerPage) / this.options.itemsPerTransition) + 1;
			if (this.options.pagination) {this.insertPagination();}
			if (this.options.nextPrevLinks) {this.insertNextPrevLinks();}
			this.updateBtnStyles();
		},
		insertMask: function() 
		{
			this.runner.wrap('<div class="mask" />');
			this.mask = this.container.find('div.mask');

			// set mask height so items can be of varying height
			//var maskHeight = this.runner.outerHeight(true);
			var maskHeight = 500; //hardcoded
			this.mask = this.container.find('div.mask');
			this.mask.height(maskHeight);
		},
		setRunnerWidth: function() 
		{
			this.noOfItems = Math.round(this.noOfItems / this.options.noOfRows);
			$("#debug").append("noOfItems="+this.noOfItems+"<br />");
			var width =  this.items.outerWidth(true) * this.noOfItems;
			this.runner.width(width);
		},
		insertPagination: function() 
		{
			var i, links = [];
			this.paginationLinks = $('<ol class="pagination-links" id="page_link"/>');
			for (i = 0; i < this.noOfPages; i++) 
			{
				if(i<=1)
				{
					links[i] = '<li><a href="#item-' + i + '">' + (i + 1) + '</a></li>';
				}
				else
				{
					if(i==this.noOfPages-1)
						links[i] = '<li><a href="#item-' + i + '">' + (i + 1) + '</a></li>';
					else
						links[i] = '<li class="hide"><a href="#item-' + i + '">' + (i + 1) + '</a></li>';
				}
			}
			//alert('insert page id on '+this.options.pageId);
			this.paginationLinks
				.append(links.join(''))
				.appendTo(document.getElementById(this.options.pageId))
				.find('a')
					.bind('click.carousel', $.proxy(this, 'paginationHandler'));
		},
		paginationHandler: function(e) 
		{
			this.itemIndex = e.target.hash.substr(1).split('-')[1] * this.options.itemsPerTransition;
			//alert("click"+this.itemIndex);
			this.showNeighbor();
			this.animate();
			return false;
		},
		insertNextPrevLinks: function() 
		{
			/*this.prevLink = $('<a href="#" class="prev"><<</a>')
								.bind('click.carousel', $.proxy(this, 'prevItem'))
								.appendTo(document.getElementById("prev"));*/
			this.prevLink = $('#'+this.options.prevId)
								.bind('click.carousel', $.proxy(this, 'prevItem'));			
			/*this.nextLink = $('<a href="#" class="next">>></a>')
								.bind('click.carousel', $.proxy(this, 'nextItem'))
								.appendTo(document.getElementById("next"));*/
			this.nextLink = $('#'+this.options.nextId)
								.bind('click.carousel', $.proxy(this, 'nextItem'));
		},
		nextItem: function() 
		{
			this.itemIndex = this.itemIndex + this.options.itemsPerTransition;
			//alert('next'+this.itemIndex);
			this.showNeighbor();
			this.animate();
			return false;
		},
		prevItem: function() 
		{
			this.itemIndex = this.itemIndex - this.options.itemsPerTransition;
			//alert('prev'+this.itemIndex);
			this.showNeighbor();
			this.animate();
			return false;
		},
		updateBtnStyles: function() 
		{
			if (this.options.pagination) 
			{
				this.paginationLinks
					.children('li')
						.removeClass('current')
						.eq(Math.ceil(this.itemIndex / this.options.itemsPerTransition))
							.addClass('current');
			}

			if (this.options.nextPrevLinks) {
				this.nextLink
					.add(this.prevLink)
						.removeClass('disabled');
				if (this.itemIndex === (this.noOfItems - this.options.itemsPerPage)) {
					this.nextLink.addClass('disabled');
				} 
				else if (this.itemIndex === 0) {
					this.prevLink.addClass('disabled');
				}
			}
		},
		animate: function() {
			var nextItem, pos;
			// check whether there are enough items to animate to
			if (this.itemIndex > (this.noOfItems - this.options.itemsPerPage)) {
				this.itemIndex = this.noOfItems - this.options.itemsPerPage; // go to last panel - items per transition
			}
			if (this.itemIndex < 0) {
				this.itemIndex = 0; // go to first
			}
			nextItem = this.items.eq(this.itemIndex);
			pos = nextItem.position();
			
			if (headache) {
				this.runner
					.stop()
					.animate({left: -pos.left}, this.options.speed, this.options.easing);
			}
			else {
				this.mask
					.stop()
					.animate({scrollLeft: pos.left}, this.options.speed, this.options.easing);
			}
			this.updateBtnStyles();
		},
		showNeighbor: function()
		{
			//alert("max pages:"+this.noOfPages);
			var show=this.itemIndex;
			var page_array=$("#page_link").children('li');
			//show 2 more pages above
			for(i=show+1;i-show<=1;i++)
			{
				if(i<this.noOfPages)
				{
					//alert("show up"+i);
					page_array.eq(i).removeClass("hide");
				}
			}
			//show 2 more pages below
			for(i=show-1;show-i<=1;i--)
			{
				if(i>=0)
				{
					//alert("show down"+i);
					page_array.eq(i).removeClass("hide");
				}
			}
			//hide the others
			this.hide();
		},
		hide: function()
		{
			//alert("hide");
			var page_array=$("#page_link").children('li');
			for(i=1;i<this.noOfPages-1;i++)
			{
				if(Math.abs(i-this.itemIndex)>1)
					page_array.eq(i).addClass("hide");
			}
		}
	};

	// bridge
	$.fn.carousel = function(options) {
		return this.each(function() {
			var obj = Object.create(Carousel);
			obj.init($(this), options);
			$.data(this, 'carousel', obj);
		});
	};
})(jQuery);