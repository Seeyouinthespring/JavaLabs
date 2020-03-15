<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Список проектов</title>
</head>
<body>
    <form action="StatefulServlet" method="post">
    <div>
        <c:out value=" На сколько вы хотите изменить зарплату ?"/>
        <input type="text" name="diff" />
    </div>
    <input type="submit" value="Изменить">
    </form>
</body>
</html>
