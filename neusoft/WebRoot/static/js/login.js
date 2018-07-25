const button = _prime(".login-button");

button.addEventListener("click",()=>{
	ajax({
		type:"post",
		timeOut:5000
	});
});