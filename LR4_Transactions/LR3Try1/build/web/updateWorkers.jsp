<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Обновить</title>
</head>
<body>
<table>
<form action="WorkerServlet" method="post">
    <input type="hidden" name="param" value="Update"/>
    <tr>
        <td>ID рабочего </td>
        <td>${param.pr_id} </td>
        
        <td>текущее ФИО </td>
        <td>${param.pr_fio} </td>
        
        <td>Дата начала работы </td>
        <td>${param.pr_date} </td>
        
        <td>Текущая зарплата </td>
        <td>${param.pr_salary} </td>
    </tr>
     <tr>
         <td></td>
         <td></td>
        <td>Новое ФИО</td>
        <td><input type="text" name="paramfio" /></td>
        <td></td>
        <td></td>
        <td>Новая зарплата</td>
        <td><input type="text" name="paramsalary" /></td>
    </tr>
        <tr>
            <td valign="middle">
                <input type="submit" value="Изменить">
            </td></tr></form>
<tr><td>
    <form action = "index.jsp">
        <input type="submit" value="Назад">
    </form></td><td></td></tr>
</table>
</body>
</html>

