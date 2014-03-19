<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page session="false"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>欢迎使用教务管理系统</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">    
<link rel="shortcut icon" href="${ctx}/style/favicon.ico" type="image/icon" />
<link type="text/css" rel="stylesheet" href="${ctx}/style/global.css" />
<link type="text/css" rel="stylesheet" href="${ctx}/style/common.css" />
<link type="text/css" rel="stylesheet" href="${ctx}/style/curriculum.css" />
</head>
<body>
<form action="${ctx}/console/login" method="post">
用户名：<input type="text" name="username" />(admin)<br/>
密码：<input type="password" name="password" />(123456)<br/>
<input type="submit" value="登录" />
    ${nan}
</form>
</body>
</html>
