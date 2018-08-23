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

			<a class="dropdown-btn" href="farmerinvoice.do">Your Invoices</a>
			
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
					<strong>Crops You Uploaded Yet</strong>
				</div>

				<div class="row title2">
					<strong>Wheat</strong>
				</div>

				
				<div class="row">
				<!-- Box Starts from here-->
				
				<c:forEach var="entry" items="${map}" >				    
					<c:set var="commodity" value="${entry.value}" scope="request" />
					<div class="col-md-3">
						<div class="card img-hover">
						<% String comm = (String)request.getAttribute("commodity");  %>
					<img src='<%= comm!=null?"commoditypic.do?name="+comm:"images/pulses.png" %>' style="width:400px;height:250px;" class="card-img-top img-responsive"/>
							<div class="card-body">
								<h4 class="card-title">${entry.key.commodity}</h4>
								<h4 class="card-title">MRP = ${entry.key.mrp} </h4>
								<h4 class="card-title">Quantity = ${entry.key.quantity} </h4>
								<h4 class="card-title">${entry.key.description}</h4>
								<button href="#" class="btn btn-success" data-toggle="modal" data-target="#cropsDescription"><span class="glyphicon glyphicon-eye-open"></span>View</button>
								<button href="#" class="btn btn-danger"><span class="glyphicon glyphicon-remove"></span>Delete</button>
								<button href="#" class="btn btn-default" data-toggle="modal" data-target="#myModal"><span class="glyphicon glyphicon-edit"></span>Edit</button>
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