package com.areap2.utils;

import java.nio.charset.StandardCharsets;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Component
public class Old_JwtUtil {

	@Value("${SECRET_KEY}")
	private String SECRET_KEY ;
	
	 private SecretKey getSecretKey() {
	        return Keys.hmacShaKeyFor(SECRET_KEY.getBytes(StandardCharsets.UTF_8));
	    }
	
    public boolean validateToken(String token) {
        try {
            Jwts.parser()
                .verifyWith(getSecretKey())
                .build()
                .parseSignedClaims(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    public String extractLoginId(String token) {
    	try {
    		 return Jwts.parser()
    	                .verifyWith(getSecretKey())
    	                .build()
    	                .parseSignedClaims(token)
    	                .getPayload()
    	                .getSubject();
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    	return "";
       
    }
	
}
