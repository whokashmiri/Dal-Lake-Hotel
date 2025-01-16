package com.Coder;

import com.Coder.Model.ApplicationUser;
import com.Coder.Model.Role;
import com.Coder.Repository.RoleRepository;
import com.Coder.Repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class LoginFormApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoginFormApplication.class, args);
	}
	@Bean
	CommandLineRunner commandLineRunner(
			RoleRepository roleRepository,
			UserRepository userRepository,
			PasswordEncoder passwordEncoder
	){
		return args -> {
			if(roleRepository.findByAuthority("ADMIN").isPresent())
				return;
			Role adminRole = roleRepository.save(new Role("ADMIN"));
			roleRepository.save(new Role("USER"));
			Set<Role> roles = new HashSet<>();
			ApplicationUser admin = new ApplicationUser(
					1, "admin" ,
					passwordEncoder.encode("password"),roles);
			userRepository.save(admin);
		};
	}

}
