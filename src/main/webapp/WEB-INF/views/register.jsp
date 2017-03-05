
<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Register</title>


</head>
<body>
		<br/><br /><br /><br /><br />
		<form name = "registration" action="login" method = "post">
			<table align= "center" >
				<tr>
					<td align= "right" >Firstname:</td><td align= "right" > <input type="text" name="fname"/></td>
				</tr>
				<tr>
					<td align= "right" >Lastname:</td><td align= "right" ><input type="text" name="lname"/></td>
				</tr>
				<tr>
					<td align= "right" >Username:</td><td align= "right" ><input type="text" name ="user"/></td>
				</tr>
				<tr>
					<td align= "right" >Gender:</td><td align= "right" ><label for = "Male"><input type="radio" name="rdoGender" id="Male" value="Male"/>Male</label>
					<label for = "Female"><input type="radio" name="rdoGender" id="Female" value = "Female"></input>Female</label></td>
				</tr>
				<tr>
					<td align= "right" >Email:</td><td align= "right" > <input type="text" name="email"/></td>
				</tr>
				
				<tr>
					<td align= "right" >Mobile: </td><td align= "right" ><input type="text" name="mobile"/></td>
				</tr>
				<tr>
					<td align= "right" >password:</td><td align= "right" ><input type="password" name="pass1"/></td>
				</tr>
				
				
				<tr>
					<td  align= "right" colspan="2"><button>Create Account</button></td>
				</tr>
			</table>
	</form>
		
</body>
</html>