$(document).ready(function(){
	var cart_value;
	var y = 0;
    $("button").click(function(){
		//alert("hiii");
        var x= $(this).attr("id");
		cart_value = x.substring(4);
		$.get("add_cart.do?commodity_id="+cart_value,function(data, status){
			y = data;
			$("#cart_sp").html(data);
			$("#cart_sp").css("background","red");	
		});
    });
});