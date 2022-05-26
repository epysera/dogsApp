<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Shelter List</title>
</head>
<body>
<%--@elvariable id="shelter" type="pl.coderslab.dogs.entity.Shelter"--%>
<table border="1">
    <thead>
    <th>id</th>
    <th>Name</th>
    <th>NIP</th>
    <th>REGON</th>
    <th>City</th>
    <th>Delete</th>
    <th>Update</th>


    </thead>
    <tbody>
    <c:forEach items="${shelters}" var="shelter">
        <tr>
            <td><c:out value="${shelter.id}"/></td>
            <td><c:out value="${shelter.name}"/></td>
            <td><c:out value="${shelter.nip}"/></td>
            <td><c:out value="${shelter.regon}"/></td>
            <td><c:out value="${shelter.city.name}"/></td>


            <td><a href="/admin/deleteShelter/${shelter.id}">delete</a></td>
            <td><a href="/admin/editShelter/${shelter.id}">update</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<a href="/admin/addShelter">Add new Shelter</a>
<br>
<a href="/admin/allDogs">Dogs list</a>
<br>
<%@include file="../admin/logout.jsp"%>
</body>
</html>