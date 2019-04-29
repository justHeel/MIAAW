document.getElementById("FetchViaLinkFormButton").addEventListener("click",function() {
	var fetchJson = {
			"link" : document.getElementById("linkFetchField").value
/*			"formOpties" : document.getElementById("")
			"videoOpties" :
			"textToSpeech" :
			"basicBar" :*/
	};

	var fetchoptions = { 
			method: 'POST',
			headers: {
				'Accept': 'application/json',
				'Content-Type': 'application/json'
	},
   	body:  JSON.stringify(fetchJson),
   	}
/*   	fetch("/enhance", fetchoptions)
   		.then(function(response) {
   			
   console.log(response);     
   	}).then(function(data) {console.log(data)})
   	.catch(error => console.log(error));*/
	
	fetch("/enhance", fetchoptions).then(function(res) {
	    return res.text();
	}).then(function(html) {
	    editedPage = (`${html}`);
	    console.log(editedPage);
	});
});