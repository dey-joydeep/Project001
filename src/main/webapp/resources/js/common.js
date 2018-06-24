const
isMobile = function() {
	return window.matchMedia('(max-width:576px)').matches;
}

/**
 * Check if media screen is 1200px or larger
 * @returns checked value
 */
const
is1200EL = function() {
	return window.matchMedia('(min-width: 1200px)').matches;
}

$.fn.replaceClass = function(newClass, oldClass) {
	$(this).removeClass(oldClass).addClass(newClass);
};

var convertToJsonString = function(formArray) {

	var data = "{";
	for (var i = 0; i < formArray.length; i++) {
		data += ('"' + formArray[i]['name'] + '":"' + formArray[i]['value'] + '"');
		if (i < formArray.length - 1)
			data += ',';
	}
	data += "}";
	return data;
}

$('input').keypress(function(e) {
	if (e.which == 13) {
		$('#login-btn').click();
	}
});

$.fn.showFlex = function() {
	$(this).css('display', 'flex');
}

$.fn.getFrameElemFromParent = function(target) {
	return $(this).contents().find(target)
}

var frameVal = function(selector) {
	return $(selector, window.parent.document).val();
}
