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
<div class="switch-states">
<ul class="states"></ul>
</div>
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.6.4/jquery.min.js"></script>
<script type="text/javascript">
$(document).ready(function(e){
	$.ajaxSetup({
		url: "/siteswitch/SwitchJsonResponse.jsp",
		dataType : "json",
		success : function(data){
			if (console && console.log){
				console.log(data);
			}
			var newSwitchState = $('<li class="state" />');
			var text = this.what;
			text = text + " : ";
			text = text + data.isComponentOn;
			newSwitchState.text(text );
			newSwitchState.appendTo( $('.switch-states > .states'));
		},
		error : function (jqXHR, textStatus, errorThrown){
			if (console && console.log){
				console.error(errorThrown);
			}		
		}
	});
	
	$.ajax({
		data : "component=switchable.objects.SwitchableObj1",
		what : "switchable.objects.SwitchableObj1"
	});
	
	$.ajax({
		data : "component=switchable.objects.SwitchableObj2",
		what : "switchable.objects.SwitchableObj2"
	});
	
	$.ajax({
		data : "component=switchable.objects.SwitchableObj2",
		what : "switchable.objects.SwitchableObj2"
	});
	
});
</script>
</body>
</html>
