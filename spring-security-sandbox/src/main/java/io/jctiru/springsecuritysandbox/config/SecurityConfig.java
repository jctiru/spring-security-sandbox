package io.jctiru.springsecuritysandbox.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private DataSource securityDataSource;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().dataSource(securityDataSource);
		
		// Add users for in-memory auth
		/*
		 * UserBuilder users = User.withDefaultPasswordEncoder();
		 * auth.inMemoryAuthentication()
		 * .withUser(users.username("john").password("test123").roles("EMPLOYEE"))
		 * .withUser(users.username("mary").password("test123").roles("EMPLOYEE",
		 * "MANAGER"))
		 * .withUser(users.username("susan").password("test123").roles("EMPLOYEE",
		 * "ADMIN"));
		 */
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
//				.anyRequest().authenticated()
				.antMatchers("/").hasRole("EMPLOYEE")
				.antMatchers("/leaders/**").hasRole("MANAGER")
				.antMatchers("/systems/**").hasRole("ADMIN")
				.and()
				.formLogin()
				.loginPage("/loginpage")
				.loginProcessingUrl("/authenticate-login")
				.permitAll()
				.and()
				.logout().permitAll()
				.and()
				.exceptionHandling().accessDeniedPage("/access-denied");
	}

}
