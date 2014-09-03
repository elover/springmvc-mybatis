package com.xilou.open.mapper;

import com.xilou.open.domain.Course;
import com.xilou.open.domain.Sc;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScMapper {
	
	List<Course> selectCourseByStudentId(String studentId);

	List<Sc> selectAll();

}
