package io.jctiru.springsecuritysandbox.service;

import io.jctiru.springsecuritysandbox.entity.User;
import io.jctiru.springsecuritysandbox.user.CrmUser;

public interface UserService {

	User findByUserName(String userName);

	void save(CrmUser crmUser);

}
