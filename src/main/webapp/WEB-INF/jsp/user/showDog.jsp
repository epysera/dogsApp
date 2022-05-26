<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--@elvariable id="dog" type="pl.coderslab.dogs.entity.Dog"--%>
<h1>Dane Psa</h1>
<h2><c:out value="${dog.name} "/></h2><br>
<p></p>
<hr>
<hr>
<c:out value="Rasa: ${dog.breed}"/><br>
<c:out value="Rozmiar: ${dog.size}"/><br>
<c:out value="Charakter:${dog.character}"/><br>
<c:out value="Schronisko:${dog.shelter.name}"/><br>
<c:out value="Miasto:${dog.shelter.city.name}"/><br>


<hr>

<p style="text-align: right" ><a href="/user/dashboard" ><strong>Powrót</strong></a></p>