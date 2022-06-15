package com.example.member.controller

import com.example.member.doamin.Member
import com.example.member.repository.MemoryMemberRepository
import com.example.member.service.MemberService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping

@Controller
class MemberController
{
    @Autowired
    private val memberService = MemberService(MemoryMemberRepository())

    @GetMapping("/members/new")
    fun creatForm(): String
    {
        return "create-member-form"
    }

    @PostMapping("/members/new")
    fun create(name: String): String
    {
        Member().apply()
        {
            this.name = name
        }.also()
        {
            memberService.join(it)
        }

        return "redirect:/"
    }

    @GetMapping("/members")
    fun memberList(model: Model): String
    {
        val members = memberService.findMembers()

        model.addAttribute("members", members)

        return "member-list"
    }

}