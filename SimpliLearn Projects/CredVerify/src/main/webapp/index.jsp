<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Credentials Verification</title>

</head>
<body>

<h2>Login Form</h2>
<form action="login" method="post" name="form_name" id="form_id" class="form_class" >
  <label for="username">Username:</label><br>
  <input type="text" id="username" name="username"><br>
  <label for="password">Password:</label><br>
  <input type="password" id="password" name="password"><br>  
  <input type="submit" value="Submit">
</form>

<p><a href="register">Registration</a> <br></p>

</body>
</html>