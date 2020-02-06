<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Page</title>
</head>
<body bgcolor="#E6E6FA">
<center><h1>Welcome to Login page</h1>
<hr>
<b>${msg }
${msg2 }
${dto }
${msg3 }
</b><br>
<form action="loginValidation" method="post">
Email<br>
<input type="email" name="email" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$" name="email" title="Email must contain '@' and '.'" required><br>
Password
<br><input type="password" name="password" required><br>
<br>
<input type="submit" value="Login"><br>
<a href="forgotpassword">Forgot Password</a>|
<a href="registration">Registration</a>
</form>
</center>
</body>
</html>