<%--
  Created by IntelliJ IDEA.
  User: Mi Book
  Date: 3/15/2021
  Time: 8:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>I Found Books</title>
    </head>
    <body>
        <h1>
            <c:forEach items="${searchedBooks}" var="u">
                ${u.toString()}
            </c:forEach>
        </h1>
    </body>
</html>
