window.addEventListener('DOMContentLoaded', function() {
	initInternal();
	addMoreBtnEvent();
	addToTopBtnEvent();
});

function initInternal() {
	configureCategory();
	addPromotions();
}

function addPromotions() {
	var element= document.getElementById('areaPromotion');
	var template= document.querySelector('#promotionTemplate').innerHTML;
	
	sendGetAjaxRequest('http://localhost:8080/edwith.reserve.service/api/promotions', function() {
		if (this.status == 200) {
			var txt = this.responseText;
			var promotioned= JSON.parse(txt).items;
			
			var children= [];
			var leng= promotioned.length;
			for(var i=0; i<leng; i++) {
				var tmp= document.createElement('div');
				tmp.innerHTML= template.replace("${path}", promotioned[i].productImageUrl);
				children[i]= tmp.firstElementChild;
			}
			
			animate(element, children, template, promotioned, 0, 1, 0);
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

var size= 4;
var selectedCd;

function configureCategory() {
	sendGetAjaxRequest('http://localhost:8080/edwith.reserve.service/api/categories', function() {
		if(this.status == 200) {
			var response= this.responseText;
			var categories= JSON.parse(response).items;
			var ele= document.getElementById('areaCategory');
			
			var htmlTemplate= document.getElementById("categoryTemplate").innerText;
			categories.forEach(function(item, index, array) {
				var name= item.name;
				var categoryId= item.id;
				
				var child= document.createElement('template');
				var innerHTML= htmlTemplate.replace("${categoryId}", categoryId)
										   .replace("${name}", name);
				child.innerHTML= innerHTML.trim();
				ele.appendChild(child.content.firstChild);
			});
			
			addCategoryEvent();
			document.getElementsByClassName("categoryBtn")[0].click();
		}
	});
}

function addCategoryEvent() {
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
			code= this.getAttribute('categoryId');
			selectedCd= code;
			
			var qs= 'categoryId=' + code +'&start=0';
			sendGetAjaxRequest('http://localhost:8080/edwith.reserve.service/api/products?' + qs, function() {
				if(this.status == 200) {
					var response= this.responseText;
					var products= JSON.parse(response);
					setProductCount(products);
					displayProduct(products);
				}
			});
		}, false);
	}
}

function setProductCount(products) {
	var cnt= products.totalCount;
	var messageFormat= document.getElementById('label.product.count').innerText;
	var element= document.getElementById('areaCount');
	element.innerText= messageFormat.replace('{0}', cnt);
}

function displayProduct(products) {
	var html= document.querySelector('#productTemplate').innerHTML;
	var items= products.items;
	var area= document.getElementsByClassName('areaProduct');
	area[0].innerHTML= '';
	area[1].innerHTML= '';
	
	for(var i=0; i<4; i++) {
		var child= document.createElement('div');
		child.setAttribute('style', 'margin-bottom: 15px;')
		child.setAttribute('class', 'product');
		child.setAttribute('productId', items[i].productId)
		
		var description= items[i].productContent;
		description= description.length > 50 ? description.substring(0, 50) + '...' : description
		child.innerHTML= html.replace('${path}', items[i].productImageUrl)
							 .replace('${name}', items[i].productDescription)
							 .replace('${place}', items[i].placeName)
							 .replace('${description}', description);
		
		area[i%2].appendChild(child);
	}
	
	var ele= document.getElementById('areaBtnMore');
	ele.style.display= '';
}

function sendGetAjaxRequest(url, callback) {
	var req = new XMLHttpRequest();
	req.addEventListener("load", callback);
	req.open("GET", url, true);
	req.send();
}

function addMoreBtnEvent() {
	var ele= document.getElementById('areaBtnMore');
	ele.addEventListener("click", function() {
		var displayedProducts= document.getElementsByClassName('product');
		size= displayedProducts.length;
		
		var qs= 'categoryId=' + selectedCd + "&start=" + size;
		
		/* 다음 건이 있는지 확인하기 위해 1건 더 조회한다 */
		sendGetAjaxRequest('http://localhost:8080/edwith.reserve.service/api/products?' + qs, function() {
			var response= this.responseText;
			var products= JSON.parse(response);
			var items= products.items;
			
			if(products.totalCount <= (size + 4)) {
				ele.style.display= 'none';
			}
			
			var area= document.getElementsByClassName('areaProduct');
			var html= document.querySelector('#productTemplate').innerHTML;
			for(var i=0; i<items.length; i++) {
				var child= document.createElement('div');
				child.setAttribute('style', 'margin-bottom: 15px;')
				child.setAttribute('class', 'product');
				var description= items[i].productContent;
				description= description.length > 50 ? description.substring(0, 50) + '...' : description
				child.innerHTML= html.replace('${path}', items[i].productImageUrl)
									 .replace('${name}', items[i].productDescription)
									 .replace('${place}', items[i].placeName)
									 .replace('${description}', description);
				
				area[i%2].appendChild(child);
			}
		});
	});
}

function addToTopBtnEvent() {
	var ele= document.getElementById('areaBtnToTop');
	ele.addEventListener("click", function() {
		window.scrollTo(0, 0);
	});
}