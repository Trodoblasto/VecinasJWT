package com.vecinitas.utils;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Service;
import org.springframework.web.filter.OncePerRequestFilter;

import com.vecinitas.security.MyUserService;
@Service
public class JwtRequestFilter extends OncePerRequestFilter {
	
	@Autowired
	private MyUserService userServive;
	
	@Autowired
	private JWTUtility jwtUtility;

	public JwtRequestFilter() {}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		final String authorizationHeader= request.getHeader("Authorization");
		String username=null;
		String jwt = null;
		if(authorizationHeader !=null && authorizationHeader.startsWith("Bearer ")) {
			jwt = authorizationHeader.substring(7);
			System.out.println("EL JWT ENVIADO:" + jwt );
			username = jwtUtility.getUsernameFromToken(jwt);
			System.out.println("EL USERNAME ENVIADO:" + username );
		}
		if (username !=null && SecurityContextHolder.getContext().getAuthentication() == null) {
			UserDetails userDetail = userServive.loadUserByUsername(username);
			if(jwtUtility.validateToken(jwt, userDetail)) {
				System.out.println("TOKEN VALIDADO" );
				UsernamePasswordAuthenticationToken usernamePassToken = new UsernamePasswordAuthenticationToken(
						userDetail,null,userDetail.getAuthorities()	);
				usernamePassToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				SecurityContextHolder.getContext().setAuthentication(usernamePassToken);
			}		
		} else {
			
		}
		filterChain.doFilter(request, response);		
	}

}
