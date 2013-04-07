<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>myTaxi Client Simulator</title>
<style type="text/css">
.order{
	padding: 20px 0 20px 50px;
	position:absolute;
	top: 50%;
	left:50%;
	margin-left:-150px;
	margin-top:-100px;
	width:300px;
	height:200px;
}
.order_button{
	padding: 10px 0 0 0;
}
.header{
	padding: 20px 0 20px 50px;
	font:bold 20px/24px Verdana, Geneva, sans-serif;
}
</style>
</head>

<body>
<div class="header">
	myTaxi Client Simulator
</div>
<div class="order">

	<table>
		<tbody>
			<tr>
				<td>
					<a href="order.jsp">
					1. Create Order
					</a>
				</td>
			</tr>
			<tr>
				<td>
				<a href="order2">
					2. Notify Order Status
				</a>
				</td>
			</tr>
			<tr>
				<td>
					<a href="urgetaxi.jsp">
					3. Urge Taxi
					</a>
				</td>
			</tr>
			<tr>
				<td>
					4. Enlarge Search Radius
				</td>
			</tr>
		
		</tbody>
	</table>
</div>
</body>
</html>