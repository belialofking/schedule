<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="renderer" content="webkit">
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    <title>系统登录</title>
    <link rel="stylesheet" href="${base}/static/css/login.css" />

</head>
<body>
<div class="login center">
    <div class="message">登录</div>
    <div id="darkbannerwrap"></div>
    <form method="post" action="${base}/loginDo">
        <dd><input name="username" type="text" placeholder="用户名"></dd>
        <dd><input name="password" type="password" placeholder="密码"></dd>
        <input type="submit" value="登录">
    </form>
</div>
<ul class="bg-bubbles">
    <li></li>
    <li></li>
    <li></li>
    <li></li>
    <li></li>
    <li></li>
    <li></li>
    <li></li>
    <li></li>
    <li></li>
</ul>
</body>
</html>
