<%--
  Created by IntelliJ IDEA.
  User: Mi Book
  Date: 3/5/2021
  Time: 8:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%-- Library JSTL for increment --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <style>
        table{
            margin: auto;
            border: 1px solid dimgray;
            width: 600px;
        }
    </style>
</head>
<body>
    <h1>My first page with Java Spring FrameWork</h1>
    <h2 align="center">Список сотрудников</h2>
    <a href="/about">ABOUT</a>

    <c:forEach items="${users}" var = "u">
        <table>
            <tr>
                <td>
        <h1>
                ${u.id} - ${u.name} - ${u.surName} - <a href="/">${u.age}</a> years old <a href="readmore/${u.id}">Read More</a>
        </h1>
                </td>
            </tr>
        </table>
    </c:forEach>

    <a href="/adduser">ADD USER</a>


</body>
</html>
