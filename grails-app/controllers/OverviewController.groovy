class OverviewController {

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

    def index = {
        def environments = Environment.list()
        println environments
        [environments:environments]
    }
}
