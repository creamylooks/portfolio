<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<meta name="viewport" content="width=device-width, initial-scale=1"/>
<link href="/resources/fonts/font-awesome.min.css"/>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="/resources/bootstrap.min.js"></script>
<link href="/resources/bootstrap.min.css"/>
 <link href="https://fonts.googleapis.com/css?family=Sansita" />
 <link href="https://fonts.googleapis.com/css?family=Merriweather|Sansita"/>
 <link href="https://fonts.googleapis.com/css?family=Merriweather|Play|Sansita" />
 <link href="https://fonts.googleapis.com/css?family=Dancing+Script|Merriweather|Play|Sansita" />
 <link href="/resources/style.css"/>
 <script>
/**
 * 
 */
function fun(){
		document.getElementById("futuresDetails").style.display="none";
		document.getElementById("optionsDetails").style.display="none";
	}
	
	function dividendSelect(){
		var ans= document.getElementById("divi").selectedIndex;
		if(ans==0 ||ans==1){
			document.getElementById("dividendDetails").style.display="none";
		}
		if(ans==2){
			document.getElementById("dividendDetails").style.display="block";
		}
	}
	function fun2(){
		var v = document.getElementById("income").selectedIndex;
		if(v==0||v==1){
			document.getElementById("isIncome").style.display="none";
		}
		else if (v==2){
			document.getElementById("isIncome").style.display="block";
		}
	}
	function fun3(){
		var v = document.getElementById("yield").selectedIndex;
		if(v==0||v==1){
			document.getElementById("isYield").style.display="none";
		}
		else if (v==2){
			document.getElementById("isYield").style.display="block";
		}
	}
function selectFunc(){
	
	
	var selection = document.getElementById("volatilityType");
	var chosenValue =selection.options[selection.selectedIndex].value;
	document.getElementById("vols").style.display="block";
	switch(chosenValue){
		case "manual":
			
			document.getElementById("manualVolatility").style.display="block";
			document.getElementById("historicalVolatility").style.display="none";
			document.getElementById("impliedVolatility").style.display="none";
			break;
		case "historical":
			document.getElementById("manualVolatility").style.display="none";
			document.getElementById("historicalVolatility").style.display="block";
			document.getElementById("impliedVolatility").style.display="none";
		break;
		case "implied":
			document.getElementById("manualVolatility").style.display="none";
			document.getElementById("historicalVolatility").style.display="none";
			document.getElementById("impliedVolatility").style.display="block";
		break;
		case "none":
			document.getElementById("manualVolatility").style.display="none";
		document.getElementById("historicalVolatility").style.display="none";
		document.getElementById("impliedVolatility").style.display="none";
		break;
			
	}
}
	function contractSelect(){
		var reply= document.getElementById("contType").selectedIndex;
		if(reply==0){
			fun();
		}
		if(reply==1){
		
			document.getElementById("optionsDetails").style.display="none";
			document.getElementById("isIncome").style.display="none";
			document.getElementById("isYield").style.display="none";
			document.getElementById("futuresDetails").style.display="block";
			
		}
		if(reply==2){
			document.getElementById("futuresDetails").style.display="none";
			document.getElementById("vols").style.display="none";
			document.getElementById("dividendDetails").style.display="none";
			document.getElementById("optionsDetails").style.display="block";
			
		}
		
	}
	



</script>
<style>
		.form-group{
			margin: 10px;
			 
		}
		.form-horizontal{
			margin-top:150px;
		}
		
