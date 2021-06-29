<%@ page import="com.db.MaterialValueDAO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>Title</title>
        <style>
            table{
                margin: auto;
                width: 600px;
            }
            table, th, td {
                border: 1px solid black;
            }
        </style>
    </head>
    <body>
        <h3>Фамилия: ${person.surname}</h3>
        <h3>Имя: ${person.name}</h3> ${p}
        <h3>Отчество: ${person.patronymic}</h3>
        <h3>${person.cnt}</h3>
        <h3>Список выданных материальных ценностей:</h3>
        <table>
            <h1>
                <tr>
                    <th>№ п/п</th>
                    <th>Название</th>
                    <th>Стоимость</th>
                </tr>

                <tr>

                </tr>
            </h1>

        </table>
    </body>
</html>
