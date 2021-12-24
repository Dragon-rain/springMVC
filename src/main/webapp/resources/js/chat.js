var wsUrl;
let state ={
	messageType: "",
	user: {},
	
};

window.onload = function async () {
	let usersCount = parseInt(document.getElementById("usersCount").value);
	let usersList = document.getElementById("usersList").value;
	for (let i = 0; i<usersCount; i++) {
		usersList;
		console.log(usersList[3]);
	}
	let users = JSON.parse("["+usersList+"]");
	
};

if (window.location.protocol == 'http:') {
    wsUrl = 'ws://';
} else {
    wsUrl = 'wss://';
};

var ws = new WebSocket(wsUrl + window.location.host + "/springMVC/chat");
	        
ws.onmessage = function(event) {
	var mySpan = document.getElementById("chat");
	console.log(event)
	mySpan.innerHTML+=event.data+"<br/>";
};
	     
ws.onerror = function(event){
	console.log("Error ", event)
};

function sendMsg() {
	var user = document.getElementById("username").value;
	var msg = user+": "+document.getElementById("msg").value;
	if(msg) {
	   ws.send(msg);
	}
	document.getElementById("msg").value="";
};

function openPrivateChat(event) {
	state.messageType = "PRIVATE";;
	console.log(state.messageType);
	document.getElementById("chat-label").innerHTML = "Chat with: "+event.value;
};

function openGlobalChat() {
	state.messageType = "GLOBAL";
	console.log(state.messageType);
	document.getElementById("chat-label").innerHTML = "Global Chat";
};

	