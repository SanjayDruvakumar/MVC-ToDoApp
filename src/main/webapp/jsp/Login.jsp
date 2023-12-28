<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>LOGIN</title>
</head>
<title>TO DO</title>
<style>
body {
	display: flex;
	flex-direction: column;
	justify-content: center;
	align-items: center;
	justify-content: center;
}

fieldset {
	display: flex;
	justify-content: center;
	align-items: center;
}
</style>
</head>
<body>

<h2 style="color:red">${fail}</h2>
	<h1>ToDo Login</h1>
	<h2 style="color:green">${password}</h2>
	<br>
	<br>
	<form action="./login" method="post">
		<fieldset>
			<legend>Login Here</legend>
			<table>
				<tr>
					<th>Email</th>
					<th><input type="text" name="email"></th>
					<th style='color:red'><h6>${email}</h6></th>
				</tr>
				<tr>
					<th>Password</th>
					<th><input type="password" name="pass"></th>
					<th style='color:red'><h6>${pass}</h6></th>
				</tr>
				<tr>
					<th><a herf=""><button>Login</button></a></th>
					<th><a href="login"><button type="reset">Cancel</button></a></th>
					<th><a href="signup"><button type="button">SignUp</button></a></th>
				</tr>
			</table>
		</fieldset>
	</form>


</body>
</html>