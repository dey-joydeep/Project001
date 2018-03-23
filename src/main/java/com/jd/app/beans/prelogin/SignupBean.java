package com.jd.app.beans.prelogin;

import com.jd.app.beans.common.SharedBean;

public class SignupBean extends SharedBean {

	private String email;
	private String password;
	private String firstname;
	private String lastname;
	private String birthdate;
	private String sex;

	/**
	 * @return the email
	 */
	public final String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public final void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the password
	 */
	public final String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public final void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the firstname
	 */
	public final String getFirstname() {
		return firstname;
	}

	/**
	 * @param firstname
	 *            the firstname to set
	 */
	public final void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	/**
	 * @return the lastname
	 */
	public final String getLastname() {
		return lastname;
	}

	/**
	 * @param lastname
	 *            the lastname to set
	 */
	public final void setLastname(String lastname) {
		this.lastname = lastname;
	}

	/**
	 * @return the birthdate
	 */
	public final String getBirthdate() {
		return birthdate;
	}

	/**
	 * @param birthdate
	 *            the birthdate to set
	 */
	public final void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}

	/**
	 * @return the sex
	 */
	public final String getSex() {
		return sex;
	}

	/**
	 * @param sex
	 *            the sex to set
	 */
	public final void setSex(String sex) {
		this.sex = sex;
	}
}
