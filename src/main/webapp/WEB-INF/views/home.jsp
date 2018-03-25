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
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
	integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
	crossorigin="anonymous"></script>
<script>
	
</script>
</head>
<body>
	<div class="container-fluid body-content">
		<div class="row">
			<header class="col">Chat Application</header>
		</div>
		<div class="row">
			<div class="col">
				<div id="control-panel">
					<i class="material-icons left-icons" title="Create New Message">chat</i>
					<i class="material-icons right-icons" title="Profile">account_circle</i>
					<i class="material-icons right-icons" title="Settings">settings</i>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col">
				<div id="frame-panel">
					<iframe src="chat"></iframe>
				</div>
			</div>
		</div>
		<div class="row">
			<footer class="col"> Copyright &copy; Joydeep Dey </footer>
		</div>
	</div>
</body>
</html>