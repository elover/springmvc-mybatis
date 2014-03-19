package com.thinkjoy.open.web.interceptor;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * 学生登录拦截器
 * 
 * @author thinkjoy
 * 
 */
public class LoginInterceptor extends HandlerInterceptorAdapter {

	private static final Logger log = Logger.getLogger(LoginInterceptor.class);

	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		String uri = request.getRequestURI();
		log.info("拦截：" + uri);
		if (request.getSession().getAttribute("student") == null) {
			log.info(sdf.format(new Date()) + "未登录！将跳转至登录页");
			response.sendRedirect(request.getContextPath() + "/");
		}
		return true;

	}

}
