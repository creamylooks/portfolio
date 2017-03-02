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
<link href="<c:url value="/resources/bootstrap.min.css"/>" rel="stylesheet"/>
 <link href="https://fonts.googleapis.com/css?family=Sansita" rel="stylesheet"/>
 <link href="https://fonts.googleapis.com/css?family=Merriweather|Sansita" rel="stylesheet"/>
 <link href="https://fonts.googleapis.com/css?family=Merriweather|Play|Sansita" rel="stylesheet"/>
 <link href="https://fonts.googleapis.com/css?family=Dancing+Script|Merriweather|Play|Sansita" rel="stylesheet"/>
 <link href="<c:url value="/resources/style.css"/>" rel="stylesheet"/>
<title> Derivative Summary</title>
</head>
<body>
		<table  class="table table-striped table-responsive">
			<thead>
			<tr>
				<td></td>
				<td>Call Option</td>
				<td>Put Option</td>
			</tr>
			</thead>
			<tbody>
			<tr>
				<td>Theoretical Price</td>
				<td>${calle}</td>
				<td>${pute}</td>
			</tr>
			<tr>
				<td>Delta</td>
				<td>${deltac}</td>
				<td>${deltap}</td>
			</tr>
			<tr>
				<td>Gamma</td>
				<td>${gamma}</td>
				<td>${gamma}</td>
			</tr>
			<tr>
				<td>Vega</td>
				<td>${vega}</td>
				<td>${vega}</td>
			</tr>
			<tr>
				<td>Theta</td>
				<td>${thetac}</td>
				<td>${thetap}</td>
			</tr>
			<tr>
				<td>Rho</td>
				<td>${rhoc}</td>
				<td>${rhop}</td>
			</tr>
			</tbody>
		</table>
		<p align ="center" id="price">${pricey}</p><br/>
		<div align="center"><button class="btn btn-default btn-lg">Save</button>&nbsp;&nbsp;<button class="btn btn-default btn-lg">Cancel</button></div>

</body>
</html>