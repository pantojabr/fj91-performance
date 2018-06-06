(function($) {
	"use strict"
	
	//config do owl.carousel
	$(".owl-carousel").owlCarousel({
		loop: true,
		margin: 10,
		center: true,
		autoplay: true,
		autoplayHoverPause: true,
		autoplayTimeout: 3000,
		responsive: {
			0: {
				items: 1
			},
			600: {
				items: 3
			},
			1000: {
				items: 5
			}
		}
	});
	
})(jQuery);
