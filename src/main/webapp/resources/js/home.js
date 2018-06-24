var frameLoadCnt = -1;
$(function() {
	loadMenus();
	loadFrames();
	$(document).ajaxStop(function() {
		$(window).resize(function() {
			if (is1200EL()) {
				$('[data-toggle="tooltip"]').tooltip();
				$('.material-icons.dropdown-toggle').tooltip();
			}
			if (isMobile()) {
				$('[data-toggle="tooltip"]').tooltip('dispose');
				$('.material-icons.dropdown-toggle').tooltip('dispose');
			}
		});

		setClickActions();

		var iframes = $('iframe');
		$.each(iframes, function(i, iframe) {
			iframe.onload = function() {
				frameLoadCnt--;
				if (frameLoadCnt === 0)
					displayFrame();
			};
		});
	});
});

function displayFrame() {
	var link = window.location.hash;
	if (link.length > 0) {
		// IMPORTANT: Frame's SRC path is same as #PATH
		var parts = link.substring(1).split('_');
		$('iframe[src=' + parts[0] + ']').show();
		if (parts.length > 1) {
			$('a[data-param=' + parts[1] + ']').click();
		}
	} else {
		$($('iframe')[0]).show();
	}
}

function setClickActions() {
	$('#home-icon').click(function() {
		$('.frames').hide();
		$('#chat-frame').show();

		$('#chat-frame').getFrameElemFromParent('.chat-sub-panel').hide();
		$('#chat-frame').getFrameElemFromParent('#user-panel').show();
	});

	$('[aria-labelledby="icon-settings"]>a').click(
			function() {
				$('.frames').hide();
				$('#settings-frame').show();
				$('#settings-frame')[0].contentWindow.clickLink($(this).attr(
						'data-param'));
			});

	$('#logout-icon').click(function() {
		var jqXhr = $.ajax({
			url : 'logout',
			method : 'get',
			contentType : "application/json; charset=utf-8"
		});
		jqXhr.done(function(data) {
			window.location.replace(context);
		});
	});
}

function hideDropDown() {
	var dds = $('.dropdown-menu');
	$.each(dds, function(i, dd) {
		if (!$(dd).is(':hidden'))
			$(dd).hide();
	});
}

function loadMenus() {
	var jqXhr = $.ajax({
		url : 'menu',
		method : 'get',
		contentType : "application/json; charset=utf-8"
	});
	jqXhr.done(function(data) {
		$.each(data, function(i, menu) {
			mapMenu(menu);
		});
	});
}

function mapMenu(menu) {
	var parentDiv = $('#control-panel');
	var menuDiv = $('<div></div>');
	var menuIcon = $('<i class="material-icons" aria-haspopup="true" aria-expanded="false"></i>');
	menuIcon.attr('id', menu.identifier);
	menuIcon.attr('title', menu.name);
	menuIcon.attr('data-placement', menu.tooltipPosition);
	menuIcon.text(menu.iconName);

	if (menu.clickActionType === 'MODAL') {
		menuDiv.attr('data-toggle', 'modal');
		menuDiv.attr('data-target', menu.modalTarget);
	}

	if (menu.subMenuExists) {
		menuIcon.attr('data-toggle', 'dropdown');
		menuIcon.addClass('dropdown-toggle');
		var subMenuDiv = $('<div class="dropdown-menu"></div>');
		subMenuDiv.attr('aria-labelledby', menu.identifier);
		$.each(menu.subMenuList, function(j, subMenu) {
			var anchor = $('<a class="dropdown-item"></a>');
			anchor.text(subMenu.name);
			anchor.attr('href', menu.linkHref + '_' + subMenu.parameterValue);
			$.each(subMenu.otherAttributes, function(attrib, value) {
				anchor.attr(attrib, value);
			});
			subMenuDiv.append(anchor);
		});
	} else {
		menuIcon.attr('data-toggle', 'tooltip');
		menuIcon = $('<a href="' + menu.linkHref + '"></a>').append(menuIcon);
	}

	if (menu.menuItemPosition === 'RIGHT') {
		menuDiv.addClass('float-right');
	} else {
		menuDiv.addClass('float-left');
	}

	menuDiv.append(menuIcon);
	menuDiv.append(subMenuDiv);

	parentDiv.append(menuDiv);
}

function loadFrames() {
	var jqXhr = $.ajax({
		url : 'frame',
		method : 'get',
		// async: false,
		contentType : "application/json; charset=utf-8"
	});
	jqXhr.done(function(data) {
		frameLoadCnt = data.length;
		$.each(data, function(i, frame) {
			var iframe = $('<iframe class="frames" ></iframe>');
			iframe.attr('id', frame.frameId);
			iframe.attr('src', frame.frameSource);

			$('#frame-panel').append(iframe);
		});
	});
}