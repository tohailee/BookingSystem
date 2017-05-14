<%--
  Created by IntelliJ IDEA.
  User: hailee
  Date: 2017/1/6
  Time: 00:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>--%>
<%--<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>--%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html>
<head>
    <title>添加用户</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <%--<link rel="stylesheet"   href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">--%>
    <link rel="shortcut icon" href="<c:out value="${pageContext.request.contextPath}"/>/resource/user_add.png"
          type="image/x-icon"/>

    <script type="text/javascript" src="http://code.jquery.com/jquery-1.7.2.min.js"></script>
    <script type="text/javascript">
        function addUser() {
            var form = document.forms[0];
            <%--form.action = "<%=basePath%>user/newUser";--%>
            <%--form.method = "post";--%>
            form.submit();
        }
    </script>
</head>

<body>
<h1>添加用户</h1>
<h6><c:out value="${error}"/></h6>
<form id="newUser" name="userForm" action="<%=basePath%>user/newUser"
      enctype="application/x-www-form-urlencoded" method="post">
    姓名：<input type="text" name="username" title="姓名" width="">
    密码：<input type="password" name="password" title="密码">
    创建时间：<input type="text" name="createTime" title="创建时间">
    角色：<input type="text" name="role.roleName" title="角色">
    描述：<input type="text" name="description" title="描述">
    <%--<input type="button" value="添加" title="添加" onclick="addUser()">--%>
    <input type="submit" value="添加" title="添加"/>
</form>
</body>
</html>
