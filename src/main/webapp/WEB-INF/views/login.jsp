<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Login</title>
</head>
<body>


		<br /><br /><br /><br />
		<form name = "login" action="login/verify" method = "post">
		<input type="hidden" name="pagename" value = "lgin"></input>
		&nbsp;&nbsp;<h2 align ="center"> &nbsp;&nbsp;Login</h2>
		<table align ="center">
			<tr>
		 		<td align ="right">Username:</td> <td><input type="text" name ="userID" /></td>
			</tr>
			<tr>
				<td align = "right">Password: </td><td><input type="password" name =  "pwd"/></td>
			</tr>
			<tr>
				<td colspan="2" align ="right"><button type="button" onclick="location.href='register'">Sign up</button>
				<button type="submit">Login</button></td>

			</tr>
			</table>
		</form>
		
</body>
</html>