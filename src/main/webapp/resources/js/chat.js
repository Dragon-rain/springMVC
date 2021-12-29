var wsUrl;
let state = {
	messageType: "GLOBAL",
	user: {},
	usersList: {},
	receiver: {},
	messageList: {}
};

window.onload = function async () {
	let usersList = JSON.parse(document.getElementById("usersList").value.toString());
	let user = JSON.parse(document.getElementById("user").value.toString());
	state = {...state, usersList, user};
		
};

if (window.location.protocol == 'http:') {
    wsUrl = 'ws://';
} else {
    wsUrl = 'wss://';
};

var ws = new WebSocket(wsUrl + window.location.host + "/springMVC/chat");

function messageFilter(element, message) {
	if(message.type == state.messageType) {
		let members = [state.user.id, state.receiver.id]
		if(state.messageType == "GLOBAL") {
			element.innerHTML+=message.text+"<br/>"
		} else if(state.messageType == "PRIVATE"&&members.includes(state.messageList.receiverId)&&members.includes(state.messageList.senderId)) {
			element.innerHTML+=message.text+"<br/>"
		}
		
	} else if (message.type != state.messageType) {
		
	}
}
	        
ws.onmessage = function(event) {
	let mySpan = document.getElementById("chat");
	state.messageList = JSON.parse(event.data.toString());
	console.log(state.messageList);
	if(Array.isArray(state.messageList)) {
		state.messageList.map(message => mySpan.innerHTML+=message.text+"<br/>");
	} else {
		messageFilter(mySpan, state.messageList);
	}
	
};
	     
ws.onerror = function(event){
	console.log("Error ", event)
};

function sendMsg() {
	let messageData = {
		senderId: state.user.id,
		receiverId: state.receiver.id,
		text: state.user.username+": "+document.getElementById("msg").value.toString(),
		type: state.messageType,
		method: "POST"
	}
	if(messageData.text) {
	   ws.send(JSON.stringify(messageData));
	}
	document.getElementById("msg").value="";
};

function openPrivateChat(event) {
	let receiver = JSON.parse(event.value);
	state.messageType = "PRIVATE";
	state.receiver = receiver;
	let messageData = {
		senderId: state.user.id,
		receiverId: receiver.id,
		type: state.messageType,
		method: "GET"
	}
	document.getElementById("chat").innerHTML = "";
	document.getElementById("chat-label").innerHTML = "Chat with: "+receiver.username;
	ws.send(JSON.stringify(messageData));
};

function openGlobalChat() {
	state.messageType = "GLOBAL";
	state.receiver = "";
	let messageData = {
		senderId: state.user.id,
		receiverId: "",
		type: state.messageType,
		method: "GET"
	}
	document.getElementById("chat").innerHTML = "";
	document.getElementById("chat-label").innerHTML = "Global Chat";
	ws.send(JSON.stringify(messageData));
};

	