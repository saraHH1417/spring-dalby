<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
    Welcome to sara great company home page! :))))))))))))
    <p>
      User: <security:authentication property="principal.username" />
      Role (s): <security:authentication property="principal.authorities" />
    </p>
<hr>
    <form:form  action="${pageContext.request.contextPath}/logout" method="POST">
        <input type="submit" value="Logout" />
    </form:form>
<br>
<a href="hello-servlet">Hello Servlet</a>
</body>
</html>