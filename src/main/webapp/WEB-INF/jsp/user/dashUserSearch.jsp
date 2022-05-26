<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<title>DashboardUser</title>

<body>
<h1 style="text-align: center;">Witaj ${user.username}</h1>

<p style="text-align: right;">User: <c:out value="${user.username}"/><br />
    <%--    Role: <c:out value="${user_role.role_id.name}"/></p>--%>

<p style="text-align: right;"><a href="/user/userInfo">Zobacz konto</a></p>
<hr>
<hr>
<p style="text-align: right;"><%@include file="../admin/logout.jsp"%></p>

<p> Wyszukiwarka</p>
<hr>
<%@include file="../search.jsp"%> <%--okienko search--%>
<hr>
<ul>
    <c:forEach items="${dogs}" var="d">
        <li> <a href="/user/findDog?id=${d.id}"><strong><c:out value="${d.name}"/></strong></a><text>
            RASA: </text><strong><c:out value="${d.breed}"/></strong></li>
            CHARAKTER: </text><strong><c:out value="${d.character}"/></strong></li>
            ROZMIAR: </text><strong><c:out value="${d.size}"/></strong></li>
            SCHRONISKO: </text><strong><c:out value="${d.shelter.name}"/></strong></li>
            MIASTO: </text><strong><c:out value="${d.shelter.city.name}"/></strong></li>
        <br />

        <hr>
    </c:forEach>
</ul>
<p>&nbsp;</p>
<hr>
<p>&nbsp;</p>

<p style="text-align: right" ><a href="/user/dashboard" ><strong>Powrót</strong></a></p>
</body>