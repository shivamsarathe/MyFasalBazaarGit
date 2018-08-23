<link rel="stylesheet" href="css/cropsAdd.css"/>
<!--Modal Start-->

		<div class="modal fade modalheight" id="myModal" role="dialog">
			<div class="modal-dialog">
    
				<!-- Modal content-->
				<div class="modal-content img1">
					<div class="modal-header">
						<h4 class="modal-title"><strong>Upload Your Crops</strong></h4>
					</div>
			
					<div class="modal-body">
						<div class="container">
							<form class="form-horizontal" action="crop_upload.do" method="post" enctype="multipart/form-data">
								<div class="form-group">
									<div class="row">

							
										<div class="col-md-3">
											<strong>Crop Name:</strong>
										</div>
								
										<div class="col-md-6">
											<select class="dropdown round button1" id="education" name="name">
												<option value="" selected="selected" disabled="disabled">-- select one --</option>
												<option value="2">Wheat</option>
												<option value="1">Rice</option>
												<option value="3">Cotton</option>
												<option value="8">Spices</option>
											</select>
										</div>
									</div>
								</div>


								<div class="form-group">
									<div class="row">

										

										<div class="col-md-3"><strong>Type of Crop:</strong>
										</div>
								
										<div class="col-md-6">
											<select class="dropdown round button1" id="education" name="crop">
												<option value="" selected="selected" disabled="disabled">-- select one --</option>
												<option value="Emmer wheat"> Emmer wheat</option>
												<option value="Macaroni wheat"> Macaroni wheat </option>
												<option value="Common bread wheat"> Common bread wheat</option>
												<option value="Indian dwarf wheat"> Indian dwarf wheat</option>
												<option value="Mexican dwarf wheat">Mexican dwarf wheat </option>
											</select>
										</div>
									</div>
								</div>



								<div class="form-group">
									<div class="row">

										

										<div class="col-md-3"><strong>Quality:</strong>
										</div>
								
										<div class="col-md-6">
											<select class="dropdown round button1" id="education" name="quality">
												<option value="" selected="selected" disabled="disabled">-- select one --</option>
												<option value="Normal">Normal</option>
												<option value="Average">Average</option>
												<option value="Good">Good</option>
												<option value="High">High</option>
											</select>
										</div>
									</div>
								</div>

								<div class="form-group">
									<div class="row">
										
										
										
										<div class="col-md-3"><strong>Price Range:</strong>
										</div>
								
										<div class="col-md-6">
											<select class="dropdown round button1" id="education" name="range">
												<option value="" selected="selected" disabled="disabled">-- select one --</option>
												<option value="45">40-50 Rs/kg</option>
												<option value="65">60-70 Rs/kg</option>
												<option value="85">80-90 Rs/kg</option>
												<option value="110">100-120 Rs/kg</option>
												
											</select>
										</div>
									</div>
								</div>

								<div class="form-group">
									<div class="row">
									<div class="col-md-3" ><strong>Discount:</strong>
										</div>

										<div class="col-md-6" >
											<input type="text" name="discount" class="round button1"/>
										</div>
									</div>
								</div>

								<div class="form-group">
									<div class="row">
									<div class="col-md-3" ><strong>Quantity:</strong>
										</div>

										<div class="col-md-6" >
											<input type="text" name="quantity" class="round button1"/>
										</div>
									</div>
								</div>
								
								<div class="form-group">
									<div class="row">
										<div class="col-md-3" ><strong>Description:</strong>
										</div>

										<div class="col-md-6" >
											<textarea class="form-control txtboxwidth" name="description"></textarea>
										</div>

									</div>
								</div>
								
								<div class="form-group">
									<div class="row">
										<div class="col-md-3"><strong>Upload Image:</strong>
										</div>

										<div class="col-md-6" >
											<input type="file" name="image"  class="round button1"/>
										</div>
									</div>
								</div>
						

								<div class="form-group"> 
									<div class="col-sm-offset-2 col-sm-10">
										<button type="submit"  src="" class="btn btn-primary btnwidth" style="">Add</button>
									</div>
								</div>

							</form>
						</div>
					</div>
					
					<div class="modal-footer">
					  <button type="button" class="btn btn-danger borRad" data-dismiss="modal">Close</button>
					</div>
				</div>
			</div>
		</div>
				
		<!--Modal End-->
