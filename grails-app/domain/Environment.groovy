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

import org.joda.time.*
import org.joda.time.contrib.hibernate.*

class Environment {
    String name
    DateTime lastDeploy

    static hasMany = [servers:Server,links:Link]

    static constraints = {
        name(blank:false, maxSize:50, unique:true)
        lastDeploy(blank:true)
    }

    static mapping = {
        lastDeploy type:PersistentDateTime
        links sort:'title'
    }

    def String toString() {
        return name + ": " + servers.size();
    }

}
