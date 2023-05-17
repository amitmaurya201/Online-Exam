package com.adjecti.oexam.service;

import java.util.List;

import com.adjecti.oexam.modal.UserDTO;

public interface UserService {
	public UserDTO findByUserId(String id);
    public List<UserDTO> getUserList();
   
}
