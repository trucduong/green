package com.green.example.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityWebConfig extends WebSecurityConfigurerAdapter {
	// @Bean
	// public UserDetailsService userDetailsService() {
	// InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
	//// manager.createUser(User.withDefaultPasswordEncoder().username("user").password("password").roles("USER").build());
	// return manager;
	// }

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.authorizeRequests()
			.anyRequest().authenticated()
			.antMatchers("/resources/**").permitAll() 
			.antMatchers("/admin/**").access("hasRole('ADMIN')")
		.and()
			.formLogin()
			.loginPage("/login")
			.loginProcessingUrl("/handleLogin")
			.usernameParameter("username")
			.passwordParameter("password")
			.permitAll()
		.and().csrf()
		.and().exceptionHandling().accessDeniedPage("/denied");
	}

}
