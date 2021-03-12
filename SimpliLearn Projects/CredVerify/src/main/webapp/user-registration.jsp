<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Credentials Verification</title>

</head>
<body>
<p><a href="index.jsp">Login</a></p>
<h2>User Registration Form</h2>
<form action="register" method="post" name="form_name" id="form_id" >
  <label for="name">Name:</label><br>
  <input type="text" id="name" name="name"><br>
  <label for="email">Email Address:</label><br>
  <input type="text" id="emailAddress" name="emailAddress"><br>
  <label for="password">Password:</label><br>
  <input type="text" id="password" name="password"><br><br>
  <input type="submit" value="Submit">
</form>



</body>
</html>