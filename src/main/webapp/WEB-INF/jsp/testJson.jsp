<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json"%>
<%--<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>--%>
<body>
<json:array var="s" items="${stu}">
    <json:object>
        <json:property name="s_id" value="${s.s_id}"></json:property>
        <json:property name="s_name" value="${s.s_name}"></json:property>
        <json:property name="s_qq" value="${s.s_qq}"></json:property>
        <json:property name="s_course" value="${s.s_course}"></json:property>
        <json:property name="update_at" value="${s.update_at}"></json:property>
        <json:property name="s_school" value="${s.s_school}"></json:property>
        <json:property name="s_link" value="${s.s_link}"></json:property>
        <json:property name="s_flag" value="${s.s_flag}"></json:property>
        <json:property name="s_brother" value="${s.s_brother}"></json:property>
        <json:property name="s_source" value="${s.s_source}"></json:property>
        <json:property name="create_at" value="${s.create_at}"></json:property>
    </json:object>
</json:array>

</body>

