import grails.test.GrailsUnitTestCase

class CommentServiceTests extends GrailsUnitTestCase {

    void testCreateComment_NoServerId() {
        mockLogging CommentService, true
        mockDomain Comment
        mockDomain Server

        def commentService = new CommentService()
        shouldFail CommentException, {
            commentService.createComment(99l,"My server does not exist","I could type a lot of content here")
        }
    }

    void testCreateComment() {
        mockLogging CommentService, true
        mockDomain Comment
        mockDomain Server,[new Server(id:3,name:"app server",function:"serve site")]

        def commentService = new CommentService()
        def newComment = commentService.createComment(3l,"jettro","my content")
        assertEquals "jettro",newComment.name
        assertEquals 1, Comment.list().size()
    }
}
