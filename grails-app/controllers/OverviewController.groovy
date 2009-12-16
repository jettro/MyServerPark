/*
 * Copyright (c) 2009. Gridshore
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

class OverviewController {

    def commentService

    def show = {
        redirect(uri: "/server/show/${params.id}")
    }

    def comments = {
        def currentServer = Server.findById(params.id.toLong())
        def allComments = Comment.withCriteria {
            server {
                eq("id", currentServer.id)
            }
            order("dateCreated","desc")
        }
        render(template: "comment", model: [comments: allComments, server: currentServer])
    }

    def addCommentAjax = {Comment comment ->
        if (!comment.validate()) {
            render "notGood"
        } else {
            commentService.createComment(comment.server.id, comment.name, comment.content)
            redirect(action:"comments",id:comment.server.id)
        }
    }

    def removeCommentAjax = {
        def currentComment = Comment.findById(params.id.toLong())
        currentComment.delete()
        redirect(action:"comments",id:currentComment.server.id)
    }

    def newComment = {
        def currentServer = Server.findById(params.serverid)
        if (!currentServer) {
            flash.error = "You need to provide a server to be able to create new comment"

            render(action: 'index')
        }
        [server: currentServer]
    }

    def index = {
        def environments = Environment.list()
        [environments: environments]
    }
}
