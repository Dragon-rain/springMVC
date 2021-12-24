<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Chat</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/chat.css">
        <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/chat.js"></script>
    </head>
    <body>
    <input id="usersCount" value='${usersList.size()}' hidden="true">
    <input id="usersList" value="${usersList}" hidden="true">
    <input id="user" value='${user}' hidden="true">
		<div>
			<a href='/springMVC/'> Main page </a>
			<a href='/springMVC/posts'> Posts Board </a>
			<a href='/springMVC/chat-page'> Chat room </a>
		</div>
		<div id="chat-contaner">
			<div id="users">
				<h3>Users:</h3>	
				<c:forEach items="${usersList}" var="user">
					<button class="clickable" onclick=openPrivateChat(this) value="${user.username}">${user.username}</button><br>
				</c:forEach>	
			</div>
			<div class="clickable" onclick=openGlobalChat() >to Global chat</div>
	        <h1>Chat room</h1>
			<div id="chat-window">
				<span id="chat-label">Global chat</span>
			    <div id="chat" class="chat"></div>
			    <div>
				    <input id="username" value="${user.username}" hidden="true">
					<input type="text" name="msg" id="msg" placeholder="Enter message here"/>
			        <button onclick="return sendMsg();">Enter</button>
			    </div>
			</div>
		</div>
    </body>
</html>