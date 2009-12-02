<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN"
 "http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
    <title><g:layoutTitle default="Grails"/></title>
    <link rel="stylesheet" href="http://yui.yahooapis.com/2.7.0/build/reset-fonts-grids/reset-fonts-grids.css" type="text/css">
    <link rel="stylesheet" href="${resource(dir: 'css', file: 'main.css')}"/>
    <link rel="shortcut icon" href="${resource(dir: 'images', file: 'favicon.ico')}" type="image/x-icon"/>
    <g:layoutHead/>
    <g:javascript library="application"/>
    <g:javascript library="scriptaculous"/>
</head>
<body>
<div id="spinner" class="spinner" style="display:none;">
    <img src="${resource(dir: 'images', file: 'spinner.gif')}" alt="Spinner"/>
</div>
<div id="doc3">
    <div id="hd">
        <img src="${resource(dir: 'images', file: 'serverpark_logo.png')}" alt="ServerPark"/><span>MyServerpark</span>
    </div>
    <div id="bd">
        <div class="yui-b">
            <g:if test="${flash.error}">
                <div class="flasherror">${flash.error}</div>
            </g:if>
            <g:if test="${flash.message}">
                <div class="flash">${flash.message}</div>
            </g:if>
        </div>
        <div id="yui-main">
            <div class="yui-b">
                <g:layoutBody/>
            </div>
        </div>
    </div>
    <div id="ft" role="contentinfo"><p>Footer</p></div>
</div>

</body>
</html>