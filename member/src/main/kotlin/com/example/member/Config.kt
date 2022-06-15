package com.example.member

import com.example.member.repository.MemoryMemberRepository
import com.example.member.service.MemberService
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class Config
{
    @Bean
    fun memberService(): MemberService
    {
        return MemberService(memberRepository())
    }

    @Bean
    fun memberRepository(): MemoryMemberRepository
    {
        return MemoryMemberRepository()
    }
}