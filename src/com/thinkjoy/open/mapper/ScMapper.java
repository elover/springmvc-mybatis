package com.thinkjoy.open.mapper;

import com.thinkjoy.open.domain.Course;
import com.thinkjoy.open.domain.Sc;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScMapper {
	
	List<Course> selectCourseByStudentId(String studentId);

	List<Sc> selectAll();

}
