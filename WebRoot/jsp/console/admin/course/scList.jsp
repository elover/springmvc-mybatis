<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="stripes" uri="http://stripes.sourceforge.net/stripes.tld"%>
<stripes:layout-render name="/jsp/layout/manager.jsp">
   <stripes:layout-component name="title">课程列表</stripes:layout-component>
   <stripes:layout-component name="legend">课程列表</stripes:layout-component>
   <stripes:layout-component name="content">
      <table class="tableList">
         <tr>
            <th>课程编号</th>
            <th>课程名称</th>
            <th>学生学号</th>
            <th>学生姓名</th>
         </tr>
         <c:forEach items="${scList}" var="sc">
            <tr>
               <td>${sc.courseId}</td>
               <td>${sc.course.name}</td>
               <td>${sc.studentId}</td>
               <td>${sc.student.name}</td>
         </c:forEach>
      </table>
   </stripes:layout-component>
</stripes:layout-render>