$(document).ready(function(){
	$.get("fitch_product.do", function(data,status){
		if(status="succes"){
		    arr = eval(data);
			//alert(data);
			if(arr!=null){
				for(i=0;i<arr.length;i++){
					
					$(".commodity"+i).html(arr[i].commodity.toUpperCase());
					//$(".quantity"+i).html("Quantities : "+arr[i].quantity+"Kg");
					$(".mrp"+i).html('<span>'+arr[i].mrp+"Rs"+'</span>');
					$(".farmer"+i).html(arr[i].user);
					$(".description"+i).html('<span>'+"Quality :"+arr[i].description+'</span>');
					//$(".qtLeft"+i).html("qtleft :"+arr[i].qtleft+"Kg");
					$("#image"+i).attr("src","commoditypics.do?commodityPic="+arr[i].commodity_pic);
					$(".farmer"+i).attr("href","seller_profile.do?user_id="+arr[i].userId);
					$(".buy"+i).attr("href","buy_crop.do?commodityId="+arr[i].commodity_id);
					$(".cart"+i).attr("id","cart"+arr[i].commodity_id);	
				}
			}else{
			alert("No commodities Available");
		}
		}else{
			alert("error");
		}

	});
	
	$("a").click(function(){
		commoditiesId = this.id;
		//alert(commoditiesId);
		$.get("supplier_detail.do?commodityId="+this.id, function(data,status){
		if(status="succes"){
			arr = eval(data);
			$(".supplier_commodity").html(arr[0].commodity);
			$("#supplier_quality").html(arr[0].quality);
			$("#supplier_mrp").html(arr[0].mrp);
			$("#supplier_quantity").html(arr[0].quantity);
			$("#supplier_description").html(arr[0].description);
		}else{
		alert(status);
		}
		});
	});
	
	$(".buy").on("click",function(){
		//alert(this.id);
		$(".buy").attr("href","buy_crop.do?commodityId="+this.id);
	});

	$("#search_btn").keyup(function(){
		
		value = $("#search_btn").val();
		
		if(value.length>=3){
			//alert("hiiii"+value);
			//alert("hi");
			$.get("search.do?search="+value,function(data,status){
				if(status="success"){
					alert(data);
					cat = eval(data);
					//alert(cat);
					$(".search_menu").html("");
					for(i=0;i<cat.length;i++){
						$(".search_menu").append(cat[i].category);
						k = cat[i].category;
						$(".search_menu").on("click",function(){
							$("#search_btn").val(k);
							$(".search_menu").css("display","none");

						});
					}
				}
			});
		}
	});

	$("a.notify").click(function(){
		alert("hiiiiii");
	});
	
});
