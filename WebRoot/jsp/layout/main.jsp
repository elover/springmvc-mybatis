<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="stripes" uri="http://stripes.sourceforge.net/stripes.tld"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<stripes:layout-definition>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><stripes:layout-component name="title">教务管理系统</stripes:layout-component></title>
<link rel="shortcut icon" href="${ctx}/style/favicon.ico" type="image/icon" />
<link type="text/css" rel="stylesheet" href="${ctx}/style/global.css" />
<link type="text/css" rel="stylesheet" href="${ctx}/style/common.css" />
<link type="text/css" rel="stylesheet" href="${ctx}/style/curriculum.css" />
<stripes:layout-component name="script"></stripes:layout-component>
</head>
<body>
   <table class="mainTable">
      <tr>
         <td style="width: 180px;vertical-align: top;">
            <ul class="ulList">
               <li><a href="${ctx}/student/${student.studentId}">个人信息</a></li>
               <li><a href="${ctx}/student/${student.studentId}/photo">个人照片</a></li>
               <li><a href="${ctx}/courses">我要选课</a></li>
               <li><a href="${ctx}/student/${student.studentId}/courses">我的课程</a></li>
               <li><a href="${ctx}/logout">退出登录</a></li>
            </ul>
         </td>
         <td>
            <fieldset class="fieldset">
               <legend>
                  <stripes:layout-component name="legend">选课管理</stripes:layout-component>
               </legend>
               <stripes:layout-component name="content"></stripes:layout-component>
            </fieldset>
         </td>
      </tr>
   </table>
</body>
</html>
</stripes:layout-definition>