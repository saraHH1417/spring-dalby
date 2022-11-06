<%--
  Created by IntelliJ IDEA.
  User: sara
  Date: 04.11.22
  Time: 17:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>
      Student Form
    </title>
</head>
<body>
  <form:form action="process-form" modelAttribute="student">
    First Name: <form:input path="firstName"/>
    <br><br>
    Last Name: <form:input path="lastName"/>
        <form:errors path="lastName" cssClass="error" />
    <br><br>
    Country:
<%--      <form:select path="country">--%>
<%--          <form:option value="Brazil" label="Brazil"/>--%>
<%--          <form:option value="France" label="France"/>--%>
<%--          <form:option value="Germany" label="Germany"/>--%>
<%--          <form:option value="Sweden" label="Sweden"/>--%>
<%--      </form:select>--%>
      <form:select path="country">
          <form:options items="${student.countryOptions}" />
      </form:select>

      <hr>
<%--      Java: <form:radiobutton path="favoriteLanguage" value="Java"/>--%>
<%--      C#    <form:radiobutton path="favoriteLanguage" value="C#" />--%>
<%--      PHP   <form:radiobutton path="favoriteLanguage" value="PHP" />--%>
<%--      RUBY  <form:radiobutton path="favoriteLanguage" value="Ruby" />--%>
      Favorite Language:
      <form:radiobuttons path="favoriteLanguage" items="${student.languages}" />
      <br><br>
      Operating systems:
      Linux: <form:checkbox path="operatingSystems"  value="Linux"/>
      MacOs <form:checkbox path="operatingSystems" value="MacOs" />
      Windows: <form:checkbox path="operatingSystems" value="Windows" />
    <input type="submit" value="Submit">
  </form:form>
</body>
</html>
