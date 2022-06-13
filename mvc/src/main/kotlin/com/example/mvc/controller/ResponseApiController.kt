package com.example.mvc.controller

import com.example.mvc.model.UserRequest
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/response")
class ResponseApiController
{
    @GetMapping("")  // GET http://localhost:8080/api/response?age=25
    fun getMapping(@RequestParam age: Int?): ResponseEntity<String>
    {
        return age?.let()
        {
            if(it < 20)
            {
                return ResponseEntity.status(400).body("age가 20보다 작으면 안됨.")
            }
            ResponseEntity.ok("OK")
        }?:
        kotlin.run()
        {
            return ResponseEntity.status(400).body("age가 null이면 안됨.")
        }

//        if(age == null)
//        {
//            return ResponseEntity.status(400).body("age가 null이면 안됨.")
//        }
//
//        if(age < 20)
//        {
//            return ResponseEntity.status(400).body("age가 20보다 작으면 안됨.")
//        }
//
//        return ResponseEntity.ok("OK")

    }

    @PostMapping("")
    fun postMapping(@RequestBody ur: UserRequest?): ResponseEntity<Any>
    {
        return ResponseEntity.status(200).body(ur)
    }

    @PutMapping("")
    fun putMappin(@RequestBody ur: UserRequest?): ResponseEntity<UserRequest>
    {
        return ResponseEntity.status(HttpStatus.CREATED).body(ur)
    }

    @DeleteMapping("")
    fun deleteMappin(@RequestParam id: Int): ResponseEntity<Any>
    {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null)
    }
}