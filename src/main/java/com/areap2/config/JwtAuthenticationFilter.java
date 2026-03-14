package com.areap2.config;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.areap2.utils.JwtUtil;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class JwtAuthenticationFilter extends OncePerRequestFilter {

	Logger log = LoggerFactory.getLogger(JwtAuthenticationFilter.class);

	@Autowired
	private JwtUtil jwtUtil;

//	@Override
//	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
//			throws ServletException, IOException {
//
//		String authHeader = request.getHeader("Authorization");
//
//		// Extract JWT token
//		String jwt = null;
//		String loginId = null;
//		if (authHeader != null && authHeader.startsWith("Bearer ")) {
//			jwt = authHeader.substring(7); // Remove "Bearer "
//			loginId = jwtUtil.extractLoginId(jwt); // returns String or null
//		}
//
//		// If token is valid and no authentication set, create authentication
//		if (loginId != null && SecurityContextHolder.getContext().getAuthentication() == null) {
//			if (jwtUtil.validateToken(jwt)) {
//				UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(loginId, // principal
//						null, // credentials
//						Collections.emptyList() // authorities
//				);
//				authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
//				SecurityContextHolder.getContext().setAuthentication(authToken);
//
//				log.debug("JWT authentication set for user: {}", loginId);
//			} else {
//				log.warn("JWT token is invalid for user: {}", loginId);
//			}
//		}
//
//		// Continue filter chain
//		filterChain.doFilter(request, response);
//	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		String authHeader = request.getHeader("Authorization");

		String jwt = null;
		String loginId = null;

		if (authHeader != null && authHeader.startsWith("Bearer ")) {
			jwt = authHeader.substring(7);
			loginId = jwtUtil.extractLoginId(jwt);
		}

		if (loginId != null && SecurityContextHolder.getContext().getAuthentication() == null) {
			if (jwtUtil.validateToken(jwt)) {

				// ✅ Extract roles from JWT
				List<String> roles = jwtUtil.extractRoles(jwt);

				// ✅ Convert to GrantedAuthority objects
				List<GrantedAuthority> authorities = roles.stream().map(role -> new SimpleGrantedAuthority(role))
						.collect(Collectors.toList());

				// ✅ Set authentication with authorities
				UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(loginId, null,
						authorities);

				authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				SecurityContextHolder.getContext().setAuthentication(authToken);

				log.debug("JWT authentication set for user: {} with roles: {}", loginId, roles);
			} else {
				log.warn("JWT token is invalid for user: {}", loginId);
			}
		}

		filterChain.doFilter(request, response);
	}

}
