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
        学员名称：<input name="s_name" value="" type="text" required pattern="^[\u4E00-\u9FA5A-Za-z0-9_]+$">
        <span style="text-align: left;color: gray;font-size: 10px">*名称至少一位,中文，数字或字母</span><br>
        QQ：<input name="s_qq" value="" type="text" required pattern="^[0-9]*$" >
        <span style="text-align: left;color: gray;font-size: 10px;white-space: nowrap">*请输入数字，并且大于10010</span><br>
        修真类型：<input name="s_course" value="" type="text" required pattern="^[1-2]">
        <span style="text-align: left;color: gray;font-size: 10px">*请输入数字1 or 2，1.Java；2.python</span><br>
        入学时间：<input name="update_at" value="" type="text" required pattern="^\d{4}-\d{1,2}-\d{1,2}$">
        <span style="text-align: left;color: gray;font-size: 10px">*请输入正确格式xxxx-xx-xx</span><br>
        毕业院校：<input name="s_school" value="" type="text"><br>
        日报链接：<input name="s_link" value="" type="text"><br>
        flag：<input name="s_flag" value="" type="text"><br>
        辅导师兄：<input name="s_brother" value="" type="text" required pattern="^[1-2]">
        <span style="text-align: left;color: gray;font-size: 10px">*请输入数字1 or 2，1.张三；2.李四</span><br>
        了解来源：<input name="s_source" value="" type="text"><br>
        创建时间：<input name="create_at" value="" type="text" required pattern="^\d{4}-\d{1,2}-\d{1,2}$">
        <span style="text-align: left;color: gray;font-size: 10px">*请输入正确格式xxxx-xx-xx</span><br>

        <input type="submit" value="增加学员">
    </form>
</div>

</body>
</html>
