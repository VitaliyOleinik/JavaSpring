<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
</head>
<body>

    <form action="/additem" method="post">
        NAME : <input type="text" name="name">
        PRICE : <input type="text" name="price">
        <button type="submit">ADD ITEM</button>
    </form>
    <c:forEach items="${items}" var="item">
        <h2>
            ${item.name} - ${item.price} USD - <a href="readitem/${item.id}">EDIT</a>
        </h2>
    </c:forEach>

</body>
</html>
