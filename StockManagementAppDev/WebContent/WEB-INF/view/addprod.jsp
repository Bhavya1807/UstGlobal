<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Product</title>
</head>
<body bgcolor="#E6E6FA">
<center>
<h1>Welcome...</h1>
<br>
${dto1 }
<form action="addData" method="post">
<pre>
<b>Product Name<br><input type="text" name="name" required><br>
Category<br><input type="text" name="category" required><br>
Company Name<br><input type="text" name="company" required><br>
Quantity<br><input type="number" name="quantity" required><br>
Price<br><input type="number" name="price" required><br></b>
<input type="submit" value="Add Product">
</pre>
</form>
</center>
</body>
</html>