import grails.test.*
import org.joda.time.DateTime

class EnvironmentIntegrationTests extends GrailsUnitTestCase {
    def env

    protected void setUp() {
        env = new Environment(name:'dev',lastDeploy: new DateTime()).save()
        env.addToLinks new Link(title:'bTest',url:'http://test.gridshore.nl')
        env.addToLinks new Link(title:'aTest',url:'http://atest.gridshore.nl')
        env.addToLinks new Link(title:'zTest',url:'http://ztest.gridshore.nl')
        env.addToLinks new Link(title:'tTest',url:'http://ztest.gridshore.nl')
        env.save(flush:true)
    }

    void testEnvironmentLinkSorting() {
        def foundEnv = Environment.get(env.id)
        foundEnv.refresh()
        def links = foundEnv.links.collect {it.title}

        assertEquals(['aTest','bTest','tTest','zTest'],links)
    }

    void testLinkSorting() {
        def foundLinks = Link.list()
        assertEquals(['aTest','bTest','tTest','zTest'],foundLinks.collect {it.title})        
    }
}
