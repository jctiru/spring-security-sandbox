<%@ taglib
	prefix="form"
	uri="http://www.springframework.org/tags/form"%>
<%@ taglib
	prefix="c"
	uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>

<head>
<meta
	name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link
	rel="stylesheet"
	href="https://bootswatch.com/4/sandstone/bootstrap.min.css">
<title>Log-in Page</title>
</head>

<body>
	<div class="container my-5">
		<div class="row">
			<div class="col-md-6 mx-auto">
				<div class="card border-secondary card-body bg-light mt-5 mb-5">
					<h2>Login</h2>
					<p>Please fill in your credentials to log in</p>
					<form:form
						action="${pageContext.request.contextPath}/authenticate-login"
						method="POST">
						<%-- Check for login error --%>
						<c:if test="${param.error != null }">
							<div class="alert alert-danger">
								<strong>Invalid username/password</strong>
							</div>
						</c:if>
						<%-- Check for logout --%>
						<c:if test="${param.logout != null }">
							<div class="alert alert-info">
								<strong>You have been logged out</strong>
							</div>
						</c:if>
						<div class="form-group">
							<label for="email">Username: </label> <input
								class="form-control"
								type="text"
								name="username" />
						</div>
						<div class="form-group">
							<label for="password">Password: </label><input
								class="form-control"
								type="password"
								name="password" />
						</div>
						<div class="row">
							<div class="col-10 mx-auto">
								<input
									class="btn btn-primary btn-block"
									type="submit"
									value="Login" />
							</div>
						</div>
					</form:form>
				</div>
			</div>
		</div>
	</div>
</body>

</html>