<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="stripes" uri="http://stripes.sourceforge.net/stripes.tld"%>
<stripes:layout-render name="/jsp/layout/main.jsp">
   <stripes:layout-component name="title">课程列表</stripes:layout-component>
   <stripes:layout-component name="legend">课程列表</stripes:layout-component>
   <stripes:layout-component name="content">
      <table class="tableList">
         <tr>
            <th>课程编号</th>
            <th>课程名称</th>
            <th>主课教师</th>
            <th>操作</th>
         </tr>
         <c:forEach items="${courseList}" var="course">
            <tr>
               <td>${course.courseId}</td>
               <td>${course.name}</td>
               <td>${course.teacher}</td>
               <td><a href="${ctx}/student/takeCourse/${course.courseId}/">选课</a></td>
            </tr>
         </c:forEach>
      </table>
   </stripes:layout-component>
</stripes:layout-render>