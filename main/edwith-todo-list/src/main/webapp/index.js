/**
 * 
 */
function getTasks() {
	var req= new XMLHttpRequest();
	req.addEventListener("load", function(){
		console.log(this.responseText);
	});
	req.open("GET", "http://localhost:8080/todo/tasks");
	req.send();
}

getTasks();
