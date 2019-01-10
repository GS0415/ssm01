<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/1/10
  Time: 8:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>

<html>
<head>
    <title>注册</title>
</head>
<body>
<form action="doregister.do">
    用户名：<input type="text" id="username" name="username"><br>
    密码：<input type="password" name="password" id="password"><br>
    确认密码：<input type="password" name="passwords"><br>
    <input type="submit" value="注册">
</form>
<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
    $(function () {
        alert(1)
    })
</script>
</body>
</html>
