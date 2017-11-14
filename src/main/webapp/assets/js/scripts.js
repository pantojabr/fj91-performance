(function($, swal, mce) {
	"use strict"
	
	//mensagens de sucesso
	let msg = $("body").data("msg");
	if (msg) {
		swal("", msg, "success");
	}
	
	//configs do TinyMCE
	mce.init({
		selector: "textarea[name=descricao]",
		height: 300,
		menubar: false,
		language: "pt_BR",
		toolbar: "undo redo | styleselect | bold italic | alignleft aligncenter alignright alignjustify | bullist numlist outdent indent | link image | code",
		plugins: [
			"advlist autolink lists link image charmap print preview anchor",
			"searchreplace visualblocks code fullscreen",
			"insertdatetime media table contextmenu code" 
		]
	});
	
	//config do Select2 plugin
	$("select").select2();
	
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
	
})(jQuery, sweetAlert, tinymce);
