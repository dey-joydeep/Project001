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
<script src="http://code.jquery.com/jquery-3.3.1.min.js"
	integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
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
					<span>Friend List</span> <span class="ctrl-icon"><i
						class="material-icons">remove</i></span>
				</div>
				<div id="user-search" class="form-group">
					<input type="text" name="searchId" id="search-id"
						class="form-control" placeholder="Search Friend"
						disabled="disabled">
				</div>
				<div id="user-list"></div>
			</div>
			<div id="blank-panel" class="chat-sub-panel">
				<span class="ctrl-icon"><i class="material-icons">add</i></span>
			</div>
			<div id="msg-panel" class="chat-sub-panel col">
				<div id="message-out" class="row"></div>
				<div id="message-in" class="row">
					<div id="text-in" contenteditable="true"></div>
				</div>
			</div>
			<div id="user-info-panel" class="chat-sub-panel col-3">User
				Info Panel</div>
		</div>
	</div>
</body>
</html>