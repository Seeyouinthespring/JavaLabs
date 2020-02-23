<%--
  Created by IntelliJ IDEA.
  User: colya
  Date: 22.02.2020
  Time: 19:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Title</title>
    <style>
        textarea{
            width: 20%;
            height: 40%;
        }
    </style>
</head>
<body>

<h1>Изменение произведения</h1>
<form:form method="post" action="/edit">
    <div>
        <form:hidden path="compositionID"/>
    </div>
    <div>
        <c:out value="Название"/>
        <form:input path="title"/>
    </div>
    <div>
        <c:out value="Жанр"/>
        <form:input path="genreID"/>
    </div>
    <div>
        <c:out value="Тип"/>
        <form:input path="typeID"/>
    </div>
    <div >
        <c:out value="Текст"/>
        <form:textarea path="text"/>
    </div>
    <div>
        <form:hidden path="authorID"/>
    </div>
    <div>
        <form:hidden path="likes"/>
    </div>
    <div>
        <form:hidden path="dislikes"/>
    </div>
    <div>
        <form:hidden path="status"/>
    </div>
    <input type="submit" value="Сохранить изменения" />
</form:form>
</body>
</html>
