package com.example.member.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.member.domain.Member;

public interface MemberRepository extends JpaRepository<Member, Long>{

}
