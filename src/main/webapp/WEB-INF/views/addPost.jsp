<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>Add Post</title>
<link rel='stylesheet' type='text/css' href='css/main.css'>
</head>
<body>
	<div>
		<a href='/springMVC/'> Main page </a>
		<a href='/springMVC/posts'> Posts Board </a>
		<a href='/springMVC/chat-page'> Chat room </a>
	</div>
	<form method="post">
		<div>
			<label>Title:</label><br/>
			<input name="title" placeholder="title" required="required"/>
		</div>
		<div>
			<label>Description:</label><br/>
			<textarea name="description" placeholder="description" required="required"></textarea>
		</div>
		<input name="success" value="true" hidden="true"/>
		<button type="submit" >add</button>
	</form>
</body>
</html>