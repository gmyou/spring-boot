package com.example.member;

import java.util.HashMap;
import java.util.Map;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.member.domain.Member;
import com.example.member.repository.MemberRepository;

@RestController
public class RestApiController {
    public static final Logger logger = LoggerFactory.getLogger(RestApiController.class);

	@Autowired
	MemberRepository memberRepository;
	
	@RequestMapping(value = "/member/", method = RequestMethod.POST)

    public Map<String, Object> createUser(@RequestBody Map<String, Object> json) {
		logger.info("Creating Member : {}", json);
 
		Member member = new Member();
		member.setUsername(json.get("username").toString());
		member.setAccount(json.get("account").toString());
		member.setPassword(json.get("password").toString());
		
		logger.info("Mapped Member : {}", member);

		Map<String, Object> result = new HashMap<String, Object>();

		try {
			memberRepository.save(member);
			
			result.put("result", "succ");
			result.put("message", "-");
		} catch(Exception e) {
			result.put("result", "fail");
			result.put("message", e.getMessage());
		}
		
		return result;
    }
	
}