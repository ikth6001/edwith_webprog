window.onload= function() {
	getTasks();
}

function getTasks() {
	var req= new XMLHttpRequest();
	req.addEventListener("load", function(){
		if(this.status != 200) {
			alert("Error while loading todo task list. [" + this.status + "]");
		} else {
			var res= JSON.parse(this.responseText);
			res.forEach(function(task){
				var container= document.createElement('div');
				container.setAttribute("id", task.id);
				container.style.cursor= "pointer";
				
				var titlePart= document.createElement('div');
				titlePart.innerHTML += task.title
				
				var mainPart= document.createElement('div');
				mainPart.innerHTML += "등록날짜 " + task.regDate + ", " + task.name;
				
				container.appendChild(titlePart);
				container.appendChild(mainPart);

				setTaskStyle(container);
				
				if(task.type === "TODO") {
					container.addEventListener('click', function(){
						updateType(container);
					});
					document.getElementById("todo").appendChild(container);
				} else if(task.type === "DOING") {
					container.addEventListener('click', function(){
						updateType(container);
					});
					document.getElementById("doing").appendChild(container);
				} else {
					document.getElementById("done").appendChild(container);
				}
			});
		}
	});
	req.open("GET", "http://localhost:8080/edwith-todo-list/todo/all");
	req.send();
}

function updateType(container) {
	var req= new XMLHttpRequest();
	var id= container.getAttribute("id");
	var reqUri= "http://localhost:8080/edwith-todo-list/todo/" + id;
	req.addEventListener("load", function(){
		if(this.status == 200) {
			location.reload();
		}
	});
	req.open("POST", reqUri);
	req.send();
}

function setTaskStyle(part) {
	part.style.backgroundColor= "yellow";
	part.style.width= "350px";
	part.style.height= "50px";
	part.style.margin= "20px";
}