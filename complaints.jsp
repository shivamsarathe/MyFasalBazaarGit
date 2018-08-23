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
		<link rel="stylesheet" href="css/complaints.css"/>
		
		
	</head>

	<body>
		<%@ include file="header_main.jsp"%>

				<!-- Container 2 Start -->
			<div class="container cardcar2" style="margin-top:-12px">
				<div class="row ">
					<div class="col-md-6 title2">
						<strong>Complaint Box</strong>
					</div>
				</div>

				<div class="row">
					<div class="col-md-12">
						<div class="card img-hover">
							<form class="form-horizontal" action="/action_page.php">
								<div class="form-group">
									<label class="control-label col-sm-3 text-center" for="name"><span class="text-danger ">* </span>First Name:</label>
									<div class="col-sm-9">
									  <input type="text" class="form-control control" id="name" placeholder="Eg. Shivam" required>
									</div>
								</div>
							
								<div class="form-group">
									<label class="control-label col-sm-3" for="pwd"><span class="text-danger ">* </span>Last Name:</label>
									<div class="col-sm-9"> 
									  <input type="text" class="form-control control" id="pwd" placeholder="Eg. Sarathe" required>
									</div>
								</div>

								<div class="form-group">
									<label class="control-label col-sm-3" for="pwd"><span class="text-danger ">* </span>Mobile No:</label>
									<div class="col-sm-9"> 
									  <input type="number" class="form-control control" id="num" placeholder="8236872256" required>
									</div>
								</div>

								<div class="form-group">
									<label class="control-label col-sm-3" for="pwd"><span class="text-danger ">* </span>Email:</label>
									<div class="col-sm-9"> 
									  <input type="email" class="form-control control" id="email" placeholder="Eg. abc@gmail.com">
									</div>
								</div>

								<div class="form-group">
									<label class="control-label col-sm-3" for="pwd"><span class="text-danger ">* </span>Complaint:</label>
									<div class="col-sm-9">
										<textarea class="form-control" rows="5" id="comment" style="width:50%;border-radius:25px"></textarea>
									</div>
								</div>

								<div class="form-group">
									<div class="col-sm-2">
									</div>
									
									<div class="col-sm-5" style="margin-top:10px;">
										<button type="submit" class="btn btn-success">Submit</button>
										
									</div>
								</div>

								
							</form>

						</div>
					</div>

					
				</div>
			</div>

	</body>
</html>