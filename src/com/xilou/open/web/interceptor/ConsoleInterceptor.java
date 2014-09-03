package com.xilou.open.web.interceptor;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 管理控制台拦截器
 * 
 * @author xilou
 * 
 */
public class ConsoleInterceptor extends HandlerInterceptorAdapter {

	private final static Logger log = Logger.getLogger(ConsoleInterceptor.class);

	private List<String> excludeURIs;

	public void setExcludeURIs(List<String> excludeURIs) {
		this.excludeURIs = excludeURIs;
	}

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		String uri = request.getRequestURI();
		log.info("拦截：" + uri);
        System.out.println("123"+excludeURIs);
		for (String exclude : excludeURIs) {
			if (uri.endsWith(exclude)) {
				log.info("放行" + uri);
				return true;
			}
		}
		if (request.getSession().getAttribute("admin") == null) {
			log.info("未登录，请先登录管理员！");
			response.sendRedirect(request.getContextPath() + "/console");
		}
		return true;
	}

}
