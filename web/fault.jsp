<%--
  Created by IntelliJ IDEA.
  User: fsweb
  Date: 17-4-17
  Time: 下午4:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>请求失败</title>
</head>
<body>
<h1>请求无效</h1>
<s:fielderror></s:fielderror>
<s:actionerror></s:actionerror>
<s:debug></s:debug>
<a href="index.action">返回主页</a>
</body>
</html>
