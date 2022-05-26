<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edytuj schronisko</title>
    <style>
        .error {
            color: red;
        }
    </style>
</head>
<body>

<%--@elvariable id="shelter" type="pl.coderslab.dogs.entity.Shelter"--%>
<form:form method="post" action="/admin/editShelter" modelAttribute="shelter" >

    <form:hidden path="id"/><br/>
    <label for="name">Name</label>
    <form:input path="name"/>
    <form:errors path="name" cssClass="error" />
    <br/>
    <label for="nip">NIP</label>
    <form:input path="nip"/>
    <form:errors path="nip" cssClass="error" />
    <br/>
    <label for="regon">REGON</label>
    <form:input path="regon"/>
    <form:errors path="regon" cssClass="error" />
    <br/>
    <label for="city">City</label>
    <form:select path="city" items="${cities}" itemLabel="name" itemValue="id"/>
    <form:errors path="city" cssClass="error"/>
    <br/>
    <input type="submit" value="Zapisz zmiany">
</form:form>

</body>
</html>