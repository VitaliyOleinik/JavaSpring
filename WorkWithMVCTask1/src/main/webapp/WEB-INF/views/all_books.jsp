<%--
  Created by IntelliJ IDEA.
  User: Mi Book
  Date: 3/13/2021
  Time: 9:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>Title</title>
    </head>
    <body>
    <table>
        <tr>
            <th>
                ID
            </th>
            <th>
                Name of Book
            </th>
            <th>
                Author
            </th>
            <th>
                Price
            </th>
        </tr>
    </table>
        <c:forEach items="${books}" var="u">
            <h2>
                <table>
                    <tr>

                        <td>
                            ${u.id})
                        </td>
                        <td>
                            ${u.name}
                        </td>
                        <td>
                            ${u.author}
                        </td>
                        <td>
                            ${u.price} $
                        </td>
                    </tr>
                </table>
            </h2>
        </c:forEach>
    </body>
</html>
