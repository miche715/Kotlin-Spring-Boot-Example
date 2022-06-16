package com.example.member.repository

import com.example.member.service.ContentService
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.annotation.Commit
import javax.transaction.Transactional

@SpringBootTest
@Transactional
class ContentServiceTest
{
    @Autowired lateinit var contentService: ContentService
    @Autowired lateinit var contentRepository: ContentRepository

    @Test
    @Commit
    fun save()
    {
        contentService.save()

    }
}