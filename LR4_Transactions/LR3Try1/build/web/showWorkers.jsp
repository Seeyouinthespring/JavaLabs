
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
        <td><c:out value="Действия"/></td>
    </tr>
    <c:forEach items="${workers}" var = "w">
        <tr>
            <td><c:out value="${w.getId()}"/></td>
            <td><c:out value="${w.getFio()}"/></td>
            <td><c:out value="${w.getSalary()}"/></td>
            <td><c:out value="${w.getStartdate()}"/></td>
            <td><form action = <c:url value="updateWorkers.jsp"/>>
                    <input type="submit" value="Изменить">
                    <input type="hidden" name="pr_salary" value="${w.getSalary()}">
                    <input type="hidden" name="pr_id" value="${w.getId()}"> 
                    <input type="hidden" name="pr_fio" value="${w.getFio()}"> 
                    <input type="hidden" name="pr_date" value="${w.getStartdate()}"> 
                </form>
                <form action = "WorkerServlet" method="post"/>
                    <input type="hidden" name="param" value="Delete">
                    <input type="hidden" name="workerid" value="${w.getId()}">
                    <input type="submit" value="Удалить">
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
        <td>
            <form action= <c:url value="createWorkers.jsp"/>>
            <input type="submit" value="Добавить рабочего">
            </form>
        </td>
    </tr>
</table>
</body>
</html>
