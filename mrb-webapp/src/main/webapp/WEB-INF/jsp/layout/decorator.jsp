<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title><sitemesh:write property='title' default="Meeting Room Booking System"/></title>
</head>
<body>
	<h2><sitemesh:write property="page.heading"/></h2>
	<hr />
	<sitemesh:write property='body'/>
	<hr />
	<sitemesh:write property="page.footer"/>
</body>
</html>