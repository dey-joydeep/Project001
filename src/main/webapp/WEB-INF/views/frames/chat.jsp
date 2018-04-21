<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<link rel="stylesheet" href="resources/css/chat-frame.css">
<link rel="stylesheet" href="resources/css/common.css" media="all">
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
<script src="resources/js/chat-frame.js"></script>
</head>
<body>
	<div id="chat-panel" class="container-fluid">
		<div class="row">
			<div id="user-panel" class="chat-sub-panel col-3">
				<div class="heading">
					<label>Friend List</label> <label class="ctrl-icon"><i
						class="material-icons" title="Collapse Friend List">remove</i></label>
				</div>
				<div id="user-search" class="form-group">
					<input type="text" name="searchId" id="search-id"
						class="form-control" placeholder="Search Friend"
						disabled="disabled">
				</div>
				<div id="user-list"></div>
			</div>
			<div id="blank-panel" class="chat-sub-panel">
				<span class="ctrl-icon"><i class="material-icons"
					title="Expand Friend List">add</i></span>
			</div>
			<div id="msg-panel" class="chat-sub-panel col">
				<div id="message-out" class="row"></div>
				<div id="message-in" class="row">
					<div class="extras">
						<i class="material-icons md-12" title="Smiley"
							data-toggle="tooltip" data-placement="bottom">insert_emoticon</i>
						<i class="material-icons md-12" title="Take Photo"
							data-toggle="tooltip" data-placement="bottom">camera_enhance</i><i
							class="material-icons md-12" title="Send Photos"
							data-toggle="tooltip" data-placement="bottom">insert_photo</i><i
							class="material-icons md-12" title="Send Videos"
							data-toggle="tooltip" data-placement="bottom">videocam</i> <i
							class="material-icons md-12" title="Send Files"
							data-toggle="tooltip" data-placement="bottom">attach_file</i>
					</div>
					<div class="input-group mb-3 input-box">
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
		</div>
	</div>
</body>
</html>
