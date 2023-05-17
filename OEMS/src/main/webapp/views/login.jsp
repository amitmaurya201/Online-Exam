<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"></script>

<style>
@import
	url("https://fonts.googleapis.com/css2?family=Poppins&display=swap");

* {
	margin: 0px;
	padding: 0px;
	box-sizing: border-box;
	font-family: "Poppins", sans-serif;
}

.flex-r, .flex-c {
	justify-content: center;
	align-items: center;
	display: flex;
}

.flex-c {
	flex-direction: column;
}

.flex-r {
	flex-direction: row;
}

.container {
	width: 100%;
	min-height: 100vh;
	padding: 20px 10px;
	background: #e5e5e5;
}

.login-text {
	background-color: #3385ff;
	width: 700px;
	max-width: 500px;
	min-height: 500px;
	margin-top: 35px;
	border-radius: 10px;
	padding: 10px 20px;
}

.logo {
	margin-bottom: 20px;
}

.logo-name {
	font-size: 45px;
	color: #000;
}
/* .logo span,
 {
  font-size: 55px;
  color: #000;
} */
.login-text h1 {
	font-size: 25px;
}

.login-text p {
	font-size: 15px;
	color: #000000b2;
}

form {
	align-items: flex-start !important;
	width: 100%;
	margin-top: 15px;
}

.input-box {
	margin: 10px 0px;
	width: 100%;
}

.label {
	font-size: 15px;
	color: black;
	margin-bottom: 3px;
}

.input {
	background-color: #f6f6f6;
	padding: 0px 5px;
	border: 2px solid rgba(216, 216, 216, 1);
	border-radius: 10px;
	overflow: hidden;
	justify-content: flex-start;
}

input {
	border: none;
	outline: none;
	padding: 10px 5px;
	background-color: #f6f6f6;
	flex: 1;
}

.input i {
	color: rgba(0, 0, 0, 0.4);
}

.check span {
	color: #000000b2;
	font-size: 15px;
	font-weight: bold;
	margin-left: 5px;
}

.btn {
	color: #ffffff;
	border-radius: 30px;
	padding: 10px 15px;
	background: linear-gradient(122.33deg, #68bed1 30.62%, #1e94e9 100%);
	margin-top: 30px;
	margin-bottom: 10px;
	font-size: 16px;
	transition: all 0.3s linear;
}

.btn:hover {
	transform: translateY(-2px);
}

.extra-line {
	font-size: 15px;
	font-weight: 600;
}

.extra-line a {
	color: #0095b6;
}
</style>

<!-- icons  -->
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.15.4/css/all.css">

<body>
<body background="static/img/back.jpg">
	
	<div class=" flex-r container-fluid">
		<div class="flex-r login-wrapper">
			<div class="login-text">
				<div class="logo">
					<span><img src="static/img/download.png" alt="logo"
						width="70" height="70"></span> <span class="logo-name"
						style="text-align: center">Adjecti Solutions</span>
				</div>
				<h1>Login</h1>
				<h1>User/Admin</h1>
				<form:form action="/login" method="post">
					<div class="input-box">
						<span class="label">User Name</span>
						<div class=" flex-r input">
							<input type="text" placeholder="Username" name="username">

						</div>
					</div>

					<div class="input-box">
						<span class="label">Password</span>
						<div class="flex-r input">
							<input type="password" placeholder="Password" name="password">

						</div>
					</div>


					<input class="btn" class="btn btn-danger" type="submit"
						value="Submit">
				</form:form>

			</div>
		</div>
	</div>

</body>
