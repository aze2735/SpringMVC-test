<%--
  Created by IntelliJ IDEA.
  User: jacky
  Date: 2021/1/4
  Time: 10:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%--      用户名称：${User.username}/密码：${User.password}/年龄：${User.age}--%>

<div align="center">
    <label><b>用户列表</b></label>

    <table border="1">
        <tr>
            <td>编号</td>
            <td>姓名</td>
            <td>年龄</td>
            <td>性别</td>
            <td>操作</td>
        </tr>
        <c:forEach var="user" items="${userList}">
            <tr>
                <td>${user.userId}</td>
                <td>${user.username}</td>
                <td>${user.age}</td>
                <td>${user.sex}</td>
                <td>
                    <a href="<%=request.getContextPath()%>/manage/delete/${user.userId}">删除</a>/
                    <a href="<%=request.getContextPath()%>/manage/update/${user.userId}">修改</a>
                </td>
            </tr>
        </c:forEach>
    </table>
    <div>
        <button id="add" name="add" onclick="addUser()">新增</button>
    </div>
</div>
<!--新增按钮点击-->
<script type="text/javascript">
    function addUser() {
        window.open("<%=request.getContextPath()%>/manage/addPage","_self");//触发Controller
    }
</script>
</body>
</html>
