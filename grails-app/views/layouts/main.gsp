<html>
    <head>
        <title><g:layoutTitle default="Grails" /></title>
        <link rel="stylesheet" href="${resource(dir:'css',file:'main.css')}" />
        <link rel="shortcut icon" href="${resource(dir:'images',file:'favicon.ico')}" type="image/x-icon" />
        <g:layoutHead />
        <g:javascript library="application" />
        <g:javascript library="prototype" />
    </head>
    <body>
        <div id="spinner" class="spinner" style="display:none;">
            <img src="${resource(dir:'images',file:'spinner.gif')}" alt="Spinner" />
        </div>	
        <div class="logo"><img src="${resource(dir:'images',file:'serverpark_logo.png')}" alt="ServerPark" /></div>
        <g:if test="${flash.error}">
            <div class="flasherror">${flash.error}</div>
        </g:if>
        <g:if test="${flash.message}">
            <div class="flash">${flash.message}</div>    
        </g:if>
        <g:layoutBody />
    </body>	
</html>