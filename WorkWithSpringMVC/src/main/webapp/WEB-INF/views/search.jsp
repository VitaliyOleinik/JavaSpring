<%--
  Created by IntelliJ IDEA.
  User: Mi Book
  Date: 5/11/2021
  Time: 5:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
    <body>
        <c:forEach items="${searchuser}" var = "u">
            <h1>
                    ${u.id} - ${u.name} - ${u.surname} - ${u.age} years old <a href="readmore/${u.id}">Read More</a>
            </h1>
        </c:forEach>
    </body>
</html>
