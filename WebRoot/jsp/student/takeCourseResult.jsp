<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="stripes" uri="http://stripes.sourceforge.net/stripes.tld"%>
<stripes:layout-render name="/jsp/layout/main.jsp">
   <stripes:layout-component name="title">选课</stripes:layout-component>
   <stripes:layout-component name="script">
      <script type="text/javascript" src="${ctx}/script/jquery-1.6.2.min.js"></script>
   </stripes:layout-component>
   <stripes:layout-component name="legend">提示</stripes:layout-component>
   <stripes:layout-component name="content">
      ${msg}
   </stripes:layout-component>
</stripes:layout-render>