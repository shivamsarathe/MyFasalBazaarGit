$(document).ready(function() {
	var value = <%session.getAttribute("valid_login")%>;
	alert(value);
});