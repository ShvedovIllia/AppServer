package com.zavada.service.impl;

import static com.zavada.constants.ErrorMessages.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.zavada.config.jwt.JWTTokenProvider;
import com.zavada.domain.UserDTO;
import com.zavada.entity.UserEntity;
import com.zavada.entity.enums.UserRole;
import com.zavada.exceptions.UserServiceException;
import com.zavada.repository.UserRepository;
import com.zavada.service.UserService;
import com.zavada.service.utils.ObjectMapperUtils;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private ObjectMapperUtils objectMapper;
	
	@Autowired
	private JWTTokenProvider jwtTokenProvider;
	
	@Autowired
	private AuthenticationManager authenticationManager;

	@Override
	public void save(UserDTO dto) {

		if (userRepository.existsByUsername(dto.getUsername())) {
			throw new UserServiceException(RECORD_ALREADY_EXISTS);
		} else {
			dto.setRole(UserRole.ROLE_USER);
			System.out.println("Password:" + dto.getPassword());
			dto.setPassword(passwordEncoder.encode(dto.getPassword()));
			System.out.println("Password2:" + dto.getPassword());
			
			UserEntity userEntity = objectMapper.map(dto, UserEntity.class);
			userRepository.save(userEntity);
		}
	}

	@Override
	public String signin(String username, String password) {
		System.out.println(">>> " + username);
		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		System.out.println(">>> " + username);
		return jwtTokenProvider.createToken(username, userRepository.findByUsername(username).getRole());
	}
	
	@Override
	public UserDTO findById(Long id) {
		return null;
	}

	@Override
	public List<UserDTO> findAll() {
		return null;
	}

	@Override
	public boolean existsByUsername(String username) {
		return false;
	}

	@Override
	public UserDTO findByUsername(String username) {
		return objectMapper.map(userRepository.findByUsername(username), UserDTO.class);
	}

}
