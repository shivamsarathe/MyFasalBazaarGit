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

	<!-- Container 1 Start -->
			
		<!-- Container 2 Start -->
			<div class="container-fluid cardcar2">
				<div class="row title">
					<strong>Your Orders</strong>
				</div>
				
				<div class="row">
				<c:forEach var="shippingAddress" items="${shippingAdd}">
					<div class="col-md-2">
						<div class="card img-hover">
							<img class="card-img-top img-responsive" src="crop_pic.do?picPath=${shippingAddress.commodity.commodityPics.picPath}" alt="Card image" style="height:200px;width:330px">
							<div class="card-body">
								<h4 class="card-title">${shippingAddress.commodity.commodity}</h4>
								<p class="card-text">MRP: ${shippingAddress.mrp}</p>
								<p class="card-text">Quantity: ${shippingAddress.quantity}</p>
								<p class="card-text">Seller: <a href="seller_profile.do?user_id=${shippingAddress.user.userId}"><span class="text-capitalize">${shippingAddress.user.userName}</span></a></p>
								<p class="card-text">Date of Delivery:20-07-18</p>
								<p class="card-text">Order Status: <strong>undelivered</strong></p>

								
							</div>
						</div>
					</div>
					</c:forEach>
					<!--<div class="col-md-2">
						<div class="card img-hover">
							<img class="card-img-top img-responsive" src="images/pulses.png" alt="Card image">
							<div class="card-body">
								<h4 class="card-title">Pulses</h4>
								<p class="card-text">Good in taste.Good in taste.Good in taste.Good in taste.Good in taste.Good in taste.Good in taste.
								</p>
								<button href="#" class="btn btn-primary">Buy</button>
							</div>
						</div>
					</div>

					<div class="col-md-2">
						<div class="card img-hover">
							<img class="card-img-top img-responsive" src="images/pulses.png" alt="Card image">
							<div class="card-body">
								<h4 class="card-title">Pulses</h4>
								<p class="card-text">Good in taste.Good in taste.Good in taste.Good in taste.Good in taste.Good in taste.Good in taste.
								</p>
								<button href="#" class="btn btn-primary">Buy</button>
							</div>
						</div>
					</div>

					<div class="col-md-2">
						<div class="card img-hover">
							<img class="card-img-top img-responsive" src="images/pulses.png" alt="Card image">
							<div class="card-body">
								<h4 class="card-title">Pulses</h4>
								<p class="card-text">Good in taste.Good in taste.Good in taste.Good in taste.Good in taste.Good in taste.Good in taste.
								</p>
								<button href="#" class="btn btn-primary">Buy</button>
							</div>
						</div>
					</div>

					<div class="col-md-2">
						<div class="card img-hover">
							<img class="card-img-top img-responsive" src="images/pulses.png" alt="Card image">
							<div class="card-body">
								<h4 class="card-title">Pulses</h4>
								<p class="card-text">Good in taste.Good in taste.Good in taste.Good in taste.Good in taste.Good in taste.Good in taste.
								</p>
								<button href="#" class="btn btn-primary">Buy</button>
							</div>
						</div>
					</div>

					<div class="col-md-2">
						<div class="card img-hover">
							<img class="card-img-top img-responsive" src="images/pulses.png" alt="Card image">
							<div class="card-body">
								<h4 class="card-title">Pulses</h4>
								<p class="card-text">Good in taste.Good in taste.Good in taste.Good in taste.Good in taste.Good in taste.Good in taste.
								</p>
								<button href="#" class="btn btn-primary">Buy</button>
							</div>
						</div>
					</div>
				</div>
			</div>-->

			<!--Container 3 Start -->
			<!--<div class="container cardcar2">
				<div class="row title">
					<strong>Discounts Offers</strong>
				</div>

				<div class="row">
					<div class="col-md-4">
						<div class="card img-hover">
							<img class="card-img-top img-responsive" src="images/pulses.png" alt="Card image">
							<div class="card-body">
								<h4 class="card-title">Pulses</h4>
								<p class="card-text">Good in taste.Good in taste.Good in taste.Good in taste.Good in taste.Good in taste.Good in taste.
								</p>
								<button href="#" class="btn btn-primary">Buy</button>
							</div>
						</div>
					</div>

					<div class="col-md-4">
						<div class="card img-hover">
							<img class="card-img-top img-responsive" src="images/pulses.png" alt="Card image">
							<div class="card-body">
								<h4 class="card-title">Pulses</h4>
								<p class="card-text">Good in taste.Good in taste.Good in taste.Good in taste.Good in taste.Good in taste.Good in taste.
								</p>
								<button href="#" class="btn btn-primary">Buy</button>
							</div>
						</div>
					</div>

					<div class="col-md-4">
						<div class="card img-hover">
							<img class="card-img-top img-responsive" src="images/pulses.png" alt="Card image">
							<div class="card-body">
								<h4 class="card-title">Pulses</h4>
								<p class="card-text">Good in taste.Good in taste.Good in taste.Good in taste.Good in taste.Good in taste.Good in taste.
								</p>
								<button href="#" class="btn btn-primary">Buy</button>
							</div>
						</div>
					</div>
				</div>

				<div class="row">
					<div class="col-md-4">
						<div class="card img-hover">
							<img class="card-img-top img-responsive" src="images/pulses.png" alt="Card image">
							<div class="card-body">
								<h4 class="card-title">Pulses</h4>
								<p class="card-text">Good in taste.Good in taste.Good in taste.Good in taste.Good in taste.Good in taste.Good in taste.
								</p>
								<button href="#" class="btn btn-primary">Buy</button>
							</div>
						</div>
					</div>

					<div class="col-md-4">
						<div class="card img-hover">
							<img class="card-img-top img-responsive" src="images/pulses.png" alt="Card image">
							<div class="card-body">
								<h4 class="card-title">Pulses</h4>
								<p class="card-text">Good in taste.Good in taste.Good in taste.Good in taste.Good in taste.Good in taste.Good in taste.
								</p>
								<button href="#" class="btn btn-primary">Buy</button>
							</div>
						</div>
					</div>

					<div class="col-md-4">
						<div class="card img-hover">
							<img class="card-img-top img-responsive" src="images/pulses.png" alt="Card image">
							<div class="card-body">
								<h4 class="card-title">Pulses</h4>
								<p class="card-text">Good in taste.Good in taste.Good in taste.Good in taste.Good in taste.Good in taste.Good in taste.
								</p>
								<button href="#" class="btn btn-primary">Buy</button>
							</div>
						</div>
					</div>
				</div>
			</div>-->

		<!-- Container 4 Start -->
			<!--<div class="container-fluid cardcar2">
				<div class="row title">
					<strong>Offers Comming Soon</strong>
				</div>

				<div class="row">
					<div class="col-md-3">
						<div class="card img-hover">
							<img class="card-img-top img-responsive" src="images/pulses.png" alt="Card image">
							<div class="card-body">
								<h4 class="card-title">Pulses</h4>
								<p class="card-text">Good in taste.Good in taste.Good in taste.Good in taste.Good in taste.Good in taste.Good in taste.
								</p>
								<button href="#" class="btn btn-primary">Buy</button>
							</div>
						</div>
					</div>

					<div class="col-md-3">
						<div class="card img-hover">
							<img class="card-img-top img-responsive" src="images/pulses.png" alt="Card image">
							<div class="card-body">
								<h4 class="card-title">Pulses</h4>
								<p class="card-text">Good in taste.Good in taste.Good in taste.Good in taste.Good in taste.Good in taste.Good in taste.
								</p>
								<button href="#" class="btn btn-primary">Buy</button>
							</div>
						</div>
					</div>

					<div class="col-md-3">
						<div class="card img-hover">
							<img class="card-img-top img-responsive" src="images/pulses.png" alt="Card image">
							<div class="card-body">
								<h4 class="card-title">Pulses</h4>
								<p class="card-text">Good in taste.Good in taste.Good in taste.Good in taste.Good in taste.Good in taste.Good in taste.
								</p>
								<button href="#" class="btn btn-primary">Buy</button>
							</div>
						</div>
					</div>

					<div class="col-md-3">
						<div class="card img-hover">
							<img class="card-img-top img-responsive" src="images/pulses.png" alt="Card image">
							<div class="card-body">
								<h4 class="card-title">Pulses</h4>
								<p class="card-text">Good in taste.Good in taste.Good in taste.Good in taste.Good in taste.Good in taste.Good in taste.
								</p>
								<button href="#" class="btn btn-primary">Buy</button>
							</div>
						</div>
					</div>
				</div>

				<div class="row">
					<div class="col-md-3">
						<div class="card img-hover">
							<img class="card-img-top img-responsive" src="images/pulses.png" alt="Card image">
							<div class="card-body">
								<h4 class="card-title">Pulses</h4>
								<p class="card-text">Good in taste.Good in taste.Good in taste.Good in taste.Good in taste.Good in taste.Good in taste.
								</p>
								<button href="#" class="btn btn-primary">Buy</button>
							</div>
						</div>
					</div>

					<div class="col-md-3">
						<div class="card img-hover">
							<img class="card-img-top img-responsive" src="images/pulses.png" alt="Card image">
							<div class="card-body">
								<h4 class="card-title">Pulses</h4>
								<p class="card-text">Good in taste.Good in taste.Good in taste.Good in taste.Good in taste.Good in taste.Good in taste.
								</p>
								<button href="#" class="btn btn-primary">Buy</button>
							</div>
						</div>
					</div>

					<div class="col-md-3">
						<div class="card img-hover">
							<img class="card-img-top img-responsive" src="images/pulses.png" alt="Card image">
							<div class="card-body">
								<h4 class="card-title">Pulses</h4>
								<p class="card-text">Good in taste.Good in taste.Good in taste.Good in taste.Good in taste.Good in taste.Good in taste.
								</p>
								<button href="#" class="btn btn-primary">Buy</button>
							</div>
						</div>
					</div>

					<div class="col-md-3">
						<div class="card img-hover">
							<img class="card-img-top img-responsive" src="images/pulses.png" alt="Card image">
							<div class="card-body">
								<h4 class="card-title">Pulses</h4>
								<p class="card-text">Good in taste.Good in taste.Good in taste.Good in taste.Good in taste.Good in taste.Good in taste.
								</p>
								<button href="#" class="btn btn-primary">Buy</button>
							</div>
						</div>
					</div>
				</div>
			</div>-->

			<!-- Container 5 Start -->
			<!--<div class="container cardcar2">
				<div class="row title">
					<strong>Discounts Offers</strong>
				</div>

				<div class="row">
					<div class="col-md-3">
						<div class="card img-hover">
							<img class="card-img-top img-responsive" src="images/pulses.png" alt="Card image">
							<div class="card-body">
								<h4 class="card-title">Pulses</h4>
								<p class="card-text">Good in taste.Good in taste.Good in taste.Good in taste.Good in taste.Good in taste.Good in taste.
								</p>
								<button href="#" class="btn btn-primary">Buy</button>
							</div>
						</div>
					</div>

					<div class="col-md-3">
						<div class="card img-hover">
							<img class="card-img-top img-responsive" src="images/pulses.png" alt="Card image">
							<div class="card-body">
								<h4 class="card-title">Pulses</h4>
								<p class="card-text">Good in taste.Good in taste.Good in taste.Good in taste.Good in taste.Good in taste.Good in taste.
								</p>
								<button href="#" class="btn btn-primary">Buy</button>
							</div>
						</div>
					</div>

					<div class="col-md-3">
						<div class="card img-hover">
							<img class="card-img-top img-responsive" src="images/pulses.png" alt="Card image">
							<div class="card-body">
								<h4 class="card-title">Pulses</h4>
								<p class="card-text">Good in taste.Good in taste.Good in taste.Good in taste.Good in taste.Good in taste.Good in taste.
								</p>
								<button href="#" class="btn btn-primary">Buy</button>
							</div>
						</div>
					</div>

					<div class="col-md-3">
						<div class="card img-hover">
							<img class="card-img-top img-responsive" src="images/pulses.png" alt="Card image">
							<div class="card-body">
								<h4 class="card-title">Pulses</h4>
								<p class="card-text">Good in taste.Good in taste.Good in taste.Good in taste.Good in taste.Good in taste.Good in taste.
								</p>
								<button href="#" class="btn btn-primary">Buy</button>
							</div>
						</div>
					</div>
				</div>
			</div><hr/>-->

			<!-- Footer Start -->
			<!--<footer>
				<h4 class="text-center">6 days ago</h4>
			</footer>

		</div>-->

		

	</body>
</html>