/**
 *
 *	[SOW] Builder
 *
 *	@author 		Dorin Grigoras
 *					www.stepofweb.com
 *
 *	@Dependency 	-
 *	@Usage			$.SOW.core.builder.init();
 * 
 *
 **/
;(function ($) {
	'use strict';


	/**
	 *
	 *	@vars
	 *
	 *
	 **/
	var scriptInfo 		= 'SOW Builder';


	$.SOW.core.builder = {


		/**
		 *
		 *	@config
		 *
		 *
		 **/
		config: {},



		/**
		 *
		 *	@collection
		 *
		 *
		 **/
		collection: $(),



		/**
		 *
		 *	@init
		 * 	
		 *
		 **/
		init: function (selector, config) {


			// -- * --
			$.SOW.helper.consoleLog('Init : ' + scriptInfo);
			// -- * --


			return this.collection;

		},



		/**
		 *
		 * 	
		 *
		 **/
		_________: function() {



		},


	};


})(jQuery);