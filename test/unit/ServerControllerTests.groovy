import grails.test.*

class ServerControllerTests extends ControllerUnitTestCase {
    protected void setUp() {
        super.setUp()
    }

    protected void tearDown() {
        super.tearDown()
    }

    void testList() {
        // TODO look at bug in intellij
        mockDomain(Server,[new Server(name:"name",function:"function")])
        this.controller.list()
    }
}
