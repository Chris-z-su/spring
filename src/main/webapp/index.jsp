<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<body>
<%--<h2>Hello, ${name}!</h2>--%>
<h2>Hello, Spring!</h2>
<%
    response.sendRedirect(request.getContextPath()+"/pages/main.jsp");
%>
</body>
</html>
