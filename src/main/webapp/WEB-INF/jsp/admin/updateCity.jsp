<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edytuj miasto</title>
    <style>
        .error {
            color: red;
        }
    </style>
</head>
<body>


<%--@elvariable id="city" type="pl.coderslab.dogs.entity.City"--%>
<form:form method="post" action="/admin/editCity" modelAttribute="city" >

    <form:hidden path="id"/><br/>
<label for="name">Name</label>
    <form:input path="name"/>
    <form:errors path="name" cssClass="error" />
<br/>

    <input type="submit" value="Zapisz zmiany">
</form:form>

</body>
</html>