
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <h1>
        THIS IS PAGE
    </h1>

    <a href="/index">GO BACK</a>

    <%
        for(int i=1;i<100;i++){
    %>
        <a href="/news/<%=i%>/news_title.html">LOAD NEWS </a><br>
    <%
        }
    %>

</body>
</html>
