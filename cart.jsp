<%@ page import="java.util.ArrayList"%>
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
		<script src="js/deletecart.js"></script>

		<!-- MY CSS -->
		<link rel="stylesheet" href="css/cart.css"/>
		
	</head>

	<body>
		<%@ include file="header_main.jsp"%>

				<!-- Container 2 Start -->
			<div class="container cardcar2" style="margin-top:-12px">
				<div class="row ">
					<div class="col-md-6 title2">
						<strong>Your Cart</strong>
					</div>
				</div>
					
				<c:forEach var="cart" items="${carts}">
				<div class="row">
				
					<div class="col-md-12" id="hide${cart.cartId}">
						<div class="card img-hover">
							<div class="row">
								<div class="col-md-3">
									<img class="card-img-top" src="crop_pic.do?picPath=${cart.cartItem.commodity.commodityPics.picPath}" alt="Card image" style="width:300px;height:300px">
								</div>
								
								<div class="col-md-1">
								</div>
								
								<div class="col-md-8">
									<div class="card-body">
										<h4 class="card-title text-left"><strong >${cart.cartItem.commodity.commodity}</strong></h4>
										<p class="card-text text-left">Mrp: ${cart.cartItem.commodity.mrp}</p>
										<p class="card-text text-left">Quantity: ${cart.cartItem.commodity.quantity}</p>
										<p class="card-text text-left">Added Date: ${cart.cartDate}</p>
										<p class="card-text text-left">Seller: <a href="seller_profile.do?user_id=${cart.cartItem.commodity.user.userId}"><span class="text-capitalize">${cart.cartItem.commodity.user.userName}</span></a></p>
						</p>
										
										<button class="btn btn-danger" id="delete${cart.cartId}" >Delete</button>
										<a href="buy_crop.do?commodityId=${cart.cartItem.commodity.commodityId}" class="btn btn-primary pull-left">Buy</a>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div> 
				</c:forEach>
				

				

			<!--	<div class="row">
					<div class="col-md-12">
						<div class="card img-hover">
							<div class="row">
								<div class="col-md-3">
									<img class="card-img-top" src="images/pulses.png" alt="Card image">
								</div>
								
								<div class="col-md-1">
								</div>
								
								<div class="col-md-8">
									<div class="card-body">
										<h4 class="card-title text-left"><strong>XYZ Fasal:</strong></h4>
										<p class="card-text text-left">Some example text.</p>
										<p class="card-text text-left">Some example text.</p>
										<p class="card-text text-left">Some example text.</p>
										<p class="card-text text-left">Some example text.</p>
										<p class="card-text text-left">Some example text.</p>
										<a href="#" class="btn btn-primary pull-left">Buy</a>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>

				<!--<div class="row">
					<div class="col-md-12">
						<div class="card img-hover">
							<div class="row">
								<div class="col-md-3">
									<img class="card-img-top" src="images/pulses.png" alt="Card image">
								</div>
								
								<div class="col-md-1">
								</div>
								
								<div class="col-md-8">
									<div class="card-body">
										<h4 class="card-title text-left"><strong>XYZ Fasal:</strong></h4>
										<p class="card-text text-left">Some example text.</p>
										<p class="card-text text-left">Some example text.</p>
										<p class="card-text text-left">Some example text.</p>
										<p class="card-text text-left">Some example text.</p>
										<p class="card-text text-left">Some example text.</p>
										<a href="#" class="btn btn-primary pull-left">Buy</a>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>-->
			
			<%ArrayList cart = (ArrayList)session.getAttribute("carts"); %>
			<%	int i = cart.size(); %>
			<%if(i>0){%>
			<span class="form-control" style="margin-top:15px;width:50%;background-color:#3399ff;color:white;border-radius:20px" id="amount">Total Amount: ${carts.get(i).cartAmount }</span>
			
			<a class="btn btn-primary form-control" style="margin-top:20px;font-size:15px;border-radius:20px" id="plc">Place Order</a>
			<%}else{%>
			<div style="color:#00ccff;font-size:30px" id="msg">You Have Not Added Anything Yet</div>
			<%}%>

	</body>
</html>