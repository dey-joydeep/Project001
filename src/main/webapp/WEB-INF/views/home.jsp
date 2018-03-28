<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Home</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<link rel="stylesheet" href="resources/css/styler.css" media="all">
<script src="http://code.jquery.com/jquery-3.3.1.min.js"
	integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
	integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
	crossorigin="anonymous"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
	integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
	crossorigin="anonymous"></script>
<script src="resources/js/home.js"></script>
</head>
<body>
	<div class="container-fluid">
		<div class="row">
			<header class="col">Chat Application</header>
		</div>
		<div class="row">
			<div class="col">
				<div id="control-panel"></div>
			</div>
		</div>
		<div class="row">
			<div class="col">
				<div id="frame-panel"></div>
			</div>
		</div>
		<div class="row">
			<footer class="col"> Copyright &copy; Joydeep Dey </footer>
		</div>
	</div>

	<!-- Modal -->
	<div class="modal fade" id="new-msg-modal" tabindex="-1" role="dialog"
		aria-labelledby="new-msg-modal-title" aria-hidden="true">
		<div class="modal-dialog modal-dialog-centered" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="new-msg-modal-title">Compose</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<div class="input-group mb-3">
						<div class="input-group-prepend">
							<span class="input-group-text" id="basic-addon1">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;To:</span>
						</div>
						<div id="recipients" contenteditable="true" class="form-control"
							aria-label="recipients" aria-describedby="basic-addon1"></div>
					</div>
					<div class="extras">
						<i class="material-icons md-18" title="Smiley"
							data-toggle="tooltip" data-placement="bottom">insert_emoticon</i>
						<i class="material-icons md-18" title="Send Photos"
							data-toggle="tooltip" data-placement="bottom">insert_photo</i><i
							class="material-icons" title="Send Videos md-18"
							data-toggle="tooltip" data-placement="bottom">videocam</i> <i
							class="material-icons md-18" title="Send Files"
							data-toggle="tooltip" data-placement="bottom">attach_file</i>
					</div>
					<div class="input-group mb-3">
						<div class="input-group-prepend">
							<span class="input-group-text" id="basic-addon1">Message:</span>
						</div>
						<div id="msg-text" contenteditable="true" class="form-control"
							aria-label="message" aria-describedby="basic-addon1"></div>
					</div>
				</div>
				<div class="modal-footer">
					<button class="btn btn-outline-danger disabled" title="Cancel"
						data-toggle="tooltip" data-placement="bottom" id="cancel-btn"
						data-dismiss="modal">
						<i class="material-icons">clear</i>
					</button>
					<button class="btn btn-outline-secondary disabled" title="Send"
						data-toggle="tooltip" data-placement="bottom" id="send-btn">
						<i class="material-icons">send</i>
					</button>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
