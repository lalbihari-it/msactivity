/**
 * 
 */
package com.ibm.vicky.login.service.util;

import java.util.Date;
import java.util.function.Function;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

@Component
public class JwtUtil {
	
	private String SECRET_KEY_TRANSACTION = "txnsecret";


	public Boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

	 public String extractUsername(String token) {
	        return extractClaim(token, Claims::getSubject);
	    }

	 public Date extractExpiration(String token) {
	        return extractClaim(token, Claims::getExpiration);
	    }
	 
	 public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
	        final Claims claims = extractAllClaims(token);
	        return claimsResolver.apply(claims);
	    }
	 
	 private Claims extractAllClaims(String token) {
	        return Jwts.parser().setSigningKey(SECRET_KEY_TRANSACTION).parseClaimsJws(token).getBody();
	    }
}	