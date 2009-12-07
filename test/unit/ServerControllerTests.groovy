import grails.test.*

class ServerControllerTests extends ControllerUnitTestCase {
    protected void setUp() {
        super.setUp()
    }

    protected void tearDown() {
        super.tearDown()
    }

    void testList() {

        mockDomain(Server,[new Server(name:"name",function:"function")])
        this.controller.list()
    }
}
