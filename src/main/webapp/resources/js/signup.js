$(function() {

	if (isMobile()) {
		$('.page-op').not('.non-btn').replaceClass('col', 'col-3');
	}

	controlPage(1);
	setBirthYearAndMonth();
	$('#dob-yy').change(function() {
		if ($('#dob-mm').val().length > 0)
			setBirthDate();
	});

	$('#dob-mm').change(function() {
		if ($('#dob-yy').val().length > 0)
			setBirthDate();
	});

	$('#dob-dd').change(
			function() {
				var dob = '';
				if (this.value !== '')
					dob = $('#dob-yy').val() + "/" + $('#dob-mm').val() + "/"
							+ this.value;

				$('#birthdate').val(dob);
			});

	$('.login-switch').click(
			function() {
				$('.login-switch').closest('.field-div').toggle();
				$('#login-mode').val() === '1' ? $('#login-mode').val(2) : $(
						'#login-mode').val(1);
			});

	$('.pass-vis').click(function() {
		if ($('#password').attr('type') === 'password') {
			$(this).text('visibility_off');
			$('#password').attr('type', 'text');
		} else {
			$(this).text('visibility');
			$('#password').attr('type', 'password');
		}
	});

	$('#signup-form').submit(function(e) {
		e.preventDefault();

	});
	$('#bck-btn').click(function() {
		var pageVal = parseInt($('#page-val').val()) - 1;
		var devType = parseInt($('#dev-type').val());

		if (devType === 0)
			pageVal--;
		controlPage(pageVal);

	});
	$('#nxt-btn').click(function() {
		handleError();
	});

	$('input').keypress(function(e) {
		if (e.which == 13) {
			$('#nxt-btn').click();
		}
	});

	$('#signup-btn').click(
			function() {
				var jqXhr = $.ajax({
					url : 'signup',
					type : 'post',
					data : convertToJsonString($('#signup-form')
							.serializeArray()),
					contentType : "application/json; charset=utf-8"
				});

				jqXhr.done(function(data) {
					if (!data.success) {
						$('#msg-div').text(data.message);
						var errMap = data.errMap;
						$('#msg-div').show();
						$.each(errMap, function(k, v) {
							var elem = $('[name=' + k + ']');
							var span = $('<span class="error"></span');
							var label = elem.closest('.field-div').find(
									'.field-label');
							span.text(v);
							span.insertAfter(label);

							if (k === 'birthdate') {
								$.each($('.dob'), function(i) {
									var dobElem = $($('.dob')[i]);
									if (dobElem.val().length === 0)
										dobElem.addClass('is-invalid');
								});
							} else {
								elem.addClass('is-invalid');
							}
						});
					} else {
						window.location.href = '/chatapp';
					}
				});
			});
});

function controlPage(pageVal) {
	$('.page').hide();
	$('.page-op').hide();
	var devType = parseInt($('#dev-type').val());

	if (devType === 0) {
		if (pageVal === 1) {
			$('#page-1').showFlex();
			$('#page-2').showFlex();
		} else {
			$('#page-3').showFlex();
		}
	} else {
		$('#page-' + pageVal).showFlex();
	}
	$('.page-op-' + pageVal).show();
	$('#page-val').val(pageVal);
}

