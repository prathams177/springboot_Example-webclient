package com.example.consumeanyplaceapis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class ConsumeanyplaceapisApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsumeanyplaceapisApplication.class, args);
	}
	
	@Bean
	public WebClient.Builder getWebClient(){
		return WebClient.builder();
	}

}
