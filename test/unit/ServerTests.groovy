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
