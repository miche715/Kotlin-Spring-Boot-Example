package com.example.member.repository

import com.example.member.doamin.Member
import com.example.member.service.MemberService
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit.jupiter.SpringExtension


@ExtendWith(SpringExtension::class)
@SpringBootTest(classes = [MemberService::class, MemoryMemberRepository::class])
class MemberServiceTest
{
    @Autowired
    lateinit var service: MemberService

    @BeforeEach
    fun init()
    {
        service = MemberService(MemoryMemberRepository())
    }

    @Test
    fun join()
    {
        val result1 = service.join(Member(name = "첫멤버"))
        val result2 = service.join(Member(name = "첫멤버"))

        Assertions.assertEquals(1, result1)
        Assertions.assertEquals(0, result2)
    }



}