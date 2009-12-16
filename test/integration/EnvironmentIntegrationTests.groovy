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

import grails.test.*
import org.joda.time.DateTime

class EnvironmentIntegrationTests extends GrailsUnitTestCase {
    def env

    protected void setUp() {
        env = new Environment(name:'dev',lastDeploy: new DateTime()).save()
        env.addToLinks new Link(title:'bTest',url:'http://btest.gridshore.nl')
        env.addToLinks new Link(title:'aTest',url:'http://atest.gridshore.nl')
        env.addToLinks new Link(title:'zTest',url:'http://ztest.gridshore.nl')
        env.addToLinks new Link(title:'tTest',url:'http://ttest.gridshore.nl')
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
