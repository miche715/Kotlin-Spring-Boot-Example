package com.example.member.repository

import com.example.member.doamin.Member
import java.util.Optional

interface MemberRepository
{
    fun save(member: Member): Member

    fun findById(id: Long): Member?

    fun findByName(name: String): Member?

    fun findAll(): MutableList<Member>
}