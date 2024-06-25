package com.balanceenquiry.authorizationserver.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.balanceenquiry.authorizationserver.entity.UserInfo;
import com.balanceenquiry.authorizationserver.entity.UserInfoDetails;
import com.balanceenquiry.authorizationserver.repository.UserInfoRepository;

@Service
public class UserInfoService implements UserDetailsService{
	
	    @Autowired
	    private UserInfoRepository userInfoRepository;
	    
	    @Autowired
	    private PasswordEncoder passwordEncoder;
	    
	    
	    @Override
	    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	        Optional<UserInfo> userInfo = userInfoRepository.findByUsername(username);
	        return userInfo.map(UserInfoDetails::new)
	                .orElseThrow(()-> new UsernameNotFoundException("User not found"+username));
	    }
	    
	    public String addUser(UserInfo userInfo){
	        userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword()));
	        userInfoRepository.save(userInfo);
	        return "User added successfully";
	    }
	    
	    public List<UserInfo> getAllUser(){
	         return userInfoRepository.findAll();
	    }
	    
	    public UserInfo getUser(Integer id){
	        return userInfoRepository.findById(id).get();
	    }

}
