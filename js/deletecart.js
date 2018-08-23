$(document).ready(function(){
	var cart_value;
    $("button").click(function(){
        var x= $(this).attr("id");
		cart_value = x.substring(6);
		
		
		$.get("delete_cart.do?cart_id="+cart_value,function(data, status){
			
			$("#amount").html(data);
			
			$("#hide"+cart_value).css("display","none");

			if(data==0.0){
				
				$("#plc").css("display","none");
				$("#amount").css("display","none");
				
			}

			
		});
		
		


		
			
		
    });
});