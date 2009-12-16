<div class="comment">
    <span class="title">%{--
  - Copyright (c) 2009. Gridshore
  -
  - Licensed under the Apache License, Version 2.0 (the "License");
  - you may not use this file except in compliance with the License.
  - You may obtain a copy of the License at
  -
  -     http://www.apache.org/licenses/LICENSE-2.0
  -
  - Unless required by applicable law or agreed to in writing, software
  - distributed under the License is distributed on an "AS IS" BASIS,
  - WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
  - See the License for the specific language governing permissions and
  - limitations under the License.
  --}%

${server.name}</span>
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