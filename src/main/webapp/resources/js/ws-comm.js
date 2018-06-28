// Create WebSocket connection.
const
socket = new WebSocket('ws://localhost/chatapp/socket/conn/ws?loginId='
		+ $('#h-uname', window.parent.document).val());

// Connection opened
socket.addEventListener('open', function(event) {
	console.log('WS connection opened');
});

// Listen for messages
socket.addEventListener('message', function(event) {
	console.log('Message from server ', event.data);
});

$(function() {
	$('#send-btn').click(function() {
		var data = {
			'senderId' : $('#h-uname', window.parent.document).val(),
			'recieverId' : $('#receiver-id').val(),
			'file' : '',
			'message' : $('#text-in').text()
		};
		socket.send(JSON.stringify(data));
	});
});