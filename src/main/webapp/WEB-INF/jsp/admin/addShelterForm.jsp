<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Add Shelter Form</title>
    <style>
        .error {
            color: red;
        }
    </style>
</head>
<body>
<%--@elvariable id="shelter" type="pl.coderslab.dogs.entity.Shelter"--%>
<form:form modelAttribute="shelter" method="post" >
<label for="name">Name</label>
    <form:input path="name"/>
    <form:errors path="name" cssClass="error" />
    <br/>
<label for="name">NIP</label>
    <form:input path="nip"/>
    <form:errors path="nip" cssClass="error" />
    <br/>
<label for="name">REGON</label>
    <form:input path="regon"/>
    <form:errors path="regon" cssClass="error" />
    <br/>
<label for="city">City</label>
    <form:select path="city" items="${cities}" itemLabel="name" itemValue="id"/>
    <form:errors path="city" cssClass="error"/>
<br/>

    <input type="submit" value="Dodaj">
</form:form>

</body>
</html>