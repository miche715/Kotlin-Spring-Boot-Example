package com.example.member.repository

import com.example.member.doamin.Member
import javax.persistence.EntityManager

class JPAMemberRepository(private var em: EntityManager) : MemberRepository
{
    override fun save(member: Member): Member
    {
        em.persist(member)

        return member
    }

    override fun findById(id: Long): Member?
    {
        return em.find(Member::class.java, id)
    }

    override fun findByName(name: String): Member?
    {
        val result = em.createQuery("select m from Member m where m.name = :name", Member::class.java).setParameter("name", name).resultList

        if(result.size > 0)
        {
            return result[0]
        }
        else
        {
            return null
        }
    }

    override fun findAll(): MutableList<Member>
    {
        return em.createQuery("select m from Member m", Member::class.java).resultList
    }
}