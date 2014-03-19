drop database if exists curriculum;

create database curriculum default character set 'UTF8';

set names 'UTF8';

use curriculum;

-- 学生表
create table student
(
studentId varchar(20) NOT NULL primary key,
password varchar(50),
name varchar(20) NOT NULL,
major varchar(50) NULL,
age INTEGER NULL,
photo varchar(100) NULL,
remark varchar(100)
)ENGINE = InnoDB;

-- 课程表
create table course
(
courseId varchar(20) NOT NULL primary key,
name varchar(20) NOT NULL,
teacher varchar(20) NULL,
remark varchar(100)
)ENGINE = InnoDB;

-- 选课表
create table sc
(
scId varchar(20) NOT NULL primary key,
studentId varchar(20) NOT NULL,
courseId varchar(20) NOT NULL,
score integer
)ENGINE = InnoDB;