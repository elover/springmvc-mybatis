<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="stripes" uri="http://stripes.sourceforge.net/stripes.tld"%>
<stripes:layout-render name="/jsp/layout/manager.jsp">
   <stripes:layout-component name="title">修改学生信息</stripes:layout-component>
   <stripes:layout-component name="legend">修改学生同学</stripes:layout-component>
   <stripes:layout-component name="content">
      <form action="${ctx}/console/student/${student.studentId}/update" method="post">
         <table class="tableForm">
            <tr>
               <th>学号：</th>
               <td><input type="text" name="studentId" value="${student.studentId}" readonly="readonly" /></td>
            </tr>
            <tr>
               <th>姓名：</th>
               <td><input type="text" name="name" value="${student.name}" /></td>
            </tr>
            <tr>
               <th>密码：</th>
               <td><input type="text" name="password" value="${student.password}" /></td>
            </tr>
            <tr>
               <th>专业：</th>
               <td><input type="text" name="major" value="${student.major}" /></td>
            </tr>
            <tr>
               <th>年龄：</th>
               <td><input type="text" name="age" value="${student.age}" /></td>
            </tr>
            <tr>
               <th>备注：</th>
               <td><input type="text" name="remark" value="${student.remark}" /></td>
            </tr>
            <tr>
               <th></th>
               <td><input type="submit" name="update" value="提交" class="btn" />&nbsp;<input type="reset" name="reset"
                  value="重填" class="btn" /></td>
            </tr>
         </table>
      </form>
   </stripes:layout-component>
</stripes:layout-render>