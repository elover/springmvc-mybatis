package com.xilou.open.web.controller.console;

import com.xilou.open.domain.Student;
import com.xilou.open.service.StudentService;
import com.xilou.open.web.validator.StudentValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller("console/studentController")
@RequestMapping("/console/student/*")
public class StudentController extends BaseController {

	private final String PATH = BASE_PATH + "/student";

	@Autowired
	private StudentService studentService;

	@InitBinder
	protected void initBinder(WebDataBinder binder) {
//		do.something();
		binder.setValidator(new StudentValidator());
		System.out.println("应用到所有@RequestMapping注解方法，在其执行之前初始化数据绑定器");
	}

	@RequestMapping(value = "list")
	public String list(Model model) {
		model.addAttribute("studentList", studentService.list());
		return PATH + "/list";
	}
    @RequestMapping(value = "{id}")
    public String view(@PathVariable String id, Model model){
        model.addAttribute("student",studentService.view(id));
        return PATH +"/view";
    }

	@RequestMapping(value = "input")
	public String input() {
		return PATH + "/input";
	}

	@RequestMapping(value = "save", method = RequestMethod.POST)
	public String save(@Valid Student student, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("errorList", result.getFieldErrors());
			model.addAttribute("errorMsg", "输入有误");
			return BASE_PATH + "/addError";
		}
		if (studentService.view(student.getStudentId()) != null) {
			model.addAttribute("errorMsg", "已存在学号：" + student.getStudentId());
			return BASE_PATH + "/addError";
		}
		studentService.save(student);
		return BASE_PATH + "/addSuccess";
	}

	@RequestMapping(value = "{id}/edit")
	public String edit(@PathVariable String id, Model model) {
		model.addAttribute("student", studentService.view(id));
		return PATH + "/edit";
	}

	@RequestMapping(value = "{id}/update", method = RequestMethod.POST)
	public String update(Student student) {
		studentService.update(student);
		return BASE_PATH + "/updateSuccess";
	}

	@RequestMapping(value = "{id}/delete")
	public String delete(@PathVariable String id) {
		studentService.delete(id);
		return "redirect:../list";
	}

	@RequestMapping(value = "{id}/check", method = RequestMethod.POST)
	@ResponseBody
	public String check(@PathVariable String id) {
		log.info("要检查的学号ID是：" + id);
		if (studentService.view(id) == null) {
			return "success";
		} else {
			return "false";
		}
	}

	@RequestMapping(value = "{id}/json", method = RequestMethod.POST)
	@ResponseBody
	public Student json(@PathVariable String id) {
		Student stu = studentService.view(id);
		return stu;
	}

	@RequestMapping(value = "jsonList", method = RequestMethod.POST)
	@ResponseBody
	public List<Student> jsonList() {
		List<Student> list = studentService.list();
		return list;
	}

}
