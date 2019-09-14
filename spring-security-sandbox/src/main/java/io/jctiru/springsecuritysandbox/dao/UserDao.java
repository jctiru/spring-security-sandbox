package io.jctiru.springsecuritysandbox.dao;

import io.jctiru.springsecuritysandbox.entity.User;

public interface UserDao {

	User findByUserName(String userName);

	User findByEmail(String email);

	void save(User user);

}
