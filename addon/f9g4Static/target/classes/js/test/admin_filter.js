angular.module('adminFilters', [])
	.filter('rating', function() {
      return function(input, showNative) {
	    var out="";	  
        if(input=='-1')
        	out='Unrated';
        else
        	out=input;
        // conditional based on optional argument
        if (showNative) {
          out = input;
        }
        return out;
      };
    })
    .filter('groupIndex', function() {
    	return function(input) {
    		var out="";	  
            out = Math.floor(input).toString();
            return out;
    	};
    })
    .filter('upperBound', function() {
    	return function(input, upperBound) {
    		var out='---';
    		if(input !=null && input != undefined && input != '---') {
        		if(input < upperBound)
        			out=input;
        		else
        			out=(upperBound-1)+'+';
    		}
    		return out;
    	}
    });