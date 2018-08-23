<!-- Main Header -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="models.User" %>

<%User user = (User)session.getAttribute("user");%>


	<header class="main-header">
		<nav class="navbar navbar-inverse " style="padding:0px;background: linear-gradient(to top right, #000000 11%, #199999 75%);">
			<div class="container-fluid">
				<div class="navbar-header" >
					<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span> 
					</button>
				  
					<img src="images/fasallogo1.png" class="img-responsive logo" style="width:35%"/>
				</div>
				
				<div class="collapse navbar-collapse" id="myNavbar" style="margin-top:15px">
					<ul class="nav navbar-nav">
						<li align="center" style="margin-top:15px;"><!-- Goggle translator -->
						   <div id="google_translate_element" align="right">
						   </div>

							<script type="text/javascript">
								function googleTranslateElementInit() {
								 new google.translate.TranslateElement({pageLanguage: 'en', layout: google.translate.TranslateElement.InlineLayout.SIMPLE}, 'google_translate_element');
							   }
							</script>

							<script type="text/javascript" src="//translate.google.com/translate_a/element.js?cb=googleTranslateElementInit"></script>
						</li>
							
						<li >
							<a href="home.do"><span class="glyphicon glyphicon-home"></span>&nbsp;Home</a>
						</li>
						<%if(user!=null){%>	
							<%if(user.getUserType().getUserTypeId()==1){%>
							<li>
								<a href="#" data-toggle="modal" data-target="#myModal" style="outline:none"><i class="glyphicon glyphicon-filter">Filter</i>
								</a>
							</li>
							<%}else{%>
							<li>
								<a href="crop_order.do" style="outline:none"><i class="glyphicon glyphicon-road">Order</i>
								</a>
							</li>								
							<%}%>
						<%}else{%>
						<li>
							<a href="#" data-toggle="modal" data-target="#myModal" style="outline:none"><i class="glyphicon glyphicon-filter">Filter</i>
							</a>
						</li>							
						<%}%>
					</ul>

					<ul class="nav navbar-nav">
						<li>
							<form class="navbar-form navbar-left" action="search_bar.do">
								<div class="input-group">
											
									<input type="text" class="form-control" placeholder="Search" style="border-radius:50px" id="search_btn" name="search"/>
											
									<div class="input-group-btn">
										<button class="btn btn-default" id="submit" type="submit" style="border-radius:60px;border:none;align:right">
											<i class="glyphicon glyphicon-search" style=""></i>
										</button>
									</div>
								</div>
										
								<div class="search_menu" style="color:white;background-color:#6600ff;border-radius:50px;text-align:center;display:block;cursor:pointer;">
								</div>
							</form>
						</li>
					</ul>

					<ul class="nav navbar-nav navbar-right">
						<%int k=0;%>
							<c:forEach var="k" items="${notification}">
								<%k=k+1;%>
							</c:forEach>
						<%if(user!=null){%>
							<%if(user.getUserType().getUserTypeId()==2){%>
								<li class="dropdown">
									<a class="dropdown-toggle" data-toggle="dropdown" href="#" style="color:white"><span class="glyphicon glyphicon-comment" ><span class="badge" style="background:red;position:relative;top:-12px;"><%= k%>
												
									</span></span>Notification
									<span class="caret"></span>
									</a>
								
									<a href=""><ul class="dropdown-menu" style="width:250px;background-color:#eeeeee;border-radius:5px;opacity:0.95;">
										
										<c:forEach var="notify" items="${notification}">
											
										<li>
											<div id="notification${notify.user.userId}" style="box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);padding:5px;">
											<!-- <button type="button" class="close" data-dismiss="modal" aria-label="Close" style="color:red;"><span aria-hidden="true"><strong> &times; </strong></span></button> -->
											<small>
												<span style="color:blue; sfont-weight:bold;">${notify.user.userName}
												</span> ordered 
												<span style="color:#fa0505; font-weight:bold;">${notify.commodity.commodity}</span> quantity 
												<span style="color:green; font-weight:bold;">${notify.quantity} 
												kg</span> from 
												<span style="color:#9900ff; font-weight:bold;">${notify.city.city}
												</span> pincode ${notify.pinCode}<br />&nbsp;&nbsp;&nbsp;<span class="glyphicon glyphicon-hand-right" style="font-size:14px;color:red;font-weight:bold;"></span><a id="notify" href="farmerinvoice.do" style="text-decoration:none;" > click here for Invoice </a></small>
											</div>
										</li>
										</c:forEach>
										
									</ul></a>
								</li>
							<%}else {%>
							<li> 	
								<a href="cart.do" id="cart" style="color:white;cursor:pointer;"> Cart <i class="glyphicon glyphicon-shopping-cart"><span class="badge" style="background:red;position:relative;top:-12px;" id="cart_sp">${items}
								</span> </i></a>
							</li>								
								
							<%}%>
						<%}else{%>
							<li>
								<a href="#" data-toggle="modal" data-target="#loginModal" style="outline:none;color:white;">Cart <i class="glyphicon glyphicon-shopping-cart"><span class="badge" style="background:red;position:relative;top:-12px;">0
										
							</span> </i>
								</a>
							</li>
						<%}%>

						<li class="dropdown">
							<a class="dropdown-toggle" data-toggle="dropdown" href="#" style="color:white">Services
							<span class="caret"></span></a>
									
							<ul class="dropdown-menu">
								<li><a href="help.do">Help?</a></li>
								<li><a <%if(user!=null){%> href="complaints.do" <%}else{%> data-toggle="modal" data-target="#loginModal"<%}%> style="cursor:pointer">Complaints</a></li>
								<li><a href="aboutUs.do">About Us</a></li>
							</ul>
						</li>
					
								<!-- <li><a <%if(user!=null){%>href="cart.do"<%}else{%> data-toggle="modal" data-target="#loginModal"<%}%>id="cart" style="color:white;cursor:pointer;">
								
									 
									<span class="glyphicon glyphicon-shopping-cart"><sup id="cart_sp" style="vertical-align:4px;color:white;font-size:20px;font-weight:bold"><span class="badge" style="background:red;">${items}</span></sup></span>Cart
									</li> -->
								
						<li class="dropdown">
							<a class="dropdown-toggle" data-toggle="dropdown" href="#"			style="color:white"><%if(user!=null){%>
							<% String proPic = user.getProfilePic();  %>
								<span style="font-size:1vw;">${user.userName}</span>&nbsp;<img src='<%= proPic!=null?"mypic.do":"images/14.jpg" %>' style="border-radius:50%;" width="20px" height="20px" /><%}else{%><i class="glyphicon glyphicon-user"></i><%}%>
								<span class="caret"></span>
							</a>
							
							<ul class="dropdown-menu">

								<%if(user!=null){%>
								<li><a href="logout.do"><i class="glyphicon glyphicon-log-in"></i>&nbsp Sign Out </a></li>

								<li><a href="profile.do"><i class="glyphicon glyphicon-log-in"></i>&nbsp Profile </a></li>
									<%if(user.getUserType().getUserTypeId()==1){%>
								<li><a href="user_order.do"><i class="glyphicon glyphicon-tasks"></i>&nbsp Your Orders </a></li>
								<li><a href="user_profile.do"><i class="glyphicon glyphicon-tasks"></i>&nbsp DashBoard </a></li>
								<li><a href="userInvoice.do"><i class="glyphicon glyphicon-tasks"></i>&nbsp Your Invoices </a></li>
									<%}%>
								<%}else{%>
								<li><a href="#" data-toggle="modal" data-target="#loginModal"><i class="glyphicon glyphicon-log-in"></i>&nbsp Sign In as Existing User</a></li>
								<li><a href="#" data-toggle="modal" data-target="#signupModal"><i class="glyphicon glyphicon-user"></i>&nbsp Sign Up as New User</a></li>
								<li><a href="#"><i class="glyphicon glyphicon-wrench"></i>&nbsp Settings</a></li><hr/>										
								<%}%>
								<!-- <li>
									<a href="#"><i class="glyphicon glyphicon-phone"></i>&nbsp Download App</a>
									</li> -->
							</ul>
						</li>							
					</ul>
				</div>
			</div>
		</nav>
	</header>
	<!-- end Header -->