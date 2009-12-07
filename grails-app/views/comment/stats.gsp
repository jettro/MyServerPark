<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Simple GSP page</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta name="layout" content="main"/>
    <g:javascript>
        function addComment(e,divId) {
            $(divId).value = e.responseText;
            window.alert($(divId).value);
        }
    </g:javascript>

</head>
<body>
  <g:each in="${comments}" var="comment">
    ${comment.name}<br/>
  </g:each>
</body>
</html>
