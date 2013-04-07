<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Taxi Driver Confirm Order Simulation</title>
</head>
<style type="text/css">
	.header{
			padding: 20px 0 20px 50px;
			font:bold 20px/24px Verdana, Geneva, sans-serif;
	}
	.confirm_order {
		width:300px;
		height:200px;
		border:solid 1px #666;
		font-size:15pt;
		margin:0 auto;
		background-color:#999;
	}
	.confirm {
		position:relative;
		margin-top:20px;
		margin-left:auto;
		margin-right:auto;
	}

</style>

<script type="text/javascript">
	function auto() {
		var input_city_order_id = document.getElementById("city_order_id");
		input_city_order_id.value=1223;
	}
</script>
<body>
<div class="header">
	Taxi Driver Confirm Order Simulation
</div>
<div class="confirm_order">
<form method="post" action="order">
	<table>
	<tbody>
		<tr>
			<td>
				city_order_id
			</td>
			<td>
				<input type="text" id="city_order_id" name="city_order_id">
			</td>
		</tr>
	</tbody>
	</table>
	<div class="confirm">
		<input type="submit" value="confirm order">
		<input type="button" value="auto" onclick="auto()">
	</div>
</form>
</div>

<div>
<%=request.getAttribute("result") %>
</div>
	
</body>
</html>