%{--
  - Copyright (c) 2009. Gridshore
  -
  - Licensed under the Apache License, Version 2.0 (the "License");
  - you may not use this file except in compliance with the License.
  - You may obtain a copy of the License at
  -
  -     http://www.apache.org/licenses/LICENSE-2.0
  -
  - Unless required by applicable law or agreed to in writing, software
  - distributed under the License is distributed on an "AS IS" BASIS,
  - WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
  - See the License for the specific language governing permissions and
  - limitations under the License.
  --}%

<% import org.codehaus.groovy.grails.orm.hibernate.support.ClosureEventTriggeringInterceptor as Events %>
<%=packageName%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>${className} List</title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="\${createLinkTo(dir:'')}">Home</a></span>
            <span class="menuButton"><g:link class="create" action="create">New ${className}</g:link></span>
        </div>
        <div class="body">
            <h1>${className} List</h1>
            <g:if test="\${flash.message}">
            <div class="message">\${flash.message}</div>
            </g:if>
            <div class="list">
                <table>
                    <thead>
                        <tr>
                        <%
                            excludedProps = ['version',
                                               Events.ONLOAD_EVENT,
                                               Events.BEFORE_DELETE_EVENT,
                                               Events.BEFORE_INSERT_EVENT,
                                               Events.BEFORE_UPDATE_EVENT]
                            
                            props = domainClass.properties.findAll { !excludedProps.contains(it.name) && it.type != Set.class }
                            Collections.sort(props, comparator.constructors[0].newInstance([domainClass] as Object[]))
                            props.eachWithIndex { p,i ->
                   	            if(i < 6) {
                   	                if(!p.type.name.startsWith('org.joda.time') && p.isAssociation()) { %>
                   	        <th>${p.naturalName}</th>
                   	    <%          } else { %>
                   	        <g:sortableColumn property="${p.name}" title="${p.naturalName}" />
                        <%  }   }   } %>
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="\${${propertyName}List}" status="i" var="${propertyName}">
                        <tr class="\${(i % 2) == 0 ? 'odd' : 'even'}">
                        <%  props.eachWithIndex { p,i ->
                                if(i == 0) { %>
                            <td><g:link action="show" id="\${${propertyName}.id}">\${fieldValue(bean:${propertyName}, field:'${p.name}')}</g:link></td>
                        <%      } else if(i < 6) { %>
                            <td>\${fieldValue(bean:${propertyName}, field:'${p.name}')}</td>
                        <%  }   } %>
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
            <div class="paginateButtons">
                <g:paginate total="\${${propertyName}Total}" />
            </div>
        </div>
    </body>
</html>
