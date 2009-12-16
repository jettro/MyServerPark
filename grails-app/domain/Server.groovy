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

class Server {
    String name
    String function
    String externalIp

    // relationships
    Status status
    static hasMany = [networks:NetworkDefinition]

    static belongsTo = [environment:Environment]

    static constraints = {
        name(blank:false, maxSize:50)
        function(blank:false, maxSize:50)
        externalIp(matches : "(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)")
    }

    static mapping = {
        sort name:'desc'
    }

    def String toString() {
        return name
    }
}
