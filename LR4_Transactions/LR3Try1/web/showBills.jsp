
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html >
<head>
    <title>Список Налогов</title>
</head>
<body>
<table border="2">
    <tr>
        <td><c:out value="ID"/></td>
        <td><c:out value="ФИО"/></td>
        <td><c:out value="Сумма налога"/></td>
        <td><c:out value="Зарплата с вычетом налога"/></td>
    </tr>
    <c:forEach items="${bills}" var = "b">
        <tr>
            <td><c:out value="${b.getId()}"/></td>
            <td><c:out value="${b.getFio()}"/></td>
            <td><c:out value="${b.getBillsum()}"/></td>
            <td><c:out value="${b.getOverall()}"/></td>
            <td><form action = "BillServlet" method="post"/>
                      <input type="hidden" name="param" value="Delete">
                      <input type="hidden" name="billid" value="${b.getId()}">
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
    </tr>
</table>
</body>
</html>
