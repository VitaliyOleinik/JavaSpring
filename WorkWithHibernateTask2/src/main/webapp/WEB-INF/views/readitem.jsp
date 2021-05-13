<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <form action="/saveitem" method="post">
        <input type="hidden" name="id" value="${item.id}">
        NAME : <input type="text" name="name" value="${item.name}">
        PRICE : <input type="text" name="price" value="${item.price}">
        <button type="submit">SAVE ITEM</button>
    </form>
    <form action="/deleteitem" method="post">
        <input type="hidden" value="${item.id}" name="id">
        <button type="submit">DELETE</button>
    </form>

</body>
</html>
