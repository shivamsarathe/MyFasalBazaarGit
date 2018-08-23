window.onload = initAll;

function initAll(){
	getAllElements();
	setAllFunctions();
}

function getAllElements(){
	generateBtn = document.getElementById("generate_btn");
	numberFld = document.getElementById("number_fld");
	resendBtn = document.getElementById("resend_btn");
	verificationFld = document.getElementById("verification_fld");
	verifyBtn = document.getElementById("verify_btn");
	form = document.getElementById("form");
}

function setAllFunctions(){
	generateBtn.onclick = generateOtp;

	verifyBtn.onclick = verifyOtp;
}

var otpRq;
function generateOtp(){
	if(numberFld.value.trim().length==10){
		otpRq = new XMLHttpRequest();
		otpRq.open('get','generate_otp.do?mobile='+numberFld.value,true);
		otpRq.onreadystatechange = otpReceived;
		otpRq.send(null);
		verificationFld.disabled = false;
	}
	else{
		alert("Please input a valid number!");
		numberFld.value = "";
	}
}

function otpReceived(){
	if(otpRq.readyState==4&&otpRq.status==200){
	generateBtn.disabled = "disabled";
	resendBtn.disabled = false;
	resendBtn.onclick = generateOtp;
	/*span = document.createElement("span");
	span.innerHTML =  otpRq.responseText;
	alert("ok");*/
	}
}

function verifyOtp(){
	if(verificationFld.value==otpRq.responseText){
		//verifyBtn.href= "#addContactModal2";
		form.action = "userFarmerSignup.jsp";
	}
	else{
		form.action ="userFarmerSignup.jsp";
		alert("Please enter correct OTP");
	}
}