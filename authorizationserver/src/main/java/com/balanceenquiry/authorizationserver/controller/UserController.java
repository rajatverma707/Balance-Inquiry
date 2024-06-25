package com.balanceenquiry.authorizationserver.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.balanceenquiry.authorizationserver.entity.AuthRequest;
import com.balanceenquiry.authorizationserver.entity.UserInfo;
import com.balanceenquiry.authorizationserver.service.AuthService;
import com.balanceenquiry.authorizationserver.service.JWTService;
import com.balanceenquiry.authorizationserver.service.UserInfoService;

import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping("/auth")
public class UserController {
	
	@Autowired
	AuthService authService;
	
	@Autowired
	UserInfoService userInfoService;
	
	@Autowired
	JWTService jwtService;
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	@PostMapping("/register")
	public String addUser(@RequestBody UserInfo  userInfo) {
		return userInfoService.addUser(userInfo);
	}

	
	@PostMapping("/login")
	public String login(@RequestBody AuthRequest  authRequest) {
		Authentication authenticate= authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
		
		if(authenticate.isAuthenticated()) {
			return	jwtService.generateToken(authRequest.getUsername());
		}else {
				throw new UsernameNotFoundException("Invalid user request");
		}
	
	}
	@GetMapping("/token")
	public String getToken(UserInfo  userInfo) {
		return authService.generateToken(userInfo.getUsername());
	}
	
	@GetMapping("/validateToken")
	public String validateToken(@RequestParam("token") String  token) {
		// authService.validateToken(token);
		//jwtService.validateToken(token, UserDetails)
		 return "Token is valid";
	}
	
	@GetMapping("/getusers")
	public List<UserInfo> getAllUsers() {
		// authService.validateToken(token);
		 return userInfoService.getAllUser();
	}
	

	@GetMapping("/getuser")
	public UserInfo getUser(@PathVariable Integer id) {
		 return userInfoService.getUser(id);
	}
}