</style>
<title>Add Derivative</title>
</head >
<body onload="fun();" >
	
	<div class="container-fluid">
	<div align="center" id="forming">
	<form action="pricesummary" method="post" class="form-horizontal" >
				<div class="form-group">
				Contract Type:
				<select name="contractType" id="contType" onchange="contractSelect();">
					<option value = "none">Please Select a Type</option>
					<option value = "Futures">Future</option>
					<option value = "Options">Option</option>
				</select>
				</div>
				<div class="form-group">
				Interest Rate:<input type="text" name = "rate"/>
				</div>
				<div class="form-group">
				Days To Expiration: <input type="text" name="daysToExp"/>
				</div>
				
				<div>
				<div class="form-group"> 
				Day Count Convention :
							   <select name="dayConv" id="dayCountConv">
									  <option value="none">Please select</option>
									  <option value="Trading">Trading Days</option>
									  <option value="Calendar">Calendar Days</option>
							   </select>
							   </div>
				</div>
				  <div id = "total">
					  <div id="futuresDetails">
					  <div class="form-group">
						  <div >Spot Price: <input type="text" name = "spotPrice"/></div>
						  </div>
						  <div class="form-group">
						  <div >
						  Known Income?:
							   <select name="incomeDetail" id="income" onchange="fun2();">
									  <option value="none">Please select</option>
									  <option value="no">No</option>
									  <option value="yes">Yes</option>
							   </select>
						  </div>
						  </div>
						  <div class="form-group">
						  <div id="isIncome">
						  	Income: <input type="text" name="inc"/>
						  	</div>
						  	<div class="form-group">
						  	Days to payment:<input type="text" name="daysToIncPay"/>
						  	</div>
						  	<div class="form-group">
						  	Interest rate for Income:<input type="text" name="intRateInc"/>
						  	</div>
						  </div>
						  <div class="form-group">
						  <div > Known Yield? :
							   <select name="yieldDetail" id="yield" onchange="fun3();">
									  <option value="none">Please select</option>
									  <option value="no">No</option>
									  <option value="yes">Yes</option>
							   </select>
							   </div>
						  </div>
						  <div class="form-group">
						  <div id="isYield">
						  	Yield: <input type="text" name="yld" />
						  	</div>
						  </div>
					 </div>
					 
					<div id="optionsDetails">
					<div class="form-group">
					<div>Pricing Model:
						<select name="priceModel">
							<option value = "none">Please Select a Type</option>
							<option value="Black_Scholes">Black-Scholes</option>
							<option value = "Binomial">Binomial</option>
						</select>
						</div>
					</div>
					<div id="optType">
					<div class="form-group">
		   Option Type:	<select name="optionType">
							<option value = "none">Please Select a Type</option>
							<option value="call">CALL</option>
							<option value = "put">PUT</option>
						</select>
						</div>
					</div>
					<div class="form-group">
					<div > Stock Price: <input type="text" name = "stockPrice" /></div>
					</div>
					<div class="form-group">
					 <div >Strike Price <input type="text" name = "strikePrice"/></div>
					 </div>
					 <div class="form-group">
					 <div>Volatility Type: 
					 <select id="volatilityType" name= "vol" onchange = "selectFunc();">
					 <option value = "none">Please Select a Type</option>
						<option value="manual">Manual Entry</option>
						<option value="historical">Historical</option>
						<option value="implied">Implied</option>
					</select>
					</div>
					</div>
					<div id="vols">
					<div class="form-group">
							<div id= "manualVolatility">
							Value for Volatility<input type="text" name = "manualVol"/>
							</div>
							</div>
							<div id="historicalVolatility">
							<div class="form-group">
							Upload price data:<input type="file" name = "priceData"/>
							</div>
							</div>
							<div class="form-group">
							<div id="impliedVolatility">
							Market Price:<input type="text" name = "marketPrice"/>
							</div>
							</div>
					</div>
					
					<div>
					<div class="form-group">
					 Dividend Yielding?:
					 <select id="divi" onchange = "dividendSelect();">
					 	<option value = "none">Please Select a Type</option>
						<option value="no">No</option>
						<option value = "yes" onclick="">Yes</option>
					</select> 
					</div>
					</div>
					
					<div id="dividendDetails">
					<div class="form-group">
					Dividend Amount: <input type="text" name = "dividendAmount"/>
					</div>
					<div class="form-group">
					Days to Ex-Dividend: <input type="text" name = "daysToExDiv"/>
					</div>
					<div class="form-group">
					Dividend Frequency:
					<select name="dividendFreq" id="divideFreq">
						<option value = "none">Please Select a Type</option>
						<option value="month">Monthly</option>
						<option value = "quarter">Quarterly</option>
						<option value="semiAnnual">Semi-Annually</option>
						<option value = "annual">Annually</option>	
					</select>
					</div> 
					</div>
					</div>
				</div>
				<button>Calculate</button>
	</form>
	</div>
	</div>
	
	
</body>
</html>