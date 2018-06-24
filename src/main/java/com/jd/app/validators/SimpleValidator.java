package com.jd.app.validators;


public class SimpleValidator {

	public static final boolean isBlankString(String str) {
		return str == null || str.isEmpty();
	}

	public static final boolean isValidName(String name) {
		String regex = "^[A-Za-z ]+$";
		return name.matches(regex);
	}

	public static final boolean isValidEmail(String email) {
		String regex = "^(?:[a-z0-9!#$%&'*+/=?^_`\\{|\\}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`\\{|\\}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])$";
		return email.matches(regex);
	}

	public static final boolean isValidMoblieNo(String mobile) {
		String regex = "^(\\+\\d{1,3})?\\d{9,11}$";
		return mobile.matches(regex);
	}

	public static final boolean isValidPassword(String password,
			String confirmPassword) {
		return password.equals(confirmPassword);
	}
}
