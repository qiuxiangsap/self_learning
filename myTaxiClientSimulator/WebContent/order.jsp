<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>myTaxiClientSimulator</title>

<style type="text/css">
.order{
	padding: 20px 0 20px 50px;
}
.return{
	padding: 0px 0 20px 50px;
	font:bold 10px/12px Verdana, Geneva, sans-serif;
}
.order_button{
	padding: 10px 0 0 0;
}
.header{
	padding: 20px 0 20px 50px;
	font:bold 20px/24px Verdana, Geneva, sans-serif;
}
</style>


<script language=javascript>
	function auto(){
		var usrid = new Array("ying","david","jun","zhongcun");
		var phone = new Array("13915921701","13915921702","13915921703","13915921700");
	
		
		 var user_id =  document.getElementById ( "name" );
		 var inputCityId =  document.getElementById ( "city_id" );
		 var origin_lng =  document.getElementById ( "origin_lng" );
		 var origin_lat =  document.getElementById ( "origin_lat" );
		 var origin_addrdesc =  document.getElementById ( "origin_addrdesc" );
		 var  dest_lng = document.getElementById("dest_lng");
		 var  dest_lat = document.getElementById("dest_lat");
		 var dest_addrdesc = document.getElementById("dest_desc");
		 var order_car_type = document.getElementById("order_car_type");
		 var inputReqMobileNum =  document.getElementById ( "req_phone_number" );
		 
		 user_id.value= usrid[randomInt(0,usrid.length-1)];
		 inputCityId.value = randomInt(1,300);
		 origin_lng.value=randomInt(10000,18000)/100;
		 origin_lat.value=randomInt(1000,9000)/100;
		 origin_addrdesc.value = randomStr(32);
		 dest_lng.value=randomInt(10000,18000)/100;
		 dest_lat.value=randomInt(1000,9000)/100;
		 dest_addrdesc.value = randomStr(32);
		 order_car_type.value =randomCarType();

		 inputReqMobileNum.value= phone[randomInt(0,phone.length-1)];
	}
	
	function randomCarType() {
/* 		var carTypes = new Array("现代","本田","桑塔纳","不限");
		return carTypes[randomInt(0,carTypes.length-1)]; */
		return randomStr(10);
	}
	
	function randomPlace() {
		var province= new Array("江苏");
		var city = new Array("南京市");
		var qu = new Array("雨花台区","鼓楼区","玄武区");
		var street = new Array("虎踞路22号","龙蟠路22号","软件大道30");
		
		var place = province[0] + city[0] +qu[randomInt(0,qu.length-1)+street[randomInt(0,street.length-1)]];
		return place;
	}
	function randomInt(randNumMin, randNumMax){
		var randInt = (Math.floor(Math.random() * (randNumMax - randNumMin + 1)) + randNumMin);
		return randInt;
	}
	
	function randomStr(number)
	{
	    var text = "";
	    var possible = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

	    for( var i=0; i < number; i++ )
	        text += possible.charAt(Math.floor(Math.random() * possible.length));

	    return text;
	}
</script>


</head>
<body>
<div class="header">
	myTaxi-Create Order
</div>
<div class="return">
	<a href="main">
		Return
	</a>
	
</div>
<div class="order">
<form method="post" action="order">
	<table>
	<tbody>
	<tr>
		<td>
			User ID:
		</td>
		<td>
			<input id="name" name="userId" type="text">
		</td>
		<td>
			Varchar(50)
		</td>
		
	</tr>
	<tr>
		<td>
		city_id
		</td>
		<td>
			<input id="city_id" name="city_id" type="text">
		</td>
		<td>
			int
		</td>
	</tr>
	<tr>
		<td>
		origin_lat
		</td>
		<td>
			<input id="origin_lat" name="origin_lat" type="text">
		</td>
		<td>
			double
		</td>
	</tr>
	<tr>
		<td>
		origin_lng
		</td>
		<td>
			<input id="origin_lng" name="origin_lng" type="text">
		</td>
		<td>
			double
		</td>
	
	<tr>
		<td>
		origin_addrdesc
		</td>
		<td>
			<input id="origin_addrdesc" name="origin_addrdesc" type="text">
		</td>
		<td>
			varchar(128)
		</td>
	</tr>
	<tr>
		<td>dest_lng:
		</td>
		<td>
		<input id="dest_lng" name="dest_lng" type="text">
		</td>
		<td>
			double
		</td>
	</tr>
	<tr>
		<td>dest_lat:
		</td>
		<td>
		<input id="dest_lat" name="dest_lat" type="text">
		</td>
		<td>
			double
		</td>
	</tr>
	<tr>
		<td>dest_desc
		</td>
		<td>
		<input id="dest_desc" name="dest_desc" type="text">
		</td>
		<td>
			Varchar(128)
		</td>
	</tr>
	<tr>
		<td>order_car_type
		</td>
		<td>
		<input id="order_car_type" name="order_car_type" type="text">
		</td>
		<td>
			Varchar(32)
		</td>
	</tr>
	<tr>
		<td>Mobile Number:
		</td>
		<td>
		<input id="req_phone_number" name="req_phone_number" type="text">
		</td>
		<td>
			Varchar(20)
		</td>
	</tr>

	<tr>
		<td>Check in Client:
		</td>
		<td>
		<input id="check" name="check" type="checkbox">
		</td>
		<td>
			
		</td>
	</tr>
	</tbody>
	</table>
	<div class="order_button">
		<input type="submit" value="Submit">
		<input type="button" id="autoSet" value="Random Set" onclick="auto()">
	</div>

</form>
</div>
<div class="order">
	<%=request.getAttribute("result")%>
</div>
<div class="divide_line">
	<hr/>
</div>
<div class="query_order_status">
<form method="post" action="form_query_status">
	<table>
	<tbody>
		<tr>
		<td>
		city_order_id
		</td>
		<td>
		<input type="text" id="query_city_order_id" name="query_city_order_id">
		</td>
		<td>
		bigint
		</td>
		</tr>

		<tr>
			<td>
			status
			</td>
			<td>
			<input type="text" id="status" name="status">
			</td>
		</tr>
		</tbody>
	</table>
	
	<div class="submit_query">
		<input type="submit" value="Submit Query">
	</div>
</form>
</div>
<div>
	<%=request.getAttribute("query_result")
	%>
</div>
</body>
</html>