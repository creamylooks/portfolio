<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<meta name="viewport" content="width=device-width, initial-scale=1"/>
<link href="<c:url value="/resources/fonts/font-awesome.min.css"/>" rel="stylesheet"/>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="/resources/bootstrap.min.js"></script>
<script src="<c:url value="https://code.jquery.com/jquery-1.12.0.min.js"/>"></script>
<link href="<c:url value="/resources/bootstrap.min.css"/>" rel="stylesheet"/>
 <link href="https://fonts.googleapis.com/css?family=Sansita" rel="stylesheet"/>
 <link href="https://fonts.googleapis.com/css?family=Merriweather|Sansita" rel="stylesheet"/>
 <link href="https://fonts.googleapis.com/css?family=Merriweather|Play|Sansita" rel="stylesheet"/>
 <link href="https://fonts.googleapis.com/css?family=Dancing+Script|Merriweather|Play|Sansita" rel="stylesheet"/>
 <link href="<c:url value="/resources/style.css"/>" rel="stylesheet"/>
 
<title>Dashboard</title>
</head>
<body>
<div class="container-fluid">
	<div class="row">
	<div class="col-md-1 col-md-1-offset-11 ">
	<button>Logout</button>
	</div>
	</div>
	<div class="row">
		<div class="col-md-3">
			<img src="http://computerarts.dk/wp-content/uploads/2014/04/background1.jpg" width="300" height="300" alt="profile picture"/>
			
			
			
			
			<div class="navbar">
			<ul class="nav nav-pills nav-stacked">
				<li ><a href ="#">Profile</a></li>
				<li><a href ="portfoliolist">Portfolio</a>
					<ul>
						<li><a href="#"> All Assets</a></li>
						<li><a href="#"> My Futures Contracts</a></li>
						<li><a href="#"> My Options Contracts</a></li>
					</ul>
				</li>
				<li><a href ="pricederivative">Add Asset</a></li>
				<li><a href ="#">Implied Volatility</a></li>
				<li><a href ="visualize">Visualize Data</a></li>
				<li><a href ="#">Settings</a></li>
				
				
			</ul>
			</div>
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
		<button onclick= "location.href='dashboard/edit'">Edit</button>

</div>

</div>
</body>
</html>