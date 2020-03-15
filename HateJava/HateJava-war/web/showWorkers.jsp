
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html >
<head>
    <title>Список рабочих</title>
</head>
<body>
<table border="2">
    <tr>
        <td><c:out value="ID Рабочего"/></td>
        <td><c:out value="ФИО"/></td>
        <td><c:out value="Зарплата"/></td>
        <td><c:out value="Работает с"/></td>
    </tr>
    <c:forEach items="${workers}" var = "w">
        <tr>
            <!--<td>${w.getWorker_id()}</td>-->
            <td><c:out value="${w.getWorker_id()}"/></td>
            <td><c:out value="${w.getFio()}"/></td>
            <td><c:out value="${w.getSalary()}"/></td>
            <td><c:out value="${w.getStartDate()}"/></td>
            <td>
                <form action = "UIController" method="get">
                    <input type="submit" value="Посчитать зароботок">
                    <input type="hidden" name="param" value="getearnings"/>
                    <input type="hidden" name="workerid" value="${w.getWorker_id()}">  
                </form>
            </td>
        </tr>
    </c:forEach>
</table>
<table>
    <tr>
        <td>
            <form action = <c:url value="index.jsp"/>>
            <input type="submit" value="Назад">
            </form></td>
    </tr>
</table>
</body>
</html>
