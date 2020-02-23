<%--
  Created by IntelliJ IDEA.
  User: colya
  Date: 23.02.2020
  Time: 12:54
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
            width: 200px;
            height: 500px;
        }
    </style>
</head>
<body>
<h1>Добавить новое произведение</h1>
<form:form method="post" action="add_сomposition">
    <table >
        <tr>
            <td>Название : </td>
            <td><form:input path="title"  /></td>
        </tr>
        <tr>
            <td>ID автора : </td>
            <td><form:input path="authorID"  /></td>
        </tr>
        <tr>
            <td>Текст :</td>
            <td><form:textarea  path="text" /></td>
        </tr>
        <tr>
            <td>Жанр :</td>
            <td><form:input path="genreID" /></td>
        </tr>
        <tr>
            <td>Тип :</td>
            <td><form:input path="typeID" /></td>
        </tr>

        <tr>
            <td> </td>
            <td><input type="submit" value="Save" /></td>
        </tr>
    </table>
</form:form>
</body>
</html>
