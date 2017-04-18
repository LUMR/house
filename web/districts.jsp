<%--
  Created by IntelliJ IDEA.
  User: lumr
  Date: 2017/4/18
  Time: 下午11:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--获取districts选项--%>
<c:forEach var="district" items="${districts}">
    <option value="${district.id}" >${district.name}</option>
</c:forEach>
