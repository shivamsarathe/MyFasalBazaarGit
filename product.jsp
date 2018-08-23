<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
<title>FasalBazaar : Upload Product</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width,height=device-height, initial-scale=1">
<link rel="stylesheet" href="css/profile.css">
<link rel="stylesheet" href="css/profiledetail.css">


<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css" />
<script src="bootstrap/jquery/jquery.min.js"></script>
<script src="bootstrap/js/bootstrap.min.js"></script>
<script src="js/register.js"></script>


<script src="js/profile.js"></script>

</head>
<body >
	<%@ include file="header_main.jsp"%>
					<form action="product_upload.do">
							<div align="center" style="margin-top:15px;font-size:30px">Commodity Upload Form</div>
						<div align="center">
							
							<input type="text" name="commodity_name" class="form-control" style="width:50%;margin-top:7px;display:inline" placeholder="product name"/>
							<p style="margin-top:5px">Commodity Name</p >
							
							<div align="center" style="margin-top:15px;font-size:10px">
								<select name="category_id">
									<option>Category</option>
									<c:forEach var="category" items="${categories}">
											<option value="${category.categoryId}">${category.category}</option>
									</c:forEach>
								</select>
							</div>
							</br>
						
							<input type="number" name="quantity" class="form-control" style="width:50%;margin-top:10px;display:inline" placeholder="quantity"/>
							<p style="margin-top:5px">Quantity</p>
						
							<input type="text" name="price" class="form-control" style="width:50%;margin-top:10px;display:inline" placeholder="price"/>
							<p style="margin-top:5px">Price</p>
							
							<input type="text" name="gst" class="form-control" style="display:inline;width:50%;margin-top:10px" placeholder="gst"/>
							<p style="margin-top:5px">GST</p>
							
							
							<input type="text" name="discount" class="form-control" style="display:inline;width:50%;margin-top:10px" placeholder="discount"/>
							<p style="margin-top:5px">Discount</p>
							
							<textarea class="form-control" name="discription" style="width:50%" name="description"></textarea>
							<p style="margin-top:5px">Discription</p>

							<input type="submit" value="Upload Commodity" class="btn btn-primary" style="margin-top:10px"/>
						</div>
					</form>
					<br/><br/><br/>
			</body>
		<head>
<html>