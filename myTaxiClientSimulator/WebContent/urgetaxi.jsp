<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style type="text/css">
.header {
	color:#FFFFFFF;
	font-size:30px;

}
.return {
	padding: 50px
}
</style>
<div class=header>
<title>myTaxi-Create Order</title></div>

<script language="javascript">

function getDefaultUsers() {
	
}

	function randomSet() {
		var input_cent_order_id = document.getElementById("central_order_id");
 		var input_userid = document.getElementById("userid");
		var input_cityorderid = document.getElementById("cityorderid");
		var input_status_update_time = document.getElementById("status_update_time"); 
		var input_user_action = document.getElementById("useraction");
		var input_vehicle_id = document.getElementById("vehicleid");
		
		
		input_user_action.value = randomInt(1,3);
		
		 input_cent_order_id.value = randomStr(32);
		 input_userid.value = randomStr(32);
		 input_cityorderid.value = randomStr(32);
		 input_status_update_time.value = getCurrenttime(); 
		 input_vehicle_id.value = randomStr(20);
		 		

	}
	
	function randomInt(randNumMin, randNumMax){
		var randInt = (Math.floor(Math.random() * (randNumMax - randNumMin + 1)) + randNumMin);
		return randInt;
	}
	function randomStr(number)
	{
	    var text = "";
	    var possible = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890";

	    for( var i=0; i < number; i++ )
	        text += possible.charAt(Math.floor(Math.random() * possible.length));

	    return text;
	}
	
	function getCurrenttime() {
		var currentDate = new Date();
		var outstr="";
		outstr += currentDate.getYear();
		outstr += "-";
		outstr += currentDate.getMonth();
		outstr += "-";
		outstr += currentDate.getDay();
		outstr += " ";
		outstr += currentDate.getHours();
		outstr += ":";
		outstr += currentDate.getMinutes();
		outstr += ":";
		outstr += currentDate.getSeconds();
		outstr += ".";
		outstr += currentDate.getMilliseconds();
		return outstr;
	}
	
</script>
</head>
<body>
	<div class=header>
	myTaxi-Create Order
	</div>

	<div class="return">
	<a href="main">
		Return
	</a>
	</div>
	
	<div>
	<form action="urgetaxi",method="post">
		<table border="0">
		<tr>
			<td>central_order_id</td>
			<td><input type="text" id="central_order_id" name="central_order_id"/></td>
			<td>varchar(32)</td>
		</tr>
		<tr>
			<td>userid</td>
			<td><input type="text" id="userid" name="userid"/></td>
			<td>varchar(32)</td>		
		</tr>
		<tr>
			<td>cityorderid</td>
			<td><input type="text" id="cityorderid" name="cityorderid"/></td>
			<td>varchar(20)</td>		
		</tr>
		<tr>
			<td>vehicleid</td>
			<td><input type="text" id="vehicleid" name="vehicleid"/></td>
			<td>varchar(20)</td>		
		</tr>
		<tr>
		<tr>
			<td>status_update_time</td>
			<td><input type="text" id="status_update_time" name="status_update_time"/></td>
			<td>timestamp</td>		
		</tr>
		<tr>
		<td>
			UserAction:
		</td>
		<td>
			<input id="useraction" name="useraction" type="text">
		</td>
		<td>
			int(1:urge taxi, 2:enlarge search area,3:track taxi)
		</td>
		
	</tr>
		</table>
		<div class=submit>
			<input type="submit", name="sub", value="Submit"/>
			<input type="button", id="autoGene", value="Random Set", onclick="randomSet()"/>
		</div>
		
	</form>
	
	</div>
	
	<div class="order">
	<%=request.getAttribute("result")%>
	</div>
</body>
</html>