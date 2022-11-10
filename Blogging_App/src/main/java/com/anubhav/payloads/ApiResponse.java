package com.anubhav.payloads;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
@Service
@AllArgsConstructor
public class ApiResponse {

	private String message;
	private boolean success;
}
