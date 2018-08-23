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
		
		<link rel="stylesheet" href="css/filterfill.css"/>
		

		<!-- Sidebar jsp -->
		
		<script src="js/sidebar.js"></script>
	</head>

	<body>
		<div id="mySidenav" class="sidenav">
			<a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
			<a class="dropdown-btn" class="active">Rice
				<i class="caret"></i>
			</a>
			 
			<div class="dropdown-container">
				<a href="#">Link 1</a>
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

					
			<c:forEach var="commodity" items="${filters}" varStatus="abc">
				<div class="col-md-2">
					<div class="card img-hover">
						<img class="card-img-top img-responsive" src="crop_pic.do?picPath=${commodity.commodityPics.picPath}" alt="Card image" style="height:200px;width:330px">
						<div class="card-body">
							<h4 class="card-title" >${commodity.commodity}</h4>
							<p class="card-text">MRP=${commodity.mrp}</p>
							<p class="card-text">Quantity=${commodity.quantity}</p>
							<p class="card-text">Seller: <a href="seller_profile.do?user_id=${commodity.user.userId}"><span class="text-capitalize">${commodity.user.userName}</span></a></p>
							<a href="buy_crop.do?commodityId=${commodity.commodityId}" class="btn btn-primary">Buy</a>
							<a href="#" class="btn btn-success" style="display:inline;" data-toggle="modal" data-target="#cropsDescription" id="">Supplier</a>

							<button class="glyphicon glyphicon-shopping-cart btn btn-primary ". id="cart${commodity.commodityId}"> 
							Add to cart</button>
						</div>	
					</div>
				</div>
		</c:forEach>		
	</body>
</html>