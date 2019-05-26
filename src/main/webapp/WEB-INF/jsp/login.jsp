<%@ page  pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>系统登陆</title>
</head>
<body>
${test}
<form style="text-align: center" action="${pageContext.request.contextPath }/students/login" method="post">
    用户账号:<input type="text" name="username"/><br/>
    用户密码:<input type="password" name="password"/><br/>
    <input type="submit" value="登录"/>
</form>
</body>
</html>