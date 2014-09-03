package com.xilou.open.web.controller.console;

import com.xilou.open.domain.Admin;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller("console/loginController")
public class LoginController extends BaseController {

	@RequestMapping(value = "/console")
	public String console(HttpServletRequest request) {
        request.setAttribute("nan","wei1111");
		return "/console/index";
	}

	@RequestMapping(value = "/console/login", method = RequestMethod.POST)
	public String login(Admin admin, HttpServletRequest request) {
		if ("admin".equals(admin.getUsername()) && "123456".equals(admin.getPassword())) {
			request.getSession().setAttribute("admin", admin);
			return "redirect:/console/index";
		} else {
			request.setAttribute("errorMsg", "用户名或密码不正确，请输入（admin / 123456）");
			return ERROR_PAGE;
		}
	}

	@RequestMapping(value = "/console/index")
	public String index() {
		return "/console/admin/index";
	}

	@RequestMapping(value = "/console/logout")
	public String logout(HttpServletRequest request) {
		request.getSession().removeAttribute("admin");
		return "redirect:/console";
	}

}
