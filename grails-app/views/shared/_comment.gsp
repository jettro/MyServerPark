%{-- Do something with pagination--}%
%{-- Use ajax to load and commit the form --}%
<div class="comment">
    <span class="title">${server.name}</span><span class="action"><g:link controller="overview" action="newComment" params="['serverid':server.id]">create comment</g:link></span>
    <g:each in="${comments}" status="i" var="comment">
        <div>
            <span class="author">${comment.name}</span>
            <span class="content">${comment.content}</span>
        </div>
        <div><g:link controller="comment" action="edit" params="[id:comment.id]">edit</g:link></div>
    </g:each>
</div>