<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%-- Library JSTL for increment --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        a{
            margin: auto;
        }
    </style>
</head>
<body>
    <h2 align="center">Список сотрудников</h2>
    <a href="/about">ABOUT</a>
    <a href="/adduser">ADD USER</a>
    <a href="/addMaterialValue">ADD MATERIAL VALES</a>
    <table>

        <h1>
            <tr>
                <th>ФИО</th>
                <th>Кол-во</th>
                <th>Общая стоимость</th>
            </tr>
    <c:forEach items="${users}" var = "u">
            <tr>
                <td><a href="/readmore/${u.id}">${u.name} ${u.surname.charAt(0)}. ${u.patronymic.charAt(0)}.</a></td>
                <td>${u.cnt}</td>
                <td>${u.totalCost}</td>
            </tr>
        </h1>
    </c:forEach>

    </table>


</body>
</html>
