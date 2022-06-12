package com.example.mvc.controller

import com.example.mvc.model.UserRequest
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController  // 해당 컨트롤러는 REST API 컨트롤러로 동작
@RequestMapping("/api")  // http://localhost:8080/api
class GetApiController
{
    //    @RequestMapping(method = [RequestMethod.GET], path = ["/request-mapping"])  // 옛날 방식
    //    fun requestMapping(): String
    //    {
    //        return "request-mapping-get"
    //    }

    @GetMapping("/hello")  // GET http://localhost:8080/api/hello
    fun hello(): String
    {
        return "hello kotlin"
    }

    // 파라미터를 변수 형태로 받기
    @GetMapping("/get-mapping/query-param")  // GET http://localhost:8080/api/get-mapping/query-param?name=cheel&age=25
    fun queryParam(@RequestParam(value = "name") name: String, @RequestParam age: Int): String
    {
        println("${name} ${age}")

        return name + " " + age
    }

    // 파라미터를 객체 형태로 받기
    @GetMapping("/get-mapping/query-param/object")  // GET http://localhost:8080/api/get-mapping/query-param/object?name=cheel&age=25&email=gmail&address=add
    fun queryParamObject(ur: UserRequest): UserRequest
    {
        println(ur)

        return ur
    }

    // 파라미터를 맵 형태로 받기
    @GetMapping("/get-mapping/query-param/map")  // GET http://localhost:8080/api/get-mapping/query-param/map?name=cheel&age=25&email=gmail&address=add
    fun queryParamMap(@RequestParam map: Map<String, Any>): Map<String, Any>
    {
        var name = map.get("name")
        println(map)
        println(name)

        return map
    }
}