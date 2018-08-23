<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
   <head>
   <style>
table, th, td {
    border: 1px solid black;
    border-collapse: collapse;
	text-align:center;
	width:400px;
	height:100px;
	background-color:#d9f3d3;
	font-weight:bold;
}
th, td {
    padding: 35px;

}
th {
    text-align: center;
}

</style>

	   <title>profile page</title>
	   		   <meta charset="utf-8" />
			   <script src="js/jquery-3.3.1.js"></script>
			   <meta name="viewport" content="width=device-width,initial-scale=1" />
			   <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css" />
			   <script src="bootstrap/jquery/jquery.min.js"></script>
			   <script src="bootstrap/js/bootstrap.min.js"></script>
			   <link rel="stylesheet" href="css/profiledetail.css" />
			   	<!--<script src="js/profile.js"> </script>-->m
			   <script src="js/dropdown.js"> </script>
			   
		   
   </head>
   <body style="font-family:veradana;">

   		 <%@ include file="header_main.jsp" %>

		<div>
					<h1 align="center">Your Commodities</h1>
					<table style="margin-top:20px;" align="center">
						<tr>
						<th style="text-align: center">Categories</th>
						<th style="text-align: center">Commodity</th>
						<th style="text-align: center">Quantity</th>
						<th style="text-align: center">Price</th>
						</tr>
						<c:forEach var="commodity" items="${commodities}">
						<tr>
							<td>${commodity.category.category}</td>
							<td>${commodity.commodity}</td>
							<td>${commodity.quantity}</td>
							<td>${commodity.mrp}</td>
						</tr>
						</c:forEach>
						
						
							
						</table>
				</div>
				
	</body>
</html>