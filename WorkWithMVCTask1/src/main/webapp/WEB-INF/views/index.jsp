<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Main</title>
</head>
    <body>
        <form action="/addbook" method="post">
            Name: <input type="text" name="name">
            Author: <input type="text" name="author">
            Price: <input type="number" name="price">
            <button>ADD Book</button>
        </form>
        <form action="/search_books" method="get">
            Name: <input name="name" type="text">
            <button>Search</button>
        </form>
        <a href="/all_books">All Books</a>
    </body>
</html>