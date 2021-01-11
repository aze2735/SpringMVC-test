<%--
  Created by IntelliJ IDEA.
  User: jacky
  Date: 2021/1/5
  Time: 20:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <div align="center">
        <h5><label>用户新增</label></h5>
        <form action="<%=request.getContextPath()%>/manage/doAdd"  method="post">
            <table border="1">
                <tr>
                    <td>姓名</td><td><input type="text" name="username"></td>
                </tr>
                <tr>
                    <td>年龄</td><td><input type="text" name="age"></td>
                </tr>
                <tr>
                    <td>性别</td>
                    <td>
                        <select name="sex">
                            <option value="男">男</option>
                            <option value="女">女</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td><input type="submit" value="保存"></td>
                    <td><input type="reset" value="取消" onclick="window.history.go(-1);"></td>
                </tr>
            </table>
        </form>
    </div>
</body>
</html>
