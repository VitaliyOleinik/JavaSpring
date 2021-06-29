<%--
  Created by IntelliJ IDEA.
  User: Mi Book
  Date: 3/5/2021
  Time: 8:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--    <h1>${message}</h1>--%>
<%--    <h1>${secondMessage}</h1>--%>
<%--    <h1>${mySecondBean}</h1>--%>
    <a href="/about">ABOUT</a>
<form action="/search" method="get">
    Name: <input type="text" name="name">
    <button>SEARCH</button>
</form>

    <c:forEach items="${users}" var = "u">
        <h1>
            ${u.id} - ${u.name} - ${u.surname} - ${u.age} years old <a href="readmore/${u.id}">Read More</a>
        </h1>
    </c:forEach>

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
</body>
</html>
