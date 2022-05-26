<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Add City Form</title>
    <style>
        .error {
            color: red;
        }
    </style>
</head>
<body>
<%--@elvariable id="city" type="pl.coderslab.dogs.entity.City"--%>
<form:form modelAttribute="city" method="post" >
<label for="name">Name</label>
    <form:input path="name"/>
    <form:errors path="name" cssClass="error" />
<br/>
    <br/>
    <input type="submit" value="Dodaj">

</form:form>

</body>
</html>