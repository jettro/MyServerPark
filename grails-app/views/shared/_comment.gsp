<%--
  Created by IntelliJ IDEA.
  User: jettropro
  Date: Nov 5, 2009
  Time: 10:46:51 AM
  To change this template use File | Settings | File Templates.
--%>

<div class="comment">
    <span class="title">${server.name}</span><span class="action"><g:link controller="comment" action="create" params="['server.id':server.id]">create comment</g:link></span>
    <g:each in="${comments}" status="i" var="comment">
        <div>
            <span class="author">${comment.name}</span>
            <span class="content">${comment.content}</span>
        </div>
    </g:each>
</div>