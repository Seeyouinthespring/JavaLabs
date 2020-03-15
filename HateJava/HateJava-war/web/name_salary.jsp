<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Список проектов</title>
</head>
<body>
    <div>
        <c:out value="${nm}"/>
        <c:out value=" имеет зарплату в "/>
        <c:out value="${slr}"/>
        <c:out value="$"/>
    </div>
    <div>
        <form action = "change_salary.jsp"> 
            <input type="submit" value="Изменить зарплату">
        </form>
    </div>
    <div>
        <c:out value="Зарплата была изменена"/>
        <c:out value="${num}"/>
        <c:out value=" раз за сессию"/>
    </div>
</body>
</html>
