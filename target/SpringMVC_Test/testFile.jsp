<%--
  Created by IntelliJ IDEA.
  User: jacky
  Date: 2021/1/5
  Time: 14:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
  <div>
      <form action="<%=request.getContextPath()%>/file/upload"  enctype="multipart/form-data" method="post">
          <input type="file" name="imgPath">
          <input type="submit" value="上传">
      </form>
  </div>
</body>
</html>
