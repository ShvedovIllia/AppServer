package com.zavada.service;

import java.util.List;

import com.zavada.domain.UserDTO;

public interface UserService {

	void save(UserDTO dto);
	
	UserDTO findById(Long id);
	
	List<UserDTO> findAll();
	
	boolean existsByUsername(String username);
	
	UserDTO findByUsername(String username);
	
	String signin(String username, String password);
	
}
