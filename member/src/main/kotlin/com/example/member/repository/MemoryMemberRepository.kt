package com.example.member.repository

import com.example.member.domain.Member

class MemoryMemberRepository(private val store: MutableMap<Long, Member> = mutableMapOf(), private var sequence: Long = 0L) : MemberRepository
{
    override fun save(member: Member): Member
    {
        return Member().apply()
        {
            this.name = member.name
            this.id = ++sequence
        }.also()
        {
            store.put(it.id!!, it)
        }
    }

    override fun findById(id: Long): Member?
    {
        return store.get(id)
    }

    override fun findByName(name: String): Member?
    {
        return store.filterValues()
        {
            it.name == name
        }.firstNotNullOfOrNull()
        {
            it.value
        }
    }

    override fun findAll(): MutableList<Member>
    {
        return store.values.toMutableList()
    }
}