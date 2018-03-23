package com.jd.app.beans.postlogin;

import com.jd.app.beans.common.SharedBean;

public class UserDetailsBean extends SharedBean {

	private String firstname;
	private String lastname;
	private String publicUsername;
	private String avatar;

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
	 * @return the publicUsername
	 */
	public final String getPublicUsername() {
		return publicUsername;
	}

	/**
	 * @param publicUsername
	 *            the publicUsername to set
	 */
	public final void setPublicUsername(String publicUsername) {
		this.publicUsername = publicUsername;
	}

	/**
	 * @return the avatar
	 */
	public final String getAvatar() {
		return avatar;
	}

	/**
	 * @param avatar
	 *            the avatar to set
	 */
	public final void setAvatar(String avatar) {
		this.avatar = avatar;
	}

}
