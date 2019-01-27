/**
 * MOCK DATA FOR ITEMS
 */

function init() {
	var mock_data;
	var xmlhttp = new XMLHttpRequest();
	xmlhttp.onreadystatechange = function() {
		if (xmlhttp.status == 200 && xmlhttp.readyState == 4) {
			var txt = xmlhttp.responseText;
			mock_data= JSON.parse(txt);
			initInternal(mock_data.items);
		}
	};
	xmlhttp.open("GET", "test/mockdata.txt", true);
	xmlhttp.send();
}



/*window.addEventListener('DOMContentLoaded', function() {
	init();
});*/
init();

function initInternal(items) {
	addPromotions(items);
	addCategoryClickEventListener();
	document.getElementsByClassName("categoryBtn")[0].click();
}

function addPromotions(items) {
	var element= document.getElementById('areaPromotion');
	var template= document.querySelector('#promotionTemplate').innerHTML;
	
	animate(element, template, items, 0);
}

function animate(element, template, items, idx) {
	/*window.requestAnimationFrame(function(){
		var path= items[idx%2].img;
		var html= template.replace("${path}", path);
		element.innerHTML= html;
		
		animate(element, template, items, idx+1, cnt);
	})*/
	window.setTimeout(function(){
		var path= items[idx%2].img;
		var html= template.replace("${path}", path);
		element.innerHTML= html;
		
		animate(element, template, items, idx+1);
	}, 2000)
}

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

			/* TODO Ajax를 활용한 click 결과에 따른 데이터 로드 */
		}, false);
	}
}