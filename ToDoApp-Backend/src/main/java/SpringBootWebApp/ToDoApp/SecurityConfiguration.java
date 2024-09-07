<<<<<<< HEAD
package SpringBootWebApp.ToDoApp;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

//@Configuration
public class SecurityConfiguration {

//	@Bean
//	public InMemoryUserDetailsManager createUserDetailsManager() {
//				
//		UserDetails userDetails1 = createNewUser("Pawan", "Gupta");
//		UserDetails userDetails2 = createNewUser("Pulkit", "Joshi");
//		UserDetails userDetails3 = createNewUser("Pankaj", "Sharma");
//		UserDetails userDetails4 = createNewUser("Rahul", "Giri");
//		
//		return new InMemoryUserDetailsManager(
//				userDetails1, userDetails2, userDetails3, userDetails4);
//	}
//
//	private UserDetails createNewUser(String username, String password) {
//		Function<String, String> passwordencoder
//		= input -> passwordEncoder().encode(input);
//		
//		UserDetails userDetails = User.builder()
//				 .passwordEncoder(passwordencoder)
//				 .username(username)
//				 .password(password)
//				 .roles("USER", "ADMIN")
//				 .build();
//		return userDetails;
//	}
//	
//	@Bean
//	public PasswordEncoder passwordEncoder() {
//		return new BCryptPasswordEncoder();
//	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

		return http.authorizeHttpRequests
				(auth -> auth
						.requestMatchers(HttpMethod.OPTIONS, "/**").permitAll()
						.anyRequest().authenticated())

				.httpBasic(Customizer.withDefaults())

				.sessionManagement(Session -> 
				Session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))

				.csrf().disable()
//		        .headers().frameOptions().disable()

				.build();
	}
}
=======
package SpringBootWebApp.ToDoApp;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

//@Configuration
public class SecurityConfiguration {

//	@Bean
//	public InMemoryUserDetailsManager createUserDetailsManager() {
//				
//		UserDetails userDetails1 = createNewUser("Pawan", "Gupta");
//		UserDetails userDetails2 = createNewUser("Pulkit", "Joshi");
//		UserDetails userDetails3 = createNewUser("Pankaj", "Sharma");
//		UserDetails userDetails4 = createNewUser("Rahul", "Giri");
//		
//		return new InMemoryUserDetailsManager(
//				userDetails1, userDetails2, userDetails3, userDetails4);
//	}
//
//	private UserDetails createNewUser(String username, String password) {
//		Function<String, String> passwordencoder
//		= input -> passwordEncoder().encode(input);
//		
//		UserDetails userDetails = User.builder()
//				 .passwordEncoder(passwordencoder)
//				 .username(username)
//				 .password(password)
//				 .roles("USER", "ADMIN")
//				 .build();
//		return userDetails;
//	}
//	
//	@Bean
//	public PasswordEncoder passwordEncoder() {
//		return new BCryptPasswordEncoder();
//	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

		return http.authorizeHttpRequests
				(auth -> auth
						.requestMatchers(HttpMethod.OPTIONS, "/**").permitAll()
						.anyRequest().authenticated())

				.httpBasic(Customizer.withDefaults())

				.sessionManagement(Session -> 
				Session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))

				.csrf().disable()
//		        .headers().frameOptions().disable()

				.build();
	}
}
>>>>>>> f36b17aa6fafaa2f907bb8ca009d81eaa3f6b2dd
