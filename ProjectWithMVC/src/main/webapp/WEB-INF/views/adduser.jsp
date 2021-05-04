<%--
  Created by IntelliJ IDEA.
  User: Mi Book
  Date: 5/4/2021
  Time: 6:58 PM
  To change this template use File | Settings | File Templates.
--%>
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
        Age:
        <select name="age">
            <c:forEach var="i" begin="1" end="100">
                <option>${i}</option>
            </c:forEach>
        </select>
        <button>ADD USER</button>
    </form>
    <a href="/">BACK</a>
</body>
</html>
