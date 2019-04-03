window.addEventListener('DOMContentLoaded', function() {
	init();
});

function init() {
	initAreaGnb();
	initPrice();
	initEssentials();
	initBtnReseve();
}

function initAreaGnb() {
	var btnToMain= document.getElementById('areaBtnToMain');
	btnToMain.addEventListener('click', function() {
		window.location.href= '/edwith.reserve.service';
	});
}

function initBtnReseve() {
	var btn= document.getElementById('reservationFinal');
	btn.addEventListener('click', function() {
		
		var status= true;
		var problemEle;
		
		for(var i=0; i<essentialEles.length; i++) {
			var essentialEle= essentialEles[i];
			essentialEle.validation();
			status= status & essentialEle.status;
			
			if(!status) {
				problemEle= essentialEle;
				break;
			}
		}
		
		var ticketCnt= parseInt(document.getElementById('totalCount').innerText);
		if(status) {
			if(ticketCnt > 0) {
				
				var prices= new Array();
				for(var i=0; i<pCnt; i++) {
					var price= {
						count: document.getElementById('btnTicketCnt' + i).innerText
						, productPriceId: document.getElementById('btnTicketCnt' + i).parentNode.id
					};
					
					prices[i]= price;
				}
				
				var parameters= {
					displayInfoId: document.getElementById('displayInfoId').innerText
					, prices: prices
					, reservationEmail: essentialEles[2].input.value
					, reservationName: essentialEles[0].input.value
					, reservationTelephone: essentialEles[1].input.value
					, reservationYearMonthDay: new Date().toISOString().slice(0,10).replace(/-/g,"")
				};
				
				sendPostAjaxRequest('/edwith.reserve.service/api/reservations', parameters, function() {
					if(this.status == 200) {
						window.location.href= '/edwith.reserve.service/reservationList';
					} else {
						alert('예약에 실패 했습니다...');
					}
				});
			} else {
				alert('예매할 티켓을 선택 해주십시오.');
			}
		} else {
			alert(problemEle.msg);
		}
	})
}

var essentialEles= new Array();

function initEssentials() {
	
	var lblName= document.getElementById('lblName');
	var inputName= document.getElementById('inputName');
	essentialEles[0]= new essential(lblName
			, inputName
			, document.getElementById('nameErrMsg')
			, /[ㄱ-ㅎ|ㅏ-ㅣ|가-힣]+/
			, '한글만 입력이 가능합니다.');
	inputName.addEventListener('change', function() {
		validate(essentialEles[0]);
	});
	
	var lblPhone= document.getElementById('lblPhone');
	var inputPhone= document.getElementById('inputPhone');
	essentialEles[1]= new essential(lblPhone
			, inputPhone
			, document.getElementById('phoneErrMsg')
			, /[0-9]+-[0-9]+-[0-9]+/
			, '핸드폰 번호 형식이 잘못 되었습니다.');
	inputPhone.addEventListener('change', function() {
		validate(essentialEles[1]);
	});
	
	var lblPhone= document.getElementById('lblEmail');
	var inputPhone= document.getElementById('inputEmail');
	essentialEles[2]= new essential(lblPhone
			, inputPhone
			, document.getElementById('emailErrMsg')
			, /^[a-zA-Z0-9]+@[a-zA-Z0-9]+\.[a-zA-Z0-9]+/
			, '이메일 형식이 잘못 되었습니다.');
	inputPhone.addEventListener('change', function() {
		validate(essentialEles[2]);
	});
}

function validate(essentialEle) {
	var status= true;
	
	essentialEles.forEach(function(essentialEle, i) {
		essentialEle.validation();
		status= status & essentialEle.status;
	});
	
	if(status) {
		document.getElementById('reservationFinal').style.background='green';
	} else {
		document.getElementById('reservationFinal').style.background='silver';
	}
	
	console.log(essentialEle.msg);
}

function essential(label, input, errEle, regEx, regExMsg) {
	this.label= label;
	this.input= input;
	this.errEle= errEle;
	this.regEx= regEx;
	this.status= false;
	this.regExMsg= regExMsg;
	this.msg;
	
	this.validation= function() {
		var contents= this.input.value;
		
		if(contents === null
				|| contents === "") {
			this.status= false;
			this.msg= label.innerText + ' 의 값을 입력 하십시오.';
			this.label.style.color= 'black';
			return;
		}
		
		if(regEx.test(contents)) {
			this.status= true;
			this.msg= '';
			this.label.style.color= 'green';
		} else {
			this.status= false;
			this.msg= regExMsg;
			this.label.style.color= 'black';
		}
		
		if( this.status ) {
			this.errEle.innerHTML= '';
		} else {
			this.errEle.innerHTML= '<font color=\'red\'>' + this.msg + '</font>';
		}
	}
}

var pCnt= 0;

