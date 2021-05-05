<%--
  Created by IntelliJ IDEA.
  User: Mi Book
  Date: 5/5/2021
  Time: 4:11 PM
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
    <form action="/addMaterialValue" method="post">
        Name: <input type="text" name="name">
        Cost: <input type="number" name="cost">

        <button>ADD MATERIAL VALUE</button>
    </form>
    <a href="/">BACK</a>
</body>
</html>
