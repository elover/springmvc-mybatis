<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="stripes" uri="http://stripes.sourceforge.net/stripes.tld"%>
<stripes:layout-render name="/jsp/layout/main.jsp">
   <stripes:layout-component name="title">查看学生信息</stripes:layout-component>
   <stripes:layout-component name="legend">查看学生信息</stripes:layout-component>
   <stripes:layout-component name="content">
         <table class="tableForm">
            <tr>
               <th>学号：</th>
               <td>${student.studentId}</td>
            </tr>
            <tr>
               <th>姓名：</th>
               <td>${student.name}</td>
            </tr>
            <tr>
               <th>专业：</th>
               <td>${student.major}</td>
            </tr>
            <tr>
               <th>年龄：</th>
               <td>${student.age}</td>
            </tr>
            <tr>
               <th>备注：</th>
               <td>${student.remark}</td>
            </tr>
         </table>
   </stripes:layout-component>
</stripes:layout-render>