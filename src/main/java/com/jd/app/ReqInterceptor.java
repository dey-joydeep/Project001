package com.jd.app;

import java.util.Enumeration;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class ReqInterceptor extends HandlerInterceptorAdapter {

	private static Logger log = Logger
			.getLogger(ReqInterceptor.class.getName());

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {

		log.info("[preHandle][" + request + "]" + "[" + request.getMethod()
				+ "]" + request.getRequestURI() + getParameters(request));

		return true;
	}

	private String getParameters(HttpServletRequest request) {
		StringBuffer posted = new StringBuffer();
		Enumeration<?> e = request.getParameterNames();
		if (e != null) {
			posted.append("?");
		}
			while (e.hasMoreElements()) {
				if (posted.length() > 1) {
					posted.append("&");
				}
				String curr = (String) e.nextElement();
				posted.append(curr + "=");
			if (curr.contains("password") || curr.contains("pass")
					|| curr.contains("pwd")) {
					posted.append("*****");
				} else {
					posted.append(request.getParameter(curr));
				}
			}
		String ip = request.getHeader("X-FORWARDED-FOR");
		String ipAddr = (ip == null) ? getRemoteAddr(request) : ip;
		if (ipAddr != null && !ipAddr.equals("")) {
			posted.append("&_psip=" + ipAddr);
		}
		return posted.toString();
	}

	private String getRemoteAddr(HttpServletRequest request) {
		String ipFromHeader = request.getHeader("X-FORWARDED-FOR");
		if (ipFromHeader != null && ipFromHeader.length() > 0) {
			log.info("ip from proxy - X-FORWARDED-FOR : " + ipFromHeader);
			return ipFromHeader;
		}
		return request.getRemoteAddr();
	}

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {

		// Set standard HTTP/1.1 no-cache headers.
		response.setHeader("Cache-Control",
				"no-store, no-cache, must-revalidate");

		// Set IE extended HTTP/1.1 no-cache headers (use addHeader).
		response.addHeader("Cache-Control", "post-check=0, pre-check=0");

		// Set standard HTTP/1.0 no-cache header.
		response.setHeader("Pragma", "no-cache");
	}
}
