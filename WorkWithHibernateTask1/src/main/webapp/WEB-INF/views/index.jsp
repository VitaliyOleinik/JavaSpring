<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/addcar" method="post">
    NAME : <input type="text" name="name">
    MODEL : <input type="text" name="model">
    PRICE : <input type="text" name="price">
    YEAR : <input type="number" name="year">
    <button>ADD CAR</button>
</form>
<table cellpadding="20">
    <tr>
        <td>ID</td>
        <td>NAME</td>
        <td>MODEL</td>
        <td>PRICE</td>
        <td>YEAR</td>
    </tr>
    <c:forEach items="${cars}" var="car">
        <tr>
            <td>
                    ${car.id}
            </td>
            <td>
                    ${car.name}
            </td>
            <td>
                    ${car.model}
            </td>
            <td>
                    ${car.price}
            </td>
            <td>
                    ${car.year}
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>