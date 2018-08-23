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
		<script src="js/signup.js"></script>

		<!-- MY CSS -->
		<link rel="stylesheet" href="css/mystyle.css"/>
		<link rel="stylesheet" href="css/index.css"/>
		<link rel="stylesheet" href="css/userFarmerSignup.css"/>
	</head>

	<body>
		<%@ include file="headerUserFarmer.jsp"%>

				<!-- Container 2 Start -->
			<div class="container-fluid cardcar2" style="margin-top:-12px">
				<div class="row ">
					<div class="col-md-6 title2">
						<strong>Fill As A User<span class="small text-danger"> (Not Mandatory)</span></strong>
					</div>

					<div class="col-md-6 title2">
						<strong>Fill As A Farmer</strong>
					</div>
				</div>

				<div class="row">
					<h5><span class="text-danger ">* </span>Fields are mandatory</h5>
					<div class="col-md-6">
						<div class="card img-hover">
							<form class="form-horizontal" action="UserRegistrationServlet.do">
								<div class="form-group">
									<label class="control-label col-sm-3 text-center" for="name"><span class="text-danger ">* </span>First Name:</label>
									<div class="col-sm-9">
									  <input type="text" name="txt_fn1" class="form-control control" id="name" placeholder="Eg. Shivam" required>
									</div>
								</div>
							
								<div class="form-group">
									<label class="control-label col-sm-3" for="pwd"><span class="text-danger ">* </span>Last Name:</label>
									<div class="col-sm-9"> 
									  <input type="text" name="txt_ln1" class="form-control control" id="pwd" placeholder="Eg. Sarathe" required>
									</div>
								</div>

								<div class="form-group">
									<label class="control-label col-sm-3"  for="pwd"><span class="text-danger ">* </span>Mobile No:</label>
									<div class="col-sm-9"> 
									  <input type="text" name="txt_mn1" class="form-control control" id="num" placeholder="8236872256" required>
									</div>
								</div>

								<div class="form-group">
									<label class="control-label col-sm-3" for="pwd">Email:</label>
									<div class="col-sm-9"> 
									  <input type="email" name="txt_ea1" class="form-control control" id="email" placeholder="Eg. abc@gmail.com">
									</div>
								</div>

								<div class="form-group">
									<label class="control-label col-sm-3" for="pwd"><span class="text-danger ">* </span>Password:</label>
									<div class="col-sm-9"> 
									  <input type="password" name="txt_p1" class="form-control control" id="pwd" placeholder="Enter Password" required>
									</div>
								</div>

								<div class="form-group">
									<label class="control-label col-sm-3" for="pwd"><span class="text-danger ">* </span>Confirm Password:</label>
									<div class="col-sm-9"> 
									  <input type="password" name="txt_cp1" class="form-control control" id="pwd" placeholder="ReType Password" required>
									</div>
								</div>
						  
								<div class="form-group">
									<div class="col-sm-2">
									</div>
									
									<div class="col-sm-5" style="margin-top:10px;">
										<button type="submit" class="btn btn-success">Submit</button>
										<button type="submit" class="btn btn-success">Cancel</button>
										<button type="submit" class="btn btn-default">Skip</button>
									</div>
								</div><hr/>

								<div class="form-group">
									
									<div class="col-sm-5">
										<a><img class="img-responsive btnheight" src="images/google_button.png"/></a>
									</div>

									<div class="col-sm-1">
										<h4 class="mtop"><strong class="text-danger ">OR</strong></h4>
									</div>
									
									<div class="col-sm-5">
										<a><img class="img-responsive btnheight" src="images/fbButton.png"/></a>
									</div>
								</div>
							</form>

						</div>
					</div>

					<div class="col-md-6">
						<div class="card img-hover">
							<form class="form-horizontal" action="FarmerRegistrationServlet.do">
								<div class="form-group">
									<label class="control-label col-sm-3 text-center" for="name"><span class="text-danger ">* </span>First Name:</label>
									<div class="col-sm-9">
									  <input type="text" name="txt_fn" class="form-control control" id="name" placeholder="Eg. Shivam" required>
									</div>
								</div>
							
								<div class="form-group">
									<label class="control-label col-sm-3" for="pwd"><span class="text-danger ">* </span>Last Name:</label>
									<div class="col-sm-9"> 
									  <input type="text" name="txt_ln" class="form-control control" id="pwd" placeholder="Eg. Sarathe" required>
									</div>
								</div>

								<div class="form-group">
									<label class="control-label col-sm-3" for="pwd"><span class="text-danger ">* </span>Mobile No:</label>
									<div class="col-sm-9"> 
									  <input type="text" name="txt_mn" class="form-control control" id="num1" placeholder="8236872256" required>
									</div>
								</div>

								<div class="form-group">
									<label class="control-label col-sm-3" for="pwd"><span class="text-danger ">* </span>Aadhar No:</label>
									<div class="col-sm-9"> 
									  <input type="text" name="txt_an" class="form-control control" id="num" placeholder="1234 5678 1234 5678" required>
									</div>
								</div>

								<div class="form-group">
									<label class="control-label col-sm-3" for="pwd"><span class="text-danger ">* </span>Kisan No:</label>
									<div class="col-sm-9"> 
									  <input type="text" name="txt_num" class="form-control control" id="num" placeholder="A123fghh" required>
									</div>
								</div>

								<div class="form-group">
									<label class="control-label col-sm-3" for="pwd">Email:</label>
									<div class="col-sm-9"> 
									  <input type="email" name="txt_ea" class="form-control control" id="email" placeholder="Eg. abc@gmail.com">
									</div>
								</div>

								<div class="form-group">
									<label class="control-label col-sm-3" for="pwd"><span class="text-danger ">* </span>Password:</label>
									<div class="col-sm-9"> 
									  <input type="password" name="txt_p" class="form-control control" id="pwd" placeholder="Enter Password" required>
									</div>
								</div>

								<div class="form-group">
									<label class="control-label col-sm-3" for="pwd"><span class="text-danger ">* </span>Confirm Password:</label>
									<div class="col-sm-9"> 
									  <input type="password" name="txt_cp" class="form-control control" id="pwd" placeholder="ReType Password" required>
									</div>
								</div>
						  
								<div class="form-group" >
									<div class="col-sm-2">
									</div>
									
									<div class="col-sm-5">
										<button type="submit" class="btn btn-success">Submit</button>
										<button type="submit" class="btn btn-success">Cancel</button>				
									</div>
								</div>
							</form>

						</div>
					</div>
				</div>
			</div>

	</body>
</html>