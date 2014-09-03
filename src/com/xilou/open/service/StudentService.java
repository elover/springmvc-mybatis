package com.xilou.open.service;

import com.xilou.open.domain.Course;
import com.xilou.open.domain.Student;

import java.util.List;

public interface StudentService {

	List<Student> list();

	Student login(Student student);

	void save(Student student);

	void delete(String studentId);

	void update(Student student);

	Student view(String studentId);

	List<Course> findByStudent(String studentId);

	void updatePhoto(Student student);

}
