package com.xilou.open.web.servlet;

import org.apache.log4j.Logger;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

/**
 * 对系统进行一些初始化配置
 * 
 * @author xilou
 * 
 */
public class ApplicationServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private Logger log = Logger.getLogger(getClass());

	ServletContext application;

	public void init(ServletConfig config) throws ServletException {
		application = config.getServletContext();
		application.setAttribute("ctx", application.getContextPath());
	}

	public void destroy() {
		log.info("开始停止应用");
		application.removeAttribute("ctx");
		super.destroy();
	}

}
