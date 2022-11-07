<%--
  Created by IntelliJ IDEA.
  User: sara
  Date: 07.11.22
  Time: 00:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Customer Confirmation Page</title>
</head>
<body>
    <h4>The customer is confirmed: ${customer.firstName} ${customer.lastName}</h4>
    <h4>Free passes: ${customer.freePasses}</h4>
    <h4>Postal Code: ${customer.postalCode}</h4>
    <h4>Course Code: ${customer.courseCode}</h4>
</body>
</html>
