<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="java.util.*" isELIgnored="false"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="/tags" prefix="date"%>

<html>
<head>
    <title>students</title>
</head>
<body>

<script type="text/javascript" src="/js/jquery.min.js"></script>

<script type="text/javascript">
    /*将post method 改变为delete*/
    $(function(){
    $(".delete").click(function () {
        var href =$(this).attr("href");
        $("#formdelete").attr("action",href).submit();
        return false;
    })
    })

</script>

<%-- 登陆模块 --%>
当前用户:${username }|
<c:if test="${username!=null }">
    <a href="${pageContext.request.contextPath }/students/logout">退出</a>
    <hr>
</c:if>

<div style="margin:0px auto;text-align:center ">
    <table align="center" border="1" cellpadding="0" width="100%">
        <tr>
            <td>线上学号</td>
            <td>姓名</td>
            <td>QQ</td>
            <td>修真类型</td>
            <td>入学时间</td>
            <td>毕业院校</td>
            <td>日报链接</td>
            <td>flag</td>
            <td>辅导师兄</td>
            <td>了解来源</td>
            <td>创建时间</td>
            <td>编辑</td>
            <td>删除</td>
        </tr>
        <c:forEach items="${stus}" var="s" varStatus="st">
            <tr>
                <td>${s.s_id}</td>
                <td>${s.s_name}</td>
                <td>${s.s_qq}</td>
                <td>${s.s_course}</td>
                <td><date:date value="${s.update_at}"></date:date></td>
                <%--<td>${s.update_at}</td>--%>
                <%--<td>--%>
                    <%--<jsp:useBean id="dateValue" class="java.util.Date"/>--%>
                    <%--<jsp:setProperty name="dateValue" property="time" value="${s.update_at}"/>--%>
                    <%--<fmt:formatDate value="${dateValue}" pattern="yyyy-MM-dd hh:mm:ss"/>--%>
                <%--</td>--%>
                <td>${s.s_school}</td>
                <td>${s.s_link}</td>
                <td>${s.s_flag}</td>
                <td>${s.s_brother}</td>
                <td>${s.s_source}</td>
                <%--第一种方式将long类型的时间转换为格式化时间--%>
                <td><date:date value="${s.create_at}"></date:date></td>
                <%--<td>${s.create_at}</td>--%>
                <%--<td>--%>
                <%--第二种方式将long类型的时间转换为格式化时间--%>
                    <%--<jsp:useBean id="dateValue1" class="java.util.Date"/>--%>
                    <%--<jsp:setProperty name="dateValue1" property="time" value="${s.create_at}"/>--%>
                    <%--<fmt:formatDate value="${dateValue1}" pattern="yyyy-MM-dd hh:mm:ss"/>--%>
                <%--</td>--%>
                <td><a href="students/${s.s_id}">编辑</a></td>
                <td><a class="delete" href="students/${s.s_id}">删除</a></td>

            </tr>
        </c:forEach>

    </table>
    <div style="align-content: center">
        <a href="?start=0">首 页</a>
        <a href="?start=${page.start-page.count}">上一页</a>
        <a href="?start=${page.start+page.count}">下一页</a>
        <a href="?start=${page.last}">末 页</a>
    </div>
    <br>
    <div style="text-align: left">
        <form method="post" action="addStudent">
            第一种方式跳转增加+后台验证：<input type="submit" value="增加学员">
        </form>
    </div>

    <br>

    <div style="align-content: center; margin-top: 40px;text-align: left">
        <form method="post" action="students" >
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

            第二种方式增加标准的restful：<input type="submit" value="增加学员">
        </form>
    </div>
    <br>

</div>

<%--这个form的method是post, 但是springmvc看到这个_method的值是DELETE后，会把其修改为DELETE.--%>
<form id="formdelete" action="" method="post">
    <input type="hidden" name="_method" value="DELETE">
</form>
</body>
</html>
