window.addEventListener('DOMContentLoaded', function() {
	loadProductImages();
	configureBtns();
});

var images;
var imgIdx;
var collapse= true;

function configureBtns() {
	var btnPrev= document.getElementById('btnPrev');
	btnPrev.addEventListener('click', function() {
		if(images.length > 0) {
			imgIdx= (imgIdx === 0) ? images.length-1 : imgIdx-1;
			setImageAndCountText(imgIdx);
		}
	});
	
	var btnNext= document.getElementById('btnNext');
	btnNext.addEventListener('click', function() {
		if(images.length > 0) {
			imgIdx= (imgIdx === images.length-1) ? 0 : imgIdx+1;
			setImageAndCountText(imgIdx);
		}
	});
	
	var btnCollapseSpand= document.getElementById('btnCollapseSpand');
	btnCollapseSpand.addEventListener('click', function() {
		var area= document.getElementById('productContents');
		var height= collapse ? '100%' : '70px';
		var text= collapse ? '접어보기△' : '펼쳐보기▽';
		
		area.setAttribute('style', 'height: ' + height + '; overflow: hidden;');
		this.innerText= text;
		collapse= !collapse;
	});
	
	var btnCommentMore= document.getElementById('btnCommentMore');
	btnCommentMore.addEventListener('click', function() {
		var displayInfoId= document.getElementById('displayInfoId').innerText;
		window.location.href= '/edwith.reserve.service/comments?displayInfoId=' + displayInfoId; 
	});
	
	var btnDetailArea= document.getElementById('detailArea');
	btnDetailArea.addEventListener('click', function() {
		var noticeImg= 'img/20_et_52.png';
		var source= document.getElementById('detailMainTemplate').innerText;
		
		var template= Handlebars.compile(source);
		var context= {notice_img: noticeImg};
		var html= template(context);
		
		var mainEle= document.getElementById('mainArea');
		mainEle.innerHTML= html;
		
		this.setAttribute('style', 'color: green;');
		document.getElementById('mapArea').setAttribute('style', 'color: black;');
	});
	
	var btnMapArea= document.getElementById('mapArea');
	btnMapArea.addEventListener('click', function() {
		var source= document.getElementById('mapMainTemplate').innerText;
		
		var template= Handlebars.compile(source);
		var context= {place_name: '예술의 전당', place_address: '서울 전당로 108 blah blah', phone_number: '010-8888-7777'};
		var html= template(context);
		
		var mainEle= document.getElementById('mainArea');
		mainEle.innerHTML= html;
		
		this.setAttribute('style', 'color: green;');
		document.getElementById('detailArea').setAttribute('style', 'color: black;');
	});
	
	var btnReserve= document.getElementById('btnReserveArea');
	btnReserve.addEventListener('click', function() {
		var displayInfoId= document.getElementById('displayInfoId').innerText;
		window.location.href='/edwith.reserve.service/reservationView?displayInfoId=' + displayInfoId;
	});
	
	btnDetailArea.click();
}

function setImageAndCountText(idx) {
	var imgEle= document.getElementById('titleImage');
	imgEle.setAttribute('src', images[idx].fileName);
	
	var countArea= document.getElementById('imgCount');
	countArea.innerText= (idx + 1) + ' / ' + images.length;
}

function loadProductImages() {
	var displayInfoId= document.getElementById('displayInfoId').innerText;
	sendGetAjaxRequest('/edwith.reserve.service/api/products/' + displayInfoId, function() {
		if(this.status == 200) {
			var responseText= this.responseText;
			var responseObj= JSON.parse(responseText);
			
			images= responseObj.productImages;
			if(images.length > 0) {
				imgIdx= 0;
				setImageAndCountText(imgIdx);
			}
		} else {
			
		}
	})
}

function sendGetAjaxRequest(url, callback) {
	var req = new XMLHttpRequest();
	req.addEventListener("load", callback);
	req.open("GET", url, true);
	req.send();
}