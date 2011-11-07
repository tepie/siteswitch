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

