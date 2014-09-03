package com.xilou.open.web.controller;

import com.xilou.open.domain.Student;
import com.xilou.open.service.CourseService;
import com.xilou.open.service.StudentService;
import com.xilou.open.util.IOUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Controller("studentController")
public class StudentController {
    private Logger log = Logger.getLogger(getClass());

	@Autowired
	private StudentService studentService;

	@Autowired
	private CourseService courseService;

	@RequestMapping("/student/index")
	public String index() {
		return "/index";
	}

	@RequestMapping("/courses")
	public String courses(Model model) {
		model.addAttribute("courseList", courseService.findAll());
		return "/student/courseList";
	}

	@RequestMapping("/student/{studentId}/courses")
	public String myCourses(@PathVariable String studentId, Model model) {
		model.addAttribute("courseList", studentService.findByStudent(studentId));
		return "/student/myCourses";
	}

	@RequestMapping("/student/{studentId}")
	public String view(@PathVariable String studentId, Model model) {
		model.addAttribute("student", studentService.view(studentId));
		return "/student/view";
	}

	@RequestMapping(value = "/student/takeCourse/{courseId}")
	public String takeCourse(@PathVariable String courseId, Model model, HttpServletRequest request) {
		Student stu = (Student) request.getSession().getAttribute("student");
		String studentId = stu.getStudentId();
		if (courseService.checkCourse(studentId, courseId)) {
			model.addAttribute("errorMsg", "您已选过此门课了");
			return "/common/error";
		}
		courseService.takeCourse(studentId, courseId);
		model.addAttribute("msg", "选课成功");
		return "/student/takeCourseResult";
	}

	@RequestMapping(value = "/student/untakeCourse/{courseId}")
	public String untakeCourse(@PathVariable String courseId, Model model, HttpServletRequest request) {
		Student stu = (Student) request.getSession().getAttribute("student");
		String studentId = stu.getStudentId();
		if (courseService.checkCourse(studentId, courseId)) {
			courseService.untakeCourse(studentId, courseId);
			model.addAttribute("msg", "退选成功");
			return "/student/takeCourseResult";
		}
		model.addAttribute("errorMsg", "您未选过此门课");
		return "/common/error";
	}

	@RequestMapping("/student/{studentId}/photo")
	public String viewPhoto(@PathVariable String studentId, Model model) {
		return "/student/uploadPhoto";
	}

	@RequestMapping("/student/{studentId}/photo/save")
	public String updateload(@PathVariable String studentId, @RequestParam("file") MultipartFile file, Model model,
			HttpServletRequest request) {
		if (!file.isEmpty()) {
			try {
				byte[] bytes = file.getBytes();
				String fileName = file.getOriginalFilename();
				String filePath = request.getSession().getServletContext().getRealPath("/photo/");


				Student stu = (Student) request.getSession().getAttribute("student");

				if (fileName != null && fileName.indexOf(".") != -1) {
					String suffix = fileName.substring(fileName.lastIndexOf("."), fileName.length());
					String newFileName = stu.getStudentId() + suffix;
					IOUtil.getFile(bytes, filePath, newFileName);
					stu.setPhoto(newFileName);
					studentService.updatePhoto(stu);
				} else {
					model.addAttribute("errorMsg", "您未选择上传文件");
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			return "/student/uploadPhoto";
		} else {
			model.addAttribute("errorMsg", "您未选择文件");
			return "/student/uploadPhoto";
		}
	}
}
