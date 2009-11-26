class CommentException extends RuntimeException {
    String message
    Comment comment
}


class CommentService {

    boolean transactional = true

    Comment createComment(long serverId, String name, String content) {
        def server = Server.get(serverId)
        if (!server) {
            throw new CommentException(message:'provided id of server does not correspond to a real server instance')
        }
        def comment = new Comment(server:server, name:name, content:content)
        if (comment.save()) {
            return comment
        } else {
            throw new CommentException (message: 'invalid comment being created', comment:comment)
        }
        
    }
}
