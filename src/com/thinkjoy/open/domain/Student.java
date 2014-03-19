package com.thinkjoy.open.domain;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class Student {

	@NotEmpty(message = "学号不能为空")
	private String studentId;

	@NotEmpty(message = "密码不能为空")
	private String password;

	@NotEmpty(message = "姓名不能为空")
	private String name;

	private String major;

	@NotNull(message = "年龄不能为空且最小10岁")
	@Min(10)
	private Integer age;

	private String remark;
	
	private String photo;

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String toString() {
		return "studentId" + studentId;
	}

}
