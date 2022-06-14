package com.example.todolist.model

import com.example.todolist.database.ToDo
import com.fasterxml.jackson.databind.PropertyNamingStrategies
import com.fasterxml.jackson.databind.annotation.JsonNaming
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import javax.validation.constraints.AssertTrue
import javax.validation.constraints.NotBlank

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy::class)
data class ToDoDto(
    var index: Int? = null,

    @field:NotBlank
    var title: String? = null,

    var description: String? = null,

    @field:NotBlank
    var schedule: String? = null,

    var createdAt: LocalDateTime? = null,

    var updatedAt: LocalDateTime? = null
)
{
    @AssertTrue(message = "yyyy-MM-dd HH:mm:ss 포맷이 아닙니다.")
    fun isValidSchedule(): Boolean
    {
        return try
        {
            LocalDateTime.parse(schedule, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
            true
        }
        catch(e: Exception)
        {
            false
        }
    }
}

fun ToDoDto.convertToDoDto(todo: ToDo): ToDoDto
{
    return ToDoDto().apply()
    {
        this.index = todo.index
        this.title = todo.title
        this.description = todo.description
        this.schedule = todo.schedule!!.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
        this.createdAt = todo.createdAt
        this.updatedAt = todo.updatedAt
    }
}