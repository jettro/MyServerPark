import grails.test.*
import org.joda.time.DateTime

class EnvironmentTests extends GrailsUnitTestCase {
    protected void setUp() {
        super.setUp()
    }

    protected void tearDown() {
        super.tearDown()
    }

    void testUniqueNameConstraint() {
        def dev = new Environment(name:"Development",lastDeploy:new DateTime())
        def acc = new Environment(name:"Acceptation",lastDeploy:new DateTime())
        mockForConstraintsTests (Environment,[dev,acc])

        def tstEnv = new Environment(name:"Development",lastDeploy:new DateTime())
        assertFalse tstEnv.validate()
        assertEquals "unique", tstEnv.errors["name"]
    }

    void testNameConstraints() {
        mockForConstraintsTests (Environment)

        def tstEnv = new Environment()
        assertFalse tstEnv.validate()
        assertEquals "nullable", tstEnv.errors["name"]

        tstEnv = new Environment(name:"Nu moeten we een hele lange string tikken die meer dan" +
            "50 karakters heeft en daardoor niet door de validatie komt")
        assertFalse tstEnv.validate()
        assertEquals "maxSize", tstEnv.errors["name"]
    }
}
