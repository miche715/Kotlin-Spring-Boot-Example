package com.example.member

import com.example.member.repository.JPAMemberRepository
import com.example.member.repository.MemberRepository
import com.example.member.repository.MemoryMemberRepository
import com.example.member.service.MemberService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import javax.persistence.EntityManager

@Configuration
class Config(@Autowired private var memberRepository: MemberRepository)
{
    @Bean
    fun memberService(): MemberService
    {
        return MemberService(memberRepository)
    }

//    @Bean
//    fun memberRepository(): MemberRepository
//    {
//        return JPAMemberRepository(em)
//    }
}