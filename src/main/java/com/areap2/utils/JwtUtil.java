package com.areap2.utils;

import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.List;

import javax.crypto.SecretKey;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.PostConstruct;

@Component
public class JwtUtil {

	private static final Logger log = LoggerFactory.getLogger(JwtUtil.class);

	@Value("${SECRET_KEY}")
	private String secretKeyString;

	private SecretKey secretKey;

	@PostConstruct
	private void initSecretKey() {
		secretKey = Keys.hmacShaKeyFor(secretKeyString.getBytes(StandardCharsets.UTF_8));
		log.info("JWT SecretKey initialized successfully");
	}

	// ✅ Validate token
	public boolean validateToken(String token) {
		try {
			Jwts.parser() // use parser() in 0.12.x
					.verifyWith(secretKey) // instead of setSigningKey()
					.build().parseSignedClaims(token); // instead of parseClaimsJws()

			log.debug("JWT token validated successfully");
			return true;
		} catch (JwtException e) {
			log.warn("Invalid JWT token: {}", e.getMessage());
			return false;
		}
	}

	// ✅ Extract loginId (subject) from JWT
	public String extractLoginId(String token) {
		try {
			Claims claims = Jwts.parser().verifyWith(secretKey).build().parseSignedClaims(token).getPayload(); // get
																												// Claims
																												// payload

			return claims.getSubject();
		} catch (JwtException e) {
			log.error("Failed to extract loginId from JWT: {}", e.getMessage(), e);
			return null;
		}
	}

	// ✅ Extract roles from JWT
	public List<String> extractRoles(String token) {
		try {
			Claims claims = Jwts.parser().verifyWith(secretKey).build().parseSignedClaims(token).getPayload();

			return claims.get("roles", List.class);
		} catch (JwtException e) {
			log.error("Failed to extract roles from JWT: {}", e.getMessage(), e);
			return Collections.emptyList();
		}
	}

}
