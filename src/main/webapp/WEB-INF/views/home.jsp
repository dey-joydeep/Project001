<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no, user-scalable=no">
<title>Home</title>
<link rel="stylesheet" href="resources/css//home/home.css" media="all">

<jsp:include page="common_js_with_popper.jsp" />
<script src="resources/js/home.js"></script>
</head>
<body>
	<header class="d-none d-lg-block d-md-block">Messaging Application</header>
	<div class="container-fluid">
		<div class="row">
			<div class="col">
				<div id="control-panel" class="clearfix"></div>
			</div>
		</div>
		<div class="row">
			<div class="col">
				<div id="frame-panel"></div>
			</div>
		</div>
	</div>
	<footer class="d-none d-lg-block"> Copyright &copy; Joydeep
		Dey </footer>

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
						<i class="material-icons md-12" title="Smiley"
							data-toggle="tooltip" data-placement="bottom">insert_emoticon</i>
						<i class="material-icons md-12" title="Take Photo"
							data-toggle="tooltip" data-placement="bottom">camera_enhance</i>
						<i class="material-icons md-12" title="Send Photos"
							data-toggle="tooltip" data-placement="bottom">insert_photo</i> <i
							class="material-icons" title="Send Videos md-12"
							data-toggle="tooltip" data-placement="bottom">videocam</i> <i
							class="material-icons md-12" title="Send Files"
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
	<input type="hidden" name="" id="h-uname" value="${user.username}">
</body>
</html>