function initPrice() {
	var displayInfoId= document.getElementById('displayInfoId').innerText;
	
	sendGetAjaxRequest('/edwith.reserve.service/api/products/' + displayInfoId, function() {
		
		if(this.status == 200) {
			
			var responseText= this.responseText;
			var responseObj= JSON.parse(responseText);
			var prices= responseObj.productPrices;
			var priceContainer= document.getElementById('ticketSelArea');
			var priceTemplate= document.getElementById('priceTemplate').innerText;
			var priceTxtHtml= '<b>요금</b><br>';
			
			prices.forEach(function(priceInfo, i) {
				var productPriceId= priceInfo.productPriceId;
				var priceTypeName= priceInfo.priceTypeName;
				var price= priceInfo.price;
				var discountRate= priceInfo.discountRate;
				
				var template= Handlebars.compile(priceTemplate);
				var context= {
						productPriceId: productPriceId
						, priceTypeName: priceTypeName
						, price: price
						, discountRate: discountRate
						, idx: i
				}
				
				priceTxtHtml= priceTxtHtml + '- ' + priceTypeName + '(' + price + '원)<br>';
				var innerHtml= priceContainer.innerHTML;
				priceContainer.innerHTML= innerHtml + template(context);
				
//				var btnCnt= document.getElementById("btnTicketCnt" + i);
//				var btnPrice= document.getElementById("totalPrice" + i);
//				var btnMinus= document.getElementById("btnPriceMinus" + i);
//				var btnPlus= document.getElementById("btnPricePlus" + i);
//				
//				btnMinus.style.cursor= 'pointer';
//				btnMinus.addEventListener('click', function() {
//					var cnt= parseInt(btnCnt.innerText);
//					var totalPrice= btnPrice.innerText;
//					
//					if(cnt > 0) {
//						btnCnt.innerText= cnt - 1;
//						btnPrice.innerText= btnPrice.innerText - price;
//						
//						if(cnt == 1) {
//							this.style.background='white';
//						}
//					}
//				});
//				
//				btnPlus.style.cursor= 'pointer';
//				btnPlus.style.backgroundColor= 'green';
//				btnPlus.addEventListener('click', function() {
//					var cnt= parseInt(btnCnt.innerText);
//					var totalPrice= btnPrice.innerText;
//					
//					btnCnt.innerText= cnt + 1;
//					btnPrice.innerText= parseInt(btnPrice.innerText) + parseInt(price);
//					
//					btnMinus.style.background='green';
//				});
			});
			
			for(var i=0; i<prices.length; i++) {
				
				var price= prices[i].price;
				var btnCnt= document.getElementById("btnTicketCnt" + i);
				var btnPrice= document.getElementById("totalPrice" + i);
				
				var btnMinus= document.getElementById("btnPriceMinus" + i);
				var btnPlus= document.getElementById("btnPricePlus" + i);
				
				pCnt= pCnt + 1;
				
				/**
				 * 솔직히 이해 하나도 안감.
				 * 자바스크립트의 scope 및 closure에 대해서 알아볼 필요 있음.
				 */
				btnMinus.style.cursor= 'pointer';
				btnMinus.addEventListener('click', 
						minusDeleagtion.bind(this, btnMinus, btnCnt, btnPrice, price));
				
				btnPlus.style.cursor= 'pointer';
				btnPlus.style.backgroundColor= 'green';
				btnPlus.addEventListener('click', 
						plusDelegation.bind(this, btnMinus, btnCnt, btnPrice, price));
			}
			
		} else {
			
		}
	});
}

function minusDeleagtion(ele, btnCnt, btnPrice, price) {
	var cnt= parseInt(btnCnt.innerText);
	var totalPrice= btnPrice.innerText;
	
	if(cnt > 0) {
		btnCnt.innerText= cnt - 1;
		btnPrice.innerText= btnPrice.innerText - price;
		
		var total= document.getElementById('totalCount');
		total.innerText= parseInt(total.innerText) - 1;
		
		if(cnt == 1) {
			ele.style.background='white';
		}
	}
}

function plusDelegation(ele, btnCnt, btnPrice, price) {
	var cnt= parseInt(btnCnt.innerText);
	var totalPrice= btnPrice.innerText;
	
	btnCnt.innerText= cnt + 1;
	btnPrice.innerText= parseInt(btnPrice.innerText) + parseInt(price);
	
	var total= document.getElementById('totalCount');
	total.innerText= parseInt(total.innerText) + 1;
	ele.style.background='green';
}

function sendGetAjaxRequest(url, callback) {
	var req = new XMLHttpRequest();
	req.addEventListener("load", callback);
	req.open("GET", url, true);
	req.send();
}

function sendPostAjaxRequest(url, parameters, callback) {
	var req= new XMLHttpRequest();
	req.addEventListener("load", callback);
	req.open("POST", url, true);
	req.setRequestHeader("Content-type", "application/json;charset=UTF-8");
	req.send(JSON.stringify((parameters)));
}

