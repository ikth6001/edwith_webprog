package com.ikth.apps.reservation.auth;

import java.util.Date;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component("tokenManager")
public class JwtTokenManager implements ITokenManager {
	
	private final String BEARER_PREFIX= "Bearer";
	
	private final String SECRET= "edwith.project";
	private final long EXPIRATION= 600000; // TODO 10M
	
	@Override
	public Authentication getAutentication(String token) 
	{
		if(StringUtils.isEmpty(token)) {
			return null;
		}
		
		final String userName= getUserName(token);
		
		/**
		 * TODO UserService?? 매번 조회를..??
		 */
		return new UsernamePasswordAuthenticationToken(new User(userName, "password"), "");
	}
	
	private String getUserName(String token) {
		return Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token).getBody().getSubject();
	}
	
	@Override
	public boolean validateToken(String token) {
		Jws<Claims> claims=
				Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token);
		
		if(claims.getBody().getExpiration().before(new Date())) {
			return false;
		}
		
		return true;
	}

	@Override
	public String resolveToken(ServletRequest request) 
	{
		String bearer= ((HttpServletRequest) request).getHeader("Authorization");
		
		if(StringUtils.isEmpty(bearer)
				|| !bearer.startsWith(BEARER_PREFIX)) {
			return null;
		}
		
		return bearer.substring(BEARER_PREFIX.length());
	}

	@SuppressWarnings("deprecation")
	@Override
	public String createToken(String userName) {
		Claims claims= Jwts.claims().setSubject(userName);
		
		Date now= new Date();
		Date expiration= new Date(now.getTime() + EXPIRATION);
		
		return Jwts.builder()
				   .setClaims(claims)
				   .setIssuedAt(now)
				   .setExpiration(expiration)
				   .signWith(SignatureAlgorithm.HS256, SECRET)
				   .compact();
	}

	
}
