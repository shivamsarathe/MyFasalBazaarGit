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
		<script src="js/cart.js"></script>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
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
			<div class="container-fluid common">
				<div class="row">
					<div class="col-md-2">
						<div class="card">
							<img class="card-img-top img-responsive" src="images/pulses.png" alt="Card image">
							<div class="card-body">
								<h4 class="card-title">Pulses</h4>
								<p class="card-text">Good in taste.Good in taste.Good in taste.Good in taste.Good in taste.Good in taste.Good in taste.
								</p>
								<a href="#" class="btn btn-primary">Buy</a>
							</div>
						</div>
					</div>

					<div class="col-md-8">
						<div class="cardcar">
							<div id="myCarousel" class="carousel slide" data-ride="carousel" data-interval="1500" style="height:320px">
								<!-- Indicators -->
								<ol class="carousel-indicators">
								  <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
								  <li data-target="#myCarousel" data-slide-to="1"></li>
								  <li data-target="#myCarousel" data-slide-to="2"></li>
								</ol>

								<!-- Wrapper for slides -->
								<div class="carousel-inner">
									<div class="item active">
										<img src="images/vegetables.png" class="img-responsive">
									</div>

									<div class="item">
										<img src="images/pulses.png" class="img-responsive">
									</div>
    
									<div class="item">
										<img src="images/cereals.png" class="img-responsive">
									</div>
								</div>

								<!-- Left and right controls -->
								<a class="left carousel-control" href="#myCarousel" data-slide="prev">
								  <span class="glyphicon glyphicon-chevron-left"></span>
								  <span class="sr-only">Previous</span>
								</a>
    
								<a class="right carousel-control" href="#myCarousel" data-slide="next">
								  <span class="glyphicon glyphicon-chevron-right"></span>
								  <span class="sr-only">Next</span>
								</a>
							</div>
						</div>
					</div>

					<div class="col-md-2">
						<div class="card">
							<img class="card-img-top img-responsive" src="images/pulses.png" alt="Card image">
							<div class="card-body">
								<h4 class="card-title" id="abc">Pulses</h4>
								<p class="card-text">Good in taste.Good in taste.Good in taste.Good in taste.Good in taste.Good in taste.Good in taste.
								</p>
								<a href="#" class="btn btn-primary">Buy</a>
							</div>
						</div>
					</div>
				</div>
			</div>

		<!-- Container 2 Start -->
			<div class="container-fluid cardcar2">
				<div class="row title">
					<strong>Crops</strong>
				</div>
				
				<div class="row">
				<c:forEach var="commodity" items="${commodities}" varStatus="abc">
					<div class="col-md-2">
						<div class="card img-hover">
							<img class="card-img-top img-responsive" src="crop_pic.do?picPath=${commodity.commodityPics.picPath}" alt="Card image" style="height:200px;width:330px">
							<div class="card-body">
								<h4 class="card-title" >${commodity.commodity}</h4>
								<p class="card-text">MRP=${commodity.mrp}</p>
								<p class="card-text">Quantity=${commodity.quantity}</p>
								<p class="card-text">Seller: <a href="seller_profile.do?user_id=${commodity.user.userId}"><span class="text-capitalize">${commodity.user.userName}</span></a></p>
								<a href="buy_crop.do?commodityId=${commodity.commodityId}" class="btn btn-primary">Buy</a>
								<button class="glyphicon glyphicon-shopping-cart btn btn-primary ". id="cart${commodity.commodityId}"> 
								Add to cart</button>
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