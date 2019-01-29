window.addEventListener('DOMContentLoaded', function() {
	initInternal();
	addMoreBtnEvent();
	addToTopBtnEvent();
});

function initInternal() {
	addCategoryClickEventListener();
	document.getElementsByClassName("categoryBtn")[0].click();
	addPromotions();
}

function addPromotions() {
	var element= document.getElementById('areaPromotion');
	var template= document.querySelector('#promotionTemplate').innerHTML;
	
	sendGetAjaxRequest(function() {
		/*TODO promotion 아이템 리스트를 가져오는 요청을 서버에 보내도록 변경*/
		if (this.status == 200) {
			var txt = this.responseText;
			var mock_data= JSON.parse(txt);
			/*animate(element, template, mock_data.items, 0);*/
			
			var children= [];
			var leng= mock_data.length;
			for(var i=0; i<leng; i++) {
				var tmp= document.createElement('div');
				var base64= Convert.ToBase64String(mock_data[i].img);
				tmp.innerHTML= template.replace("${path}", 'data:image/PNG;base64,' + base64);
				children[i]= tmp.firstElementChild;
			}
			
			animate(element, children, template, mock_data, 0, 1, 0);
		}
	});
}

function animate(element, children, template, items, firstIdx, secondIdx, cnt) {
	window.requestAnimationFrame(function() {
		var firstEle= children[firstIdx];
		var secondEle= children[secondIdx];
		
		if(cnt == 0) {
			firstEle.style.left= "0px";
			firstEle.style.top= "0px";
			secondEle.style.left= "600px";
			secondEle.style.top= "-200px";
			element.appendChild(firstEle);
			element.appendChild(secondEle);
			cnt= cnt+1;
		} else if(cnt == 600) {
			element.innerHTML= "";
			firstIdx= (firstIdx === items.length-1) ? 0 : firstIdx+1;
			secondIdx= (secondIdx === items.length-1) ? 0 : secondIdx+1;
			cnt= 0;
		} else {
			firstEle.style.left= parseInt(firstEle.style.left) - 1 + "px";
			secondEle.style.left= parseInt(secondEle.style.left) - 1 + "px";
			cnt= cnt+1;
		}
		animate(element, children, template, items, firstIdx, secondIdx, cnt);
	});
}

/*function animate(element, template, items, idx) {
	window.setTimeout(function() {
		if(idx == items.length) {
			idx= 0;
		}
		var path= items[idx].img;
		var html= template.replace("${path}", path);
		element.innerHTML= html;
		animate(element, template, items, idx+1);
	}, 2000)
}*/

var products;
var initialSize= 4;

function addCategoryClickEventListener() {
	var elements = document.getElementsByClassName("categoryBtn");
	for (var i=0; i<elements.length; i++) {
		var ele = elements[i];
		ele.addEventListener("click", function() {
			for (var j = 0; j < elements.length; j++) {
				elements[j].style.color = "black";
				elements[j].style.textDecoration = "none";
			}
			this.style.color = "green";
			this.style.textDecoration = "underline";
			
			code= this.getAttribute('code');
			console.log('code [' + code + ']');
			
			sendGetAjaxRequest(function() {
				if(this.status == 200) {
					var response= this.responseText;
					products= JSON.parse(response);
					setProductCount();
					displayProduct();
				}
			});
		}, false);
	}
}

function setProductCount() {
	var innerText= '예약 가능한 공연이 ' + products.length + '개 있습니다.';
	var element= document.getElementById('areaCount');
	element.innerText= innerText;
}

function displayProduct() {
	var html= document.querySelector('#productTemplate').innerHTML;
	var leng= products.length > 4 ? 4 : products.length;
	var area= document.getElementsByClassName('areaProduct');
	area[0].innerHTML= '';
	area[1].innerHTML= '';
	
	for(var i=0; i<leng; i++) {
		var child= document.createElement('div');
		child.setAttribute('style', 'margin-bottom: 15px;')
		child.setAttribute('class', 'product');
		var product= products[i];
		child.innerHTML= html.replace('${path}', product.img)
							 .replace('${name}', product.name)
							 .replace('${place}', product.place)
							 .replace('${description}', product.description);
		
		console.log('idx ' + (i%2) );
		area[i%2].appendChild(child);
	}
}

function sendGetAjaxRequest(callback) {
	var req = new XMLHttpRequest();
	req.addEventListener("load", callback);
	req.open("GET", 'http://localhost:8080/edwith.reserve.service/api/products', true);
	req.send();
}

function addMoreBtnEvent() {
	var ele= document.getElementById('areaBtnMore');
	ele.addEventListener("click", function() {
		var displayedProducts= document.getElementsByClassName('product');
		var productLeng= displayedProducts.length;
		var toAdd= productLeng < products.length ? products.length - productLeng : -1;
		toAdd= toAdd > 4 ? 4 : toAdd;
		
		if(toAdd <= 0) {
			this.style.display= 'none';
			return;
		}
		
		var area= document.getElementsByClassName('areaProduct');
		var html= document.querySelector('#productTemplate').innerHTML;
		for(var i=productLeng; i<productLeng + toAdd; i++) {
			var child= document.createElement('div');
			child.setAttribute('style', 'margin-bottom: 15px;')
			child.setAttribute('class', 'product');
			var product= products[i];
			child.innerHTML= html.replace('${path}', product.img)
								 .replace('${name}', product.name)
								 .replace('${place}', product.place)
								 .replace('${description}', product.description);
			
			area[i%2].appendChild(child);
		}
		
		if( (productLeng + toAdd) === products.length ) {
			this.style.display= 'none';
		}
	});
}

function addToTopBtnEvent() {
	var ele= document.getElementById('areaBtnToTop');
	ele.addEventListener("click", function() {
		window.scrollTo(0, 0);
	});
}