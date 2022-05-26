<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>City List</title>
</head>
<body>
<%--@elvariable id="city" type="pl.coderslab.dogs.entity.City"--%>
<table border="1">
    <thead>
    <th>id</th>
    <th>Name</th>

    <th>Action</th>
    <th>Action</th>


    </thead>
    <tbody>
    <c:forEach items="${cities}" var="city">
        <tr>
            <td><c:out value="${city.id}"/></td>
            <td><c:out value="${city.name}"/></td>


            <td><a href="/admin/deleteCity/${city.id}">delete</a></td>
            <td><a href="/admin/editCity/${city.id}">update</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<a href="/admin/addCity">Add new City</a>
<br>
<a href="/admin/allDogs">Dogs list</a>
<br>
<%@include file="../admin/logout.jsp"%>
</body>
</html>