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

    ${commentData.keySet()}<br/>

<g:pieChart title="Comments per server" type="3d" size="${[600,200]}"
      labels="${commentData.keySet()}"  dataType='text' data='${commentData.values().asList()}'/>
</body>
</html>
