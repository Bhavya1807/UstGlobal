<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home Page</title>
</head>
<body bgcolor="#E6E6FA">
<center><h1>Welcome to Home Page</h1><hr>
<h2 style="color:#00bfff">Welcome ${dto.getUsername() }</h2>
<h3 style="color:#00bfff">${msg1 }
${msg }
${dto1 }</h3>
<h3 style="text-align:center"> <a href="addproduct">Add Product</a>|<a href="search">Search Products</a>
|<a href="viewproducts">View Products</a>|<a href="logout">Logout</a></h3>
</center>
</body>
</html>