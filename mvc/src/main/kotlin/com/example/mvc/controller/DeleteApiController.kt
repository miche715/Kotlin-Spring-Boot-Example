package com.example.mvc.controller

import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import javax.validation.constraints.Min
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

@Validated
@RestController
@RequestMapping("/api")
class DeleteApiController
{
    @DeleteMapping("/detete-mapping")
    fun deleteMapping(
            @NotNull(message = "null이면 안됩니다.")
            @Size(min = 2, max = 5, message = "범위가 맞지 않습니다.")
            @RequestParam name: String,

            @NotNull(message = "null이면 안됩니다.")
            @Min(value = 20, message = "20보다 커야합니다.")
            @RequestParam age: Int
        ): String
    {
        println(name)
        println(age)

        return name + " " + age
    }
}