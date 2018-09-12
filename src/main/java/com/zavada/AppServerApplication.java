package com.zavada;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.zavada.entity.UserEntity;
import com.zavada.entity.enums.UserRole;
import com.zavada.repository.UserRepository;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.zavada.repository")
public class AppServerApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(AppServerApplication.class, args);
	}
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public void run(String... args) throws Exception {
		if(userRepository.count()==0) {
			UserEntity userEntity = new UserEntity();
			userEntity.setUsername("admin");
			userEntity.setFirstName("Admin");
			userEntity.setLastName("admin");
			userEntity.setRole(UserRole.ROLE_ADMIN);
			userEntity.setPassword(passwordEncoder.encode("admin"));
			
			userRepository.save(userEntity);
		}
		
	}
}
