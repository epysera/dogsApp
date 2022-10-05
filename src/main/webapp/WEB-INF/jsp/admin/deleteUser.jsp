<%@ page contentType="text/html; charset=UTF-8" %>

<%--@elvariable id="user" type="pl.coderslab.dogs.entity.User"--%>
<h2>Czy na pewno chcesz usunać użytkownika? </h2>

<form method="post" action="/admin/deleteUser" modelAttribute="user">
    <input type="hidden" name="id" value="${user.id}">
    <button type="submit" value="yes" name="confirmed">TAK</button>
    <button type="submit" value="no" name="confirmed">NIE</button>
</form>