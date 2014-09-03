package com.xilou.open.web.controller.console;

import org.apache.log4j.Logger;

public abstract class BaseController {

	protected final String BASE_PATH = "console/admin";

	protected final String ERROR_PAGE = "/common/error";

	protected final Logger log = Logger.getLogger(this.getClass());

}
