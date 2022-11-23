<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Spring Rest Demo</title>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<br/>
<a href="hello-servlet">Hello Servlet</a>
<br>
<a href="test/hello">Test Hello Page</a>
<%--<a href="${pageContext.request.contextPath}/test/hello">Test Hello Page</a>--%>
<br>
<a href="${pageContext.request.contextPath}/api/students">List All Students</a>
</body>
</html>