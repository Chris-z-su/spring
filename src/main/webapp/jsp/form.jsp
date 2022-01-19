<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2022/1/19
  Time: 23:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/user/quick14" method="post">
        <%--表明是第几个User对象的username，age--%>
        user1[用户名]: <input type="text" name="userList[0].username"><br/>
        user1[年龄]: <input type="text" name="userList[0].age"><br/>


        user2[用户名]: <input type="text" name="userList[1].username"><br/>
        user2[年龄]: <input type="text" name="userList[1].age"><br/>

        <input type="submit" value="提交">
    </form>

</body>
</html>
