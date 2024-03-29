package com.example.springsecurityjwt.configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.example.springsecurityjwt.filter.JwtAuthFilter;
import com.example.springsecurityjwt.service.JpaDataUserDetailsService;

@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private JpaDataUserDetailsService jpaDataUserDetailsService;

	@Autowired
	private JwtAuthFilter jwtAuthFilter;
	
	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(jpaDataUserDetailsService);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable()
		.authorizeRequests()		
		.antMatchers("/user").hasAnyRole("USER","ADMIN")
		.antMatchers("/admin").hasRole("ADMIN")
		.antMatchers("/test").permitAll()
		.antMatchers("/authenticate").permitAll()
		.antMatchers("/h2-console/**").permitAll()
		.anyRequest().authenticated().and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		http.addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);
		http.headers().frameOptions().disable();  		
	}
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}

	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}
}
