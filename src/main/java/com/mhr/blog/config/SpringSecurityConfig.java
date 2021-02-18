package com.mhr.blog.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.mhr.blog.modules.users.service.UsersServiceImpl;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	private UsersServiceImpl usersServiceImpl;
	
	@Autowired
	private Oauth2UserService oauth2UserService;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable()
			.authorizeRequests()
			.antMatchers("/oauth2Login","/files/**","/info","/error" , "/login","/user","/admin","/users/test","/posts/test","/comments/test","/categories/test").permitAll()
			.anyRequest().authenticated().and()
		    .formLogin().loginPage("/login").usernameParameter("email")
		    .successHandler(new LoginSuccessHandler())
		    .and()
			.oauth2Login().loginPage("/oauth2Login")
			.authorizationEndpoint().baseUri("/login/oauth2")
			.and().redirectionEndpoint().baseUri("/login/callback").and()
			.userInfoEndpoint().userService(oauth2UserService)
			.and()
			.successHandler(new LoginSuccessHandler())
			.and()
			.rememberMe().rememberMeCookieName("remember")
			.tokenValiditySeconds(60).rememberMeParameter("remember")
			.and().exceptionHandling().accessDeniedPage("/error")
			.and().logout().logoutUrl("/logout").logoutSuccessUrl("/mylogout").deleteCookies("remember");
			
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(usersServiceImpl);
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	
	
}
