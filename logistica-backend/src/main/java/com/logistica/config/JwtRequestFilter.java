package com.logistica.config;

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
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.logistica.service.impl.UserDetailsServiceImpl;

import io.jsonwebtoken.ExpiredJwtException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

@Component
public class JwtRequestFilter extends OncePerRequestFilter {
    
        private static final Logger Logger = LoggerFactory.getLogger(JwtRequestFilter.class);

	@Autowired
	private UserDetailsServiceImpl jwtUserDetailsService;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;
        
        @Override
        protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
                throws ServletException, IOException {
            try {
                String jwt = parseJwt(request);
                if (jwt != null && jwtTokenUtil.validateJwtToken(jwt)) {
                    String username = jwtTokenUtil.getUsernameFromToken(jwt);
                    UserDetails userDetails = jwtUserDetailsService.loadUserByUsername(username);
                    UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null,
                            userDetails.getAuthorities());
                    authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                    SecurityContextHolder.getContext().setAuthentication(authentication);
                }
            } catch (Exception e) {
                Logger.error("Cannot set user authentication:", e);
            }
            filterChain.doFilter(request, response);
        }
        private String parseJwt(HttpServletRequest request) {
            String headerAuth = request.getHeader("Authorization");
            if (StringUtils.hasText(headerAuth) && headerAuth.startsWith("Bearer ")) {
                return headerAuth.substring(7, headerAuth.length());
            }
            return null;
        }

//	@Override
//	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
//			throws ServletException, IOException {
//
//		final String requestTokenHeader = request.getHeader("Authorization");
//
//		String username = null;
//		String jwtToken = null;
//		// JWT Token is in the form "Bearer token". Remove Bearer word and get only the Token
//		if (requestTokenHeader != null && requestTokenHeader.startsWith("Bearer ")) {
//			jwtToken = requestTokenHeader.substring(7);
//			try {
//				username = jwtTokenUtil.getUsernameFromToken(jwtToken);
//			} catch (IllegalArgumentException e) {
//				System.out.println("Unable to get JWT Token");
//			} catch (ExpiredJwtException e) {
//				System.out.println("JWT Token has expired");
//			}
//		} else {
//			logger.warn("JWT Token does not begin with Bearer String");
//		}
//
//		//Once we get the token validate it.
//		if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
//
//			UserDetails userDetails = this.jwtUserDetailsService.loadUserByUsername(username);
//
//			// if token is valid configure Spring Security to manually set authentication
//			if (jwtTokenUtil.validateToken(jwtToken, userDetails)) {
//
//				UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
//						userDetails, null, userDetails.getAuthorities());
//				usernamePasswordAuthenticationToken
//						.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
//				// After setting the Authentication in the context, we specify
//				// that the current user is authenticated. So it passes the Spring Security Configurations successfully.
//				SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
//			}
//		}
//		chain.doFilter(request, response);
//	}

}
