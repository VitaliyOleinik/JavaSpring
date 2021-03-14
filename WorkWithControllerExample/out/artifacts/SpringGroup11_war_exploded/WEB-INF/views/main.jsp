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

</body>
</html>
