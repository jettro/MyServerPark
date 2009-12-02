<div class="comment">
    <span class="title">${server.name}</span>
    <div id="newComment${server.environment.id}">
        <g:form>
            <g:hiddenField name="server.id" value="${server.id}"/>
            Name :<br/><g:textField name="name" value="${comment?.name}"/><br/>
            Content :<br/><g:textArea name="content" value="${comment?.content}" rows="2" cols="20"/><br/>
            <g:submitToRemote action="addCommentAjax" value="New Comment" update="comments${server.environment.id}"/>
        </g:form>
    </div>
    <div id="showComments${server.environment.id}">
        <g:each in="${comments}" status="i" var="comment">
            <div>
                <span class="author">${comment.name}</span>
                <span class="content">${comment.content}</span>
            </div>
            <div>
                <g:link controller="comment" action="edit" params="[id:comment.id]">edit</g:link>&nbsp;
                <g:remoteLink action="removeCommentAjax" params="[id:comment.id]"
                        update="comments${server.environment.id}">remove</g:remoteLink>
            </div>

        </g:each>
    </div>
</div>