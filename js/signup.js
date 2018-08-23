window.onload = initAll;

function initAll(){
	var params = window.location.href.split('=');
	params1 = params[1].split('&');
	num = document.getElementById("num");
	num1 = document.getElementById("num1");
	num.value = params1[0];
	num1.value = params1[0];
}