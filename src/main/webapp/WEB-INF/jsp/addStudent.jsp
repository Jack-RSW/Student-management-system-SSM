<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="java.util.*" isELIgnored="false"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <title>addStudent</title>
</head>
<body>

<c:if test="${allErrors!=null}">
    <c:forEach items="${allErrors}" var="error">
        ${error.defaultMessage}
    </c:forEach>
</c:if>

<div style="align-content: center; margin-top: 40px">
    <form method="post" action="${pageContext.request.contextPath}/students/editStudentsSubmit">
        学员名称：<input name="s_name" value="" type="text"><br>
        QQ：<input name="s_qq" value="" type="text"><br>
        修真类型：<input name="s_course" value="" type="text"><br>
        入学时间：<input name="update_at" value="" type="text"><br>
        毕业院校：<input name="s_school" value="" type="text"><br>
        日报链接：<input name="s_link" value="" type="text"><br>
        flag：<input name="s_flag" value="" type="text"><br>
        辅导师兄：<input name="s_brother" value="" type="text"><br>
        了解来源：<input name="s_source" value="" type="text"><br>
        创建时间：<input name="create_at" value="" type="text"><br>

        <input type="submit" value="增加学员">
    </form>
</div>

</body>
</html>
