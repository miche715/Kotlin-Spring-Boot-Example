package com.example.example.controller

import com.example.example.model.Hello
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("")
class HelloAPIController
{
    @GetMapping("/hello-api")
    fun helloAPI(@RequestParam name: String): Hello
    {
        return Hello().apply()
        {
            this.name = name
        }
    }
}