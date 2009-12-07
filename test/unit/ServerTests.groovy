import grails.test.*

class ServerTests extends GrailsUnitTestCase {
    protected void setUp() {
        super.setUp()
    }

    protected void tearDown() {
        super.tearDown()
    }

    void testConstraints_noEnvironment() {
        def server = new Server(name:"serv 1",function:"site server")
        mockForConstraintsTests Server,[server]

        assertFalse server.validate()
        assertEquals "nullable",server.errors["environment"]
    }

    void testExternalIpValidation() {
        assertTrue validateServer("123.123.123.123").validate()
        assertTrue validateServer("255.123.23.123").validate()
        assertFalse validateServer("255.123.23.1233").validate()
        assertFalse validateServer("255.123.23").validate()
        assertTrue validateServer("123.123.123.6").validate()
    }

    Server validateServer(externalIp) {
        def dev = new Environment(name:"Development")
        def okStatus = new Status(name:"OK")
        def server = new Server(
                name:"my server",function:"testing",externalIp:externalIp,environment:dev,status:okStatus)

        mockForConstraintsTests Server, [server]
        return server
    }
}
