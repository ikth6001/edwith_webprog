package com.ikth.apps.reservation.auth;

import java.util.Date;

import javax.servlet.ServletRequest;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
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
		
		String subject= getSubject(token);
		String[] segments= subject.split(":");
		String id= segments[0];
		String pw= segments[1];
		
		return new UsernamePasswordAuthenticationToken(new User(id, pw), pw);
	}
	
	private String getSubject(String token) {
		return Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token).getBody().getSubject();
	}
	
	@Override
	public boolean validateToken(String token) {
		Jws<Claims> claims= null;
		
		try {
			claims= Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token);
		} catch (ExpiredJwtException e) {
			return false;
		}
		
		if(claims.getBody().getExpiration().before(new Date())) {
			return false;
		}
		
		return true;
	}

	@Override
	public String resolveToken(ServletRequest request) 
	{
		HttpServletRequest hReq= (HttpServletRequest) request;
		String bearer= hReq.getHeader("Authorization");
		
		if(StringUtils.isEmpty(bearer)
				|| !bearer.startsWith(BEARER_PREFIX)) {
			Cookie[] cookies= hReq.getCookies();

			if(cookies != null
					&& cookies.length > 0) {
				for(Cookie cookie : cookies) {
					if(BEARER_PREFIX.equals(cookie.getName())) {
						return cookie.getValue();
					}
				}
			}
			
			return null;
		}
		
		return bearer.substring(BEARER_PREFIX.length());
	}

	@Override
	public String createToken(String userName, String userEncPw) {
		Claims claims= Jwts.claims().setSubject(userName + ":" + userEncPw);
		
		Date now= new Date();
		Date expiration= new Date(now.getTime() + EXPIRATION);
		
		return Jwts.builder()
				   .setClaims(claims)
				   .setIssuedAt(now)
				   .setExpiration(expiration)
				   .signWith(SignatureAlgorithm.HS256, SECRET)
				   .compact();
	}

//	@Override
//	public void removeToken(ServletRequest request) {
//		HttpServletRequest hReq= (HttpServletRequest) request;
//		Cookie[] cookies= hReq.getCookies();
//
//		for(Cookie cookie : cookies) {
//			if(BEARER_PREFIX.equals(cookie.getName())) {
//				cookie.setValue("");
//				cookie.setMaxAge(0);
//			}
//		}
//	}
	
}
