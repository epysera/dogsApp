<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edytuj psa</title>
    <style>
        .error {
            color: red;
        }
    </style>
</head>
<body>


<%--@elvariable id="dog" type="pl.coderslab.dogs.entity.Dog"--%>
<form:form method="post" action="/admin/editDog" modelAttribute="dog" >

    <form:hidden path="id"/><br/>
    <label for="name">Name</label>
    <form:input path="name"/>
    <form:errors path="name" cssClass="error" />
    <br/>
    <label for="breed">Breed</label>
    <form:input path="breed"/>
    <form:errors path="breed" cssClass="error" />
    <br/>
    <label for="size">Size</label>
    <form:select path="size" items="${sizes}"/>
    <form:errors path="size" cssClass="error" />
    <br/>
    <label for="character">Character</label>
    <form:input path="character"/>
    <form:errors path="character" cssClass="error" />
    <br/>
    <label for="shelter">Shelter</label>
    <form:select path="shelter" items="${shelters}" itemLabel="name" itemValue="id"/>
    <form:errors path="shelter" cssClass="error"/>
    <br/>
    <input type="submit" value="Zapisz zmiany">
</form:form>

</body>
</html>