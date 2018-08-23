window.onload = initAll;
var count = 0,btn;
function initAll(){
	btn = document.getElementById("btn");
	count++;
	if(count==3){
		btn.setAttribute("disabled","disabled");
	}
	
}

