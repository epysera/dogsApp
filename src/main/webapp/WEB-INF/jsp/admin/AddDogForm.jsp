<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Add Dog Form</title>
    <style>
        .error {
            color: red;
        }
    </style>
</head>
<body>
<%--@elvariable id="dog" type="pl.coderslab.dogs.entity.Dog"--%>
<form:form modelAttribute="dog" method="post" >
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


<br/>
<input type="submit" value="Dodaj">

</form:form>

</body>
</html>