<%--
  Created by IntelliJ IDEA.
  User: PukanBombit
  Date: 21.11.2021
  Time: 15:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Calculator</title>
</head>
<body>
<s:form action="calc" method="post" modelAttribute="newOperation">
    <s:input path="num1" placeholder="Number 1"/>
    <s:errors path="num1"/>
    <s:input path="action" placeholder="Action"/>
    <s:errors path="action"/>
    <s:input path="num2" placeholder="Number 2"/>
    <s:errors path="num2"/>
    <s:button>Calculate</s:button>
</s:form>
<p>${result}</p>
<p>My operations:
    <c:forEach var="operation" items="${operationList}">
    <c:out value="${operation.num1}${operation.action}${operation.num2}=${operation.result}"/></p>
</c:forEach>
</body>
</html>
