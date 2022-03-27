<%--
  Created by IntelliJ IDEA.
  User: chris
  Date: 2022/3/27 0027
  Time: 19:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>展示账户数据信息</h1>
    <table>
        <tr>
            <th>账户名称</th>
            <th>账户金额</th>
        </tr>

        <c:forEach items="${accountList}" var="account">
            <tr>
                <td>${account.name}</td>
                <td>${account.money}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
