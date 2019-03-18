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
		
		// TODO 정규 표현식을 통한 입력값 검증
		
		var req= new XMLHttpRequest();
		req.addEventListener("load", function() {
			if(this.status == 200) {
				var txt= this.responseText;
				var res= JSON.parse(txt);
				
				if(res.success) {
					areaMsg.innerHTML= '';
//					localStorage.setItem('token', res.token);
					document.cookie='Bearer=' + res.token;
					window.history.back();
				} else {
					areaMsg.innerHTML= '<font color=\'red\'>' + res.failMsg + '</font>';
				}
			} else {
				areaMsg.innerHTML= '<font color=\'red\'>Auth server internal error..</font>';
			}
		});
		req.open("GET", 'http://localhost:8080/edwith.reserve.service/login?id=' + id + '&passwd=' + pw, true);
		req.send();
	});
}