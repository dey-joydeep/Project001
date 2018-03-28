<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Login</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<link rel="stylesheet" href="resources/css/login.css" media="all">
<script src="http://code.jquery.com/jquery-3.3.1.min.js"
	integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
	crossorigin="anonymous"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
	integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
	crossorigin="anonymous"></script>
<script>
	$(function() {
		$('#login-form').submit(function(e) {
			e.preventDefault();
			var jqXhr = $.ajax({
				url : $(this).attr('action'),
				type : $(this).attr('method'),
				data : convertToJsonString($(this).serializeArray()),
				contentType : "application/json; charset=utf-8"
			});

			jqXhr.done(function(data) {
				if (!data.success) {
					$('#msg-div').text(data.message);
				} else {
					window.location.reload();
				}
			});
		});
	});

	function convertToJsonString(formArray) {

		var data = "{";
		for (var i = 0; i < formArray.length; i++) {
			data += ('"' + formArray[i]['name'] + '":"' + formArray[i]['value'] + '"');
			if (i < formArray.length - 1)
				data += ',';
		}
		data += "}";
		return data;
	}
</script>
</head>
<body>
	<header>Chat Application</header>
	<div class="container centered-form">
		<form:form id="login-form" modelAttribute="login" method="post"
			action="login">
			<div id="msg-div"></div>
			<div class="form-group">
				<form:label path="loginId">Username: </form:label>
				<form:input path="loginId" name="loginId" id="login-id"
					cssClass="form-control" />
				<form:label path="password">Password:</form:label>
				<form:password path="password" name="password" id="password"
					cssClass="form-control" />
			</div>
			<form:button id="login" name="login" class="btn btn-outline-primary">Login</form:button>
		</form:form>
	</div>
	<footer> Copyright &copy; Joydeep Dey </footer>
</body>
</html>
