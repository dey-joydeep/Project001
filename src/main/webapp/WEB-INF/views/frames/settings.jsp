<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" href="resources/css/settings/settings-frame.css">
<jsp:include page="../common_js_with_popper.jsp" />
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
								<input type="email" class="form-control"
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
								<input type="tel" class="form-control" placeholder="9800012345"
									aria-label="9800012345" aria-describedby="basic-addon2">
							</div>
						</div>
					</div>
					<div class="semi-row btn-row">
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
				<div class="details" data-param="set-4">
					<div class="semi-row">
						<label>Block an user from bothering you or check and
							handle already blocked user.</label> <input type="button"
							value="Block/Check" id="blk-chk-btn"
							class="btn btn-outline-primary">
					</div>
					<div class="semi-row">
						<label>Set your "online" visibility status to one or more
							users.</label> <input type="button" value="Set" id="on-off-vis-stat-btn"
							class="btn btn-outline-primary">
					</div>
					<div class="semi-row">
						<label>Set your "last seen" visibility status to one or
							more users.</label> <input type="button" value="Set"
							id="last-vis-stat-btn" class="btn btn-outline-primary">
					</div>
					<div class="semi-row">
						<label>Control your "profile picture" visibility to one or
							more users.</label> <input type="button" value="Set" id="dp-vis-ctrl-btn"
							class="btn btn-outline-primary">
					</div>
					<div class="semi-row">
						<label>Control "Message Receipt" visibility to one or more
							users.</label> <input type="button" value="Set" id="msg-rcpt-ctrl-btn"
							class="btn btn-outline-primary">
					</div>
				</div>
				<div class="details" data-param="set-5">
					<div class="semi-row">
						<label>Delete all chats</label> <input type="button"
							value="Delete" id="dlt-all-chat-btn"
							class="btn btn-outline-danger">
					</div>
					<div class="semi-row">
						<label>Archive all chats</label> <input type="button"
							value="Archive" id="arc-all-chat-btn"
							class="btn btn-outline-secondary">
					</div>
					<div class="semi-row">
						<label>Download all chats</label> <input type="button"
							value="Download" id="dnld-all-chat-btn"
							class="btn btn-outline-success">
					</div>
				</div>
				<div class="details" data-param="set-6">
					<div class="semi-row">
						<p>All Notifications</p>
						<div class="form-check form-check-inline">
							<label class="form-check-label">Mute</label><input type="radio"
								value="0" name="all-rad" class="form-check-input">
						</div>
						<div class="form-check form-check-inline">
							<label class="form-check-label">Unmute</label><input type="radio"
								value="1" name="all-rad" class="form-check-input">
						</div>
					</div>
				</div>

			</div>
		</div>
	</div>
</body>
</html>