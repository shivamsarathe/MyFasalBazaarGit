<!-- Login modal -->
		<div class="modal fade " id="signupModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
			<div class="modal-dialog modal-lg" role="document">
				<div class="modal-content reglog img1">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true"><strong>&times;</strong></span></button>
						
						<h3 class="modal-title text-center" id="myModalLabel"><strong>SIGNUP</strong></h3>
					</div>
						
					<form id="form" action="" >
						<div class="modal-body" align="center">
							<div class="container-fluid">
								<div class="form-group">
									<input type="text" class="rounded" id="number_fld" name="contact" placeholder="Mobile No.">
								</div>

								<button type="button" id="generate_btn" class="btn button1 btn-success">Generate OTP</button>
								
								<button type="button" id="resend_btn" class="btn button1 btn-success">Resend OTP</button>
								  
								<div class="form-group">
									<input type="password" id="verification_fld" class="rounded" id="pwd" id="contactpassword" name="password" placeholder="Enter OTP">
								</div>

								<button id="verify_btn" class="button button1 btn-success">Verify</button>
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