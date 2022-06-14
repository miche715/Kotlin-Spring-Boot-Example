package com.example.todolist.model

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.validation.FieldError
import javax.validation.Validation

class ToDoDtoTest
{
    val validator = Validation.buildDefaultValidatorFactory().validator

    @Test
    fun todoDtoTest()
    {
       val todoDto = ToDoDto().apply()
       {
           this.title = "test"
           this.schedule = "2022-11-11 11:11:11"
           this.description = "test"
       }

        val result = validator.validate(todoDto)

        for(r in result)
        {
            println(r.toString())
        }

        Assertions.assertEquals(true, result.isEmpty())
    }



}