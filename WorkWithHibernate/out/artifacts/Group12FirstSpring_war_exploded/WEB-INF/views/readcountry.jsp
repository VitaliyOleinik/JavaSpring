<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <h1>
        ${country.id} - ${country.name}
    </h1>

    <form action="/addcity" method="post">
        CITY NAME : <input type="text" name="name">
        <input type="hidden" value="${country.id}" name="country_id">
        <button>ADD CITY</button>
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
        <c:forEach items="${cities}" var="gorod">
            <tr>
                <td>
                        ${gorod.id}
                </td>
                <td>
                        ${gorod.name}
                </td>
                <td>
                        ${gorod.country.name}
                </td>
            </tr>
        </c:forEach>
    </table>


</body>
</html>
