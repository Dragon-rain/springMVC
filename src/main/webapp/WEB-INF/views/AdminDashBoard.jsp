<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Administrator page</title>
</head>
<body>
	<div>
		<a href='/springMVC/'> Main page </a>
		<a href='/springMVC/posts'> Posts Board </a>
		<a href='/springMVC/chat-page'> Chat room </a>
	</div>
	<h1>hello ${user.username}</h1>
	<span>Administrator dash board</span>
</body>
</html>