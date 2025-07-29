//package org.ironhack.Food_Punck.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.config.Customizer;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.web.SecurityFilterChain;
//
////@Configuration
////@EnableWebSecurity
//public class SecurityConfig {
//
//	//// below methods establishes https connection to all calls. will update later when user and store require authentication
//	///  link: https://www.codejava.net/frameworks/spring-boot/fix-websecurityconfigureradapter-deprecated
//	@Bean
//	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//	    http.csrf(AbstractHttpConfigurer::disable)
//	      .authorizeHttpRequests(authorizationManagerRequestMatcherRegistry ->
//	              authorizationManagerRequestMatcherRegistry.requestMatchers(HttpMethod.DELETE).hasRole("ADMIN")
//	                     // .requestMatchers("/admin/**").hasAnyRole("ADMIN")
//	                    //  .requestMatchers("/user/**").hasAnyRole("USER", "ADMIN")
//	                    //  .requestMatchers("/login/**").permitAll()
//	                      .anyRequest().authenticated())
//	      .httpBasic(Customizer.withDefaults())
//	      .sessionManagement(httpSecuritySessionManagementConfigurer -> httpSecuritySessionManagementConfigurer.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
//
//	    return http.build();
//	}
//	
//}
