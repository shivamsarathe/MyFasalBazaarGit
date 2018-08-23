<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Bootstrap Case</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width,height=device-height, initial-scale=1">
<link rel="stylesheet" href="css/profile.css">
<link rel="stylesheet" href="css/profiledetail.css">


<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css" />
<script src="bootstrap/jquery/jquery.min.js"></script>
<script src="bootstrap/js/bootstrap.min.js"></script>
<script src="js/productpic.js"></script>

</head>
<body >
	<%@ include file="header_main.jsp"%>
					<h1 style="text-align:center">Upload Commodity Picture</h1>
					<div class="form-control" style="border:none;text-align:center;margin-top:20px" >
					<form action="product_pic_upload.do" method="post" enctype="multipart/form-data">
					<input type="file"  style="display:inline;border-radius:5px" name="product_pic" />
					<input type="submit" Value="Upload" class="btn btn-primary" style="padding:2px" id="btn" />
					</form>
					<a href="profile.jsp"><input type="submit" value="Save" class="btn btn-primary" style="padding:3px;margin-left:400px;margin-top:-45px"/></a>
					</div> 

					<div id="img_body" style="width:780px;height:540px;margin-left:380px;margin-top:30px" >
						<c:forEach var="productPic" items="${commodityPics}" varStatus="abc">
						
						<img src="pic.do?picPath=${productPic}" style="width:250px;height:250px;padding:6px" class="img-thumbnail" />
						
						</c:forEach>
						<div>
					<br/><br/><br/>
					
					
</body>


</html>
