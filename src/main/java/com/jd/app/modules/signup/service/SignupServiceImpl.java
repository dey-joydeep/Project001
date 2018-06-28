package com.jd.app.modules.signup.service;

import java.text.ParseException;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.jd.app.db.dao.impl.LoginDaoImpl;
import com.jd.app.db.dao.impl.UserDaoImpl;
import com.jd.app.db.entity.primitive.LoginEntity;
import com.jd.app.db.entity.primitive.UserEntity;
import com.jd.app.modules.signup.bean.SignupBean;
import com.jd.app.shared.crypto.CryptoUtils;
import com.jd.app.shared.crypto.CryptoUtils.CannotPerformOperationException;
import com.jd.app.shared.helper.SharedLogic;
import com.jd.app.shared.validators.SimpleValidator;

@Service
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, readOnly = false)
public class SignupServiceImpl implements SignupService {

	@Autowired
	LoginDaoImpl loginDaoImpl;

	@Autowired
	UserDaoImpl userDaoImpl;

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

	@Transactional
	public long execSignup(SignupBean signupBean) {
		LoginEntity loginEntity = new LoginEntity();
		loginEntity.setEmail(signupBean.getEmail());

		String password = null;
		try {
			password = CryptoUtils.createHash(signupBean.getPassword());
		} catch (CannotPerformOperationException e) {
			e.printStackTrace();
		}
		loginEntity.setPassword(password);
		loginEntity.setActive(true);

		UserEntity userEntity = new UserEntity();
		userEntity.setLogin(loginEntity);
		Random rndm = new Random();
		userEntity.setUsername(signupBean.getFirstname()
				+ signupBean.getLastname() + rndm.nextLong());

		userEntity.setFirstname(signupBean.getFirstname());
		userEntity.setLastname(signupBean.getLastname());
		userEntity.setSex((short) 1);
		try {
			userEntity.setBirthdate(SharedLogic.StringToDate(signupBean
					.getBirthdate()));
		} catch (ParseException e) {
			e.printStackTrace();
		}

		// loginEntity.setUser(userEntity);
		userDaoImpl.insertUserWithCredentials(userEntity);

		return loginEntity.getLoginId();
	}

	@Override
	public void validateForgetPassword() {
		// TODO Auto-generated method stub

	}
}
