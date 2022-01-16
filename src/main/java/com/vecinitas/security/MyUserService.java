package com.vecinitas.security;

import java.util.ArrayList;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserService implements UserDetailsService{

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
	
		return  new User("ana","$2a$12$iTLT4mFhkz161DeuXYHdgOsH2jhX80ySactt0cu88r91MqwG3lAZu", new ArrayList<>());
	}

	

}
