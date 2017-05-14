<%--@elvariable id="user" type="com.resource.entity.User.User"--%>
<%--
  Created by IntelliJ IDEA.
  User: hailee
  Date: 2017/1/6
  Time: 00:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html>
<head>
    <title>编辑用户</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <%--<link rel="stylesheet"   href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">--%>
    <link rel="shortcut icon" href="<c:out value="${pageContext.request.contextPath}"/>/resource/user_edit.png"
          type="image/x-icon"/>

    <script type="text/javascript"
            src="<c:out value="${pageContext.request.contextPath}"/>/js/http://code.jquery.com/jquery-1.7.2.min.js"></script>
    <%--<script type="text/javascript">--%>
    <%--function updateUser() {--%>
    <%--var form = document.forms[0];--%>
    <%--&lt;%&ndash;form.action = "<%=basePath%>user/updateUser";&ndash;%&gt;--%>
    <%--//            form.method = "post";--%>
    <%--form.submit();--%>
    <%--}--%>
    <%--</script>--%>
</head>

<body>
<h1>修改用户</h1>
<form id="editUser" name="editUser" method="post" action="<%=basePath%>user/updateUser/${user.id}">
    <input type="hidden" name="id" value="<c:out value="${user.id}"/>"/>
    <table id="" width="100%" border="1">
        <tr>
            <td width="30%">
                姓名：<input type="text" name="username" value="<c:out value="${user.username}"/>" title="姓名"/>
            </td>
            <td width="30%">
                角色：
                <label title="角色">
                    <select name="roleId" title="roleId">
                        <c:forEach items="${roles}" var="role">
                            <option name="roleName" value="<c:out value="${role.key}"/>" title="角色"><c:out
                                    value="${role.value}"/></option>
                        </c:forEach>
                    </select>
                </label>
            </td>
            <td width="30%">
                描述：<input type="text" name="description" value="<c:out value="${user.description}"/>" title="描述"/>
            </td>
            <td width="10%">
                <input type="submit" value="提交" title="提交"/>
                <%--<input type="button" value="提交" title="提交" onclick="document.forms[0].submit()"/>--%>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
