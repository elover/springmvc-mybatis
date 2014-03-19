package com.thinkjoy.open.domain;

public class Sc {

	private String scId;

	private String studentId;

	private String courseId;

	private Integer score;

	private Student student;

	private Course course;

	public String getScId() {
		return scId;
	}

	public void setScId(String scId) {
		this.scId = scId;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getCourseId() {
		return courseId;
	}

	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public String toString() {
		return studentId + "; " + courseId;
	}

}
