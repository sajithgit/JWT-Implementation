package com.internal.jwtapi;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
public class JwtApplication {


	public static void main(String[] args) {

		Logger logger = LoggerFactory.getLogger(JwtApplication.class.getName());
		SpringApplication.run(JwtApplication.class, args);
		logger.info("JWT BOOT CAMP");
	}

}
