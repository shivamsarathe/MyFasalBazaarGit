window.onload = initAll;
	function initAll(){
	////userName//
	var edit_unm,save_unm,cancel_unm,unm;
	////city////
	var edit_city,cancel_city,save_city,city;
	var text_area,save_btn;
	
	/////userName/////
	edit_unm = document.getElementById('edit_unm');
	save_unm = document.getElementById('save_unm');
	cancel_unm = document.getElementById('cancel_unm');
	unm = document.getElementById('unm');
	
	edit_unm.onclick = editUserName;
	save_unm.onclick = saveUserName;
	cancel_unm.onclick = cancelUserName;

	/////city///

	edit_city = document.getElementById('edit_city');
	save_city = document.getElementById('save_city');
	cancel_city = document.getElementById('cancel_city');
	city = document.getElementById('city');
	records = document.getElementById('records');

	edit_city.onclick = editCity;
	cancel_city.onclick = cancelCity;
	city.onkeyup = showCities;
	save_city.onclick = saveCities;

	////textArea///

	text_area = document.getElementById('text_area');
	save_btn = document.getElementById('save_btn');
	save_btn.onclick = saveAddress;
}
var atp;
function saveAddress(){
	atp = new XMLHttpRequest();
	atp.open('get','update_address.do?address='+text_area.value,true);
	atp.onreadystatechange = showAddress;
	atp.send(null);
	
}

function showAddress(){
	if(atp.readyState==4&&atp.status==200){
		
		alert(atp.responseText);	
	}
}

////city////

function editCity(){
	edit_city.style.display="none";
	save_city.style.display="inline";
	cancel_city.style.display="inline";
	city.removeAttribute("disabled");
}

function cancelCity(){
	edit_city.style.display="inline";
	save_city.style.display="none";
	cancel_city.style.display="none";
	city.setAttribute("disabled","disabled");
	
}

var ctq;
function showCities(){
	
	 ctq = new XMLHttpRequest();
	 ctq.open('get','city.do?city='+city.value,true);
	 ctq.onreadystatechange = cities;
	 ctq.send(null);

	
}
var obj,i;
function cities(){
	
	if(city.value.trim().length>2){
	if(ctq.readyState==4&&ctq.status==200){
		
		records.innerHTML = '';
		var arr = eval(ctq.responseText);
			for(i=0;i<arr.length;i++){
				obj= document.createElement('div');
				obj.innerHTML = arr[i].citynm+','+arr[i].statenm;
				obj.onmouseover = show;
				obj.onmouseout = hide;
				obj.title = arr[i].cityid;
				obj.cityid = arr[i].cityid;
				
				obj.onclick = onck;
				records.appendChild(obj);
			}
			records.style.display='block';
	} 
	}
}
function onck(){
	city.value = this.innerHTML;
	city.cityid = this.cityid;
	
	records.style.display="none";
	
	
} 

function show(){
	this.className = 'on';
}
function hide(){
	this.className = 'out';
}
var sct
function saveCities(){

	sct = new XMLHttpRequest();
	 sct.open('get','save_city.do?city_id='+city.cityid,true);
	 sct.onreadystatechange = showSaveCities;
	 sct.send(null);

}

function showSaveCities(){
	if(sct.readyState==4&&sct.status==200){
		
		//alert(sct.responseText);
		city.setAttribute("disabled","disabled");
		edit_city.style.display="inline";
	save_city.style.display="none";
	cancel_city.style.display="none";
	
	}
}

/////userName////
function editUserName(){
	edit_unm.style.display="none";
	save_unm.style.display="inline";
	cancel_unm.style.display="inline";
	unm.removeAttribute("disabled");
}

var utp,val;

function saveUserName(){
	
	/*utp = new XMLHttpRequest();
	
	utp.open('get','change_User_Name.do?userName='+unm.value,true);
	
	utp.onreadystatechange = showUserName;

	utp.send(null);*/

	if(val!=unm.value){
	utp = new XMLHttpRequest();
	utp.open('get','update_unm.do?unm='+unm.value,true);
	val=unm.value;
	utp.onreadystatechange = showUserName;
	utp.send(null);
	}else{
		alert("same");
	}
	


	

}

function showUserName(){
		
	if(utp.readyState==4&&utp.status==200){
		
		unm.value=val;
		unm.setAttribute("disabled","disabled");
		save_unm.style.display="none";
		cancel_unm.style.display="none";
		edit_unm.style.display="inline";
		
	}
}

function cancelUserName(){
	edit_unm.style.display="inline";
	save_unm.style.display="none";
	cancel_unm.style.display="none";
	unm.setAttribute("disabled","disabled");
}