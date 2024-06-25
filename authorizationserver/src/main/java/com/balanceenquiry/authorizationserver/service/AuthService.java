package com.balanceenquiry.authorizationserver.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.balanceenquiry.authorizationserver.entity.UserInfo;
import com.balanceenquiry.authorizationserver.repository.UserInfoRepository;

@Service
public class AuthService {

	@Autowired
	private UserInfoRepository userInfoRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private JWTService jwtService;
	
	public String saveUser(UserInfo userInfo) {
		userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword()));
		userInfoRepository.save(userInfo);
		
		return "User added to the system successfully";
	}
	
	public String generateToken(String username) {
		return jwtService.generateToken(username);
	}
	
//	public void validateToken(String token) {
//		jwtService.validateToken(token);
//	}
}
