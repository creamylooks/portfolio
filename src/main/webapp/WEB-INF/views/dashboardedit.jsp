<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Edit Profile</title>
</head>
<body>
		<form name = "registration" action="" method = "post">
					Firstname: <input type="text" name="fname"/>
					Lastname:<input type="text" name="lname"/>
					Username:<input type="text" name ="user"/>
				
					<label for = "Male"><input type="radio" name="rdoGender" id="Male" value="Male"/>Male</label>
					<label for = "Female"><input type="radio" name="rdoGender" id="Female" value = "Female"></input>Female</label>
				Email: <input type="text" name="email"/>
				
				Mobile: <input type="text" name="mobile"/>
				
					<button type="button" onclick="location.href='derivatives/dashboard'">Cancel</button><button type="submit">Save</button>
				
	</form>
</body>
</html>