<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="stripes" uri="http://stripes.sourceforge.net/stripes.tld"%>
<stripes:layout-render name="/jsp/layout/manager.jsp">
   <stripes:layout-component name="title">修改课程</stripes:layout-component>
   <stripes:layout-component name="script">
      <script type="text/javascript" src="${ctx}/script/jquery-1.6.2.min.js"></script>
   </stripes:layout-component>
   <stripes:layout-component name="legend">修改课程</stripes:layout-component>
   <stripes:layout-component name="content">
      <form action="${ctx}/console/course/${course.courseId}/update" method="post">
         <table class="tableForm">
            <tr>
               <th>课程编号：</th>
               <td><input type="text" name="courseId" value="${course.courseId}" readonly="readonly" id="courseId" /></td>
            </tr>
            <tr>
               <th>课程名称：</th>
               <td><input type="text" name="name" value="${course.name}" /></td>
            </tr>
            <tr>
               <th>主讲教师：</th>
               <td><input type="text" name="teacher" value="${course.teacher}" /></td>
            </tr>
            <tr>
               <th></th>
               <td><input type="submit" name="submit" value="提交" class="btn" /> &nbsp;<input type="reset"
                  name="reset" value="重填" class="btn" /></td>
            </tr>
         </table>
      </form>
   </stripes:layout-component>
</stripes:layout-render>