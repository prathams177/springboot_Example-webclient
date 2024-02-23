package com.example.consumeanyplaceapis;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class Body {
	
	private String pois_from;
	private String pois_to;

}
