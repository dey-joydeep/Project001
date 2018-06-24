$(function() {
	loadUsers();
	$('#search-id').on('input', function() {
		searchUser();
	});

	$('#text-in').on('input', function() {
		controlChatContent($(this));
	});

	$(window).resize(function() {
		if (is1200EL()) {
			$('[data-toggle="tooltip"]').tooltip();
		}
		if (isMobile()) {
			$('#user-panel').replaceClass('col', 'col-3');
			$('#search-id').addClass('form-control-sm');
			$('[data-toggle="tooltip"]').tooltip('dispose');
		}
	});

	$('#back-to-friend-list').click(function() {
		$('.chat-sub-panel').hide();
		$('#user-panel').show();
	});

	$('#message-out').scroll(function() {
		// TODO: Implement scroll to bottom code.
	});
});

/**
 * Load the friend/user list associated with the logged in user
 */
function loadUsers() {
	var jqXhr = $.ajax({
		url : 'users',
		data : {
			loginId : "user1"
		},
		method : 'get',
		contentType : "application/json; charset=utf-8"
	});

	jqXhr.done(function(data) {
		var div = $('#user-list');
		if (data.length > 0) {
			$('#search-id').removeAttr('disabled');
			$.each(data, function(idx, user) {
				generateUserList(div, user);
			});

			$('.user-unit').click(function() {
				openChatPanel($(this));
			});
		}
	});
}

/**
 * Generate list of users info depending
 * 
 * @param mainDiv
 *            DIV, where user list will be added
 * @param user
 *            Details of an user fetched from server
 */
function generateUserList(mainDiv, user) {
	var proto = '<div class="row no-gutters user-unit">'
			+ '<input type="hidden" class="friend-ids">'
			+ '<div class="col-2"><img class="avatar" height="40" width="40"></div>'
			+ '<div class="col-10">'
			+ '<div class="row no-gutters">'
			+ '<div class="users col-7"><span class="user-status"></span></div>'
			+ '<div class="col message-time text-right"></div>'
			+ '<div class="w-100"></div>'
			+ '<div class="message-summary col-10 text-truncate"></div>'
			+ '<div class="col text-right"><i class="material-icons md-15 status-icon">done</i></div>'
			+ '</div>' + '</div>' + '</div>';
	proto = $(proto);
	mainDiv.append(proto);

	proto.find('.friend-ids').val(user.publicUsername);
	var name = user.firstname + " " + user.lastname;
	var img = proto.find('.avatar');
	img.attr('src', user.avatar);
	img.prop('alt', name);

	var statusSpan = proto.find('.user-status');
	if (user.status === 1)
		statusSpan.addClass('online');
	else
		statusSpan.addClass('offline');
	$(statusSpan).after(name);

	proto.find('.message-time').text(user.lastMessageTime);
	proto.find('.message-summary').text(user.lastMessage);

	var status = proto.find('.status-icon');
	switch (user.lastMessageStatus) {
	case 0:
		status.text('done');
		break;
	case 1:
		status.text('done_all');
		break;
	case 2:
		status.addClass('delivered');
		status.text('done_all');
		break;
	default:
		status.addClass('send-failed');
		status.text('error_outline');
		break;
	}

}

/**
 * Open chat panel for selected user passed via parameter as jQuery object.
 * 
 * @param user
 *            Selected user
 */
function openChatPanel(user) {
	$('#curr-size').val(0);
	$('#next-size').val(100);
	$('#msg-panel').show();
	$('#message-out>div.col').empty();

	if (isMobile()) {
		$('#user-panel').hide();
	}
	loadMessages(user, 1);
}

/**
 * Load message for given user. If called by user selection, only last 100
 * messages will be loaded. If called by scrolling up, next 100 from current
 * will be loaded. Calling from message notification is same as user selection.
 * 
 * @param user
 *            Selected user
 * @param caller
 *            caller identifier {0: scroll, 1: other}
 */
