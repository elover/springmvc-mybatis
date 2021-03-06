package com.xilou.open.mapper;

import com.xilou.open.domain.Course;
import com.xilou.open.domain.Student;

import java.util.List;

public interface StudentMapper {

	List<Student> selectAll();

	Student selectById(String studentId);

	int insert(Student student);

	int delete(String studentId);

	int update(Student student);

	Student selectByIdAndPassword(Student student);

	List<Course> selectByStudent(String studentId);

	int updatePhoto(Student student);
}
