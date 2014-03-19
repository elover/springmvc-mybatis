<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="cn">
<head>
    <meta charset="UTF-8">
    <title>Document</title>
</head>
<body>
rwqyryt
<c:forEach items="${scList}" var="sc">
    ${sc.course}
    <br/>
    ${sc.studentId}
    <br/>
    ${sc.scId}
    <br>
    ${sc.student.studentId}
</c:forEach>
<br>
</body>
</html>