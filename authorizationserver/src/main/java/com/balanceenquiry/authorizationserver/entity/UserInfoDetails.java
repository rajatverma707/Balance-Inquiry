package com.balanceenquiry.authorizationserver.entity;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UserInfoDetails implements UserDetails{
 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String username= null;
	String password = null;
	
	List<GrantedAuthority> authorities;
	
	public UserInfoDetails(UserInfo userInfo){
	username = userInfo.getUsername();
	password = userInfo.getPassword();
	authorities = Arrays.asList("User").stream().map(SimpleGrantedAuthority::new)
			      .collect(Collectors.toList());
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return authorities;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return username;
	}

}
