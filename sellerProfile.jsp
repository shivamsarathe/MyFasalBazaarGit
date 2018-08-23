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
		<link rel="stylesheet" href="css/userProfile.css"/>
		
		<!-- Sidebar jsp -->
	
		<script src="js/sidebar.js"></script>
	</head>

	<body>
		<div id="mySidenav" class="sidenav">
			<a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
			<a class="dropdown-btn" >Rice
				<i class="caret"></i>
			</a>
			 
			<div class="dropdown-container">
				<a href="rice.jsp">Link 1</a>
				<a href="#">Link 2</a>
				<a href="#">Link 3</a>
			</div>

			<a class="dropdown-btn">Wheat
				<i class="caret"></i>
			</a>
			 
			<div class="dropdown-container">
				<a href="#">Link 1</a>
				<a href="#">Link 2</a>
				<a href="#">Link 3</a>
			</div>
			 
			
			<a class="dropdown-btn">Pulses
				<i class="caret"></i>
			</a>
			 
			<div class="dropdown-container">
				<a href="#">Link 1</a>
				<a href="#">Link 2</a>
				<a href="#">Link 3</a>
			</div>

			<a class="dropdown-btn">Spices
				<i class="caret"></i>
			</a>
			 
			<div class="dropdown-container">
				<a href="#">Link 1</a>
				<a href="#">Link 2</a>
				<a href="#">Link 3</a>
			</div>
		</div>

		<%@ include file="dropdown.jsp"%>

		<div id="main">
			<!--Header start-->

			<%@ include file="header_main.jsp"%>

			<!--SignUp - LogIn Modal start-->

			<%@ include file="loginModal.jsp"%>																			
			<%@ include file="signupModal.jsp"%>

			<%@ include file="filter.jsp"%>

			<div id="spn" onclick="openNav()">&#9776; 
				<strong>Click Here To Search Variety Of Crops >></strong>
			</div>

		<!-- Container 2 Start -->
			<div class="container-fluid cardcar2">
				<div class="row title">
					<strong>Seller Profile</strong>
				</div>

				<div style="font-size:22px">Name:${seller.userName}</div>
				<div style="font-size:22px">Contact:${seller.contact}</div>
				<div style="font-size:22px">Address:${seller.address}</div>
				
			</div>
	</body>
</html>