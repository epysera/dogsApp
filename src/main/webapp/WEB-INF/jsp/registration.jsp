
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Rejestracja</title>
    <style>
        .error {
            color: red;
            border: 2px solid;
        }
    </style>
</head>
<body>

<%--@elvariable id="user" type="pl.coderslab.dogs.entity.User"--%>
<form:form modelAttribute="user">

    <form:hidden path="id"/><br/>
    login: <form:input path="username"/><br/>
    <form:errors path="username" cssClass="error"/> <br>
    password: <form:input path="password"/><br/>
    <form:errors path="password" cssClass="error"/> <br>

    <input type="submit" value="Rejestruj"><br/>

</form:form>

</body>
</html>