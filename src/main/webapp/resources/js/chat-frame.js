$(function() {
	loadUsers();
	loadMessages();
	$('#search-id').on('input', function() {
		searchUser();
	});

	$('.ctrl-icon').click(function() {
		if ($(this).text() == 'add') {
			$('#blank-panel').hide();
			$('#user-panel').toggle('slow');
		} else {
			$('#blank-panel').toggle('slow');
			$('#user-panel').hide();
		}
	});
});

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
		var ul = $('<ul></ul>');
		if (data.length > 0) {
			$('#search-id').removeAttr('disabled');
			$.each(data, function(idx, user) {
				var li = $('<li class="users" id="' + user.publicUsername
						+ '"</li>');
				li.text(user.firstname + " " + user.lastname);
				ul.append(li);
			});
			div.append(ul);
			$('.users').click(function() {
				$('#user-info-panel').toggle();
			});
		}
	});
}

function loadMessages() {
	var jqXhr = $.ajax({
		url : 'messages',
		data : {
			loginId : "user1",
			currentSize : 0,
			nextSize : 10
		},
		method : 'get',
		contentType : "application/json; charset=utf-8"
	});

	jqXhr.done(function(data) {
		var div = $('#message-out');
		$.each(data, function(idx, msg) {
			var msgDiv = $('<div class="msg" </div>');
			var wrapperDiv = $('<div class="wrapper" ></div>');
			var anchor = $('<a ></a>');
			var img = $('<img  height="36" width="36">');
			var contentDiv = $('<div class="content"></div>');
			var tsDiv = $('<div class="col"></div>');
			var statusDiv = $('<div class="col"></div>');
			var footnoteDiv = $('<div class="footnote row"></div>');

			msgDiv.attr('id', msg.messageId);
			img.attr('src', msg.avatar);
			anchor.append(img);
			contentDiv.text(msg.content);

			if (msg.senderId !== null && msg.senderId.length > 0) {
				wrapperDiv.addClass('sender-msg');
				anchor.attr('href', msg.senderId);
				img.prop('alt', msg.senderName);
				img.prop('title', msg.senderName);

				wrapperDiv.append(anchor);
				wrapperDiv.append(contentDiv);
			} else {
				wrapperDiv.addClass('receiver-msg');
				anchor.attr('href', msg.receiverId);
				img.prop('alt', msg.receiverName);
				img.prop('title', msg.receiverName);

				wrapperDiv.append(contentDiv);
				wrapperDiv.append(anchor);
			}

			tsDiv.text('2018/03/23 11:15:39');
			statusDiv.text('Seen');
			footnoteDiv.append(tsDiv);
			footnoteDiv.append(statusDiv);
			wrapperDiv.append(footnoteDiv);
			msgDiv.append(wrapperDiv);
			div.append(msgDiv);
		});
	});
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