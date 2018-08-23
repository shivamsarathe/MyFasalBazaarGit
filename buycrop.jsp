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
					<strong>Crop Shipment</strong>
				</div>
				<c:forEach var="commodity" items="${commodities}">
				<div class="row">
					<div class="col-md-2">
						<div class="card img-hover">
							<img class="card-img-top img-responsive" src="crop_pic.do?picPath=${commodity.commodityPics.picPath}" alt="Card image">
							<div class="card-body">
								<h4 class="card-title">${commodity.commodity}</h4>
								<p class="card-text">MRP=${commodity.mrp}/Kg</p>
								<p class="card-text">Quantity=${commodity.quantity}</p>
								<p class="card-text">Seller: <a href="seller_profile.do?user_id=${commodity.user.userId}"><span class="text-capitalize">${commodity.user.userName}</span></a></p>

								
							</div>
						</div>
					</div>
				</c:forEach>
				<div>
				
				
				<p><input type="text" placeholder="Enter Name" class="form-control" style="width:50%;margin-top:10px" value="${user.userName}"/></p>
				<p><input type="text" placeholder="Enter Mobile Number" class="form-control" style="width:50%" value="${user.contact}"/></p>
				<p><input type="text" placeholder="Enter Address" class="form-control" style="width:50%" value="${user.address}"/></p>
				
				<form action="place_order.do" method="post">
				<p><input type="text" placeholder="Enter House Number,Use Only Number e.g. 1111" class="form-control" style="width:50%" name="house_no"/></p>
				<p><input type="text" placeholder="Enter Street Lane" class="form-control" style="width:50%" name="street"/></p>
				<p><input type="text" placeholder="Enter Pincode,Use Only Number e.g. 50003" class="form-control" style="width:50%" name="pincode"/></p>
				<c:forEach var="comm" items="${commodities}">
				<p><input type="text" placeholder="Enter Pincode" class="form-control" style="width:50%;display:none" value="${comm.commodityId}" name="commodity_id" /></p>

				<p><input type="text" placeholder="" class="form-control" style="width:50%;display:none" value="${comm.user.userId}" name="seller_id" /></p>


				<p><input type="text" placeholder="" class="form-control" style="width:50%;display:none" value="${comm.mrp}" name="mrp" /></p>


				</c:forEach>
				
				<p><input type="number" placeholder="Enter Quantity in kg" class="form-control" style="width:50%;"  name="quantity" /></p>

				<input type="submit" class="btn btn-primary" value="Place Order"/>
				</form>
				<div>
					

		

	</body>
</html>