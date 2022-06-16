package com.example.member.repository

import com.example.member.domain.Content
import org.springframework.data.jpa.repository.JpaRepository

interface SpringDataJPAContentRepository : JpaRepository<Content, Long>, ContentRepository
{
    override fun findByTitle(title: String): Content?
}