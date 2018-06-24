<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no, user-scalable=no">
<title>Login</title>
<link rel="stylesheet" href="resources/css/login/login.css" media="all">
<jsp:include page="common_js_only.jsp" />
<script>
	$(function() {
		$('#login-form').submit(function(e) {
			$('#msg-div').hide();
			$('#msg-div').text('');
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
					$('#msg-div').show();
				} else {
					window.location.reload();
				}
			});
		});

		if (isMobile()) {
			$('.col-4').replaceClass('col', 'col-4');
		}
	});
</script>
</head>
<body>
	<header>Messaging Application</header>
	<div class="container-fluid centered-form">
		<div id="msg-div"></div>
		<form:form id="login-form" modelAttribute="login" method="post"
			action="login" cssClass="center">
			<div class="row justify-content-end">
				<div class="col">
					<div class="form-group">
						<form:label path="loginId" cssClass="field-label">Username: </form:label>
						<form:input path="loginId" id="login-id" cssClass="form-control"
							placeholder="Login ID or email or mobile no." />
					</div>
				</div>
				<div class="w-100"></div>
				<div class="col">
					<div class="form-group">
						<form:label path="password" cssClass="field-label">Password:</form:label>
						<form:password path="password" id="password"
							cssClass="form-control" placeholder="Password" />
					</div>
				</div>
				<div class="w-100"></div>
				<div class="col">
					<div class="form-check form-check-inline">
						<form:checkbox path="rememberMe" id="rem-chk"
							cssClass="form-check-input" value="false" />
						<form:label path="rememberMe"
							cssClass="form-check-label field-label">Remember me</form:label>
					</div>
				</div>
				<div class="w-100"></div>
				<div class="col-4 p-3">
					<form:button id="login-btn" name="login"
						class="btn btn-sm btn-outline-primary btn-block">Login</form:button>
				</div>
				<div class="w-100"></div>
				<div class="col links">
					<a href="#">Forgot Password? Click here to reset.</a>
					<div class="w-100"></div>
					<label> Don't have an account yet? <a href="signup"
						class="">Sign up</a>
					</label>
				</div>
			</div>
		</form:form>
	</div>
	<footer> Copyright &copy; Joydeep Dey </footer>
</body>
</html>
