<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="stripes" uri="http://stripes.sourceforge.net/stripes.tld"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<stripes:layout-render name="/jsp/layout/manager.jsp">
   <stripes:layout-component name="title">欢迎使用教务管理系统</stripes:layout-component>
   <stripes:layout-component name="content">
      <br />添加失败：${errorMsg}<br />
      <ul class="ulList" style="border:0;">
      <c:forEach items="${errorList}" var="e" varStatus="status">
         <li>${status.count}. ${e.defaultMessage}</li>
      </c:forEach>
      </ul>
   </stripes:layout-component>
</stripes:layout-render>