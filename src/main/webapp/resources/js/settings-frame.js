$(function() {
	$('.nav-link').click(function() {
		var dataParam = $(this).attr('data-param');
		clickLink(dataParam);
		top.window.location.hash = this.hash;
	});
});

function clickLink(param) {
	$('.details').hide();
	$('div[data-param="' + param + '"]').show();
}
