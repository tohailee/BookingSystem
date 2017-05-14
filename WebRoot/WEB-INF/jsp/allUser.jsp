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
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <%--<link rel="stylesheet"   href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">--%>
    <link rel="shortcut icon" href="<c:out value="${pageContext.request.contextPath}"/>/resource/user.png"
          type="image/x-icon"/>
    <title>用户列表</title>

    <script type="text/javascript" src="http://code.jquery.com/jquery-1.7.2.min.js"></script>

    <script type="text/javascript">
        function deleteUser(id) {
            $.get("<%=basePath%>user/deleteUser/" + id, function (data) {
                if ("success" == data.result) {
                    alert("删除成功");
                    window.location.reload();
                } else {
                    alert("删除失败");
                }
            });
        }
    </script>
</head>

<body>
<h6><a href="<%=basePath%>user/addUser">添加用户</a></h6>
<table border="1" width="100%">
    <tbody>
    <tr>
        <th>姓名</th>
        <th>角色</th>
        <th>联系方式</th>
        <th>创建时间</th>
        <th>最后登录时间</th>
        <th>描述</th>
        <th>操作</th>
    </tr>
    <%--<jsp:useBean id="userList" scope="request" type="com.resource.entity.User.User"/>--%>
    <%--@elvariable id="userList" type="com.resource.entity.User.User"--%>
    <c:if test="${!empty userList }">
        <c:forEach items="${userList}" var="user">
            <tr>
                <td><c:out value="${user.username }"/></td>
                <td><c:out value="${user.role.roleName }"/></td>
                <td><c:out value="${user.contact }"/></td>
                <td><c:out value="${user.createTime }"/></td>
                <td><c:out value="${user.lastLoginTime }"/></td>
                <td><c:out value="${user.description }"/></td>
                <td>
                    <a href="<%=basePath%>user/editUser/<c:out value="${user.id}"/>" title="修改用户">修改用户</a>
                        <%--<a href="<%=basePath%>user/updateUser?id=${user.id}">修改用户</a>--%>
                    <a href="javascript:void(0);" onclick="deleteUser('<c:out value="${user.id }"/>')" title="删除用户">删除用户</a>
                </td>
            </tr>
        </c:forEach>
    </c:if>
    </tbody>
</table>
</body>
</html>
