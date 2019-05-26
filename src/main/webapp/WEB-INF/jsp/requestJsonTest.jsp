<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.util.*" pageEncoding="utf-8" isELIgnored="false" %>
<html>
<head>
    <title>json测试</title>

    <script type="text/javascript" src="/js/jquery.min.js"></script>
    <script type="text/javascript">
        function requestJson() {
            $.ajax({
               type:"post",
                url:"${pageContext.request.contextPath}/requestJsonTest",
                contentType:"application/json;charset=utf-8",
                // dataType:"json",
                data:'{"s_id":"2005000","s_name":"jack","s_qq":"10010","s_course":"1","update_at":"123154563", "s_school":"大学","s_link":"www.w3cshool.com","s_flag":"努力","s_brother":"1","s_source":"百度","create_at":"11231212"}',
                success:function (data) {
                    alert(data);
                }
            });
        }

    </script>
</head>
<body>

<input type="button" onclick="requestJson()" value="requestJsonTest请求json,输出json">
</body>
</html>
