package com.example.member

import com.example.member.repository.ContentRepository
import com.example.member.repository.MemberRepository
import com.example.member.service.ContentService
import com.example.member.service.MemberService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class Config(@Autowired private var memberRepository: MemberRepository, @Autowired private var contentRepository: ContentRepository)
{
    @Bean
    fun memberService(): MemberService
    {
        return MemberService(memberRepository)
    }

    @Bean
    fun contentService(): ContentService
    {
        return ContentService(contentRepository)
    }

//    @Bean
//    fun memberRepository(): MemberRepository
//    {
//        return JPAMemberRepository(em)
//    }
}