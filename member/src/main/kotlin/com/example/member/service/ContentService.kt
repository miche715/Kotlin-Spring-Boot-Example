package com.example.member.service

import com.example.member.domain.Content
import com.example.member.repository.ContentRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.transaction.annotation.Transactional
import java.time.LocalDateTime

@Transactional
class ContentService(@Autowired private var contentRepository: ContentRepository)
{
    fun save()
    {
        contentRepository.save(Content(userName = "aaa", title = "bbb", text = "ccc", createdAt = LocalDateTime.now()))

    }
}