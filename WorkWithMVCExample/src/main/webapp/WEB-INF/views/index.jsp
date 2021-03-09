<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <h1>THIS IS HOME PAGE</h1>
    <a href="/about">GO TO ABOUT</a>

    <form action="/addcar" method="post">
        NAME : <input type="text" name="name">
        MODEL : <input type="text" name="model">
        MAX SPEED : <input type="number" name="max_speed">
        YEAR : <input type="text" name="year">
        ENGINE VOLUME : <input type="text" name="engine_volume">
        <button>ADD CAR</button>
    </form>

    <c:forEach items="${cars}" var="mashina">
        <h1>
            ${mashina.name} ${mashina.model}
            <a href="/loadcar/${mashina.id}-${mashina.year}.html">READ MORE</a>
        </h1>
    </c:forEach>

</body>
</html>
