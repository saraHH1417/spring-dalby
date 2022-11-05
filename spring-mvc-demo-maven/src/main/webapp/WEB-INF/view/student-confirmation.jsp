<%--
  Created by IntelliJ IDEA.
  User: sara
  Date: 04.11.22
  Time: 17:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Student Confirmation</title>
</head>
<body>
    The Student is confirmed: ${student.firstName} ${student.lastName}
    <br>
    Country: ${student.country}
    <br>
    Favorite Language: ${student.favoriteLanguage}
    <hr>
    Operating systems: ${student.operatingSystems}
<%--    <ul>--%>
<%--        <c:foreach var="temp" items="${student.operatingSystems}">--%>
<%--            <li>${temp}</li>--%>
<%--        </c:foreach>--%>
<%--    </ul>--%>
</body>
</html>
