<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Compose</title>
</head>
<body bgcolor="#E6E6FA">
<center><h2>Welcome to Compose Mail </h2><hr>
<form action="composeData" method="post">
<pre>
<b>To<br><input type="email" name="To" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$" title="Email must contain '@' and '.'" required><br>
Subject<br><input type="text" name="Subject" ><br>
Message<br><input type="text" name="Message" required><br></b>
<input type="submit" value="SendMail">
</pre>
</form>
</center>
</body>
</html>