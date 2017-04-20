<%--
  Created by IntelliJ IDEA.
  User: fsweb
  Date: 17-4-20
  Time: 下午3:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>上传文件</title>
</head>
<body>
<s:form enctype="multipart/form-data" action="upload">
    <s:file name="upload"></s:file>
    <s:submit></s:submit>
</s:form>
</body>
</html>
