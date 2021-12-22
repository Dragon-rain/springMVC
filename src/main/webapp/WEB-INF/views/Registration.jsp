<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Registration</title>
</head>
<body>
	<div>
		<a href='/springMVC/'> Main page </a>
		<a href='/springMVC/posts'> Posts Board </a>
		<a href='/springMVC/chat-page'> Chat room </a>
	</div>
	<h1>회원가입</h1>
	
	<form name="registration" action="registration" method="post" onsubmit="return check_pass()">
		<div>
			<input name="username" placeholder="username" required="required"/>
		</div>
		<div>
			<input name="password" placeholder="password" type="password" required="required"/>
		</div>
		<div>
			<input name="confirm_password" placeholder="repeat password" type="password" required="required"/>
		</div>
		<button type="submit" >회원가입</button>
	</form>
	<script type="text/javascript">
		
		function check_pass() {
		    if (document.forms["registration"]["password"].value ==
		    	document.forms["registration"]["confirm_password"].value) {
		        document.forms["registration"].submit();
		    } else {
		        alert('password not match')
		        return false;
		    }
		};
		
	</script>
</body>
</html>