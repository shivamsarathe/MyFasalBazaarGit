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
		<script src="js/myjs.js"></script>
		<script src="js/cart.js"></script>
		
		<!-- MY CSS -->
		<link rel="stylesheet" href="css/mystyle.css"/>
		<link rel="stylesheet" href="css/index.css"/>
		<link rel="stylesheet" href="css/hover.css"/>
		
		

		<!-- Sidebar jsp -->
		<link rel="stylesheet" href="css/sidebar.css"/>
		<script src="js/sidebar.js"></script>
		<script src="js/validation.js"></script>
		<script src="js/modal_signup.js"></script>
	</head>

	<body>
	

	<%@include file="showCropsDescription.jsp"%>
		

		<%@ include file="dropdown.jsp"%>

		<div id="main">
			<!--Header start-->

			<%@ include file="header_main.jsp"%>
			<%@ include file="header.jsp"%>

			<!--SignUp - LogIn Modal start-->

			<%@ include file="loginModal.jsp"%>																			
			<%@ include file="signupModal.jsp"%>

			<%@ include file="filter.jsp"%>
			<!--  validation   ----->
			<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
			<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
			<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>			
			<% int card = 0; %>
			<%if(session.getAttribute("valid_login")!=null){%>
				<% boolean login = ((Boolean)session.getAttribute("valid_login")).booleanValue();%>
				<%if(login){%>
				<div class="alert alert-success alert-dismissible">
				  <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
				  <strong>Success!</strong> Indicates a successful or positive action.
				</div>
				<%}else{%>
				<div class="alert alert-danger">
					<strong>Danger!</strong> This alert box could indicate a dangerous or potentially negative action.
				</div>
				<%}%>
			<%}%>
			
			<%if(session.getAttribute("valid_registration")!=null){%>
				<% boolean register = ((Boolean)session.getAttribute("valid_registration")).booleanValue();%>
				<%= register%>
				<%if(register){%>
				<div class="alert alert-success alert-dismissible">
				  <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
				  <strong>Success!</strong> Indicates a successful or positive action.
				</div>
				<%}else{%>
				<div class="alert alert-danger">
					<strong>Danger!</strong> This alert box could indicate a dangerous or potentially negative action.
				</div>
				<%}%>
			<%}%>	
	<!-- Container 1 Start -->
			<div class="container-fluid common" id="0">
				<div class="row">
					<div class="col-md-12">
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
				
					
				</div>
			</div>
			
			
		<!-- Container 2 Start -->
		
			<!-- <div class="container-fluid cardcar2" id="2">
				<div class="row title">
					<strong>Discounts Offers</strong>
				</div> -->
				
				
				<%@ include file="testing2.jsp"%>
			<!-- </div> -->
				<hr/>

			<!-- Footer Start -->
				<footer>
					<h4 class="text-center">6 days ago</h4>
				</footer>

		</div>
	</body>
</html>