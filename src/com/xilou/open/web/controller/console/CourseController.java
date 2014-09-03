package com.xilou.open.web.controller.console;

import com.xilou.open.domain.Course;
import com.xilou.open.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
@RequestMapping("/console/*")
public class CourseController extends BaseController {

	private final String PATH = BASE_PATH + "/course";

	@Autowired
	private CourseService courseService;

	@RequestMapping(value = "course/input")
	public String input() {
		return PATH + "/input";
	}

	@RequestMapping(value = "course/save", method = RequestMethod.POST)
	public String save(Course course) {
		courseService.save(course);
		return BASE_PATH + "/addSuccess";
	}

	@RequestMapping(value = "course/{id}/edit")
	public String edit(@PathVariable String id, Model model) {
		model.addAttribute("course", courseService.view(id));
		return PATH + "/edit";
	}

	@RequestMapping(value = "course/{id}/update")
	public String update(Course course) {
		courseService.update(course);
		return BASE_PATH + "/updateSuccess";
	}

	@RequestMapping(value = "course/{id}/delete")
	public String delete(@PathVariable String id) {
		courseService.delete(id);
		return BASE_PATH + "/deleteSuccess";
	}

	@RequestMapping(value = "course/{id}/ajaxDelete")
	@ResponseBody
	public String ajaxDelete(@PathVariable String id) {
		try {
			System.out.println("delete: " + id);
			if (courseService.view(id) == null) {
				return "null";
			} else {
				courseService.delete(id);
				return "success";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}

	@RequestMapping(value = "course/list")
	public String list(Model model) {
		model.addAttribute("courseList", courseService.findAll());
		return PATH + "/list";
	}

	@RequestMapping(value = "sc/list")
	public String scList(Model model) {
		model.addAttribute("scList", courseService.findScList());
		return PATH + "/scList";
	}

	@RequestMapping(value = "course/batchInput")
	public String batchInput() {
		return PATH + "/batchInput";
	}

	@RequestMapping(value = "course/batchSave", method = RequestMethod.POST)
	public String batchSave(ArrayList<Course> courses) {
		int count = courses == null ? 0 : courses.size();
		for (int i = 0; i < count; i++) {
			System.out.println("print: " + courses.get(i));
		}
		return BASE_PATH + "/addSuccess";
	}

	@RequestMapping(value = "course/jsonSave", method = RequestMethod.POST, headers = { "content-type=application/json" })
	@ResponseBody
	public String jsonSave(@RequestBody Course course) {

//        try {
//            writer.write("{name='nan'}");
//            writer.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        System.out.println(course.getName());
		if (courseService.view(course.getCourseId()) != null) {
			return "false";
		} else {
			courseService.save(course);
			return "true";
		}
	}

}
