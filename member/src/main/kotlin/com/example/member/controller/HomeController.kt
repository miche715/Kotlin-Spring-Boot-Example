package com.example.member.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/member-application")
class HomeController
{
    @GetMapping("")
    fun home(): String
    {
        return "home"
    }
}