package com.example.member;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.member.repository.MemberRepository;

@RestController
public class RestApiController {
    public static final Logger logger = LoggerFactory.getLogger(RestApiController.class);

	@Autowired
	MemberRepository memberRepository;
	
	@RequestMapping(value = "/member/", method = RequestMethod.POST)
    public ResponseEntity<?> createUser(@RequestBody Map<String, Object> json) {
		logger.info("Creating Member : {}", json);
 
		return new ResponseEntity<String>(json.toString(), HttpStatus.CREATED);
    }
	
}
