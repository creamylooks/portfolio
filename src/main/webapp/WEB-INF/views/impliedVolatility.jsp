<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Implied  Volatility</title>
</head>
<body>
			<form action="implied" method="post"  >
			Asset Name: <input type="text" name="assetName"/>
					Symbol: <input type="text" name="assetSymbol"/>
			Option Type:	<select name="opTp">
							<option value = "none">Please Select a Type</option>
							<option value="call">CALL</option>
							<option value = "put">PUT</option>
						</select>
			Days To Expiration: <input type="text" name="daysToExp"/>
			<div > Stock Price: <input type="text" name = "underlyingPrice" /></div>
			 <div >Strike Price: <input type="text" name = "excercisePrice"/></div>
			Day Count Convention :
							   <select name="dayConv" id="dayCountConv">
									  <option value="none">Please select</option>
									  <option value="Trading">Trading Days</option>
									  <option value="Calendar">Calendar Days</option>
							   </select>
			Interest Rate:<input type="text" name = "rate"/>
			Market Price:<input type="text" name = "mOPrice"/>
			<!-- <input type="text" name="answer" disabled="disabled"/>  -->
			
			<button type="submit">Calculate</button>
			</form>
</body>
</html>