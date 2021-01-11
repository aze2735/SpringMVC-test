<%--
  Created by IntelliJ IDEA.
  User: jacky
  Date: 2021/1/4
  Time: 12:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

     <div align="center">
         <h5><label>用户登录</label></h5>
         <form  method="post">
            <table border="1">

                <tr>
                    <td>用户名</td>
                <td><input id = "username" type="text"  name="username"></td>
                </tr>
                <tr>
                    <td>密码</td>
                    <td><input id = "password" type="password" name="password"></td>
                </tr>

                <tr>
                    <td></td>
                    <td>
                        <input type="button" value="登录" onclick="doLogin()">
                        <input type="button" value="注册" onclick="doRegister()">
                    </td>
                </tr>
            </table>
         </form>
         ${result}
     </div>

<script type="text/javascript">
    function  doLogin() {  //登录验证
        alert("ok");
        var username = document.getElementById("username").value;
        var password = document.getElementById("password").value;
        window.open("<%=request.getContextPath()%>/account/validate?"+"username="+username+"&password="+password,"_self")
    }
    
    function doRegister() {  //注册账号
        window.open("<%=request.getContextPath()%>/account/registerPage","_self");
    }
</script>
</body>
</html>
