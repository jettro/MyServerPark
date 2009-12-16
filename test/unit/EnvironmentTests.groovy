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
