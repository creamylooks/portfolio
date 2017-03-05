<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" id="html">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<meta name="viewport" content="width=device-width, initial-scale=1"/>
<link href="<c:url value="/resources/fonts/font-awesome.min.css"/>" rel="stylesheet"/>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="/resources/bootstrap.min.js"></script>
<link href="<c:url value="/resources/bootstrap.min.css"/>" rel="stylesheet"/>
 <link href="https://fonts.googleapis.com/css?family=Sansita" rel="stylesheet"/>
 <link href="https://fonts.googleapis.com/css?family=Merriweather|Sansita" rel="stylesheet"/>
 <link href="https://fonts.googleapis.com/css?family=Merriweather|Play|Sansita" rel="stylesheet"/>
 <link href="https://fonts.googleapis.com/css?family=Dancing+Script|Merriweather|Play|Sansita" rel="stylesheet"/>
 <link href="<c:url value="/resources/style.css"/>" rel="stylesheet"/>
<title>Login</title>


</head>
<body id="body">
		<div class="container-fluid">
		<div class="collection">
		<p  id= "name" class="info"><i class="fa fa-user-circle fa-5x" aria-hidden="true" ></i></p>
			<h2 align ="center">Login</h2>
		<form name = "login" action="dashboard" method = "post">
		<div class="form-group">
    <label for="userName">Username:</label>
    <div class="input-group">
     <span class="input-group-addon"><i class="fa fa-user" aria-hidden="true"></i></span>
    <input type="text" class="form-control" name ="userID" />
    </div>
    </div>
		<div class="form-group" >
		<label for="userPassword">Password:</label>
		<div class="input-group ">
    	 	<span class="input-group-addon"><i class="fa fa-lock" aria-hidden="true"></i></span>
				 <input type="password" class="form-control" name =  "pwd"></input>
				 
				 </div>
			</div>
				<button type="submit" class="btn btn-primary btn-block">Sign in</button><br/>
				<p align ="center" class="text-danger">${Invalid}</p><br/>
				
				<div id="collect">
				<label for="needAccount">Need an Account?</label>
				<button type="button" class="btn btn-primary btn-sm" onclick="location.href='register'">Register</button><br/>
				<a href="#">Forgot your password?</a>
				</div>
				
				
				
		</form>
		
		
		</div>
		</div>
</body>
</html>