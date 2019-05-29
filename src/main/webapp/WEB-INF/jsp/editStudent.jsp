<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="java.util.*" isELIgnored="false"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="/tags" prefix="date"%>

<html>
<head>
    <title>editStudent</title>
</head>

<body>

<div style="text-align:left;color: red;font-size: 25px">
    <c:if test="${allErrors!=null}">
        <c:forEach items="${allErrors}" var="error">
            ${error.defaultMessage} <br>
        </c:forEach>
    </c:if>
</div>

<div style="width: 500px;margin: 0px auto;text-align: center">
    <div style="text-align: left;margin-top:40px">
        <%--注意：form 下增加 filed, 虽然这个form的method是post, 但是springmvc看到这个_method的值是put后，会把其修改为put.--%>
        <form method="post" action="${pageContext.request.contextPath}/students/${s.s_id}">
            <input type="hidden" name="_method" value="PUT">
            学号：<input name="s_id" value="${s.s_id}" type="text"><br><br>
            学员名称：<input name="s_name" value="${s.s_name}" type="text" required pattern="^[\u4E00-\u9FA5A-Za-z0-9_]+$">
            <span style="text-align: left;color: gray;font-size: 10px">*名称至少一位,中文，数字或字母</span><br><br>
            QQ：<input name="s_qq" value="${s.s_qq}" type="text" required pattern="^[0-9]*$" >
            <span style="text-align: left;color: gray;font-size: 10px;white-space: nowrap">*请输入数字，并且大于10010</span><br><br>
            修真类型：<input name="s_course" value="${s.s_course}" type="text" required pattern="^[1-2]">
            <span style="text-align: left;color: gray;font-size: 10px">*请输入数字1 or 2，1.Java；2.python</span><br><br>
            <%--入学时间：<input name="update_at" value="${s.update_at}" type="text">--%>
            入学时间：<input name="update_at" value="<date:date value="${s.update_at}"></date:date>" type="text"required pattern="^\d{4}-\d{1,2}-\d{1,2}$">
            <span style="text-align: left;color: gray;font-size: 10px">*请输入正确格式xxxx-xx-xx</span><br><br>
            <%--<br><br>--%>
            <%--<jsp:useBean id="dateValue" class="java.util.Date"/>--%>
            <%--<jsp:setProperty name="dateValue" property="time" value="${s.update_at}"/>--%>
            <%--入学时间：<input name="update_at" value=<fmt:formatDate value="${dateValue}" pattern="yyyy-MM-dd hh:mm:ss"/> type="text">--%>

            毕业院校：<input name="s_school" value="${s.s_school}" type="text"><br><br>
            日报链接：<input name="s_link" value="${s.s_link}" type="text"><br><br>
            flag：<input name="s_flag" value="${s.s_flag}" type="text"><br><br>
            辅导师兄：<input name="s_brother" value="${s.s_brother}" type="text" required pattern="^[1-2]">
            <span style="text-align: left;color: gray;font-size: 10px">*请输入数字1 or 2，1.张三；2.李四</span><br><br>
            了解来源：<input name="s_source" value="${s.s_source}" type="text"><br><br>

            <%--创建时间：<input name="create_at" value="${s.create_at}" type="text">--%>
            创建时间：<input name="create_at" value="<date:date value="${s.create_at}"></date:date>" type="text" required pattern="^\d{4}-\d{1,2}-\d{1,2}$">
            <span style="text-align: left;color: gray;font-size: 10px">*请输入正确格式xxxx-xx-xx</span><br>
            <%--<br><br>--%>
            <%--<jsp:useBean id="dateValue1" class="java.util.Date"/>--%>
            <%--<jsp:setProperty name="dateValue1" property="time" value="${s.create_at}"/>--%>
            <%--创建时间：<input name="create_at" value=<fmt:formatDate value="${dateValue1}" pattern="yyyy-MM-dd hh:mm:ss"/> type="text">--%>
            <br><br>
            <input type="submit" value="修改学员">
        </form>
    </div>
</div>

</body>
</html>
