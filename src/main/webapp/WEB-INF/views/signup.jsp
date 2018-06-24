<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no, user-scalable=no">
<title>Sign up</title>
<link rel="stylesheet" href="resources/css/signup/signup.css"
	media="all">
<jsp:include page="common_js_only.jsp" />
<script src="resources/js/signup.js"></script>
</head>
<body>
	<header>Messaging Application- Sign Up</header>
	<div class="container-fluid centered-form">
		<div class="heading">Create a free account with XXX. It only
			takes a minute.</div>
		<div id="msg-div" class="center">
			<div class="alert alert-danger" role="alert"></div>
		</div>
		<form:form id="signup-form" modelAttribute="signup" method="post"
			action="signup" novalidate="true" cssClass="center">
			<%-- cssClass="center" --%>
			<div class="row justify-content-center page" id="page-1">
				<div class="col">
					<div class="form-group field-div">
						<form:label path="firstname" cssClass="field-label">First Name</form:label>
						<form:input path="firstname" name="firstname" id="first-name"
							placeholder="Joydeep" cssClass="form-control form-control-sm" />
					</div>
				</div>
				<div class="w-0"></div>
				<div class="col">
					<div class="form-group field-div">
						<form:label path="lastname" cssClass="field-label">Last Name</form:label>
						<form:input path="lastname" name="lastname" id="last-name"
							placeholder="Dey" cssClass="form-control form-control-sm" />
					</div>
				</div>
				<div class="w-100"></div>
				<div class="col">
					<div class="form-group field-div">
						<form:label path="birthdate" cssClass="field-label">Date of Birth</form:label>
						<div class="row">
							<div class="col">
								<select id="dob-yy" class="form-control form-control-sm dob">
									<option value="">YYYY</option>
								</select>
							</div>
							<div class="col">
								<select id="dob-mm" class="form-control form-control-sm dob"><option
										value="">MM</option></select>
							</div>
							<div class="col">
								<select id="dob-dd" class="form-control form-control-sm dob"><option
										value="">DD</option></select>
							</div>
						</div>
						<form:hidden path="birthdate" name="birthdate" id="birthdate" />
					</div>
				</div>
				<div class="w-0"></div>
				<div class="col">
					<div class="form-group field-div">
						<form:label path="sex" cssClass="field-label">Gender</form:label>
						<form:select path="sex" name="sex" id="sex"
							cssClass="form-control form-control-sm">
							<form:option value="">--Select--</form:option>
							<form:option value="1">Male</form:option>
							<form:option value="2">Female</form:option>
							<form:option value="3">Prefer not to say</form:option>
						</form:select>
					</div>
				</div>
			</div>
			<div class="row justify-content-center page" id="page-2">
				<div class="col">
					<div class="form-group field-div" id="email-div">
						<form:label path="email" cssClass="field-label">Email
						</form:label>
						<span class="login-switch">(sign up by mobile no)</span>
						<form:input path="email" name="email" id="email" type="email"
							cssClass="form-control form-control-sm"
							placeholder="dey.joydeep@example.com" />
					</div>
					<div class="form-group field-div" id="mobile-div">
						<form:label path="phoneNo" cssClass="field-label">Mobile No.
						</form:label>
						<span class="login-switch">(sign up by email)</span>
						<form:input path="phoneNo" name="phoneNo" id="phone-no" type="tel"
							cssClass="form-control form-control-sm"
							placeholder="91-9800098000" />
					</div>
				</div>
				<div class="w-0"></div>
				<div class="col">
					<div class="form-group field-div">
						<form:label path="password" cssClass="field-label">Password</form:label>
						<div class="input-group mb-3">
							<form:password path="password" name="password" id="password"
								cssClass="form-control form-control-sm" />
							<div class="input-group-append pass-check">
								<span class="input-group-text"><i
									class="material-icons  md-18 pass-vis"> visibility </i></span>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="row justify-content-center page" id="page-3"></div>
			<div class="row justify-content-center btn-ctrl">
				<div class="col-3 page-op page-op-2 page-op-3">
					<input type="button" value="Back"
						class="btn btn-sm btn-primary btn-block" id="bck-btn">
				</div>
				<div class="col-3 page-op page-op-1 page-op-2">
					<input type="button" value="Next"
						class="btn btn-sm btn-primary btn-block" id="nxt-btn">
				</div>
				<div class="col-3 page-op page-op-3">
					<input id="signup-btn" name="signup"
						class="btn btn-sm btn-primary btn-block" value="Sign up"
						type="submit">
				</div>
				<div class="w-100"></div>
				<div class="col page-op page-op-3 non-btn">
					<div class="policy-note">
						By clicking "Sign up", you acknowledge that you have read our
						updated <a href="#">terms of service</a>, <a href="#">privacy
							policy</a> and <a href="#">cookie policy</a>, and that your continued
						use of the website is subject to these policies.
					</div>
				</div>
			</div>
			<form:hidden path="deviceType" id="dev-type" />
			<form:hidden path="pageVal" id="page-val" />
			<form:hidden path="loginMode" id="login-mode" />
		</form:form>
		<div class="footnote center">
			Already have an account? <a href="${pageContext.request.contextPath}">Login</a>
		</div>
	</div>
	<footer> Copyright &copy; Joydeep Dey </footer>
</body>
</html>
