<%--
  Created by IntelliJ IDEA.
  User: chris
  Date: 2022/1/23 0023
  Time: 19:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--    <form action="${pageContext.request.contextPath}/user/quick22" method="post" enctype="multipart/form-data">--%>
<%--        名称<input type="text" name="username"><br/>--%>
<%--        文件1<input type="file" name="file1"><br/>--%>
<%--        文件2<input type="file" name="file2"><br/>--%>
<%--        <input type="submit" value="提交">--%>
<%--    </form>--%>

    <form action="${pageContext.request.contextPath}/user/quick23" method="post" enctype="multipart/form-data">
        名称<input type="text" name="username"><br/>
        文件1<input type="file" name="file"><br/>
        文件2<input type="file" name="file"><br/>
        文件3<input type="file" name="file"><br/>
        <input type="submit" value="提交">
    </form>
</body>
</html>
