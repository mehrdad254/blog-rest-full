package com.mhr.blog.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import com.mhr.blog.modules.users.entity.Users;
import com.mhr.blog.modules.users.repository.UsersRepository;

@Service
public class Oauth2UserService extends DefaultOAuth2UserService{
	
	@Autowired
	private UsersRepository userRepository;
	
	@Override
	public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
		OAuth2User auth2User = super.loadUser(userRequest);
		
		Users users = userRepository.findByEmail(auth2User.getAttribute("email"));
		
		if(users == null) {
			users = new Users();
			users.setEmail(auth2User.getAttribute("email"));
		}
		
		users.setName(auth2User.getAttribute("name"));
		users.setPicture(auth2User.getAttribute("picture"));
		users = userRepository.save(users);
		
		return users;
	}

	
}
