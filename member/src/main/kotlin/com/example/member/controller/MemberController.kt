package com.example.member.controller

import com.example.member.domain.Member
import com.example.member.service.MemberService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/member-application")
class MemberController(@Autowired private val memberService: MemberService)
{
    @GetMapping("/members/join")
    fun creatForm(): String
    {
        return "member-join"
    }

    @PostMapping("/members/join")
    fun create(name: String): String
    {
        Member().apply()
        {
            this.name = name
        }.run()
        {
            memberService.join(this)
        }

        return "redirect:/member-application"
    }

    @GetMapping("/members/list")
    fun memberList(model: Model): String
    {
        val members = memberService.findMembers()

        model.addAttribute("members", members)

        return "member-list"
    }
}