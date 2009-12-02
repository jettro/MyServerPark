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
