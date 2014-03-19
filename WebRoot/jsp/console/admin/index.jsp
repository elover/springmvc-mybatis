<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="stripes" uri="http://stripes.sourceforge.net/stripes.tld"%>
<stripes:layout-render name="/jsp/layout/manager.jsp">
   <stripes:layout-component name="title">欢迎使用教务管理系统</stripes:layout-component>
   <stripes:layout-component name="content"><br/>${sessionScope.admin.username} ${admin}您好，欢迎使用教务管理系统!<br/></stripes:layout-component>
</stripes:layout-render>