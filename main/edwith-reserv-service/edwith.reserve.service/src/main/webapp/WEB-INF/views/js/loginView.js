window.addEventListener('DOMContentLoaded', function() {
	init();
});


function init() {
	
	var btnLogin= document.getElementById('btnLogin');
	var txtId= document.getElementById('txtId');
	var txtPw= document.getElementById('txtPw');
	var areaMsg= document.getElementById('areaMsg');
	
	btnLogin.addEventListener("click", function() {
		var id= txtId.value;
		var pw= txtPw.value;
		
		var req= new XMLHttpRequest();
		req.addEventListener("load", function() {
			if(this.status == 200) {
				var txt= this.responseText;
				var res= JSON.parse(txt);
				
				if(res.success) {
					// token local storage
					// redirect page
					areaMsg.innerText= '';
//					localStorage.setItem('token', res.token);
					document.cookie='Bearer=' + res.token;
					console.log(res.token);
					
				} else {
					areaMsg.innerText= res.failMsg;
				}
			} else {
				areaMsg.innerText='Auth server internal error..';
			}
		});
		req.open("GET", 'http://localhost:8080/edwith.reserve.service/login?id=' + id + '&passwd=' + pw, true);
		req.send();
	});
}