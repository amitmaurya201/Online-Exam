package com.adjecti.oexam.service.Impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adjecti.oexam.entity.User;
import com.adjecti.oexam.modal.UserDTO;
import com.adjecti.oexam.repository.UserRepository;
import com.adjecti.oexam.service.UserService;


@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository; 
	
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public UserDTO findByUserId(String username) {
		User user = userRepository.findByUserId(username);
		UserDTO user1 = modelMapper.map(user, UserDTO.class);
		return user1;
	}

	

	@Override
	public List<UserDTO> getUserList() {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	
	
	
}
