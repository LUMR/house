<%--
  Created by IntelliJ IDEA.
  User: lumr
  Date: 2017/4/18
  Time: 下午11:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--获取types选项--%>
<c:forEach var="type" items="${types}">
    <option value="${type.id}" >${type.name}</option>
</c:forEach>
