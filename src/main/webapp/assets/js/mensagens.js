(function($, swal) {
	"use strict"
	
	//mensagens de sucesso
	let msg = $("body").data("msg");
	if (msg) {
		swal("", msg, "success");
	}
	
})(jQuery, sweetAlert);
