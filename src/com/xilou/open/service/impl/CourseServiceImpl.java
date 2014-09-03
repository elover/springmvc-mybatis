package com.xilou.open.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xilou.open.domain.Course;
import com.xilou.open.domain.Sc;
import com.xilou.open.mapper.CourseMapper;
import com.xilou.open.mapper.ScMapper;
import com.xilou.open.service.CourseService;

@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
	private CourseMapper courseMapper;

    @Autowired
	private ScMapper scMapper;

	public List<Course> findAll() {

		return courseMapper.selectAll();
	}

	public Course view(String courseId) {
		return courseMapper.selectById(courseId);
	}

	@Transactional
	public void save(Course course) {
		courseMapper.insert(course);
	}

	@Transactional
	public void delete(String courseId) {
		courseMapper.delete(courseId);
	}

	@Transactional
	public void update(Course course) {
		courseMapper.update(course);
	}

	@Transactional
	public boolean takeCourse(String studentId, String courseId) {
		Sc sc = new Sc();
		sc.setScId(String.valueOf(System.currentTimeMillis()));
		sc.setStudentId(studentId);
		sc.setCourseId(courseId);
		int count = courseMapper.takeCourse(sc);
		boolean flag = count > 0 ? true : false;
		return flag;
	}

	/**
	 * true: 选过了 false: 没选过
	 */
	public boolean checkCourse(String studentId, String courseId) {
		boolean flag;
		Sc sc = new Sc();
		sc.setScId(String.valueOf(System.currentTimeMillis()));
		sc.setStudentId(studentId);
		sc.setCourseId(courseId);
		if (courseMapper.selectByStudentIdAndCourseId(sc) == null
				|| courseMapper.selectByStudentIdAndCourseId(sc).size() == 0) {
			flag = false;
		} else {
			flag = true;
		}
		return flag;
	}

	public boolean untakeCourse(String studentId, String courseId) {
		Sc sc = new Sc();
		sc.setScId(String.valueOf(System.currentTimeMillis()));
		sc.setStudentId(studentId);
		sc.setCourseId(courseId);
		int count = courseMapper.untakeCourse(sc);
		boolean flag = count > 0 ? true : false;
		return flag;
	}

	public List<Sc> findScList() {
		return scMapper.selectAll();
	}

}
