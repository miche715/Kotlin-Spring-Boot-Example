package com.example.example.controller

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam

@Controller
class HelloController
{
    @GetMapping("/hello")
    fun hello(model: Model): String
    {
        model.addAttribute("data", "hello!@!@!@")

        return "hello"
    }

    @GetMapping("/hello-mvc")
    fun helloMVC(@RequestParam name: String, model: Model): String
    {
        model.addAttribute("name", name)

        return "hello-template"
    }
}

/*
@RestController는 return "hello"하면 문자열 hello를 반환하고,
@Controller는 return "hello"하면 hello.html을 찾아서 반환하는 듯 하다.
*/