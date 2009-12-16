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
