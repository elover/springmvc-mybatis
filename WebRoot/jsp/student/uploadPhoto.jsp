<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="stripes" uri="http://stripes.sourceforge.net/stripes.tld"%>
<stripes:layout-render name="/jsp/layout/main.jsp">
   <stripes:layout-component name="title">上传照片</stripes:layout-component>
   <stripes:layout-component name="legend">上传照片</stripes:layout-component>
   <stripes:layout-component name="content">
      <form action="${ctx}/student/${student.studentId}/photo/save" method="post" enctype="multipart/form-data">
         <table class="tableForm">
            <tr>
               <th></th>
               <td><c:if test="${student.photo!=null}"><img src="${ctx}/photo/${student.photo}" style="width: 200px;" /></c:if>${errorMsg}</td>
            </tr>
            <tr>
               <th>照片：</th>
               <td><input type="file" name="file" /></td>
            </tr>
            <tr>
               <th>&nbsp;</th>
               <td><input type="submit" value="上传"/></td>
            </tr>
         </table>
      </form>
   </stripes:layout-component>
</stripes:layout-render>