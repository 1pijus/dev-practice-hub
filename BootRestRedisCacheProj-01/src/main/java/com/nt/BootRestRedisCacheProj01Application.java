package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class BootRestRedisCacheProj01Application {

	public static void main(String[] args) {
		SpringApplication.run(BootRestRedisCacheProj01Application.class, args);
	}

}
