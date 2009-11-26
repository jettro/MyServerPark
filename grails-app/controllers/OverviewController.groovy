class OverviewController {

    def commentService

    def show = {
        redirect(uri:"/server/show/${params.id}")
    }

    def comments = {
        def currentServer = Server.findById(params.id.toLong())
        def allComments = Comment.withCriteria {
            server {
                eq("id",currentServer.id)
            }
        }
        render(template:"/shared/comment",model:[comments:allComments, server:currentServer])
    }

    def addComment = {
        commentService.createComment(params.serverId.toLong(),params.name,params.content)
        redirect(action:'index')
    }

    def newComment = {
        def currentServer = Server.findById(params.serverid)
        if (!currentServer) {
            flash.error = "You need to provide a server to be able to create new comment"
            
            render(action:'index')
        }
        [server:currentServer]
    }

    def index = {
        def environments = Environment.list()
        [environments:environments]
    }
}
