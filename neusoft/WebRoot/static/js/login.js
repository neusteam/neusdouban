const button = _prime(".login_button");

button.addEventListener("click",()={
	ajax({
		type:"post",
		timeOut:5000
	});
});