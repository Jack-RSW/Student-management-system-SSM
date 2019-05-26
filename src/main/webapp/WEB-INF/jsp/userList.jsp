<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false" %>

<%-- 登陆模块 --%>
当前用户:${username }|
<c:if test="${username!=null }">
    <a href="${pageContext.request.contextPath }/logout">退出</a>
    <hr>
</c:if>