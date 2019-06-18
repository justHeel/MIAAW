var fetchoptions = { 
		method: 'GET',
		headers: {
			'Accept': 'application/json',
			'Content-Type': 'application/json'
}
}
fetch("/basicbar", fetchoptions).then(function(res) {
    return res.text();
}).then(function(res) {
	var txtarea = document.getElementById("CodeEditor")
	txtarea.innerHTML = res;
});

document.getElementById("UpdateBasicBarCode").addEventListener("click", function(){
	var fetchoptions = { 
			method: 'POST',
			headers: {
				'Accept': 'application/json',
				'Content-Type': 'application/json'
	}, body : JSON.stringify({'code' : document.getElementById("CodeEditor").value})
	}
	fetch("/basicbar", fetchoptions).then(function(res) {
	    return res.text();
	}).then(function(res) {
		console.log("done");
		location.reload();
	});
});