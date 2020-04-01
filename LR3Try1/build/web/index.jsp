
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>workersandprojects</title>
    <style>
        body{background-color: black}
        input{
            font-size: 30px;
            color: darkturquoise;
            background: lightgrey;
            width: 300px;
            height: 100px;
            text-align: center;
        }
        p{
            font-size: 30px;
            color: darkturquoise;  
        }
    </style>
</head>
<body>
<p>Выберете таблицу, с которой нужно работать:</p>
<table border="0">
    <tr>
        <td>
            <form action = "WorkerServlet" method="get">
                <input type="submit" value="Таблица Рабочих">
            </form>
        </td>
        <td>
            <form action = "ProjectServlet" method="get">
                <input type="hidden" name="param" value="All">
                <input type="submit" value="Таблица Проектов">
            </form>
        </td>
        <td>
            <form action=<c:url value="/pageThatNotExist"/>>
                <input type="submit" value="Нет Страницы">
            </form>
        </td>
    </tr>
</table>
</body>
</html>
