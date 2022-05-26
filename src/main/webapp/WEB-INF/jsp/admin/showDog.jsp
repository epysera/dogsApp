<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Dog Details</title>
</head>
<body>
<%--@elvariable id="dog" type="pl.coderslab.dogs.entity.Dog"--%>
    <table border="1">
        <thead>
        <th>id</th>
        <th>Name</th>
        <th>Breed</th>
        <th>Size</th>
        <th>Character</th>
        <th>Shelter</th>


        </thead>
        <tbody>
<%--        <c:forEach items="${dogs}" var="dog">--%>
        <tr>
            <td><c:out value="${dog.id}"/></td>
            <td><c:out value="${dog.name}"/></td>
            <td><c:out value="${dog.breed}"/></td>
            <td><c:out value="${dog.size}"/></td>
            <td><c:out value="${dog.character}"/></td>
            <td><c:out value="${dog.shelter.name}"/></td>
        <td>
        </td>
    </tr>

    </tbody>
</table>
<a href = "/admin/allDogs">Dogs list</a>
<br>
<a href="/login">Wyloguj</a>
</body>
</html>