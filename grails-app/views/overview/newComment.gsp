<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Add comment</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta name="layout" content="main"/>
</head>
<body>
<div class="nav">
    <span class="menuButton"><a class="home" href="${resource(dir: '')}">Home</a></span>
</div>
    <span>New comment for ${server.toString()}</span>
    <g:hasErrors>
      <div class="errors">
          <g:renderErrors bean="${comment}" as="list"/>
      </div>
    </g:hasErrors>
    <g:form action="addComment" method="POST">
        <g:hiddenField name="server.id" value="${server.id}"/>
        Name : <g:textField name="name" value="${comment?.name}"/><br/>
        Content : <g:textArea name="content" value="${comment?.content}"/><br/>
        <g:actionSubmit value="Add Comment"/>
    </g:form>
</body>
</html>