function renderConfirmationPage() {
	var rowDiv = $('#page-3');
	rowDiv.empty();

	var name = $('#first-name').val() + " " + $('#last-name').val();
	var dob = $('#dob-yy').val() + "/" + $('#dob-mm').val() + "/"
			+ $('#dob-dd').val();
	var sex = $('#sex option:selected').text();
	var email = $('#email').val();
	var phNo = $('#phone-no').val();
	var pass = "*****";

	var colonDiv = ('<div class="col-1">:</div>');
	var nlDiv = ('<div class="w-100"></div>');
	var labelDiv = ('<div class="col-4"></div>');
	var valueDiv = ('<div class="col"></div>');

	rowDiv.append($(labelDiv).text("Name")).append(colonDiv).append(
			$(valueDiv).text(name)).append(nlDiv);
	rowDiv.append($(labelDiv).text("Birthdate")).append(colonDiv).append(
			$(valueDiv).text(dob)).append(nlDiv);
	rowDiv.append($(labelDiv).text("Gender")).append(colonDiv).append(
			$(valueDiv).text(sex)).append(nlDiv);
	if ($('#login-mode').val() === '1')
		rowDiv.append($(labelDiv).text("Email")).append(colonDiv).append(
				$(valueDiv).text(email)).append(nlDiv);
	else
		rowDiv.append($(labelDiv).text("Mobile No")).append(colonDiv).append(
				$(valueDiv).text(phNo)).append(nlDiv);
	rowDiv.append($(labelDiv).text("Password")).append(colonDiv).append(
			$(valueDiv).text(pass)).append(nlDiv);
}

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

function setBirthYearAndMonth() {
	var currYr = new Date().getFullYear() - 13;
	var lastYr = currYr - 125;

	for (var i = currYr; i >= lastYr; i--) {
		$('#dob-yy').append('<option value="' + i + '">' + i + '</option');
	}
	for (var i = 1; i <= 12; i++) {
		var mm = i > 9 ? i : '0' + i;
		$('#dob-mm').append('<option value="' + mm + '">' + mm + '</option');
	}
}

function setBirthDate() {
	var ddRange = [ 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 ];
	var yy = parseInt($('#dob-yy').val());
	var mm = parseInt($('#dob-mm').val());
	var lastDt = ddRange[mm - 1];
	var isLeapYear = (yy % 400 === 0 || (yy % 4 === 0 && yy % 100 !== 0));

	$('#dob-dd').empty();
	$('#dob-dd').append('<option value="">DD</option');
	if (mm === 2 && isLeapYear)
		lastDt++;
	for (var i = 1; i <= lastDt; i++) {
		var dd = i > 9 ? i : '0' + i;
		$('#dob-dd').append('<option value="' + dd + '">' + dd + '</option');
	}
}

function handleError() {
	$('#msg-div').hide();
	$('.error').remove();
	$('.is-invalid').removeClass('is-invalid');
	var jqXhr = $.ajax({
		url : 'validateSignup',
		type : 'post',
		data : convertToJsonString($('#signup-form').serializeArray()),
		contentType : "application/json; charset=utf-8"
	});

	jqXhr.done(function(data) {
		if (!data.success) {
			$('#msg-div').text(data.message);
			var errMap = data.errMap;
			$('#msg-div').show();
			$.each(errMap, function(k, v) {
				var elem = $('[name=' + k + ']');
				var span = $('<span class="error"></span');
				var label = elem.closest('.field-div').find('.field-label');
				span.text(v);
				span.insertAfter(label);

				if (k === 'birthdate') {
					$.each($('.dob'), function(i) {
						var dobElem = $($('.dob')[i]);
						if (dobElem.val().length === 0)
							dobElem.addClass('is-invalid');
					});
				} else {
					elem.addClass('is-invalid');
				}
			});
		} else {
			transitPage();
		}
	});
}

function transitPage() {
	var pageVal = parseInt($('#page-val').val());
	if (pageVal !== 3) {
		pageVal++;
		var devType = parseInt($('#dev-type').val());

		if (devType === 0)
			pageVal++;
		if (pageVal == 3)
			renderConfirmationPage();
		controlPage(pageVal);
		return;
	}

	var jqXhr = $.ajax({
		url : 'signup',
		type : 'post',
		data : convertToJsonString($('#signup-form').serializeArray()),
		contentType : "application/json; charset=utf-8"
	});

	jqXhr.done(function(data) {
		jqXhr = $.ajax({
			url : 'login',
			type : 'post',
			data : {
				username : ($('#email').val().length > 0 ? $('#email').val()
						: $('#phone-no').val()),
				password : $('#password').val()
			},
			contentType : "application/json; charset=utf-8"
		});

		jqXhr.done(function(data) {
			window.location('/');
		});
	});
}