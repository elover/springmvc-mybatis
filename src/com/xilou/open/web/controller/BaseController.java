package com.xilou.open.web.controller;

import org.apache.log4j.Logger;

public abstract class BaseController {

	protected final Logger log = Logger.getLogger(this.getClass());

	protected final String LOGIN_PAGE = "/";

	protected final String ERROR_PAGE = "/common/error";

}
