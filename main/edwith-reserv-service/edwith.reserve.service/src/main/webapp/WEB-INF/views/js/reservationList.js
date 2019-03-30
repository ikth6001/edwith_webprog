window.addEventListener('DOMContentLoaded', function(){
	init();
})

function init() {
	initAreaGnb();
	
	var userEmail= document.getElementById('loginUserEmail').innerText;
	var qs= 'reservationEmail=' + userEmail;
	var templateTxt= document.getElementById('reservationTempalte').innerText;
	var template= Handlebars.compile(templateTxt);
	
	sendGetAjaxRequest('/edwith.reserve.service/api/reservations?' + qs, function() {
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
			
			/**
			 * TODO btn..
			 */
		} else if(this.status == 401){
			window.location.href='/edwith.reserve.service/loginView';
		}
	});
}

function initAreaGnb() {
	var btnToMain= document.getElementById('areaBtnToMain');
	btnToMain.addEventListener('click', function() {
		window.location.href= '/edwith.reserve.service';
	});
}

function sendGetAjaxRequest(url, callback) {
	var req = new XMLHttpRequest();
	req.addEventListener("load", callback);
	req.open("GET", url, true);
	req.send();
}