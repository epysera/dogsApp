<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Dogs List</title>
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
    <th>Delete</th>
    <th>Update</th>


    </thead>
    <tbody>
    <c:forEach items="${dogs}" var="dog">
        <tr>
            <td><c:out value="${dog.id}"/></td>
            <td><c:out value="${dog.name}"/></td>
            <td><c:out value="${dog.breed}"/></td>
            <td><c:out value="${dog.size}"/></td>
            <td><c:out value="${dog.character}"/></td>
            <td><c:out value="${dog.shelter.name}"/></td>

            <td><a href="/admin/deleteDog/${dog.id}">delete</a></td>
            <td><a href="/admin/editDog/${dog.id}">update</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<a href="/admin/addDog">Add new Dog</a>
</br>
<a href="/admin/allShelters">Shelters list</a>
</br>
<a href="/admin/allCities">Cities list</a>
</br>
<a href="/admin/allUsers">Users list</a>
<br>

<%@include file="../admin/logout.jsp"%>

</body>
</html>