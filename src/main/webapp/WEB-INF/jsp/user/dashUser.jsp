<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%--<%@ sec:taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>--%>

<title>DashboardUser</title>

<body>
<h1 style="text-align: center;">Witaj ${user.username}</h1>

<p style="text-align: right;">User: <c:out value="${user.username}"/><br />
<%--    Role: <c:out value="${user_role.role_id.name}"/></p>--%>

<p style="text-align: right;"><a href="/user/userInfo">Zobacz konto</a></p>
<hr>
<hr>
<p style="text-align: right;"><%@include file="../admin/logout.jsp"%></p>


</ul>
<p>&nbsp;</p>
<hr>
<hr>
<p>&nbsp;</p>

<p><a href="/user/dashboard/dogs">Przejdź do wyszukiwarki psów</a></p>

</body>