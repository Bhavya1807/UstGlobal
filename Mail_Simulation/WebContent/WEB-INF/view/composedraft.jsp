<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Compose Mail</title>
</head>
<body bgcolor="#E6E6FA">
<center><h1>Welcome to Compose Mail</h1><hr>
<form action="composedraftData" method="post">
<pre>
<input type="hidden" name="Id" value="${From_id.getId() }" >
To
<input type="email" name="To" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$" title="Email must contain '@' and '.'" value="${From_id.getSentto() }"  required ><br>
Subject
<input type="text" name="Subject" value="${From_id.getSubject() }"><br>
Message
<input type="text" name="Message" value="${From_id.getMessage() }" required ><br>
<input type="submit" value="SendMail">
</pre>
</form>
</center>
</body>
</html>