package com.areap2.config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

	private final JwtAuthenticationFilter jwtAuthFilter;

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.csrf(csrf -> csrf.disable()).cors(cors -> cors.configurationSource(corsConfigurationSource()))
				.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
				.authorizeHttpRequests(auth -> auth.requestMatchers("/masterData/add/**").authenticated()
						.requestMatchers("/masterData/update/**").authenticated()
						.requestMatchers("/masterData/delete/**").authenticated().requestMatchers("/audit/update/**")
						.authenticated().anyRequest().permitAll())
				.addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);

		return http.build();
	}

	@Bean
	public org.springframework.web.cors.CorsConfigurationSource corsConfigurationSource() {
		org.springframework.web.cors.CorsConfiguration config = new org.springframework.web.cors.CorsConfiguration();

		//config.setAllowedOrigins(List.of("http://localhost:3000", "http://localhost:4200"));
	//	config.setAllowedOrigins(List.of("http://localhost:8081", "http://localhost:8081"));
		config.addAllowedOriginPattern("*");   // VERY IMPORTANT FIX
		config.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "OPTIONS"));
		config.setAllowedHeaders(List.of("*"));
		config.setExposedHeaders(List.of("Authorization"));
		config.setAllowCredentials(true);

		org.springframework.web.cors.UrlBasedCorsConfigurationSource source = new org.springframework.web.cors.UrlBasedCorsConfigurationSource();

		source.registerCorsConfiguration("/**", config);

		return source;
	}

}

//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//            .csrf(csrf -> csrf.disable())
//            .cors(cors -> cors.disable())
//            .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
//            .authorizeHttpRequests(auth -> auth
//                .requestMatchers("/masterData/add/**").authenticated() 
//                .requestMatchers("/masterData/update/**").authenticated() 
//                .requestMatchers("/masterData/delete/**").authenticated() 
//                .requestMatchers("/audit/update/**").authenticated() 
////                .requestMatchers("/areap2/admin/**").hasRole("10001")
//                .anyRequest().permitAll()
//            )
//            .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);
//
//        return http.build();
//    }
//
//
//}

//old version
//@Bean
//public PasswordEncoder passwordEncoder() {
//  return new BCryptPasswordEncoder();
//}
//
//
//@Bean
//public DaoAuthenticationProvider authenticationProvider() {
//  DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
//  daoAuthenticationProvider.setUserDetailsService(userDetailsService);
//  daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
//  return daoAuthenticationProvider;
//}
//
//@Bean
//public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
//  return authenticationConfiguration.getAuthenticationManager();
//}