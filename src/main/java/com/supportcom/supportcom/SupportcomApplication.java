package com.supportcom.supportcom;

import com.supportcom.supportcom.entities.CustomUser;
import com.supportcom.supportcom.entities.CustomRole;
import com.supportcom.supportcom.services.AccountService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class SupportcomApplication {

	public static void main(String[] args) {
		SpringApplication.run(SupportcomApplication.class, args);
	}
	@Bean
	PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}
	@Bean
	CommandLineRunner start(AccountService accountService){
		return args -> {
			accountService.addNewRole(new CustomRole(null,"USER"));
			accountService.addNewRole(new CustomRole(null,"ADMIN"));
			accountService.addNewRole(new CustomRole(null,"MANAGER"));

			accountService.addNewUser(new CustomUser(null,"yassir","123",new ArrayList<>()));
			accountService.addNewUser(new CustomUser(null,"yassir2","123",new ArrayList<>()));
			accountService.addNewUser(new CustomUser(null,"yassir3","123",new ArrayList<>()));
			accountService.addNewUser(new CustomUser(null,"admin","123",new ArrayList<>()));

			accountService.addRoleToUser("admin","ADMIN");
			accountService.addRoleToUser("yassir","MANAGER");
			accountService.addRoleToUser("yassir2","USER");
			accountService.addRoleToUser("yassir3","USER");

		};
	}

}

