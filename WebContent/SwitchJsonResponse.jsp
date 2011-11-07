<%@ page language="java" contentType="application/json; utf-8" pageEncoding="utf-8"%>

<%
siteswitch.config.SwitchConfigurationReader conf = siteswitch.config.SwitchConfigurationReader.getInstance();
boolean switchState = conf.isComponentOn(request.getParameter("component"));
%>
{"isComponentOn" : <% out.print(switchState); %>}
