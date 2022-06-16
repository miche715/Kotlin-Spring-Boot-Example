package com.example.member.repository

import com.example.member.doamin.Member
import org.springframework.data.jpa.repository.JpaRepository

interface SpringDataJPAMemberRepository : JpaRepository<Member, Long>, MemberRepository
{
    override fun findByName(name: String): Member?  // select m from Member m where m.name = ?
}