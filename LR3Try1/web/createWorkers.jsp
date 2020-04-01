

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="WorkerServlet" method="post">
        <input type="hidden" name="param" value="Create"/>
         <tr>
            <td>ФИО</td>
            <td><input type="text" name="pfio" /></td>
        </tr>
        <tr>
            <td>Зарплата</td>
            <td><input type="text" name="psalary" /></td>
        </tr>
            <tr>
                <td valign="middle">
                    <input type="submit" value="Добавить">
                </td></tr></form>
    <tr><td>
        <form action = "index.jsp">
            <input type="submit" value="Назад">
    </form>
</table>
    </body>
</html>
