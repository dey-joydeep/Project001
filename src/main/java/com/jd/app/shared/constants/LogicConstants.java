package com.jd.app.shared.constants;

public class LogicConstants {

	public static final String APPLICATION_JSON = "application/json";

	/** Servlet Redirection */
	public static final String SERV_INIT = "/init";
	public static final String SERV_LOGIN = "/login";
	public static final String SERV_CHAT = "/chat";
	public static final String SERV_ERROR = "/err";

	/** Page Redirection */
	public static final String PAGE_LOGIN = "/WEB-INF/jsp/login.jsp";
	public static final String PAGE_CLIENT = "/WEB-INF/jsp/client.jsp";
	public static final String PAGE_ERROR = "/WEB-INF/jsp/error.jsp";

	/** General Response Status */
	public static final String RESP_ERROR = "-1";
	public static final String RESP_SUCCESS = "0";

	/** Date Formats */
	public static final String YYYYMMDD = "yyyy/MM/dd";
	public static final String YYYYMMDD_HH24MMSS = "yyyy/MM/dd HH:mm:ss";

	/** Others */
	public static final String LF = "\n";
	public static final String CRLF = "\r\n";
	public static final String EMPTY_STRING = "";
	public static final String UTF_8 = "utf-8";
	public static final char URL_PATH_SEPERATOR = '/';

	/** Session Attributes */
	public static final String SESSION_ATTR_LOGIN_ID = "loginId";
}
