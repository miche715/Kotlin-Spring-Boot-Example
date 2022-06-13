package com.example.mvc.controller

import com.example.mvc.model.Result
import com.example.mvc.model.UserRequest
import com.example.mvc.model.UserResponse
import org.springframework.http.ResponseEntity
import org.springframework.validation.BindingResult
import org.springframework.validation.FieldError
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
@RequestMapping("/api")
class PutApiController
{
//    @RequestMapping(method = [RequestMethod.PUT], path = ["/request-mapping"])  // 옛날 방식
//    fun requestMapping(): String
//    {
//        return "request-mapping-put"
//    }

    @PutMapping("/put-mapping")
    fun putMapping(): String
    {
        return "put-mapping"
    }

    @PutMapping("/put-mapping/object")
    fun putMappingObject(@Valid @RequestBody ur: UserRequest, br: BindingResult): Any
    {
        val msg = StringBuilder()
        if(br.hasErrors())
        {
            for(e in br.allErrors)
            {
                val field = e as FieldError
                val message = e.defaultMessage
                msg.append(field.field + ": " + message + "\n")
            }

            return ResponseEntity.badRequest().body(msg.toString())
        }

        return UserResponse().apply()
        {
            this.result = Result().apply()
            {
                this.resultCode = "OK"
                this.resultMessage = "성공"
            }
        }.apply()
        {
            this.description = "fadasdsada"
        }.apply()
        {
            val userList = mutableListOf<UserRequest>()

            userList.add(ur)
            userList.add(UserRequest().apply()
            {
                this.name = "aaa"
                this.age = 123
                this.email = "mailmail"
                this.address = "tytyrt"
                this.phoneNumber = "0101010"
            })
            userList.add(UserRequest().apply()
            {
                this.name = "b"
                this.age = 12323
                this.email = "mailhhh"
                this.address = "lkgjh"
                this.phoneNumber = "0670"
            })

            this.user = userList
        }
    }
}