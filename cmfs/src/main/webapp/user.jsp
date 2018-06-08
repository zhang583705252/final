<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page contentType="text/html; charset=utf-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>


</head>
<body>
        <form action="${pageContext.request.contextPath}/user/regist" method="post">
            姓名：<input type="text" value="" name="username"/></br>
            电话：<input type="text" value="" name="phoneNum"/></br>
            密码：<input type="password" value="" name="password"/></br>
            性别：<input type="text" value="" name="sex"></br>
            省份：<input type="text" value="" name="province"/></br>
            城市：<input type="text" value="" name="city"/></br>
            图片：<input type="text" value="" name="headPic"/></br>
            法名：<input type="text" value="" name="dharmaName"></br>
            提交：<input type="submit" value="提交"/>
        </form>
</body>

</html>