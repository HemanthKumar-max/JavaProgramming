<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<%@page import="com.bz.usermanagement.service.UserInfoProvider" %>
<%@page import="com.bz.usermanagement.model.UserModel"%>
<%@page import="com.bz.usermanagement.utils.InputUtility"%>
</head>
<body>
<% 
String password = (String)session.getAttribute("password");
System.out.println(password);
UserInfoProvider up=new UserInfoProvider();
UserModel um=up.getDetails(password);
System.out.println("in view user");
%>


<h><% out.println("<h3>User Bio-data</h3>"); %></h>
<h><% out.println("========================="); %></h><br>
<h><% out.println("NAME:" +um.getName()); %></h><br>
<h><% out.println("PASSWORD: "+um.getPassword()); %></h><br>
<h><% out.println("COUNTRY:" +um.getCountry()); %></h><br>
<h><% out.println("PHONE:" +um.getPhone()); %></h>


<h1>Want to logout =====></h1>
<form class="form-horizontal" action="ServletLogout"  method="post">
<p align="left"><button type="submit"><em>Logout</em></button></p>
</form>



</body>
</html>