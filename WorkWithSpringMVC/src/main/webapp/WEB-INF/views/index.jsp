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
    <h1>My first page with Java Spring FrameWork</h1>
    <a href="/about">ABOUT</a>
    <form action="/process" method="get">
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
