package io.jctiru.springsecuritysandbox.dao;

import io.jctiru.springsecuritysandbox.entity.Role;

public interface RoleDao {

	public Role findRoleByName(String theRoleName);

}
