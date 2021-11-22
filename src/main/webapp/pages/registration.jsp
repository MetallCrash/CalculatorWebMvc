<%--
  Created by IntelliJ IDEA.
  User: PukanBombit
  Date: 19.11.2021
  Time: 18:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Registration</title>
</head>
<body>
<%--<form action="/user/reg" method="post">--%>
<%--    <input type="text" placeholder="Login" name="login">--%>
<%--    <p>${requestScope.login}</p>--%>
<%--    <br>--%>
<%--    <input type="password" placeholder="Password" name="password">--%>
<%--    <p>${requestScope.password}</p>--%>
<%--    <button>Submit</button>--%>
<%--</form>--%>
<s:form action="/user/reg" method="post" modelAttribute="newUser">
    <s:input path="login" placeholder="Login"/>
    <s:errors path="password"/>
    <s:input path="password" placeholder="Password"/>
    <s:errors path="password"/>
    <s:button>Submit</s:button>
</s:form>
</body>
</html>
