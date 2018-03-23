<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Login</title>
<script src="http://code.jquery.com/jquery-3.3.1.min.js"
	integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
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
				if (!data.status) {
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
	<form:form id="login-form" modelAttribute="login" method="post"
		action="login">
		<table>
			<tr>
				<td><form:label path="loginId">Username: </form:label></td>
				<td><form:input path="loginId" name="loginId" id="login-id" />
				</td>
			</tr>
			<tr>
				<td><form:label path="password">Password:</form:label></td>
				<td><form:password path="password" name="password"
						id="password" /></td>
			</tr>
			<tr>
				<td></td>
				<td align="left"><form:button id="login" name="login">Login</form:button>
				</td>
			</tr>
			<tr></tr>
		</table>
	</form:form>
	<div id="msg-div"></div>
</body>
</html>