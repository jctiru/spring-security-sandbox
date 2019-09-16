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
<title>Registration Page</title>
</head>

<body>
	<div class="container my-5">
		<div class="row">
			<div class="col-md-6 mx-auto">
				<div class="card border-secondary card-body bg-light mt-5 mb-5">
					<h2>Register</h2>
					<p>Please fill up the form to register</p>
					<form:form
						action="${pageContext.request.contextPath}/register/registration-form"
						modelAttribute="crmUser"
						novalidate="true"
						method="POST"
						>
						<%-- Check for registration error --%>
						<c:if test="${registrationError != null}">
							<div class="alert alert-danger">
								<strong>${registrationError}</strong>
							</div>
						</c:if>
						<%-- Username --%>
						<div class="form-group">
							<label for="userName">Username*: </label>
							<form:errors
								path="userName"
								cssClass="invalid-feedback d-inline" />
							<form:input
								path="userName"
								class="form-control"
								cssErrorClass="form-control is-invalid"
								type="text" />
						</div>
						<%-- Password --%>
						<div class="form-group">
							<label for="password">Password*: </label>
							<form:errors
								path="password"
								cssClass="invalid-feedback d-inline" />
							<form:input
								path="password"
								class="form-control"
								cssErrorClass="form-control is-invalid"
								type="password" />
						</div>
						<%-- Confirm password --%>
						<div class="form-group">
							<label for="matchingPassword">Confirm Password*: </label>
							<form:errors
								path="matchingPassword"
								cssClass="invalid-feedback d-inline" />
							<form:input
								path="matchingPassword"
								class="form-control"
								cssErrorClass="form-control is-invalid"
								type="password" />
						</div>
						<%-- First Name --%>
						<div class="form-group">
							<label for="firstName">First Name*: </label>
							<form:errors
								path="firstName"
								cssClass="invalid-feedback d-inline" />
							<form:input
								path="firstName"
								class="form-control"
								cssErrorClass="form-control is-invalid"
								type="text" />
						</div>
						<%-- Last Name --%>
						<div class="form-group">
							<label for="lastName">Last Name*: </label>
							<form:errors
								path="lastName"
								cssClass="invalid-feedback d-inline" />
							<form:input
								path="lastName"
								class="form-control"
								cssErrorClass="form-control is-invalid"
								type="text" />
						</div>
						<%-- Email --%>
						<div class="form-group">
							<label for="email">Email*: </label>
							<form:errors
								path="email"
								cssClass="invalid-feedback d-inline" />
							<form:input
								path="email"
								class="form-control"
								cssErrorClass="form-control is-invalid"
								type="email" />
						</div>
						<%-- Register --%>
						<div class="row">
							<div class="col-10 mx-auto">
								<input
									class="btn btn-primary btn-block"
									type="submit"
									value="Register" />
							</div>
						</div>
					</form:form>
				</div>
			</div>
		</div>
	</div>
</body>

</html>