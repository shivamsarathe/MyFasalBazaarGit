<%@ page import="models.User"%>
<%@ page import="models.UserType"%>
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
<script src="js/profiledetail.js"></script>


<!-- <script src="js/profile.js"></script> -->

</head>
<body >
	<%@ include file="header_main.jsp"%>
					
					<div class="container-fluid">
					
					<% String proPic = user.getProfilePic();  %>
					<form action="user_pic_upload.do" method="post" enctype="multipart/form-data" >
					<img  src='<%= proPic!=null?"mypic.do":"images/consumer.png" %>' width="250px" height="250px"  style="margin-left:620px; border-radius:50%;"/>
					</div >
					<div class="form-control" style="border:none;text-align:center" >
					<input type="file"  style="display:inline;border-radius:5px" name="mypic" />
					<input type="submit" Value="Upload" class="btn btn-primary" style="padding:2px" />
					</form>
					</div> 
					<div align="center" style="margin-top:15px;font-size:30px">Personal-Details</div>
					<div align="center">
						<p style="margin-top:5px">UserName</p >
						<input type="text" class="form-control" style="width:50%;margin-top:7px;display:inline" placeholder="UserName" value="${user.userName}" disabled="disabled" id="unm"/><span class="glyphicon glyphicon-edit" title="Edit" id="edit_unm"></span><span class="glyphicon glyphicon-ok" style="display:none" id="save_unm"></span><span class="glyphicon glyphicon-remove" style="display:none" id="cancel_unm"></span>
						
						
						<p style="margin-top:5px">City</p>
						<input type="text" class="form-control" style="display:inline;width:50%;margin-top:10px " placeholder="Type First Three Initial Character Of City Name" id="city"/ disabled="disabled"><span class="glyphicon glyphicon-edit" id="edit_city"></span><span class="glyphicon glyphicon-ok" style="display:none" id="save_city"></span><span class="glyphicon glyphicon-remove" style="display:none" id="cancel_city"></span>
						<div style="width:50%;height:100px;overflow:auto;display:none" id="records" class="form-control"></div>
						<p style="margin-top:5px">Address</p>
						<textarea class="form-control" style="width:50%" id="text_area"></textarea>

						<input type="submit" value="Save Changes" class="btn btn-primary" style="margin-top:10px" id="save_btn"/>
					
					<br/><br/><br/>
						<% User user1 = (User)session.getAttribute("user");%>
						
						<% UserType x = user1.getUserType();%>
						<% if(x.getUserTypeId()==2){%>
					<a href="commodity_sell_form.do">Sell Commodities</a>
						<%}%>
												</div>
					<br/><br/><br/>
					
					
</body>

</head>
</html>
