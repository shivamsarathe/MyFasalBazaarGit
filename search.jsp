<!doctype html>
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
		 
		 <!-- MY CSS -->
		 <link rel="stylesheet" href="css/mystyle.css"/>
		 <link rel="stylesheet" href="css/index.css"/>
		 <link rel="stylesheet" href="css/hover.css"/>
		 

		 <!-- Sidebar jsp -->
		 <link rel="stylesheet" href="css/sidebar.css"/>
		 <script src="js/sidebar.js"></script>
  <link rel="stylesheet" href="css/session.css"></link>
  <title>Document</title>
 </head>
 <body>
	<%@ include file="header_main.jsp"%>
		<%int card=0;%>
		
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
										<a href="#" class="btn btn-success" style="display:inline;" data-toggle="modal" data-target="#cropsDescription" id="">Supplier</a>

										<button class="glyphicon glyphicon-shopping-cart btn btn-primary ". id="cart${commodity.commodityId}"> 
										Add to cart</button>
									</div>
						
						<!--rating-->
						<div class="rating">

							<span id="star0<%=card%>"></span>
							<span id="star1<%=card%>"></span>
							<span id="star2<%=card%>"></span>
							<span id="star3<%=card%>"></span>
							<span id="star4<%=card%>"></span>
							
						</div>	
						
					</div>
				</div>
			
			<%card++;%>
		</c:forEach>
	
 </body>
</html>
