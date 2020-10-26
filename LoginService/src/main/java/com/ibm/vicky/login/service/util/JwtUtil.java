/**
 * 
 */
package com.ibm.vicky.login.service.util;

import org.springframework.http.HttpRequest;
import org.springframework.security.core.userdetails.UserDetails;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

import com.ibm.vicky.login.service.UserDetailService;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import javax.servlet.http.HttpServletRequest;

@Service
public class JwtUtil {
	
	private String SECRET_KEY_AUTH = "authsecret";
	
	private String SECRET_KEY_TRANSACTION = "txnsecret";

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
        return Jwts.parser().setSigningKey(SECRET_KEY_AUTH).parseClaimsJws(token).getBody();
    }

    private Boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    public String generateAuthToken(UserDetails userDetails) {
        Map<String, Object> claims = new HashMap<>();
        return createAuthToken(claims, userDetails.getUsername());
    }

    private String createAuthToken(Map<String, Object> claims, String subject) {

        return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10))
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY_AUTH).compact();
    }

    public String generateTxnToken(UserDetails userDetails) {
        Map<String, Object> claims = new HashMap<>();
        return createTxnToken(claims, userDetails.getUsername());
    }

    private String createTxnToken(Map<String, Object> claims, String subject) {

        return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10))
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY_TRANSACTION).compact();
    }
    
    public Boolean validateToken(String token, UserDetails userDetails) {
        final String username = extractUsername(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

	public boolean validateToken(HttpServletRequest req, UserDetailService userDetailService) {

		String header = req.getHeader("Authorization");
		String userName = null;
		String authToken = null;		
		
		try {
			
			if(header != null && header.startsWith("Bearer ")) {
				authToken = header.replace("Bearer ", "");
				userName = extractUsername(authToken);
			}
			if(userName != null) {
				
				UserDetails userDetails = userDetailService.loadUserByUsername(userName);
				
				if(validateToken(authToken, userDetails))
					return true;
			}else
				return false;
		} catch (Exception e) {
			System.out.println("Incorrect username or password"+ e);
		}
		return false;
	}
}
	
	
	/*
	 * public String generateToken(UserDetails userDetails) {
	 * 
	 * String token = null;
	 * 
	 * try { final Authentication authentication = authManager.authenticate( new
	 * UsernamePasswordAuthenticationToken(userDetails.getUsername(),
	 * userDetails.getUsername()));
	 * SecurityContextHolder.getContext().setAuthentication(authentication);
	 * 
	 * }catch() {
	 * 
	 * }finally {
	 * 
	 * }
	 * 
	 * return token; }
	 */

