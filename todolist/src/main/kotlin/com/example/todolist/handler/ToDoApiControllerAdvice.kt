package com.example.todolist.handler

import com.example.todolist.model.Error
import com.example.todolist.controller.ToDoApiController
import com.example.todolist.model.ErrorResponse
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.FieldError
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import java.time.LocalDateTime
import javax.servlet.http.HttpServletRequest

@ControllerAdvice(basePackageClasses = [ToDoApiController::class])
class ToDoApiControllerAdvice
{
    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun methodArgumentNotValidException(e: MethodArgumentNotValidException, request: HttpServletRequest): ResponseEntity<ErrorResponse>
    {
        val errors = mutableListOf<Error>()

        e.bindingResult.allErrors.forEach()
        {
            Error().apply()
            {
                this.field = (it as FieldError).field
                this.message = it.defaultMessage
                this.value = it.rejectedValue
            }.apply()
            {
                errors.add(this)
            }
        }

        val errorResponse = ErrorResponse().apply()
        {
            this.resultCode = "FAIL"
            this.httpStatus = HttpStatus.BAD_REQUEST.value().toString()
            this.httpMethod = request.method
            this.message = ""
            this.path = request.requestURI
            this.timeStamp = LocalDateTime.now()
            this.error = errors
        }

        return ResponseEntity.badRequest().body(errorResponse)
    }
}