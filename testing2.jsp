

		<link rel="stylesheet" href="css/testing2.css"/>
		<script src="js/testing2.js"></script>
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	

		<div class="container-fluid">
			<div class='row'>
				<div class='col-md-12'>
					<div class="carousel slide media-carousel media-carousel1" id="media">
						<div class="carousel-inner">
							
							<!-- <div class="item  active">
								<div class="row">
									<%for(card=0;card<=5;card++){%>
									<div class="col-md-2" id="<%=card%><%=card%>">
												
										<div class="card img-hover">
											<img class="card-img-top img-responsive" src="images/pulses.png" style="width:200px;height:150px" alt="Card image" id="image<%= card%>"/>
													
											<div class="card-body" style="text-align:center;">
												<h5 class="card-title commodity commodity<%= card %>" style="color:#1f2021;font-weight:bold;text-align:center;"></h5>
												<h3 class="card-title mrp mrp<%= card %>" style="color:green;font-weight:bold;"></h3>
												<h5 class="card-title quantity quantity<%= card %>" style="color:red;font-weight:bold;"></h5>
												<p class="card-text description description<%= card %>"></p>
												<p class="card-text qtLeft qtLeft<%= card %>"></p>
												<p><span>Seller </span><a href="#" class="farmer<%= card%>" style="text-decoration:none;"></a></p>
												
												<a class="btn btn-primary buy<%= card%>" style="float:left;">Buy</a>
												<button href="#" class="btn btn-success cart<%= card%>" id="" style="width:102px;text-align:center;">Add to Cart</button>	
												
							
												
											</div>
										</div>
									</div>
									<%}%>
								</div>
							</div> -->
					
							<div class="item active">
								<div class="row">
									<%for(card=0;card<=5;card++){%>
									<div class="col-md-2" id="<%=card%><%=card%>">
										
					
										<div class="card img-hover">
											<img class="card-img-top img-responsive" src="images/pulses.png" style="width:200px;height:150px" alt="Card image" id="image<%= card%>"/>
						
											<div class="card-body" style="text-align:center;">
												<h5 class="card-title commodity commodity<%= card %>" style="color:#1f2021;font-weight:bold;text-align:center;">
												</h5>
												
												<h3 class="card-title mrp mrp<%= card %>" style="color:green;font-weight:bold;"></h3>
												
												<h5 class="card-title quantity quantity<%= card %>" style="color:red;font-weight:bold;"></h5>
												
												<p class="card-text description description<%= card %>">
												</p>
												
												<p class="card-text qtLeft qtLeft<%= card %>">
												</p>
												
												<p><a href="#" class="farmer<%= card%>" style="text-decoration:none;"></a>
												</p>
												
												<a class="btn btn-primary buy<%= card%>" style="float:left;">Buy
												</a>
												
												<a href="#" class="btn btn-success cart<%= card%>" id="" style="width:102px;text-align:center;">Add to Cart
												</a>			
												
											</div>
										</div>
									</div>
									<%}%>        
								</div>
							</div>


							<div class="item ">
								<div class="row">
									<%for(card=6;card<=11;card++){%>
									<div class="col-md-2" id="<%=card%><%=card%>">
										
					
										<div class="card img-hover">
											<img class="card-img-top img-responsive" src="images/pulses.png" style="width:200px;height:150px" alt="Card image" id="image<%= card%>"/>
						
											<div class="card-body" style="text-align:center;">
												<h5 class="card-title commodity commodity<%= card %>" style="color:#1f2021;font-weight:bold;text-align:center;">
												</h5>
												
												<h3 class="card-title mrp mrp<%= card %>" style="color:green;font-weight:bold;"></h3>
												
												<h5 class="card-title quantity quantity<%= card %>" style="color:red;font-weight:bold;"></h5>
												
												<p class="card-text description description<%= card %>">
												</p>
												
												<p class="card-text qtLeft qtLeft<%= card %>">
												</p>
												
												<p><a href="#" class="farmer<%= card%>" style="text-decoration:none;"></a>
												</p>
												
												<a class="btn btn-primary buy<%= card%>" style="float:left;">Buy
												</a>
												
												<a href="#" class="btn btn-success cart<%= card%>" id="" style="width:102px;text-align:center;">Add to Cart
												</a>			
												
											</div>
										</div>
									</div>
									<%}%>        
								</div>
							</div>
				  
							
						</div>
				
						<a data-slide="prev" href="#media" class="left carousel-control carousel-control1">‹</a>
						<a data-slide="next" href="#media" class="right carousel-control carousel-control1">›</a>
					</div>                          
				</div>
			</div>
		</div>
	