package com.jd.app.service.impl;

import java.util.Map;
import java.util.TreeMap;

import org.springframework.stereotype.Service;

import com.jd.app.beans.prelogin.LoginBean;
import com.jd.app.beans.prelogin.SignupBean;
import com.jd.app.service.def.PreLoginService;
import com.jd.app.validators.SimpleValidator;

@Service
public class PreLoginServiceImpl implements PreLoginService {

	@Override
	public void authorize(LoginBean loginBean) {
		String message = "Access authorized!";
		if (loginBean.getLoginId().isEmpty()
				|| loginBean.getPassword().isEmpty())
			message = "Username/Password is required.";
		else if ("user1".equals(loginBean.getLoginId())
				&& "user1".equals(loginBean.getPassword()))
			loginBean.setSuccess(true);
		else
			message = "Username/Password is incorrect.";
		loginBean.setUsername(loginBean.getLoginId());
		loginBean.setPassword(null);
		loginBean.setMessage(message);
	}

	@Override
	public void validateSignup(SignupBean signupBean) {

		short pageVal = signupBean.getPageVal();
		short deviceType = signupBean.getDeviceType();

		Map<String, String> errMap = new TreeMap<>();

		if (deviceType == (short) 0) {
			errMap.putAll(validatePage1(signupBean));
			errMap.putAll(validatePage2(signupBean));
		} else {
			if (pageVal == (short) 1) {
				errMap.putAll(validatePage1(signupBean));
			} else if (pageVal == (short) 2) {
				errMap.putAll(validatePage2(signupBean));
			} else {
				errMap.putAll(validatePage1(signupBean));
				errMap.putAll(validatePage2(signupBean));
			}
		}
		signupBean.setErrMap(errMap);
		if (!errMap.isEmpty())
			signupBean
					.setMessage("You have some error in the sign up form. Please correct them and re-submit.");
	}

	private Map<String, String> validatePage1(SignupBean signupBean) {
		final String ERR_MSG_REQ = "required";
		final String ERR_MSG_INV = "invalid";

		String fn = signupBean.getFirstname();
		String ln = signupBean.getLastname();
		String dob = signupBean.getBirthdate();
		String sex = signupBean.getSex();

		Map<String, String> errMap = new TreeMap<>();

		if (SimpleValidator.isBlankString(fn))
			errMap.put("firstname", ERR_MSG_REQ);
		else if (!SimpleValidator.isValidName(fn))
			errMap.put("firstname", ERR_MSG_INV);

		if (SimpleValidator.isBlankString(ln))
			errMap.put("lastname", ERR_MSG_REQ);
		else if (!SimpleValidator.isValidName(ln))
			errMap.put("lastname", ERR_MSG_INV);

		if (SimpleValidator.isBlankString(dob))
			errMap.put("birthdate", ERR_MSG_REQ);

		if (SimpleValidator.isBlankString(sex))
			errMap.put("sex", ERR_MSG_REQ);

		return errMap;
	}

	private Map<String, String> validatePage2(SignupBean signupBean) {
		final String ERR_MSG_REQ = "required";
		final String ERR_MSG_INV = "invalid";

		String em = signupBean.getEmail();
		String mob = signupBean.getPhoneNo();
		String mp = signupBean.getPassword();

		Map<String, String> errMap = new TreeMap<>();

		if (signupBean.getLoginMode() == (short) 1) {
			if (SimpleValidator.isBlankString(em))
				errMap.put("email", ERR_MSG_REQ);

			if (!SimpleValidator.isBlankString(em)
					&& !SimpleValidator.isValidEmail(em))
				errMap.put("email", ERR_MSG_INV);
		} else {
			if (SimpleValidator.isBlankString(mob))
				errMap.put("phoneNo", ERR_MSG_REQ);

			if (!SimpleValidator.isBlankString(mob)
					&& !SimpleValidator.isValidMoblieNo(mob))
				errMap.put("phoneNo", ERR_MSG_INV);
		}

		if (SimpleValidator.isBlankString(mp))
			errMap.put("password", ERR_MSG_REQ);

		return errMap;
	}

	@Override
	public void execSignup(SignupBean signupBean) {
		// TODO DB Insert logic

	}

	@Override
	public void validateForgetPassword() {
		// TODO Auto-generated method stub

	}

	@Override
	public void execForgetPassword() {
		// TODO Auto-generated method stub

	}
}
