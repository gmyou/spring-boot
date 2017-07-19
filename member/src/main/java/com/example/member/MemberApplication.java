package com.example.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.member.domain.Member;
import com.example.member.repository.MemberRepository;

@SpringBootApplication
public class MemberApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(MemberApplication.class, args);
	}

	@Autowired
	MemberRepository memberRepository;
	
	@Override
	public void run(String... arg0) throws Exception {
		List<Member> members = memberRepository.findAll();
		for(Member m: members) { 
			System.out.print(m.getUsername()); 
			System.out.print("\t"); 
			System.out.println(m.getAccount()); 
		}
		System.out.println("--------------------------");
	}
}
