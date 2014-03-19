package com.thinkjoy.open.service;

import com.thinkjoy.open.domain.Course;
import com.thinkjoy.open.domain.Sc;

import java.util.List;

public interface CourseService {

	List<Course> findAll();

	Course view(String courseId);

	void save(Course course);

	void delete(String courseId);

	void update(Course course);

	boolean checkCourse(String studentId, String courseId);

	/**
	 * 选课
	 * 
	 * @param studentId
	 * @param courseId
	 * @return
	 */
	boolean takeCourse(String studentId, String courseId);

	/**
	 * 退选
	 * 
	 * @param studentId
	 * @param courseId
	 * @return
	 */
	boolean untakeCourse(String studentId, String courseId);
	
	List<Sc> findScList();

}
