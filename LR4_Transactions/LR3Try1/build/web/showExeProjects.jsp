
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Список проектов</title>
</head>
<body>
<table border="2">
    <tr>
        <td>ID Проекта</td>
        <td>Название</td>
        <td>Дедлайн</td>
        <td>Выполнение</td>
        <td>Стоимость</td>
        <td>ФИО Рабочего</td>
    </tr>
    <c:forEach items="${projects}" var = "pr">
        <tr>
            <td>${pr.getId()}</td>
            <td>${pr.getName()}</td>
            <td>${pr.getDeadline()}</td>
            <td>
                <c:if test="${pr.isExecution()}">
                    <c:out value="Выполнен" />
                </c:if>
                <c:if test="${!pr.isExecution()}">
                    <c:out value="НЕ Выполнен" />
                </c:if>
            </td>
            <td>${pr.getCost()}</td>
            <td>${pr.getWorker().getFio()}</td>
        </tr>
    </c:forEach>
</table>
    <table>
    <tr><td>
        <form action = "index.jsp">
            <input type="submit" value="Назад">
        </form>
        </td>
    </tr>
</table>
</body>
</html>
