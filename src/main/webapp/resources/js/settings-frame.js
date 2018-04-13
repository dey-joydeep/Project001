$(function() {
	$('.nav-link').click(function() {
		var dataParam = $(this).attr('data-param');
		clickLink(dataParam);
		top.window.location.hash = this.hash;
	});
	setUsernameSettignsButtonValue();
});

function clickLink(param) {
	$('.details').hide();
	$('div[data-param="' + param + '"]').show();
}

function setUsernameSettignsButtonValue() {
	var username = $(this.parent.document).find('#h-uname').val();
	if (username.startsWith('$'))
		$('#uname-set-btn').val("Set");
	else
		$('#uname-set-btn').val("Update");
}
