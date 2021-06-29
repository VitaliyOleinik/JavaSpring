<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%-- Library JSTL for increment --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="/adduser" method="post">
        Name: <input type="text" name="name">
        SurName: <input type="text" name="surname">
        Patronymic: <input type="text" name="patronymic">
        <button>ADD USER</button>
    </form>
    <a href="/">BACK</a>
</body>
</html>
