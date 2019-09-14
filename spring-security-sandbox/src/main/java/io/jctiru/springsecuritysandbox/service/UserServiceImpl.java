package io.jctiru.springsecuritysandbox.service;

import java.util.Arrays;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.jctiru.springsecuritysandbox.dao.RoleDao;
import io.jctiru.springsecuritysandbox.dao.UserDao;
import io.jctiru.springsecuritysandbox.entity.Role;
import io.jctiru.springsecuritysandbox.entity.User;
import io.jctiru.springsecuritysandbox.user.CrmUser;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {

	@Autowired
	private UserDao userDao;

	@Autowired
	private RoleDao roleDao;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Override
	@Transactional
	public User findByUserName(String userName) {
		return userDao.findByUserName(userName);
	}

	@Override
	@Transactional
	public void save(CrmUser crmUser) {
		User user = new User();
		user.setUserName(crmUser.getUserName());
		user.setPassword(passwordEncoder.encode(crmUser.getPassword()));
		user.setFirstName(crmUser.getFirstName());
		user.setLastName(crmUser.getLastName());
		user.setEmail(crmUser.getEmail());
		user.setRoles(new HashSet<Role>(Arrays.asList(roleDao.findRoleByName("ROLE_EMPLOYEE"))));
		userDao.save(user);
	}

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		User user = userDao.findByUserName(userName);

		if (user == null) {
			throw new UsernameNotFoundException("User not found.");
		}

		UserBuilder builder = org.springframework.security.core.userdetails.User.builder();
		builder.username(user.getUserName());
		builder.password(user.getPassword());
		builder.roles(user.getRoles().stream().map(role -> role.getName()).toArray(String[]::new));

		return builder.build();
	}

}
