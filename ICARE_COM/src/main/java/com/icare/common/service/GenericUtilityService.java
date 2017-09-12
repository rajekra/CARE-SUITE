package com.icare.common.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class GenericUtilityService {

	@Autowired
	private ObjectMapper objectMapper;
	
	
}
