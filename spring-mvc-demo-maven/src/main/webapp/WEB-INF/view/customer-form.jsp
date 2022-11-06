<%--
  Created by IntelliJ IDEA.
  User: sara
  Date: 07.11.22
  Time: 00:27
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="form"  uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <title>Customer Registration Form</title>
  <style>
    .error {color: red}
  </style>
</head>
<body>
  <form:form action="process-form" modelAttribute="customer">
    First Name: <form:input path="firstName"/>
                <form:errors path="firstName" cssClass="error"/>
    <br><br>
    Last Name(*): <form:input  path="lastName" />
                  <form:errors  path="lastName" cssClass="error"/>
    <br><br>
    Free Passes: <form:input path="freePasses" />
                  <form:errors path="freePasses" cssClass="error"/>
    <br><br>
    Postal code: <form:input path="postalCode" />
                 <form:errors path="postalCode" cssClass="error"/>
    <input type="submit" value="Submit" />
  </form:form>
</body>
</html>
