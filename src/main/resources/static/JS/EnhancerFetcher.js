document.getElementById("generateButton").addEventListener("click", function(){
	values = document.getElementById("textToSpeechCheck").checked;
	console.log(values)
});;

	formOpties = document.getElementById("formOptiesCheck").checked
	videoOpties = document.getElementById("videoOptiesCheck").checked
	textToSpeech = document.getElementById("textToSpeechCheck").checked
	basicBar = document.getElementById("basicBarCheck").checked



document.getElementById("FetchViaLinkFormButton").addEventListener("click",function() {
	
	if(document.getElementById("formOptiesCheck").checked == true){
		document.getElementById("formOptiesCheck").value = +true;
	}else{
			document.getElementById("formOptiesCheck").value = null;
		}
		console.log(document.getElementById("formOptiesCheck").value)
	if(document.getElementById("videoOptiesCheck").checked == true){
		document.getElementById("videoOptiesCheck").value = +true;
	}else{
			document.getElementById("videoOptiesCheck").value = null;
		}
		console.log(document.getElementById("videoOptiesCheck").value)
	if(document.getElementById("textToSpeechCheck").checked == true){
		document.getElementById("textToSpeechCheck").value = +true;
	}else{
			document.getElementById("textToSpeechCheck").value = null;
		}
		console.log(document.getElementById("textToSpeechCheck").value)
	if(document.getElementById("basicBarCheck").checked == true){
		document.getElementById("basicBarCheck").value = +true;
	}else{
			document.getElementById("basicBarCheck").value = null;
		}
		console.log(document.getElementById("basicBarCheck").value)
	
	var fetchJson = {
			"link" : document.getElementById("linkFetchField").value,
			"formOpties" : document.getElementById("formOptiesCheck").value,
			"videoOpties" : document.getElementById("videoOptiesCheck").value,
			"textToSpeech" : document.getElementById("textToSpeechCheck").value,
			"basicBar" : document.getElementById("basicBarCheck").value
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
	
	fetch("/enhance/link", fetchoptions).then(function(res) {
	    return res.text();
	}).then(function(html) {
	    editedPage = (`${html}`);
	    console.log(editedPage);
	    downloadFile(editedPage);
	});
});

document.getElementById("FetchViaFileFormButton").addEventListener("click",function() {

	if(document.getElementById("formOptiesCheck").checked == true){
		document.getElementById("formOptiesCheck").value = +true;
	}else{
			document.getElementById("formOptiesCheck").value = +false;
		}
		console.log(document.getElementById("formOptiesCheck").value)
	if(document.getElementById("videoOptiesCheck").checked == true){
		document.getElementById("videoOptiesCheck").value = +true;
	}else{
			document.getElementById("videoOptiesCheck").value = +false;
		}
		console.log(document.getElementById("videoOptiesCheck").value)
	if(document.getElementById("textToSpeechCheck").checked == true){
		document.getElementById("textToSpeechCheck").value = +true;
	}else{
			document.getElementById("textToSpeechCheck").value = +false;
		}
		console.log(document.getElementById("textToSpeechCheck").value)
	if(document.getElementById("basicBarCheck").checked == true){
		document.getElementById("basicBarCheck").value = +true;
	}else{
			document.getElementById("basicBarCheck").value = +false;
		}
		console.log(document.getElementById("basicBarCheck").value)
	
	var fetchJson = {
			"file" : document.getElementById("fileFetchField").value,
			"formOpties" : document.getElementById("formOptiesCheck").value,
			"videoOpties" : document.getElementById("videoOptiesCheck").value,
			"textToSpeech" : document.getElementById("textToSpeechCheck").value,
			"basicBar" : document.getElementById("basicBarCheck").value
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
	
	fetch("/enhance/file", fetchoptions).then(function(res) {
	    return res.text();
	}).then(function(html) {
	    editedPage = (`${html}`);
	    console.log(editedPage);
	    downloadFile(editedPage);
	});
});

document.get
function downloadFile(data, filename){

	    if(!data) {
	        console.error('Console.save: No data')
	        return;
	    }

	    if(!filename) filename = 'edited.html'

	    if(typeof data === "object"){
	        data = JSON.stringify(data, undefined, 4)
	    }

	    var blob = new Blob([data], {type: 'text/html'}),
	        e    = document.createEvent('MouseEvents'),
	        a    = document.createElement('a')

	    a.download = filename
	    a.href = window.URL.createObjectURL(blob)
	    a.dataset.downloadurl =  ['text/html', a.download, a.href].join(':')
	    e.initMouseEvent('click', true, false, window, 0, 0, 0, 0, 0, false, false, false, false, 0, null)
	    a.dispatchEvent(e)
	 }