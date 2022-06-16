package com.example.member.repository

import com.example.member.domain.Member
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit.jupiter.SpringExtension

@ExtendWith(SpringExtension::class)
@SpringBootTest(classes = [MemoryMemberRepository::class])
class MemoryMemberRepositoryTest
{
    @Autowired
    lateinit var repository: MemoryMemberRepository

    @BeforeEach
    fun init()
    {
        repository = MemoryMemberRepository()
    }

    @Test
    fun save()
    {
        val member = Member(name = "fdsfs")

        with(repository.save(member))
        {
            Assertions.assertEquals(1, this.id)
            Assertions.assertEquals("fdsfs", this.name)
        }
    }

    @Test
    fun findByName()
    {
        val member1 = Member().apply { this.name = "111" }.also { repository.save(it) }
        val member2 = Member().apply { this.name = "222" }.also { repository.save(it) }

        val result = repository.findByName("111")
        Assertions.assertEquals(member1.name, result?.name)
    }

    @Test
    fun findAll()
    {
        val member1 = Member().apply { this.name = "111" }.also { repository.save(it) }
        val member2 = Member().apply { this.name = "222" }.also { repository.save(it) }

        val result = repository.findAll()

        Assertions.assertEquals(2, result.size)
    }
}