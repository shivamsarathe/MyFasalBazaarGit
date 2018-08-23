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
		<link rel="stylesheet" href="css/help.css"/>
		
	</head>

	<body>
		<%@ include file="header_main.jsp"%>

				<!-- Container 2 Start -->
			<div class="container cardcar2" style="margin-top:-12px">
				<div class="row ">
					<div class="col-md-6 title2">
						<strong>Ask Whatever You Want</strong>
					</div>
				</div>

			

				<div class="row">
					<div class="col-md-12">
						<div class="card img-hover">
							<select class="dropdown form-control" id="education" name="education" style="border-radius:25px;padding:5px;">
								<option value="" selected="selected" disabled="disabled">-- select one --</option>
								<option value="No formal education">t</option>
								<option value="Primary education">e</option>
								<option value="Secondary education">ds</option>
								<option value="GED">Sp</option>
							</select>

							<input type="text" class="form-control" placeholder="Specify Other Help" style="border-radius:25px;padding:5px;margin-top:10px"/>

							<button type="submit" class="btn btn-success " style="padding:5px;margin-top:10px;width:25%;border-radius:25px">Help</button>

							<div></div>
							
						</div>
					</div>
				</div>
			</div>

	</body>
</html>