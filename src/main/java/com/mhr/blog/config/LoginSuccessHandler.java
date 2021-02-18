package com.mhr.blog.config;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.mhr.blog.enums.Authorities;

public class LoginSuccessHandler implements AuthenticationSuccessHandler {

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		
	    DefaultRedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
		
		if(authentication.getAuthorities().contains(Authorities.OP_ACCESS_ADMIN)) {
			redirectStrategy.sendRedirect(request, response, "/admin");
		}else if(authentication.getAuthorities().contains(Authorities.OP_ACCESS_USER)) {
			redirectStrategy.sendRedirect(request, response, "/user");
		}else {
			redirectStrategy.sendRedirect(request, response, "/");
		}

	}

}
