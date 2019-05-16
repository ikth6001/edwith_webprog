window.addEventListener('DOMContentLoaded', function(){
	init();
})

function init() {
	initAreaGnb();
	
	var userEmail= document.getElementById('loginUserEmail').innerText;
	var qs= 'reservationEmail=' + userEmail;
	var templateTxt= document.getElementById('reservationTempalte').innerText;
	var template= Handlebars.compile(templateTxt);
	
	sendGetAjaxRequest('/api/reservations?' + qs, function() {
		if(this.status == 200) {
			var reservations= JSON.parse(this.responseText).reservations;
			
			for(var i=0; i<reservations.length; i++) {
				var reservation= reservations[i];
				
				var container;
				var eleClass;
				
				if(reservation.cancelYn) {
					container= document.getElementById('canceled');
					eleClass= 'contentsContainer';
				} else {
					container= document.getElementById('active');
					eleClass= 'contentsContainer inActive';
				}
				
				var element= document.createElement('div');
				var id= reservation.reservationInfoId;
				
				element.setAttribute('id', id);
				element.setAttribute('class', eleClass);
				
				var context= {
					classes: eleClass
					, productName: reservation.displayInfo.productDescription
					, openingHours: reservation.displayInfo.openingHours
					, place: reservation.displayInfo.placeName
					, price: reservation.totalPrice
				};
				
				element.innerHTML= template(context);
				container.appendChild(element);
			}
			
			var activeCnt= document.getElementById('active').children.length-1;
			var cancelCnt= document.getElementById('canceled').children.length-1;
			
			document.getElementById('activeLabel').innerHTML= '<h3>예약확정(' + activeCnt + '개)</h3>';
			document.getElementById('cancelLabel').innerHTML= '<h3>예약취소(' + activeCnt + '개)</h3>';
			
			var container= document.getElementById('active');
			var divs= container.children;
			var first= true;
			
			
			for(let element of divs) {
				if(first) {
					first= false;
					continue;
				}
				
				element.addEventListener('click', function() {
					var isCancel= confirm('예약을 취소 하겠습니까??');
					
					if(isCancel) {
						var id= element.id;
						sendPutAjaxRequest('/api/reservations/' + id, function() {
							location.reload(true);
						});
					}
				});
			};
		} else if(this.status == 401){
			window.location.href='/loginView';
		}
	});
}

function initAreaGnb() {
	var btnToMain= document.getElementById('areaBtnToMain');
	btnToMain.addEventListener('click', function() {
		window.location.href= '/';
	});
}

function sendGetAjaxRequest(url, callback) {
	var req = new XMLHttpRequest();
	req.addEventListener("load", callback);
	req.open("GET", url, true);
	req.send();
}

function sendPutAjaxRequest(url, callback) {
	var req= new XMLHttpRequest();
	req.addEventListener("load", callback);
	req.open("PUT", url, true);
	req.setRequestHeader("Content-type", "application/json;charset=UTF-8");
	req.send();
}