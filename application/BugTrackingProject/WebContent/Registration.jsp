<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="./css/bootstrap.css">
<link rel="stylesheet" href="./css/style1.css">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- <link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script src="./js/validateRegister.js"></script> -->
</head>
<body >

	<div class="container" style="width: 30%; margin-top: 50px;">
		<h2 style="text-align: center">User Registration</h2>
		<form action="register" method="post">
			<div class="form-group">
				<label for="email"><b>Email:</b></label> <input type="email"
					class="form-control" id="email" placeholder="Enter email"
					name="email" autofocus required>
			</div>
			<div class="form-group">
				<label for="role"><b>Select Role</b></label> <select id="role" name="role"
					class="form-control">
					<option value="tester" selected>Tester</option>
					<option value="developer">Developer</option>
					<option value="project manager">Manager</option>
				</select>
			</div>
			<div class="form-group">
				<label for="pass"><b>Password:</b></label> <input type="password"
					class="form-control" name="pass" id="pass"
					pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*]).{8,}"
					required placeholder="strong password">
			</div>
			<span>Note: Enter a strong password (min. 8 characters) containing atleast 1
				number, 1 lowercase, 1 uppercase character and 1 special character</span>
			<p></p>
			<div class="form-group">
				<label for="cpass"><b>Confirm Password:</b></label> <input type="password"
					class="form-control" name="cpass" id="cpass"
					pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*]).{8,}"
					required placeholder="strong password">
			</div>
			<p id="errpass">
			<div style="text-align: center; margin-top: 30px;">
				<button type="submit" class="btn btn-primary">Register</button>
			</div>
		</form>
	</div>
</body>
</html>