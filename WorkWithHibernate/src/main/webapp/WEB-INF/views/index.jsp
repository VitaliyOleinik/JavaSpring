<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <form action="/addcountry" method="post">
        NAME : <input type="text" name="name">
        <button>ADD COUNTRY</button>
    </form>

    <table cellspacing="10">
        <tr>
            <td>
                ID
            </td>
            <td>
                NAME
            </td>
            <td>
                MORE
            </td>
        </tr>
        <c:forEach items="${countries}" var="strana">
            <tr>
                <td>
                    ${strana.id}
                </td>
                <td>
                    ${strana.name}
                </td>
                <td>
                    <a href="readcountry/${strana.id}">READ MORE</a>
                </td>
            </tr>
        </c:forEach>
    </table>

</body>
</html>
