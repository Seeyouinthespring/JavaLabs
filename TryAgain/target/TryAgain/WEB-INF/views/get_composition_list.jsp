<%--
  Created by IntelliJ IDEA.
  User: colya
  Date: 22.02.2020
  Time: 19:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Список произведений</h1>
<table border="2" width="70%" cellpadding="2">
    <tr><th>Id</th><th>Название</th><th>Лайки</th><th>Дизлайки</th><th>Автор</th><th>Жанр</th><th>Тип</th><th>Статус</th></tr>
    <c:forEach var="comp" items="${list}">
        <tr>
            <td>${comp.compositionID}</td>
            <td>${comp.title}</td>
            <td>${comp.likes}</td>
            <td>${comp.dislikes}</td>
            <td>${comp.authorID}</td>
            <td>${comp.genreID}</td>
            <td>${comp.typeID}</td>
            <td>${comp.status}</td>
            <td><a href="get_composition_by_id/${comp.compositionID}">Просмотр</a></td>
            <td><a href="delete_composition/${comp.compositionID}">Удалить</a></td>
        </tr>
    </c:forEach>
</table>
<br/>
<a href="add_composition_form">Добавить произведение</a>
</body>
</html>
