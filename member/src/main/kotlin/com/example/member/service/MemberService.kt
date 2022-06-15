package com.example.member.service

import com.example.member.doamin.Member
import com.example.member.repository.MemoryMemberRepository

class MemberService
{
    private var memberRepository = MemoryMemberRepository()

    fun join(member: Member): Long
    {
        return when(memberRepository.findByName(member.name!!))
        {
            null -> {
                with(memberRepository.save(member))
                {
                    this.id!!
                }
            }
            else -> 0  // throw IllegalStateException("이미 존재하는 이름입니다.")
        }
    }

    fun findMembers(): MutableList<Member>
    {
        return memberRepository.findAll()
    }

    fun findOne(id: Long): Member
    {
        return memberRepository.findById(id)!!
    }

}