function loadMessages(user, caller) {
	var jqXhr = $.ajax({
		url : 'messages',
		data : {
			loginId : $('#h-uname', window.parent.document).val(),
			friendId : user.find('.friend-ids').val(),
			currentSize : $('#curr-size').val(),
			nextSize : $('#next-size').val()
		},
		method : 'get',
		contentType : "application/json; charset=utf-8"
	});

	jqXhr.done(function(chat) {

		var userDiv = $('#user-info');
		userDiv.empty();
		var imgTag = $('<img class="avatar" height="30" width="30" >');
		imgTag.attr('src', chat.avatar);
		userDiv.append(imgTag);
		userDiv.append(chat.senderName);

		var messageDiv = $('#message-out>div.col');
		if (chat.messages.length > 0) {
			$.each(chat.messages, function(idx, msg) {
				// renderMessage(messageDiv, msg, caller);
				renderMessageTemp(messageDiv, msg);
			});
			if (caller === 1) {
				messageDiv.scrollTop(messageDiv.prop("scrollHeight"));
			}
		} else {

		}
	});
}
function renderMessage(mainDiv, msg) {
	var blankCol = '<div class="col"></div>';
	var msgDiv = $('<div class="msg col"></div>');
	var contentDiv = $('<div class="content row" ></div>');
	var wrapperBody = $('<div class="wrapper col-10"></div>');
	var msgBody = $('<div class="msg-body"></div>');
	var bottomDiv = $('<div class="bottom row"></div>');
	var tsDiv = $('<div class="col"></div>');
	var statusDiv = $('<div class="col text-right"></div>');

	msgDiv.attr('id', msg.messageId);
	msgBody.text(msg.content);

	if (msg.sender) {
		contentDiv.addClass('sender-msg');
	} else {
		contentDiv.addClass('receiver-msg');
	}
	wrapperBody.append(msgBody);
	wrapperBody.append('<div class="w-100"></div>');

	tsDiv.text(msg.sentAt);
	statusDiv.text('Seen');
	bottomDiv.append(tsDiv);
	bottomDiv.append(statusDiv);
	wrapperBody.append($('<div class="col"></div>').append(bottomDiv));

	contentDiv.append(wrapperBody);
	msgDiv.append(contentDiv);
	mainDiv.append(msgDiv);
	$('<div class="w-100"></div>').insertAfter(msgDiv);

	if (msg.sender) {
		msgDiv.addClass('align-self-end');
		$('.content>div').first().addClass('order-last');
		$('.content>div').last().addClass('order-first');
	} else {
		msgDiv.addClass('align-self-start');
	}

	msgBody.click(function() {
		$(this).parent().find('.bottom').toggleClass('flex-display');
	});
}

function renderMessageTemp(mainDiv, msg) {
	var proto = '<div class="msg row" >' + '<div class="col-10 content"></div>'
			+ '<div class="w-100"></div>'
			+ '<div class="col-10 attachments"></div>'
			+ '<div class="w-100"></div>' + '<div class="col-10">'
			+ '<div class="d-inline message-time"></div>'
			+ '<div class="d-inline message-status float-right"></div>'
			+ '</div>';
	proto = $(proto);
	mainDiv.append(proto);

	proto.attr('id', msg.messageId);
	if (msg.sender)
		proto.addClass('justify-content-start');
	else
		proto.addClass('justify-content-end');
	proto.find('.content').text(msg.content);
	proto.find('.message-time').text(msg.sentAt);
	proto.find('.message-status').text('Seen');
}

function searchUser() {
	var input, filter, ul, li, a;
	input = $('#search-id');
	filter = input.val().toLowerCase();
	ul = $('#user-list>ul');
	li = $('li');
	for (var i = 0; i < li.length; i++) {
		if ($(li[i]).text().toLowerCase().indexOf(filter) > -1) {
			$(li[i]).show();
		} else {
			$(li[i]).hide();

		}
	}
}

function controlChatContent(elem) {
	if (elem.text().length > 0) {
		$('#send-btn').removeClass('disabled');
	} else {
		$('#send-btn').addClass('disabled');
	}
}
