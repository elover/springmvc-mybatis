package com.xilou.open.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xilou.open.domain.Course;
import com.xilou.open.domain.Student;
import com.xilou.open.mapper.StudentMapper;
import com.xilou.open.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentMapper studentMapper;

	public List<Student> list() {
		return studentMapper.selectAll();
	}

	public Student login(Student student) {
		return studentMapper.selectByIdAndPassword(student);
	}

	@Transactional
	public void save(Student student) {
		studentMapper.insert(student);
	}

	@Transactional
	public void delete(String studentId) {
		studentMapper.delete(studentId);
	}

	@Transactional
	public void update(Student student) {
		studentMapper.update(student);
	}

	@Transactional
	public Student view(String studentId) {
		return studentMapper.selectById(studentId);
	}

	public List<Course> findByStudent(String studentId) {
		return studentMapper.selectByStudent(studentId);
	}

	@Transactional
	public void updatePhoto(Student student) {
		studentMapper.updatePhoto(student);
	}

}
