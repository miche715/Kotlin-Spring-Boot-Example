package com.example.member.repository

import com.example.member.domain.Content

interface ContentRepository
{
    fun save(content: Content)

    fun findById(id: Long): Content?

    fun findByTitle(title: String): Content?

    fun findAll(): MutableList<Content>
}