package com.example.consumeanyplaceapis.controller;

import java.awt.PageAttributes.MediaType;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.example.consumeanyplaceapis.Body;

import reactor.core.publisher.Mono;

@RestController
public class AnyplaceController {
	
	@Autowired
	WebClient.Builder client;
	 private static final Logger logger = LoggerFactory.getLogger(AnyplaceController.class);
	
	@PostMapping("/loginUser")
	public String getPoisData(@RequestBody Body params) {
		
		String baseurl = "https://ap.cs.ucy.ac.cy:44/api/navigation/route";
		
	String response = 	WebClient.create(baseurl).post()
		.accept(org.springframework.http.MediaType.APPLICATION_JSON).contentType(org.springframework.http.MediaType.APPLICATION_JSON)
		.body(Mono.just(params), Body.class)
		.retrieve()
		.bodyToMono(String.class).block();
	 try {
    ObjectMapper objectMapper = new ObjectMapper();
    objectMapper.writeValue(new File("jsonfiles/response.json"), response);

    return response;
    
} catch (IOException e) {
    e.printStackTrace();
    return "Failed to store JSON response.";
}

	}
	

	
	
	

	
	

}
