console.log("Xin chào");
const url = "http://localhost:8080/SOF3021_IT15301/demo-api";
fetch(url)
	.then(function (response) {
		return response.text()
	})
	.then(function (data) {
		console.log(data)
	})
