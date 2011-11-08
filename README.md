site switches
=============

Site switches demonstrates how parts of your sites can be on or off. The point is to support being able to
disable certain parts of your site while enabling others, verses a complete outage to your customers. 

For example, if your search function on your site is failing and you still want to allow normal browser 
then why not just disable the search? 

Requirements
-------
* This example is written in java and provides a servlet filter example
* Plain objects are also switchable
* There is also a javascript async request to check the component switch state
* List your switches in the site_switches.properties, then the setup is read and used

Running
-------
Uh... well I have this deployed on a tomcat install. It's not an "drop in" application at this point 
or library, but more so a example or concept. Since the implementation is so simple, it can be ported 
to anything. 

Core 
-------
The base implementation is done via simple resource bundle configuration to drive the switch states. 

See: https://github.com/tepietrondi/siteswitch/blob/master/src/siteswitch/config/SwitchConfigurationReader.java


examples
=============

switchable plain objects
-------
Look at: https://github.com/tepietrondi/siteswitch/blob/master/src/switchable/logic/LogicRunner.java

This runner looks to see if objects are runnable.

switchable JSP's / servlets
-------
Look at: https://github.com/tepietrondi/siteswitch/blob/master/WebContent/SwitchablePresentation.jsp

If the servlet request was "http://localhost:8080/siteswitch/SwitchablePresentation.jsp" then the servlet filter:

https://github.com/tepietrondi/siteswitch/blob/master/src/siteswitch/filter/SiteSwitchFilter.java

would either allow the request or throw an error. The whole page is switchable. 

switchable async checks
-------
Look again at: https://github.com/tepietrondi/siteswitch/blob/master/WebContent/SwitchablePresentation.jsp

There is JS logic to run check on the front end to determine the switch state. The JSON response page:

https://github.com/tepietrondi/siteswitch/blob/master/WebContent/SwitchablePresentation.jsp

will look up the component and respond with true or false for on and off. 




