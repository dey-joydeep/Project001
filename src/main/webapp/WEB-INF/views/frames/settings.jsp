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
<link rel="stylesheet" href="resources/css/settings-frame.css">
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
<script src="resources/js/settings-frame.js"></script>
</head>
<body>
	<div class="container-fluid">
		<div class="row main-panel">
			<div class="col-3 settings-sub-panel">
				<nav class="nav flex-column">
					<a class="nav-link" href="#settings_set-1" data-param="set-1">Account</a>
					<a class="nav-link" href="#settings_set-2" data-param="set-2">General</a>
					<a class="nav-link" href="#settings_set-3" data-param="set-3">Security</a>
					<a class="nav-link" href="#settings_set-4" data-param="set-4">Privacy</a>
					<a class="nav-link" href="#settings_set-5" data-param="set-5">Chats</a>
					<a class="nav-link" href="#settings_set-6" data-param="set-6">Notification</a>
				</nav>
			</div>
			<div class="col settings-sub-panel setting-details">

				<div class="details" data-param="set-1">
					<section>
						<h4>Suspend Account</h4>
						<p>Suspend this account. When an account is in suspended
							state, you cannot be able to operate this account until the
							suspension is revoked. Once the account is suspended, you will be
							automatically logged out from all the devices. On login again,
							you will be asked to choose whether the suspension will be
							continued or revoked. On revoking, the account will back to the
							normal state. If you have any trusted device with two steps
							verification turned on, the device will be required to verify
							again.</p>
						<p>When in suspended state, your friends cannot visit your
							profile or send new message or reply to your message. However,
							you will not lose your contacts and they can check any previously
							made conversation. Revoking suspension would make them able to
							interact with again.</p>
						<input type="button" value="Suspend" class="btn btn-secondary">
					</section>
					<section>
						<h4>Delete Account</h4>
						<p>Delete this account permanently. When an account is
							deleted, all data with this account will be erased and you will
							be logged out from all the devices you are connected from. Alike
							suspend, your friends cannot visit your profile or send new
							message or reply to your message. However, you will not lose your
							contacts and they can check any previously made conversation. If
							you want to get connected with your friends again, you need to
							start from the beginning by singing up.</p>
						<input type="button" value="Delete" class="btn btn-danger">
					</section>
				</div>
				<div class="details row" data-param="set-2">
					<div class="semi-row">
						Set or update your
						<code>username</code>
						. A
						<code>username</code>
						must be unique to the profile and can be used for login. You also
						can refer your account by the
						<code>username</code>
						. Updating your
						<code>username</code>
						account will not be affected by the update.
						<div class="alert alert-light footnote" role="alert">
							Caution: If you update your
							<code>username</code>
							, any referral to your account with previous
							<code>username</code>
							will be inaccessible.
						</div>
						<div class="input-group mb-3">
							<input type="text" class="form-control"
								placeholder="Type a username" aria-label="Type a username"
								aria-describedby="basic-addon2">
						</div>
					</div>
					<div class="semi-row">
						<div>
							<p>Your current email address: abc@example.com</p>
							<div class="input-group mb-3">
								<input type="text" class="form-control"
									placeholder="xyz@example.com" aria-label="xyz@example.com"
									aria-describedby="basic-addon2">
							</div>
						</div>
					</div>
					<div class="semi-row">
						<div>
							<p>Your current phone number: (+91)9800012345</p>
							<div class="input-group mb-3">
								<div class="input-group-prepend">
									<select class="" id="cnt-code">
										<option>+91</option>
										<option>+81</option>
										<option>+92</option>
										<option>+82</option>
										<option>+1</option>
									</select>
								</div>
								<input type="number" class="form-control"
									placeholder="9800012345" aria-label="9800012345"
									aria-describedby="basic-addon2">
							</div>
						</div>
					</div>
					<div class="semi-row">
						<input type="button" value="Save" id="gen-set-save-btn"
							class="btn btn-outline-primary">
					</div>
				</div>
				<div class="details row" data-param="set-3">
					<div class="semi-row">
						<h5>Change Passowrd</h5>
						<div class="form-group">
							<label for="curr-pass">Current password</label> <input
								type="password" class="form-control" id="curr-pass"
								placeholder="Current Password">
						</div>
						<div class="form-group">
							<label for="new-pass">New password</label> <input type="password"
								class="form-control" id="new-pass" placeholder="New Password">
						</div>
						<div class="form-group">
							<label for="re-new-pass">Re-confirm password</label> <input
								type="password" class="form-control" id="re-new-pass"
								placeholder="Re-enter new Password">
						</div>
					</div>
					<div class="semi-row">
						<label>Set or update security questions</label> <input
							type="button" value="Start" id="sec-ques-start-btn"
							class="btn btn-outline-primary">
					</div>
					<div class="semi-row">
						<label>Review saved devices</label><input type="button"
							value="Review" id="rev-devc-btn" class="btn btn-outline-primary">
					</div>
					<div class="semi-row">
						<label>Check last 10 login activity</label><input type="button"
							value="Check" id="chk-login-act-btn"
							class="btn btn-outline-primary">
					</div>

					<div class="semi-row">
						<label>2-setp Verification</label><input type="button" value="Set"
							id="set-2-stp-ver-btn" class="btn btn-outline-primary">
					</div>
				</div>
				<div class="details" data-param="set-4">Privacy settings</div>
				<div class="details" data-param="set-5">Chats settings</div>
				<div class="details" data-param="set-6">Notification settings</div>

			</div>
		</div>
	</div>
</body>
</html>
