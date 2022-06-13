package com.example.mvc.controller

import com.example.mvc.model.UserRequest
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ResponseBody

@Controller
class PageController
{
    @GetMapping("/main")
    fun main(): String
    {
        println("main")

        return "main.html"
    }

    @ResponseBody
    @GetMapping("/test")
    fun response(): UserRequest
    {
        return UserRequest().apply()
        {
            this.name = "dfafda"
        }
    }
}