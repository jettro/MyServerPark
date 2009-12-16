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
