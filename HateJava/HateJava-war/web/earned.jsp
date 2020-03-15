
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html >
<head>
    <title>Список рабочих</title>
</head>
<body>
    <div>
        <c:out value="Сумма заработной платы рабочего за выполненные проекты: "/>
        <c:out value="${earnings}" /> 
    </div>
</body>
</html>