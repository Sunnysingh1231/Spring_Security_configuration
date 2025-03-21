package com.configuration.confugeration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.configuration.service.myUserDetailsService;

@EnableWebSecurity
@Configuration
public class securityConfig {
	
	@Autowired
	private UserDetailsService userDetailsServ;
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
		
		return http
				
				.csrf(customi -> customi.disable())
				
				.authorizeHttpRequests(req -> req
						.requestMatchers("/","/login","/registration","/allcss.css").permitAll()
						.anyRequest().authenticated())
				
//				.formLogin(Customizer.withDefaults())
				
				.formLogin(form -> form
	                    .loginPage("/login") // Custom login page
	                    .defaultSuccessUrl("/home", true) // Redirect to homepage after successful login
	                    .permitAll()
	            )
				
				.logout(logout -> logout
	                    .logoutUrl("/logouttt")
	                    .logoutSuccessUrl("/") // Redirect to login page after logout
	                    .permitAll()
	            )
				
//				.sessionManagement(sess -> sess.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
				
				.build();
	}
	
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(10);
	}
	
	
	@Bean
	public AuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		//provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
		provider.setPasswordEncoder(new BCryptPasswordEncoder(10));
		provider.setUserDetailsService(userDetailsServ);
		return provider;
	}
	
}
