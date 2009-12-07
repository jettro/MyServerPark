import org.joda.time.DateTime

class CommentController {
    def scaffold = true

    def stats = {
        def comments = Comment.findAllByDateCreatedGreaterThan((new DateTime()).minusDays(7))

        def commentData = [:]
        comments.each {comment ->
            def serverName = comment.server.name
            if (commentData[serverName]) {
                commentData[serverName]++
            } else {
                commentData[serverName] = 1
            }
        }
        return [commentData:commentData]
    }
}
