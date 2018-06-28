package com.jd.app.shared.helper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.jd.app.shared.constants.LogicConstants;

public class SharedLogic {

	/**
	 * Check for user authentication
	 *
	 * @param session
	 * @return
	 */
	public static final boolean isAuthenticated(HttpSession session) {
		return (session != null && session
				.getAttribute(LogicConstants.SESSION_ATTR_LOGIN_ID) != null);
	}

	/**
	 * Check, if a string is empty or not. A string is empty, if it is either
	 * null or its length is 0. If <code>Strict Mode</code> is enabled, string
	 * will be checked by trimming from both sides.
	 *
	 * @param str
	 *            String to be checked
	 * @param isStrict
	 *            Whether to check strictly (by trimming from both side) or
	 *            general check
	 * @return true, if the string is empty, false otherwise
	 */
	public static final boolean isEmptyString(String str, boolean isStrict) {
		return str == null ? true : (isStrict ? str.trim().isEmpty() : str
				.isEmpty());
	}

	public static final String dateTimeToString(Date date) {
		return new SimpleDateFormat(LogicConstants.YYYYMMDD_HH24MMSS)
				.format(date);
	}

	public static final String dateToString(Date date) {
		return new SimpleDateFormat(LogicConstants.YYYYMMDD).format(date);
	}

	public static final Date StringToDateTime(String date)
			throws ParseException {
		return new SimpleDateFormat(LogicConstants.YYYYMMDD_HH24MMSS)
				.parse(date);
	}

	public static final Date StringToDate(String date) throws ParseException {
		return new SimpleDateFormat(LogicConstants.YYYYMMDD).parse(date);
	}

	public static final Date addDaysToCurrentDate(int daysToAdd) {
		GregorianCalendar calendar = new GregorianCalendar();
		calendar.add(Calendar.DATE, daysToAdd);
		return calendar.getTime();
	}

	public static final Date addDaysToDate(Date date, int daysToAdd) {
		GregorianCalendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		calendar.add(Calendar.DATE, daysToAdd);
		return calendar.getTime();
	}

	/**
	 * Get time in milliseconds
	 *
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static final long getDateDifference(Date date1, Date date2) {
		return date1.getTime() - date2.getTime();
	}

	public static String getClientIpAddress(HttpServletRequest req) {
		String ip = req.getHeader("X-Forwarded-For");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = req.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = req.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = req.getHeader("HTTP_CLIENT_IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = req.getHeader("HTTP_X_FORWARDED_FOR");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = req.getRemoteAddr();
		}
		return ip;
	}
}
