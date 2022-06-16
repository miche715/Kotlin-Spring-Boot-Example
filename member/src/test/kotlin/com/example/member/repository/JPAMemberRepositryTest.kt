package com.example.member.repository

import com.example.member.domain.Member
import com.example.member.service.MemberService
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import javax.transaction.Transactional

@SpringBootTest
@Transactional
class JPAMemberRepositryTest
{
    @Autowired lateinit var memberService: MemberService
    @Autowired lateinit var memberRepository: MemberRepository

    @Test
    fun join()
    {
        val member1 = Member(name = "test3")
        val saveId1 = memberService.join(member1)
        val findMember1 = memberService.findOne(saveId1)

        Assertions.assertEquals(member1.name, findMember1.name)

        val member2 = Member(name = "test3")
        val saveId2 = memberService.join(member2)

        Assertions.assertEquals(saveId2, 0)
    }

}