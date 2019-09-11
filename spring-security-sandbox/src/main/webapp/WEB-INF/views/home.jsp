<%@ taglib
	prefix="form"
	uri="http://www.springframework.org/tags/form"%>
<%@ taglib
	prefix="security"
	uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html>
<html>

<head>
<title>Company Home Page</title>
</head>

<body>
	<h1>Welcome to company home page!</h1>
	<hr>
	<p>
		User: <security:authentication property="principal.username"/>
		<br>
		Role(s): <security:authentication property="principal.authorities"/>
	</p>
	<form:form
		action="${pageContext.request.contextPath}/logout"
		method="POST">
		<input
			type="submit"
			value="Logout" />
	</form:form>
</body>

</html>