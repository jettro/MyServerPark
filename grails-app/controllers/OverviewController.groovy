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
        }
        render(template: "/shared/comment",
                model: [comments: allComments, server: currentServer, environmentId: params.environmentId])
    }

    def addComment = {Comment comment ->
        if (!comment.validate()) {
            render(view: 'newComment', model: [comment: comment, server: comment.server])
            return
        }
        commentService.createComment(comment.server.id, comment.name, comment.content)
        flash.message = "Comment is created for server ${comment.server.toString()}"
        redirect(action: 'index')
    }

    def addCommentAjax = {Comment comment ->
        if (!comment.validate()) {
            render "notGood"
        } else {
            commentService.createComment(comment.server.id, comment.name, comment.content)
            render "Comment is created for server ${comment.server.toString()}"
        }
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
