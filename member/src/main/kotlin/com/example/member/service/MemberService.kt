package com.example.member.service

import com.example.member.domain.Member
import com.example.member.repository.MemberRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.transaction.annotation.Transactional

@Transactional
class MemberService(@Autowired private var memberRepository: MemberRepository)
{
    fun join(member: Member): Long
    {
        return when(memberRepository.findByName(member.name!!))
        {
            null -> {
                with(memberRepository.save(member))
                {
                    this.id!!  // DB에 중복되는 이름이 없어 가입 허용.
                }
            }
            else -> 0  // DB에 중복되는 이름이 있으므로 가입 거절.
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