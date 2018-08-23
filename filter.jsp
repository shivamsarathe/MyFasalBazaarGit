<link rel="stylesheet" href="css/filter.css"/>
<!--Modal Start-->

		<div class="modal fade" id="myModal" role="dialog">
			<div class="modal-dialog">
    
				<!-- Modal content-->
				<div class="modal-content img1">
					<div class="modal-header">
						<h4 class="modal-title"><strong>Select Your Choice</strong></h4>
					</div>
			
					<div class="modal-body">
						<div class="container">
							<form class="form-horizontal" action="filter.do">
								<div class="form-group">
									<div class="row">

										<div class="col-md-1"></div>

										<div class="col-md-3">
											<strong>Crops:</strong>
										</div>
								
										<div class="col-md-6">
											<select class="dropdown round button1" id="education" name="crop">
												<option value="" selected="selected" disabled="disabled">-- select one --</option>
												<option value="wheat">Wheat</option>
												<option value="rice">Rice</option>
												<option value="oilseeds">OilSeeds</option>
												<option value="spices">Spices</option>
											</select>
										</div>
									</div>
								</div>


								<div class="form-group">
									<div class="row">

										<div class="col-md-1"></div>

										<div class="col-md-3"><strong>Type of Crop:</strong>
										</div>
								
										<div class="col-md-6">
											<select class="dropdown round button1" id="education" name="verity">
												<option value="" selected="selected" disabled="disabled">-- select one --</option>
												<option value="Emmer"> Emmer wheat</option>
												<option value="Macaroni"> Macaroni wheat </option>
												<option value="Common"> Common bread wheat</option>
												<option value="Indian"> Indian dwarf wheat</option>
											</select>
										</div>
									</div>
								</div>



								<div class="form-group">
									<div class="row">

										<div class="col-md-1"></div>

										<div class="col-md-3"><strong>Quality:</strong>
										</div>
								
										<div class="col-md-6">
											<select class="dropdown round button1" id="education" name="quality">
												<option value="" selected="selected" disabled="disabled">-- select one --</option>
												<option value="normal">Normal</option>
												<option value="average">Average</option>
												<option value="good">Good</option>
												<option value="high">High</option>
											</select>
										</div>
									</div>
								</div>

								<div class="form-group">
									<div class="row">
										
										<div class="col-md-1"></div>
										
										<div class="col-md-3"><strong>Price Range:</strong>
										</div>
								
										<div class="col-md-6">
											<select class="dropdown round button1" id="education" name="mrp">
												<option value="" selected="selected" disabled="disabled">-- select one --</option>
												<option value="40">40-50 Rs/kg</option>
												<option value="60">60-70 Rs/kg</option>
												<option value="80">80-90 Rs/kg</option>
												<option value="100">100-120 Rs/kg</option>
												
											</select>
										</div>
									</div>
								</div>

								<div class="form-group"> 
									<div class="col-sm-offset-2 col-sm-10">
										<button type="submit" src="" class="btn btn-primary button1" style="">Submit</button>
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
