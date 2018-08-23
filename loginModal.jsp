<link rel="stylesheet" href="css/logsign.css"/>
<!-- Login modal -->
		<div class="modal fade round" id="loginModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
			<div class="modal-dialog modal-lg" role="document">
				<div class="modal-content reglog  img1">
					<div class="modal-header ">
						<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true"><strong> &times; </strong></span></button>
						
						<h3 class="modal-title text-center" id="myModalLabel"><strong>LOGIN</strong></h3>
					</div>
						
					<form action="login.do" method="post">
						<div class="modal-body" align="center">
							<div class="container-fluid">
								<div class="form-group">
									<input type="text" class="rounded" id="contact" name="contact" placeholder="Mobile No.">
								</div>
								  
								<div class="form-group">
									<input type="password" class="rounded" id="pwd" id="contactpassword" name="password" placeholder="Password">
								</div>

								<button class="button button1 btn-success">Login</button>
								<button class="button button1 btn-success">Forget Password?</button>
							</div>
							  
							<div class="modal-footer">
								<button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
							</div>
						</div>
					</form>
				
				</div>
			</div>
			
		</div>
<!-- Login modal end-->