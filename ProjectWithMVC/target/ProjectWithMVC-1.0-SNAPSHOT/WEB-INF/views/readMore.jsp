<%@ page import="com.db.MaterialValueDAO" %><%--
  Created by IntelliJ IDEA.
  User: Mi Book
  Date: 3/7/2021
  Time: 8:39 PM
  To change this template use File | Settings | File Templates.
--%>
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
                <%-- ${u.id} - ${u.name} - ${u.surName} - <a href="/">${u.age}</a>
                     years old <a href="readmore/${u.id}">Read More</a>--%>
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
