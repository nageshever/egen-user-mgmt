package com.egen.egenusermgmt;

import com.egen.egenusermgmt.entity.User;
import com.egen.egenusermgmt.repos.UserRespository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EgenUserMgmtApplication {

	public static void main(String[] args) {
		SpringApplication.run(EgenUserMgmtApplication.class, args);
	}

	/*@Bean
	CommandLineRunner init (UserRespository userRespository) {
		return args -> {
			userRespository.save(new User("Nagesh","Lakinepally", (short)12, "M", "9196388454"));
		};
	} */
}
