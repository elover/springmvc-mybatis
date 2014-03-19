package com.thinkjoy.open.mapper;

import com.thinkjoy.open.domain.Course;
import com.thinkjoy.open.domain.Sc;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseMapper {

	List<Course> selectAll();

	Course selectById(String courseId);

	int insert(Course course);

	int delete(String courseId);

	int update(Course course);

	int takeCourse(Sc sc);

	List<Sc> selectByStudentIdAndCourseId(Sc sc);

	int untakeCourse(Sc sc);

}
