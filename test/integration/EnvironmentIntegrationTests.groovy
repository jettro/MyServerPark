import grails.test.*
import org.joda.time.DateTime

class EnvironmentIntegrationTests extends GrailsUnitTestCase {
    def env

    protected void setUp() {
        env = new Environment(name:'dev',lastDeploy: new DateTime()).save()
        env.addToLinks new Link(title:'btest',url:'http://test.gridshore.nl')
        env.addToLinks new Link(title:'aTest',url:'http://atest.gridshore.nl')
        env.addToLinks new Link(title:'zTest',url:'http://ztest.gridshore.nl')
        env.addToLinks new Link(title:'tTest',url:'http://ztest.gridshore.nl')
    }



    void testEnvironmentLinkSorting() {
        def foundEnv = Environment.get(env.id)
        def links = foundEnv.links.collect {it.title}

        assertEquals(['aTest','bTest','tTest','zTest'],links)
    }

    void testLinkSorting() {
        def foundLinks = Link.findAll()
        assertEquals(['aTest','bTest','tTest','zTest'],foundLinks.collect {it.title})        
    }
}
