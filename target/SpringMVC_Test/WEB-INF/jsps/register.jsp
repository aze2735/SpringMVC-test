<%--
  Created by IntelliJ IDEA.
  User: jacky
  Date: 2021/1/6
  Time: 15:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>账号注册</title>
</head>
<body>
   <div align="center">
       <h5><label>用户注册</label></h5>
       <form action="<%=request.getContextPath()%>/account/register" method="post">
           <table>
               <tr>
                   <td>账号名称</td><td><input type="text" name="account"></td>
               </tr>
               <tr>
                   <td>密码</td><td><input type="password" name="password"></td>
               </tr>
               <tr>
                   <td><input type="submit" value="保存"></td>
                   <td><input type="reset" value="取消"></td>
               </tr>
           </table>
       </form>
   </div>
</body>
</html>
