package com.thinkjoy.open.web.filter;

import org.apache.log4j.Logger;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 登录过滤器, 过期了, 用LoginInterceptor取代
 * 
 * @author thinkjoy
 * @deprecated
 * 
 */
public class LoginFilter implements Filter {

	private static final Logger log = Logger.getLogger(LoginFilter.class);

	public void destroy() {

	}

	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain filterChain) throws IOException,
			ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
		HttpSession session = request.getSession();
		String uri = request.getRequestURI();
		log.info("uri = " + uri);
		if (uri.endsWith(request.getContextPath() + "/") || uri.endsWith("/login")
				|| session.getAttribute("student") != null) {
			log.info("放行");
			filterChain.doFilter(req, resp);
		} else {
			log.info("请先登录！");
			response.sendRedirect(request.getContextPath() + "/");
		}

	}

	public void init(FilterConfig filterConfig) throws ServletException {

	}

}
