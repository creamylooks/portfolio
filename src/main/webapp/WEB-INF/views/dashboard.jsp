<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Dashboard</title>
</head>
<body>
		<div><img src="#" alt="banner"/></div>
		<div>
			<img src="#" alt="profile picture"/>
			<ul>
				<li><a href ="/dashboard">Profile</a></li>
				<li><a href ="/portfoliolist">Portfolio</a></li>
				<li><a href ="/pricederivative">Add Derivative</a></li>
				<li><a href ="/visualize">Visualize</a></li>
				<li><a href ="/portsummary">Porfolio Summary</a></li>
			</ul>
		</div>
		<div>
			<div>Username
				<div><h4>${username}</h4></div>
			</div>
			<div>Firstname
				<div><h4>${firstname}</h4></div>
			</div>
			<div>Lastname
				<div><h4>${lastname}</h4></div>
			</div>
			<div>Email
				<div><h4>${email}</h4></div>
			</div>
			<div>Mobile
				<div><h4>${mobile}</h4></div>
			</div>
			<div>Gender
				<div><h4>${gender}</h4></div>
			</div>
		</div>
		<button>Edit</button>




</body>
</html>