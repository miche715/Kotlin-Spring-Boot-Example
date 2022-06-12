package com.example.mvc.controller

import com.example.mvc.model.UserRequest
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class PostApiController
{
//    @RequestMapping(method = [RequestMethod.POST], path = ["/request-mapping"])  // 옛날 방식
//    fun requestMapping(): String
//    {
//        return "request-mapping-post"
//    }

    @PostMapping("/post-mapping")
    fun postMapping(): String
    {
        return "post-maaping"
    }

    @PostMapping("/post-mapping/object")
    fun postMappingObject(@RequestBody ur: UserRequest): UserRequest
    {
        // 들어올땐 json -> object
        println(ur)

        // 리턴할땐 object -> json
        return ur
    }
}