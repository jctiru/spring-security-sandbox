package io.jctiru.springsecuritysandbox.user;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import io.jctiru.springsecuritysandbox.validation.FieldMatch;

@FieldMatch.List({
		@FieldMatch(first = "password", second = "matchingPassword", message = "The password fields must match")
})
public class CrmUser {

	@NotBlank(message = "is required")
	@Size(min = 1, message = "is required")
	private String userName;

	@NotBlank(message = "is required")
	@Size(min = 1, message = "is required")
	private String password;

	@NotBlank(message = "is required")
	@Size(min = 1, message = "is required")
	private String matchingPassword;

	@NotBlank(message = "is required")
	@Size(min = 1, message = "is required")
	private String firstName;

	@NotBlank(message = "is required")
	@Size(min = 1, message = "is required")
	private String lastName;

	@Email
	@NotBlank(message = "is required")
	@Size(min = 1, message = "is required")
	private String email;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMatchingPassword() {
		return matchingPassword;
	}

	public void setMatchingPassword(String matchingPassword) {
		this.matchingPassword = matchingPassword;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
