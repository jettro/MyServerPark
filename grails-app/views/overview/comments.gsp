<%--
  Created by IntelliJ IDEA.
  User: jettropro
  Date: Nov 5, 2009
  Time: 8:49:07 AM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Server comments</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta name="layout" content="main"/>
</head>
<body>
<div class="nav">
    <span class="menuButton"><a class="home" href="${resource(dir: '')}">Home</a></span>
</div>
<div>
    <g:render template="/shared/comment" model="comments"/>
</div>
</body>
</html>