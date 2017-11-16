(function($, mce) {
	"use strict"
	
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
	
})(jQuery, tinymce);
