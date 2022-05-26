<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edytuj użytkownika</title>
    <style>
        .error {
            color: red;
        }
    </style>
</head>
<body>

<%--@elvariable id="user" type="pl.coderslab.dogs.entity.User"--%>
<form:form method="post" action="/admin/editUser" modelAttribute="user" >

    <form:hidden path="id"/><br/>
    <label for="username">UserName</label>
    <form:input path="username"/>
    <form:errors path="username" cssClass="error" />
    <br/>
    <label for="password">Password</label>
    <form:input path="password"/>
    <form:errors path="password" cssClass="error" />
    <br/>

    <input type="submit" value="Zapisz zmiany">
</form:form>

</body>
</html>