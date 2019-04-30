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
	
	fetch("/enhance/link", fetchoptions).then(function(res) {
	    return res.text();
	}).then(function(html) {
	    editedPage = (`${html}`);
	    console.log(editedPage);
	    downloadFile(editedPage);
	});
});

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