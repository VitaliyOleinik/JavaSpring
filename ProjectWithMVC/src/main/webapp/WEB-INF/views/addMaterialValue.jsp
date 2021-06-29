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
