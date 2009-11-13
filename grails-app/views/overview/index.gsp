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
    <span class="menuButton"><g:link controller="environment">Environments</g:link></span>
    <span class="menuButton"><g:link controller="server">Servers</g:link></span>
    <span class="menuButton"><g:link controller="vlan">Vlans</g:link></span>
</div>
<div id="environments">
    <g:each in="${environments}" status="i" var="environment">
        <div class="environment">
            <span class="title"><g:link action="show" controller="environment" id="${environment.id}">${environment.name}</g:link>
            - (last depoy : ${environment.lastDeploy.format('dd-MMM-yyyy HH:mm')})
            <g:each in="${environment.links.sort {a, b -> a.title.compareToIgnoreCase b.title}}" var="link"><a href="${link.url}" title="${link.title}">${link.title}</a>&nbsp;</g:each>
            </span>
            <g:each in="${environment.servers.sort { a, b -> a.name.compareToIgnoreCase b.name }}" var="server">
                <div class="server ${server.status.name.toLowerCase()}">
                    <g:link action="show" id="${server.id}">${fieldValue(bean: server, field: 'name')}</g:link>
                    <ul>
                    <li>${server.function}</li>
                    <g:each in="${server.networks.sort { a, b -> a.vlan.name.compareToIgnoreCase b.vlan.name }}" status="j" var="network">
                        <li>${network.vlan} (${network.ipAddress})</li>
                    </g:each>
                </ul>
                    <g:remoteLink action="comments" params="[id:server.id]" update="comments${i}">comments</g:remoteLink>
                </div>
            </g:each>
            <div id="comments${i}" class="comments"></div>
        </div>
    </g:each>
</div>
</body>
</html>