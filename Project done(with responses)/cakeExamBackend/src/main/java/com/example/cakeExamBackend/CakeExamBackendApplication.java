package com.example.cakeExamBackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.web.firewall.HttpFirewall;
import org.springframework.security.web.firewall.StrictHttpFirewall;

@SpringBootApplication
public class CakeExamBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(CakeExamBackendApplication.class, args);
	}
}
