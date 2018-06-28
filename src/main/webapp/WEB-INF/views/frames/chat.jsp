<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no, user-scalable=no">
<link rel="stylesheet" href="resources/css/chat/chat-frame.css">
<jsp:include page="../common_js_with_popper.jsp" />
<script src="resources/js/chat-frame.js"></script>
<script src="resources/js/ws-comm.js"></script>
</head>
<body>
	<div id="chat-panel" class="container-fluid">
		<div class="row">
			<div id="user-panel" class="chat-sub-panel col-3">
				<div class="heading">
					<label>Friend List</label>
				</div>
				<div id="user-search" class="form-group">
					<input type="search" name="searchId" id="search-id"
						class="form-control" placeholder="Search Friend"
						disabled="disabled">
				</div>
				<div id="user-list"></div>
			</div>
			<div id="msg-panel" class="chat-sub-panel col">
				<div class="row">
					<div class="col chat-top-bar clearfix">
						<div class="float-left d-lg-none d-md-none">
							<i class="material-icons" id="back-to-friend-list">
								arrow_back_ios </i>
						</div>
						<div id="user-info" class="float-left"></div>
						<div class="float-right">
							<i class="material-icons">call</i> <i class="material-icons">videocam</i>
						</div>
						<input type="hidden" name="receiverId" id="receiver-id">
					</div>
				</div>
				<div id="message-out" class="row">
					<div class="col"></div>
				</div>
				<div id="message-in" class="row">
					<div class="extras col">
						<i class="material-icons float-left d-none d-lg-inline"
							title="Smiley" data-toggle="tooltip" data-placement="bottom">insert_emoticon</i>

						<i class="material-icons float-left" title="Take Photo"
							data-toggle="tooltip" data-placement="bottom">camera_enhance</i>

						<i class="material-icons d-none d-md-inline float-left"
							title="Send Photos & Videos" data-toggle="tooltip"
							data-placement="bottom">perm_media</i> <i
							class="material-icons d-none d-md-inline float-left"
							title="Send Documents" data-toggle="tooltip"
							data-placement="bottom">insert_drive_file</i> <i
							class="material-icons d-none d-md-inline float-left"
							title="Location" data-toggle="tooltip" data-placement="bottom">add_location</i>
						<i id="send-items"
							class="d-sm-inline d-md-none material-icons dropdown-toggle float-right"
							data-toggle="dropdown">add</i>

						<div class="dropdown-menu" aria-labelledby="send-items">
							<a class="dropdown-item" href="#"><i class="material-icons">perm_media</i>
								<label> Send Photos &amp; Videos</label></a> <a
								class="dropdown-item" href="#"><i class="material-icons">insert_drive_file</i>
								<label>Send Documents</label></a> <a class="dropdown-item" href="#"><i
								class="material-icons">add_location</i> <label>Send
									Location</label></a> <a class="dropdown-item" href="#"><i
								class="material-icons">account_box</i> <label>Send
									Contact</label></a>
						</div>
					</div>
					<div class="w-100"></div>
					<div class="input-group mb-3 input-box col">
						<div id="text-in" contenteditable="true" class="form-control"
							aria-label="" aria-describedby="basic-addon1"></div>
						<div class="input-group-append">
							<button class="btn btn-outline-secondary disabled" title="Send"
								data-toggle="tooltip" data-placement="bottom" id="send-btn">
								<i class="material-icons">send</i>
							</button>
						</div>
					</div>
				</div>
			</div>
			<div id="summary-panel" class="chat-sub-panel col-3">User Info
				Panel</div>
			<input type="hidden" id="curr-size" value="0"> <input
				type="hidden" id="next-size" value="100">
		</div>
	</div>
</body>
</html>
