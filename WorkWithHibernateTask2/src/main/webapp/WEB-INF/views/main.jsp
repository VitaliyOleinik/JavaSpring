<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <form action="/auth" method="post">
        EMAIL : <input type="email" name="email">
        PASSWORD : <input type="password" name="password">
        <input type="checkbox" name="remember" value="yes"> Remember me
        <button type="submit">SIGN IN</button>
    </form>

<br>
    <form action="register" method="post">
        EMAIL : <input type="text" name="email">
        PASSWORD : <input type="text" name="password">
        FULL NAME : <input type="text" name="full_name">
        <button type="submit">SIGN UP</button>
    </form>

    <br>
    <a href="/items">GO TO ITEMS</a>

</body>
</html>
