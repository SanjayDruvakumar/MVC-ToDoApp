<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
body {
	display: flex;
	flex-direction: column;
	justify-content: center;
	align-items: center;
}

div {
	display: flex;
	flex-direction: column;
	justify-content: center;
	align-items: center;
}

fieldset {
	display: flex;
	flex-direction: column;
	justify-content: center;
	align-items: center;
}
</style>
</head>
<body>
	<div>
		<h1>ToDo SignUp</h1>
		<br> <br>
		<form action="signup" method="post">
			<fieldset>
				<legend>Sign Up Here</legend>
				<table>
					<tr>
						<th><h1>Enter Details For SignUp</h1></th>
					</tr>
					<tr>
						<th>Name</th>
						<th><input type="text" name="name" required="required"></th>
					</tr>
					<tr>
						<th>Email</th>
						<th><input type="text" name="eamil" required="required"></th>
					<//tr>
					<tr>
						<th>Password</th>
						<th><input type="password" name="pass" required="required"></th>
					</tr>
					<tr>
						<th>Phone Number</th>
						<th><input type="number" pattern="[0-9][10]" name="pnumber"
							required="required"></th>
					</tr>
					<tr>
						<th>Gender</th>
						<th><input type="radio" value="Male" name="gender"
							required="required">Male</th>
						<th><input type="radio" value="Female" name="gender">Female</th>
					</tr>
					<tr>
						<th>Date Of Birth</th>
						<th><input type="date" name="date" required="required"></th>
					</tr>
					<tr>
						<th><button>Create</button></th>
						<th><button type="reset">Cancel</button></th>
					</tr>
					<tr>
						<th><a href="login">Click Here if Already have Account</a></th>
					</tr>
				</table>
			</fieldset>
		</form>
	</div>
</body>
</html>