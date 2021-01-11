<%--
  Created by IntelliJ IDEA.
  User: jacky
  Date: 2021/1/6
  Time: 9:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
     <div align="center">
         <h5><label>用户修改</label></h5>
         <form action="<%=request.getContextPath()%>/manage/doUpdate" method="post">
             <table border="1">
                 <tr>
                     <td>用户编号</td><td><input type="text" name="userId" value="${User.userId}" readonly></td>
                 </tr>
                 <tr>
                     <td>用户名</td><td><input type="text" name="username" value="${User.username}"></td>
                 </tr>
                 <tr>
                     <td>性别</td><td><input type="text" name="sex" value="${User.sex}"></td>
                 </tr>
                 <tr>
                     <td>年龄</td><td><input type="text" name="age" value="${User.age}"></td>
                 </tr>
                 <tr>
                     <td></td>
                     <td>
                         <input type="submit" value="保存">
                         <input type="button" value="取消" onclick="window.history.go(-1);">
                     </td>
                 </tr>
             </table>
         </form>
     </div>
</body>
</html>
