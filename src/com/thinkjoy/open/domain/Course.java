package com.thinkjoy.open.domain;

public class Course {

	private String courseId;

	private String name;

	private String teacher;

	private Course[] courses;

	public String getCourseId() {
		return courseId;
	}

	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTeacher() {
		return teacher;
	}

	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}

	public Course[] getCourses() {
		return courses;
	}

	public void setCourses(Course[] courses) {
		this.courses = courses;
	}

	public String toString() {
		return "{courseId = " + courseId + ", name = " + name + "}";
	}

}
