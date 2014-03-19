<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>欢迎使用选课系统</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">    
<link rel="shortcut icon" href="${ctx}/style/favicon.ico" type="image/icon" />
<link type="text/css" rel="stylesheet" href="${ctx}/style/global.css" />
<link type="text/css" rel="stylesheet" href="${ctx}/style/common.css" />
<link type="text/css" rel="stylesheet" href="${ctx}/style/curriculum.css" />
</head>
<body>
<form action="${ctx}/login" method="post">
学号：<input type="text" name="studentId" /><br/>
密码：<input type="password" name="password" /><br/>
<input type="submit" value="登录" />
<a href="${ctx}/console">管理员入口</a>
</form>
</body>
</html>
