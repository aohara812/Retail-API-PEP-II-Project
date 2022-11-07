package com.cognixa.jump.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


import com.cognixa.jump.filter.JwtRequestFilter;

@Configuration
public class SecurityConfiguration {
	
	// when you perform dependency injection, check if any files in this app are UserDetailsService files,
	// if so, create an object of that class for this variable
	@Autowired
	UserDetailsService userDetailsService; // = new MyUserDetailsService();
	 
	@Autowired
	JwtRequestFilter jwtRequestFilter;
	
	// Authentication - who are you?
	@Bean
	protected UserDetailsService userDetailsService() {
		
		return userDetailsService;
	}
	
	// Authorization - what do you want?
	@Bean
	protected SecurityFilterChain filterChain( HttpSecurity http ) throws Exception {
		
		http.csrf().disable()
			.authorizeRequests()
			.antMatchers(HttpMethod.POST, "/api/user").permitAll()
			.antMatchers(HttpMethod.GET, "/api/user").hasRole("ADMIN")
			.antMatchers(HttpMethod.POST, "/api/product").hasRole("ADMIN")
			.antMatchers(HttpMethod.PUT, "/api/product").hasRole("ADMIN")
			.antMatchers(HttpMethod.DELETE, "/api/product").hasRole("ADMIN")
			
			
			.antMatchers("/authenticate").permitAll()
			.anyRequest().authenticated()			// need some login in order to access any of the APIs
			.and().httpBasic()
		
		
		.and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS );  // tell spring security to NOT create sessions;
	
		
	http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);

		
				
		return http.build();
	}
	
	// Encoder -> method help with encoding/decoding all the user password
	@Bean
	protected PasswordEncoder encoder() {
		
		// plain text encoder -> encode/encrypt the password
		return NoOpPasswordEncoder.getInstance();
		
		// encrypt the password with the bcrypt algorithm
		//return new BCryptPasswordEncoder();
		
	}
	
	// load in the encoder & user details service that are needed for security to do authentication & authorization
	@Bean
	protected DaoAuthenticationProvider authenticationProvider() {
		
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		
		authProvider.setUserDetailsService(userDetailsService);
		authProvider.setPasswordEncoder( encoder() );
		
		return authProvider;
	}
	
	@Bean
	protected AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
		return authConfig.getAuthenticationManager();
	}
	
	
	
}

