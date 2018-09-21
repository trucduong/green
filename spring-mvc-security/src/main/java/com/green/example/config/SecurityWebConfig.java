package com.green.example.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.security.authentication.AuthenticationTrustResolverImpl;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
@EnableWebSecurity
@ComponentScan({ "com.green.example" })
public class SecurityWebConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService userDetailService;
	
	@Bean
	public AuthenticationTrustResolver getAuthenticationTrustResolver() {
	    return new AuthenticationTrustResolverImpl();
	}
	
	@Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.authorizeRequests()
			.anyRequest().authenticated()
			.antMatchers("/resources/**").permitAll() 
//			.antMatchers("/admin/**").access("hasRole('ADMIN')")
		.and()
			.formLogin()
			.loginPage("/login")
			.loginProcessingUrl("/handleLogin")
			.usernameParameter("username")
			.passwordParameter("password")
			.permitAll()
		.and()
			.logout().logoutUrl("/logout")
		.and().csrf()
		.and().exceptionHandling().accessDeniedPage("/denied")
		.and().userDetailsService(userDetailService);
	}

}
