import org.joda.time.DateTime

class CommentController {
    def scaffold = true

    def stats = {
        def comments = Comment.findAllByDateCreatedGreaterThan((new DateTime()).minusDays(7))

        [comments:comments]
    }
}
