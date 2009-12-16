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

import org.joda.time.DateTime

class BootStrap {
    def init = { servletContext ->
        def statussus = ['OK', 'WARNING', 'PROBLEM', 'COLD']
        statussus.each { statusName ->
            def newStatus = new Status(name: statusName)
            newStatus.save()
        }

        def vlans = [['Middleware', 'middle_dev'], ['Backend', 'backend_dev'], ['Beheer', 'maint_dev'], ['Backup', 'backup_dev']]
        vlans.each {
            vlanFunction, vlanName ->
            def newVlan = new Vlan(name: vlanName, function: vlanFunction)
            newVlan.save()
        }

        def environments = ['Development', 'Test', 'Acceptation', 'Production']
        environments.each {
            name ->
            def environment = new Environment(name: name, lastDeploy:new DateTime())
            environment.save()
        }

        def okStatus = Status.findByName("OK")
        def warningStatus = Status.findByName("WARNING")
        def errorStatus = Status.findByName("PROBLEM")
        def coldStatus = Status.findByName("COLD")

        def backend1 = new Server(name:'backend 1',function:'appserver',status:okStatus,externalIp:'127.0.0.1')

        def devEnvironment = Environment.findByName("Development")
        devEnvironment.addToServers(backend1)
        devEnvironment.save(flush:true)

        def now = new DateTime()

        def comments = [['comment now','this is a comment from now',now,backend1],
                        ['comment now 2','this is a comment from now too',now,backend1],
                        ['comment from past','this is a comment from the past',now.minusDays(4),backend1],
                        ['comment yesterday','this is a comment from yesterday',now.minusDays(1),backend1],
                        ['comment old','this is an old comment',now.minusDays(20),backend1]]
        comments.each {name, content, dateCreated, server ->
            def comment = new Comment(name:name,content:content,server:server)
            comment.save()
        }
    }
    def destroy = {
    }
}