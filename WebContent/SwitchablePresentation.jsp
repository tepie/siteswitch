<%@page import="switchable.logic.LogicRunner"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Switchable Presentation</title>
</head>
<body>

If this page is active, it will load, otherwise, the servlet filter will
throw an exception. 

When active, the following code is now switchable:

<%

LogicRunner runner = new LogicRunner();
runner.main();

%>

</body>
</html>