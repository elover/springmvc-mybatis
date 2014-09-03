package com.xilou.open.web.controller;

import com.xilou.open.domain.Student;
import com.xilou.open.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginController extends BaseController {

	@Autowired
	private StudentService studentService;

    @RequestMapping(value={"/login","/"},method = RequestMethod.GET)
    public String login(HttpEntity<String> httpEntity){

//        HttpHeaders responseHeaders = new HttpHeaders();
//        responseHeaders.setContentType(MediaType.APPLICATION_JSON);
//        log.info("content-type:" + MediaType.APPLICATION_JSON);
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(HttpServletRequest request, Student student, Model model) {
		Student stu = studentService.login(student);
		if (stu != null) {
			request.getSession().setAttribute("student", stu);
			return "redirect:/student/index";
		} else {
			log.error("学号：[" + student.getStudentId() + "]登录失败！");
			model.addAttribute("errorTitle", "登录失败");
			model.addAttribute("errorMsg", "学号或密码错误，请重新登录！");
			return ERROR_PAGE;
		}
	}

	@RequestMapping("/logout")
	public String logout(HttpServletRequest request) {
		request.getSession().removeAttribute("student");
		return "redirect:/";
	}

}
