package com.cbankoue.booklist.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private UserDetailService userDetailservice;
	
	private final String API_BOOK_LIST = "api_book_list";

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
		auth.authenticationProvider(authenticationProvider());
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.authorizeRequests()
			.antMatchers(API_BOOK_LIST + "/").authenticated()
			.antMatchers(API_BOOK_LIST + "/add-book", API_BOOK_LIST + "/edit-book").hasAnyAuthority("ADMIN")
			.antMatchers(API_BOOK_LIST + "/book/**").hasAnyRole("USER")
			.and()
			.formLogin()
			.loginPage("/login")
			.and()
			.logout()
			.logoutUrl("/logout").logoutSuccessUrl("/login");
		
	}
	
	@Bean
	DaoAuthenticationProvider authenticationProvider() {
		
		DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
		authenticationProvider.setUserDetailsService(userDetailservice);
		authenticationProvider.setPasswordEncoder(new BCryptPasswordEncoder());
		
		return authenticationProvider;
	}
}
