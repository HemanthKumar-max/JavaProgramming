<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>
<hr>
<h3 align="center">:LOGIN SESSION:</h3>
<h3>=================================================================================</h3>
<div class="container"><br>
<form class="form-horizontal" action="ServletLogin"  method="post">
<div class="form-group">
	<div class="col-sm-10">
	Name:<input type="text" name="name">
	</div>
	</div><br>
	
	<div class="form-group">
	<div class="col-sm-10">
	Password:<input type="text" name="password">
	</div>
	</div><br>
	<p align="left"><button type="submit"><em>Login</em></button></p> 
</form>






</div>
<br>


    
    
</body>
</html>