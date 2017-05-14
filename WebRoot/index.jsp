<%--
  Created by IntelliJ IDEA.
  User: hailee
  Date: 2017/1/6
  Time: 00:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE html>
<html>
<head>
    <title>首页</title>
    <link rel="shortcut icon" href="<c:out value="${pageContext.request.contextPath}"/>/resource/house.png"
          type="image/x-icon"/>
</head>

<body>
<a href="<%=basePath%>user/getUsers">进入用户管理页</a>
</body>
</html>