<%--
  Created by IntelliJ IDEA.
  User: jettropro
  Date: Nov 5, 2009
  Time: 8:49:07 AM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Simple GSP page</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta name="layout" content="main"/>
</head>
<body>
<div class="nav">
    <span class="menuButton"><a class="home" href="${resource(dir: '')}">Home</a></span>
</div>
<div id="environments">
    <g:each in="${environments}" var="environment">
        <div class="environment">
            <span class="title">${environment.name}</span>
            <g:each in="${environment.servers}" status="i" var="server">
                <div class="server ${server.status.name.toLowerCase()}">
                    <g:link action="show" id="${server.id}">${fieldValue(bean: server, field: 'name')}</g:link>
                    <ul>
                        <li>${server.name}</li>
                        <li>${server.function}</li>
                        <li>vlans
                            <ul>
                                <g:each in="${server.networks}" status="j" var="network">
                                    <li>${network.vlan}</li>
                                </g:each>
                            </ul>
                        </li>
                    </ul>
                    <g:remoteLink action="comments" params="[id:server.id]" update="comments">comments</g:remoteLink>
                </div>
            </g:each>
        </div>
    </g:each>
</div>
<div id="comments"></div>
</body>
</html>