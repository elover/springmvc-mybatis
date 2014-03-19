<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="stripes" uri="http://stripes.sourceforge.net/stripes.tld"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="shortcut icon" href="${ctx}/style/favicon.ico" type="image/icon" />
<title>${errorTitle==null?"错误提示":errorTitle}</title>
</head>
<body>
<stripes:errors/>
<br/>
${errorMsg} <a href="javascript:void();" onClick="javascript:history.back();">返回</a><br/>
</body>
</html>