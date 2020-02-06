<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration Page</title>
</head>
<body bgcolor="#E6E6FA">
<center>
<h1>Welcome to Registration page</h1><hr>
<br>
${dto }
<form action="registrationData" method="post">
<pre>
User Name<br><input type="text" name="User_name" required><br>
Email<br><input type="email" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$" name="email" title="Email must contain '@' and '.' " required ><br>
Password<br><input type="password" name="password" required><br>
<h3>Security Question!!!!!!!!</h3><select name="Questions">
<option value="What is your nickname?">What is your nickname?</option>
<option value="What is your pet name?">What is your pet name?</option>
<option value="What is your favourite colour?">What is your favourite colour?</option>
<option value="What is your favourite place to visit?">What is your favourite place to visit?</option>
<option value="How many siblings do you have?">How many siblings do you have?</option></select>
<h3>Answer</h3><input type="answer" name="answer" required><br>
<input type="submit" value="Register"><br>
<a href="login">Login</a>
</pre>
</form>
</center>
</body>
</html>