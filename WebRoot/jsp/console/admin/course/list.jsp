<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="stripes" uri="http://stripes.sourceforge.net/stripes.tld"%>
<stripes:layout-render name="/jsp/layout/manager.jsp">
   <stripes:layout-component name="script">
   <script type="text/javascript" src="${ctx}/script/jquery-1.6.2.min.js"></script>
   <script language="javascript">
   function ajaxDelete(courseId, deleteCourseId) {
      var courseList = $("#courseList");
        var cfg = {
           type: 'POST',
           url: '${ctx}/console/course/'+ courseId +'/ajaxDelete',
           dataType: 'html',
           contentType:'text/html ;charset=UTF-8',
           success: function(msg) {
               if (msg == "success") {
                  $("#" + deleteCourseId).remove();
               } else if(msg == "null") {
                  alert("删除失败: 不存在课程号为 " + courseId + " 的课程！");  
               } else {
                  alert("删除失败");
               }
           }
         };
      $.ajax(cfg);
   }
   </script></stripes:layout-component>
   <stripes:layout-component name="title">课程列表</stripes:layout-component>
   <stripes:layout-component name="legend">课程列表</stripes:layout-component>
   <stripes:layout-component name="content">
      <table class="tableList" id="courseList">
         <tr>
            <th>课程编号</th>
            <th>课程名称</th>
            <th>主课教师</th>
            <th>操作</th>
         </tr>
         <c:forEach items="${courseList}" var="course" varStatus="status">
            <tr id="${status.index}">
               <td>${course.courseId}</td>
               <td>${course.name}</td>
               <td>${course.teacher}</td>
               <td><a href="${ctx}/console/course/${course.courseId}/edit">编辑</a> <a
                  href="${ctx}/console/course/${course.courseId}/delete">删除</a> <a
                  href="javascript:void();" onclick="ajaxDelete('${course.courseId}','${status.index}');" id="deleteLink">不刷新Ajax删除</a></td>
         </c:forEach>
      </table>
   </stripes:layout-component>
</stripes:layout-render>