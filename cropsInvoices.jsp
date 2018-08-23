<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8" />
		
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
		<title>FASALBAZAR</title>
		<meta content='width=device-width,height=device-width, initial-scale=1.0' name='viewport' />
		
		
		<!-- CSS Files -->
		<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" />
		<script src="bootstrap/jquery/jquery.min.js"></script>
		<script src="bootstrap/js/bootstrap.min.js"></script>
		
		<!-- MY CSS -->
		<link rel="stylesheet" href="css/farmerProfile.css"/>
		
		<!-- Sidebar jsp -->
		<link rel="stylesheet" href="css/sidebar.css"/>
		<script src="js/sidebar.js"></script>

		
	</head>

	<body>
		<div id="mySidenav" class="sidenav">
			<a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
			<a class="dropdown-btn" href="#" data-toggle="modal" data-target="#myModal" style="outline:none">Add Crops</a>
			
			<a class="dropdown-btn" href="crop_order.do">Your Orders</a>

			<a class="dropdown-btn" href="cropsInvoices.jsp">Your Invoices</a>
			
			<a class="dropdown-btn" href="cropsStatus.jsp">Check Status</a>
		</div>

		<%@ include file="dropdown.jsp"%>

		<div id="main">
			<!--Header start-->

			<%@ include file="header_main.jsp"%>

			<!--SignUp - LogIn Modal start-->

			<%@ include file="cropsAdd.jsp"%>

			<div id="spn" onclick="openNav()">&#9776; 
				<strong>Click Here For Any Action >></strong>
			</div>

		<!-- Container 2 Start -->
			<div class="container-fluid cardcar2">
				<div class="row title">
					<strong>Your Invoices</strong>
				</div>

				<div class="row title2">
					<strong></strong>
				</div>

				
				<div class="row">
				<!-- Box Starts from here-->
				<c:forEach var="shippingAdd" items="${shippingAddress}" varStatus="abc">

					<div class="col-md-3">
						<div class="card img-hover">
							<div class="card-body" id="div${abc.count}">
							

								<h4 class="card-title">Buyer: ${shippingAdd.user.userName}</h4>
								<p class="card-text">Contact: ${shippingAdd.user.contact}</p>

								<p class="card-text">Commodity: ${shippingAdd.commodity.commodity}</p>
								<p class="card-text">MRP: ${shippingAdd.mrp}</p>
								<p class="card-text">Quantity: ${shippingAdd.quantity}</p>
								<p class="card-text">House Number: ${shippingAdd.housePlotFlatNumber}</p>
								<p class="card-text">Street: ${shippingAdd.streetLane}</p>
								<p class="card-text">Pincode: ${shippingAdd.pinCode}</p>
								<p class="card-text">City: ${shippingAdd.city.city}</p>
								<p class="card-text">Date Of Delivery: </p>
								
								<button class="btn btn-primary" >Print Invoice</button>
							</div>
						</div>
					</div>
				</c:forEach>
					
			</div><hr/>

			<!-- Footer Start -->
			<footer>
				<h4 class="text-center">6 days ago</h4>
			</footer>

		</div>
		<%@include file="showCropsDescription.jsp"%>
	</body>
</html>