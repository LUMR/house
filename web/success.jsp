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
    <title>登录成功</title>
</head>
<body>
<h1>Hello! ${user.name}</h1>
<s:actionmessage/>
<s:debug/>
<h2>${actionMessages[0]}</h2>
</body>
</html>
