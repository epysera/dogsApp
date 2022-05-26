<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Users List</title>
</head>
<body>
<%--@elvariable id="user" type="pl.coderslab.dogs.entity.User"--%>
<table border="1">
    <thead>
    <th>id</th>
    <th>UserName</th>
    <th>Password</th>
    <th>Delete</th>
    <th>Update</th>


    </thead>
    <tbody>
    <c:forEach items="${users}" var="user">
        <tr>
            <td><c:out value="${user.id}"/></td>
            <td><c:out value="${user.username}"/></td>
            <td><c:out value="${user.password}"/></td>

            <td><a href="/admin/deleteUser/${user.id}">delete</a></td>
            <td><a href="/admin/editUser/${user.id}">update</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<a href="/admin/allDogs">Dogs list</a>

<%@include file="../admin/logout.jsp"%>

</body>
</html>