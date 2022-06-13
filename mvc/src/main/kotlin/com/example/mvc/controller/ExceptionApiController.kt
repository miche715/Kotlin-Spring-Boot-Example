package com.example.mvc.controller

import com.example.mvc.model.Error
import com.example.mvc.model.ExceptionResponse
import com.example.mvc.model.UserRequest
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.FieldError
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.*
import java.time.LocalDateTime
import javax.servlet.http.HttpServletRequest
import javax.validation.ConstraintViolationException
import javax.validation.Valid
import javax.validation.constraints.Min
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size

@RestController
@RequestMapping("/api")
@Validated
class ExceptionApiController
{
    @GetMapping("/hello-exception")
    fun hello()
    {
        val list = mutableListOf<String>()
        val temp = list[0]
    }

    @GetMapping("/exception-get")
    fun get(
        @NotBlank
        @Size(min = 2, max = 6)
        @RequestParam name: String,

        @Min(10)
        @RequestParam age: Int): String
    {
        println(name)
        println(age)

        return name + " " + age
    }

    @PostMapping("/exception-post")
    fun post(@Valid @RequestBody ur: UserRequest): UserRequest
    {
        println(ur)

        return ur
    }

    @ExceptionHandler(value =[ConstraintViolationException::class])
    fun constraintViolationException(e: ConstraintViolationException, request: HttpServletRequest): ResponseEntity<ExceptionResponse>
    {
        val errors = mutableListOf<Error>()

        for(ex in e.constraintViolations)
        {
            val error = Error().apply()
            {
                this.field = ex.propertyPath.last().name
                this.message = ex.message
                this.value = ex.invalidValue
            }

            errors.add(error)
        }

        val errorResponse = ExceptionResponse().apply()
        {
            this.resultCode = "Error"
            this.httpStatus = HttpStatus.BAD_REQUEST.value().toString()
            this.httpMethod = request.method
            this.message = "예외남"
            this.path = request.requestURI.toString()
            this.timeStamp = LocalDateTime.now()
            this.errors = errors
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse)
    }

    @ExceptionHandler(value = [MethodArgumentNotValidException::class])
    fun methodArgumentNotValidException(e: MethodArgumentNotValidException, request: HttpServletRequest): ResponseEntity<ExceptionResponse>
    {
        val errors = mutableListOf<Error>()

        for(ex in e.bindingResult.allErrors)
        {
            val error = Error().apply()
            {
                this.field = (ex as FieldError).field
                this.message = ex.defaultMessage
                this.value = ex.rejectedValue
            }

            errors.add(error)
        }

        val errorResponse = ExceptionResponse().apply()
        {
            this.resultCode = "Error"
            this.httpStatus = HttpStatus.BAD_REQUEST.value().toString()
            this.httpMethod = request.method
            this.message = "예외남"
            this.path = request.requestURI.toString()
            this.timeStamp = LocalDateTime.now()
            this.errors = errors
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse)
    }

    @ExceptionHandler(value = [IndexOutOfBoundsException::class])
    fun indexOutOfBoundException(e: IndexOutOfBoundsException): ResponseEntity<String>
    {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("IndexOutOfBounds Error!!!!!!!!!!!")
    }
}